import utilitarios.Conexao;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField pfSenha;
	private JTextField tfId;
        private Conexao conexao;

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
		
		JLabel lblId = new JLabel("ID Usu\u00E1rio:");
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
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(115, 165, 159, 28);
		panel.add(pfSenha);
		
		tfId = new JTextField();
		tfId.setBounds(115, 125, 159, 28);
		panel.add(tfId);
		tfId.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon("Imagens/LoginIcon.png"));
                btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            conexao = new Conexao();
                            conexao.conecta();
                            String user = tfId.getText();
                            String pass = new String(pfSenha.getPassword());
                            
                            try {
                                conexao.executarSQL("select count(*) as count from usuario where login = '"+user+"' and senha = '"+pass+"'");
                                conexao.resultSet.first();
                                if(conexao.resultSet.getString("count").equals("1")){
                                    TelaCadastroProduto tcp = new TelaCadastroProduto();
                                    tcp.setVisible(true);
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
		btnLogin.setBounds(20, 206, 109, 23);
		panel.add(btnLogin);
		
		JButton btnCancelar = new JButton("Limpar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            pfSenha.setText("");
                            tfId.setText("");
			}
		});
		btnCancelar.setIcon(new ImageIcon("Imagens/cancelar.png"));
		btnCancelar.setBounds(149, 206, 109, 23);
		panel.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Imagens/logoLogin.png"));
		lblNewLabel.setBounds(0, 0, 284, 88);
		panel.add(lblNewLabel);
		
		

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
