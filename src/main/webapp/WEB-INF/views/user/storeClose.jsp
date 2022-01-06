<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/FortAwesome/Font-Awesome@5.14.0/css/all.min.css">
    <link type="text/css" href="/project1982/resources/css/6_my_store.css" rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<style>
	h2 {
		text-align: center;
	}
	table {
		width: 100%;
	}
	#outter2 {
		display: block;
 		width: 100%;
		margin: auto;
	}
	a {
		text-decoration: none;
	}
	.chart{
	display:flex;
	flex-direction:column;
	justify-content:center;
	align-items:center;
	}
</style>

<script>
	function selChange() {
		var sel2 = document.getElementById('cntPerPage').value;
		location.href="/project1982/user/storeClose.do?nowPage=${paging.nowPage}&cntPerPage="+sel2;
	}
</script>


<body>
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
                   <a href="storeClose.do?userid=${userId}" class="search">
                   일자리찾기
                   </a>
                   <!--유저 -->
                   <a href="userMypage.do?userid=${userId}" class="user">
                   마이페이지
                   </a>

                   <!--카트  -->
                   <a href="userBoard.do?userid=${userId}">
                   고객센터
                       <!--카트 상품-->
                       
                   </a>
                   <a href="/project1982/index.jsp" class="logout">
                    로그아웃

                   </a>
               </div>
   
           </header>
 <!-- 메인 ---------------------------------------------------------------->
     	<!-- 왼쪽 네비게이션 -->
            <ul class="left_nav">
            	<br/>
                <li class="left_nav_text"><a>자주 묻는 질문</a></li>
                <br/>
                <li class="left_nav_text"><a href="#" onclick="window.open('userpay.do','주휴 수당 이란?', 'width=1000px;, height=800px, resizable = no, scrollbars = no'); return false">주휴 수당이란?</a></li>
                <br/>
                <li class="left_nav_text"><a href="#" onclick="window.open('userpay2.do','적용 대상 ', 'width=800px;, height=700px, resizable = no, scrollbars = no'); return false">최저 임금 적용 대상</a></li>
                <br/>
                <li class="left_nav_text"><a href="#" onclick="window.open('userpay3.do', '최저 임금 Q&A', 'width=1000px;, height=700, resizable = no, scrollbars = no'); return false">최저 임금 Q&A</a></li>
                <br/> 
            </ul>
            
     	<form class="search-form" action="/project1982/user/storeClose.do" autocomplete="off" method="get">
     		<select name="searchCondition">
     			<option value="shopaddr">주소</option>
     			<option value="shopname">업체명</option>
     			<option value="jobDate">날짜</option>
     			<option value="normal_emergency">긴급/일일</option>
     		</select>
     		
     		<input type="text" name="searchKeyword">
     		<input type="submit" value="검색">
     	</form>
     	<div id="outter2">
				   <div>
						<select id="cntPerPage" name="sel2" onchange="selChange()">
							<option value="5"
								<c:if test="${paging.cntPerPage == 5}">selected</c:if>>5줄 보기</option>
							<option value="10"
								<c:if test="${paging.cntPerPage == 10}">selected</c:if>>10줄 보기</option>
							<option value="15"
								<c:if test="${paging.cntPerPage == 15}">selected</c:if>>15줄 보기</option>
							<option value="20"
								<c:if test="${paging.cntPerPage == 20}">selected</c:if>>20줄 보기</option>
						</select>
						</div>
			</div>
    <section class="section_main">
           
      <div id="mainWrapper">

  
              <!-- 게시판 목록  -->
              <li>
                  <ul id ="ulTable">
                      <li>
                          <ul>
                              <li>업체</li>
                              <li>긴급/일일</li>
                              <li>주소</li>
                              <li>날짜</li>
                              <li>시급</li>
                          </ul>
                      </li>
                      <!-- 게시물이 출력될 영역 -->
                       
                        <c:forEach items="${ShopList}" var="shop">
							<li>
							<ul>
								
								<li class="left"><a href="userSupport.do?board_owner_seq=${shop.board_owner_seq}">
										${shop.shopname}</a></li>
								<li class="left">${shop.normal_emergency }</li>
								<li class="left">${shop.shopaddr }</li>
								<li class="left">${shop.jobDate }</li>
								<li class="left">${shop.shoppay }</li>
							</ul>
							</li>
						</c:forEach>                            
                  </ul>
              </li>
              
             <!-- 게시판 페이징 영역  -->
  			<div style="display: block; text-align: center;">		
				<c:if test="${paging.startPage != 1 }">
					<a href="/project1982/user/storeClose.do?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
				</c:if>
				<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
					<c:choose>
						<c:when test="${p == paging.nowPage }">
							<b>${p}</b>
						</c:when>
						<c:when test="${p != paging.nowPage }">
							<a href="/project1982/user/storeClose.do?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
						</c:when>
					</c:choose>
				</c:forEach>
				<c:if test="${paging.endPage != paging.lastPage}">
					<a href="/project1982/user/storeClose.do?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
				</c:if>
			</div>
		
		<div id=pay>
       	<img src="/project1982/resources/images/pay.PNG"/>
       	<img src="/project1982/resources/images/pay2.PNG"/>
        </div>
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