<%-- <%@page import="com.itwillbs.domain.MemberDTO"%> --%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/update.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/table.css">
<c:if test="${! empty sessionScope.resultM and sessionScope.resultM ne ''}">
	<c:set var="resultM" value="${sessionScope.resultM}"></c:set>
</c:if>
</head>
<body>
	<h1>member/update.jsp</h1>
	<c:if test="${! empty sessionScope.id and sessionScope.id ne ''}">
		<c:set var="id" value="${sessionScope.id }"></c:set>
	</c:if>
	<c:set var="member" value="${requestScope.memberDTO }"></c:set>
	<c:choose>
		<c:when test="${! empty member }" >
		<form action="updatePro.me" method="post">
			<table>
				<c:if test="${!empty resultM }">
					<tr>
						<td>결과 메세지</td>
						<td>${resultM }</td>
					</tr>
				</c:if>
				<tr>
					<td>아이디</td>
					<td><input type="text" class="input_border" name="id" readonly value="${member.id }"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" class="input_border" name="pass"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" class="input_border" name="name" value="${member.name }"></td>
				</tr>
				<tr>
					<td><a href="main.me" class="button btnLightBlue">main.jsp 이동</a></td>
					<td><input type="submit"  value="회원정보수정"></td>
				</tr>
			</table>
		</form>
		</c:when>
		<c:otherwise>
		<tr>
			<td rowspan="2">로그인 정보 없음</td>
		</tr>
		</c:otherwise>
	</c:choose>
</body>
</html>