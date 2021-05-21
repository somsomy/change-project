<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/default.css" />' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/subpage.css" />' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/content.css" />' rel="stylesheet" type="text/css">
<link href='<c:url value="/resources/css/volunteer/reply.css" />' rel="stylesheet" type="text/css">

 <script defer src="../script/reply.js"></script>
</head>
<body>
<div id="wrap">
<jsp:include page="../inc/top.jsp"/>

<div class="clear"></div>
<div id="divSub">
<div id="text">자원봉사</div>
<hr id="texthr">
<div id="text2">사랑의 손길을 내어주세요. </div>
<div id="sub_img"></div>
</div>
<div id="divArticle">
<article>
<h1>자원봉사 모집</h1>
<hr>
<table id="cnotice">
<tr id="sub"><td colspan="2">${vrbList.get(0).subject }</td></tr>
<tr><td colspan="2" id="write">${vrbList.get(0).name }</td></tr>
<tr><td class="tdtd">  작성일 <fmt:formatDate value="${vrbList.get(0).date}" type="both" pattern="yyyy.MM.dd HH:mm"/></td>
<td id="readtd">조회수 ${vrbList.get(0).readcount }</td></tr>
<tr id="cbtr"><td colspan="2" id="con">${vrbList.get(0).content }</td></tr>
<tr><td id="down" colspan="2">첨부파일 
<c:choose>
	<c:when test="${!empty vrbList.get(0).file  }">
		<a href='<c:url value="/resources/images/uploadImage/${vrbList.get(0).file }" />' download>
			<c:set var="f" value="${vrbList.get(0).file }"></c:set>
			<c:set var="length" value="${fn:length(f) }"></c:set>
			<c:set var="idx" value="${fn:indexOf(f,'_')}"></c:set>
			<c:set var="filename" value="${fn:substring(f,idx+1,length)}"></c:set>
		${filename } 다운로드
		</a>	
	</c:when>
	<c:otherwise>
		없음
	</c:otherwise>
</c:choose>
</td></tr>
</table>

<c:forEach var="vrb" items="${vrbList }">
	<c:if test="${vrb.repNum ne 0 }">
		<table id="reply">
			<tr>
			<td rowspan="3"><c:if test="${vrb.re_lev > 0 }"><img src='<c:url value="/resources/images/board/blank.png"/>' width="${vrb.re_lev*5 }" ></c:if>
			</td>
			<td class="rep">${vrb.repName }</td>
			</tr>
			<tr><td class="rep"><fmt:formatDate value="${vrb.repDate}" type="both" pattern="yyyy.MM.dd HH:mm"/></td></tr>
			<tr>
			<td class="recon" >${vrb.repContent }</td>
<!-- 			<td> -->
			<%-- <% --%>
			<!-- if(mb.getNick()!=null) { -->
			<%-- if(mb.getNick().equals(rb.getName())) { %> --%>
			<%-- <a onclick="location.href='replyDelete.jsp?num=<%=rb.getNum()%>&boardNum=<%=rb.getBoardNum()%>&re_lev=<%=rb.getRe_lev()%>&re_ref=<%=rb.getRe_ref()%>'">삭제</a> --%>
			<%-- <a onclick="updateOpen<%=i%>()">수정</a> --%>
			<%-- <%} } --%>
			
			<!-- if(id!=null) { -->
			<%-- %> --%>
			<%-- <a onclick="open<%=i%>()" >답글</a> --%>
			<%-- <%}%> --%>
<!-- 			</td> -->
			</tr>
		</table>
	</c:if>
</c:forEach>

