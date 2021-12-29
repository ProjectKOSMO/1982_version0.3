<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>11</title>
    <link type="text/css" href="/project1982/resources/css/2_login.css" rel="stylesheet"/>
</head>
<script>
	window.onload = function(){
		document.getElementById('Submit').onclick = check;	
	}
	
	function check(){
		if(document.loginform.userid.value==""){
			alert("ID를 입력하세요.")
			document.loginform.userid.focus();
			return false;
		}
		
		if(document.loginform.userpass.value==""){
			alert("패스워드를 입력하세요.")
			document.loginform.userpass.focus();
			return false;
		}
		
		document.loginform.submit();//전송
	}
</script>
<body>
	<form action="adminPage.do" method="post" id="login-form">
        <h1>1982 관리자</h1>
        <input name="supervisorId" type="text" placeholder="Username" />
        <input name="supervisorPw" type="password" placeholder="Password" />
        <input id="login" type="submit" value="로그인" />
        <div class="login_article">
            <a href="../main.do">1982 홈페이지</a>           
        </div>    
    </form>
</body>
</html>