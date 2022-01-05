<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 찾기</title>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<script>
	window.onload = function(){
	document.getElementById('findId').onclick = findId;	
		}
	
	function findId(){
	
	if(document.findidform.username.value==""){
		alert("이름을 입력하세요.")
		document.findidform.username.focus();
		return false;
	}
	
	if(document.findidform.userbirth.value==""){
		alert("생년월일을 입력하세요.")
		document.findidform.userbirth.focus();
		return false;
	}
	
	if(document.findidform.usermail.value==""){
		alert("이메일을 입력하세요.")
		document.findidform.usermail.focus();
		return false;
	}
	
	if(document.findidform.userpn.value==""){
		alert("가입시 저장한 휴대폰 번호를 입력하세요.")
		document.findidform.userpn.focus();
		return false;
	}
	
	document.findidform.submit();//전송
};
</script>
<body>
<div>
	<h2 style="border-bottom:solid 2px black; width:90%;margin-left:5%;margin-rigth:5%;">아이디 찾기</h2>
	<form action="findId.do" name="findidform" method="POST" style="width:90%;margin-left:5%;margin-rigth:5%;" >
		<table border="1" cellpadding="0" cellspacing="0" style="text-align: center;font-weight:bolder;font-family:italic;">
			<tr>
				<td bgcolor="#dee2e6" width="100">가입자이름</td>
				<td align="center"><input name="username" id="username" type="text"/></td>
			</tr>
			<tr>
				<td bgcolor="#dee2e6">생년월일</td>
				<td align="center"><input name="userbirth" id="userbirth" type="text""/></td>
			</tr>
 			<tr>
				<td bgcolor="#dee2e6">이메일</td>
				<td align="center"><input name="usermail" id="usermail" type="text"/></td>
			</tr>
			<tr>
				<td bgcolor="#dee2e6">휴대폰번호</td>
				<td align="center"><input name="userpn" id="userpn" type="text"/></td>
			</tr>
		</table>
		<div style="margin:10px; margin-left:3%;">
			<input type="submit" id="findId" value="아이디 찾기" />
			<input type="submit" value="비밀번호 찾기" onclick="window.close();"/>
			<input type="submit" value="취소" onclick="window.close();"/>
		</div>
	</form>
</div>
</body>
</html>