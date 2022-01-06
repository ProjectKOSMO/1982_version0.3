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
	
	if(document.findidform.ownername.value==""){
		alert("이름을 입력하세요.")
		document.findidform.ownername.focus();
		return false;
	}
	
	if(document.findidform.ownermail.value==""){
		alert("이메일을 입력하세요.")
		document.findidform.ownermail.focus();
		return false;
	}
	
	if(document.findidform.ownerpn.value==""){
		alert("가입시 저장한 휴대폰 번호를 입력하세요.")
		document.findidform.ownerpn.focus();
		return false;
	}
	document.findidform.action="findId.do";
	document.findidform.submit();//전송
};
</script>
<body>
<div>
	<h2 style="border-bottom:solid 2px black; width:90%;margin-left:5%;margin-rigth:5%;">아이디 찾기</h2>
	<form name="findidform" method="POST" style="width:90%;margin-left:5%;margin-rigth:5%;" >
		<table border="1" cellpadding="0" cellspacing="0" style="text-align: center;font-weight:bolder;font-family:italic;">
			<tr>
				<td bgcolor="#dee2e6" width="100">가입자이름</td>
				<td align="center"><input name="ownername" id="ownername" type="text"/></td>
			</tr>
 			<tr>
				<td bgcolor="#dee2e6">이메일</td>
				<td align="center"><input name="ownermail" id="ownermail" type="text"/></td>
			</tr>
			<tr>
				<td bgcolor="#dee2e6">휴대폰번호</td>
				<td align="center"><input name="ownerpn" id="ownerpn" type="text"/></td>
			</tr>
		</table>
		<div style="margin:10px; margin-left:14%;">
			<input type="submit" id="findId" value="아이디 찾기" />
			<input type="submit" value="취소" onclick="window.close();"/>
		</div>
	</form>
</div>
</body>
</html>