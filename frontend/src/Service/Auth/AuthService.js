import Api from "../Api";

export const AuthService = {

    signUp: async (userData) => {
        try {
            const response = await Api.post('/auth/sign-up', userData);
            return response.data;
        } catch (error) {
            throw error.response?.data || error.message;
        }
    },

    login: async (email, password) => {

        try {
            const response = await Api.post('/auth/log-in', { email, password });
            const {token, code, message, expirationTime} = response.data;

            // JWT 토큰에서 사용자 정보 추출
            const userInfo = AuthService.decodeToken(token);
            
            localStorage.setItem('token', token);
            localStorage.setItem('user', JSON.stringify(userInfo));

            // 사용자 상태 변경 이벤트 발생
            window.dispatchEvent(new Event('userStateChanged'));

            return response.data;
        } catch (error) {
            throw error.response?.data || error.message;
        }
    },

    // JWT 토큰 디코딩
    decodeToken: (token) => {
        try {
            const base64Url = token.split('.')[1];
            const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
            const jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
                return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
            }).join(''));

            const payload = JSON.parse(jsonPayload);
            return {
                email: payload.sub,
                name: payload.sub.split('@')[0], // 이메일에서 이름 추출
                role: 'USER' // 기본 역할 설정
            };
        } catch (error) {
            console.error('토큰 디코딩 오류:', error);
            return null;
        }
    },

    // 현재 사용자 정보 가져오기
    getCurrentUser: () => {
        const userStr = localStorage.getItem('user');
        if (!userStr || userStr === 'undefined' || userStr === 'null') {
            return null;
        }
        try {
            return JSON.parse(userStr);
        } catch (error) {
            console.error('JSON 파싱 오류:', error);
            localStorage.removeItem('user');
            return null;
        }
    },

    // 토큰 확인
    getToken: () => {
        return localStorage.getItem('token');
    },

    // 로그인 상태 확인
    isAuthenticated: () => {
        return !!localStorage.getItem('token');
    },

    // 로그아웃
    logout: () => {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        // 사용자 상태 변경 이벤트 발생
        window.dispatchEvent(new Event('userStateChanged'));
    }
}