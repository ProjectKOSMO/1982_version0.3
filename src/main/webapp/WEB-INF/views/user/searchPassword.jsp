<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js" type="text/javascript"></script>
	<script src="/project1982/resources/js/searchPassword.js" type="text/javascript"></script>
</head>
<body>
<div>
	<h2 style="border-bottom:solid 2px black; width:90%;margin-left:5%;margin-rigth:5%;">비밀번호 찾기</h2>
	<form action="" name="search-password-form" style="width:90%;margin-left:5%;margin-rigth:5%;" >
		<table border="1" cellpadding="0" cellspacing="0" style="text-align: center;font-weight:bolder;font-family:italic;">
			<tr>
				<td bgcolor="#dee2e6" width="100">아이디</td>
				<td align="center"><input type="text" class="userId" name="userId"></td>
			</tr>
			<tr>
				<td bgcolor="#dee2e6">이메일</td>
				<td align="center"><input type="text" class="userMail" name="userMail"></td>
			</tr>
		</table>
	</form>
	<div style="margin:10px; margin-left:5%;">
		<button id="passwordSearch">인증번호 보내기</button>
	</div>
	<div style="width:90%;margin-left:5%;margin-rigth:5%;">
		<table border="1" cellpadding="0" cellspacing="0" style="text-align: center;font-weight:bolder;font-family:italic;">
			<tr>
				<td bgcolor="#dee2e6" width="100">인증번호</td>
				<td align="center"><input type="text" id="confirmNum" disabled="disabled"></td>
			</tr>
		</table>
		<a id="warn">- 이메일 확인 후 인증번호를 입력하세요.</a>
	</div>
	<div style="margin:10px;margin-top:5px; margin-left:5%;">
		<button id="passwordSend" disabled="disabled">비밀번호 보내기</button>
	</div>
</div>


<!-- 	<form action="" name="search-password-form">
		<a>아&nbsp&nbsp&nbsp이&nbsp&nbsp&nbsp디 : </a><input type="text" class="userId" name="userId"><br/>
		<a>이메일 주소 : </a><input type="text" class="userMail" name="userMail"><br/>
	</form>
		<button id="passwordSearch">인증번호 보내기</button><br/>
<br/>

<a>인증 번호 : </a><input type="text" id="confirmNum" disabled="disabled">
<a id="warn">인증번호를 입력하세요</a>
<br/>
<button id="passwordSend" disabled="disabled">비밀번호 보내기</button><br/> -->
</body>
</html>