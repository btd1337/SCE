package model.DAO;

import java.sql.SQLException;

import model.entity.ResultSetTableModel;
import view.TelaEstoque;

public class EstoqueDAO {
	
	public static void updateTabelaListarPorTotal() {
		try {
			TelaEstoque.getTable().setModel(new ResultSetTableModel(
					"select filial,produto,qtde from estoque"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
