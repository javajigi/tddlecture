<%@page contentType="text/html; charset=euc-kr"%>
<%@page import="net.slipp.user.*"%>
<%@ include file="loginCheck.jsp"%>
<%
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String admin = request.getParameter("isAdmin");
	boolean isAdmin = Boolean.parseBoolean(admin);
	
	User user = new User(userId, password, name, email, isAdmin);
	UserService service = new UserService();
	service.update(user);

	response.sendRedirect("index.jsp");
%>