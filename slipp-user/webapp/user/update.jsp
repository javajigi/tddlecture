<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@page import="net.slipp.user.*"%><%@ include
	file="/WEB-INF/jsp/include/tags.jspf"%><%@ include
	file="loginCheck.jsp"%>
<%
	String userId = request.getParameter("userId");
	UserService service = new UserService();
	User user = service.findUser(userId);
%><!DOCTYPE html>
<html>
<head>
<title>사용자 관리</title>
</head>
<body>
	<c:set var="user" value="<%=user%>" />
	<div id="main">
		<form name="userForm" method="post" action="updateAction.jsp">
			<input type="hidden" name="userId" value="${user.userId}" />
			<input type="hidden" name="isAdmin" value="${user.admin}" />
			<table>
				<tr>
					<td>사용자 아이디</td>
					<td>${user.userId}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${user.name}">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" value="${user.email}">
					</td>
				</tr>
			</table>
			<input type="submit" value="수정하기" />
		</form>
	</div>
</body>
</html>