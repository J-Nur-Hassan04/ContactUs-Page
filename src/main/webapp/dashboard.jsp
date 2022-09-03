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
	response.setHeader("Cache-Control", "no-cache , no-store, must-revalidate");
	if (session.getAttribute("userName") == null) {
		response.sendRedirect("login");
	}
	%>


	<table border="1" width="700">
		<h2>Active Table</h2>
		<tr>
			<td>Name</td>
			<td>Email</td>
			<td>Message</td>
			<td>Status</td>
		</tr>

		<%
		ArrayList<Request> activeList = (ArrayList<Request>) request.getAttribute("data");
		for (Request active : activeList) {
			if (!active.isStatus()) {
		%>

		<tr>
			<td><%=active.getName()%></td>
			<td><%=active.getEmail()%></td>
			<td><%=active.getMessage()%></td>

			<td><form action="dashboard" method="post">
					<input type="submit" value=<%="Archive"%>> <input
						name="email" type="hidden" value=<%=active.getEmail()%>>
				</form></td>
		</tr>
		<%
		}
		}
		%>
	</table>
	<table border="1" width="700">
		<h2>Archived Table</h2>
		<tr>
			<td>Name</td>
			<td>Email</td>
			<td>Message</td>
			<td>Status</td>
		</tr>

		<%
		ArrayList<Request> archivedList = (ArrayList<Request>) request.getAttribute("data");
		for (Request archived : archivedList) {
			if (archived.isStatus()) {
		%>

		<tr>
			<td><%=archived.getName()%></td>
			<td><%=archived.getEmail()%></td>
			<td><%=archived.getMessage()%></td>

			<td><form action="dashboard" method="post">
					<input type="submit" value=<%="Active"%>> <input
						name="email" type="hidden" value=<%=archived.getEmail()%>>
				</form></td>
		</tr>
		<%
		}
		}
		%>
	</table>




	<form action="logout" method="get">
		<input type="submit" value="Log Out">
	</form>
</body>
</html>