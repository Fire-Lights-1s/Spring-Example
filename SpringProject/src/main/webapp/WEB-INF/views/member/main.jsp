<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/main.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/table.css">
</head>
<body>
<c:if test="${empty sessionScope.id}">
<%-- 	<c:redirect url="login"></c:redirect> --%>
</c:if>
	<h1>member/main.jsp</h1>
	<table>
	<caption><%= session.getAttribute("id")%>, ${sessionScope.id}</caption>
	<c:if test="${!empty sessionScope.id}">
		<c:if test="${sessionScope.id eq 'admin'}">
		<tr>
			<td colspan="2"><a href="list" class="button btnLightBlue">모든 유저정보 보기</a></td>
		</tr>
		</c:if>
	</c:if>
		<tr>
			<td><a href="info" class="button btnLightBlue">개인정보 보기</a></td>
			<td><a href="update" class="button btnLightBlue">나의 정보 수정</a></td>
		</tr>
		<tr>
			<td><a href="../board/write" class="button btnLightBlue">글쓰기</a></td>
			<td><a href="../board/list" class="button btnLightBlue">글목록 보기</a></td>
		</tr>
		<tr>
			<td><a href="delete" class="button btnLightBlue">나의 정보 삭제</a></td>
			<td><a href="logout" class="button btnLightBlue">로그아웃</a></td>
		</tr>
	</table>
</body>
</html>