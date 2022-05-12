package CodeSource;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;


public class Connexion extends JFrame {
	
	

	private JPanel contentPane;
	private JPasswordField txtPass;
	private JTextField textUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion frame = new Connexion();
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
	public Connexion() {
		setResizable(false);
		
		setTitle("Connexion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 330);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username           :");
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		usernameLabel.setBounds(37, 76, 141, 37);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Mot de passe      :");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		passwordLabel.setBounds(37, 124, 141, 37);
		contentPane.add(passwordLabel);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(188, 126, 169, 35);
		contentPane.add(txtPass);
		
		textUser = new JTextField();
		textUser.setBounds(188, 78, 169, 37);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnValider.setBackground(new Color(153, 0, 0));
		btnValider.setForeground(Color.BLACK);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/construction","root","");
					Statement st=cnx.createStatement();
					
					String sql="Select * from connexion where login='"+textUser.getText()+"' and password='"+txtPass.getText().toString()+"' ";
					
					ResultSet rs=st.executeQuery(sql);
					
					if(rs.next()) {
						//JOptionPane.showMessageDialog(null, "ok");
						setState(ICONIFIED);
						MenuPrincipal mp=new MenuPrincipal();
						mp.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "Veuillez vérifier votre login et mot de passe !!");
					
					cnx.close();
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		});
		btnValider.setBounds(230, 196, 89, 23);
		contentPane.add(btnValider);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 434, 46);
		contentPane.add(panel);
		
		JLabel lblLogin = new JLabel("Login Access");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Javanese Text", Font.BOLD, 25));
		panel.add(lblLogin);
		
		JLabel lblNb = new JLabel("N.B : username : Ahmed \r\n");
		lblNb.setForeground(Color.RED);
		lblNb.setBackground(Color.WHITE);
		lblNb.setBounds(23, 205, 196, 60);
		contentPane.add(lblNb);
		
		JLabel lblNewLabel = new JLabel("mot de passe : 123");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(34, 251, 117, 14);
		contentPane.add(lblNewLabel);
	}
}