<!-- <form action="replyUpdatePro.jsp" method="post" name="fr"> -->
<%-- <div id="hideReplyUpdate<%=hide %>" class="hideRep"> --%>
<%-- <input type="hidden" name="num" value="<%=rb.getNum()%>"> --%>
<%-- <input type="hidden" name="boardNum" value="<%=rb.getBoardNum()%>"> --%>
<%-- <textarea id="hidecont" name="recontent" onkeyup="resize(this)"><%=rb.getContent() %></textarea> --%>
<!-- <input type="submit" value="수정" id="rebtn"> -->
<%-- <input type="button" value="취소" onclick="updateClose<%=i%>()" id="recancelBtn"> --%>
<!-- </div> -->
<!-- </form> -->

<!-- <form action="replyRegPro2.jsp" method="post" name="fr"> -->
<%-- <div id="hideReply<%=hide %>" class="hideRep"> --%>
<%-- <input type="hidden" name="boardNum" value="<%=num%>"> --%>
<%-- <input type="hidden" name="re_ref" value="<%=rb.getRe_ref()%>"> --%>
<%-- <input type="hidden" name="re_lev" value="<%=rb.getRe_lev() %>"> --%>
<%-- <input type="hidden" name="re_seq" value="<%=rb.getRe_seq() %>"> --%>
<%-- <input type="hidden" name="name" value="<%=mb.getNick() %>"> --%>
<!-- <textarea id="hidecont" name="recontent" onkeyup="resize(this)"></textarea> -->
<!-- <input type="submit" value="등록" id="rebtn"> -->
<%-- <input type="button" value="취소" onclick="close<%=i%>()" id="recancelBtn"> --%>
<!-- </div> -->
<!-- </form> -->
<!-- <script> -->
<%-- function open<%=i%>() { --%>
<%-- 	document.getElementById('hideReply'+<%=i%>).style.display='block'; --%>
	
<!-- } -->
<%-- function updateOpen<%=i%>() { --%>
<%-- 	document.getElementById('hideReplyUpdate'+<%=i%>).style.display='block'; --%>
<!-- } -->

<%-- function close<%=i%>() { --%>
<%-- 	document.getElementById('hideReply'+<%=i%>).style.display='none'; --%>
<!-- } -->

<%-- function updateClose<%=i%>() { --%>
<%-- 	document.getElementById('hideReplyUpdate'+<%=i%>).style.display='none'; --%>
<!-- } -->
<!-- </script> -->
<div id="page_control">

<c:if test="${pb.startPage > pb.pageBlock }">
	<a href='<c:url value="/volunteer/content?pageNum=${pb.startPage - pb.pageBlock }" />'>이전</a>
</c:if>
<c:forEach var="i" begin="${pb.startPage }" end="${pb.endPage }" step="1">
	<a href='<c:url value="/volunteer/content?pageNum=${i }" />'>${i }</a>
</c:forEach>
<c:if test="${pb.endPage < pb.pageCount }">
	<a href='<c:url value="/volunteer/content?pageNum=${pb.startPage + pb.pageBlock }" />'>다음</a>
</c:if>
</div>

<div id="comdiv">
<span id="com">댓글작성</span>
<form action="replyRegPro.jsp" method="post">
<input type="hidden" name="boardNum" value="${vrbList.get(0).num }">
<c:choose>
	<c:when test="${!empty sessionScope.id }">
		<textarea name="content" id="comtext" onkeyup="resize(this)" ></textarea>
		<input type="submit" class="combtn" value="작성">
	</c:when>
	<c:otherwise>
		<div>로그인이 필요합니다.</div>
	</c:otherwise>
</c:choose>
</form>
</div>
<div id="wbtn">
<input type="button" value="목록" class="writeBtn" onclick="location.href='<c:url value="/volunteer" />'" >

<c:if test="${!empty sessionScope.id }">
	<c:if test="${sessionScope.id eq 'admin' }">	
		<input type="button" value="글수정" class="writeBtn" onclick="location.href='<c:url value="/volunteer/update?num=${vrbList.get(0).num }" />'">
		<input type="button" value="글삭제" class="writeBtn" onclick="location.href='<c:url value="/volunteer/delete?num=${vrbList.get(0).num }&file=${f }" />'">
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