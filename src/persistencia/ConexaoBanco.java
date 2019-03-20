package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBanco {
	private static final String DRIVER = "org.postgresql.Driver";   
	private static final String URL = "jdbc:postgresql://localhost:5432/projeto01web";   
	private static final String USERNAME = "postgres";   
	private static final String PASSWORD = "1234"; 
	private static final String CRIARTABELAS= "--CRIAR AS TABELAS" + 
			"" + 
			"-- CLIENTES" + 
			"CREATE TABLE public.clientes" + 
			"(" + 
			"  id_cliente serial NOT NULL," + 
			"  nome_cliente character(100) NOT NULL," + 
			"  email_cliente character(100)," + 
			"  senha_cliente character(20)," + 
			"  CONSTRAINT id_cliente PRIMARY KEY (id_cliente)" + 
			")" + 
			"WITH (" + 
			"  OIDS=FALSE" + 
			");" + 
			"ALTER TABLE public.clientes" + 
			"  OWNER TO postgres;" + 
			"" + 
			"" + 
			"-- LOJISTAS" + 
			"  CREATE TABLE public.lojistas" + 
			"(" + 
			"  id_lojista serial NOT NULL," + 
			"  nome_lojista character(100) NOT NULL," + 
			"  email_lojista character(100)," + 
			"  senha_lojista character(20)," + 
			"  CONSTRAINT pk_lojista PRIMARY KEY (id_lojista)" + 
			")" + 
			"WITH (" + 
			"  OIDS=FALSE" + 
			");" + 
			"ALTER TABLE public.lojistas" + 
			"  OWNER TO postgres;" + 
			"" + 
			"" + 
			"-- PRODUTOS" + 
			"  CREATE TABLE public.produtos" + 
			"(" + 
			"  id_produto serial NOT NULL," + 
			"  nome_produto character(50) NOT NULL," + 
			"  descricao_produto character(50)," + 
			"  preco_unitario character(10)," + 
			"  quantidade integer," + 
			"  CONSTRAINT pk_nome_produto PRIMARY KEY (id_produto)" + 
			")" + 
			"WITH (" + 
			"  OIDS=FALSE" + 
			");" + 
			"ALTER TABLE public.produtos" + 
			"  OWNER TO postgres;";
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
	            Statement stmt = conexao.createStatement();
	            stmt.execute(CRIARTABELAS);
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
