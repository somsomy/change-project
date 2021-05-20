<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/default.css" />' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/subpage.css" />' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/content.css" />' rel="stylesheet" type="text/css">

</head>
<body>
<div id="wrap">
<jsp:include page="../inc/top.jsp"/>
<div class="clear"></div>
<div id="divSub">
<div id="text">Q&A</div>
<div id="sub_img_qna"></div>
<nav id="sub_menu">
</nav>
</div>
<div id="divArticle">
<article>
<h1>Q&A</h1>
<hr>
<table id="cnotice">
<tr id="sub"><td colspan="2">${qb.subject }</td></tr>
<tr><td colspan="2" id="write">${qb.name }</td></tr>
<tr><td class="tdtd">작성일 <fmt:formatDate value="${qb.date}" type="both" pattern="yyyy.MM.dd HH:mm"/></td></tr>
<tr><td colspan="2" id="con">${qb.content }</td></tr>
</table>
<div id="wbtn">

<c:if test="${!empty sessionScope.id }">
	<c:if test="${sessionScope.id eq 'admin' }">
			<input type="button" value="글삭제" class="writeBtn" onclick="location.href='qnaDelete.jsp?num=${qb.num}'">
		<c:if test="${qb.state eq '답변대기' }">
			<input type="button" value="답글달기" class="writeBtn" onclick="location.href='qnanswerForm.jsp?num=${qb.num}'">
		</c:if>
	</c:if>
	
	<c:if test="${nick eq qb.name }">
		<input type="button" value="글수정" class="writeBtn" onclick="location.href='update?num=${qb.num}'">
		<input type="button" value="글삭제" class="writeBtn" onclick="location.href='qnaDelete.jsp?num=${qb.num}'">
	</c:if>
</c:if>
</div>
<div class="clear"></div>

</article>
</div>
<div class="clear"></div>
<jsp:include page="../inc/bottom.jsp"/>
</div>
</body>
</html>