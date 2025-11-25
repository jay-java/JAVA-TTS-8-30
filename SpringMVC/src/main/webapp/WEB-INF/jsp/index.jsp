<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 	my index page
	<%
int num = (Integer) request.getAttribute("num");
%>
	<%
	out.print(num);
	%>
	<%
	String name = (String) request.getAttribute("name");
	%>
	<h1>
		<%
		out.print(name);
		%>
	</h1>

	<%
	List list = (List) request.getAttribute("list");
	%>
	<%
	out.print(list);
	%>
 --%>
	<br>
	<h1>${num }</h1>
	<h1>${name }</h1>
	<h1>${list }</h1>
	<c:forEach items="${list }" var="u">
	<h2>${u }</h2>
	</c:forEach>


</body>
</html>