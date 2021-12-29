<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" href="/project1982/resources/css/reset.min.css" rel="stylesheet">
    <link type="text/css" href="/project1982/resources/css/all.min.css" rel="stylesheet">
  	<link type="text/css" href="/project1982/resources/style/useStyle.css" rel="stylesheet"/>
    <link type="text/css" href="/project1982/resources/style/header.css" rel="stylesheet"/>
    <script type="text/javascript" src="/project1982/resources/js/userview.js"></script>
	<title>글 목록</title>
</head>

<style>
	h2 {
		text-align: center;
	}
	table {
		width: 100%;
	}
	#outter {
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
		var sel = document.getElementById('cntPerPage').value;
		location.href="/project1982/user/userBoard.do?nowPage=${paging.nowPage}&cntPerPage="+sel;
	}
</script>

<body>
<% 
	String userId = (String)session.getAttribute("userId");
%>
        <!--메뉴바  ------------------------------------------------->
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
                   <a href="storeClose.do" class="search">
                   일자리찾기
                   </a>
                   <a href="userMypage.do?userid=${userId}" class="user">
                   마이페이지
                   </a>
                   <a href="userBoard.do">
                   고객센터                       
                   </a>
                   <a href="/project1982/index.jsp" class="logout">
                    로그아웃
                   </a>
               </div>
   
           </header>
<!-- -----------메인---------------- -->
		       <!-- 검색부분 추가 -->
        <main>
        	 <div class="jari"> <!-- 페이지 컨테이너 시작-->
        	 	<div class="jari1"> <!-- 중간 메뉴바 시작-->	
		        <div id="actor1">고객센터</div>
		        <hr/>
		        
		        <div class="chart">
                   <form action='/project1982/user/userBoard.do' method='get'>
                       <select name="searchCondition" id="" style="width:150px;">
                           <option value="b_title">제목</option>
                           <option value="b_content">내용</option>
                           <option value="b_name">작성자</option>
                        </select>
						<input type='text' name='searchKeyword' style="width:600px;">
						<input type='submit' value='검색' style="width:100px;">
					</form>
				</div>



                 
 			<div id="outter">
				   <div style="float: right;">
						<select id="cntPerPage" name="sel" onchange="selChange()">
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
					
	<table id="boardTable">
			<tr>
				<th bgcolor="#dee2e6" width="100" >번호</th>
				<th bgcolor="#dee2e6" width="400" >제목</th>
				<th bgcolor="#dee2e6" width="150" >작성자</th>
				<th bgcolor="#dee2e6" width="170" >등록일</th>
				<th bgcolor="#dee2e6" width="120" >조회수</th>
				<th bgcolor="#dee2e6" width="170">파일이름</th>
				<th bgcolor="#dee2e6" width="120">파일용량</th>				
				<!-- 추가 -->
			</tr>
			<c:forEach items="${boardList}" var="board">
				<!-- 프라퍼티이름 변경 -->
				<tr>
					<td>${board.b_id }</td>
					<td align="left"><a href="getBoard.do?b_id=${board.b_id}" id="go">
							${board.b_title }</a></td>
					<td>${board.b_name }</td>
					<td>${board.b_date }</td>
					<td>${board.b_count }</td>
					<!-- 추가 -->
					<td>
					 <c:choose>
					    <c:when test="${board.b_fsize==0}">첨부파일 없음</c:when>
					    <c:otherwise>
					    		<img src="resources/images/disk.gif">${board.b_fname}
					    </c:otherwise>
					 </c:choose>					  
					</td>					
					<td>${board.b_fsize}byte</td>
				</tr>
			</c:forEach>
		</table>
		<br> <a href="insertBoard.do">새글 등록</a>
		
		
			<div style="display: block; text-align: center;">		
				<c:if test="${paging.startPage != 1 }">
					<a href="/project1982/user/userBoard.do?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
				</c:if>
				<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
					<c:choose>
						<c:when test="${p == paging.nowPage }">
							<b>${p}</b>
						</c:when>
						<c:when test="${p != paging.nowPage }">
							<a href="/project1982/user/userBoard.do?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
						</c:when>
					</c:choose>
				</c:forEach>
				<c:if test="${paging.endPage != paging.lastPage}">
					<a href="/project1982/user/userBoard.do?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
				</c:if>
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