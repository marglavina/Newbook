package application;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class LoginPanel extends JPanel {
	private JTextField nameLogOn;
	private JTextField surnameLogOn;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NEW BOOK");
		lblNewLabel.setBounds(121, 11, 174, 48);
		lblNewLabel.setFont(new Font("Poor Richard", Font.BOLD | Font.ITALIC, 30));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lblNewLabel_1.setIcon(new ImageIcon("profile.png"));
		lblNewLabel_1.setBounds(22, 86, 137, 165);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(169, 100, 46, 14);
		add(lblNewLabel_2);
		
		nameLogOn = new JTextField();
		nameLogOn.setBounds(225, 97, 167, 20);
		add(nameLogOn);
		nameLogOn.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Surname");
		lblNewLabel_3.setBounds(169, 148, 46, 14);
		add(lblNewLabel_3);
		
		surnameLogOn = new JTextField();
		surnameLogOn.setText("");
		surnameLogOn.setBounds(225, 145, 167, 20);
		add(surnameLogOn);
		surnameLogOn.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Sex");
		lblNewLabel_4.setBounds(169, 197, 46, 14);
		add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(225, 194, 167, 20);
		add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 308, 430, 131);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Surname", "Sex"
			}
		));
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(303, 225, 89, 23);
		add(logoutBtn);
		table.getColumnModel().getColumn(2).setResizable(false);

	}
}
