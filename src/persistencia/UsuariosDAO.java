package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelos.Usuarios;

public class UsuariosDAO {
	
	ConexaoBanco conect = new ConexaoBanco();
	Usuarios usr;
	
	private final String CADASTRARCLIENTE = "INSERT INTO CLIENTES (NOME_CLIENTE, EMAIL_CLIENTE, SENHA_CLIENTE) VALUES (?,?,?)";
	//private final String CONSULTARUSUARIO = "SELECT * FROM CLIENTES WHERE EMAIL_CLIENTE =;
	private final String CONSULTARUSUARIOLOJA = "SELECT * FROM LOJISTAS WHERE NOME_CLIENTE = (?)";
		
	public boolean cadastrarCliente(String nome, String email, String senha) {
		
		try {
            conect.getConnection();
          
            PreparedStatement prepararInstrucao;
            prepararInstrucao = conect.getConexao().prepareStatement(CADASTRARCLIENTE);
            prepararInstrucao.setString(1, nome);
            prepararInstrucao.setString(2, email);
            prepararInstrucao.setString(3, senha);

            prepararInstrucao.execute();
            
            conect.desconecta();
            return true;
        } catch (SQLException ex) {
            System.out.println("PAROU");
            System.out.println(ex);
        }
		return false;
	}
	
	public Usuarios consultarUsuario(String email) {
		  try {
	            conect.getConnection();
	            	            
	            PreparedStatement prepararInstrucao = null;
	            String SQL = "SELECT * FROM CLIENTES WHERE UPPER(EMAIL_CLIENTE) LIKE" 
	            		+ "'%' || '"+email+"' || '%'";
	            prepararInstrucao = conect.getConexao().prepareStatement(SQL);
	           	            
	            prepararInstrucao.setString(1, email);
	            ResultSet rs = prepararInstrucao.executeQuery();
	            if(rs.next()){
	            	usr = new Usuarios(rs.getString("NOME_CLIENTE"), rs.getString("EMAIL_CLIENTE"), rs.getString("SENHA_CLIENTE"));	
	            }
	       
	            conect.desconecta();
	           
	        } catch (SQLException ex) {
	            System.out.println("erro na consulta");
	            System.out.println(ex);
	        }
		return usr;	
	}
	
	public Usuarios consultarUsuarioLoja(String email) {
		 try {
	            conect.getConnection();
	            
	            PreparedStatement prepararInstrucao;
	            prepararInstrucao = conect.getConexao().prepareStatement(CONSULTARUSUARIOLOJA);
	            
	            prepararInstrucao.setString(1, email);
	            ResultSet rs = prepararInstrucao.executeQuery();
	            if (rs.next()) {
	            	usr =  new Usuarios(rs.getString("NOME_LOJISTA"), rs.getString("EMAIL_LOJISTA"), rs.getString("SENHA_LOJISTA"));
	            }
	            conect.desconecta();
	        } catch (SQLException ex) {
	        	System.out.println("erro na consulta");
	        	System.out.println(ex);
	        }		
		return usr;
	}
}
