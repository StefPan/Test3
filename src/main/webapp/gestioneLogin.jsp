<%@ page import="java.sql.ResultSet" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestione login</title>
</head>
<body>

<p>

<%ResultSet resultSet= (ResultSet) session.getAttribute("resultSet");
String email= (String) session.getAttribute("email");
String password= (String) session.getAttribute("password");
%> 

  <% if(!resultSet.first()) {
	 out.print("Utente non registrato");
			} 
	if (resultSet.getString("email").equalsIgnoreCase(email)){
	 	if (resultSet.getString("passwrd").equalsIgnoreCase(password)) {
					/* <!--  HttpSession session = request.getSession();
					session.setAttribute("resultSet", resultSet); */ 
					request.getRequestDispatcher("welcoming.jsp").forward(request, response);
							} else {
					
							request.getRequestDispatcher("errorePassword.jsp").forward(request, response);

							}
							}%>
 
<%-- <%out.print("Benvenuto "/* + resultSe.getString("nome") */);%>  --%>
<h1>Benvenuto!</h1>
<hr> 


<%-- <%@include file= %> --%>







</body>
</html>