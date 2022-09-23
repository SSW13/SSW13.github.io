package V;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import M.CustomerDB;
import M.CustomerManager;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchCustomerFrame extends JFrame
{

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_search;
	private JButton btn_Search;
	ArrayList<CustomerDB> list;
	private JButton btn_Select;
	selectCustomerI xselectCustomerI;

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
					SearchCustomerFrame frame = new SearchCustomerFrame();
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
	public SearchCustomerFrame()
	{
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 414, 195);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		textField_search = new JTextField();
		textField_search.setBounds(10, 11, 86, 20);
		contentPane.add(textField_search);
		textField_search.setColumns(10);
		
		btn_Search = new JButton("Search");
		btn_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btn_Search.setBounds(106, 10, 89, 23);
		contentPane.add(btn_Search);
		
		btn_Select = new JButton("Select");
		btn_Select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount()==0) {
					JOptionPane.showMessageDialog(SearchCustomerFrame.this, "Please select 1 row");
				}
				
				if(xselectCustomerI != null) {
					if(list != null) {
					xselectCustomerI.select(list.get(table.getSelectedRow()));
					setVisible(false);
					}
				}
			}
		});
		btn_Select.setBounds(335, 10, 89, 23);
		contentPane.add(btn_Select);
		
		load();
	}
	
	public void load()
	{
		list = CustomerManager.getAllCustomer();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("name");
		model.addColumn("surname");
		model.addColumn("phone");
		for (CustomerDB c : list)
		{
			model.addRow(new Object[]
			{ c.id, c.name, c.surname, c.phone });
		}

		table.setModel(model);
	}
	
	public void search()
	{
		list = CustomerManager.searchCustomer(textField_search.getText());
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("name");
		model.addColumn("surname");
		model.addColumn("phone");
		for (CustomerDB c : list)
		{
			model.addRow(new Object[]
			{ c.id, c.name, c.surname, c.phone });
		}

		table.setModel(model);
	}
	
	public void setSelectCustomerI(selectCustomerI x) {
		xselectCustomerI = x;
	}
}

interface selectCustomerI{
	public void select(CustomerDB x);
}
