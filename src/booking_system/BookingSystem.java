package booking_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Login_Sys.Login_S;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class BookingSystem {

	private JFrame frame;
	private JTable table;
	private JTable jTable1;
	private JTextField txtMemberID;
	private JTextField txtFirstname;
	private JTextField txtLastname;
	private Connection connection;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingSystem window = new BookingSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookingSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1370, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setLocationRelativeTo(null); 
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Football Club Booking System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		panel.add(lblNewLabel);
		
		table = new JTable();
		panel.add(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 1, 3, 3));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 3, 3, 3));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(3, 3, 2, 2));
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		
		JLabel lblVisitors = new JLabel("Visitors");
		lblVisitors.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_7.add(lblVisitors);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		
		JLabel lblNewLabel_1 = new JLabel("Ticket Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_8.add(lblNewLabel_1);
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_9.add(lblGender);
		
		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10);
		
		JRadioButton rdbtnNonmember = new JRadioButton("Non-Member");
		rdbtnNonmember.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_10.add(rdbtnNonmember);
		
		JPanel panel_11 = new JPanel();
		panel_4.add(panel_11);
		
		JRadioButton rdbtnSingle = new JRadioButton("Single");
		rdbtnSingle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_11.add(rdbtnSingle);
		
		JPanel panel_12 = new JPanel();
		panel_4.add(panel_12);
		
		JCheckBox chckbxFemale = new JCheckBox("Female");
		chckbxFemale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_12.add(chckbxFemale);
		
		JPanel panel_13 = new JPanel();
		panel_4.add(panel_13);
		
		JRadioButton rdbtnMembership = new JRadioButton("Membership");
		rdbtnMembership.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_13.add(rdbtnMembership);
		
		JPanel panel_14 = new JPanel();
		panel_4.add(panel_14);
		
		JRadioButton rdbtnAnnually = new JRadioButton("Annually");
		rdbtnAnnually.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_14.add(rdbtnAnnually);
		
		JPanel panel_15 = new JPanel();
		panel_4.add(panel_15);
		
		JCheckBox chckbxMale = new JCheckBox("Male");
		chckbxMale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_15.add(chckbxMale);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(3, 3, 1, 1));
		
		JPanel panel_16 = new JPanel();
		panel_5.add(panel_16);
		
		JLabel lblMemberId = new JLabel("Member ID");
		lblMemberId.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_16.add(lblMemberId);
		
		JPanel panel_17 = new JPanel();
		panel_5.add(panel_17);
		
		txtMemberID = new JTextField();
		txtMemberID.setEditable(false);
		txtMemberID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_17.add(txtMemberID);
		txtMemberID.setColumns(10);
		
		
		JPanel panel_18 = new JPanel();
		panel_5.add(panel_18);
		
		JLabel lblNewLabel_4 = new JLabel("Clubs     ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_18.add(lblNewLabel_4);
		
		JComboBox cmbRegions = new JComboBox();
		cmbRegions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbRegions.setModel(new DefaultComboBoxModel(new String[] {"Test1", "Test2"}));
		panel_18.add(cmbRegions);
		
		JPanel panel_19 = new JPanel();
		panel_5.add(panel_19);
		
		JLabel lblNewLabel_2 = new JLabel("Firstname");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_19.add(lblNewLabel_2);
		
		JPanel panel_20 = new JPanel();
		panel_5.add(panel_20);
		
		txtFirstname = new JTextField();
		txtFirstname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_20.add(txtFirstname);
		txtFirstname.setColumns(10);
		
		JPanel panel_21 = new JPanel();
		panel_5.add(panel_21);
		
		JPanel panel_22 = new JPanel();
		panel_5.add(panel_22);
		
		JLabel lblNewLabel_3 = new JLabel("Lastname");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_22.add(lblNewLabel_3);
		
		JPanel panel_23 = new JPanel();
		panel_5.add(panel_23);
		
		txtLastname = new JTextField();
		txtLastname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_23.add(txtLastname);
		txtLastname.setColumns(10);
		
		JPanel panel_24 = new JPanel();
		panel_5.add(panel_24);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdbtnNonmember.setSelected(false);
				rdbtnMembership.setSelected(false);
				rdbtnSingle.setSelected(false);
				rdbtnAnnually.setSelected(false);
				
				chckbxMale.setSelected(false);
				chckbxFemale.setSelected(false);
				
				txtMemberID.setText("");
				txtFirstname.setText("");
				txtLastname.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_6.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New Record");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMemberID.setEditable(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_6.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Confirm Booking");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
				
				model.addRow(new Object[] {txtMemberID.getText(), rdbtnNonmember.isSelected(), rdbtnMembership.isSelected(),
						rdbtnSingle.isSelected(), rdbtnAnnually.isSelected(), chckbxFemale.isSelected(),
						chckbxMale.isSelected(), txtFirstname.getText(), 
						txtLastname.getText(), cmbRegions.getSelectedItem().toString(),});
				
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:FORTESTING","DWADM","DWADM");
					
					JOptionPane.showMessageDialog(null, "Connection sucessfull!");
					
					Boolean nonmember = rdbtnNonmember.isSelected();
					Boolean membership = rdbtnMembership.isSelected();
					Boolean single = rdbtnSingle.isSelected();
					Boolean annually = rdbtnAnnually.isSelected();
					Boolean female = chckbxFemale.isSelected();
					Boolean male = chckbxMale.isSelected();
					String memberid = txtMemberID.getText();
					String firstname = txtFirstname.getText();
					String lastname = txtLastname.getText();
					String region = cmbRegions.getSelectedItem().toString();
					
					String query = "INSERT INTO booking_list (nonmember, membership, single, annually, female, male, memberid, firstname, lastname, region, login) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					
					PreparedStatement statement = connection.prepareStatement(query);
										
					if(nonmember) {
						statement.setString(1, "true");
					}else {
						statement.setString(1, "false");
					}
					
					if(membership) {
						statement.setString(2, "true");
					}else {
						statement.setString(2, "false");
					}
					
					if(single) {
						statement.setString(3, "true");
					}else {
						statement.setString(3, "false");
					}
					
					if(annually) {
						statement.setString(4, "true");
					}else {
						statement.setString(4, "false");
					}
					
					if(female) {
						statement.setString(5, "true");
					}else {
						statement.setString(5, "false");
					}
					
					if(male) {
						statement.setString(6, "true");
					}else {
						statement.setString(6, "false");
					}
														
					statement.setString(7, memberid);
					statement.setString(8, firstname);
					statement.setString(9, lastname);
					statement.setString(10, region);
					statement.setString(11, Login_S.currentUser);	
					statement.executeUpdate();
					
				} catch (ClassNotFoundException | SQLException e1) {					
					e1.printStackTrace();
				}finally {
					try {
						connection.close();
					} catch (SQLException e1) {						
						e1.printStackTrace();
					}
				}
				
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_6.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Save After Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Boolean nonmember = rdbtnNonmember.isSelected();
				Boolean membership = rdbtnMembership.isSelected();
				Boolean single = rdbtnSingle.isSelected();
				Boolean annually = rdbtnAnnually.isSelected();
				Boolean female = chckbxFemale.isSelected();
				Boolean male = chckbxMale.isSelected();
				String memberid = txtMemberID.getText();
				String firstname = txtFirstname.getText();
				String lastname = txtLastname.getText();
				String region = cmbRegions.getSelectedItem().toString();
				
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:FORTESTING","DWADM","DWADM");									
					
					String query = "update BOOKING_LIST set nonmember=?, membership=?, single=?, annually=?, female=?, male=?, firstname=?, lastname=?, region=?, login=? where memberid=?";
					PreparedStatement statement = connection.prepareStatement(query);	
					
					if(nonmember) {
						statement.setString(1, "true");
					}else {
						statement.setString(1, "false");
					}
					
					if(membership) {
						statement.setString(2, "true");
					}else {
						statement.setString(2, "false");
					}
					
					if(single) {
						statement.setString(3, "true");
					}else {
						statement.setString(3, "false");
					}
					
					if(annually) {
						statement.setString(4, "true");
					}else {
						statement.setString(4, "false");
					}
					
					if(female) {
						statement.setString(5, "true");
					}else {
						statement.setString(5, "false");
					}
					
					if(male) {
						statement.setString(6, "true");
					}else {
						statement.setString(6, "false");
					}										
					
					statement.setString(7, firstname);
					statement.setString(8, lastname);
					statement.setString(9, region);
					statement.setString(10, Login_S.currentUser);	
					statement.setString(11, memberid);
					statement.executeUpdate();
					
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
				
				model.setRowCount(0);
				model.addRow(new Object[] {"MemberID", "Visitor (Non-member)", "Visitor (Membership)", "Ticket(Single)", "Ticket(Annually)", "Female", "Male", "Firstname", "Lastname", "Selected Club"});
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:FORTESTING","DWADM","DWADM");
					
					//JOptionPane.showMessageDialog(null, "Connection sucessfull!");			
								
					String query = "select * from booking_list";
					PreparedStatement statement = connection.prepareStatement(query);
								
					ResultSet set = statement.executeQuery();
					
					while (set.next()) {
						String set_nonmeber = set.getString("nonmember");
						String set_membership = set.getString("membership");
						String set_single = set.getString("single");
						String set_annually = set.getString("annually");
						String set_female = set.getString("female");
						String set_male = set.getString("male");
						String set_memberid = set.getString("memberid");
						String set_firstname = set.getString("firstname");
						String set_lastname = set.getString("lastname");
						String set_region = set.getString("region");
						
						model.addRow(new Object[] { set_memberid, set_nonmeber, set_membership, set_single, set_annually, set_female, set_male,   set_firstname, set_lastname, set_region});
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
				
				//JOptionPane.showMessageDialog(null, "Booking System Save", "Booking System", JOptionPane.OK_CANCEL_OPTION);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_6.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 1, 1));
		
		JPanel panel_26 = new JPanel();
		panel_26.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.add(panel_26);
		panel_26.setLayout(new BorderLayout(0, 0));		
		
		model = new DefaultTableModel(new String[]{"MemberID", "Visitor (Non-member)", "Visitor (Membership)", "Ticket(Single)", "Ticket(Annually)", "Female", "Male", "Firstname", "Lastname", "Selected Club"}, 0);
		model.addRow(new Object[] {"MemberID", "Visitor (Non-member)", "Visitor (Membership)", "Ticket(Single)", "Ticket(Annually)", "Female", "Male", "Firstname", "Lastname", "Selected Club"});	
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:FORTESTING","DWADM","DWADM");
			
			//JOptionPane.showMessageDialog(null, "Connection sucessfull!");			
						
			String query = "select * from booking_list";
			PreparedStatement statement = connection.prepareStatement(query);
						
			ResultSet set = statement.executeQuery();
			
			while (set.next()) {
				String set_nonmeber = set.getString("nonmember");
				String set_membership = set.getString("membership");
				String set_single = set.getString("single");
				String set_annually = set.getString("annually");
				String set_female = set.getString("female");
				String set_male = set.getString("male");
				String set_memberid = set.getString("memberid");
				String set_firstname = set.getString("firstname");
				String set_lastname = set.getString("lastname");
				String set_region = set.getString("region");
				
				model.addRow(new Object[] { set_memberid, set_nonmeber, set_membership, set_single, set_annually, set_female, set_male,   set_firstname, set_lastname, set_region});
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
		
		jTable1 = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(jTable1);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel_26.add(scrollPane);
        
		jTable1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		jTable1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		jTable1.setModel(model);		
		
		jTable1.setBorder(new LineBorder(new Color(0, 0, 0)));
		jTable1.setFillsViewportHeight(true);
		jTable1.setColumnSelectionAllowed(true);
		jTable1.setCellSelectionEnabled(true);
				
		JPanel panel_25 = new JPanel();
		panel_25.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.add(panel_25);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
								
								
				int[] rows = jTable1.getSelectedRows();														
				
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:FORTESTING","DWADM","DWADM");
								
					String query = "delete from booking_list where memberid=?";
					PreparedStatement statement = connection.prepareStatement(query);
					
					//System.out.println(Arrays.toString(rows));					
					
					if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to delete data", "Booking Systems", 
							JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
						
						for(int i=0;i<rows.length;i++){												
							statement.setString(1, model.getValueAt(rows[i], 0).toString());							
							statement.executeUpdate();
						}
						
						int[] row = jTable1.getSelectedRows();	
						//System.out.println(Arrays.toString(rows));
						   for(int j=0;j<row.length;j++){
						     model.removeRow(row[j]-j);
						   }					   
						
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
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_25.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMemberID.setEditable(false);
				int row = jTable1.getSelectedRow();	
				
				/*System.out.print(row);
				System.out.print(model.getValueAt(row, 0).toString());
				*/
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:FORTESTING","DWADM","DWADM");
					
					String query = "select * from BOOKING_LIST where memberid=?";
					PreparedStatement statement = connection.prepareStatement(query);	
					statement.setString(1, model.getValueAt(row, 0).toString());
					ResultSet set = statement.executeQuery();
					
					if(set.next()) {
						
						if(set.getString("nonmember").equals("true")) {
							rdbtnNonmember.setSelected(true);
						}else {
							rdbtnNonmember.setSelected(false);
						}
						
						if(set.getString("membership").equals("true")) {
							rdbtnMembership.setSelected(true);
						}else {
							rdbtnMembership.setSelected(false);
						}
						
						if(set.getString("single").equals("true")) {
							rdbtnSingle.setSelected(true);
						}else {
							rdbtnSingle.setSelected(false);
						}
						
						if(set.getString("annually").equals("true")) {
							rdbtnAnnually.setSelected(true);
						}else {
							rdbtnAnnually.setSelected(false);
						}
						
						if(set.getString("female").equals("true")) {
							chckbxFemale.setSelected(true);
						}else {
							chckbxFemale.setSelected(false);
						}
						
						if(set.getString("male").equals("true")) {
							chckbxMale.setSelected(true);
						}else {
							chckbxMale.setSelected(false);
						}
						
						txtMemberID.setText(set.getString("memberid"));
						txtFirstname.setText(set.getString("firstname"));
						txtLastname.setText(set.getString("lastname"));
						cmbRegions.setSelectedItem(set.getString("region"));		
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
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_25.add(btnUpdate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdbtnNonmember.setSelected(false);
				rdbtnMembership.setSelected(false);
				rdbtnSingle.setSelected(false);
				rdbtnAnnually.setSelected(false);
				
				chckbxMale.setSelected(false);
				chckbxFemale.setSelected(false);
				
				txtMemberID.setText("");
				txtFirstname.setText("");
				txtLastname.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_25.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Booking Systems", 
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_25.add(btnExit);
	}

}
