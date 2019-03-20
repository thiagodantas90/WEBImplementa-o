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
		<th>Descrição</th>
		<th>Preço Unitário</th>
		<th>Quantidade</th>
		<th>Carrinho</th>
	</tr>
	
 	<%ArrayList<Produtos> produtosLista = new ArrayList();
 		ProdutosDAO p = new ProdutosDAO();
 		produtosLista.addAll(p.ListarProdutos());
 		
 		for(int i=0; i<produtosLista.size();i++){ %>
 			<tr>
 				<td name="nome" id=<%=i%>><%=produtosLista.get(i).getNome()%></td>
 				<td name="descricao" id=<%=i%>><%=produtosLista.get(i).getDescricao()%></td>
 				<td name="preco" id=<%=i%>><%=produtosLista.get(i).getPreco()%></td>
 				<td><%=produtosLista.get(i).getEstoque() %></td>
 				
 				<td name="enviar" id=<%=i%>><%if(produtosLista.get(i).getEstoque()>0){%>
 						<a  href="/implementacao/CarrinhoProdutos?">Adicionar</a>
 						<%}else{%>
 							Sem estoque
 						<%}%>
 			</tr>
 		<%}%>
	</table>
	<a href="MeuCarrinho.jsp">Ver carrinho</a>
	
</body>
</html>