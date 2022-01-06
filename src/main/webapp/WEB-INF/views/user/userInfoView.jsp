<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이력서</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" href="/project1982/resources/css/infoView.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/FortAwesome/Font-Awesome@5.14.0/css/all.min.css">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<script>
	$(document).ready(function(){
		
		$('#userUpdate').on("click",function(){
			var params = $("#userUpdateForm").serialize();
			console.log(params)
			$.ajax({
				type : 'post',
				url : "../user/updateInfoView.do",
				data : params,
				success : function(){
					alert("성공")
				}
			})
			alert("등록이 완료되었습니다")
			self.close();
		});
	});
</script>
<body>
<% 
	String userId = (String)session.getAttribute("userId");
%>
    <main class="main">
        <div class="main_container">
            <div>
            <form id="" method="" enctype="multipart/form-data">
           		<input name="userid" type="hidden" value="${userId}" disabled />
			    <table border="1" width="800">
			    <tr>
			        <td width = "85" height="113">
			            <img src="/project1982/resources/upload/${infoview.userimg1}" style="height: 240px;width: 180px;">
			        </td>
			        <th colspan="9" height="50"><font size="8">구 직 신 청 서</font></th>
			    </tr>
			    <tr>
			        <th rowspan="3" width = "85" height = "70" bgcolor="D5D5D5"> 성명</th>
			    </tr>
			    <tr>
			        <th colspan = "2" bgcolor="D5D5D5">한글</th>
			        <td width="90" align="left"><input name="username" type="text" value="${infoview.username}" disabled/></td>
			        <th bgcolor="D5D5D5">생 년 월 일</th>
			        <th colspan="2" width = "80" bgcolor="D5D5D5">E-mail</th>
			    </tr>
			
			    <tr>
			        <th colspan = "2" bgcolor="D5D5D5"> 한문</th>
			        <td align="left"><input name="username2" type="text" value="${infoview.username2}" disabled/></td>
			        <td align="left"><input name="userbirth" type="text" value="${infoview.userbirth}" disabled/></td>
			        <td colspan="2"><input name="usermail" type="text" value="${infoview.usermail}" disabled/></td>
			    </tr>
			    <tr>
			        <th bgcolor="D5D5D5">연락처</th>
			        <td colspan="8" align="left" ><input name="userpn" type="text" value="${infoview.userpn}" disabled/></td>
			    </tr>
			    <tr>
			        <th bgcolor="D5D5D5">현주소</th>
			        <td colspan="8" align="left"><input name="useraddr" type="text" value="${infoview.useraddr}" disabled/></td>
			    </tr>
			    </table>
			    <table border="1">
			    <tr>
			        <th colspan="5" width="790" bgcolor="D5D5D5"> 학력사항</th>
			    </tr>
			<tr>
			<th bgcolor = "D5D5D5"> 기간(~)</th>
			<th bgcolor = "D5D5D5"> 학교명</th>
			<th bgcolor = "D5D5D5"> 학위과정</th>
			<th bgcolor = "D5D5D5"> 재학/졸업</th>
			<th bgcolor = "D5D5D5"> 비고</th>
			</tr>
			<tr>
				<td><input name="userschool_date" type="text" value="${infoview.userschool_date}" disabled/></td>
				<td align ="center"><input name="userschool" type="text" value="${infoview.userschool}" disabled/></td> 
				<td><input name="userschool_subject" type="text" value="${infoview.userschool_subject}" disabled/></td> 
				<td><input name="userschool_end" type="text" value="${infoview.userschool_end}" disabled/></td>
				<td><input name="userschool_bigo" type="text" value="${infoview.userschool_bigo}" disabled/></td>
			</tr>
			<tr>
			    <td><input name="userschool_date1" type="text" value="${infoview.userschool_date1}" disabled/></td>
			    <td align="center"><input name="userschool1" type="text" value="${infoview.userschool1}" disabled/></td>
			    <td><input name="userschool_subject1" type="text" value="${infoview.userschool_subject1}" disabled/></td>
			    <td><input name="userschool_end1" type="text" value="${infoview.userschool_end1}" disabled/></td>
			    <td><input name="userschool_bigo1" type="text" value="${infoview.userschool_bigo1}" disabled/></td>
			</tr>
			<tr>
			    <th colspan = "6" bgcolor = "D5D5D5"> 경력사항</th>
			</tr>
			<tr>
			    <th width="180" bgcolor="D5D5D5" > 기간(~)</th>
			    <th width="200" bgcolor="D5D5D5"> 근무처</th>
			    <th width="100" bgcolor="D5D5D5" > 직위</th>
			    <th width="100" bgcolor="D5D5D5"> 경력(년차)</th>
			    <th colspan = "2" width  = "70" bgcolor="D5D5D5"> 비고</th>
			</tr>
			<tr>
			    <td align="center"><input name="careerdate" type="text" value="${infoview.careerdate}" disabled/></td>
			    <td align="center"><input name="departmentname" type="text" value="${infoview.departmentname}" disabled/></td>
			    <td><input name="careerspot" type="text" value="${infoview.careerspot}" disabled/></td>
			    <td><input name="usercareerlist" type="text" value="${infoview.usercareerlist}" disabled/></td>
			    <td colspan ="2"><input name="careerbigo" type="text" value="${infoview.careerbigo}" disabled/></td>
			</tr>
			<tr>
			    <td align="center"><input name="careerdate1" type="text" value="${infoview.careerdate1}" disabled/></td>
			    <td align="center"><input name="departmentname1" type="text" value="${infoview.departmentname1}" disabled/></td>
			    <td><input name="careerspot1" type="text" value="${infoview.careerspot1}" disabled/></td>
			    <td><input name="usercareerlist1" type="text" value="${infoview.usercareerlist1}" disabled/></td>
			    <td colspan = "2"><input name="careerbigo1" type="text" value="${infoview.careerbigo1}" disabled/></td>
			</tr>
			<tr>
			    <td align="center"><input name="careerdate2" type="text" value="${infoview.careerdate2}" disabled/></td>
			    <td align="center"><input name="departmentname2" type="text" value="${infoview.departmentname2}" disabled/></td>
			    <td><input name="careerspot2" type="text" value="${infoview.careerspot2}" disabled/></td>
			    <td><input name="usercareerlist2" type="text" value="${infoview.usercareerlist2}" disabled/></td>
			    <td colspan = "2"><input name="careerbigo2" type="text" value="${infoview.careerbigo2}" disabled/></td>
			</tr>
			</table>
			<table border="1">
			<tr>
			    <th colspan = "6" width="790" bgcolor = "D5D5D5"> 자격증</th>
			</tr>
			<tr>
			    <th width="33%" bgcolor="D5D5D5" > 취득일</th>
			    <th width="33%" bgcolor="D5D5D5"> 자격증명</th>
			    <th width="33%" bgcolor="D5D5D5"> 발행기관</th>
			</tr>
			<tr>
				<td align ="center"><input name="certficatedate" type="text" value="${infoview.certficatedate}"/ disabled></td>
				<td align = "center"><input name="certficatename" type="text" value="${infoview.certficatename}" disabled/></td>
				<td align = "center"><input name="certficate_company" type="text" value="${infoview.certficate_company}" disabled/></td>
			</tr>
			<tr>
				<td align ="center"><input name="certficatedate1" type="text" value="${infoview.certficatedate1}" disabled/></td>
				<td align = "center"><input name="certficatename1" type="text" value="${infoview.certficatename1}" disabled/></td>
				<td align = "center"><input name="certficate_company1" type="text" value="${infoview.certficate_company1}" disabled/></td>
			</tr>
			<tr>
				<td align ="center"><input name="certficatedate2" type="text" value="${infoview.certficatedate2}" disabled/></td>
				<td align = "center"><input name="certficatename2" type="text" value="${infoview.certficatename2}" disabled /></td>
				<td align = "center"><input name="certficate_company2" type="text" value="${infoview.certficate_company2}" disabled/></td>
			</tr>
			<td colspan="6">
			
			<br/>
			<br/>
			    <p style = "text-align:center"> 위 기재 사항은 사실과 틀림이 없습니다.</p>
			<br/>
			<br/>
			<p style = "text-align:right">${infoview.username}(인)&nbsp;&nbsp;&nbsp;</p>
			
			</td>
			</tr>
			</table>
			
          </form>
        </div>  
    </main>
</body>
</html>