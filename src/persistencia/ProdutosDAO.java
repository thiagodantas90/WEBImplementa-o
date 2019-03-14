package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutosDAO {
	ConexaoBanco conect = new ConexaoBanco();
	
	public void CadastrarProduto(String nome, String descricao, String preco_unt, String quant) {
		
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
	public void ListarProdutos() {
		
	}
	public void AlterarQuantProduto() {
		
	}
}
