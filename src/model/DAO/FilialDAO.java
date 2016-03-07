package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

	public static void addFilial(Filial filial) {
		String sql = "insert into filial (nomeFilial,descricaoFilial) "
				+ "values(?,?)";
		
		try {
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, filial.getNomeFilial());
			stmt.setString(2, filial.getDescricaoFilial());
			stmt.execute();
			JOptionPane.showMessageDialog(
					null, "Filial adicionada com sucesso!","Adicionar Filial",JOptionPane.INFORMATION_MESSAGE);
			TelaFilial.getTableFiliais().setModel(new ResultSetTableModel("Select nomeFilial, descricaoFilial from filial"));
		} catch (MySQLIntegrityConstraintViolationException e) {
			//TODO Corrigir mensagem de erro para registro duplicado
			JOptionPane.showMessageDialog(
					null, "Filial já cadastrada!","Adicionar Filial",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
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

}