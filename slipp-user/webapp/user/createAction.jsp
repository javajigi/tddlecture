<%@page contentType="text/html; charset=euc-kr"%>
<%@page import="net.slipp.user.*"%>
<%
try{
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String admin = request.getParameter("isAdmin");
	if (admin == null) {
		admin = "false";
	}

	boolean isAdmin = Boolean.parseBoolean(admin);
	User user = new User(userId, password, name, email, isAdmin);
	UserService service = new UserService();
	service.create(user);

	response.sendRedirect("index.jsp");
} catch (Exception e) {
%>
<script language="javascript">
alert("<%=e.getMessage()%>");
history.back();
</script>
<%
}
%>
