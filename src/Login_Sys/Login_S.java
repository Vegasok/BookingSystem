package Login_Sys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import booking_system.BookingSystem;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login_S {

	private JFrame frmAuthorization;
	private JFrame frmLoginSystem;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private Connection connection;
	public static String currentUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_S window = new Login_S();
					window.frmAuthorization.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_S() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAuthorization = new JFrame();
		frmAuthorization.setTitle("Authorization form");
		frmAuthorization.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 30));
		frmAuthorization.setBounds(100, 100, 450, 300);
		frmAuthorization.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAuthorization.getContentPane().setLayout(null);
		frmAuthorization.setLocationRelativeTo(null);      
		
		JLabel lblNewLabel = new JLabel("Login Systems");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(96, 11, 231, 35);
		frmAuthorization.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUsername.setBounds(39, 65, 170, 46);
		frmAuthorization.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPassword.setBounds(39, 129, 170, 46);
		frmAuthorization.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtUsername.setBounds(219, 68, 161, 40);
		frmAuthorization.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtPassword.setBounds(219, 132, 161, 40);
		frmAuthorization.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:FORTESTING","DWADM","DWADM");
					
					//JOptionPane.showMessageDialog(null, "Connection sucessfull!");
					
					String username = txtUsername.getText();
					String pass = txtPassword.getText();
					
					String query = "select * from USERPASSWORD where name=? and password=?";
					PreparedStatement statement = connection.prepareStatement(query);
					statement.setString(1, username);
					statement.setString(2, pass);
					
					ResultSet set = statement.executeQuery();
					
					if (set.next()) {
						JOptionPane.showMessageDialog(null, "Login Sucessfull");
						currentUser = set.getString("name");
						//System.out.print(currentUser);
						BookingSystem booking = new BookingSystem(); 
						BookingSystem.main(null);						
						frmAuthorization.dispose();						
						
					} else {
						JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					}
						
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						connection.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnLogin.setBounds(39, 203, 120, 40);
		frmAuthorization.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(167, 203, 120, 40);
		frmAuthorization.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmLoginSystem = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login Systems", 
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(295, 203, 100, 40);
		frmAuthorization.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 190, 400, 2);
		frmAuthorization.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 52, 400, 2);
		frmAuthorization.getContentPane().add(separator_1);
	}
}
