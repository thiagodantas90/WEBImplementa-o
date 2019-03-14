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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//UsuariosDAO usr = new UsuariosDAO();
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		//cadastrarCliente(nome, email, senha);
		ConexaoBanco conect = new ConexaoBanco();
		String CADASTRARCLIENTE = "INSERT INTO CLIENTES (NOME_CLIENTE, EMAIL_CLIENTE, SENHA_CLIENTE) VALUES (?,?,?)";
		try {
            conect.getConnection();
          
            PreparedStatement prepararInstrucao;
            prepararInstrucao = conect.getConexao().prepareStatement(CADASTRARCLIENTE);
            
            prepararInstrucao.setString(1, nome);
            prepararInstrucao.setString(2, email);
            prepararInstrucao.setString(3, senha);
           
            prepararInstrucao.execute();
           
            conect.desconecta();
            
        } catch (SQLException ex) {
            System.out.println("PAROU");
        }
//		if() {
//			out.print("Cadastro Realizado");
//			out.print("<html>"
//					+ "<a href=\"index.jsp\">Voltar</a>"						
//					+ "</html>");
//		}else{
//			out.print("Cadastro não Realizado");
//			out.print("<html>"
//					+ "<a href=\"CadastrarCliente.jsp\">Tentar novamente</a>"						
//					+ "</html>");
//		}
		out.close();
	}

	private void cadastrarCliente(String nome, String email, String senha) {
		// TODO Auto-generated method stub
		
		
	}


}
