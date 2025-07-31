import Api from "../Api";

export const AuthService = {

    signUp: async (userData) => {
        try {
            const response = await Api.post('/auth/sign-up', userData);
            return response.data;
        } catch (error) {
            throw error.response?.data || error.message;
        }
    }
}