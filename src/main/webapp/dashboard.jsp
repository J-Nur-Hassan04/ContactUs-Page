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
	<%
	ArrayList<Request> allRequestList = (ArrayList<Request>) request.getAttribute("data");
	%>


	<table border="1" width="700">
		<h2>Active Table</h2>
		<tr>
			<th>id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Message</th>
			<th>Status</th>
		</tr>

		<%
		ArrayList<Request> activeList = allRequestList;
		for (Request active : activeList) {
			if (!active.isStatus()) {
		%>

		<tr>
			<td><%=active.getRequestId()%></td>
			<td><%=active.getName()%></td>
			<td><%=active.getEmail()%></td>
			<td><%=active.getMessage()%></td>

			<td><form action="dashboard" method="post">
					<input type="submit" value=<%="Archive"%>> <input
						name="requestId" type="hidden" value=<%=active.getRequestId()%>>
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
			<th>id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Message</th>
			<th>Status</th>
		</tr>

		<%
		ArrayList<Request> archivedList = allRequestList;
		for (Request archived : archivedList) {
			if (archived.isStatus()) {
		%>

		<tr>
			<td><%=archived.getRequestId() %></td>
			<td><%=archived.getName()%></td>
			<td><%=archived.getEmail()%></td>
			<td><%=archived.getMessage()%></td>

			<td><form action="dashboard" method="post">
					<input type="submit" value=<%="Active"%>> <input
						name="requestId" type="hidden" value=<%=archived.getRequestId()%>>
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