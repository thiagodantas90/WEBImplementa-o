package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBanco {
	private static final String DRIVER = "org.postgresql.Driver";   
	private static final String URL = "jdbc:postgresql://localhost:5432/projeto01web";   
	private static final String USERNAME = "postgres";   
	private static final String PASSWORD = "postgres"; 
	private Connection conexao;
	
//	public static Connection getConnection() throws SQLException {
//		try {   
//			Class.forName(DRIVER);   
//		} catch (ClassNotFoundException ex) {   
//			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");   
//			return null;   
//		}   
//		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);   
//		return conn;   
//	}
//	public static void desconecta () throws SQLException {
//		getConnection().close();
//	}
	
	  public void getConnection() {
	        try {
	            Class.forName(DRIVER); //Carrega o driver (inicializa um objeto da classe org.postgresql.Driver) 
	            conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD); //Cria a conexao
	            System.out.println("Banco conectado");
	            //Statement stmt = conexao.createStatement();
	            //stmt.execute(CRIAR_TABELAS);
	        } catch (Exception e) {
	            System.err.println(e);
	            e.printStackTrace();
	        }
	    }

	    //METODO QUE DESCONECTA O BANCO DE DADOS
	    public void desconecta() {
	        try {
	            conexao.close();//fecha a conexao
	        } catch (SQLException ex) {
	            System.err.println(ex);
	            ex.printStackTrace();
	        }
	    }

	    public Connection getConexao() {
	        return conexao;
	    }
}
