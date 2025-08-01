import {Link} from "react-router-dom";

function Header() {



    return (
        <header>
            <div>
                {/* 로고 */}
                <Link to="/">
                    <h1>404</h1>
                </Link>

                {/* 검색 창 */}
                <form>
                    <div>
                        <input />
                        <button>검색</button>
                    </div>
                </form>

                {/* 사용자 메뉴 */}
                <div>
                    <>
                        <Link to="/">장바구니</Link>
                        <Link to="/">관리자</Link>
                        <div>
                            <button>회원 이름
                                <span>▼</span>
                            </button>
                            <div>
                                <div>
                                    <div>안녕하세요,</div>
                                    <div>사용자 님.</div>
                                </div>
                                <button>로그아웃</button>
                            </div>
                        </div>
                    </>

                    <div>
                        <Link to="/login">
                            로그인
                        </Link>
                        <Link to="/signUp">
                            회원가입
                        </Link>
                    </div>
                </div>
            </div>

            <nav>
                <div>
                    <div>
                        <button>
                            카테고리<span>▼</span>
                        </button>
                        <div>
                            <Link to="/">
                                카테고리
                            </Link>
                        </div>
                    </div>

                    <Link to="/">
                        전체상품
                    </Link>
                    <Link to="/">
                        인기상품
                    </Link>
                    <Link to="/">
                        신상품
                    </Link>
                </div>
            </nav>
        </header>
    )
}

export default Header;