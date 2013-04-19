import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class TelaVenda extends JFrame {

	private JPanel contentPane;
	private JTextField tfTotal;
	private JTextField tfCodigo;
	private JTextField tfQuantidade;
	private JTextField tfValorUni;
	private JTable tbLista = new JTable();
	private JLabel lblFoto;
	private DefaultTableModel model;
	private JTextPane tfDescricao;
	private JScrollPane scrollPane;
	private JPopupMenu popupMenu;
	private JMenuItem mntmRemover;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVenda frame = new TelaVenda();
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
	public TelaVenda() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("" + e.getKeyCode());
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1090, 715);
		contentPane = new JPanel();

		contentPane.setBackground(UIManager.getColor("CheckBox.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblTotal = new JLabel("Total R$");
		lblTotal.setFont(new Font("Verdana", Font.PLAIN, 35));

		tfTotal = new JTextField();
		tfTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		tfTotal.setEditable(false);
		tfTotal.setFont(new Font("Verdana", Font.PLAIN, 35));
		tfTotal.setText("135,54");
		tfTotal.setColumns(10);

		JLabel lblProduto = new JLabel("Valor Unit\u00E1rio R$");
		lblProduto.setFont(new Font("Verdana", Font.PLAIN, 20));

		tfDescricao = new JTextPane();
		tfDescricao.setEditable(false);
		tfDescricao.setText("FARINHA DE MANDIOCA - GRANFINO - 500GR");
		tfDescricao.setFont(new Font("Verdana", Font.PLAIN, 20));

		JLabel lblPreoUnitrio = new JLabel("Qnt");
		lblPreoUnitrio.setHorizontalAlignment(SwingConstants.LEFT);
		lblPreoUnitrio.setFont(new Font("Verdana", Font.PLAIN, 20));

		tfCodigo = new JTextField();
		tfCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if (e.getKeyCode() == 113) {
					tfQuantidade.setEditable(true);
					tfQuantidade.requestFocus();
					tfQuantidade.selectAll();
				} else if (e.getKeyCode() == 10) {
					model = (DefaultTableModel) tbLista.getModel();
					model.addRow(new Object[] { 1, tfDescricao.getText(),
							tfValorUni.getText(), tfQuantidade.getText(),
							verificarTotal() });
					atualizarNumeros();
				} else if (e.getKeyCode() == 40) {

				}

			}
		});
		tfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfCodigo.setText("0123456789123");
		tfCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		tfCodigo.setColumns(10);

		JLabel lblQuantidade = new JLabel("C\u00F3digo de Barras");
		lblQuantidade.setFont(new Font("Verdana", Font.PLAIN, 20));

		tfQuantidade = new JTextField();
		tfQuantidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					tfQuantidade.setEditable(false);
					tfCodigo.requestFocus();

				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789";
				if (!caracteres.contains(e.getKeyChar() + ""))
					e.consume();
			}
		});

		tfQuantidade.setEditable(false);
		tfQuantidade.setText("5");
		tfQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
		tfQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfQuantidade.setColumns(10);

		lblFoto = new JLabel("");
		lblFoto.setIcon(new ImageIcon("Imagens/pao.jpg"));
		lblFoto.setOpaque(true);

		tfValorUni = new JTextField();
		tfValorUni.setEditable(false);
		tfValorUni.setFont(new Font("Verdana", Font.PLAIN, 20));
		tfValorUni.setHorizontalAlignment(SwingConstants.RIGHT);
		tfValorUni.setText("5.99");
		tfValorUni.setColumns(10);

		scrollPane = new JScrollPane();

		tbLista = new JTable();

		tbLista.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item", "Descri\u00E7\u00E3o", "Valor", "Qn", "Total"
			}
		));
		tbLista.getColumnModel().getColumn(0).setPreferredWidth(56);
		tbLista.getColumnModel().getColumn(1).setPreferredWidth(359);
		tbLista.getColumnModel().getColumn(3).setPreferredWidth(45);
		scrollPane.setViewportView(tbLista);

		popupMenu = new JPopupMenu();
		addPopup(tbLista, popupMenu);

		mntmRemover = new JMenuItem("Remover");
		mntmRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				model.removeRow(tbLista.getSelectedRow());}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null, "Selecione uma linha.");
				}
			}
		});
		popupMenu.add(mntmRemover);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Op\u00E7\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(UIManager.getColor("CheckBox.light"));
		panel.setLayout(null);

		JLabel lblF2 = new JLabel("F2 Mudar a quantidade");
		lblF2.setForeground(new Color(0, 0, 0));
		lblF2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblF2.setBounds(10, 24, 158, 20);
		panel.add(lblF2);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Imagens/logoTelaVenda.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(5)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								scrollPane,
																								GroupLayout.DEFAULT_SIZE,
																								668,
																								Short.MAX_VALUE)
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addGap(152)
																										.addComponent(
																												lblTotal,
																												GroupLayout.PREFERRED_SIZE,
																												161,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(44)
																										.addComponent(
																												tfTotal,
																												GroupLayout.PREFERRED_SIZE,
																												197,
																												GroupLayout.PREFERRED_SIZE)))
																		.addGap(18)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addComponent(
																												lblQuantidade,
																												GroupLayout.PREFERRED_SIZE,
																												233,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(53)
																										.addComponent(
																												lblPreoUnitrio,
																												GroupLayout.PREFERRED_SIZE,
																												77,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addComponent(
																												tfCodigo,
																												GroupLayout.PREFERRED_SIZE,
																												207,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(79)
																										.addComponent(
																												tfQuantidade,
																												GroupLayout.PREFERRED_SIZE,
																												77,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								tfDescricao,
																								GroupLayout.PREFERRED_SIZE,
																								363,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addComponent(
																												lblProduto,
																												GroupLayout.PREFERRED_SIZE,
																												180,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(61)
																										.addComponent(
																												tfValorUni,
																												GroupLayout.PREFERRED_SIZE,
																												122,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								panel,
																								GroupLayout.PREFERRED_SIZE,
																								363,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblFoto,
																								GroupLayout.PREFERRED_SIZE,
																								363,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				label,
																				GroupLayout.PREFERRED_SIZE,
																				460,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								Alignment.LEADING,
								gl_contentPane
										.createSequentialGroup()
										.addComponent(label,
												GroupLayout.PREFERRED_SIZE, 80,
												GroupLayout.PREFERRED_SIZE)
										.addGap(9)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				lblFoto,
																				GroupLayout.PREFERRED_SIZE,
																				210,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(29)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblQuantidade,
																								GroupLayout.PREFERRED_SIZE,
																								31,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblPreoUnitrio,
																								GroupLayout.PREFERRED_SIZE,
																								31,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(5)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								tfCodigo,
																								GroupLayout.PREFERRED_SIZE,
																								30,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								tfQuantidade,
																								GroupLayout.PREFERRED_SIZE,
																								30,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(11)
																		.addComponent(
																				tfDescricao,
																				GroupLayout.PREFERRED_SIZE,
																				74,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(11)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblProduto,
																								GroupLayout.PREFERRED_SIZE,
																								31,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addGap(4)
																										.addComponent(
																												tfValorUni,
																												GroupLayout.PREFERRED_SIZE,
																												30,
																												GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				8,
																				Short.MAX_VALUE)
																		.addComponent(
																				panel,
																				GroupLayout.PREFERRED_SIZE,
																				135,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				scrollPane,
																				GroupLayout.DEFAULT_SIZE,
																				488,
																				Short.MAX_VALUE)
																		.addGap(11)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblTotal,
																								GroupLayout.PREFERRED_SIZE,
																								58,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								tfTotal,
																								GroupLayout.PREFERRED_SIZE,
																								58,
																								GroupLayout.PREFERRED_SIZE))))));
		contentPane.setLayout(gl_contentPane);

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

	public void atualizarNumeros() {
		for (int i = 1; i <= tbLista.getRowCount(); i++) {
			model.setValueAt(i, i - 1, 0);
		}

	}

	public String verificarTotal() {

		DecimalFormat format = new DecimalFormat("#.##");
		int quant = Integer.parseInt(tfQuantidade.getText());
		double valor = Double.parseDouble(tfValorUni.getText());

		return format.format(quant * valor);
	}
	
	public void atualizarTotal(){
		for(int i =0;i<tbLista.getRowCount();i++){
			
		}
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
