package implementacao;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class filtro
 */
//@WebFilter(urlPatterns="/LoginServlet")
public class filtro implements Filter {

    public filtro() {
        
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest) request;   
	      HttpServletResponse res = (HttpServletResponse) response;   
	      HttpSession session = req.getSession();   
	      String user = (String) session.getAttribute("currentSessionUser");   
	      System.out.println("usuario logado =" +user);
	      if(user!=null && user.trim().length()>0){   
	         return;   
	      }   
	      res.sendRedirect("index.jsp"); 
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
