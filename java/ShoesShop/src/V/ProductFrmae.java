package V;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import M.CustomerDB;
import M.CustomerManager;
import M.ProductDB;
import M.ProductManager;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductFrmae extends JFrame
{

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_productID;
	private JTextField textField_ProductName;
	private JTextField textField_productPrice;
	private JTextField textField_ProductDescription;
	private ImagePanel imagePanel;
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
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ProductFrmae frame = new ProductFrmae();
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
	public ProductFrmae()
	{
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 905, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 506, 529);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (table.getSelectedRowCount() < 1)
					return;
				int index = table.getSelectedRow();
				BufferedImage img = list.get(index).product_image;
				if (img != null)
				{
					imagePanel.setImage(img);
				}
				
				if (table.getSelectedRowCount() < 1)
				{
					return;
				}

				int id = Integer.parseInt(table.getValueAt(index, 0).toString());
				String name = table.getValueAt(index, 1).toString();
				double price = Double.parseDouble(table.getValueAt(index, 2).toString());
				String desc = table.getValueAt(index, 3).toString();

				textField_productID.setText("" + id);
				textField_ProductName.setText("" + name);
				textField_productPrice.setText("" + price);
				textField_ProductDescription.setText("" + desc);
			}
		});
		table.setForeground(Color.BLACK);
		scrollPane.setColumnHeaderView(table);

		textField_productID = new JTextField();
		textField_productID.setBackground(Color.YELLOW);
		textField_productID.setEditable(false);
		textField_productID.setForeground(Color.BLACK);
		textField_productID.setBounds(638, 11, 181, 20);
		contentPane.add(textField_productID);
		textField_productID.setColumns(10);

		textField_ProductName = new JTextField();
		textField_ProductName.setColumns(10);
		textField_ProductName.setBounds(638, 42, 181, 20);
		contentPane.add(textField_ProductName);

		textField_productPrice = new JTextField();
		textField_productPrice.setColumns(10);
		textField_productPrice.setBounds(638, 73, 181, 20);
		contentPane.add(textField_productPrice);

		textField_ProductDescription = new JTextField();
		textField_ProductDescription.setColumns(10);
		textField_ProductDescription.setBounds(638, 104, 181, 20);
		contentPane.add(textField_ProductDescription);

		JLabel lblNewLabel = new JLabel("Product ID");
		lblNewLabel.setBounds(516, 14, 112, 14);
		contentPane.add(lblNewLabel);

		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(516, 45, 112, 14);
		contentPane.add(lblProductName);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(516, 76, 112, 14);
		contentPane.add(lblPrice);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(516, 107, 112, 14);
		contentPane.add(lblDescription);

		JButton button_save = new JButton("Save new");
		button_save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!textField_productPrice.getText().trim().matches("[+-]?\\d*(\\.\\d+)?")) {
					JOptionPane.showMessageDialog(ProductFrmae.this , "Number only please");
					textField_productPrice.requestFocus();
					textField_productPrice.selectAll();
				}
				ProductDB x = new ProductDB(0, textField_ProductName.getText().trim(),
						Double.parseDouble(textField_productPrice.getText().trim()),
						textField_ProductDescription.getText().trim(), (BufferedImage) imagePanel.getImage());
				ProductManager.saveNewProduct(x);
				load();
				textField_productID.setText("");
				textField_ProductName.setText("");
				textField_productPrice.setText("");
				textField_ProductDescription.setText("");

				JOptionPane.showMessageDialog(ProductFrmae.this , "Saved");
			}
		});
		button_save.setBounds(638, 411, 89, 23);
		contentPane.add(button_save);

		JButton button_edit = new JButton("Edit");
		button_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_productPrice.getText().trim().matches("[+-]?\\d*(\\.\\d+)?")) {
					JOptionPane.showMessageDialog(ProductFrmae.this , "Number only please");
					textField_productPrice.requestFocus();
					textField_productPrice.selectAll();
				}
				ProductDB x = new ProductDB(Integer.parseInt(textField_productID.getText().trim()), textField_ProductName.getText().trim(),
						Double.parseDouble(textField_productPrice.getText().trim()),
						textField_ProductDescription.getText().trim(), (BufferedImage) imagePanel.getImage());
				ProductManager.editProduct(x);
				load();
				textField_productID.setText("");
				textField_ProductName.setText("");
				textField_productPrice.setText("");
				textField_ProductDescription.setText("");

				JOptionPane.showMessageDialog(ProductFrmae.this , "Edited");
				
			}
		});
		button_edit.setBounds(638, 445, 89, 23);
		contentPane.add(button_edit);

		JButton button_delete = new JButton("Delete");
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(ProductFrmae.this, "SURE ?",
						"DELETE", JOptionPane.OK_CANCEL_OPTION))
				{

					ProductDB x = new ProductDB(Integer.parseInt(textField_productID.getText().trim()), textField_ProductName.getText().trim(),
							Double.parseDouble(textField_productPrice.getText().trim()),
							textField_ProductDescription.getText().trim(), (BufferedImage) imagePanel.getImage());
					ProductManager.deleteProduct(x);
					load();

					textField_productID.setText("");
					textField_ProductName.setText("");
					textField_productPrice.setText("");
					textField_ProductDescription.setText("");

					JOptionPane.showMessageDialog(ProductFrmae.this , "Deleted");
				}
			}
		});
		button_delete.setBounds(638, 479, 89, 23);
		contentPane.add(button_delete);

		imagePanel = new ImagePanel((Image) null);
		imagePanel.setBounds(615, 198, 162, 183);
		contentPane.add(imagePanel);

		JButton button_Browse = new JButton("Browse...");
		button_Browse.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser fc = new JFileChooser();
				fc.addChoosableFileFilter(new OpenFileFilter("jpeg", "Photo in JPEG format"));
				fc.addChoosableFileFilter(new OpenFileFilter("jpg", "Photo in JPEG format"));
				fc.addChoosableFileFilter(new OpenFileFilter("png", "PNG image"));
				fc.addChoosableFileFilter(new OpenFileFilter("svg", "Scalable Vector Graphic"));
				fc.setAcceptAllFileFilterUsed(false);
				int returnVal = fc.showOpenDialog(ProductFrmae.this);
				if (returnVal == JFileChooser.APPROVE_OPTION)
				{
					File f = fc.getSelectedFile();
					try
					{
						BufferedImage bimg = ImageIO.read(f);
						imagePanel.setImage(bimg);

					} catch (Exception e1)
					{
						e1.printStackTrace();
					}
				}
			}
		});
		button_Browse.setBounds(516, 144, 89, 23);
		contentPane.add(button_Browse);

		load();

	}

	class OpenFileFilter extends FileFilter
	{

		String description = "";
		String fileExt = "";

		public OpenFileFilter(String extension)
		{
			fileExt = extension;
		}

		public OpenFileFilter(String extension, String typeDescription)
		{
			fileExt = extension;
			this.description = typeDescription;
		}

		@Override
		public boolean accept(File f)
		{
			if (f.isDirectory())
				return true;
			return (f.getName().toLowerCase().endsWith(fileExt));
		}

		@Override
		public String getDescription()
		{
			return description;
		}
	}

	public void load()
	{
		list = ProductManager.getAllProduct();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("product_id");
		model.addColumn("product_name");
		model.addColumn("price");
		model.addColumn("description");
		for (ProductDB c : list)
		{
			model.addRow(new Object[]
			{ c.product_id, c.product_name, c.price_per_unit, c.product_description });
		}

		table.setModel(model);
	}
}
