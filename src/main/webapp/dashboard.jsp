<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nurhassan.obj.Request"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	if(session.getAttribute("userName") == null)
	{
		response.sendRedirect("login");
	}
	%>
	<table border="1" width="700">
		<tr>
			<td>Name</td>
			<td>Email</td>
			<td>Message</td>
			<td>Status</td>
		</tr>

		<%
		ArrayList<Request> l = (ArrayList<Request>) request.getAttribute("data");
		for (Request req : l) {
		%>

		<tr>
			<td><%=req.getName()%></td>
			<td><%=req.getEmail()%></td>
			<td><%=req.getMessage()%></td>
			<%
			if (req.isStatus()) {
			%>
			<td><form action="dashboard" method="post">
					<input type="submit" value=<%="UnArchive"%>>
					<input name="email" type="hidden" value=<%=req.getEmail() %>>
				</form></td>
			<%
			} else {
			%>
			<td><form action="dashboard" method="post">
					<input type="submit" value=<%="Archive"%>>
					<input name="email" type="hidden" value=<%=req.getEmail() %>>
				</form></td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>