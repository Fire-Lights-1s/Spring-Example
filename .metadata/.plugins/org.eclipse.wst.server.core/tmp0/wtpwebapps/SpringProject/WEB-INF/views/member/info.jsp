<%-- <%@page import="com.itwillbs.domain.MemberDTO"%> --%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/info.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/table.css">
</head>
<body>
	<h1>member/info.jsp</h1>
	<%
	String id = "";
	if (session.getAttribute("id") != null && !session.getAttribute("id").equals("")) {
		id = (String) session.getAttribute("id");
	}
// 	MemberDTO member = (MemberDTO)request.getAttribute("memberDTO");

// 	out.print("member 리턴값 " + member);
	%>
	<table>
	<c:set var="dto" value="${requestScope.memberDTO}"/>
	<c:choose>
		<c:when test="${ ! empty dto }">
		<tr>
			<td>아이디</td>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${memberDTO.pass}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${memberDTO.name}</td>
		</tr>
		<tr>
			<td>가입 날짜</td>
			<td>${memberDTO.date}</td>
		</tr>
		</c:when>
		<c:otherwise>
			<tr>
			<td rowspan="2">로그인 정보 없음</td>
		</tr>
		</c:otherwise>
	</c:choose>
	</table>
	<a href="main">main.jsp 이동</a>
</body>
</html>