<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/include/tags.jspf"%><%@page
	import="java.util.*"%><%@page import="net.slipp.domain.user.*"%>

<%@ include file="loginCheck.jsp"%>

<%
	UserService service = new UserService();
	List<User> users = service.findUserList();
%><!DOCTYPE html>
<html>
<head>
<title>사용자 관리</title>
</head>
<body>
	<div id="main">
		<table>
			<tr>
				<td width=190>사용자 아이디</td>
				<td width=200>이름</td>
				<td width=200>이메일</td>
				<td></td>
			</tr>
			<c:forEach items="<%=users%>" var="each">
				<tr>
					<td width=190>${each.userId}</td>
					<td width=200>${each.name}</td>
					<td width=200>${each.email}</td>
					<td><a href="update.jsp?userId=${each.userId}">수정</a>&nbsp; <a
						href="deleteAction.jsp?userId=${each.userId}">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
		<br /> <a href="/user/create.jsp">사용자 추가</a>&nbsp;&nbsp;<a href="/qna/form">질문하기</a>
	</div>
</body>
</html>