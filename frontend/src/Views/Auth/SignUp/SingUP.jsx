import "./Style.css";
import {Link, useNavigate} from "react-router-dom";
import {useState} from "react";
import {AuthService} from "../../../Service/Auth/AuthService.js";

function SingUP() {

    const [formData, setFormData] = useState({
        email: '',
        name: '',
        password: '',
        confirmPassword: '',
        phone: '',
        address: '',
    })
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState('');

    const navigate = useNavigate();

    const handleChange = (e) => {
        const {name, value} = e.target;
        setFormData(prev => ({
            ...prev,
            [name]: value,
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setLoading(true);
        setError('');

        if (formData.password !== formData.confirmPassword) {
            setError('비밀번호가 일치하지 않습니다.');
            setLoading(false);
            return;
        }

        try {
            await AuthService.signUp(formData);
            alert('회원가입이 완료되었습니다. 로그인해주세요.');
            navigate('/login');
        } catch (error) {
            setError(error.response?.data?.message || '회원가입에 실패했습니다.');
        } finally {
            setLoading(false);
        }
    };

    // render: 회원가입 페이지 렌더링 //
    return (
        <div className="Sign-Up-Page">
            <div className="Sign-Up-Title-Container">
                <div className="Sign-Up-Box">
                    <h2 className="Sign-Up-Title">회원가입</h2>
                    <p className="Sing-Up-Title-Detail">새로운 계정을 만들어 쇼핑을 시작하세요.</p>
                </div>
            </div>

            <div className="Sign-Up-Form-Container">
                <div className="card" style={{ padding: '2rem 1rem'}}>
                    <form className="Sign-Up-Form" onSubmit={handleSubmit}>

                        {error && (
                            <div className="Sign-Up-Form-Error">{error}</div>
                        )}

                        <div>
                            <label htmlFor="email" className="Sign-Up-Input">
                                이메일*
                            </label>
                            <input className="input-box" id="email" name="email" type="email" required
                                   value={formData.email} placeholder="이메일을 입력하세요" onChange={handleChange}/>
                        </div>
                        <div>
                            <label className="Sign-Up-Input" >
                                이름*
                            </label>
                            <input className="input-box" id="name" name="name" type="text" required
                                   value={formData.name} onChange={handleChange} placeholder="이름을 입력하세요"/>
                        </div>
                        <div>
                            <label className="Sign-Up-Input" >
                                비밀번호*
                            </label>
                            <input className="input-box" id="password" name="password" type="password"
                                   required value={formData.password} onChange={handleChange} placeholder="비밀번호를 입력하세요"/>
                        </div>
                        <div>
                            <label className="Sign-Up-Input" >
                                비밀번호 확인*
                            </label>
                            <input className="input-box" id="confirmPassword" name="confirmPassword" type="password"
                                   required value={formData.confirmPassword} onChange={handleChange} placeholder="비밀번호를 입력하세요" />
                        </div>
                        <div>
                            <label className="Sign-Up-Input" >
                                전화번호(선택)
                            </label>
                            <input className="input-box" id="phone" name="phone" type="tel"
                                   required value={formData.phone} onChange={handleChange} placeholder="전화번호를 입력하세요"/>
                        </div>
                        <div>
                            <label className="Sign-Up-Input" >
                                주소(선택)
                            </label>
                            <textarea className="input-box" id="address" name="address"
                                      required value={formData.address} onChange={handleChange} rows="3" placeholder="주소를 입력하세요"
                                      style={{resize: 'vertical'}}/>
                        </div>

                        <div>
                            <button className="button Sign-Up-Button" type="submit" disabled={loading}
                                    style={{ opacity: loading ? 0.5 : 1, cursor: loading ? 'not-allowed' : 'pointer'}}>
                                {loading ? '가입 중...' : '회원가입'}
                            </button>
                        </div>
                        <div className="Sign-Up-Form-Link">
                            <p className="Sign-Up-Form-Link-Text">
                                이미 계정이 있으신가요?{' '}
                                <Link to="/login" className="Sign-Up-Form-Link-Text-Link"
                                onMouseEnter={(e) => e.target.style.color = 'var(--green-light)'}
                                      onMouseLeave={(e) => e.target.style.color = 'var(--green)'}
                                >
                                    로그인
                                </Link>
                            </p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default SingUP;