package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TelaGerenciamentoFilial extends JFrame {

	private JPanel contentPane;
	private JTable tableProdutosFilial;
	private String[] Operacoes = { "Adicionar", "Editar", "Desativar" };
	private TelaProdutos telaProdutos;
	private TelaFilial telaFilial;
	private TelaEstoque telaEstoque;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaGerenciamentoFilial frame = new TelaGerenciamentoFilial();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);// centraliza na tela
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public TelaGerenciamentoFilial() {

		setTitle("SCE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 550);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnOpes = new JMenu("Opções");
		menuBar.add(mnOpes);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnOpes.add(mntmSair);

		JMenu mnNewMenu = new JMenu("Sobre");
		menuBar.add(mnNewMenu);

		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(1000, 420);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSistemaControladorDe = new JLabel("Sistema Controlador de Estoque");
		lblSistemaControladorDe.setBounds(15, 5, 613, 23);
		lblSistemaControladorDe.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(lblSistemaControladorDe);

		JPanel panelMenus = new JPanel();
		panelMenus.setBounds(15, 34, 106, 454);
		panelMenus.setBackground(UIManager.getColor("Button.darkShadow"));
		contentPane.add(panelMenus);
		panelMenus.setLayout(null);

		JDesktopPane deskPrincipal = new JDesktopPane();
		deskPrincipal.setBounds(133, 40, 500, 450);
		contentPane.add(deskPrincipal);

		JMenuItem mntmFilial = new JMenuItem("Filial");
		mntmFilial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!telaFilial.isVisible()) {
					deskPrincipal.add(telaFilial);
					telaFilial.setLocation(0, 0);

					telaProdutos.setVisible(false);
					telaEstoque.setVisible(false);
					telaFilial.setVisible(true);

				}
			}
		});
		mntmFilial.setBounds(8, 40, 89, 23);
		mntmFilial.setHorizontalAlignment(SwingConstants.LEFT);
		mntmFilial.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		panelMenus.add(mntmFilial);

		JMenuItem mntmEstoque = new JMenuItem("Estoque");
		mntmEstoque.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!telaEstoque.isVisible()) {
					deskPrincipal.add(telaEstoque);
					telaEstoque.setLocation(0, 0);

					telaFilial.setVisible(false);
					telaProdutos.setVisible(false);
					telaEstoque.setVisible(true);
				}
			}
		});
		mntmEstoque.setBounds(8, 75, 89, 23);
		mntmEstoque.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		panelMenus.add(mntmEstoque);

		JMenuItem mtmnProdutos = new JMenuItem("Produtos");
		mtmnProdutos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!telaProdutos.isVisible()) {
					deskPrincipal.add(telaProdutos);
					telaProdutos.setLocation(0, 0);

					telaFilial.setVisible(false);
					telaEstoque.setVisible(false);
					telaProdutos.setVisible(true);

				}
			}
		});
		mtmnProdutos.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		mtmnProdutos.setBounds(8, 110, 89, 23);
		panelMenus.add(mtmnProdutos);
		
		// inicia as telas auxiliares
		telaFilial = new TelaFilial();
		telaFilial.setVisible(true);
		telaEstoque = new TelaEstoque();
		telaEstoque.setVisible(false);
		telaProdutos = new TelaProdutos();
		telaProdutos.setVisible(false);

	}
}
