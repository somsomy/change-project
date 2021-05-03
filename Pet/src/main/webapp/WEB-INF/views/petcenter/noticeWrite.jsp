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
<link href='<c:url value="/resources/css/content.css" />' rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
<jsp:include page="../inc/top.jsp"/>
<div class="clear"></div>
<div id="divSub">
<div id="text">공지사항</div>
<hr id="texthr">
<div id="text2">고양이의 하루의 공지사항입니다.</div>
<jsp:include page="../inc/petcenterSubMenu.jsp"></jsp:include>
</div>
<div id="divArticle">
<c:if test="${empty sessionScope.id }">
	<script>
		alert("로그인이 필요합니다");
		location.href="member/login";
	</script>
</c:if>

<article>
<h1>공지사항 게시판</h1>
<hr>
<form action='<c:url value="/noticeWrite" />' method="post">
<table id="cnotice">
<tr id="sub"><td >제목</td><td><input type="text" name="subject" id="title" placeholder="제목을 입력해주세요." required></td></tr>
<tr><td class="tdtd">작성자</td><td class="tdtd"><input type="text" name="name" value="${sessionScope.id }" id="writer" readonly></td></tr>
<tr class="subsub"><td class="consub">내용</td><td class="consub"><textarea name="content" placeholder="내용을 입력해주세요." id="conupdate" required></textarea></td></tr>
</table>
<div class="clear"></div>
<div id="wbtn">
<input type="submit" value="글쓰기" class="writeBtn" >
</div>
</form>
<div class="clear"></div>

</article>
</div>
<div class="clear"></div>
<jsp:include page="../inc/bottom.jsp"/>
</div>
</body>
</html>