import {Link} from "react-router-dom";

function LogIn() {
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
                    <form className="Log-In-Form">
                        <div className="Log-In-Form-Error">

                        </div>

                        <div>
                            <label htmlFor="email" className="Log-In-Input">이메일</label>
                            <input className="input-box"/>
                        </div>
                        <div>
                            <label htmlFor="password" className="Log-In-Input"></label>
                            <input className="input-box"/>
                        </div>

                        <div>
                            <button className="button Log-In-Button">
                                {'로그인'}
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