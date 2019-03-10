package webimplementacao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webimplementacao.*;

@WebServlet("/ListaProdutosServlet")
public class ListaProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nome");
		response.getWriter().append("Hello, " + name +".");
		

		Connection connection = null;
	    try {   
	    	connection = ConexaoBanco.getConnection();
	    } catch (SQLException ex) {   
	    	response.getWriter().append("Connection Failed! Check output console");   
	    }
	    
	    if(connection!= null){
			response.getWriter().append("A conexão com o banco foi realizada!");
	    }else{
	    	response.getWriter().append("A conexão com o banco falhou!");
	    }

		
//		try {
//			connection.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();}
//		}
//	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
