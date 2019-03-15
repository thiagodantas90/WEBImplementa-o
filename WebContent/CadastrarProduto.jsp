<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Produto</title>
</head>
<body>
	<form method=POST action="CadastrarProduto">
	Nome:<input type="text" name="nome"><br>
	Descrição:<input type="text" name="descricao"><br>
	Preço Unitário:<input type="text" name="preco"><br>
	Quantidade:<input type="text" name=quantidade"><br>
	<input type="submit" value="CADASTRAR">
	</form>

</body>
</html>