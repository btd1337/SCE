package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.entity.Produto;
import model.entity.ResultSetTableModel;
import view.TelaProdutos;

public class ProdutoDAO {

	public static void addProduto(Produto produto) {
		String sql = "insert into produto (nomeProduto, descricaoProduto) "
				+ "values (?,?)";
		
		try {
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, produto.getNomeProduto());
			prepareStatement.setString(2, produto.getDescricaoProduto());
			prepareStatement.execute();
			JOptionPane.showMessageDialog(
					null, "Produto adicionado com sucesso!","Adicionar Produto",JOptionPane.INFORMATION_MESSAGE);
			updateTabelaProdutos();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void updateTabelaProdutos() {
		try {
			TelaProdutos.getTable().setModel(new ResultSetTableModel(
					"select nomeProduto,descricaoProduto from produto"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
