<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/FortAwesome/Font-Awesome@5.14.0/css/all.min.css">
	<link type="text/css" href="/project1982/resources/style/style.css" rel="stylesheet"/>
    <link type="text/css" href="/project1982/resources/style/header.css" rel="stylesheet"/>
</head>
<body>
 

        <!--메뉴바  ------------------------------------------------->
        <header class="header" >
         <!-- 로고-->

            <a href="#" class="logo">
                <img src=""/>
            </a>

            <!--메뉴-->   
            <ul class="menu">
                <li><a href="#">구직자용</a></li>
                <li><a href="#">구인자용</a>
                <!--쎄일 라벨 -->
                    <span class="sale-lable">신규</span>
                </li>
                <li><a href="#">둘러보기</a></li>
                <li><a href="#">FAQ</a></li>
                <li><a href="#">고객센터</a></li>
            </ul>
            <!-- 오른쪽 메뉴-->
            <div class="right-menu">
                <!--검색 -->
                <a href="#" class="search">
                    <i class="fas fa-search"></i>
                </a>
                <!--유저 -->
                <a href="#" class="user">
                    <i class="far fa-user"></i>
                </a>
                <!--카트  -->
                <a href="#">
                    <i class="fas fa-shopping-cart">
                    <!--카트 상품-->
                    <span class="num-cart-product">0</span>
                    </i>
                </a>
            </div>

        </header>

    <!-- 메인 ---------------------------------------------------------------->
        <main>

            <form action="">
            <ul class="left_nav">
                <li class="left_nav_text"><a class="home" href="#">홈</a></li>
                <li class="left_nav_text"><a href="#">새소식</a></li>
                <li class="left_nav_text"><a href="#">상품</a></li>
                <li class="left_nav_text"><a href="#">회사</a></li>
            </ul>
            <div class="body_container"> <!-- 페이지 컨테이너 시작-->
         
                <div class="body_container_center"> <!-- 중간 메뉴바 시작-->
                    <div>업체지원현황</div>
                        <div class="body_container_center_shop_contanier">
                            <div class="body_container_center_shop_contanier_img">
                                <input type="text" placeholder="조회기간">
                                 
                            <!--게시판 시작---------->  
                            <div id="mainWrapper">
                                <ul>
                                    <!-- 게시판 제목 -->
                                    <li>게시판 Title </li>
                        
                                    <!-- 게시판 목록  -->
                                    <li>
                                        Table
                                        <ul id ="ulTable">
                                            <li>
                                                <ul>
                                                    <li>No</li>
                                                    <li>제목</li>
                                                    <li>작성일</li>
                                                    <li>작성자</li>
                                                    <li>조회수</li>
                                                </ul>
                                            </li>
                                            <!-- 게시물이 출력될 영역 -->
                                            <li>
                                                <ul>
                                                    <li>1</li>
                                                    <li class="left">제목제목제목제목1</li>
                                                    <li>2014.07.09</li>
                                                    <li>자바킹</li>
                                                    <li>0</li>
                                                </ul>
                                            </li>
                        
                                            <li>
                                                <ul>
                                                    <li>2</li>
                                                    <li class="left">제목제목제목제목1</li>
                                                    <li>2014.07.09</li>
                                                    <li>자바킹</li>
                                                    <li>0</li>
                                                </ul>
                                            </li>
                        
                                            <li>
                                                <ul>
                                                    <li>3</li>
                                                    <li class="left">제목제목제목제목1</li>
                                                    <li>2014.07.09</li>
                                                    <li>자바킹</li>
                                                    <li>0</li>
                                                </ul>
                                            </li>
                        
                                            <li>
                                                <ul>
                                                    <li>4</li>
                                                    <li class="left">제목제목제목제목1</li>
                                                    <li>2014.07.09</li>
                                                    <li>자바킹</li>
                                                    <li>0</li>
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
                                            <select id='selSearchOption' >
                                                <option value='A'>제목+내용</option>
                                                <option value='T'>제목</option>
                                                <option value='C'>내용</option>
                                            </select>
                                            <input id='txtKeyWord' />
                                            <input type='button' value='검색'/>
                                        </div>
                                        </li>
                        
                                </ul>
                            </div>
                                    
                             <!-- 게시판 종료 --------->
                            </div>
                            <div class= "body_container_center_shop_contanier_info">

                                <div class="shop_img">
                                    <img src="" alt="">
                                    <p>${shop.shopname }</p>
                                    <p>가산 디지털로</p>
                                    <button>찜하기</button>
                                    <button>리뷰작성</button>
                                </div>                 
                                <div class="store">
                                    <div>업체와 대화를 나눠보세요</div>
                                    <div class="talk_store"></div>
                                </div>                 
                            </div>
                        </div>
                    
                        <main>
                            <div>
                                <div class="table_title">내가 찜한 점포</div>   
                                <table border='1' >
                                    <tr>
                                      <td>업체명</td>
                                      <td>Price</td>
                                      <td>Product</td>
                                      <td>Price</td>
                                      <td>Product</td>
                                      
                                    </tr>
                                    <tr>
                                      <td>
                                        <button class="store_button">gs25</button>
                                      </td>
                                      <td>3000</td>
                                      <td>Product</td>
                                      <td><a href="#">Price</a></td>
                                      <td>
                                        <button class="store_button">gs25</button>
                                        <button class="store_button">gs25</button>
                                      </td>
                                   
                                    </tr>
                                    <tr>
                                      <td>
                                        <button class="store_button">gs25</button> 
                                      </td>
                                      <td>2000</td>
                                      <td>Product</td>
                                      <td><a href="#">Price</a></td>
                                      <td>
                                        <button class="store_button">gs25</button>
                                        <button class="store_button">gs25</button>
                                      </td>
                                     
                                    </tr>
                                    <tr>
                                        <td>
                                            <button class="store_button">gs25</button>
                                        </td>
                                        <td>2000</td>
                                        <td>Product</td>
                                        <td><a href="#">Price</a></td>
                                        <td>
                                            <button class="store_button">gs25</button>
                                            <button class="store_button">gs25</button>
                                          </td>
                                    </tr>                    
                                  </table>
                                  
                            </div>
                          </main>
                    
                    
                    
                 
                   
                </div><!--중간 메뉴바 종료-->
               
            
            </div><!-- 페이지 컨테이너 종료--> 
        </form>
        </main>
        
        
        
        
        
        
        
        
        
        
        
 
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
