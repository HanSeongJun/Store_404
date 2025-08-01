import {Link} from "react-router-dom";
import "./Style.css";
import logoImage from "../../Assets/logo.png";

function Header() {



    return (
        <header className="Header">
            <div className="Header-Container">
                {/* 로고 */}
                <Link to="/" className="Header-Logo">
                    <img src={logoImage} alt="404 Logo" className="Header-Logo-Image" />
                </Link>

                {/* 검색 창 */}
                <form className="Header-Search">
                    <div className="Header-Search-Container">
                        <input className="Header-Search-Input" />
                        <button className="Header-Search-Button">검색</button>
                    </div>
                </form>

                {/* 사용자 메뉴 */}
                <div className="Header-User-Menu">
                    <>
                        <Link to="/" className="Header-User-Menu-Link">
                            장바구니
                        </Link>
                        <Link to="/" className="Header-User-Menu-Link">
                            관리자
                        </Link>
                        <div className="Header-User-Menu-Member">
                            <button className="Header-User-Menu-Button">회원 이름
                                <span>▼</span>
                            </button>
                            <div className="Header-User-Menu-Member-Dropdown">
                                <div className="Header-User-Menu-Member-Dropdown-Info">
                                    <div className="Header-User-Menu-Member-Dropdown-Hello">안녕하세요,</div>
                                    <div className="Header-User-Menu-Member-Dropdown-Member">사용자 님.</div>
                                </div>
                                <button className="Header-User-Menu-Logout-Button">로그아웃</button>
                            </div>
                        </div>
                    </>

                    <div className="Header-User-Menu-Login">
                        <Link to="/login" className="Header-User-Menu-Login-Link">
                            로그인
                        </Link>
                        <Link to="/signUp" className="Header-User-Menu-Login-Link">
                            회원가입
                        </Link>
                    </div>
                </div>
            </div>

            <nav className="Header-Nav">
                <div className="Header-Nav-Container">
                    <div className="Header-Nav-Category">
                        <button className="Header-Nav-Category-Button">
                            카테고리<span>▼</span>
                        </button>
                        <div className="Header-Nav-Category-Dropdown">
                            <Link to="/" className="Header-Nav-Category-Dropdown-Link">
                                카테고리
                            </Link>
                        </div>
                    </div>

                    <Link to="/" className="Header-Nav-Link">
                        전체상품
                    </Link>
                    <Link to="/" className="Header-Nav-Link">
                        인기상품
                    </Link>
                    <Link to="/" className="Header-Nav-Link">
                        신상품
                    </Link>
                </div>
            </nav>
        </header>
    )
}

export default Header;