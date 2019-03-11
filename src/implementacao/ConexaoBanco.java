package implementacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	private static final String DRIVER = "org.postgressql.Driver";   
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";   
	private static final String USERNAME = "postgres";   
	private static final String PASSWORD = "1234"; 
	
	
	public static Connection getConnection() throws SQLException {
		try {   
			Class.forName(DRIVER);   
		} catch (ClassNotFoundException ex) {   
			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");   
			return null;   
		}   
		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);   
		return conn;   
	}
}
