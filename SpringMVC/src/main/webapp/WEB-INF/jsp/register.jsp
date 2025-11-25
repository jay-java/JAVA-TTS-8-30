<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Register page
<form action="add" method="post">
  <label for="fname">Name:</label><br>
  <input type="text" id="fname" name="name"><br><br>
  <label for="lname">Contact:</label><br>
  <input type="text" id="lname" name="contact"><br><br>
   <label for="lname">Address:</label><br>
  <input type="text" id="lname" name="address"><br><br>
   <label for="lname">Email:</label><br>
  <input type="email" id="lname" name="email"><br><br>
   <label for="lname">Password:</label><br>
  <input type="password" id="lname" name="password"><br><br>
  <input type="submit" name="action" value="register">
</form> 

</body>
</html>