<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>owner_register.jsp</title>
    <link type="text/css" href="/project1982/resources/css/3_register.css" rel="stylesheet"/>
    <script type="text/javascript" src="/project1982/resources/js/jquery-1.7.1.js"></script>
	<script  src="/project1982/resources/js/js_ownerinput.js"></script>
	
	<script type="text/javascript">
	function passConfirm() {
	
	var ownerpass = document.getElementById('ownerpass');					//비밀번호 
	var ownerpass2 = document.getElementById('ownerpass2');	//비밀번호 확인 값
	
	var confirmMsg = document.getElementById('confirmMsg');				//확인 메세지
	var correctColor = "#00ff00";	//맞았을 때 출력되는 색깔.
	var wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔
	
	if(ownerpass.value == ownerpass2.value){
		confirmMsg.style.color = correctColor;
		confirmMsg.innerHTML ="비밀번호 일치";
	}else{
		confirmMsg.style.color = wrongColor;
		confirmMsg.innerHTML ="비밀번호 불일치";
	}
}
</script>
</head>
<body>
	<form action="ownerInsert.do" method="get" name="ownerinput" class="login-form">
        <h1>1982 사업자 - 회원가입</h1>
        <div>
	        <input class="id_input" id="ownerid" name="ownerid" type="text" placeholder="아이디를 입력하세요" />
	        <span id="idCheckResult" style="width:150px;color:red"></span>
        </div>
	        <input name="ownerpass" id="ownerpass" type="password" placeholder="비밀번호를 입력하세요" />
	        <input name="ownerpass2" id="ownerpass2" type="password" placeholder="비밀번호 확인" onkeyup="passConfirm()"/>
        	<span id ="confirmMsg"></span>
        <div>
       		<input class="ownername" name="ownername" id="ownername" type="text" placeholder="이름을 입력하세요" />
	        <input class="id_input" name="ownerpn" id="ownerpn" type="text" placeholder="핸드폰 번호를 입력하세요" />
	        <input type="submit" value="인증요청" />
        </div>
	        <input name="ownerpn" type="password" placeholder="인증번호" />
	        <input name="ownermail" id ="ownermail" placeholder="이메일" />
	        <input type="submit" name="confirm" id="confirm" value="가입" />

      </form>
</body>
</html>