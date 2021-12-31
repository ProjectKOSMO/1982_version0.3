<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>새글등록</title>
</head>
<body>
		<h1>글 등록</h1>		
		<hr>
		<form action="saveBoard.do" method="post" enctype="multipart/form-data"> <!--  enctype="multipart/form-data" -->
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="#dee2e6" width="70">제목</td>
					<td align="left"><input type="text" name='b_title'/></td>					
				</tr>
				<tr>
					<td bgcolor="#dee2e6">작성자</td>
					<td align="left"><input type="text" name='b_name' size="10" value="${userId}"/></td>
				</tr>
				<tr>
					<td bgcolor="#dee2e6">내용</td>
					<td align="left"><textarea cols="40" name='b_content' rows="10"></textarea></td>
				</tr>
				<tr>
					<td bgcolor="#dee2e6">이메일</td>
					<td align="left"><input type="text" name='b_email'/></td>
				</tr>
				<tr>
					<td align="left"><input type="hidden" name='b_pwd' value="${userPass}"/></td>
				</tr>
				<tr>
					<td bgcolor="#dee2e6" width="70">파일추가</td><td align="left">
					<input type="file" name='file' maxlength="60" size="40"></td>
					<!-- name="file"은 BoardVO 안에 File file 선언한 이름과 동일해야 함  -->
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"	value=" 새글 등록 " /></td>
				</tr>
			</table>
		</form>
</body>
</html>