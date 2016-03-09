package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;

import controller.GerenciaFilialController;
import model.DAO.FilialDAO;
import model.enuns.EnumEntidade;
import model.enuns.EnumOperacao;

public class TelaFilial extends JInternalFrame {
	private JTextField txtDescricao;
	private static JTextField txtFilial;
	private static JTable tableFiliais;
	private static JComboBox comboFiliais;

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
		
		comboFiliais = new JComboBox();
		comboFiliais.setBounds(50, 39, 220, 24);
		FilialDAO.updateComboFiliais();
		getContentPane().add(comboFiliais);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtFilial.setText((String) comboFiliais.getSelectedItem());
				txtDescricao.setText(GerenciaFilialController.getDescricaoFilial(txtFilial.getText()));
				FilialDAO.updateTabelaFiliais(txtFilial.getText());
			}
		});
		btnSelecionar.setBounds(282, 39, 117, 25);
		getContentPane().add(btnSelecionar);
		
		JLabel lblFilial = new JLabel("Filial:");
		lblFilial.setBounds(50, 108, 70, 15);
		getContentPane().add(lblFilial);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(50, 135, 85, 15);
		getContentPane().add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setEditable(false);
		txtDescricao.setPreferredSize(new Dimension(12, 30));
		txtDescricao.setBounds(147, 133, 252, 22);
		getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtFilial = new JTextField();
		txtFilial.setEditable(false);
		txtFilial.setColumns(10);
		txtFilial.setBounds(147, 106, 252, 22);
		getContentPane().add(txtFilial);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 178, 340, 195);
		getContentPane().add(scrollPane);
		
		tableFiliais = new JTable();
		tableFiliais.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tableFiliais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableFiliais.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		//FilialDAO.updateTabelaFiliais();
		
		scrollPane.setViewportView(tableFiliais);
		
				JButton btnAdicionar = new JButton("Adicionar");
				btnAdicionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaOperacoes telaOperacoes = new TelaOperacoes(EnumOperacao.ADD, EnumEntidade.FILIAL,"");
				telaOperacoes.setLocationRelativeTo(null);				
			}
		});btnAdicionar.setBounds(361,381,117,25);

	getContentPane().add(btnAdicionar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(txtFilial.getText() == "") {
					JOptionPane.showMessageDialog(
							null, "Selecione uma filial", "Editar Filial", JOptionPane.ERROR_MESSAGE);
				}else {
				
					TelaOperacoes telaOperacoes = new TelaOperacoes(
								EnumOperacao.UPDATE, EnumEntidade.FILIAL,TelaFilial.getTxtFilial().getText());
				}
			}
		});
		btnEditar.setBounds(232, 380, 117, 25);
		getContentPane().add(btnEditar);
		
		JButton btnDesativar = new JButton("Desativar");
		btnDesativar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeFilial = txtFilial.getText();
				
				if(nomeFilial.equals("")) {
					JOptionPane.showMessageDialog(
							null, "Selecione uma filial", "Desativar Filial", JOptionPane.ERROR_MESSAGE);
				}//verificar se estoque da filial está vazio
				else if(GerenciaFilialController.isEstoqueVazio(nomeFilial)) {
					String descFilial = txtDescricao.getText();
					int opcaoUsuario = JOptionPane.showConfirmDialog(
							null, "Tem certeza que deseja excluir a filial " + nomeFilial + " - " + descFilial + " ?","Excluir Filial",
							JOptionPane.YES_NO_OPTION);
					
					if(opcaoUsuario == 0) {//confirma
						GerenciaFilialController.desativarFilial(nomeFilial);
					}
					
				}else {
					
				}
			}
		});
		btnDesativar.setBounds(103, 379, 117, 25);
		getContentPane().add(btnDesativar);
		
	}

	public static JTable getTableFiliais() {
		return tableFiliais;
	}

	public static JComboBox getComboFiliais() {
		return comboFiliais;
	}

	public static JTextField getTxtFilial() {
		return txtFilial;
	}
	
	
	
}
