package com.momoca.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;


public class TelaCadastroUsuario extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 55, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(10, 80, 46, 14);
		contentPane.add(lblCargo);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 118, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:");
		lblConfirmarSenha.setBounds(10, 143, 83, 14);
		contentPane.add(lblConfirmarSenha);
	}

}
