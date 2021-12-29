<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/FortAwesome/Font-Awesome@5.14.0/css/all.min.css">
    <title>storeReview.jsp</title>
    <link type="text/css" href="/project1982/resources/css/9_review.css" rel="stylesheet"/>
</head>
<body>
    <div class="wrap">
        <main>
           <p class="review_title">리뷰 작성 페이지</p>
           <img src="./1.png" alt="" />
           <div class="star">
               <i class="far fa-star"></i>
               <i class="far fa-star"></i>
               <i class="far fa-star"></i>
               <i class="far fa-star"></i>
               <i class="far fa-star"></i>
           </div>
        </main>
        <article class="article">
            <input type="text" class="input_text">
            <input type="text" class="input_text">
            <input type="text" class="input_text">
            <input type="text" class="input_text">
            <input type="text" class="input_text">
            <input type="text" class="input_box">
            <button>작성 완료</button>
        </article>
    </div>
    <script src="./snow.js"></script>
</body>
</html>