package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.Produtos;

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
            System.out.println(ex);
        }
	}
	public ArrayList<Produtos> ListarProdutos() {
		ArrayList<Produtos> produtos = new ArrayList();
		Produtos p;
		
		try {
            conect.getConnection();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = conect.getConexao().prepareStatement("SELECT NOME_PRODUTO, PRECO_UNITARIO, QUANTIDADE FROM PRODUTOS");
            
            ResultSet rs = prepararInstrucao.executeQuery();
            while (rs.next()) {                
                p = new Produtos(rs.getInt("ID_PRODUTO"),rs.getString("NOME_PRODUTO"),rs.getString("DESCRICAO_PRODUTO"),rs.getString("PRECO_UNITARIO"), rs.getInt("QUANTIDADE"));
                produtos.add(p);
            }
            
        } catch (SQLException ex) {
            
        }
		
		return produtos;
		
		
	}
	public void AlterarQuantProduto() {
		
	}
}
