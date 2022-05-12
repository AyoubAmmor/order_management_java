package CodeSource;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class ClientsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNum;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtTel;
	private JTextField txtAdresse;
	private JTextField txtClSu;
	private JTextField txtnumCl;
	private JTextField Nomtxt;
	private JTextField textPrenom;
	private JTextField textTel;
	private JTextField textAdresse;
	private JTextField num;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientsFrame frame = new ClientsFrame();
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
	public ClientsFrame() {
		setResizable(false);
		setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 365);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 595, 62);
		contentPane.add(panel);
		
		JLabel lblEspaceDeGestion = new JLabel("Espace de gestion des clients ");
		lblEspaceDeGestion.setForeground(new Color(255, 255, 255));
		lblEspaceDeGestion.setFont(new Font("Javanese Text", Font.BOLD, 25));
		panel.add(lblEspaceDeGestion);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 62, 587, 267);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 0, 51));
		panel_1.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Ajouter", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNom = new JLabel("Num\u00E9ro du client(id) :");
		lblNom.setForeground(new Color(255, 255, 255));
		lblNom.setBackground(new Color(255, 255, 255));
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNom.setBounds(108, 40, 140, 14);
		panel_1.add(lblNom);
		
		txtNum = new JTextField();
		txtNum.setBounds(258, 37, 183, 20);
		panel_1.add(txtNum);
		txtNum.setColumns(10);
		
		JLabel lblNom_1 = new JLabel("Nom :");
		lblNom_1.setForeground(new Color(255, 255, 255));
		lblNom_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNom_1.setBounds(212, 65, 36, 14);
		panel_1.add(lblNom_1);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setForeground(new Color(255, 255, 255));
		lblPrnom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrnom.setBounds(190, 89, 58, 14);
		panel_1.add(lblPrnom);
		
		JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone :");
		lblTlphone.setForeground(new Color(255, 255, 255));
		lblTlphone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTlphone.setBounds(173, 114, 75, 14);
		panel_1.add(lblTlphone);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setForeground(new Color(255, 255, 255));
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdresse.setBounds(183, 139, 65, 14);
		panel_1.add(lblAdresse);
		
		txtNom = new JTextField();
		txtNom.setBounds(258, 63, 183, 20);
		panel_1.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(258, 87, 183, 20);
		panel_1.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		txtTel = new JTextField();
		txtTel.setBounds(258, 112, 183, 20);
		panel_1.add(txtTel);
		txtTel.setColumns(10);
		
		txtAdresse = new JTextField();
		txtAdresse.setBounds(258, 137, 183, 20);
		panel_1.add(txtAdresse);
		txtAdresse.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setForeground(Color.BLACK);
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnValider.setBackground(new Color(153, 0, 0));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
		             theQuery("insert into client values('"+Integer.parseInt(txtNum.getText())+"','"+txtNom.getText()+"','"+txtPrenom.getText()+"','"+Integer.parseInt(txtTel.getText())+"','"+txtAdresse.getText()+"')");
		         }
		         catch(Exception ex){}
				
		         }
				
				
			
		
		});
	
		btnValider.setBounds(308, 181, 89, 23);
		panel_1.add(btnValider);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Modifier", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblVeillezDonnerLe = new JLabel("Veillez saisir le num\u00E9ro du client \u00E0 modifier :");
		lblVeillezDonnerLe.setForeground(Color.WHITE);
		lblVeillezDonnerLe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVeillezDonnerLe.setBounds(80, 11, 436, 25);
		panel_2.add(lblVeillezDonnerLe);
		
		txtnumCl = new JTextField();
		txtnumCl.setBounds(151, 36, 266, 20);
		panel_2.add(txtnumCl);
		txtnumCl.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(0, 60, 582, 179);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblChampsModifier = new JLabel("Champs \u00E0 modifier :");
		lblChampsModifier.setForeground(Color.WHITE);
		lblChampsModifier.setBounds(186, 4, 194, 22);
		panel_4.add(lblChampsModifier);
		lblChampsModifier.setFont(new Font("Sylfaen", Font.BOLD, 20));
		
		JLabel lblNom_2 = new JLabel("Nom :");
		lblNom_2.setForeground(Color.WHITE);
		lblNom_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNom_2.setBounds(157, 69, 38, 14);
		panel_4.add(lblNom_2);
		
		JLabel lblPrnom_1 = new JLabel("Pr\u00E9nom :");
		lblPrnom_1.setForeground(Color.WHITE);
		lblPrnom_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrnom_1.setBounds(138, 94, 57, 14);
		panel_4.add(lblPrnom_1);
		
		JLabel lblTelphone = new JLabel("Tel\u00E9phone :");
		lblTelphone.setForeground(Color.WHITE);
		lblTelphone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelphone.setBounds(123, 119, 72, 19);
		panel_4.add(lblTelphone);
		
		JLabel lblAdresse_1 = new JLabel("Adresse :");
		lblAdresse_1.setForeground(Color.WHITE);
		lblAdresse_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdresse_1.setBounds(138, 149, 56, 14);
		panel_4.add(lblAdresse_1);
		
		Nomtxt = new JTextField();
		Nomtxt.setBounds(205, 68, 151, 20);
		panel_4.add(Nomtxt);
		Nomtxt.setColumns(10);
		
		textPrenom = new JTextField();
		textPrenom.setBounds(205, 93, 151, 20);
		panel_4.add(textPrenom);
		textPrenom.setColumns(10);
		
		textTel = new JTextField();
		textTel.setBounds(205, 118, 151, 20);
		panel_4.add(textTel);
		textTel.setColumns(10);
		
		textAdresse = new JTextField();
		textAdresse.setBounds(205, 148, 151, 20);
		panel_4.add(textAdresse);
		textAdresse.setColumns(10);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirmer.setForeground(Color.BLACK);
		btnConfirmer.setBackground(new Color(153, 0, 0));
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection cnx=cnx();
				try {
					String req="update client set numCl=? , nom =? , prenom=? , tel=? , adresse=? where numCl= '"+Integer.parseInt(txtnumCl.getText())+"'";
					PreparedStatement aj=cnx.prepareStatement(req);
					aj.setInt(1, (Integer.parseInt(num.getText())));
					aj.setString(2,(Nomtxt.getText()));
					aj.setString(3, textPrenom.getText());
					aj.setInt(4, Integer.parseInt(textTel.getText()));
					aj.setString(5,(textAdresse.getText()));
					
					aj.execute();
					JOptionPane.showMessageDialog(null, "Client modifié");
				}
					
				catch(Exception E) {
					System.out.println("Une erreur est survenue lors de la modification "+E);
					
				}
			}
				
		});
		btnConfirmer.setBounds(404, 145, 113, 23);
		panel_4.add(btnConfirmer);
		
		num = new JTextField();
		num.setBounds(205, 37, 151, 20);
		panel_4.add(num);
		num.setColumns(10);
		
		JLabel lblNumroDuClient = new JLabel("Num\u00E9ro du client :");
		lblNumroDuClient.setForeground(Color.WHITE);
		lblNumroDuClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumroDuClient.setBounds(82, 38, 113, 14);
		panel_4.add(lblNumroDuClient);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Supprimer", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblDonnezLeNumro = new JLabel("Donnez le num\u00E9ro du client \u00E0 supprimer");
		lblDonnezLeNumro.setForeground(Color.WHITE);
		lblDonnezLeNumro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDonnezLeNumro.setBounds(86, 55, 424, 30);
		panel_3.add(lblDonnezLeNumro);
		
		txtClSu = new JTextField();
		txtClSu.setBounds(171, 96, 231, 20);
		panel_3.add(txtClSu);
		txtClSu.setColumns(10);
		
		JButton btnValider_1 = new JButton("Valider");
		btnValider_1.setForeground(Color.BLACK);
		btnValider_1.setBackground(new Color(153, 0, 0));
		btnValider_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnValider_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
					
		             theQuery("delete from client where numCl = "+txtClSu.getText());
		             
		         }
		         catch(Exception ex){
		        	 
		         }
		         }
			
		});
		btnValider_1.setBounds(237, 127, 89, 23);
		panel_3.add(btnValider_1);
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

