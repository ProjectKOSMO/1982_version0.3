var code="";

$(function(){
	$("#passwordSearch").click(function(){
		
		$.ajax({
			type: "POST",
			url : "../OwnpasswordSearch",
			data: $("form[name=search-password-form]").serialize(),
			dataType:'text',
			success:function(data){
				if(data!="a"){
				// alert(data);
				
				$("#confirmNum").attr("disabled",false);
				
				$("warn").text("인증번호를 입력하세요.");
				code=data;
				
				alert("인증 번호를 보냈습니다.");
				}else{alert("아이디나 이메일이 틀렸습니다");}
			}
		})
	})
	
	
	$("#confirmNum").keyup(function(){
      
      inputNum=$("#confirmNum").val();
   
      if(inputNum==code){
         $("#warn").text("인증번호가 일치합니다.");
         $("#warn").css("color","#00ff00");
         $("#passwordSend").attr("disabled",false);
      }else{
         $("#warn").text("인증번호가 불일치합니다.");
         $("#warn").css("color","#ff0000");
         $("#passwordSend").attr("disabled",true);
      }
  
	})
	
		$("#passwordSend").click(function(){
		
		$.ajax({
			type: "POST",
			url : "../OwnpasswordSend",
			data: $("form[name=search-password-form]").serialize(),
			dataType:'text',
			success:function(data){
				alert(data);
				
			}
		})
	})
})