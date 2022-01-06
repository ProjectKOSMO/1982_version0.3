<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>새글등록</title>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="/project1982/resources/js/userview.js"></script>
</head>
<style>
    @import url('https://fonts.googleapis.com/css2?family=Cute+Font&family=Gamja+Flower&family=Gowun+Dodum&family=Noto+Sans:ital@0;1&family=Noto+Serif+KR:wght@400;500;600&family=Single+Day&display=swap');

    h1{
        font-family: 'Gowun Dodum', sans-serif;
    }

    label{
        font-weight: 700;
        font-family: 'Gowun Dodum', sans-serif;
        font-size: 20px;
        margin:5px 0;
    }
    .wrap{
        display: flex;
        flex-direction: column;   
    }
    input{
        border: 1px solid rgba(0,0,0,0.3);
        border-radius: 5px;
        height: 30px;
    }
    textarea{
        border: 1px solid rgba(0,0,0,0.3);
        border-radius: 5px;
        color:rgba(0,0,0,0.5);
    }
    a{
        text-decoration: none;
        color: white;
    }
    .wrap_button{
        display: flex;
        justify-content: center;

    }
    .button1{
        width: 60px;
        height: 40px;
        background-color: rgb(16, 139, 246);
        border-radius: 5px;
        display: flex;
        justify-content: center;
        align-items: center;
        
    }
    .button2{
        width: 70px;
        height: 50px;
        background-color: rgb(16, 139, 246);
        border-radius: 5px;
        display: flex;
        justify-content: center;
        align-items: center;
        
        margin-left: 20px;
    }
    .button3{
        margin-top: 20px;
        display: flex;
        justify-content: center;
        cursor: pointer;
    }
    input[type=submit]{
        background-color: rgb(16, 139, 246);
        color: white;
        border: none;
    }
</style>
<script>
	$(document).ready(function(){
		$('#save1').on("click",function(){
			var param = $("#boardform").serialize();
			$.ajax({
				type : 'post',
				url : "../user/saveBoard.do",
				data : param,
				success : function(){
				}
			})
			alert("새글 등록이 완료되었습니다")
			self.close();
		});
	});
</script>
<body>
		<h1>글쓰기</h1>		
		<hr>
		<form method="POST" name="save" id="boardform" enctype="multipart/form-data"> <!--  enctype="multipart/form-data" -->
			<table border="1" cellpadding="0" cellspacing="0">
                <div class="wrap">
                    <label for="">제목</label>
                    <input name="b_title" type="text" placeholder="제목을 입력하세요"/>
                </div>
                <div class="wrap">
                    <label for="">작성자</label>
                    <input type="text" name='b_name' size="10" value="${userId}"/>
                </div>
                <div class="wrap">
                    <label for="">내용</label>
                    <textarea name="b_content" cols="40" rows="10">내용을 입력하세요</textarea>
                </div>
                <div class="wrap">
                    <label for="">이메일</label>
                    <input type="text" name='b_email'/ placeholder="이메일을 입력하세요">
                </div>
                <div class="wrap">
                    <label for="">파일추가</label>
                    <input type="file" name='file' maxlength="60" size="40">
                </div>   
					<!-- name="file"은 BoardVO 안에 File file 선언한 이름과 동일해야 함  -->

				<div class="button3">
					<input type="submit" id="save1"	value=" 새글 등록 " />
                </div>    

			</table>
		</form>
</body>
</html>