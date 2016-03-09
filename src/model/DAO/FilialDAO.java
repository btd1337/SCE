package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import model.entity.Filial;
import model.entity.ResultSetTableModel;
import view.TelaFilial;

public class FilialDAO {

	public FilialDAO() {
	}

	public static void getFilial() {
		// TODO implement here
	}

	public static void selectFilial(String nomeFilial) {
		// TODO implement here
	}

	public static void getDadosFilial(String nomeFilial) {
		// TODO implement here
	}

	public static void updateFilial(Filial filial) {
		// TODO implement here
	}

	public static void getFiliais(String nomeFilial) {
		// TODO implement here
	}

	public static void desativaFilial(Filial filialOrigem, Filial filialDestino) {
		// TODO implement here
	}

	public static void updateTabelaFiliais(String nomeFilial) {

		try {
			TelaFilial.getTableFiliais().setModel(new ResultSetTableModel(
					"select produto, qtde from estoque where filial = '" + nomeFilial + "'"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void updateComboFiliais() {
		Connection connection;
		try {
			connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select nomeFilial from filial");
			TelaFilial.getComboFiliais().removeAllItems();
			while (resultSet.next()) {
				TelaFilial.getComboFiliais().addItem(resultSet.getString("nomeFilial"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getDescricaoFilial(String nomeFilial) {

		String descricao = null;

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("select descricaoFilial from filial where nomeFilial = ?");
			statement.setString(1, nomeFilial);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				descricao = resultSet.getString("descricaoFilial");
			}
			
			return descricao;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Caso dê erro
		return null;
	}
	
	public static void addFilial(Filial filial) {
		String sql = "insert into filial (nomeFilial,descricaoFilial) " + "values(?,?)";

		try {
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, filial.getNomeFilial());
			stmt.setString(2, filial.getDescricaoFilial());
			stmt.execute();
			JOptionPane.showMessageDialog(null, "Filial adicionada com sucesso!", "Adicionar Filial",
					JOptionPane.INFORMATION_MESSAGE);
			updateComboFiliais();

		} catch (MySQLIntegrityConstraintViolationException e) {
			// TODO Corrigir mensagem de erro para registro duplicado
			JOptionPane.showMessageDialog(null, "Filial já cadastrada!", "Adicionar Filial", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateFilial(String elementoAlterado, Filial filial) {
		String sql = "update filial set nomeFilial = ?, descricaoFilial = ? where nomeFilial = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, filial.getNomeFilial());
			statement.setString(2, filial.getDescricaoFilial());
			statement.setString(3, elementoAlterado);
			
			statement.execute();
			
			JOptionPane.showMessageDialog(null, "Filial atualizada com sucesso!", "Editar Filial",
					JOptionPane.INFORMATION_MESSAGE);
			updateComboFiliais();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public static boolean isEstoqueVazio(String nomeFilial) {		
		// TODO Auto-generated method stub
		String sql = "select produto from estoque where filial = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, nomeFilial);
			resultSet =  statement.executeQuery();
			
			if(!resultSet.next()) {
				return true;
			}else {
				return false;
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	public static void desativaFilial(String nomeFilial) {
		// TODO CRIAR MÉTODO PARA DESATIVAR A FILIAL ATRAVÉS DE FLAG
		
	}

}