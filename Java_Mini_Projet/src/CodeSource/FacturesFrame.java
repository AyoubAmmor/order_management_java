package CodeSource;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JRadioButton;
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

public class FacturesFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNum;
	private JTextField txtDate;
	private JTextField txtMontant;
	private JTextField FaSupp;
	private JTextField txtCo;
	private JTextField txt1;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacturesFrame frame = new FacturesFrame();
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
	public FacturesFrame() {
		setResizable(false);
		setTitle("Facture");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 339);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 516, 58);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		
		JLabel lblEspaceDeGestion = new JLabel("Espace de gestion des factures");
		lblEspaceDeGestion.setForeground(Color.WHITE);
		lblEspaceDeGestion.setFont(new Font("Javanese Text", Font.BOLD, 25));
		panel.add(lblEspaceDeGestion);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 57, 516, 244);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Ajouter", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNumroDeLa = new JLabel("Num\u00E9ro de la facture  :");
		lblNumroDeLa.setForeground(Color.WHITE);
		lblNumroDeLa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumroDeLa.setBounds(37, 36, 161, 24);
		panel_1.add(lblNumroDeLa);
		
		JLabel lblNewLabel = new JLabel("Date de la facture :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(68, 71, 130, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblMontant = new JLabel("Montant :");
		lblMontant.setForeground(Color.WHITE);
		lblMontant.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMontant.setBounds(130, 105, 68, 14);
		panel_1.add(lblMontant);
		
		txtNum = new JTextField();
		txtNum.setBounds(208, 40, 154, 20);
		panel_1.add(txtNum);
		txtNum.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setText("jj/mm/aaaa");
		txtDate.setBounds(208, 70, 154, 20);
		panel_1.add(txtDate);
		txtDate.setColumns(10);
		
		txtMontant = new JTextField();
		txtMontant.setBounds(208, 104, 154, 20);
		panel_1.add(txtMontant);
		txtMontant.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setForeground(Color.BLACK);
		btnValider.setBackground(new Color(153, 0, 0));
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		             theQuery("insert into facture values('"+Integer.parseInt(txtNum.getText())+"','"+txtDate.getText()+"','"+Double.parseDouble(txtMontant.getText())+"','"+txtCo.getText()+"')");
		         }
		         catch(Exception ex){}
		         }
			
		});
		btnValider.setBounds(208, 182, 89, 23);
		panel_1.add(btnValider);
		
		txtCo = new JTextField();
		txtCo.setBounds(208, 136, 154, 20);
		panel_1.add(txtCo);
		txtCo.setColumns(10);
		
		JLabel lblNumroDeLa_2 = new JLabel("Num\u00E9ro de la commande :");
		lblNumroDeLa_2.setForeground(Color.WHITE);
		lblNumroDeLa_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumroDeLa_2.setBounds(17, 139, 181, 14);
		panel_1.add(lblNumroDeLa_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Modifier", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblVeuillezS = new JLabel("Veuillez saisir le num\u00E9ro de la facture \u00E0 modifier :");
		lblVeuillezS.setForeground(Color.WHITE);
		lblVeuillezS.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVeuillezS.setBounds(35, 11, 454, 14);
		panel_2.add(lblVeuillezS);
		
		txt1 = new JTextField();
		txt1.setBounds(127, 30, 270, 20);
		panel_2.add(txt1);
		txt1.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(0, 55, 511, 161);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblLesChamps = new JLabel("Les champs \u00E0 modifier :");
		lblLesChamps.setForeground(Color.WHITE);
		lblLesChamps.setBounds(138, 10, 233, 22);
		lblLesChamps.setFont(new Font("Sylfaen", Font.BOLD, 20));
		panel_4.add(lblLesChamps);
		
		JLabel lblDateDeLa = new JLabel("Date de la facture :");
		lblDateDeLa.setForeground(Color.WHITE);
		lblDateDeLa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateDeLa.setEnabled(true);
		lblDateDeLa.setBounds(81, 68, 117, 14);
		panel_4.add(lblDateDeLa);
		
		JLabel lblMontant_1 = new JLabel("Montant :");
		lblMontant_1.setForeground(Color.WHITE);
		lblMontant_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMontant_1.setBounds(138, 100, 60, 14);
		panel_4.add(lblMontant_1);
		
		JLabel lblNumroDeLa_3 = new JLabel("Num\u00E9ro de la commande :");
		lblNumroDeLa_3.setForeground(Color.WHITE);
		lblNumroDeLa_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumroDeLa_3.setBounds(35, 131, 163, 14);
		panel_4.add(lblNumroDeLa_3);
		
		txt3 = new JTextField();
		txt3.setText("jj/mm/aaaa");
		txt3.setBounds(208, 68, 126, 20);
		panel_4.add(txt3);
		txt3.setColumns(10);
		
		txt4 = new JTextField();
		txt4.setBounds(208, 99, 126, 20);
		panel_4.add(txt4);
		txt4.setColumns(10);
		
		txt5 = new JTextField();
		txt5.setBounds(208, 130, 126, 20);
		panel_4.add(txt5);
		txt5.setColumns(10);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setForeground(Color.BLACK);
		btnConfirmer.setBackground(new Color(153, 0, 0));
		btnConfirmer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection cnx=cnx();
				try {
					String req="update facture set numFacture=? ,DateFacture =? , montant=? , numCommande=? where numFacture= '"+Integer.parseInt(txt1.getText())+"'";
					PreparedStatement aj=cnx.prepareStatement(req);
					aj.setInt(1, (Integer.parseInt(txt2.getText())));
					aj.setString(2,(txt3.getText()));
					aj.setDouble(3, Double.parseDouble(txt4.getText()));
					aj.setInt(4, Integer.parseInt(txt5.getText()));
					
					
					aj.execute();
					JOptionPane.showMessageDialog(null, "Facture modifiée");
				}
					
				catch(Exception E) {
					System.out.println("Une erreur est survenue lors de la modification "+E);
					
				}
			}
		});
		btnConfirmer.setBounds(367, 121, 110, 23);
		panel_4.add(btnConfirmer);
		
		JLabel lblNumroDeLa_4 = new JLabel("Num\u00E9ro de la facture :");
		lblNumroDeLa_4.setForeground(Color.WHITE);
		lblNumroDeLa_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumroDeLa_4.setBounds(61, 43, 137, 14);
		panel_4.add(lblNumroDeLa_4);
		
		txt2 = new JTextField();
		txt2.setBounds(208, 42, 126, 20);
		panel_4.add(txt2);
		txt2.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Supprimer", null, panel_3, null);
		panel_3.setLayout(null);
		
		FaSupp = new JTextField();
		FaSupp.setText("");
		FaSupp.setBounds(296, 46, 162, 20);
		panel_3.add(FaSupp);
		FaSupp.setColumns(10);
		
		JLabel lblNumroDeLa_1 = new JLabel("Num\u00E9ro de la facture \u00E0 supprimer :");
		lblNumroDeLa_1.setForeground(Color.WHITE);
		lblNumroDeLa_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumroDeLa_1.setBounds(37, 47, 247, 14);
		panel_3.add(lblNumroDeLa_1);
		
		JButton btnValider_1 = new JButton("Valider");
		btnValider_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnValider_1.setForeground(Color.BLACK);
		btnValider_1.setBackground(new Color(153, 0, 0));
		btnValider_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			          
					 theQuery("delete from facture where numFacture = "+FaSupp.getText());
		         }
		         catch(Exception ex){
		        	 
		         }
			}
		});
		btnValider_1.setBounds(296, 90, 89, 23);
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
