<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome</h1>


<form action="login" method="post">
Email:<input type="text" name="email"><br>
Password:<input type="password" name="password"><br>
<!-- <input type="submit" value="submit"> -->
<button type ="submit">Login</button><br>
</form>

<a href="formRegistrazione.jsp">Registrazione</a>
<a href="logout">Logout</a>

</body>
</html>