package application;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controller.UserController;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;
import javax.swing.ButtonGroup;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewBook {
	
	UserController usercontroler = new UserController();
	
	
	
	private JFrame frame;
	private JTextField username;
	private JPasswordField password;
	private JTextField nameLogOn;
	private JTextField surnameLogOn;
	private JTextField sexLogOn;
	private JTextField surnameReg;
	private JTextField nameReg;
	private JTextField usernameReg;
	private JPasswordField passwordReg;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private JTextField adminSearch;
	
	private int brojac = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBook window = new NewBook();
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
	public NewBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 462, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelHome = new JPanel();
		panelHome.setBounds(0, 0, 436, 434);
		frame.getContentPane().add(panelHome);
		panelHome.setLayout(null);
		
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 450, 450);
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		loginPanel.setVisible(false);
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBounds(0, 0, 450, 450);
		frame.getContentPane().add(registerPanel);
		registerPanel.setLayout(null);
		registerPanel.setVisible(false);
		
		JPanel adminPanel = new JPanel();
		adminPanel.setBounds(0, 0, 450, 450);
		frame.getContentPane().add(adminPanel);
		adminPanel.setLayout(null);
		adminPanel.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 68, 407, 299);
		adminPanel.add(scrollPane);
		
		JButton adminLogOutBtn = new JButton("Log out");
		adminLogOutBtn.setBounds(324, 34, 89, 23);
		adminPanel.add(adminLogOutBtn);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Surname", "Sex"
			}
		));
		
		JButton deleteBtn = new JButton("Delete selected user");
		deleteBtn.setBounds(20, 378, 183, 23);
		adminPanel.add(deleteBtn);
		
		adminSearch = new JTextField();
		adminSearch.setBounds(20, 412, 249, 20);
		adminPanel.add(adminSearch);
		adminSearch.setColumns(10);
		
		JButton adminSerachBtn = new JButton("Search by surname");
		adminSerachBtn.setBounds(279, 411, 147, 23);
		adminPanel.add(adminSerachBtn);
		
		JButton updateBtn = new JButton("Update selected user");
		updateBtn.setBounds(213, 378, 213, 23);
		adminPanel.add(updateBtn);
		
		JLabel usernameUsed = new JLabel("Username already in use!!");
		usernameUsed.setEnabled(true);
		usernameUsed.setForeground(Color.RED);
		usernameUsed.setBounds(170, 279, 167, 20);
		registerPanel.add(usernameUsed);
		usernameUsed.setVisible(false);
		
		JLabel registerLabel_4 = new JLabel("Sex");
		registerLabel_4.setBounds(114, 214, 46, 14);
		registerPanel.add(registerLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Surname");
		lblNewLabel_3.setBounds(114, 165, 46, 14);
		registerPanel.add(lblNewLabel_3);
		
		surnameReg = new JTextField();
		surnameReg.setText("");
		surnameReg.setColumns(10);
		surnameReg.setBounds(170, 162, 167, 20);
		registerPanel.add(surnameReg);
		
		nameReg = new JTextField();
		nameReg.setColumns(10);
		nameReg.setBounds(170, 114, 167, 20);
		registerPanel.add(nameReg);
		
		JLabel registerLabel_2 = new JLabel("Name");
		registerLabel_2.setBounds(114, 117, 46, 14);
		registerPanel.add(registerLabel_2);
		
		JLabel registerLabel = new JLabel("NEW BOOK");
		registerLabel.setFont(new Font("Poor Richard", Font.BOLD | Font.ITALIC, 30));
		registerLabel.setBounds(127, 41, 174, 48);
		registerPanel.add(registerLabel);
		
		JRadioButton male = new JRadioButton("M");
		male.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonGroup.add(male);
		buttonGroup.add(male);
		male.setBounds(167, 210, 33, 23);
		registerPanel.add(male);
		
		JRadioButton female = new JRadioButton("F");
		female.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonGroup.add(female);
		buttonGroup.add(female);
		female.setBounds(228, 210, 33, 23);
		registerPanel.add(female);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(114, 261, 55, 20);
		registerPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setBounds(114, 313, 46, 14);
		registerPanel.add(lblNewLabel_5);
		
		usernameReg = new JTextField();
		usernameReg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				if (!Character.isLetter(c)) {
					e.consume();
				}
				
			}
		});
		usernameReg.setBounds(170, 261, 167, 20);
		registerPanel.add(usernameReg);
		usernameReg.setColumns(10);
		
		passwordReg = new JPasswordField();
		passwordReg.setBounds(170, 310, 167, 20);
		registerPanel.add(passwordReg);
		
		JButton registrationBtn = new JButton("Register");
		registrationBtn.setBounds(248, 363, 89, 23);
		registerPanel.add(registrationBtn);
		
		JLabel lblNewLabel = new JLabel("NEW BOOK");
		lblNewLabel.setBounds(145, 76, 174, 35);
		lblNewLabel.setFont(new Font("Poor Richard", Font.BOLD | Font.ITALIC, 30));
		panelHome.add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(177, 174, 168, 20);
		panelHome.add(username);
		username.setColumns(10);
		
		JLabel NewLabel_1 = new JLabel("Username");
		NewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		NewLabel_1.setBounds(85, 174, 82, 23);
		panelHome.add(NewLabel_1);
		
		JLabel passwordlabej = new JLabel("Password");
		passwordlabej.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordlabej.setBounds(85, 208, 82, 36);
		panelHome.add(passwordlabej);
		
		JLabel logonLabel = new JLabel("NEW BOOK");
		logonLabel.setBounds(121, 11, 174, 48);
		logonLabel.setFont(new Font("Poor Richard", Font.BOLD | Font.ITALIC, 30));
		loginPanel.add(logonLabel);
		
		JLabel logonLabel_1 = new JLabel("");
		logonLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		logonLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 5));
		logonLabel_1.setIcon(new ImageIcon("D:\\programiranje java\\NewBook\\profile.png"));
		logonLabel_1.setBounds(22, 86, 137, 165);
		loginPanel.add(logonLabel_1);
		
		JLabel logonLabel_2 = new JLabel("Name");
		logonLabel_2.setBounds(169, 100, 46, 14);
		loginPanel.add(logonLabel_2);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(303, 225, 89, 23);
		loginPanel.add(logoutBtn);
		
		
		nameLogOn = new JTextField();
		nameLogOn.setBounds(225, 97, 167, 20);
		loginPanel.add(nameLogOn);
		nameLogOn.setColumns(10);
		
		JLabel logonLabel_3 = new JLabel("Surname");
		logonLabel_3.setBounds(169, 148, 46, 14);
		loginPanel.add(logonLabel_3);
		
		surnameLogOn = new JTextField();
		surnameLogOn.setText("");
		surnameLogOn.setBounds(225, 145, 167, 20);
		loginPanel.add(surnameLogOn);
		surnameLogOn.setColumns(10);
		
		JLabel logonLabel_4 = new JLabel("Sex");
		logonLabel_4.setBounds(169, 197, 46, 14);
		loginPanel.add(logonLabel_4);
		
		sexLogOn = new JTextField();
		sexLogOn.setBounds(225, 194, 167, 20);
		loginPanel.add(sexLogOn);
		sexLogOn.setColumns(10);
		
		frame.getContentPane().add(loginPanel);
		
		JButton loginBtn = new JButton("Login");
		
		loginBtn.setBounds(263, 274, 82, 55);
		panelHome.add(loginBtn);
		
		JLabel lblNewLabel_2 = new JLabel("Don't have acc?");
		lblNewLabel_2.setBounds(85, 268, 168, 35);
		panelHome.add(lblNewLabel_2);
		
		JButton registerBtn = new JButton(" Register now for \"free\"!");
		registerBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		registerBtn.setBounds(85, 306, 153, 23);
		panelHome.add(registerBtn);
		
		password = new JPasswordField();
		password.setBounds(177, 219, 168, 20);
		panelHome.add(password);
		
		JLabel wrongUsername = new JLabel("Wrong username or password!!");
		wrongUsername.setForeground(Color.RED);
		wrongUsername.setBounds(177, 235, 184, 28);
		panelHome.add(wrongUsername);
		wrongUsername.setVisible(false);
		
		JLabel blankUsername = new JLabel("Username or password can't be blank!!");
		blankUsername.setForeground(Color.RED);
		blankUsername.setBounds(177, 235, 249, 28);
		panelHome.add(blankUsername);
		blankUsername.setVisible(false);
		
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usernames = username.getText();
				String passwords = new String( password.getPassword());
				boolean userPass = false;
				String[] userInfo;
				
				try {
					
					FileWriter fw = new FileWriter("users.txt", true);
					fw.close();
					
				}
				catch(IOException txt) {
					
					System.out.println(txt);
					
				}
				if((!usernames.equals("") && !passwords.equals("")) && (!usernames.equals("admin")&& !passwords.equals("admin")) )
					userPass = usercontroler.checkUserPass(usernames, passwords);
				
				
				if(usernames.equals("admin")&& passwords.equals("admin")) {
					panelHome.setVisible(false);
					wrongUsername.setVisible(false);
					blankUsername.setVisible(false);
					adminPanel.setVisible(true);
					username.setText("");
					password.setText("");
					DefaultTableModel tables = (DefaultTableModel)table.getModel();
					tables.setRowCount(0);
					
					try {
						
						File users = new File("users.txt");
						BufferedReader bf = new BufferedReader (new FileReader(users));
						String allUsers;
						String[] userName;
						String[] oneUserForTable;
						tables = (DefaultTableModel)table.getModel();
						
						while((allUsers = bf.readLine())!= null)
						{
							userName = allUsers.split(", ");
							File oneUser = new File(userName[0]+".txt");
							BufferedReader oneUserBF = new BufferedReader (new FileReader(oneUser));
							oneUserForTable = oneUserBF.readLine().split(", ");
							
							tables.addRow(oneUserForTable);
							oneUserBF.close();
						
						}
						bf.close();	
						
					}
					catch(IOException es){
						System.out.println (e);
						
					}	
					
					
				}
				else if(usernames.equals("") && passwords.equals(""))
				{
					wrongUsername.setVisible(false);
					blankUsername.setVisible(true);
				}
				else {
					if(userPass) {
						JOptionPane.showMessageDialog(frame, "Welcome back "+usernames);
						panelHome.setVisible(false);
						blankUsername.setVisible(false);
						wrongUsername.setVisible(false);
						loginPanel.setVisible(true);
						userInfo = usercontroler.setUserInfo(usernames).split(", ");
					
						nameLogOn.setText(userInfo[0]);
						surnameLogOn.setText(userInfo[1]);
						sexLogOn.setText(userInfo[2]);
						nameLogOn.setEditable(false);
						surnameLogOn.setEditable(false);
						sexLogOn.setEditable(false);
						
					}
					else {
						blankUsername.setVisible(false);
						wrongUsername.setVisible(true);
						username.setText("");
						password.setText("");
					}
				}
				
			}
		});
		
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelHome.setVisible(true);
				loginPanel.setVisible(false);

				nameLogOn.setText("");
				surnameLogOn.setText("");
				sexLogOn.setText("");
				username.setText("");
				password.setText("");
				blankUsername.setVisible(false);
				wrongUsername.setVisible(false);
	
			}
		});
		
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelHome.setVisible(false);
				registerPanel.setVisible(true);

				
			}
		});
		
		registrationBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nameRegs, surnameRegs, usernameRegs, passwordRegs;
				boolean males = male.isSelected();
				boolean females = female.isSelected();
				boolean readyToReg = true;
				try {
				File fw = new File("users.txt");
				
				fw.createNewFile();
				}
				catch(IOException eash) {
					System.out.print(eash);
				}
				nameRegs = nameReg.getText();
				surnameRegs = surnameReg.getText();
				usernameRegs = usernameReg.getText();
				passwordRegs = new String(passwordReg.getPassword());
				
				if(nameRegs.equals("") || surnameRegs.equals("")|| usernameRegs.equals("") || passwordRegs.equals("") || (!males && !females))
					JOptionPane.showMessageDialog(frame, "All field must be entered!!");
				else {
				
				try {
					
					
					File users = new File("users.txt");
					BufferedReader bf = new BufferedReader (new FileReader(users));
					String user;
					String[] userTrue;
					boolean userMatch = false;
					
					FileWriter fw = new FileWriter("users.txt", true);
					
					fw.close();
					
					
					while((user = bf.readLine())!= null)
					{
						userTrue = user.split(", ");
						userMatch = usernameRegs.equals(userTrue[0]);
						
						if(userMatch)
						{
							//JOptionPane.showMessageDialog(frame, "Username in use!!");
							usernameUsed.setVisible(true);
							usernameReg.setText("");
							readyToReg = false;
							break;
						}
						else readyToReg = true;
				
					}
					bf.close();
					
					if(readyToReg)
					{
						fw = new FileWriter(""+usernameRegs+".txt");
						
						if(males)
							fw.write(nameRegs+", "+surnameRegs+", "+"Male \n");
						else
							fw.write(nameRegs+", "+surnameRegs+", "+"Female \n");
						fw.close();
						
						fw = new FileWriter("users.txt", true);
						fw.write(usernameRegs+", "+passwordRegs+"\n");
						fw.close();
						
						JOptionPane.showMessageDialog(frame, "Thank you for registration pls login.");
						
						nameReg.setText("");
						surnameReg.setText("");
						usernameReg.setText("");
						passwordReg.setText("");
						buttonGroup.clearSelection();
						usernameUsed.setVisible(false);
						
						registerPanel.setVisible(false);
						panelHome.setVisible(true);
					
					}
					
								
				}
				catch(IOException eh){
					System.out.println (e);
					
				}	
				blankUsername.setVisible(false);
				wrongUsername.setVisible(false);
			}
				
		}
				
			
		});
	
		adminLogOutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				blankUsername.setVisible(false);
				wrongUsername.setVisible(false);
				panelHome.setVisible(true);
				adminPanel.setVisible(false);
				
				
			}
		});
		
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					String[] opcijeBrisanje = {"Delete selected user", "Delete all", "Nothing"};
					int odabirBrisanja = JOptionPane.showOptionDialog(null, "What would you delete?", "Delete", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcijeBrisanje, opcijeBrisanje[0]);
					//JOptionPane.showMessageDialog(null, odabirBrisanja);
					
					//asdsad, asdsa
					//asd, asd
					//das, asd
					//dsa, dsa
					//dsadas, asd
					//asdsa, asdas

					
					if (odabirBrisanja == 0)
					{
						int redBr = table.getSelectedRows().length;
						int index = table.getSelectedRow();
						if (redBr < 1)
							JOptionPane.showMessageDialog(null, "Pls select one row!!");
						else	
						{
							for(int i=0; i<redBr ; i++ ) 
							{
								DefaultTableModel tablicas = (DefaultTableModel)table.getModel();
								tablicas.removeRow(index);
							}
							try
							{
								
								File users = new File("users.txt");
								BufferedReader bf = new BufferedReader (new FileReader(users));
								String allUsers;
								String[] userName;
								String[] oneUserForTable;
								DefaultTableModel tables = (DefaultTableModel)table.getModel();
								brojac = 0;
								tables.setRowCount(0);
								FileWriter newUserList = new FileWriter("newuserlist.txt");
								
								while((allUsers = bf.readLine())!= null)
								{
									
									userName = allUsers.split(", ");
									File oneUser = new File(userName[0]+".txt");
									
									if(brojac == index) {
										oneUser.delete();
										
									}
									else {
										newUserList.write(allUsers+"\n");
										BufferedReader oneUserBF = new BufferedReader (new FileReader(oneUser));
										oneUserForTable = oneUserBF.readLine().split(", ");
										
										tables.addRow(oneUserForTable);
										oneUserBF.close();
									}
									brojac++;
																	
								}
								bf.close();
								newUserList.close();
								users = new File("newuserlist.txt");
								bf = new BufferedReader (new FileReader(users));
								newUserList = new FileWriter("users.txt");
								while((allUsers = bf.readLine())!= null)
								{
									newUserList.write(allUsers+"\n");
																										
								}
								
								bf.close();
								newUserList.close();
								
							}
							catch (IOException e4)
							{
								JOptionPane.showMessageDialog(frame, "Something went wrong try again!!");
							}
						}
					}
					else if (odabirBrisanja == 1)
					{

						
						File users = new File("users.txt");
						BufferedReader bf = new BufferedReader (new FileReader(users));
						String allUsers;
						String[] userName;
						String[] oneUserForTable;
						DefaultTableModel tables = (DefaultTableModel)table.getModel();
						
						
						while((allUsers = bf.readLine())!= null)
						{
							
							userName = allUsers.split(", ");
							File oneUser = new File(userName[0]+".txt");
														
							oneUser.delete();

															
						}
						bf.close();
						
						tables.setRowCount(0);
						users.delete();
					}


						
				}
				catch (Exception e3)
				{
					JOptionPane.showMessageDialog(frame, "Something went wrong try again !!");
				}
				
				
			}
		});
		
		adminSerachBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					File users = new File("users.txt");
			        if (users.length() == 0)
			        	JOptionPane.showMessageDialog(frame, "There are no users");
			        else
			        {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
					//trs.setRowFilter(RowFilter.regexFilter(tfPretraga.getText().trim()));
					String tekstPretraga = adminSearch.getText();
					trs.setRowFilter(RowFilter.regexFilter(tekstPretraga,1));
					table.setRowSorter(trs);
			        }
				}

				catch (Exception e5)
				{
					JOptionPane.showMessageDialog(null, "Something went wrong!!");
				}
				
				
			}
		}); 
		
		
	}
	
}
