package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBanco {
	private static final String DRIVER = "org.postgresql.Driver";   
	private static final String URL = "jdbc:postgresql://ec2-54-83-50-174.compute-1.amazonaws.com:5432/d8r3he84v9kfkj?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";   
	private static final String USERNAME = "gtjwfkeqjkoyra";   
	private static final String PASSWORD = "aac67cff60d379fb01b0640ac924ef20ddd230f7cff9f41b2410f60bf2de1dcc"; 
	private static final String CRIARTABELAS= "--CRIAR AS TABELAS" + 
			"-- CLIENTES" + 
			"CREATE TABLE public.clientes" + 
			"(" + 
			"  id_cliente serial NOT NULL," + 
			"  nome_cliente character(100) NOT NULL," + 
			"  email_cliente character(100)," + 
			"  senha_cliente character(20)," + 
			"  CONSTRAINT id_cliente PRIMARY KEY (id_cliente)" + 
			")" + 
			"-- LOJISTAS" + 
			"  CREATE TABLE public.lojistas" + 
			"(" + 
			"  id_lojista serial NOT NULL," + 
			"  nome_lojista character(100) NOT NULL," + 
			"  email_lojista character(100)," + 
			"  senha_lojista character(20)," + 
			"  CONSTRAINT pk_lojista PRIMARY KEY (id_lojista)" + 
			")" + 
			"-- PRODUTOS" + 
			"  CREATE TABLE public.produtos" + 
			"(" + 
			"  id_produto serial NOT NULL," + 
			"  nome_produto character(50) NOT NULL," + 
			"  descricao_produto character(50)," + 
			"  preco_unitario character(10)," + 
			"  quantidade integer," + 
			"  CONSTRAINT pk_nome_produto PRIMARY KEY (id_produto)" + 
			")"
			+ "-- Preencher as tabelas.\r\n" + 
			"
			"INSERT INTO LOJISTAS (NOME_LOJISTA, EMAIL_LOJISTA, SENHA_LOJISTA) VALUES ('TANIRO RODRIGUES','TANIRO@GMAIL.COM','123456abc');\r\n" + 
			"INSERT INTO LOJISTAS (NOME_LOJISTA, EMAIL_LOJISTA, SENHA_LOJISTA) VALUES ('LORENA SILVA','LORE_SIL@YAHOO.COM.BR', '12uhuu@');\r\n" + 
			"\r\n" + 
			"INSERT INTO CLIENTES (NOME_CLIENTE, EMAIL_CLIENTE, SENHA_CLIENTE) VALUES ('João Pedro', 'jp2017@uol.com.br', '12345jaum');\r\n" + 
			"INSERT INTO CLIENTES (NOME_CLIENTE, EMAIL_CLIENTE, SENHA_CLIENTE) VALUES ('Amara Silva', 'amarasil@bol.com.br','amara82');\r\n" + 
			"INSERT INTO CLIENTES (NOME_CLIENTE, EMAIL_CLIENTE, SENHA_CLIENTE) VALUES ('Maria Pereira', 'mariape@terra.com.br', '145aektm');\r\n" + 
			"\r\n" + 
			"INSERT INTO PRODUTOS (NOME_PRODUTO, DESCRICAO_PRODUTO, PRECO_UNITARIO, QUANTIDADE) VALUES ('Mesa','Uma mesa de computador', 10, 0);\r\n" + 
			"INSERT INTO PRODUTOS (NOME_PRODUTO, DESCRICAO_PRODUTO, PRECO_UNITARIO, QUANTIDADE) VALUES ('Lapis','Lapis B2 grafite', 15, 0);\r\n" + 
			"INSERT INTO PRODUTOS (NOME_PRODUTO, DESCRICAO_PRODUTO, PRECO_UNITARIO, QUANTIDADE) VALUES ('Caneta','Caneca BIC azul', 7, 1);\r\n" + 
			"INSERT INTO PRODUTOS (NOME_PRODUTO, DESCRICAO_PRODUTO, PRECO_UNITARIO, QUANTIDADE) VALUES ('Telefone','Telefone fixo antigo', 8, 1);\r\n" + 
			"INSERT INTO PRODUTOS (NOME_PRODUTO, DESCRICAO_PRODUTO, PRECO_UNITARIO, QUANTIDADE) VALUES ('Computador','Computador Intel', 1000, 1);\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"";
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
