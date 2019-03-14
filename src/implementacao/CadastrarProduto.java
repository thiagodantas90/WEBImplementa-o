package implementacao;

import java.io.IOException;
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
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String preco_unt = request.getParameter("preco");
		String quant = request.getParameter("quantidade");
		
		produto.CadastrarProduto(nome, descricao, preco_unt, quant);
	
		
	}

}
