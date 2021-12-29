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
	<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css"> -->
    <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/FortAwesome/Font-Awesome@5.14.0/css/all.min.css"> -->
  	<!-- <link type="text/css" href="/project1982/resources/style/style.css" rel="stylesheet"/> -->
    <link type="text/css" href="/project1982/resources/style/header.css" rel="stylesheet"/>
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
		width: 60%;
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
		location.href="/project1982/owner/ownerBoard.do?nowPage=${paging.nowPage}&cntPerPage="+sel;
	}
</script>

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
                   <a href="/project1982/owner/job_positing.do" class="search">
                   구인공고
                   </a>
                   <!--유저 -->
                   <a href="/project1982/owner/ownerMypage.do" class="user">
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
<!-- -----------메인---------------- -->
		                   <!-- 검색부분 추가 -->
		        <div class="chart">
		        <h1>게시글 목록</h1>
                   <form action='/project1982/owner/ownerBoard.do' method='get'>
                       <select name="searchCondition" id="" >
                           <option value="b_title">제목</option>
                           <option value="b_content">내용</option>
                           <option value="b_name">작성자</option>
                        </select>
						<input type='text' name='searchKeyword'>
						<input type='submit' value='검색'>
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
					
	<table border="1">
			<tr>
				<th bgcolor="orange" width="100" >번호</th>
				<th bgcolor="orange" width="200" >제목</th>
				<th bgcolor="orange" width="150" >작성자</th>
				<th bgcolor="orange" width="150" >등록일</th>
				<th bgcolor="orange" width="100" >조회수</th>
				<!-- 추가 -->
			</tr>
			<c:forEach items="${boardList}" var="board">
				<!-- 프라퍼티이름 변경 -->
				<tr>
					<td>${board.b_id }</td>
					<td align="left"><a href="getBoard.do?b_id=${board.b_id }">
							${board.b_title }</a></td>
					<td>${board.b_name }</td>
					<td>${board.b_date }</td>
					<td>${board.b_count }</td>
					<!-- 추가 -->
				</tr>
			</c:forEach>
		</table>
		<br> <a href="insertBoard.do">새글 등록</a>
		
		
	<div style="display: block; text-align: center;">		
		<c:if test="${paging.startPage != 1 }">
			<a href="/project1982/owner/ownerBoard.do?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p}</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="/project1982/owner/ownerBoard.do?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="/project1982/owner/ownerBoard.do?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
	</div>
</div>	
		
		
		
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