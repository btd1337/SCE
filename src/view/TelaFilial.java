package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;

import model.entity.ResultSetTableModel;
import model.enuns.EnumEntidade;
import model.enuns.EnumOperacao;

public class TelaFilial extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private static JTable tableFiliais;

	/**
	 * Create the frame.
	 */
	public TelaFilial() {
		setBorder(null);
		setBounds(100, 100, 500, 450);
		getContentPane().setLayout(null);
		
		JLabel lblFiliais = new JLabel("Filiais");
		lblFiliais.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFiliais.setBounds(12, 12, 70, 15);
		getContentPane().add(lblFiliais);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(50, 39, 220, 24);
		getContentPane().add(comboBox);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setBounds(282, 39, 117, 25);
		getContentPane().add(btnSelecionar);
		
		JLabel lblFilial = new JLabel("Filial:");
		lblFilial.setBounds(50, 108, 70, 15);
		getContentPane().add(lblFilial);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(50, 135, 85, 15);
		getContentPane().add(lblDescricao);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(12, 30));
		textField.setBounds(147, 133, 252, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 106, 252, 22);
		getContentPane().add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 178, 340, 195);
		getContentPane().add(scrollPane);
		
		tableFiliais = new JTable();
		tableFiliais.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tableFiliais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableFiliais.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		try {
			tableFiliais.setModel(new ResultSetTableModel("select nomeFilial, descricaoFilial from filial"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		scrollPane.setViewportView(tableFiliais);
		
				JButton btnAdicionar = new JButton("Adicionar");
				btnAdicionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaOperacoes telaOperacoes = new TelaOperacoes(EnumOperacao.ADD, EnumEntidade.FILIAL);
				telaOperacoes.setLocationRelativeTo(null);				
			}
		});btnAdicionar.setBounds(361,381,117,25);

	getContentPane().add(btnAdicionar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setBounds(232, 380, 117, 25);
		getContentPane().add(btnEditar);
		
		JButton btnDesativar = new JButton("Desativar");
		btnDesativar.setBounds(103, 379, 117, 25);
		getContentPane().add(btnDesativar);
		
	}

	public static JTable getTableFiliais() {
		return tableFiliais;
	}
	
}
