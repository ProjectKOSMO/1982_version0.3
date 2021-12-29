<!DOCTYPE html>
<html lang="en">
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
 <% 
	String userId = (String)session.getAttribute("userId");
 	out.println(userId);
%>

        <!--메뉴바  ------------------------------------------------->
        <header class="header" >
         <!-- 로고-->
            <div>
            <a href="userMain.do" class="logo">
                <h1>1982</h1>
            </a>
            </div>
            <!--메뉴--> 
          
            
            <!-- 오른쪽 메뉴-->
            <div class="right-menu">
                <!--검색 -->
                <a href="storeClose.do" class="search">
              일자리찾기
                </a>
                <!--유저 -->
                <a href="userMypage.do" class="user">
                마이페이지
                </a>
                <!--카트  -->
                <a href="userBoard.do">
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
                <img src="../resources/upload/${shop.si_realname}" alt="" />
            </div>
            <div >
                <form action="support.do" method="post" id="login-form">
                
                	<input type="hidden" value="${userId}" name="userid"/>
                	<input type="hidden" value="${shop.board_owner_seq }" name="board_owner_seq"/>
                	
                    <div>업체 이름 : ${shop.shopname }</div>
                    <input type="hidden" value="${shop.shopname }" name="shopname"/>
                    <div>긴급/일일 : ${shop.normal_emergency }</div>
                    <input type="hidden" value="${shop.normal_emergency }" name="normal_emergency"/>
                    <div >주소 : ${shop.shopaddr }</div>
                    <input type="hidden" value="${shop.shopaddr }" name="shopaddr"/>
                  	<div>시급 : ${shop.shoppay }</div>
                  	<input type="hidden" value="${shop.shoppay }" name="shoppay"/>
                    <div>날짜 : ${shop.jobDate }</div>
                    <input type="hidden" value="${shop.jobDate }" name="jobDate"/>
                    <div>시작시간 : ${shop.jobTime_start }</div>
                    <input type="hidden" value="${shop.jobTime_start }" name="startTime"/>
                    <div>종료시간 : ${shop.jobTime_end }</div>
                    <input type="hidden" value="${shop.jobTime_end }" name="endTime" />
                 	<div class="review_star">
                   		
                      <button class="button" type="submit" > 지원하기</button>
                  </div>
                  </form>
                 
                  
                  </div>
        </main>
        
      
        <!--아래 게시판 ----------------------------------------------------------------------->


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