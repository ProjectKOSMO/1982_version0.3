<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <title>user_register.jsp</title>
   	<link type="text/css" href="/project1982/resources/css/3_register.css" rel="stylesheet"/>
    <script type="text/javascript" src="/project1982/resources/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="/project1982/resources/js/SongEmail.js"></script>
	<script  src="/project1982/resources/js/js_userinput.js"></script>
	<script>
	
	function passConfirm() {
		
		var userpass = document.getElementById('userpass');					//비밀번호 
		var userpass2 = document.getElementById('userpass2');	//비밀번호 확인 값
		
		var confirmMsg = document.getElementById('confirmMsg');				//확인 메세지
		var correctColor = "#00ff00";	//맞았을 때 출력되는 색깔.
		var wrongColor ="#ff0000";	//틀렸을 때 출력되는 색깔
		
		if(userpass.value == userpass2.value){
			confirmMsg.style.color = correctColor;
			confirmMsg.innerHTML ="비밀번호 일치";
		}else{
			confirmMsg.style.color = wrongColor;
			confirmMsg.innerHTML ="비밀번호 불일치";
		}
	}

		 </script>
		 
	    
		<script  src="/project1982/resources/js/js_userinput.js">
		
		</script>
	</head>
	<body>

	    <section class="section1" id="section1">
	      <form action="userInsert.do" method="post" name="userinput" class="login-form">
	        <h1>1982 구직자 - 회원가입</h1>
	        
		        <input 
	                class="id_input" 
	                id = "userid" 
	                name="userid" 
	                type="text" 
	                placeholder="아이디를 입력하세요" 
	                onkeyup="IDConfirm()"/>
		        <span id="idCheckResult" style="width:250px; color:red"></span>
	        
	         
		        <input 
	                name="userpass" 
	                id= "userpass" 
	                type="password" 
	                placeholder="비밀번호를 입력하세요" />
		        <input 
	                name="userpass2" 
	                id = "userpass2" 
	                type="password" 
	                placeholder="비밀번호 확인" 
	                onkeyup="passConfirm()"/>
		         <span id ="confirmMsg"></span> 
		        
	        
	        	<input
	                class="username" 
	                name="username" 
	                id ="username" 
	                type="text" 
	                placeholder="이름을 입력하세요" />
	       		<input 
	                class="userbirth" 
	                name="userbirth" 
	                type="text" 
	                placeholder="생년월일 (ex:19960401)" />
	       	
	       	
		        <input 
	                name="usermail" 
	                class="mail_input" 
	                type="email" 
	                placeholder="이메일" />
		        <input 
	                type="button" 
	                class="mail_check_button" 
	                value="인증요청" />
		        <input 
	                name="phoneid" 
	                class="mail_check_input" 
	                disabled="disabled" 
	                type="text" 
	                placeholder="인증번호" />
	                	        <div id="mail_check_input_box_warn">인증을 요청하세요</div> <br/>
		        <div class="clearfix"></div>
		       
	            
	            
		        <input type="text" class="id_input" name="userpn"  placeholder="핸드폰 번호를 입력하세요" />
		        <input type="submit" id="register" disabled="disabled" value="가입" />
	            
	            
	        </form>


	    </section>
	</body>
	</html>