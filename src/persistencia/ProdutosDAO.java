package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.Produtos;

public class ProdutosDAO {
	ConexaoBanco conect = new ConexaoBanco();
	
	public boolean CadastrarProduto(String nome, String descricao, double preco, int quant) {
		try {
            conect.getConnection();
          
            PreparedStatement prepararInstrucao;
            prepararInstrucao = conect.getConexao().prepareStatement("INSERT INTO PRODUTOS (NOME_PRODUTO, DESCRICAO_PRODUTO, PRECO_UNITARIO, QUANTIDADE) VALUES (?,?,?,?)");
            
            prepararInstrucao.setString(1, nome);
            prepararInstrucao.setString(2, descricao);
            prepararInstrucao.setDouble(3, preco);
            prepararInstrucao.setInt(4, quant);
           //erronessa linha
            prepararInstrucao.execute();
           
            conect.desconecta();
            return true;
        } catch (SQLException ex) {
            System.out.println("PAROU");
            System.out.println(ex);
        }
		return false;
	}
	public ArrayList<Produtos> ListarProdutos() {
		ArrayList<Produtos> produtos = new ArrayList<>();
		Produtos p;
		
		try {
            conect.getConnection();
            PreparedStatement prepararInstrucao;
            prepararInstrucao = conect.getConexao().prepareStatement("SELECT NOME_PRODUTO, DESCRICAO_PRODUTO, PRECO_UNITARIO, QUANTIDADE FROM PRODUTOS");
            
            ResultSet rs = prepararInstrucao.executeQuery();
            while (rs.next()) {            	
                p = new Produtos(rs.getDouble("PRECO_UNITARIO"), rs.getString("NOME_PRODUTO"), rs.getString("DESCRICAO_PRODUTO"), rs.getInt("QUANTIDADE"));
                produtos.add(p);
            }
            conect.desconecta();
        } catch (SQLException ex) {
            
        }
		
		return produtos;
		
		
	}
	public void AlterarQuantProduto() {
		
	}
}
