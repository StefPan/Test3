<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Registrazione Nuovo Cliente</h1>
	<form method="post" action="createClient">
		<label>Nome</label>
        <input type="text" name="firstName">
        
        <label>Cognome</label>
        <input type="text" name="lastName">
  
        <label>Email</label>
        <input type="text" name="email">
  
        <label>Password</label>
        <input type="text" name="password">
  
  		<label>Indirizzo</label>
        <input type="text" name="indirizzo">
        
        <label>cap</label>
        <input type="text" name="cap">
        
        <label>citta</label>
        <input type="text" name="citta">
        
        <button type="submit">Crea Utente</button>
	</form>
	
	<a href="index.html" >Login</a>

</body>
</html>