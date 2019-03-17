package implementacao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Usuarios;
import persistencia.UsuariosDAO;

/**
 * Servlet implementation class AreaRest
 */
@WebServlet("/AreaRest")
public class AreaRest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
UsuariosDAO usuario = new UsuariosDAO(); 
		
		String email = request.getParameter("email");
		String pass = request.getParameter("senha");
				
		Usuarios cliente = new Usuarios();
			
		cliente = usuario.consultarUsuarioLoja(email);
	
		
		if(cliente==null||!cliente.getSenha().equals(pass)) {
			request.getSession().setAttribute("msg", "E-mail ou senha invalidos");
			//response.sendRedirect("index.jsp");
			
		}else{
			request.getSession().setAttribute(email, cliente);
			response.sendRedirect("CadastroProduto.jsp");
		}
		
	}

}
