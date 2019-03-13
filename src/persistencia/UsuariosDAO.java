package persistencia;

import implementacao.ConexaoBanco;

public class UsuariosDAO {
	ConexaoBanco conect = new ConexaoBanco();
	
	private final String CONSULTARPRECO = "SELECT NOME_PRODUTO, PRECO FROM PRODUTOS WHERE COD_BARRAS = (?)";
	
	
}
