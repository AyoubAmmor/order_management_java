package CodeSource;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Window.Type;

public class ProduitsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtPr;
	private JTextField txtnm;
	private JTextField textqu;
	private JTextField textprix;
	private JTextField PrSupp;
	private JTextField txtprd;
	private JTextField txtnom;
	private JTextField txtqu;
	private JTextField txtprix;
	private JTextField txtpro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProduitsFrame frame = new ProduitsFrame();
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
	public ProduitsFrame() {
		setResizable(false);
		setTitle("Produit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 340);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 500, 57);
		contentPane.add(panel);
		
		JLabel lblGestionDesCommandes = new JLabel("Espace de gestion des produits ");
		lblGestionDesCommandes.setForeground(Color.WHITE);
		lblGestionDesCommandes.setFont(new Font("Javanese Text", Font.BOLD, 25));
		panel.add(lblGestionDesCommandes);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 55, 504, 256);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Ajouter", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNumroDuProduit = new JLabel("Num\u00E9ro du produit   :");
		lblNumroDuProduit.setForeground(Color.WHITE);
		lblNumroDuProduit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumroDuProduit.setBounds(39, 38, 155, 20);
		panel_1.add(lblNumroDuProduit);
		
		JLabel lblNomDuProduit = new JLabel("Nom du produit         :");
		lblNomDuProduit.setForeground(Color.WHITE);
		lblNomDuProduit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomDuProduit.setBounds(39, 67, 155, 20);
		panel_1.add(lblNomDuProduit);
		
		JLabel lblQuantit = new JLabel("Quantit\u00E9                      :");
		lblQuantit.setForeground(Color.WHITE);
		lblQuantit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantit.setBounds(39, 92, 155, 14);
		panel_1.add(lblQuantit);
		
		JLabel lblPrix = new JLabel("Prix                              :");
		lblPrix.setForeground(Color.WHITE);
		lblPrix.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrix.setBounds(39, 117, 155, 14);
		panel_1.add(lblPrix);
		
		txtPr = new JTextField();
		txtPr.setBounds(204, 37, 182, 20);
		panel_1.add(txtPr);
		txtPr.setColumns(10);
		
		txtnm = new JTextField();
		txtnm.setBounds(204, 66, 182, 20);
		panel_1.add(txtnm);
		txtnm.setColumns(10);
		
		textqu = new JTextField();
		textqu.setBounds(204, 91, 182, 20);
		panel_1.add(textqu);
		textqu.setColumns(10);
		
		textprix = new JTextField();
		textprix.setBounds(204, 116, 182, 20);
		panel_1.add(textprix);
		textprix.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBackground(new Color(153, 0, 0));
		btnValider.setForeground(Color.BLACK);
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		             theQuery("insert into produit values('"+Integer.parseInt(txtPr.getText())+"','"+txtnm.getText()+"',"+Integer.parseInt(textqu.getText())+","+Double.parseDouble(textprix.getText())+")");
		         }
		         catch(Exception ex){}
		         }
			
		});
		btnValider.setBounds(204, 154, 89, 23);
		panel_1.add(btnValider);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Modifier", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblVeuillezSaisirLe = new JLabel("Veuillez saisir le num\u00E9ro du produit \u00E0 modifier :");
		lblVeuillezSaisirLe.setForeground(Color.WHITE);
		lblVeuillezSaisirLe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVeuillezSaisirLe.setBounds(47, 11, 425, 20);
		panel_2.add(lblVeuillezSaisirLe);
		
		txtprd = new JTextField();
		txtprd.setBounds(145, 35, 220, 14);
		panel_2.add(txtprd);
		txtprd.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(0, 53, 495, 175);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblLesChamps = new JLabel("Les champs \u00E0 modifier :");
		lblLesChamps.setForeground(Color.WHITE);
		lblLesChamps.setBounds(135, 11, 226, 22);
		lblLesChamps.setFont(new Font("Sylfaen", Font.BOLD, 20));
		panel_4.add(lblLesChamps);
		
		JLabel lblNomDuProduit_1 = new JLabel("Nom du produit :");
		lblNomDuProduit_1.setForeground(Color.WHITE);
		lblNomDuProduit_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomDuProduit_1.setBounds(49, 69, 106, 19);
		panel_4.add(lblNomDuProduit_1);
		
		JLabel lblQuantit_1 = new JLabel("Quantit\u00E9 :");
		lblQuantit_1.setForeground(Color.WHITE);
		lblQuantit_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantit_1.setBounds(94, 99, 61, 14);
		panel_4.add(lblQuantit_1);
		
		JLabel lblPrix_1 = new JLabel("Prix :");
		lblPrix_1.setForeground(Color.WHITE);
		lblPrix_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrix_1.setBounds(123, 130, 32, 14);
		panel_4.add(lblPrix_1);
		
		txtnom = new JTextField();
		txtnom.setBounds(158, 69, 168, 20);
		panel_4.add(txtnom);
		txtnom.setColumns(10);
		
		txtqu = new JTextField();
		txtqu.setBounds(158, 98, 168, 20);
		panel_4.add(txtqu);
		txtqu.setColumns(10);
		
		txtprix = new JTextField();
		txtprix.setBounds(158, 129, 168, 20);
		panel_4.add(txtprix);
		txtprix.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmer");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(153, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String req="update produit set numProduit=? ,nomProduit =?,quantite=?,prix=?  where numProduit= '"+Integer.parseInt(txtprd.getText())+"'";
					PreparedStatement aj=cnx().prepareStatement(req);
					aj.setInt(1, (Integer.parseInt(txtpro.getText())));
					aj.setString(2,(txtnom.getText()));
					aj.setInt(3, Integer.parseInt(txtqu.getText()));
					aj.setInt(4, Integer.parseInt(txtprix.getText()));

					
					
					aj.execute();
					JOptionPane.showMessageDialog(null, "Livraison modifiée");
				}
					
				catch(Exception E) {
					System.out.println("Une erreur est survenue lors de la modification "+E);
					
				}
			}
			
		});
		btnNewButton.setBounds(354, 128, 106, 23);
		panel_4.add(btnNewButton);
		
		JLabel lblNumroDuProduit_2 = new JLabel("Num\u00E9ro du produit :");
		lblNumroDuProduit_2.setForeground(Color.WHITE);
		lblNumroDuProduit_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumroDuProduit_2.setBounds(29, 44, 126, 19);
		panel_4.add(lblNumroDuProduit_2);
		
		txtpro = new JTextField();
		txtpro.setBounds(158, 44, 168, 19);
		panel_4.add(txtpro);
		txtpro.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Supprimer", null, panel_3, null);
		panel_3.setLayout(null);
		
		PrSupp = new JTextField();
		PrSupp.setBounds(270, 43, 177, 20);
		panel_3.add(PrSupp);
		PrSupp.setColumns(10);
		
		JLabel lblNumroDuProduit_1 = new JLabel("Num\u00E9ro du produit \u00E0 supprimer :");
		lblNumroDuProduit_1.setForeground(Color.WHITE);
		lblNumroDuProduit_1.setBackground(Color.BLACK);
		lblNumroDuProduit_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumroDuProduit_1.setBounds(23, 38, 237, 27);
		panel_3.add(lblNumroDuProduit_1);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setForeground(Color.BLACK);
		btnConfirmer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirmer.setBackground(new Color(153, 0, 0));
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
			          
		             theQuery("delete from produit where numProduit = "+PrSupp.getText());
		         }
		         catch(Exception ex){
		        	 
		         }
			}
		});
		btnConfirmer.setBounds(270, 74, 115, 23);
		panel_3.add(btnConfirmer);
	}
	

	public void theQuery(String query){
	      Connection con = null;
	      Statement st = null;
	      try{
	    		String driver="com.mysql.jdbc.Driver";
				Class.forName(driver);
	          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/construction","root","");
	          st = con.createStatement();
	          st.executeUpdate(query);
	          JOptionPane.showMessageDialog(null,"Requête exécutée avec succès");
	      }catch(Exception ex){
	          JOptionPane.showMessageDialog(null,ex.getMessage());
	      }
	  }
	
	static Connection cnx() {
		try {
			String driver="com.mysql.jdbc.Driver";
			Class.forName(driver);
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/construction","root","");
			
		}
		catch(Exception e) {
			System.out.println("Connexion échouée "+e);
			}
			return null;
		}
	
	
}
