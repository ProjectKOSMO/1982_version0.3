<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세</title>
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
        background-color: rgb(89, 168, 236);
        border-radius: 5px;
        display: flex;
        justify-content: center;
        align-items: center;
        
    }
    .button2{
        width: 60px;
        height: 40px;
        background-color: rgb(89, 168, 236);
        border-radius: 5px;
        display: flex;
        justify-content: center;
        align-items: center;
        
        margin-left: 20px;
    }
</style>
<script>
	$(document).ready(function(){
		
		$('#update1').on("click",function(){
			var params = $("#updateform").serialize();
			$.ajax({
				type : 'post',
				url : "../user/updateBoard.do",
				data : params,
				success : function(){
				}
			})
			alert("수정이 완료되었습니다")
			self.close();
			});
			
		$('#delete').on("click",function(){
			$.ajax({
				type : 'delete',
				url : "../user/deleteBoard.do?b_id=${board.b_id}",
				success : function(){
				}
			})
			alert("삭제가 완료되었습니다")
			self.close();
			});
		});
</script>
<body>
		<h1>글 상세</h1>		
		<hr>
		<form id="updateform" name="update" method="put">
			<input name="b_id" type="hidden" value="${board.b_id}" />
			<table border="1" cellpadding="0" cellspacing="0">
                <div class="wrap">
                    <label for="">제목</label>
                    <input name="b_title" type="text" value="${board.b_title }" />
                </div>
                <div class="wrap">
                    <label for="">작성자</label>
                    <input name="b_name" type="text" value="${board.b_name }" />
                </div>
                <div class="wrap">
                    <label for="">내용</label>
                    <textarea name="b_content" cols="40" rows="10">${board.b_content }</textarea>
                </div>
                <div class="wrap">
                    <label for="">등록일</label>
                    <input name="b_date" type="text" value="${board.b_date }" />
                </div>
                <div class="wrap">
                    <label for="">조회수</label>
                    <input name="b_count" type="text" value="${board.b_count }" />
                </div>
                
			
			
				<!-- #### 첨부파일을 보여주고자 한다면 -->
				<c:if test="${board.b_realfname != null}">
				<tr>
					<td colspan="2" align="center">
					<img src="/project1982/resources/upload/${board.b_realfname}" width='500' height='400'>
					<a download='${board.b_fname}' href='/project1982/resources/upload/${board.b_realfname}'>${board.b_fname}</a>
					</td>
				</tr>
				</c:if>
			</table>
		</form>
		<hr>
        <div class="wrap_button">
            <div class="button1">
		        <a href="#" onclick="window.close()">닫기</a>
            </div>
            <div class="button2">    
		        <a href="#" id="delete">삭제</a>
            </div>
        </div>


</body>
</html>
