<%@page import="java.sql.SQLException"%>
<%@page import="com.mysql.cj.jdbc.exceptions.SQLError"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/update.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/table.css?after">
</head>
<body>
<h1>board/update.jsp</h1>
<c:set var="board" value="${requestScope.boardDTO }"></c:set>
<c:choose>
	<c:when test="${board.name ne sessionScope.id }">
		<c:redirect url="list.bo"></c:redirect>
	</c:when>
	<c:otherwise>
		<form action="updatePro.bo" method="post">
		<table>
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="num" value="${board.num}"
				class='input_border' readonly></td>
			</tr>
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="name" value="${board.name}"
				class='input_border' readonly></td>
			</tr>
			<tr>
				<td>글제목</td><td><input type="text" name="subject" value="${board.subject}"
				class='input_border' ></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td><textarea rows="10" cols="20" name="content" 
				class='input_border resize_none' >${board.content}</textarea></td>
			</tr>
			<tr><td colspan="2"><input type="submit" value="글 수정"> <a href="main.me">go to main</a></td></tr>
		</table>
		</form>
	</c:otherwise>
</c:choose>
</body>
</html>