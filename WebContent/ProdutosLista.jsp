<%@page import="persistencia.ProdutosDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Produtos" %>
<%@page import="persistencia.ProdutosDAO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produtos Lista</title>
</head>
<body>
<h1 align="center">Produtos</h1>
	<table align="center" border="2px" >
	<tr>
		<th>Nome</th>
		<th>Descri��o</th>
		<th>Pre�o Unit�rio</th>
		<th>Quantidade</th>
	</tr>
	
 	<%ArrayList<Produtos> produtosLista = new ArrayList();
 		ProdutosDAO p = new ProdutosDAO();
 		produtosLista = p.ListarProdutos();
 		
 		for(int i=0; i<produtosLista.size();i++){%>
 			<tr>
 				<td><%=produtosLista.get(i).getNome()%></td>
 				<td><%=produtosLista.get(i).getDescricao()%></td>
 				<td><%=produtosLista.get(i).getPreco()%></td>
 				<td><%=produtosLista.get(i).getEstoque() %></td>
 			</tr>
 		<%}%>
	</table>
	
</body>
</html>