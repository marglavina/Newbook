package application;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JPanel {
	private JTextField surnameReg;
	private JTextField nameReg;
	private JTextField usernameReg;
	private JPasswordField passwordReg;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public Register() {
		setLayout(null);
		
		JLabel registerLabel_4 = new JLabel("Sex");
		registerLabel_4.setBounds(114, 214, 46, 14);
		add(registerLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Surname");
		lblNewLabel_3.setBounds(114, 165, 46, 14);
		add(lblNewLabel_3);
		
		surnameReg = new JTextField();
		surnameReg.setText("");
		surnameReg.setColumns(10);
		surnameReg.setBounds(170, 162, 167, 20);
		add(surnameReg);
		
		nameReg = new JTextField();
		nameReg.setColumns(10);
		nameReg.setBounds(170, 114, 167, 20);
		add(nameReg);
		
		JLabel registerLabel_2 = new JLabel("Name");
		registerLabel_2.setBounds(114, 117, 46, 14);
		add(registerLabel_2);
		
		JLabel registerLabel = new JLabel("NEW BOOK");
		registerLabel.setFont(new Font("Poor Richard", Font.BOLD | Font.ITALIC, 30));
		registerLabel.setBounds(127, 41, 174, 48);
		add(registerLabel);
		
		JRadioButton male = new JRadioButton("M");
		buttonGroup.add(male);
		male.setBounds(167, 210, 33, 23);
		add(male);
		
		JRadioButton female = new JRadioButton("F");
		buttonGroup.add(female);
		female.setBounds(228, 210, 33, 23);
		add(female);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(114, 261, 55, 20);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setBounds(114, 313, 46, 14);
		add(lblNewLabel_5);
		
		usernameReg = new JTextField();
		usernameReg.setBounds(170, 261, 167, 20);
		add(usernameReg);
		usernameReg.setColumns(10);
		
		passwordReg = new JPasswordField();
		passwordReg.setBounds(170, 310, 167, 20);
		add(passwordReg);
		
		JButton registrationBtn = new JButton("Register");
		registrationBtn.setBounds(248, 363, 89, 23);
		add(registrationBtn);
		
		JLabel usernameUsed = new JLabel("Username already in use!!");
		usernameUsed.setEnabled(false);
		usernameUsed.setForeground(Color.RED);
		usernameUsed.setBounds(170, 279, 167, 20);
		add(usernameUsed);
		
		JButton regBackButtn = new JButton("Back");
		regBackButtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		regBackButtn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		regBackButtn.setBounds(338, 41, 73, 23);
		add(regBackButtn);

	}
}
