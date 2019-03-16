package implementacao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistencia.ConexaoBanco;
import persistencia.ProdutosDAO;

@WebServlet("/CadastrarProduto")
public class CadastrarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdutosDAO produto = new ProdutosDAO();
		PrintWriter out = response.getWriter();
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		double preco = Double.parseDouble(request.getParameter("preco"));
		
		if(produto.CadastrarProduto(nome, descricao, preco, quantidade)) {
			
			out.print("<html>"
					+ "<h1>Produto Cadastrado</h1><br>"
					+ "<a href=\"CadastrarProduto.jsp\">Cadastrar Novo Produto || </a>"
					+ "<a href=\"ProdutosLista.jsp\">Produtos </a>"
					+ "</html>");
		}
		//produto.CadastrarProduto(nome, descricao, preco, quantidade);
		//conm
		out.close();
		
	}

}
