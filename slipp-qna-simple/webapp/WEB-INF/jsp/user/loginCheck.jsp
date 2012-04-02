
<%
	session = request.getSession();

	if ((session == null) || (session.getAttribute("user") == null)) {
		response.sendRedirect("login.jsp");
	}
%>