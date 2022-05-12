package CodeSource;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;

public class CommandesFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtCo;
	private JTextField txtDateCo;
	private JTextField txtCoSu;
	private JTextField txtCl;
	private JTextField txt1;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CommandesFrame frame = new CommandesFrame();
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
	public CommandesFrame() {
		setResizable(false);
		setTitle("Commande");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 332);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 506, 57);
		contentPane.add(panel);
		
		JLabel lblEspaceDeGestion = new JLabel("Espace de gestion des commandes");
		lblEspaceDeGestion.setForeground(Color.WHITE);
		lblEspaceDeGestion.setFont(new Font("Javanese Text", Font.BOLD, 25));
		panel.add(lblEspaceDeGestion);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBounds(0, 57, 506, 236);
		contentPane.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("00/00/0000");
		panel_2.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Ajouter", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNumroDeLa = new JLabel("Num\u00E9ro de la commande :");
		lblNumroDeLa.setForeground(Color.WHITE);
		lblNumroDeLa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumroDeLa.setBounds(23, 47, 180, 14);
		panel_2.add(lblNumroDeLa);
		
		JLabel lblDateDeLa = new JLabel("Date de la commande     :");
		lblDateDeLa.setForeground(Color.WHITE);
		lblDateDeLa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateDeLa.setBounds(23, 84, 180, 18);
		panel_2.add(lblDateDeLa);
		
		txtCo = new JTextField();
		txtCo.setBounds(213, 44, 161, 20);
		panel_2.add(txtCo);
		txtCo.setColumns(10);
		
		txtDateCo = new JTextField();
		txtDateCo.setText("jj/mm/aaaa");
		txtDateCo.setToolTipText("");
		txtDateCo.setBounds(213, 84, 161, 20);
		panel_2.add(txtDateCo);
		txtDateCo.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setForeground(Color.BLACK);
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnValider.setBackground(new Color(153, 0, 0));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
		             theQuery("insert into commande values('"+Integer.parseInt(txtCo.getText())+"','"+txtDateCo.getText()+"','"+Integer.parseInt(txtCl.getText())+"')");
		         }
		         catch(Exception ex){}
		         }
			
		});
		btnValider.setBounds(213, 174, 89, 23);
		panel_2.add(btnValider);
		
		JLabel lblNumroDuClient = new JLabel("Num\u00E9ro du client             :");
		lblNumroDuClient.setForeground(Color.WHITE);
		lblNumroDuClient.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumroDuClient.setBounds(23, 131, 180, 18);
		panel_2.add(lblNumroDuClient);
		
		txtCl = new JTextField();
		txtCl.setBounds(213, 131, 161, 20);
		panel_2.add(txtCl);
		txtCl.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Modifier", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblVeuillezSaisirLe = new JLabel("Veuillez saisir le num\u00E9ro de la commande \u00E0 modifier :");
		lblVeuillezSaisirLe.setForeground(Color.WHITE);
		lblVeuillezSaisirLe.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblVeuillezSaisirLe.setBounds(31, 11, 460, 14);
		panel_1.add(lblVeuillezSaisirLe);
		
		txt1 = new JTextField();
		txt1.setBounds(142, 37, 226, 20);
		panel_1.add(txt1);
		txt1.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(0, 69, 501, 139);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblLesChamps = new JLabel("Les champs \u00E0 modifier :");
		lblLesChamps.setForeground(Color.WHITE);
		lblLesChamps.setBounds(151, 18, 231, 22);
		lblLesChamps.setFont(new Font("Sylfaen", Font.BOLD, 20));
		panel_4.add(lblLesChamps);
		
		JLabel lblDateDeLa_1 = new JLabel("Date de la commande :");
		lblDateDeLa_1.setForeground(Color.WHITE);
		lblDateDeLa_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateDeLa_1.setBounds(42, 79, 143, 14);
		panel_4.add(lblDateDeLa_1);
		
		JLabel lblNumroDuClient_1 = new JLabel("Num\u00E9ro du client :");
		lblNumroDuClient_1.setForeground(Color.WHITE);
		lblNumroDuClient_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumroDuClient_1.setBounds(72, 109, 113, 14);
		panel_4.add(lblNumroDuClient_1);
		
		txt3 = new JTextField();
		txt3.setText("jj/mm/aaaa");
		txt3.setBounds(194, 78, 162, 20);
		panel_4.add(txt3);
		txt3.setColumns(10);
		
		txt4 = new JTextField();
		txt4.setBounds(195, 108, 161, 20);
		panel_4.add(txt4);
		txt4.setColumns(10);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setForeground(Color.BLACK);
		btnConfirmer.setBackground(new Color(153, 0, 0));
		btnConfirmer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection cnx=cnx();
				try {
					String req="update commande set numCommande=? , DateCommande =? , numCl=?  where numCommande= '"+Integer.parseInt(txt1.getText())+"'";
					PreparedStatement aj=cnx.prepareStatement(req);
					aj.setInt(1, (Integer.parseInt(txt2.getText())));
					aj.setString(2,(txt3.getText()));
					aj.setInt(3, Integer.parseInt(txt4.getText()));
				
					
					aj.execute();
					JOptionPane.showMessageDialog(null, "Commande modifiée");
				}
					
				catch(Exception E) {
					System.out.println("Une erreur est survenue lors de la modification "+E);
					
				}
			}
		});
		btnConfirmer.setBounds(382, 107, 109, 23);
		panel_4.add(btnConfirmer);
		
		JLabel lblNumroDeLa_2 = new JLabel("Num\u00E9ro de la commande :");
		lblNumroDeLa_2.setForeground(Color.WHITE);
		lblNumroDeLa_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumroDeLa_2.setBounds(22, 51, 163, 14);
		panel_4.add(lblNumroDeLa_2);
		
		txt2 = new JTextField();
		txt2.setBounds(194, 50, 162, 20);
		panel_4.add(txt2);
		txt2.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Supprimer", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNumroDeLa_1 = new JLabel("Num\u00E9ro de la commande \u00E0 supprimer :");
		lblNumroDeLa_1.setForeground(Color.WHITE);
		lblNumroDeLa_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumroDeLa_1.setBounds(10, 40, 284, 24);
		panel_3.add(lblNumroDeLa_1);
		
		txtCoSu = new JTextField();
		txtCoSu.setBounds(304, 44, 175, 20);
		panel_3.add(txtCoSu);
		txtCoSu.setColumns(10);
		
		JButton btnValider_1 = new JButton("Valider");
		btnValider_1.setForeground(Color.BLACK);
		btnValider_1.setBackground(new Color(153, 0, 0));
		btnValider_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnValider_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try{
			          
		             theQuery("delete from commande where numCommande = "+txtCoSu.getText());
		         }
		         catch(Exception ex){
		        	 
		         }
		         }
		});
		btnValider_1.setBounds(185, 101, 89, 23);
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
