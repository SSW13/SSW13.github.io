package V;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import M.CompanyInfoDB;
import M.CompanyInfoManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompanyInfoFrame extends JFrame
{

	private JPanel contentPane;
	private JTextField textField_companyname;
	private JTextField textField_companyaddress;
	private JTextField textField_companyphone;
	private JTextField textField_companyemail;

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
					CompanyInfoFrame frame = new CompanyInfoFrame();
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
	public CompanyInfoFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Company Name");
		lblNewLabel.setBounds(10, 43, 136, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 68, 136, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(10, 93, 136, 14);
		contentPane.add(lblPhone);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email");
		lblNewLabel_2_1.setBounds(10, 118, 136, 14);
		contentPane.add(lblNewLabel_2_1);
		
		textField_companyname = new JTextField();
		textField_companyname.setBounds(156, 40, 251, 20);
		contentPane.add(textField_companyname);
		textField_companyname.setColumns(10);
		
		textField_companyaddress = new JTextField();
		textField_companyaddress.setColumns(10);
		textField_companyaddress.setBounds(156, 65, 251, 20);
		contentPane.add(textField_companyaddress);
		
		textField_companyphone = new JTextField();
		textField_companyphone.setColumns(10);
		textField_companyphone.setBounds(156, 90, 251, 20);
		contentPane.add(textField_companyphone);
		
		textField_companyemail = new JTextField();
		textField_companyemail.setColumns(10);
		textField_companyemail.setBounds(156, 115, 251, 20);
		contentPane.add(textField_companyemail);
		
		JButton btn_save = new JButton("Save");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xCompanyInfoDB.company_name = textField_companyname.getText();
				xCompanyInfoDB.address = textField_companyaddress.getText();
				xCompanyInfoDB.phone = textField_companyphone.getText();
				xCompanyInfoDB.email = textField_companyemail.getText();
				
				CompanyInfoManager.edit(xCompanyInfoDB);
				
				JOptionPane.showMessageDialog(CompanyInfoFrame.this, "SAVED");
				
			}
		});
		btn_save.setBounds(166, 146, 89, 23);
		contentPane.add(btn_save);
		
		load();
	}
		CompanyInfoDB xCompanyInfoDB;
	public void load() {
		xCompanyInfoDB = CompanyInfoManager.getAllCompany();
		textField_companyname.setText(xCompanyInfoDB.company_name);
		textField_companyaddress.setText(xCompanyInfoDB.address);
		textField_companyphone.setText(xCompanyInfoDB.phone);
		textField_companyemail.setText(xCompanyInfoDB.email);
	}
}
