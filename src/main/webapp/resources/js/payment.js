$(document).ready(function(){
	   var pay = 5;
	   console.log(pay);
	   	
		var IMP = window.IMP;
		var code = "imp38743974"; //가맹점 식별코드
		IMP.init(code);

		$('.check30, .check60, .check90, .check184, .check365').click(function(e){
		  var name_var = 'init';
		  var amount_var = 0;
		  var pay_date_var;
		  
		  if($(this).attr("class") == 'check30'){
		  	  name_var = "30일 구독권";
		  	amount_var = 50000;
		  	pay_date_var = new Date();
		  	pay_date_var.setDate(pay_date_var.getDate()+30);
		  }else if($(this).attr("class") == 'check60'){
		  	name_var = "60일 구독권";
		  	amount_var = 90000;
			pay_date_var = new Date();
			pay_date_var.setDate(pay_date_var.getDate()+60);
		  }else if($(this).attr("class") == 'check90'){
			  	name_var = "90일 구독권";
			  	amount_var = 135000;
				pay_date_var = new Date();
				pay_date_var.setDate(pay_date_var.getDate()+90);
		  }else if($(this).attr("class") == 'check184'){
			  name_var = "184일 구독권";
			  amount_var = 260000;
				pay_date_var = new Date();
				pay_date_var.setDate(pay_date_var.getDate()+184);
		  }else if($(this).attr("class") == 'check365'){
		  	  name_var = "365일 구독권";
		  	amount_var = 500000;
			pay_date_var = new Date();
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
					// "imp_uid" : rsp.imp_uid,
					// "merchant_uid" : rsp.merchant_uid,
					"biz_email" : 'df',
					"pay_date" : new Date().getTime(),
					"pay_date_end" : pay_date_var.getTime(),
					"amount" : rsp.paid_amount,
					"ownernum" : sessionStorage.getItem("ownernum") 
					// "card_no" : rsp.apply_num,
					// "refund" : 'payed'
					}
					console.log("결제성공 " + msg);
					$.ajax({
						url : 'insertPayCoupon.do', 
				        type :'POST',
				        data : JSON.stringify(result,
				        		[// 'imp_uid', 
				        			// 'merchant_uid', 
				        			'biz_email', 
				        			'pay_date', 
				        			'amount', 
				        			// 'card_no', 
				        			// 'refund', 
				        			'pay_date_end',
				        			'ownernum']),
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