<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/include/tags.jspf"%>
<!DOCTYPE html>
<html>
<head>
<title>질문 답변 게시판</title>
</head>
<body>
	<div id="main">
		<table>
			<tr>
				<td height="400" valign="top">
					<table>
						<tr>
							<td width="400">제목</td>
							<td width="100">글쓴이</td>
							<td width="150">생성일</td>
						</tr>
						<c:forEach items="${questions}" var="each">
							<tr>
								<td width="400"><a href="/qna/${each.questionId}">${each.title}</a></td>
								<td width="100">${each.writerName}</td>
								<td width="150"><fmt:formatDate
										pattern="yyyy-MM-dd hh:mm:ss" value="${each.createdDate}" /></td>
							</tr>
						</c:forEach>
					</table>
				</td>
				<td height="400" valign="top">
					<table>
						<tr>	
							<td>			
							<c:forEach items="${tags}" var="each">
								${each.name} X ${each.taggedCount} <br/>
							</c:forEach>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<br /> <a href="/qna/form">질문하기</a>
	</div>
</body>
</html>