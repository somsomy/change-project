<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/default.css" />' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/subpage.css" />' rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
<jsp:include page="../inc/top.jsp"/>
<div class="clear"></div>
<div id="divSub">
<div id="text">보호센터 소개</div>
<hr id="texthr">
<div id="text2">고양이의 하루는 고양이의 행복한 삶을 기원합니다.</div>
<jsp:include page="../inc/petcenterSubMenu.jsp"></jsp:include>
</div>
<div id="divArticle">
<article>
<h1>보호센터 소개</h1>
<hr>
<p id="infobox">
<img src='<c:url value="/resources/images/center_info.png" />' id="centerinfo">
</p>
</article>
</div>
<div class="clear"></div>
<jsp:include page="../inc/bottom.jsp"/>
</div>
</body>
</html>



    