import "./Style.css";
import {Link} from "react-router-dom";

function SingUP() {

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
                    <form className="Sign-Up-Form">
                        <div className="Sign-Up-Form-Error"></div>
                        <div>
                            <label htmlFor="email" className="Sign-Up-Input">
                                이메일*
                            </label>
                            <input id="email" name="email" type="email" placeholder="이메일을 입력하세요" className="input-box"/>
                        </div>
                        <div>
                            <label className="Sign-Up-Input" >
                                이름*
                            </label>
                            <input id="name" name="name" type="text" placeholder="이름을 입력하세요" className="input-box"/>
                        </div>
                        <div>
                            <label className="Sign-Up-Input" >
                                비밀번호*
                            </label>
                            <input id="password" name="password" type="password" placeholder="비밀번호를 입력하세요" className="input-box"/>
                        </div>
                        <div>
                            <label className="Sign-Up-Input" >
                                비밀번호 확인*
                            </label>
                            <input id="comfirmPassword" name="comfirmPassword" type="password" placeholder="비밀번호를 입력하세요" className="input-box"/>
                        </div>
                        <div>
                            <label className="Sign-Up-Input" >
                                전화번호(선택)
                            </label>
                            <input id="phone" name="phone" type="tel" placeholder="전화번호를 입력하세요" className="input-box"/>
                        </div>
                        <div>
                            <label className="Sign-Up-Input" >
                                주소(선택)
                            </label>
                            <textarea id="address" name="address" placeholder="주소를 입력하세요" className="input-box"/>
                        </div>

                        <div>
                            <button className="button Sign-Up-Button">{'회원가입'}</button>
                        </div>
                        <div className="Sign-Up-Form-Link">
                            <p className="Sign-Up-Form-Link-Text">
                                이미 계정이 있으신가요?{''}
                                <Link to="/" className="Sign-Up-Form-Link-Text-Link">
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