<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/include/tags.jspf"%><!DOCTYPE html>
<html>
<head>
<title>질문 답변 게시판</title>
</head>
<body>
	<div id="main">
		<form:form modelAttribute="question" action="/qna" method="post">
			<table>
				<tr>
					<td>제목</td>
					<td><form:input path="title" size="90"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><form:textarea path="contents" rows="5" cols="150"></form:textarea></td>
				</tr>
				<tr>
					<td>태그</td>
					<td><form:input path="plainTags" size="90"/></td>
				</tr>
			</table>
			<input type="submit" value="질문하기" />		
		</form:form>
	</div>
</body>
</html>