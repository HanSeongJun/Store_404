import {Link} from "react-router-dom";
import "./Style.css";
import logoImage from "../../Assets/logo.png";
import {useEffect, useState} from "react";

//          component: 헤더 컴포넌트          //
function Header() {

    //          state: 사용자 메뉴 드랍다운 상태          //
    const [isUserMenuOpen, setIsUserMenuOpen] = useState(false);
    //          state: 카테고리 메뉴 드랍다운 상태          //
    const [isCategoryMenuOpen, setIsCategoryMenuOpen] = useState(false);

    //          event handler: 사용자 메뉴 드랍다운 핸들러          //
    const handleUserMenuClick = () => {
        setIsUserMenuOpen(!isUserMenuOpen);
        setIsCategoryMenuOpen(false);
    }
    //          event handler: 카테고리 메뉴 드랍다운 핸들러          //
    const handleCategoryMenuClick = () => {
        setIsCategoryMenuOpen(!isCategoryMenuOpen);
        setIsUserMenuOpen(false);
    }

    //           effect: 드롭다운 외부 클릭 시 닫기          //
    useEffect(() => {
        const handleClickOutside = (event) => {
            if (!event.target.closest('[data-dropdown]')) {
                setIsUserMenuOpen(false);
                setIsCategoryMenuOpen(false);
            }
        };

        document.addEventListener('mousedown', handleClickOutside);
        return () => {
            document.removeEventListener('mousedown', handleClickOutside);
        }
    })

    //           render: Header 렌더링          //
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
                        <input type="text" placeholder="검색어를 입력해주세요" className="Header-Search-Input" />
                        <button className="Header-Search-Button" >
                            <svg
                            xmlns="http://www.w3.org/2000/svg"
                            className="SearchIcon"
                            fill="none"
                            viewBox="0 0 24 24"
                            stroke="var(--green)"
                            width="20"
                            height="20">
                                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2"
                                d="M21 21l-4.35-4.35M17 10.5A6.5 6.5 0 104 10.5a6.5 6.5 0 0013 0z" />
                            </svg>
                        </button>
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
                        <div className="Header-User-Menu-Member" data-dropdown>
                            <button className="Header-User-Menu-Button" onClick={handleUserMenuClick}>회원 이름
                                <span>▼</span>
                            </button>
                            {isUserMenuOpen && (
                                <div className="Header-User-Menu-Member-Dropdown">
                                    <div className="Header-User-Menu-Member-Dropdown-Info">
                                        <div className="Header-User-Menu-Member-Dropdown-Hello">안녕하세요,</div>
                                        <div className="Header-User-Menu-Member-Dropdown-Member">사용자 님.</div>
                                    </div>
                                    <button className="Header-User-Menu-Logout-Button">로그아웃</button>
                                </div>
                            )}
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
                    <div className="Header-Nav-Category" data-dropdown>
                        <button className="Header-Nav-Category-Button" onClick={handleCategoryMenuClick}>
                            <span className="HamburgerIcon">
                                <span></span>
                                <span></span>
                                <span></span>
                            </span>
                            <span className="CategoryText">카테고리</span>
                        </button>
                        {isCategoryMenuOpen && (
                            <div className="Header-Nav-Category-Dropdown">
                                <Link to="/" className="Header-Nav-Category-Dropdown-Link">
                                    카테고리
                                </Link>
                            </div>
                        )}
                    </div>

                    <Link to="/" className="nav Header-Nav-Link">
                        전체상품
                    </Link>
                    <Link to="/" className="nav Header-Nav-Link">
                        인기상품
                    </Link>
                    <Link to="/" className="nav Header-Nav-Link">
                        신상품
                    </Link>
                </div>
            </nav>
        </header>
    )
}

export default Header;