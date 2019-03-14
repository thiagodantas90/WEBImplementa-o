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

@WebServlet("/CadastrarProduto")
public class CadastrarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String preco_unt = request.getParameter("preco");
		String quant = request.getParameter("quantidade");
		
		ConexaoBanco conect = new ConexaoBanco();
		
		try {
            conect.getConnection();
          
            PreparedStatement prepararInstrucao;
            prepararInstrucao = conect.getConexao().prepareStatement("INSERT INTO PRODUTOS (NOME_PRODUTO, DESCRICAO_PRODUTO, PRECO_UNITARIO, QUANTIDADE) VALUES (?,?,?,?)");
            
            prepararInstrucao.setString(1, nome);
            prepararInstrucao.setString(2, descricao);
            prepararInstrucao.setString(3, preco_unt);
            prepararInstrucao.setString(4, quant);
           //erronessa linha
            prepararInstrucao.execute();
           
            conect.desconecta();
            
        } catch (SQLException ex) {
            System.out.println("PAROU");
        }
	}

}
