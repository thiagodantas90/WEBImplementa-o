package implementacao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Carrinho;

@WebServlet("/CarrinhoProdutos")
public class CarrinhoProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String preco= request.getParameter("preco");
		
		ArrayList<Produtos> listaProdutos =new ArrayList<>();
		Produtos prod = new Produtos();
		listaProdutos.add(prod);
		Carrinho carro = new Carrinho();
		
		out.print("você está no seu carrinho");
	}

}
