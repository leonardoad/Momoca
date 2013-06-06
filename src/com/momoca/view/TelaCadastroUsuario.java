package com.momoca.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class TelaCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario frame = new TelaCadastroUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroUsuario() {
		setTitle("Cadastro de Usu\u00E1rios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 741, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(40, 72, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(40, 110, 46, 14);
		contentPane.add(lblCargo);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(40, 148, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:");
		lblConfirmarSenha.setBounds(40, 188, 107, 14);
		contentPane.add(lblConfirmarSenha);
		
		textField = new JTextField();
		textField.setBounds(115, 69, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 107, 153, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(158, 145, 107, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(157, 185, 108, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon("Imagens/logoLogin.png"));
		labelLogo.setBounds(357, 98, 284, 89);
		contentPane.add(labelLogo);
		
		btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(35, 243, 112, 33);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.setBounds(159, 243, 106, 33);
		contentPane.add(btnNewButton_1);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(275, 243, 106, 33);
		contentPane.add(btnExcluir);
		
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
