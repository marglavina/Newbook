package application;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AdminPanel extends JPanel {
	private JTable table;
	private JTextField adminSearch;

	/**
	 * Create the panel.
	 */
	public AdminPanel() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 68, 407, 299);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "Name", "Surname", "Sex"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		
		JButton deleteBtn = new JButton("Delete selected user");
		deleteBtn.setBounds(20, 378, 183, 23);
		add(deleteBtn);
		
		adminSearch = new JTextField();
		adminSearch.setBounds(20, 412, 249, 20);
		add(adminSearch);
		adminSearch.setColumns(10);
		
		JButton adminSerachBtn = new JButton("Search by surname");
		adminSerachBtn.setBounds(279, 411, 147, 23);
		add(adminSerachBtn);
		
		JButton updateBtn = new JButton("Update selected user");
		updateBtn.setBounds(213, 378, 213, 23);
		add(updateBtn);
		
		JButton adminLogOutBtn = new JButton("Log out");
		adminLogOutBtn.setBounds(324, 34, 89, 23);
		add(adminLogOutBtn);

	}
}
