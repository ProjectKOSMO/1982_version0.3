<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 찾기</title>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<div style="width:90%;margin-left:5%;margin-rigth:5%;">
	<h2 style="border-bottom:solid 2px black;width:90%;margin-left:5%;margin-rigth:5%;">아이디 찾기 완료</h2>
	<div style="width:90%;margin-left:5%;margin-rigth:5%;">
	<table id="mypageTable" border="2" style="text-align: center;">
	
		<tr>
			<th bgcolor="#dee2e6" width="150" >가입날짜</th>
			<th bgcolor="#dee2e6" width="150" >아이디</th>
		</tr>
		
	<c:forEach items="${userfindid}" var="ufi">
		<tr>
			<td>${ufi.userdate}</td>
			<td>${ufi.userid}</td>
		</tr>
	</c:forEach>
	</table>
	
	<div style="margin:10px; margin-left:16%;">
		<input type="submit" value="로그인하기" onclick="window.close();"/>
		<input type="submit" value="비밀번호찾기" onClick="location.href='searchPassword.do'"/>
	</div>
</div>
</div>
</body>
</html>