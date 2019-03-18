package implementacao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		PrintWriter out = response.getWriter();		
		String email = request.getParameter("email").toUpperCase();
		String pass = request.getParameter("senha");
		
		Usuarios lojista = new Usuarios();
		ArrayList<Usuarios> listaC = new ArrayList<>();
		listaC.addAll(usuario.ListarLojista());
		
		//System.out.println("Tamanho da lista: "+ listaC.size());
		
		if(email=="" || pass=="" ) {
			out.print("campo em branco<br>"
					+ "<input type=\"button\" onclick='history.go(-1)' value=\"VOLTAR AO LOGIN\">");
		}else{
			int cont = 0;
			for(int i = 0 ; i<listaC.size();i++) {
				if(listaC.get(i).getEmail().contains(email) && listaC.get(i).getSenha().contains(pass)){
					request.getSession().setAttribute(email, lojista);
					response.sendRedirect("CadastrarProduto.jsp");
					break;			
				}else {
					cont++;
				}
			}
			if(cont==listaC.size()) {
				out.print("E-mail ou senha invalidos<br>"
						+ "<input type=\"button\" onclick='history.go(-1)' value=\"VOLTAR AO LOGIN\">");
			}
		}		
	
			
	}

}
