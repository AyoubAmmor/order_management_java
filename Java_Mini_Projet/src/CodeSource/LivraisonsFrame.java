package CodeSource;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
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

public class LivraisonsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNum;
	private JTextField txtDate;
	private JTextField LiSupp;
	private JTextField txtCom;
	private JTextField txtliv;
	private JTextField txtdatelivr;
	private JTextField txtnumcom;
	private JTextField txtnumlivr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LivraisonsFrame frame = new LivraisonsFrame();
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
	public LivraisonsFrame() {
		setResizable(false);
		setTitle("Livraison ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 339);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 544, 57);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		
		JLabel lblEspaceDeGestion = new JLabel("Espace de gestion des livraisons ");
		lblEspaceDeGestion.setForeground(Color.WHITE);
		lblEspaceDeGestion.setFont(new Font("Javanese Text", Font.BOLD, 25));
		panel.add(lblEspaceDeGestion);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 57, 544, 245);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Ajouter", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNumroLivraison = new JLabel("Num\u00E9ro livraison        :");
		lblNumroLivraison.setForeground(Color.WHITE);
		lblNumroLivraison.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumroLivraison.setBounds(79, 47, 157, 14);
		panel_1.add(lblNumroLivraison);
		
		JLabel lblDateLivraison = new JLabel("Date livraison     :");
		lblDateLivraison.setForeground(Color.WHITE);
		lblDateLivraison.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateLivraison.setBounds(115, 87, 121, 14);
		panel_1.add(lblDateLivraison);
		
		txtNum = new JTextField();
		txtNum.setBounds(246, 46, 168, 20);
		panel_1.add(txtNum);
		txtNum.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setText("jj/mm/aaaa");
		txtDate.setBounds(246, 86, 168, 20);
		panel_1.add(txtDate);
		txtDate.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setForeground(Color.BLACK);
		btnValider.setBackground(new Color(153, 0, 0));
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
		             theQuery("insert into livraison values('"+Integer.parseInt(txtNum.getText())+"','"+txtDate.getText()+"','"+txtCom.getText()+"')");
		         }
		         catch(Exception ex){}
		         
			}
		});
		
		btnValider.setBounds(249, 183, 89, 23);
		panel_1.add(btnValider);
		
		JLabel lblNumroDeLa = new JLabel("Num\u00E9ro de la commande :");
		lblNumroDeLa.setForeground(Color.WHITE);
		lblNumroDeLa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumroDeLa.setBounds(50, 131, 186, 14);
		panel_1.add(lblNumroDeLa);
		
		txtCom = new JTextField();
		txtCom.setBounds(246, 130, 168, 20);
		panel_1.add(txtCom);
		txtCom.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Modifier", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblVeuillezSaisirLe = new JLabel("Veuillez saisir le num\u00E9ro de la livraison \u00E0 modifier :");
		lblVeuillezSaisirLe.setForeground(Color.WHITE);
		lblVeuillezSaisirLe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVeuillezSaisirLe.setBounds(41, 11, 456, 14);
		panel_2.add(lblVeuillezSaisirLe);
		
		txtliv = new JTextField();
		txtliv.setBounds(126, 36, 267, 20);
		panel_2.add(txtliv);
		txtliv.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(0, 65, 539, 152);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblChampsModifier = new JLabel("Champs \u00E0 modifier :");
		lblChampsModifier.setForeground(Color.WHITE);
		lblChampsModifier.setBounds(181, 16, 194, 22);
		lblChampsModifier.setFont(new Font("Sylfaen", Font.BOLD, 20));
		panel_4.add(lblChampsModifier);
		
		JLabel lblDateDeLivraison = new JLabel("Date de livraison :");
		lblDateDeLivraison.setForeground(Color.WHITE);
		lblDateDeLivraison.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateDeLivraison.setBounds(100, 86, 109, 14);
		panel_4.add(lblDateDeLivraison);
		
		JLabel lblNumroDeLa_1 = new JLabel("Num\u00E9ro de la commande :");
		lblNumroDeLa_1.setForeground(Color.WHITE);
		lblNumroDeLa_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumroDeLa_1.setBounds(46, 122, 163, 14);
		panel_4.add(lblNumroDeLa_1);
		
		txtdatelivr = new JTextField();
		txtdatelivr.setText("jj/mm/aaaa");
		txtdatelivr.setBounds(219, 85, 151, 20);
		panel_4.add(txtdatelivr);
		txtdatelivr.setColumns(10);
		
		txtnumcom = new JTextField();
		txtnumcom.setBounds(219, 121, 151, 20);
		panel_4.add(txtnumcom);
		txtnumcom.setColumns(10);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setForeground(new Color(0, 0, 0));
		btnConfirmer.setBackground(new Color(153, 0, 0));
		btnConfirmer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection cnx=cnx();
				try {
					String req="update livraison set numLivraison=? ,DateLivraison =?,numCommande=?  where numLivraison= '"+Integer.parseInt(txtliv.getText())+"'";
					PreparedStatement aj=cnx.prepareStatement(req);
					aj.setInt(1, (Integer.parseInt(txtnumlivr.getText())));
					aj.setString(2,(txtdatelivr.getText()));
					aj.setInt(3, Integer.parseInt(txtnumcom.getText()));
					
					
					aj.execute();
					JOptionPane.showMessageDialog(null, "Livraison modifiée");
				}
					
				catch(Exception E) {
					System.out.println("Une erreur est survenue lors de la modification "+E);
					
				}
			}
			
		});
		btnConfirmer.setBounds(400, 120, 109, 23);
		panel_4.add(btnConfirmer);
		
		JLabel lblNumroDeLa_2 = new JLabel("Num\u00E9ro de la livraison :");
		lblNumroDeLa_2.setForeground(Color.WHITE);
		lblNumroDeLa_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumroDeLa_2.setBounds(67, 49, 142, 14);
		panel_4.add(lblNumroDeLa_2);
		
		txtnumlivr = new JTextField();
		txtnumlivr.setBounds(219, 49, 151, 20);
		panel_4.add(txtnumlivr);
		txtnumlivr.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Supprimer", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNumeroDeLa = new JLabel("Numero de la livraison \u00E0 supprimer :");
		lblNumeroDeLa.setForeground(Color.WHITE);
		lblNumeroDeLa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumeroDeLa.setBounds(20, 44, 271, 22);
		panel_3.add(lblNumeroDeLa);
		
		LiSupp = new JTextField();
		LiSupp.setBounds(301, 47, 183, 20);
		panel_3.add(LiSupp);
		LiSupp.setColumns(10);
		
		JButton btnValider_1 = new JButton("Valider");
		btnValider_1.setBackground(new Color(153, 0, 0));
		btnValider_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnValider_1.setForeground(Color.BLACK);
		btnValider_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
			          
		             theQuery("delete from livraison where numLivraison = "+LiSupp.getText());
		         }
		         catch(Exception ex){
		        	 
		         }
			}
		});
		btnValider_1.setBounds(301, 92, 89, 23);
		panel_3.add(btnValider_1);
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
	
	
}
