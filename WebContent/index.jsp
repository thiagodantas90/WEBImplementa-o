<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela de Login</title>
</head>
<body>
<form method="POST" action="LoginServlet?">
	E-mail<br><input type="text" name="email">
	<br>Senha<br><input type="password" name="senha"><br>
	<input type="submit" name="Entrar" value="Enviar"><br>
	
	<a href="CadastrarCliente.jsp">Cadastre-se</a><br>
	
	<a href="AreaRestrita.jsp">Área Restrita</a>
</form>
</body>
</html>