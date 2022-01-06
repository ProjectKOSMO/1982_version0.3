<!-- 
  -	작성 일자 : 2021. 12. 25.
  -	수정 일자 : 2021. 12. 25.
  -	작성자 : 이혁철
  -	내용 : 구직자 마이페이지
  - 변경 사항 있으면 아래에 자세히 작성 바랍니다..
  - ex) idcheck 보안사항 추가, 맵핑 추가 등등
 
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이 페이지</title>
    <link type="text/css" href="/project1982/resources/css/reset.min.css" rel="stylesheet">
    <link type="text/css" href="/project1982/resources/css/all.min.css" rel="stylesheet">
	<link type="text/css" href="/project1982/resources/style/useStyle.css" rel="stylesheet"/>
    <link type="text/css" href="/project1982/resources/style/header.css" rel="stylesheet"/>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
</head>

<script type="text/javascript">
$(document).ready(function(){
	
	$("a#supportdetail").on("click", function(){
		
		var teo = {"shopname" : $(this).text()}
		
		console.log($(this).text());
		
		$.ajax({
			type : 'post',
			url : '../user/shopInfoView.do',
			contentType : "application/json",
			data : JSON.stringify(teo),
			dataType : 'json',
			success : function(shop){
				console.log(shop)
				var image = "<img src=" + "/project1982/resources/upload/" + shop.si_realname + " style='width: 100%;'/>";
				$(".body_container_center_shop_contanier_info_ta1").html(image)
				$("#shopname").html(shop.shopname)
				$("#shopaddr").html(shop.shopaddr)
				$("#shoppn").html(shop.shoppn)
			},
			error:function(request,status,error){
			    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			   }
		})
	});
	
});
</script>
<body>
<% 
	String userId = (String)session.getAttribute("userId");
