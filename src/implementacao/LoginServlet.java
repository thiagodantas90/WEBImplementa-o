package implementacao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistencia.UsuariosDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		UsuariosDAO usuario = new UsuariosDAO(); 
		String usr = request.getParameter("usuario");
		String pass = request.getParameter("senha");
		String resposta = usuario.consultarUsuario(usr, pass);
		
		out.print(resposta);
		
//		if(usuario.consultarUsuario(usr, pass)) {
//			out.print("usu�rio Cadastrado"+usr);
//		}else {
//			out.print("usu�rio n�o encontrado");
//		}
//		out.close();
	}

}
