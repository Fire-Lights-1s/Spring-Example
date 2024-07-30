<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/content.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/table.css?after">
</head>
<body>
	<% pageContext.setAttribute("newLine", "\n"); %>
	<h1>board/content.jsp</h1>
	<p>로그인 : ${sessionScope.id }</p>
	<c:set var="board" value="${requestScope.boardDTO}"></c:set>
	<c:if test="${! empty board}"></c:if>
	<table>
		<tr>
			<td>글번호</td>
			<td>${board.getNum()}</td>
		</tr>
		<tr>
			<td>글쓴이</td>
			<td>${board.getName()}</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${board.getReadCount()}</td>
		</tr>
		<tr>
			<td>글 작성 날짜</td>
			<td>${board.getDate()}</td>
		</tr>
		<tr>
			<td>글제목</td>
			<td>${board.getSubject()}</td>
		</tr>
		<tr>
			<td>글내용</td>
			<td>${fn:replace(board.content, newLine, '<br>')}</td>
		</tr>
		<c:if test="${board.getName() eq sessionScope.id }">
		<tr>
			<td><a href="update.bo?num=${board.getNum()}"
				class="button btnLightBlue">글 수정</a></td>
			<td><a href="delete.bo?num=${board.getNum()}"
				class="button btnLightBlue">글 삭제</a></td>
		</tr>
		</c:if>
	</table>

	<a href="list.bo">글 목록 돌아가기</a>
</body>
</html>