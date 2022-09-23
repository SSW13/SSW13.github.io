package V;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import M.CustomerDB;
import M.CustomerManager;
import M.UserDB;
import M.UserManager;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class UserFrame extends JFrame
{

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_id;
	private JTextField textField_username;
	private JTextField textField_password;
	ArrayList<UserDB> list;
	private JLabel lblNewLabel_3;
	String [] str = { "user", "admin"};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					UserFrame frame = new UserFrame();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserFrame()
	{
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 905, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 11, 490, 505);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (table.getSelectedRowCount() < 1)
				{
					return;
				}
				int index = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(index, 0).toString());
				String username = table.getValueAt(index, 1).toString();
				String password = table.getValueAt(index, 2).toString();


				textField_id.setText("" + id);
				textField_username.setText("" + username);
				textField_password.setText("" + password);

			}
		});
		table.setBackground(Color.WHITE);
		scrollPane.setColumnHeaderView(table);
		
		textField_id = new JTextField();
		textField_id.setBounds(673, 28, 149, 20);
		contentPane.add(textField_id);
		textField_id.setColumns(10);
		
		textField_username = new JTextField();
		textField_username.setColumns(10);
		textField_username.setBounds(673, 59, 149, 20);
		contentPane.add(textField_username);
		
		textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBounds(673, 90, 149, 20);
		contentPane.add(textField_password);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(521, 31, 142, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(521, 62, 142, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(521, 93, 142, 14);
		contentPane.add(lblNewLabel_2);
		
		JList list = new JList(str);
		list.setValueIsAdjusting(true);
		list.setBounds(673, 121, 149, 32);
		contentPane.add(list);
		
		lblNewLabel_3 = new JLabel("UserType");
		lblNewLabel_3.setBounds(521, 122, 142, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("SAVE NEW");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDB x = new UserDB(0, textField_username.getText().trim(), textField_password.getText().trim(),
						String.valueOf(list.getSelectedValue()));
				UserManager.saveNewUser(x);
				load();

				textField_id.setText("");
				textField_username.setText("");
				textField_password.setText("");
				
				JOptionPane.showMessageDialog(UserFrame.this, "Saved");
			}
		});
		btnNewButton.setBounds(673, 164, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDB x = new UserDB( Integer.parseInt(textField_id.getText().trim()), textField_username.getText().trim(), textField_password.getText().trim(),
						String.valueOf(list.getSelectedValue()));
				UserManager.editUser(x);
				load();

				textField_id.setText("");
				textField_username.setText("");
				textField_password.setText("");

				JOptionPane.showMessageDialog(UserFrame.this, "Edited");
			}
		});
		btnEdit.setBounds(673, 198, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(UserFrame.this, "SURE ?",
						"DELETE", JOptionPane.OK_CANCEL_OPTION))
				{

					UserDB x = new UserDB( Integer.parseInt(textField_id.getText().trim()), textField_username.getText().trim(), textField_password.getText().trim(),
							String.valueOf(list.getSelectedValue()));
					UserManager.deleteUser(x);
					load();

					textField_id.setText("");
					textField_username.setText("");
					textField_password.setText("");

					JOptionPane.showMessageDialog(UserFrame.this, "Deleted");
				}
			
			}
		});
		btnDelete.setBounds(673, 232, 89, 23);
		contentPane.add(btnDelete);
		
		load();
		}
	
	public void load()
	{
		list = UserManager.getAllUser();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("user_name");
		model.addColumn("user_password");
		model.addColumn("usertype");
		for (UserDB c : list)
		{
			model.addRow(new Object[]
			{ c.id, c.user_name , c.user_password , c.usertype });
		}

		table.setModel(model);
	}
}
