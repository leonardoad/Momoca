package com.momoca.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.momoca.DAO.UsuarioDao;
import com.momoca.model.Usuario;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField TfNome;

	private JTextField TfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setTitle("Login de Usu\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 0, 284, 240);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblId = new JLabel("Nome:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(20, 130, 85, 14);
		panel.add(lblId);

		JLabel label = new JLabel("");
		label.setBounds(232, 13, 0, 0);
		panel.add(label);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(20, 170, 85, 14);
		panel.add(lblSenha);

		TfNome = new JTextField();
		TfNome.setBounds(115, 125, 159, 23);
		panel.add(TfNome);
		TfNome.setColumns(10);

		// Botão Login
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario usuario = new Usuario();
			
				try {
					UsuarioDao u = new UsuarioDao();
					usuario = u.getRetornaUsuario(TfNome.getText(), TfSenha.getText());
					
					if(usuario != null){
						Principal tela = new Principal();
						tela.setSize(1100, 680);
						tela.setLocationRelativeTo(null);
						tela.setVisible(true);						
					}else
						JOptionPane.showMessageDialog(null, "Nome/senha incorretos!");
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		btnLogin.setIcon(new ImageIcon("Imagens/LoginIcon.png"));
		btnLogin.setBounds(20, 206, 109, 23);
		panel.add(btnLogin);

		// Botão Cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);
			}

		});
		btnCancelar.setIcon(new ImageIcon("Imagens/cancelar.png"));
		btnCancelar.setBounds(149, 206, 109, 23);
		panel.add(btnCancelar);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Imagens/logoLogin.png"));
		lblNewLabel.setBounds(0, 0, 284, 88);
		panel.add(lblNewLabel);

		TfSenha = new JTextField();
		TfSenha.setBounds(115, 164, 159, 25);
		panel.add(TfSenha);
		TfSenha.setColumns(10);

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
