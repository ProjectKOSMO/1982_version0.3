<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js" type="text/javascript"></script>
	<script src="/project1982/resources/js/OwnersearchPassword.js" type="text/javascript"></script>
</head>
<body>

<h1>비밀번호 찾기</h1>
<br/>
<br/>
<form action="" name="search-password-form">
<a>아&nbsp&nbsp&nbsp이&nbsp&nbsp&nbsp디 : </a><input type="text" class="userId" name="userId"><br/>
<a>이메일 주소 : </a><input type="text" class="userMail" name="userMail"><br/>
</form>
<button id="passwordSearch">인증번호 보내기</button><br/>
<br/>

<a>인증 번호 : </a><input type="text" id="confirmNum" disabled="disabled">
<a id="warn">인증번호를 신청하세요</a>
<br/>
<button id="passwordSend" disabled="disabled">비밀번호 보내기</button><br/>
</body>
</html>