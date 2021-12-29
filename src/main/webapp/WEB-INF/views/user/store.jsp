<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <title>5</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/FortAwesome/Font-Awesome@5.14.0/css/all.min.css">
    <link type="text/css" href="/project1982/resources/css/5_store.css" rel="stylesheet"/>
</head>
<body>
 

        <!--메뉴바  ------------------------------------------------->
        <header class="header" >
         <!-- 로고-->
            <div>
            <a href="#" class="logo">
                <h1>1982</h1>
            </a>
            </div>
            <!--메뉴--> 


            <!-- 오른쪽 메뉴-->
            <div class="right-menu">
                <!--검색 -->
                <a href="#" class="search">
                 구인공고
                </a>
                <!--유저 -->
                <a href="#" class="user">
                마이페이지
                </a>
                <!--카트  -->
                <a href="#">
                고객센터
                    <!--카트 상품-->

                </a>
                 <a href="/project1982/index.jsp" class="logout">
                    로그아웃
                   </a>
            </div>

        </header>

    <!-- 메인 ---------------------------------------------------------------->
        <main class="main">
            <div class="main_img">
                <img src="" alt="" />
            </div>
            <div >
                <form action="friends.html" method="get" id="login-form">
                    <input name="username" type="text" placeholder="업체명" />
                    <input name="password" type="password" placeholder="주소" />
                    <input name="password" type="password" placeholder="연락처" />

                    <input name="password" type="password" placeholder="업종" />
                    <input type="submit" value="길찾기" />
                  </form>
                  <div class="review_star">
                      <div>리뷰 및 별점</div>
                      <div class="star">
                          <i class="far fa-star"></i>
                          <i class="fas fa-star"></i>
                          <i class="fas fa-star"></i>
                          <i class="fas fa-star"></i>
                          <i class="fas fa-star"></i>
                        4/5</div>
                      <button class="button">지원하기</button>
                  </div>
            </div>
        </main>

        <!--아래 게시판 ----------------------------------------------------------------------->

        <section class="section_main">






            <div id="mainWrapper">

                <ul>
                    <!-- 게시판 제목 -->
                    <div class="board_title">사용자 리뷰 </div>

                    <!-- 게시판 목록  -->
                    <li>

                        <div class="chart_title">             
                            <div><a href="#">작성일순</a></div>
                            <div><a href="#">별점순</a></div>
                            <div>총 4건</div>
                        </div>
                        <ul id ="ulTable">
                            <li>
                                <ul>
                                    <li>No</li>
                                    <li>제목</li>
                                    <li>작성일</li>
                                    <li>작성자</li>
                                    <li>별점</li>
                                </ul>
                            </li>
                            <!-- 게시물이 출력될 영역 -->
                            <li>
                                <ul>
                                    <li class="left">1</li>
                                    <li class="left">제목제목제목제목1</li>
                                    <li class="left">2014.07.09</li>
                                    <li class="left">자바킹</li>
                                    <li class="left">
                                        <i class="far fa-star"></i>
                          <i class="fas fa-star"></i>
                          <i class="fas fa-star"></i>
                          <i class="fas fa-star"></i>
                          <i class="fas fa-star"></i>
                                    </li>
                                </ul>
                            </li>

                            <li>
                                <ul>
                                    <li class="left">2</li>
                                    <li class="left">제목제목제목제목1</li>
                                    <li class="left">2014.07.09</li>
                                    <li class="left">자바킹</li>
                                    <li class="left">0</li>
                                </ul>
                            </li>

                            <li>
                                <ul>
                                    <li class="left">3</li>
                                    <li class="left">제목제목제목제목1</li>
                                    <li class="left">2014.07.09</li>
                                    <li class="left">자바킹</li>
                                    <li class="left">0</li>
                                </ul>
                            </li>

                            <li>
                                <ul>
                                    <li class="left">4</li>
                                    <li class="left">제목제목제목제목1</li>
                                    <li class="left">2014.07.09</li>
                                    <li class="left">자바킹</li>
                                    <li class="left">0</li>
                                </ul>
                            <li>                                        
                        </ul>
                    </li>

                    <!-- 게시판 페이징 영역 -->
                    <li>
                        <div id="divPaging">
                            <div>◀</div>
                               <div><b>1</b></div>
                            <div>2</div>
                            <div>3</div>
                            <div>4</div>
                            <div>5</div>
                            <div>▶</div>
                        </div>
                    </li>

                    <!-- 검색 폼 영역 -->
                    <li id='liSearchOption'>
                        <div>
                            <select id='selSearchOption' class="search_height">
                                <option value='A'>제목+내용</option>
                                <option value='T'>제목</option>
                                <option value='C'>내용</option>
                            </select>
                            <input id='txtKeyWord' class="search_height"/>
                            <input type='button' value='검색'class="search_height"/>
                        </div>
                        </li>

                </ul>
            </div>

        </section>
<!-- footer --------------------------------------------------------------------->
    <footer>
        <div id="footer">
            <div class="wrap_inner">
                <div class="left_area">
                    <h4 class="rap_inner_h4">
                        일구하자 1982
                    </h4>
                    <div class="left_text">
                        <div class="left_text_margin">
                            <h5>고객센터</h5>
                            <p class="left_phone">1566-1982</p>
                            <p> 
                                <div>평일 AM 09:00 ~ PM 05:30</div>
                                <div>점심 PM 12:00 ~ PM 01:00</div>
                            </p>
                        </div>
                    </div>
                    <div class="footer_icon">
                        <div><a href="#"><i class="fab fa-facebook-f fa-2x" style="color:rgba(0,0,0,0.5)"></i></a></div>
                        <div><a href="#"><i class="fab fa-twitter fa-2x" style="color:rgba(0,0,0,0.5)"></i></a></div>
                        <div><a href="#"><i class="fab fa-youtube fa-2x" style="color:rgba(0,0,0,0.5)"></i></a></div>
                        <div><a href="#"><i class="fab fa-instagram fa-2x" style="color:rgba(0,0,0,0.5)"></i></a></div>
                    </div>
                </div>
                <div class="right_area">
                    <div class="right_ul">
                        <p>이용약관 | </p>
                        <p>개인정보처리방침 | </p>
                        <p>일구하자 이용안내 | </p>
                        <p>고객요청</p>
                    </div>
                    <div class="right_address">
                        <p>
                            <span>주식회사 1982 |</span>
                            <a href="#">
                                <span>대표이사 : 한세호 |</span>
                            </a>
                                <span>사업자등록번호 : 123-12-12345</span>
                            </p>
                        <p>
                            <span>통신판매업신고 : 2021-서울가산-1982 |</span>
                            <span>WEBMASTER : 한세호</span>
                        </p>
                        <p>
                            <span>주소 : 00000 서울 금천구 벚꽃로 309 </span>
                        </p>
                        <p>
                            <span>TEL : 1566-1982</span>
                            <span>E - mail : 1982@seho.co.kr</span>
                            <span>호스팅제공자 : 코스모(주)</span>
                        </p>
                    </div>
                    <p class="right_copyright">
                        Copyright by
                        <span>일구하자 1982</span>
                        all rights reserved.
                    </p>
                </div>        
            </div>
        </div>

    </footer>

</body>
</html>
