package V;

import M.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import M.CompanyInfoDB;
import M.CompanyInfoManager;
import M.CustomerDB;
import M.ProductDB;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InvoiceFrame extends JFrame
{

	private JPanel contentPane;
	public JPanel panel;
	public JTable table;
	CustomerDB xcustomer;
	ProductDB xproduct;
	ArrayList<invoiceDetail> detailList;
	public JScrollPane scrollPane;
	
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
					InvoiceFrame frame = new InvoiceFrame();
					frame.setLocationRelativeTo(null);
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
	public InvoiceFrame()
	{
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				panel.setBounds(0, 60, getWidth(), getHeight()-100);
			}
		});
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double heigth = screenSize.getHeight();
				
				
				
		setBounds(100, 100, (int)width, (int)heigth);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 60, getWidth()-20, getHeight()-100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_companyInfo = new JLabel("New label");
		lblNewLabel_companyInfo.setBounds(41, 126, 991, 14);
		panel.add(lblNewLabel_companyInfo);
		
		JLabel lblNewLabel = new JLabel("Invoice");
		lblNewLabel.setBounds(919, 5, 113, 37);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_customer = new JLabel("New label");
		lblNewLabel_customer.setBounds(41, 151, 991, 14);
		panel.add(lblNewLabel_customer);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u0E23\u0E32\u0E22\u0E25\u0E30\u0E40\u0E2D\u0E35\u0E22\u0E14");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(41, 176, 275, 25);
		panel.add(lblNewLabel_1_2);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 212, 782, 558);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JButton btn_customer = new JButton("Customer");
		btn_customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchCustomerFrame f = new SearchCustomerFrame();
				f.setSelectCustomerI(new selectCustomerI()
				{
					
					@Override
					public void select(CustomerDB x)
					{
						// TODO Auto-generated method stub
						xcustomer = x;
						String s = x.name+" "+x.surname+" ( phone "+x.phone+" )";
						lblNewLabel_customer.setText(s);
					}
				});
				
				f.setVisible(true);
				
			}
			
		});
		btn_customer.setBounds(10, 11, 89, 23);
		contentPane.add(btn_customer);
		
		JButton btn_Product = new JButton("Product");
		btn_Product.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchProductFrame f = new SearchProductFrame();
				f.setSelectProduct(new selectProductI()
				{
					
					@Override
					public void select(ProductDB x)
					{
						// TODO Auto-generated method stub
						setDetail(x);
						
						f.setVisible(false);
					}
				});
				f.setVisible(true);
			}
		});
		btn_Product.setBounds(109, 11, 89, 23);
		contentPane.add(btn_Product);
		
		JButton btn_Save = new JButton("Save");
		btn_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InvoiceManager.saveInvoice(xcustomer, detailList);
				JOptionPane.showMessageDialog(InvoiceFrame.this, "SAVED!!");
			}
		});
		btn_Save.setBounds(208, 11, 89, 23);
		contentPane.add(btn_Save);
		
		JButton btn_print = new JButton("Print");
		btn_print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrinterJob job = PrinterJob.getPrinterJob();
				job.setPrintable(new invoicePrint(InvoiceFrame.this));
				boolean doPrint = job.printDialog();
				if(doPrint) {
					try
					{
						job.print();
					} catch (PrinterException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btn_print.setBounds(307, 11, 89, 23);
		contentPane.add(btn_print);
		
		CompanyInfoDB x = CompanyInfoManager.getAllCompany();
		String info = x.company_name+"  ที่อยู่ "+x.address+" โทร. "+x.phone+" email "+x.email;
		
		lblNewLabel_companyInfo.setText(info);
		
		JLabel lblNewLabel_date = new JLabel("New label");
		lblNewLabel_date.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_date.setBounds(1560, 126, 157, 14);
		panel.add(lblNewLabel_date);
		
		lblNewLabel_date.setText(new SimpleDateFormat().format(Calendar.getInstance().getTime()));
		
		detailList = new ArrayList<invoiceDetail>();
	}
	
	public void setDetail(ProductDB xProduct) {
		invoiceDetail x = new invoiceDetail();
		x.no = detailList.size()+1;
		x.priceperunit = xProduct.price_per_unit;
		x.name = xProduct.product_name;
		x.qty = 1;
		x.totalprice = x.priceperunit*x.qty;
		x.product = xProduct;
		
		detailList.add(x);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("no");
		model.addColumn("image");
		model.addColumn("name");
		
		model.addColumn("qty");
		model.addColumn("priceperunit");
		model.addColumn("totalprice");
		for (invoiceDetail c : detailList)
		{
			model.addRow(new Object[]
			{ c.no,c.product.product_image, c.name, c.qty, c.priceperunit, c.totalprice });
		}

		table.setModel(model);
		table.getColumn("image").setCellRenderer(new invoiceDetailTableRenderer());
		
		for(int i =0;i<table.getRowCount();i++) {
			table.setRowHeight(i,120);
		}
		
	}

}



class invoiceDetailTableRenderer extends DefaultTableCellRenderer implements TableCellRenderer{
	public Component getTableCellRendererComponent
	(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
		ImageComponent i = new ImageComponent();
		i.image = (BufferedImage) value;
		return i;
	}
}

class ImageComponent extends JComponent{
	
	public  BufferedImage image;
	
	public void paint(Graphics g) {
		if(image != null) {
			g.drawImage(image, 0, 0, 120, 120, 0, 0, image.getWidth(), image.getHeight(), this);
		}
	}
}

class invoicePrint implements Printable{
	
	InvoiceFrame xframe;
	public invoicePrint(InvoiceFrame frame) {
		xframe = frame;
	}
	@Override
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException
	{
		if(page > 0 ) {
			return NO_SUCH_PAGE;
		}
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());
		
		for(int i =0;i<xframe.panel.getComponentCount();i++) {
			Component c = xframe.panel.getComponent(i);
			if(c instanceof JLabel) {
				JLabel l = (JLabel)c;
				g2d.setFont(l.getFont());
				g2d.drawString(l.getText(),
						(int)l.getLocation().getX(),
						(int)(l.getLocation().getY()+l.getHeight()));
			}
		}
		int x = 10;
		int y = (int)(xframe.scrollPane.getLocation().getY());
		for(int i =0 ; i<xframe.table.getColumnCount();i++) {
			g2d.setFont(xframe.table.getFont());
			g2d.drawString(xframe.table.getColumnName(i) ,
					x,
					y);
			x+= xframe.table.getColumn(xframe.table.getColumnName(i)).getWidth();
		}
		
		y+=40;
		
		for(int j = 0; j< xframe.table.getRowCount();j++) {
			
		
		x=10;
		
		for(int i =0 ; i<xframe.table.getColumnCount();i++) {
			g2d.setFont(xframe.table.getFont());
			if(xframe.table.getColumnName(i).equals("image")) {
				BufferedImage image = (BufferedImage) xframe.table.getValueAt(j, i);
				g.drawImage(image, x, y, x+120, y+120, 0, 0, image.getWidth(), image.getHeight(), null);
			}else {
			g2d.setFont(xframe.table.getFont());
			g2d.drawString(""+xframe.table.getValueAt(j, i), x,	y);
			}
			x+= xframe.table.getColumn(xframe.table.getColumnName(i)).getWidth();
			
		}
			y += xframe.table.getRowHeight(j);
		}
		return 0;
		
	}
}

