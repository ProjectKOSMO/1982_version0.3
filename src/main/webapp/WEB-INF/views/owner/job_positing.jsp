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
    <title>job_positing.jsp</title>              
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/FortAwesome/Font-Awesome@5.14.0/css/all.min.css">

	<link type="text/css" href="/project1982/resources/style/style_job_position.css" rel="stylesheet"/>
    <link type="text/css" href="/project1982/resources/style/header_job_position.css" rel="stylesheet"/>
</head>

<style type="text/css">
/* boardcss_list 에서 사용되는 글 등록 버튼 테이블 크기 */
#boardcss_list_add_button_table { width: 100%; margin: 0 auto 15px; /*position: relative; background: #bddcff; font-weight: bold;*/ }

/* 화면에 보여지는 글 등록 버튼 */
#boardcss_list_add_button_table .add_button { cursor: pointer; border: 1px solid #bebebe; position: absolute; right: 10px; top: 10px; width: 85px; padding: 6px 0 6px; text-align: center; font-weight: bold; }
#boardcss_list_add_button_table .add_button a { color: #ffffff; }

/* 글 등록 버튼과 글 목록이 겹치지 않게 만들어준 아무것도 아닌것 */
#boardcss_list_add_button_table .boardcss_list_add_button ul { width: 100%; overflow: hidden; height: 10px;}

/* boardcss_list 에서 사용하는 글 목록 테이블 크기*/
.boardcss_list_table { width: 100%; }

/* 화면에 보여지는 글 목록 테이블 */
.list_table { width: 100%; }

/* 화면에 보여지는 caption */
.list_table caption { display: none; }

/* list_table 에서 사용되는 thead */
.list_table thead th { text-align: center; border-top: 1px solid #e5e5e5; border-bottom: 1px solid #e5e5e5; padding: 8px 0; background: #faf9fa; }

/* list_table 에서 사용되는 tbody */
.list_table tbody td { text-align: center;  border-bottom: 1px solid #e5e5e5; padding: 5px 0; }

</style>


<body>
 <% 
	String ownerid = (String)session.getAttribute("ownerid");
	int ownernum = (int)session.getAttribute("ownernum");
	out.println(ownerid + " 님 환영합니다.");
	out.println(ownernum + " 님 환영합니다.");
	
%>

        <!--메뉴바  ------------------------------------------------->
        <header class="header">
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
                   <a href="/project1982/board.do">
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
            <ul class="left_nav">
                <li class="left_nav_text"><a class="home" href="#"></a></li>
                <li class="left_nav_text"><a href="#" class="home">프로필 수정</a></li>
                <li class="left_nav_text"><a href="#" class="home">업체지원현황</a></li>
                <li class="left_nav_text"><a href="#" class="home">입출금 내역</a></li>
            </ul>


            <div class="body_container">
                <!-- 페이지 컨테이너 시작-->

                

                <form action="ownerBoardInsert.do" method="post">

                <div class="main_title">구인공고</div>
                    <div class="body_container_center">
                        <!-- 중간 메뉴바 시작-->
                        <div>
                            <div class="main_font">나의 매장 :
                                <input class="input_box" type="text" value="${shopList[0].shopName}" disabled>                
								<input class="hide" type="text" name="shopname" value="${shopList[0].shopName }">		
                            </div>
                            <div class="main_font">근무 날짜 :
                                <input type="date" name="jobDate" class="select_css"
	      						 value="2021-12-30" min="2021-12-21" max="2022-12-20">
                            </div>
                            <div class="main_font">근무 시작 시간 :
                                <input type="time" id="jobStart" name="jobTime_start" class="select_css"
                                    value="15:00:00">
                            </div>
                             <div class="main_font salary">주소 :
                                 <input class="input_box" type="text" value="${shopList[0].shopaddr }" style="width:100%" disabled>
                                 <input class="hide" type="text" name="shopaddr" value="${shopList[0].shopaddr }">
                            </div>
                            <div class="main_font">근무 종료 시간 :
                                <input type="time" id="jobEnd" name="jobTime_end" class="select_css" value="23:00:00">
                            </div>
                            <div class="main_font salary">급여 :
                                <input class="input_box" type="text" name="shoppay" placeholder=" 상세하게 적어주세요">
                            </div>
                            <div class="main_font">연락처 :
                                <input class="input_box" type="text" value="${shopList[0].shoppn }" disabled>
                                <input class="hide" type ="text" name="shoppn" value="${shopList[0].shoppn }" >
                            </div>
                            <div class="main_font">필요인원 :
                                <input class="input_box" type="text" name="need_Num" placeholder=" 내용을 입력해주세요">
                            </div>
                            <div class="main_font">상세내용 :

                                <textarea name="content" id="" cols="30" rows="10" style="resize:none;"></textarea>
                            </div>
                            
                            <div class="hide">
                            <input class="" type="text" name="ownernum" value="${ownernum }">
                            </div>
                                                        
                        </div>

                        <div class="main_button">
                        	<input type="submit" name="normal_emergency" class="button1" value="긴급알바"> 
                        	<input type="submit" name="normal_emergency" class="button2" value="일일알바">
                        </div>
                     

            </div>
                            </form>
            
            <!--중간 메뉴바 종료-->


            <!-- <form name = "boardFrom" action = "getBoardList.do">
	<input type=submit value = "쓰기">
</form>
<script>
	document.boardFrom.submit();
</script> -->

            <div class="boardcss_list_table">

                <c:if test="${ownerBoardList != null}">
                    <table class="list_table">
                    <thead>
                        <tr>
                            <th width="10%">번호</th>
                            <th width="10%">긴급 / 일일</th>
                            <th width="15%">매장 이름</th>
                            <th width="20%">날짜</th>
                            <th width="10%">필요 인원</th>
                            <th width="10%">공고취소</th>
                        </tr>
                    </thead>
                    
                        <c:forEach items="${ownerBoardList }" var="boardList">
                            <tr>
                                <td>${boardList.board_owner_seq }</td>
                                <td>${boardList.normal_emergency }</td>
                                <td>${boardList.shopname }</td>
                                <td>${boardList.jobDate}</td>
                                <td>${boardList.need_Num }</td>
                                <td>취소</td>

                            </tr>
				                            
                        </c:forEach>
                    </table>
                </c:if>

            </div>
                              

			

            </div><!-- 페이지 컨테이너 종료 -->

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