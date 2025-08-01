import {Link, useLocation, useNavigate} from "react-router-dom";
import "./Style.css";
import {useState} from "react";
import {AuthService} from "../../../Service/Auth/AuthService.js";

//          component: Login 컴포넌트          //
function LogIn() {

    //          state: 로그인 정보          //
    const [formData, setFormData] = useState({
        email: '',
        password: '',
    })
    //          state: 로딩 상태          //
    const [loading, setLoading] = useState(false);
    //          state:에러 상태          //
    const[error, setError] = useState('');

    const navigate = useNavigate();
    const location = useLocation();
    const from = location.state?.from?.pathname || '/';

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData(prev => ({
            ...prev,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setLoading(true);
        setError('');

        try {
            await AuthService.login(formData.email, formData.password);
            // 사용자 상태 변경 이벤트 발생 (AuthService에서 이미 발생시키지만 확실히 하기 위해)
            window.dispatchEvent(new Event('userStateChanged'));
            navigate(from, { replace: true });
        } catch (error) {
            setError(error.response?.data?.message || '로그인에 실패했습니다.');
        } finally {
            setLoading(false);
        }
    };

    //          render: Login 렌더링          //
    return (
        <div className="Log-In-Page">
            <div className="Log-In-Title-Container">
                <div className="Log-In-Box">
                    <h2 className="Log-In-Title">
                        로그인
                    </h2>
                    <p className="Log-In-Title-Detail">
                        계정에 로그인하여 쇼핑몰을 시작하세요.
                    </p>
                </div>
            </div>

            <div className="Log-In-Form-Container">
                <div className="card" style={{ padding: '2rem 1rem'}}>
                    <form className="Log-In-Form" onSubmit={handleSubmit}>
                        {error && (
                            <div className="Log-In-Form-Error">
                                {error}
                            </div>
                        )}

                        <div>
                            <label htmlFor="email"  onChange={handleChange}>
                                이메일
                            </label>
                            <input className="input-box" id="email" name="email" type="email" required
                                   value={formData.email} onChange={handleChange} placeholder="이메일을 입력하세요"/>
                        </div>
                        <div>
                            <label htmlFor="password" className="Log-In-Input"></label>
                            <input className="input-box" id="password" name="password" type="password" required
                            value={formData.password} onChange={handleChange} placeholder="비밀번호를 입력하세요"/>
                        </div>

                        <div>
                            <button className="button Log-In-Button" type="submit" disabled={loading}>
                                {loading ? '로그인 중...' : '로그인'}
                            </button>
                        </div>

                        <div className="Log-In-Form-Link">
                            <p className="Log-In-Form-Link-Text">
                                아직 계정이 없으신가요?{' '}
                                <Link to="/signUp" className="Log-In-Form-Link-Text-Link">
                                    회원가입
                                </Link>
                            </p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    )
}

export default LogIn;