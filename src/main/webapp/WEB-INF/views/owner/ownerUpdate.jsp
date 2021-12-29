<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/FortAwesome/Font-Awesome@5.14.0/css/all.min.css">
	<link type="text/css" href="/project1982/resources/style/style.css" rel="stylesheet"/>
    <link type="text/css" href="/project1982/resources/style/header.css" rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-3.6.0.js" type="text/javascript"></script>
<script src='/project1982/resources/js/locationExample.js' type="text/javascript"></script>
</head>
<body>

<% 
	String ownerid = (String)session.getAttribute("ownerid");
	Integer ownernum = (Integer)session.getAttribute("ownernum");
	
	out.println(ownerid + " 님 환영합니다.");
	out.println("번호 : " + ownernum);
%>
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
                   <a href="/project1982/owner/job_positing.do" class="search">
                    구인공고
                   </a>
                   <!--유저 -->
                   <a href="/project1982/owner/ownerMypage" class="user">
                   마이페이지
                   </a>
                   <!--카트  -->
                   <a href="/project1982/owner/ownerBoard.do">
                   고객센터
                       <!--카트 상품-->
                       
                   </a>
                   <a href="/project1982/index.jsp" class="logout">
                    로그아웃
                   </a>
               </div>
   
           </header>
    <!-- 메인 ---------------------------------------------------------------->
        <main>
      
        <form action="shopUpdate.do" method='post' enctype="multipart/form-data"> 
            <ul class="left_nav">
                <li class="left_nav_text"><a class="home" href="#">홈</a></li>
                <li class="left_nav_text"><a href="#">새소식</a></li>
                <li class="left_nav_text"><a href="#">상품</a></li>
                <li class="left_nav_text"><a href="#">회사</a></li>
            </ul>
            <div class="body_container"> <!-- 페이지 컨테이너 시작-->
         
                <div class="body_container_center"> <!-- 중간 메뉴바 시작-->
                    <div>업체 정보 수정</div>
                        <div class="body_container_center_shop_contanier">
                            <div class="body_container_center_shop_contanier_img">
                     			<img width="70%" height="70%" src="/project1982/resources/upload/${shopInfo[0].si_realname }">
								<input type="file" name="file" maxlength="60" size="40">
					        </div>
                    
                    
                            <div class= "body_container_center_shop_contanier_info">
                                <div>업체 이름: <input type="text" name="shopname" value="${shopInfo[0].shopname }"> </div>

                                <div>업체 주소: <input type="text" name="shopaddr" id="shopaddr" value="${shopInfo[0].shopaddr }"><div id="locationConfirm">주소확인</button></div>                                
                                <div>location_y: <input type="text" name="location_y" id="location_y" value="${shopInfo[0].location_y }"></div>
                                <div>location_x: <input type="text" name="location_x" id="location_x" value="${shopInfo[0].location_x }"></div>
                                <div>업체 연락처: <input type="text" name="shoppn" value="${shopInfo[0].shoppn }"></div>                             
                                <div class="body_container_center_shop_contanier_info_ta">업체 소개: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <textarea name="shopcontent" id="" cols="30" rows="10" >${shopInfo[0].shopcontent }</textarea>     
                                 <div class="hide">담당자 번호: <input type="text" name="ownernum" value = "${ownernum}"></div>   
                                </div>                                
                                
                                                     <button>확인 </button>                 
                            </div>
                        </div>
                    
                    
            
                  
                   
                </div><!--중간 메뉴바 종료-->
               
            
            </div><!-- 페이지 컨테이너 종료--> 
        </form> <!--  전체폼으로 감싸기 -->
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
