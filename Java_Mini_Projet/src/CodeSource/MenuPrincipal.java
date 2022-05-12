package CodeSource;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JTree;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		
		setResizable(false);
		setTitle("Menu principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 381);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup group=new ButtonGroup();
		
		JRadioButton btnCl = new JRadioButton("    Les clients ");
		btnCl.setForeground(new Color(255, 255, 255));
		btnCl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCl.setBackground(Color.DARK_GRAY);
		group.add(btnCl);
		btnCl.setBounds(388, 48, 181, 32);
		contentPane.add(btnCl);
		
		JRadioButton btnPr = new JRadioButton("    Les produits");
		btnPr.setForeground(Color.WHITE);
		btnPr.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPr.setBackground(Color.DARK_GRAY);
		group.add(btnPr);
		btnPr.setBounds(388, 194, 181, 32);
		contentPane.add(btnPr);
		
		JRadioButton btnCo = new JRadioButton("    Les commandes");
		btnCo.setForeground(Color.WHITE);
		btnCo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCo.setBackground(Color.DARK_GRAY);
		group.add(btnCo);
		btnCo.setBounds(388, 143, 181, 32);
		contentPane.add(btnCo);
		
		JRadioButton btnLi = new JRadioButton("    Les livraisons");
		btnLi.setForeground(Color.WHITE);
		btnLi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLi.setBackground(Color.DARK_GRAY);
		group.add(btnLi);
		btnLi.setBounds(388, 252, 181, 32);
		contentPane.add(btnLi);
		
		JRadioButton btnFa = new JRadioButton("    Les factures");
		btnFa.setForeground(Color.WHITE);
		btnFa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFa.setBackground(Color.DARK_GRAY);
		group.add(btnFa);
		btnFa.setBounds(388, 94, 181, 32);
		contentPane.add(btnFa);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menuText);
		panel.setBounds(0, 0, 259, 342);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/gy.jpg")));
		lblNewLabel.setBounds(0, 0, 259, 342);
		panel.add(lblNewLabel);
		
		JLabel lblRConstructions = new JLabel("Menu Principal");
		lblRConstructions.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRConstructions.setFont(new Font("Sylfaen", Font.BOLD, 24));
		lblRConstructions.setForeground(Color.WHITE);
		lblRConstructions.setBackground(Color.WHITE);
		lblRConstructions.setBounds(40, 28, 184, 33);
		panel.add(lblRConstructions);
		
		Button btnConfirmer = new Button("Confirmer");
		btnConfirmer.setForeground(Color.BLACK);
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(btnCl.isSelected()) {
					setState(ICONIFIED);
					ClientsFrame cf=new ClientsFrame();
					cf.setVisible(true);
				}
				
				if(btnPr.isSelected()) {
					setState(ICONIFIED);
					ProduitsFrame pf=new ProduitsFrame();
					pf.setVisible(true);
				}
				
				if(btnCo.isSelected()) {
					setState(ICONIFIED);
					CommandesFrame cof=new CommandesFrame();
					cof.setVisible(true);
				}
				
				if(btnLi.isSelected()) {
					setState(ICONIFIED);
					LivraisonsFrame lf=new LivraisonsFrame();
					lf.setVisible(true);
				}
				
				if(btnFa.isSelected()) {
					setState(ICONIFIED);
					FacturesFrame fa=new FacturesFrame();
					fa.setVisible(true);
				}
			}
		});
		btnConfirmer.setFont(new Font("Bernard MT Condensed", Font.BOLD, 15));
		btnConfirmer.setBackground(new Color(204, 0, 51));
		btnConfirmer.setBounds(412, 309, 133, 23);
		contentPane.add(btnConfirmer);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/icons8-facture-64.png")));
		lblNewLabel_2.setBounds(317, 94, 65, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/icons8-gestion-des-clients-48.png")));
		lblNewLabel_1.setBounds(327, 51, 46, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/icons8-historique-des-commandes-48.png")));
		lblNewLabel_3.setBounds(327, 128, 46, 48);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/icons8-produit-50.png")));
		lblNewLabel_4.setBounds(325, 187, 46, 39);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/images/icons8-livraison-48.png")));
		lblNewLabel_5.setBounds(327, 236, 55, 48);
		contentPane.add(lblNewLabel_5);
	}
}
