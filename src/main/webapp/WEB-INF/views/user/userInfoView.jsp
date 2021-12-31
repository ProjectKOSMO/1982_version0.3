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
</head>
<body>
    <main class="main">
        <p class="main_title">간단한 이력서</p>
        <div class="main_container">
            <div>
            <form action="updateMypage.do" method="post" enctype="multipart/form-data">
                <div class="Hong_img_box">
                    <div>
                    <label for="">이름</label>
                    <div class="label_div">
                        <input type="text" placeholder="이름"> 
                    </div>
                    <label for="">핸드폰번호</label>
                    <div class="label_div">
                        <input type="text" placeholder="핸드폰번호"> 
                    </div>
                    <label for="">학력사항</label>
                    <div class="label_div">
                        <input type="text" placeholder="학력사항">
                        <select name="" id="" class="select">
                           <option value="">중학교 졸업</option>
                           <option value="">고등학교 졸업</option>
                           <option value="">대학교 졸업</option>
                           <option value="">기타</option>
                        </select>  
                    </div>
                    </div>
                    <div class="right_menu">
                        <label for="" >경력사항</label>
                        <div class="right_icon">
                        <div class="label_div">
                            <input type="text" placeholder="경력사항"> 
                        </div>
                        <div class="icon">
                            <a href="#">
                                <i class="fas fa-plus-square"></i>
                            </a>   
                        </div>
                        </div>
                        <label for="">자격증</label>
                        <div class="label_div">
                            <input type="text" placeholder="자격증"> 
                        </div>
                    </div>
            	</div>  
              <input type="submit" value="등록하기">
            </div>
          </form>
        </div>  
    </main>
</body>
</html>