<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ownersub 페이지</title>
     
    <link type="text/css" href="/project1982/resources/css/10_ownersub.css" rel="stylesheet"/>
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
  <!-- iamport.payment.js -->
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.7.js"></script>
    
    
</head>
	<% 
	Integer ownernum = (Integer)session.getAttribute("ownernum");
	out.println("현재 번호 : " + ownernum);
%>

	
	
	

<body>
<%-- 	<div class="hide">${ownerBoardList[0].ownernum }</div>
 --%>	
	
	<!-- <form action="" method="post" id="login-form" name=""> -->
		<h1>구독권 결제</h1>
		<div class="center">
		
			<div class="right">
				   
					<div class="list">
						<div class="box">
							<h1>30</h1>
							<h3>day</h3>
							<p>50,000원</p>
							<button class="box_button check30">Buy</button>
						</div>
						<div class="box">
							<h1>60</h1>
							<h3>day</h3>
							<p>90,000원</p>
							<button class="box_button check60">Buy</button>
						</div>
						<div class="box">
							<h1>90</h1>
							<h3>day</h3>
							<p>135,000원</p>
							<button class="box_button check90">Buy</button>
						</div>
						<div class="box">
							<h1>184</h1>
							<h3>day</h3>
							<p>260,000원</p>
							<button class="box_button check184">Buy</button>
						</div>
						<div class="box">
							<h1>365</h1>
							<h3>day</h3>
							<p>500,000원</p>
							<button class="box_button check365">Buy</button>
						</div>	
							
					</div>
			
			</div>
		</div>     
	
	<!-- </form> -->
		<div  class="return">
			<button class="box_button" type="button" class="navyBtn" onClick="location.href='ownerMypage.do'">돌아가기</button>
		</div>
		 
		 
	<script type="text/javascript">
	
	$(document).ready(function(){
	   var pay = 5;
	   console.log(pay);
	   	
		var IMP = window.IMP;
		var code = "imp38743974"; //가맹점 식별코드
		IMP.init(code);
		
		

		$('.check30, .check60, .check90, .check184, .check365').click(function(e){
		  var name_var = 'init';
		  var amount_var = 0;
		  var pay_date_var = new Date();
		  var coupon_type_var = 0;
		  		  
		  if($(this).attr("class") == 'box_button check30'){
		  	  name_var = "30일 구독권";
		  	amount_var = 50000;
		  	coupon_type_var = 1;
		  	pay_date_var.setDate(pay_date_var.getDate()+30);
		  }else if($(this).attr("class") == 'box_button check60'){
		  	name_var = "60일 구독권";
		  	amount_var = 90000;
		  	coupon_type_var = 2;
		  	pay_date_var.setDate(pay_date_var.getDate()+60);
		  }else if($(this).attr("class") == 'box_button check90'){
			  	name_var = "90일 구독권";
			  	amount_var = 135000;
			  	coupon_type_var = 3;
				pay_date_var.setDate(pay_date_var.getDate()+90);
		  }else if($(this).attr("class") == 'box_button check184'){
			  name_var = "184일 구독권";
			  amount_var = 260000;
			  coupon_type_var = 4;
				pay_date_var.setDate(pay_date_var.getDate()+184);
		  }else if($(this).attr("class") == 'box_button check365'){
		  	  name_var = "365일 구독권";
		  	amount_var = 500000;
		  	coupon_type_var = 5;
			pay_date_var.setDate(pay_date_var.getDate()+365);
		  }
		  

		  	
		  //결제요청
		  IMP.request_pay({ // param
          pg: "TC0ONETIME",
          pay_method: "card",
          // merchant_uid: "ORD20180131-0000012",
          // name: "30일 구독권",
          name : name_var,
          
          amount: amount_var,
          // buyer_email: "gildong@gmail.com",
           // buyer_name: "홍길동",
           // buyer_tel: "010-4242-4242",
           // buyer_addr: "서울특별시 강남구 신사동",
           // buyer_postcode: "01181"
      }, function(rsp){
				if(rsp.success){//결제 성공시
					var msg = '결제가 완료되었습니다';
					var result = {
					 //"imp_uid" : rsp.imp_uid,
					 //"merchant_uid" : rsp.merchant_uid,
					//"biz_email" : 'df',
					"pay_date" : new Date().getTime(),
					"pay_date_end" : pay_date_var.getTime(),
					"amount" : rsp.paid_amount,
					"coupon_type" : coupon_type_var
					// "ownernum" : sessionStorage.getItem("ownernum")
					 // "card_no" : rsp.apply_num,
					 // "refund" : 'payed'
					}
					console.log("결제성공 " + msg);
					$.ajax({
						url : '../insertPayCoupon.do', 
				        type :'POST',
				        data : JSON.stringify(result,
				        		[ 
				        			//'imp_uid', 
				        			// 'merchant_uid', 
				        			//'biz_email', 
				        			'pay_date', 
				        			'amount', 
				        			 // 'card_no', 
				        			 // 'refund', 
				        			'pay_date_end',
				        			'coupon_type'
				        			//'ownernum'
				        			]),
				        contentType:'application/json;charset=utf-8',
				        dataType: 'json', //서버에서 보내줄 데이터 타입
				        success: function(res){
				        			        	
				          if(res == 1){
							 console.log("추가성공");
							 alert("결제가 성공했습니다.")
							 window.location.href = '/project1982/owner/job_positing.do';
				          }else{
				             console.log("Insert Fail!!!");
				          }
				        },
				        error:function(){
				          console.log("Insert ajax 통신 실패!!!");
				        }
					}) //ajax
					
				}
				else{//결제 실패시
					var msg = '결제에 실패했습니다';
					msg += '에러 : ' + rsp.error_msg
				}
				console.log(msg);
			});//pay
		}); //check1 클릭 이벤트
		 
	}); //doc.ready
		</script>
	
	</body>
	
	


	
	</html>