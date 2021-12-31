var code="";

$(function(){
	$(".mail_check_button").click(function(){
		var email = $(".mail_input").val();
		var checkBox=$(".mail_check_input");
		
		$.ajax({
			type: "GET",
			url : "../mailCheck?email="+email,
			success:function(data){
				console.log("data : "+data);
				
				checkBox.attr("disabled",false);
				
				code=data;
			}
		})
	})
	
	
	$(".mail_check_input").keyup(function(){
		
		inputNum=$(".mail_check_input").val();
	
		if(inputNum==code){
			$("#mail_check_input_box_warn").text("인증번호가 일치합니다.");
		}else{
			$("#mail_check_input_box_warn").text("인증번호가 불일치합니다.");
		}
	})
})