package view;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import model.DAO.ProdutoDAO;
import model.enuns.EnumEntidade;
import model.enuns.EnumOperacao;

public class TelaProdutos extends JInternalFrame {
	private static JTable table;

	/**
	 * Create the frame.
	 */
	public TelaProdutos() {
		setBorder(null);
		setLocation(new Point(1, 1));
		setBounds(100, 100, 500, 450);
		getContentPane().setLayout(null);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setFont(new Font("Dialog", Font.BOLD, 16));
		lblProdutos.setBounds(6, 6, 95, 15);
		getContentPane().add(lblProdutos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 58, 340, 280);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		ProdutoDAO.updateTabelaProdutos();
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaOperacoes telaOperacoes = new TelaOperacoes(EnumOperacao.ADD, EnumEntidade.PRODUTO,"");
				telaOperacoes.setLocationRelativeTo(null);
			}
		});
		btnAdicionar.setBounds(364, 386, 100, 27);
		getContentPane().add(btnAdicionar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEditar.setBounds(252, 386, 100, 27);
		getContentPane().add(btnEditar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(140, 386, 100, 27);
		getContentPane().add(btnRemover);

	}
	
	public static JTable getTable() {
		return table;
	}
}
