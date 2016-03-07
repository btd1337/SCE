package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.entity.ResultSetTableModel;

public class TelaEstoque extends JInternalFrame {
	private JTable table;

	/**
	 * Create the frame.
	 */
	public TelaEstoque() {
		setBorder(null);
		setBounds(100, 100, 500, 450);
		getContentPane().setLayout(null);
		
		JLabel lblEstoqueListagem = new JLabel("Estoque - Listagem por Filial");
		lblEstoqueListagem.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEstoqueListagem.setBounds(12, 12, 416, 20);
		getContentPane().add(lblEstoqueListagem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 44, 375, 285);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		try {
			table.setModel(new ResultSetTableModel("select filial,produto,qtde from estoque"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Listar Por Total");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					table.setModel(new ResultSetTableModel("select filial,produto,qtde from estoque"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(335, 381, 143, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnListarPorFilial = new JButton("Listar Por Filial");
		btnListarPorFilial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListarPorFilial.setBounds(180, 381, 143, 25);
		getContentPane().add(btnListarPorFilial);

	}
}
