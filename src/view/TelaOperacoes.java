package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.GerenciaFilialController;
import model.enuns.EnumEntidade;
import model.enuns.EnumOperacao;
import net.miginfocom.swing.MigLayout;

public class TelaOperacoes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtDescricao;

	/**
	 * Create the dialog.
	 */
	public TelaOperacoes(EnumOperacao enumOperacao, EnumEntidade enumEntidade) {

		String tituloJanela = null;

		// Edita o título da janela
		switch (enumOperacao) {
		case ADD:
			tituloJanela = "Adicionar ";
			break;
		case UPDATE:
			tituloJanela = "Editar ";
			break;
		case DESATIVA:
			tituloJanela = "Desativar ";
			break;
		}

		switch (enumEntidade) {
		case FILIAL:
			tituloJanela += "Filial";
			break;
		case PRODUTO:
			tituloJanela += "Produto";
			break;
		}
		
		
		setTitle(tituloJanela);
		setBounds(100, 100, 400, 200);
		setVisible(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		{
			JLabel lblNome = new JLabel("Nome:");
			contentPanel.add(lblNome, "cell 0 0");
		}
		{
			txtNome = new JTextField();
			contentPanel.add(txtNome, "cell 1 0");
			txtNome.setColumns(25);
		}
		{
			JLabel lblDescricao = new JLabel("Descrição:");
			contentPanel.add(lblDescricao, "cell 0 2,alignx trailing");
		}
		{
			txtDescricao = new JTextField();
			txtDescricao.setColumns(20);
			contentPanel.add(txtDescricao, "cell 1 2,growx");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnConfirmar = new JButton("Confirmar");
				btnConfirmar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Ações do Botão Confirmar novo Item
						switch (enumOperacao) {
						case ADD: {
							if (enumEntidade == EnumEntidade.FILIAL) {
								GerenciaFilialController.addFilial(txtNome.getText(), txtDescricao.getText());
							} else if (enumEntidade == EnumEntidade.PRODUTO) {
								GerenciaFilialController.addProduto(txtNome.getText(),txtDescricao.getText());
							}
							break;
						}
						case UPDATE:
							if (enumEntidade == EnumEntidade.FILIAL) {
								GerenciaFilialController.updateFilial(txtNome.getText(), txtDescricao.getText());
							} else if (enumEntidade == EnumEntidade.PRODUTO) {
								GerenciaFilialController.addProduto(txtNome.getText(),txtDescricao.getText());
							}
							break;
						case DESATIVA:
							//
							break;
						}
					}
				});
				btnConfirmar.setActionCommand("Confirmar");
				buttonPane.add(btnConfirmar);
				getRootPane().setDefaultButton(btnConfirmar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
