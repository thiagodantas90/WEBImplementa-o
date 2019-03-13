package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import implementacao.ConexaoBanco;

public class UsuariosDAO {
	ConexaoBanco conect = new ConexaoBanco();
	
	private final String CADASTRARCLIENTE = "INSERT INTO CLIENTES (NOME_CLIENTE, EMAIL_CLIENTE, SENHA_CLIENTE) VALUES (?,?,?)";
	//private final String CONSULTAUSUARIO = "SELECT NOME_PRODUTO, PRECO FROM PRODUTOS WHERE COD_BARRAS = (?)";
	
	
	public void cadastrarCliente(String nome, String email, String senha) {
		
		try {
            conect.getConnection();
          
            PreparedStatement prepararInstrucao;
            prepararInstrucao = conect.getConexao().prepareStatement(CADASTRARCLIENTE);
            
            prepararInstrucao.setString(1, nome);
            System.out.println("1");
            prepararInstrucao.setString(2, email);
            System.out.println("2");
            prepararInstrucao.setString(3, senha);
            System.out.println("3");
           
            prepararInstrucao.execute();
            System.out.println("Executando");
           
            conect.desconecta();
            
        } catch (SQLException ex) {
            System.out.println("PAROU");
        }
   }
	
}
