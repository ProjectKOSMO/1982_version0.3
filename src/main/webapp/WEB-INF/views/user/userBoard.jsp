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
  	<link type="text/css" href="/project1982/resources/style/board.css" rel="stylesheet"/>
    <link type="text/css" href="/project1982/resources/style/boardheader.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/FortAwesome/Font-Awesome@5.14.0/css/all.min.css">
	<title>userBoard</title>
</head>

<script>
	function selChange() {
		var sel = document.getElementById('cntPerPage').value;
		location.href="/project1982/user/userBoard.do?nowPage=${paging.nowPage}&cntPerPage="+sel;
	}
</script>
<style>
 .divTableHead:first-child {
  width: 10%;
}
.divTableHead:nth-child(2) {
  width: 30%;
}
.divTableHead:nth-child(3) {
  width: 10%;
}
.divTableHead:nth-child(4) {
  width: 10%;
}
.divTableHead:nth-child(5) {
  width: 10%;
}
.divTableHead:nth-child(6) {
  width: 15%;
}
.divTableHead:last-child {
  width: 15%;
}
</style>
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
<!-- -----------메인---------------- -->

<main>
	<div>
		<div class="main_title">고객센터</div>
		
		  <div style="margin-bottom:10px;">
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
	</div>
	

	
	   <!-- 게시판 시작 ----------------> 
	<div id="outer">
    	<div class="divTable minimalistBlack">
            <div class="divTableHeading"><!-- 제목 전체 -->
                <div class="divTableRow"><!-- 제목 내부 -->
                    <div class="divTableHead">번호</div>
                    <div class="divTableHead">제목</div>
                    <div class="divTableHead">작성자</div>
                    <div class="divTableHead">등록일</div>
                    <div class="divTableHead">조회수</div>
                    <div class="divTableHead">파일이름</div>
                    <div class="divTableHead">파일용량</div>

              	</div><!-- 제목내부 -->
            </div><!-- 제목 전체 -->
            <div class="divTableBody">
            	<c:forEach items="${boardList}" var="board">
                	<div class="divTableRow">   
                    	<div class="divTableCell">${board.b_id }</div>
                    	<div class="divTableCell" align="center"><a href="#" onclick="window.open('getBoard.do?b_id=${board.b_id}', '상세글보기','width=500;, height=500, resizable = no, scrollbars = no'); return false">
                        	${board.b_title }</a></div>
                    	<div class="divTableCell">${board.b_name }</div>
                    	<div class="divTableCell">${board.b_date }</div>
                    	<div class="divTableCell">${board.b_count }</div>
                    	<div class="divTableCell">
                        	<c:choose>
                        		<c:when test="${board.b_fsize==0}">첨부파일 없음</c:when>
                        			<c:otherwise>
                                		<img src="/project1982/resources/images/disk.gif">${board.b_fname}
                        			</c:otherwise>
                        	</c:choose>
                    	</div>
                    	<div class="divTableCell">${board.b_fsize}byte</div>
           
            		</div>
            	</c:forEach>
            </div>
		</div>
	</div>	
</main>

 <div style="display: block; text-align: center; margin-bottom: 100px; margin-top:20px;">		
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
    <br><a class="openboard" href="#" onclick="window.open('insertBoard.do', '새글등록','width=500;, height=500, resizable = no, scrollbars = no'); return false">새글 등록</a>
</div>

<form action='/project1982/user/userBoard.do' method='get'>
    <select name="searchCondition" id="" >
        <option value="b_title">제목</option>
        <option value="b_content">내용</option>
        <option value="b_name">작성자</option>
     </select>
     <input type='text' name='searchKeyword'>
     <input type='submit' value='검색'>
</form>

            



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