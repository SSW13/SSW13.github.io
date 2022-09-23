package Server;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerGUI extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnOpen;
	private JTextArea textArea;
	private JButton btnSend;

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
					ServerGUI frame = new ServerGUI();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	Server xServer;
	
	/**
	 * Create the frame.
	 */
	public ServerGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xServer = new Server(new MsgRecieve()
				{

					@Override
					public void getMsg(String s)
					{
						textArea.setText(textArea.getText()+"\r\n client : "+ s);
						// TODO Auto-generated method stub
						
					}
					
				});
				
			}
		});
		btnOpen.setBounds(10, 11, 89, 23);
		contentPane.add(btnOpen);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 50, 768, 367);
		contentPane.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(10, 440, 509, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(xServer == null) {
					JOptionPane.showMessageDialog(ServerGUI.this, "OPEN 1st");
					return;
				}
				xServer.sendAll(textField.getText());
				textField.setText("");
				
			}
		});
		btnSend.setBounds(689, 440, 89, 23);
		contentPane.add(btnSend);
	}
}
