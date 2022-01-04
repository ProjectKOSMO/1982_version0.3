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
            
            $("#mail_check_input_box_warn").text("인증번호를 입력하세요.");
            code=data;
            
            alert("인증 번호를 보냈습니다.");
         }
      })
   })
   
   
   $(".mail_check_input").keyup(function(){
      
      inputNum=$(".mail_check_input").val();
   
      if(inputNum==code){
         $("#mail_check_input_box_warn").text("인증번호가 일치합니다.");
         $("#mail_check_input_box_warn").css("color","#00ff00");
         $("#register").attr("disabled",false);
         $("#confirm").attr("disabled",false);
      }else{
         $("#mail_check_input_box_warn").text("인증번호가 불일치합니다.");
         $("#mail_check_input_box_warn").css("color","#ff0000");
         $("#register").attr("disabled",true);
         $("#confirm").attr("disabled",true);
      }
  
   })
})