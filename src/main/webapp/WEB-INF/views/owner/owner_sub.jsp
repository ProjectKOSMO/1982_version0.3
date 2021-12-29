<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ownersub 페이지</title>
    <link type="text/css" href="/project1982/resources/css/10_ownersub.css" rel="stylesheet"/>
</head>

<body>

<div class="hide">${ownerBoardList[0].ownernum }</div>


<form action="" method="post" id="login-form" name="">
	<h1>구독권 결제</h1>
	<div class="center">
	
        <div class="right">
       		구독 기간:
        		<div class="list">
        			<button>30일</button>	
        			<button>60일</button>	
        			<button>90일</button>	
        			<button>150일</button>	
        			<button>360일</button>	
        		</div>
        
        </div>
	</div>     

</form>
	<div  class="return">
		<button type="button" class="navyBtn" onClick="location.href='ownerMypage.do'">돌아가기</button>
	</div> 
</body>
</html>