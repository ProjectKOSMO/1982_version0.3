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
    <title>adminPage.jsp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/FortAwesome/Font-Awesome@5.14.0/css/all.min.css">
	<link type="text/css" href="/project1982/resources/style/style.css" rel="stylesheet"/>
    <link type="text/css" href="/project1982/resources/style/header.css" rel="stylesheet"/>
<script src="/project1982/resources/js/Chart.min.js"></script>
</head>
<script src='../resources/js/reply.js' type="text/javascript"></script>
<script>
	function selChange() {
		var sel = document.getElementById('cntPerPage').value;
		location.href="/project1982/admin/admin_shopInfo.do?nowPage=${paging.nowPage}&cntPerPage="+sel;
	}
</script>
<body>
 

        <!--메뉴바  ------------------------------------------------->

        <header class="header" >
         <!-- 로고-->
            
            <a href="#" class="logo">
                <img src=""/>
            </a>
            
            <!--메뉴-->   
            <ul class="menu">
                <li><a href="admin_positing.do">구직자용</a></li>
                <li><a href="admin_storeClose.do">구인자용</a>
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
            <ul class="left_nav">
                <li class="left_nav_text"><a class="home" href="#">홈</a></li>
                <li class="left_nav_text"><a href="adminPage.do">블랙리스트 현황</a></li>
                <li class="left_nav_text"><a href="adminPage2.do">구독권 현황</a></li>
            </ul>

            <div class="body_container"> <!-- 페이지 컨테이너 시작-->
         
                <div class="body_container_center"> <!-- 중간 메뉴바 시작-->
                   
                    <div>서비스 이용 지표</div>
                    <div class="body_container_center_services">
                        <div class="service1">
<!-- 여기2 -->                            
                         

                            
                        </div>

                    </div>
                   
                   
                   
               
               <!--  회원가입 현황  -->
                    <div class="body_container_center_members">
       
                    </div>
<!-- 여기2 -->           
                     <div>사업자 매장 정보</div>
                     
                     <div>
                     <div class="divTable minimalistBlack">
                            <div class="divTableHeading">
                            <div class="divTableRow">
                            <div class="divTableHead">매장명</div>
                            <div class="divTableHead">매장 주소</div>
                            <div class="divTableHead">매장 연락처</div>
                            <div class="divTableHead">매장 소게</div>
                            <div class="divTableHead">등록일</div>
                            <div class="divTableHead">최근 수정일</div>
                            <div class="divTableHead">위도</div>
                            <div class="divTableHead">경도</div>
                            <div class="divTableHead">삭제</div>
                    </div>
                    </div>
                           <c:forEach items="${shopInfoList}" var="shopInfoList">
                            <div class="divTableBody">
                            <div class="divTableRow">
                            <div class="divTableCell"><form action='#' method='post'><input type='hidden' name="shopName" value='${shopInfoList.shopName}'>${shopInfoList.shopName}</div>
                            <div class="divTableCell"><input type='hidden' name="shopaddr" value='${shopInfoList.shopaddr}'>${shopInfoList.shopaddr}</div>
                            <div class="divTableCell"><input type='hidden' name="shoppn" value='${shopInfoList.shoppn}'>${shopInfoList.shoppn}</div>
                            <div class="divTableCell"><input type='hidden' name="shopcontent" value='${shopInfoList.shopcontent}'>${shopInfoList.shopcontent}</div>
                            <div class="divTableCell"><input type='hidden' name="shopdate" value='${shopInfoList.shopdate}'>${shopInfoList.shopdate}</div>
                            <div class="divTableCell"><input type='hidden' name="shopupdate" value='${shopInfoList.shopupdate}'>${shopInfoList.shopupdate}</div>
                            <div class="divTableCell"><input type='hidden' name="location_x" value='${shopInfoList.location_x}'>${shopInfoList.location_x}</div>
                            <div class="divTableCell"><input type='hidden' name="location_y" value='${shopInfoList.location_y}'>${shopInfoList.location_y}</div>
                            
                            <div class="divTableCell"><input type='Submit' value='데이터 삭제'></div></form>
                          </div>
                          </div>
                          
                         </c:forEach>
                         <div style="display: block; text-align: center;">		
							<c:if test="${paging.startPage != 1 }">
								<a href="/project1982/admin/admin_shopInfo.do?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
							</c:if>
							<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
								<c:choose>
									<c:when test="${p == paging.nowPage }">
										<b>${p }</b>
									</c:when>
									<c:when test="${p != paging.nowPage }">
										<a href="/project1982/admin/admin_shopInfo.do?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
									</c:when>
								</c:choose>
							</c:forEach>
							<c:if test="${paging.endPage != paging.lastPage}">
								<a href="/project1982/admin/admin_shopInfo.do?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
							</c:if>
						</div>
                        </div>
                        </div>              
                </div><!--중간 메뉴바 종료-->
               
            
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
                            <a>

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