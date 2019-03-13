<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="LoginServlet?">
	Usuário<br><input type="text" name="usuario" id="usuario">
	<br>Senha<br><input type="password" name="senha" id="senha"><br>
	<input type="submit" name="Entrar" id="entrar" value="Enviar"><br>
	<a href="CadastrarCliente.jsp">Cadastre-se</a>;
</form>
</body>
</html>