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
				<tr>
					<td bgcolor="#dee2e6" width="70">제목</td>
					<td align="left"><input name="b_title" type="text"
						value="${board.b_title }" /></td>
				</tr>
				<tr>
					<td bgcolor="#dee2e6">작성자</td>
					<td align="left">${board.b_name }</td>
				</tr>
				<tr>
					<td bgcolor="#dee2e6">내용</td>
					<td align="left"><textarea name="b_content" cols="40" rows="10">${board.b_content }</textarea></td>
				</tr>
				<tr>
					<td bgcolor="#dee2e6">등록일</td>
					<td align="left">${board.b_date }</td>
				</tr>
				<tr>
					<td bgcolor="#dee2e6">조회수</td>
					<td align="left">${board.b_count }</td>
				</tr>
				<!-- #### 첨부파일을 보여주고자 한다면 -->
				<c:if test="${board.b_realfname != null}">
				<tr>
					<td colspan="2" align="center">
					<%-- <img src="resources/upload/${board.b_fname}" width='500' height='400'> --%>
					<a download='${board.b_fname}' href='/project1982/resources/upload/${board.b_realfname}'>${board.b_fname}</a>
					</td>
				</tr>
				</c:if>
				<tr>
<!-- 				<td bgcolor="orange">비밀번호</td>
					<td align="left"><input name="b_pwd" type="text"/></td> -->
					<c:if test="${board.b_name == userId}">
						<td colspan="2" align="center"><input type="submit" id="update1" value="글 수정" /></td>
					</c:if>
				</tr>
				
				
			</table>
		</form>
		<hr>
		<a href="#" onclick="window.open('insertBoard.do', '새글등록','width=500;, height=500, resizable = no, scrollbars = no'); return false">글 등록</a>&nbsp;&nbsp;&nbsp; 
		<c:if test="${board.b_name == userId}">
		<a href="#" id="delete">글삭제</a>&nbsp;&nbsp;&nbsp;
		</c:if>
</body>
</html>
