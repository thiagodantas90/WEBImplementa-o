package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuariosDAO {
	
	ConexaoBanco conect = new ConexaoBanco();
	
	private final String CADASTRARCLIENTE = "INSERT INTO CLIENTES (NOME_CLIENTE, EMAIL_CLIENTE, SENHA_CLIENTE) VALUES (?,?,?)";
	private final String CONSULTARUSUARIO = "SELECT NOME_CLIENTE FROM CLIENTES WHERE EMAIL_CLIENTE = '?' AND SENHA_CLIENTE = '?'";
		
	public void cadastrarCliente(String nome, String email, String senha) {
		
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
            System.out.println(ex);
        }
	}
	
	public void consultarUsuario(String email, String pass) {
		 try {
	            conect.getConnection();
	            
	            PreparedStatement prepararInstrucao;
	            prepararInstrucao = conect.getConexao().prepareStatement(CONSULTARUSUARIO);
	            
	            prepararInstrucao.setString(1, email);
	            prepararInstrucao.setString(2, pass);
	            ResultSet rs = prepararInstrucao.executeQuery();
	                            
	            rs.getString("NOME_CLIENTE");
	                		
	            
	        } catch (SQLException ex) {
	            
	        }
		 
		 conect.desconecta();		 
		
	}

	
}
