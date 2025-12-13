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
Update page
<form action="${pageContext.request.contextPath }/add" method="post">
<label for="fname">ID :</label><br>
  <input type="text" id="fname" name="id" value="${u.id }"><br><br>
  <label for="fname">Name:</label><br>
  <input type="text" id="fname" name="name" value="${u.name }"><br><br>
  <label for="lname">Contact:</label><br>
  <input type="text" id="lname" name="contact" value="${u.contact }"><br><br>
   <label for="lname">Address:</label><br>
  <input type="text" id="lname" name="address" value="${u.address }"><br><br>
   <label for="lname">Email:</label><br>
  <input type="email" id="lname" name="email" value="${u.email }"><br><br>
   <label for="lname">Password:</label><br>
  <input type="password" id="lname" name="password" value="${u.password }"><br><br>
  <input type="submit" name="action" value="update">
</form> 

</body>
</html>