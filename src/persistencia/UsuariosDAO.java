package persistencia;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.Usuarios;

public class UsuariosDAO {
	
	ConexaoBanco conect = new ConexaoBanco();
	Usuarios usr;
	
	private final String CADASTRARCLIENTE = "INSERT INTO CLIENTES (NOME_CLIENTE, EMAIL_CLIENTE, SENHA_CLIENTE) VALUES (?,?,?)";
	//private final String CONSULTARUSUARIO = "SELECT * FROM CLIENTES WHERE EMAIL_CLIENTE = ('?')";
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
	
	public ArrayList<Usuarios> ListarClientes(){
		ArrayList<Usuarios> lista = new ArrayList<>();
		conect.getConnection();
		PreparedStatement prepararInstrucao;
		try {
			prepararInstrucao = conect.getConexao().prepareStatement("SELECT * FROM CLIENTES");
			 ResultSet rs = prepararInstrucao.executeQuery();
	            while (rs.next()){
	            	Usuarios usr = new Usuarios(rs.getString("NOME_CLIENTE"), rs.getString("EMAIL_CLIENTE"), rs.getString("SENHA_CLIENTE"));
	            	lista.add(usr);
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("erro ao listar");
			e.printStackTrace();
		}
		return lista;
	}
		public ArrayList<Usuarios> ListarLojista(){
			ArrayList<Usuarios> lista = new ArrayList<>();
			conect.getConnection();
			PreparedStatement prepararInstrucao;
			try {
				prepararInstrucao = conect.getConexao().prepareStatement("SELECT * FROM LOJISTAS");
				 ResultSet rs = prepararInstrucao.executeQuery();
		            while (rs.next()){
		            	Usuarios usr = new Usuarios(rs.getString("NOME_LOJISTA"), rs.getString("EMAIL_LOJISTA"), rs.getString("SENHA_LOJISTA"));
		            	lista.add(usr);
		            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("erro ao listar");
				e.printStackTrace();
			}
			return lista;	
	}
	

}
