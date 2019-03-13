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
		UsuariosDAO usuario = new UsuariosDAO(); 
		String usr = request.getParameter("usuario");
		String pass = request.getParameter("senha");
//		PrintWriter out = response.getWriter();
//				out.print(usr);
//				out.print(pass);
//				out.close();
		
		
		
	}

}
