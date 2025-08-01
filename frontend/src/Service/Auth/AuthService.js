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
            const {token, user} = response.data;

            localStorage.setItem('token', token);
            localStorage.setItem('user', JSON.stringify(user));

            return response.data;
        } catch (error) {
            throw error.response?.data || error.message;
        }
    }
}