%>
        <!--메뉴바(헤더)  ------------------------------------------------->
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
     <main>
        
      		<!-- 왼쪽 네비게이션 -->
            <ul class="left_nav">
                <li class="left_nav_text"><a href="#actor">프로필 수정</a></li>
                <li class="left_nav_text"><a href="#actor1">업체지원현황</a></li>
                <li class="left_nav_text"><a href="#" onclick="window.open('userInfoView.do?userid=${userId}', '간단한 이력서','width=700;, height=500, resizable = no, scrollbars = no'); return false">간단한이력서</a></li>  
            </ul>
            
     <!-- 프로필 수정 -->
     <form action="updateMypage.do" method="post" enctype="multipart/form-data">
         <input name="userid" type="hidden" value="${userId}" />
         <div class="body_container"> <!-- 페이지 컨테이너 시작-->
             <div class="body_container_center"> <!-- 중간 메뉴바 시작-->
             
                 <div id="actor">프로필 수정</div>
                 <hr/>
                     <div class="body_container_center_shop_contanier">
                         <div class="body_container_center_shop_contanier_img">
                                <div class="body_container_center_shop_contanier_img_ta1">                          
                                 <div class="body_container_center_shop_contanier_img_ta2">
                                     <c:if test="${user.userimg1 != null}">             			
                                         <img src="/project1982/resources/upload/${user.userimg1}" style="height: 240px;width: 180px;">
                                     </c:if>
                                 </div>
                                 <input type="file" name='file' maxlength="60" size="40" value="${user.userimg1}" style=" margin-left:10px;">
                             </div>
                                 <div style="flex:10;">
                                    <p style="margin-left:4%;width:92%;margin-rigth:4%;margin-top:10px;font-size:20px;font-weight:bolder;border-bottom:solid 2px black;font-family: 'Gowun Dodum', sans-serif;">회원정보수정<p><br/>                 
                                    <p style="margin-left:4%;font-weight:bolder;font-family: 'Gowun Dodum', sans-serif;">- 이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 름 :<input id="dia" name="username" type="text" value="${user.username}"/><p><br/>
                                    <p style="margin-left:4%;font-weight:bolder;font-family: 'Gowun Dodum', sans-serif;">- 비밀번호 :<input id="dia" name="userpass" type="password" value="${user.userpass}"/><p><br/>
                                    <p style="margin-left:4%;font-weight:bolder;font-family: 'Gowun Dodum', sans-serif;">- 자기소개<p><br/>
                                    <input id="dia1" name="userself" type="text" placeholder="자신을 소개해보세요" value="${user.userself}"/>
                                    <input type="submit" value="수정완료" style="margin-left:4%;">
                                    </div>                              
                         </div>
                     </div>
              </div> <!-- 중간 메뉴바 종료-->
         </div><!-- 페이지 컨테이너 종료--> 
     </form>
     </main>
        
        <!---------------------- 업체지원현황 ------------------------------------------->
        <main>
        	 <div class="body_container1"> <!-- 페이지 컨테이너 시작-->
        	 	<div class="body_container_center"> <!-- 중간 메뉴바 시작-->
                	<div id="actor1">업체 지원 현황</div>
                	<hr/>
                        <div class="body_container_center_shop_contanier">
                            <div class="body_container_center_shop_contanier_img1">
                            
                                <!-- 검색부분 추가 -->
						        <div class="chart">
				                   <form action='/project1982/user/userMypage.do' method='post'>
				                   	 <input name="userid" type="hidden" value="${userId}" />
				                       <select name="searchCondition" id="" style="width:100px;">
				                           <option value="shopname">업체명</option>
				                           <option value="maching">매칭여부</option>
				                           <option value="jobDate">일자</option>
				                        </select>
										<input type='text' name='searchKeyword' style="width:530px;">
										<input type='submit' value='검색' >
									</form>
								</div>
		                	
        <!-------------------------- 테이블 ------------------------->     
                        <div class="divTable minimalistBlack"><!-- 출근현황 시작 -->
                            <div class="divTableHeading"><!-- 제목 전체 -->
                                <div class="divTableRow"><!-- 제목 내부 -->
                                    <div class="divTableHead">일자</div>
                                    <div class="divTableHead">시작시간</div>
                                    <div class="divTableHead">종료시간</div>
                                    <div class="divTableHead">업체명</div>
                                    <div class="divTableHead">급여</div>
                                    <div class="divTableHead">매칭 여부</div>
                                </div><!-- 제목내부 -->
                            </div><!-- 제목 전체 -->
                            
                            <div class="divTableBody">
                            <c:forEach items="${support}" var="sup">
                                <div class="divTableRow">
                                    <div class="divTableCell">${sup.jobDate }</div>
                                    <div class="divTableCell">${sup.jobTime_start }</div>
                                    <div class="divTableCell">${sup.jobTime_end }</div>
                                    <div class="divTableCell">
                                        <a href="#" id="supportdetail">${sup.shopname}</a>
                                    </div>
                                    <div class="divTableCell">${sup.shoppay }</div>
                                    <div class="divTableCell"> ${sup.maching }</div> 
                                </div> <!-- 첫행 -->
                               </c:forEach> 
                            </div>  
                   		 </div> 
                                <!------------------------ 테이블 종료---------------> 
                            </div>
                           
                         <div class= "body_container_center_shop_contanier_info1">
                             <div class="body_container_center_shop_contanier_info_ta1" style="width:95%;">
                                     
                             </div>
                             <!-- 업체 미리보기 -->
                             <div style="margin-left:5%;margin-right:5%;">
                                 <ul style="font-size:18px;font-weight:bolder;font-family: 'Gowun Dodum', sans-serif;">
                                     <br/>
                                     <li>- 업체이름 : <span id="shopname"></span></li>
                                     <br/>
                                     <hr/>
                                     <br/>
                                     <li>- 업체주소 : <span id="shopaddr"></span></li>
                                     <br/>
                                     <hr/>
                                     <br/>
                                     <li>- 업체 전화번호 : <span id="shoppn"></span></li>
                                     <br/>
                                     <hr/>
                                 </ul>
                             </div>
                         </div>
                     </div>

             </div> <!-- 중간 메뉴바 종료-->
         </div><!-- 페이지 컨테이너 종료-->
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