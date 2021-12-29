<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
	/* 	if(document.loginform.userid.value!="userid"){
			alert("ID가 틀립니다..")
			document.loginform.userid.focus();
			return false;
		} */
		
		if(document.loginform.userpass.value==""){
			alert("패스워드를 입력하세요.")
			document.loginform.userpass.focus();
			return false;
		}
		/* if(document.loginform.userpass.value!="userpass"){
			alert("비밀번호가 틀립니다.")
			document.loginform.userpass.focus();
			return false;
		} */
		document.loginform.submit();//전송
	}
</script>

<body>

    <form name="loginform" action="login.do" method="post" id="login-form">
        <h1>1982 구직자</h1>
        <input name="userid" type="text" placeholder="Username" />
        <input name="userpass" type="password" placeholder="Password" />
        <input type="submit" id="Submit" name="Submit" value="로그인" />
        <div class="login_article">
            <a href="#">아이디 |</a>
            <a href="#">비밀번호찾기 |</a>
            <a href="user_register.do">회원가입</a>
        </div>    
    </form>



    <script
   src="https://kit.fontawesome.com/6478f529f2.js"
   crossorigin="anonymous"
   ></script>

</body>
</html>
