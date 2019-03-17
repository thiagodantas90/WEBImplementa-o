package implementacao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistencia.ConexaoBanco;
import persistencia.UsuariosDAO;

/**
 * Servlet implementation class CadastroCliente
 */
@WebServlet("/CadastroCliente")
public class CadastroCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		UsuariosDAO usr = new UsuariosDAO();
		
		String nome = request.getParameter("nome").toUpperCase();
		String email = request.getParameter("email").toUpperCase();
		String senha = request.getParameter("senha");
		
		if(nome==""||email==""||senha=="") {
			out.print("ATENÇÃO: Há campos em Branco<br><br>"
					+ "<html>"
					+ "<input type=\"button\" onclick='history.go(-1)' value=\"VOLTAR AO CADASTRO\">"
					+ "</html>");
		}else{
			if(usr.cadastrarCliente(nome, email, senha)) {
				out.print("Cadastrado"						
						+ "<a href=\"index.jsp\">Fazer Login</a>");
			}
		}
		
	}

}
