import React from 'react';
import "./Style.css";

//          component: Footer 컴포넌트          //
function Footer() {

    //           render: Footer 렌더링          //
    return (
        <footer className="Footer">
            <div className="Footer-Container">

                {/* 회사 정보 */}
                <div>
                    <h3 className="Footer-Company-Text">
                        404 SHOP
                    </h3>
                    <p className="Footer-Company-Description">
                        최고의 상품과 서비스로 고객님의 만족을 추구합니다.
                    </p>
                    <div className="Footer-Company-Icons">
                        <span>📧</span>
                        <span>📱</span>
                        <span>💬</span>
                    </div>
                </div>

                {/* 고객 서비스 */}
                <div>
                    <h3 className="Footer-Section-Title">
                        고객 서비스
                    </h3>
                    <ul className="Footer-Link-List">
                        <li className="Footer-Link-Item">
                            <a href="#" className="Footer-Link">
                                자주 묻는 질문
                            </a>
                        </li>
                        <li style={{ marginBottom: '0.5rem' }}>
                            <a href="#" className="Footer-Link">
                                배송 안내
                            </a>
                        </li>
                        <li style={{ marginBottom: '0.5rem' }}>
                            <a href="#" className="Footer-Link">
                                반품/교환 안내
                            </a>
                        </li>
                        <li style={{ marginBottom: '0.5rem' }}>
                            <a href="#" className="Footer-Link">
                                고객센터
                            </a>
                        </li>
                    </ul>
                </div>

                {/* 회사 상세 정보 */}
                <div>
                    <h3 className="Footer-Section-Title">
                        회사 정보
                    </h3>
                    <div className="Footer-Company-Detail">
                        <p className="Footer-Link-Item">
                            <strong>상호명:</strong> 404 SHOP
                        </p>
                        <p className="Footer-Link-Item">
                            <strong>대표:</strong> 한성준
                        </p>
                        <p className="Footer-Link-Item">
                            <strong>사업자등록번호:</strong> 123-45-67890
                        </p>
                        <p className="Footer-Link-Item">
                            <strong>주소:</strong> 서울특별시 강남구 테헤란로 123
                        </p>
                        <p className="Footer-Link-Item">
                            <strong>전화:</strong> 02-1234-5678
                        </p>
                        <p className="Footer-Link-Item">
                            <strong>이메일:</strong> gkstjdwns2@naver.com
                        </p>
                    </div>
                </div>

            </div>

            {/* 하단 저작권 */}
            <div className="Footer-Copyright">
                <p>
                    © 2024 쇼핑몰. All rights reserved.
                </p>
            </div>
        </footer>
    );
}

export default Footer; 