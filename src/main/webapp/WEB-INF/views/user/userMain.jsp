<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>main.jsp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/FortAwesome/Font-Awesome@5.14.0/css/all.min.css">
    <link type="text/css" href="/project1982/resources/css/4_main.css" rel="stylesheet"/>
</head>
<body>

<% 
   String userId = (String)session.getAttribute("userId");
   String userPass = (String)session.getAttribute("userPass");
%>

        <!-- 메뉴바  ------------------------------------------------->
        <header class="header" >
            <!-- 로고-->
               <div>
               <a href="userMain.do" class="logo">
                   <h1>1982</h1>
               </a>
               </div>
               <!--유저 메뉴--> 
               <div class="right-menu">
                   <!--검색 -->


                   <a href="storeClose.do?userid=${userId}" class="search">
                   일자리찾기
                   </a>
                   <a href="userMypage.do?userid=${userId}" class="user">
                   마이페이지
                   </a>
                   <a href="userBoard.do?userid=${userId}">
                   고객센터                       
                   </a>
                 <a href="/project1982/index.jsp" class="logout">
                    로그아웃
                   </a>
               </div>
   
           </header>
    <!-- 메인 ---------------------------------------------------------------->
        <main class="main1">
            <div>
                <div class="main_title">내 주변 일자리</div>
                <div  class="main">
                  <div id="map" style="width:1400px;height:500px;margin-top: 50px;border: 1px solid black;"></div>
                  
    <script src="https://code.jquery.com/jquery-3.6.0.js" type="text/javascript"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=eb66f18ab68f4698ad06cb4444bfc896&libraries=services"></script>
<script src='/project1982/resources/js/locationExample4.js' type="text/javascript"></script>

    
                  
                </div>
                
                <div id="searchPost" style="width:1430px;height:250px; display:flex; margin-left:auto; margin-right:auto;">  
                       <div class="main_right"></div>
                       <div class="main_right"></div>
                       <div class="main_right"></div>
                       <div class="main_right"></div>
                  </div>
                
                
               <div id="SongPagingMap">
               
                <div id="divPagingMap">
                    <div>2</div>
                    <div>1</div>
                </div>
               
            </div>
<div style="display:flex; justify-content:center; margin-bottom:20px;">
<form name="search-form" method='get'>
      <input type='text' name='CenterLocation_y' id='CenterLocation_y' style="display:none" >
      <input type='text' name='CenterLocation_x' id='CenterLocation_x' style="display:none" >
      <input type= 'text' name='pageNum' id='pageNum'style="display:none" >
      <select name='searchCondition'>
         <option value='I.shopName'>가게이름</option>
         <option value='I.content'>업무내용</option>
      </select>
      <input type='text' name='searchKeyword'>
      <input type='button' id="em" value='검색'>
</form>
</div>

<div style="display:flex; justify-content:center;">
<button id="mapPanTo">검색 중심 좌표로 이동하기</button>
<button id="moveCenterLocation">검색 중심 위치 변경하기</button>
</div>

         <div class="main2">
                <img src="/project1982/resources/images/main1.jpg" alt="">
                <div class="main_wrap">
                    <h2>언제나 365일</h2>
                    <p>일자리는 언제든 어디서든 열려있습니다. 주저하지 말고 지원하세요 저희는 당신을 응원합니다.
                    </p>
                    <form action="storeClose.do?userid=${userId}">
                <input type="submit" class="main2_button" onclick="storeClose.do?userid=${userId}" value="지원하기">   
                </form>
                </div>
            </div>           
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