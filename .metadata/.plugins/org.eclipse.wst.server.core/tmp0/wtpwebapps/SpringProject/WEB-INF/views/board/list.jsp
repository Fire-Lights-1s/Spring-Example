<%@page import="com.itwillbs.domain.PageDTO"%>
<%@page import="com.itwillbs.domain.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/list.jsp</title>
<link rel='stylesheet' href="${pageContext.request.contextPath }/css/table.css">
</head>
<body>
	<h1>board/list.jsp</h1>
	<a href="write.bo">글쓰기</a>
	<c:set var="boardList" value="${requestScope.boardList }"></c:set>
	<c:set var="pageDTO" value="${requestScope.pageDTO }"></c:set>
	<h2>글목록 [ 글개수 : ${pageDTO.count}]</h2>
	<h2>글목록 [ 페이지개수 : ${pageDTO.totalPage}]</h2>
	<table>
		<tr>
			<td>글번호</td>
			<td>글쓴이</td>
			<td>글제목</td>
			<td>조회수</td>
			<td>글 작성 날짜</td>
		</tr>
		<c:if test="${! empty boardList }">
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td><a href="content.bo?num=${board.getNum()}">${board.getNum()}</a></td>
					<td>${board.getName()}</td>
					<td><a href="content.bo?num=${board.getNum()}">${board.getSubject()}</a></td>
					<td>${board.getReadCount()}</td>
					<td>${board.getDate()}</td>
				</tr>
			</c:forEach>
		</c:if>
	<tr id="underBar">
		<td>
			<a href="main.me">go to main</a>
		</td>
		<td colspan="3">
		<c:if test="${pageDTO.startPage > pageDTO.pageBlock }">
			<a  href="list.bo?pageNum=${pageDTO.getStartPage()-pageDTO.pageBlock}"> 이전</a>
		</c:if>
		<c:forEach var="p" begin="${pageDTO.getStartPage()}" end="${pageDTO.getEndPage()}" step="1">
			<a href="list.bo?pageNum=${p}"> ${p} </a>
		</c:forEach>
		<c:if test="${pageDTO.endPage < pageDTO.totalPage }">
			<a  href="list.bo?pageNum=${pageDTO.getStartPage()+pageDTO.pageBlock}"> 다음</a>
		</c:if>
		</td>
	</tr>
	</table>
	<br>
</body>
</html>