<%@page contentType="text/html; charset=euc-kr"%>
<%@page import="net.slipp.domain.user.*"%>
<%@ include file="loginCheck.jsp"%>
<%
	String userId = request.getParameter("userId");

	UserService service = new UserService();
	service.remove(userId);

	response.sendRedirect("index.jsp");
%>