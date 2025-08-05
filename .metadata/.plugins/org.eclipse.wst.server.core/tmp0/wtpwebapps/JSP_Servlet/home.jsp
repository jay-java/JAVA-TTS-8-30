<%@page import="DAO.UserDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	%>

	<%
	User u = null;
	if (session.getAttribute("data") != null) {
		u = (User) session.getAttribute("data");
	} else {
		response.sendRedirect("login.jsp");
	}
	%>

	<h1>
		Welcome,
		<%=u.getName()%></h1>


	<%
	List<User> list = UserDAO.getAllUsers();
	%>

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Contact</th>
			<th>Address</th>
			<th>Email</th>
			<th>Password</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
		for (User u1 : list) {
		%>
		<tr>
			<td><%=u1.getId()%></td>
			<td><%=u1.getName()%></td>
			<td><%=u1.getContact()%></td>
			<td><%=u1.getAddress()%></td>
			<td><%=u1.getEmail()%></td>
			<td><%=u1.getPassword()%></td>
			<td><a href="UserController?action=edit&id=<%=u1.getId()%>">Edit</a></td>
			<td>
				<form action="UserController" method="post">
					<input type="hidden" name="id" value="<%=u1.getId()%>"> <input
						type="submit" name="action" value="delete">
				</form>
			</td>
		</tr>
		<%
		}
		%>

	</table>

	<h1>
		<a href="logout.jsp">Logout</a>
	</h1>
</body>
</html>
