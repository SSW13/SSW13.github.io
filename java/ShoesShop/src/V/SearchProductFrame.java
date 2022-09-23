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
import M.ProductDB;
import M.ProductManager;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchProductFrame extends JFrame
{

	private JPanel contentPane;
	private JTextField textField_searchpro;
	private JTable table;
	private JButton btn_Search;
	private JButton btn_Select;
	ArrayList<ProductDB> list;

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
					SearchProductFrame frame = new SearchProductFrame();
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
	public SearchProductFrame()
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
		scrollPane.setViewportView(table);
		
		textField_searchpro = new JTextField();
		textField_searchpro.setColumns(10);
		textField_searchpro.setBounds(10, 11, 86, 20);
		contentPane.add(textField_searchpro);
		
		btn_Search = new JButton("Search");
		btn_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btn_Search.setBounds(117, 11, 89, 23);
		contentPane.add(btn_Search);
		
		btn_Select = new JButton("Select");
		btn_Select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount()==0) {
					JOptionPane.showMessageDialog( SearchProductFrame.this, "Please select 1 row");
				}
				
				if(xselectProductI != null) {
					if(list != null) {
						xselectProductI.select(list.get(table.getSelectedRow()));
					setVisible(false);
					}
				}
			}
		});
		btn_Select.setBounds(335, 11, 89, 23);
		contentPane.add(btn_Select);
	}
	public void search()
	{
		list = ProductManager.searchProduct(textField_searchpro.getText());
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("product_id");
		model.addColumn("product_name");
		model.addColumn("price_per_unit");
		model.addColumn("product_description");
		for (ProductDB c : list)
		{
			model.addRow(new Object[]
			{ c.product_id, c.product_name, c.price_per_unit, c.product_description });
		}

		table.setModel(model);
	}
	
	
	selectProductI xselectProductI;
	
	public void setSelectProduct(selectProductI x) {
		xselectProductI = x;
	}
}

interface selectProductI{
	public void select(ProductDB x);
}

