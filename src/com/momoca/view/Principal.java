package com.momoca.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
					frame.setSize(1100, 680);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Momoca - Sistema de Vendas");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(251, 98, 719, 431);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label_logo = new JLabel("");
		label_logo.setBounds(245, 167, 291, 103);
		panel.add(label_logo);
		label_logo.setIcon(new ImageIcon("imagens/logoLogin.png"));
		label_logo.setVerticalTextPosition(SwingConstants.TOP);
		label_logo.setVerticalAlignment(SwingConstants.TOP);
		label_logo.setOpaque(true);

		JLabel lblSistemaDeVendas = new JLabel("Sistema de Vendas");
		lblSistemaDeVendas.setFont(new Font("Arial", Font.BOLD, 16));
		lblSistemaDeVendas.setBounds(319, 141, 164, 14);
		panel.add(lblSistemaDeVendas);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(85, 98, 156, 431);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnVendas = new JButton("Vendas");
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVenda tv = new TelaVenda();
				tv.setSize(1100, 680);
				tv.setLocationRelativeTo(null);
				tv.setVisible(true);
			}
		});
		btnVendas.setBounds(22, 51, 124, 30);
		panel_1.add(btnVendas);
		btnVendas.setToolTipText("Sistema de Vendas dos produtos");

		JButton btnNewButton_1 = new JButton("Usuarios");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroUsuario tu = new TelaCadastroUsuario();
			    tu.setLocationRelativeTo(null);
				tu.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(22, 92, 124, 30);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setToolTipText("Cadastro de Usu\u00E1rios");

		JButton btnNewButton_2 = new JButton("Produtos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProduto tp = new TelaCadastroProduto();			
                tp.setLocationRelativeTo(null);
				tp.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(22, 133, 124, 30);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setToolTipText("Cadastro de Produtos");

		JButton btnOutro = new JButton("outro");
		btnOutro.setBounds(22, 174, 124, 30);
		panel_1.add(btnOutro);
		btnOutro.setToolTipText("");

		JButton btnOutro_1 = new JButton("Outro\r\n");
		btnOutro_1.setBounds(22, 215, 124, 30);
		panel_1.add(btnOutro_1);
		btnOutro_1.setToolTipText("");

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setToolTipText("");
		btnSair.setBounds(22, 256, 124, 30);
		panel_1.add(btnSair);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.setBounds(85, 11, 634, 35);
		contentPane.add(menuBar);

		JMenu mnVendas = new JMenu("Vendas");
		mnVendas.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.add(mnVendas);

		JMenuItem mntmTelaDeVendas = new JMenuItem("Tela de Vendas");
		mntmTelaDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaVenda tv = new TelaVenda();
				tv.setSize(1100, 680);				
                tv.setLocationRelativeTo(null);
				tv.setVisible(true);
			}
		});
		mnVendas.add(mntmTelaDeVendas);

		JMenu mnCadastro = new JMenu("Usu\u00E1rios");
		mnCadastro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.add(mnCadastro);

		JMenuItem mntmCadastroDeUsurios = new JMenuItem(
				"Cadastro de Usu\u00E1rios");
		mntmCadastroDeUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroUsuario tu = new TelaCadastroUsuario();
				
                tu.setLocationRelativeTo(null);
				tu.setVisible(true);
			}
		});
		mnCadastro.add(mntmCadastroDeUsurios);

		JMenu mnProdutos = new JMenu("Produtos");
		mnProdutos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.add(mnProdutos);

		JMenuItem mntmCadastroDeProdutos = new JMenuItem("Cadastro de Produtos");
		mntmCadastroDeProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProduto tp = new TelaCadastroProduto();
				tp.setLocationRelativeTo(null);
				tp.setVisible(true);
			}
		});
		mnProdutos.add(mntmCadastroDeProdutos);

		JMenu mnSobre = new JMenu("Sobre");

		mnSobre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.add(mnSobre);

		JMenuItem mntmEncerrarOPrograma = new JMenuItem(
				"Informa\u00E7\u00F5es sobre o Sistema\r\n");
		mnSobre.add(mntmEncerrarOPrograma);

		JMenu mnManual = new JMenu("Manual");
		mnManual.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.add(mnManual);

		JMenuItem mntmManualDoProduto = new JMenuItem("Manual do Produto");
		mntmManualDoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnManual.add(mntmManualDoProduto);

		JMenu mnSair = new JMenu("Sair");
		mnSair.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuBar.add(mnSair);

		JMenuItem mntmEncerrarPrograma = new JMenuItem("Encerrar Programa");
		mntmEncerrarPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnSair.add(mntmEncerrarPrograma);

		try {
			UIManager
					.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			try {

				UIManager
						.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				SwingUtilities.updateComponentTreeUI(this);
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(null, "Erro ao mudat look");
			}
		}
	}
}
