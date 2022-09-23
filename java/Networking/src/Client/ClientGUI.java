package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Server.MsgRecieve;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientGUI extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_IP;
	private JTextField textField_Port;
	private JButton btnConnect;
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
					ClientGUI frame = new ClientGUI();
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
	
	Client xClient;
	public ClientGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xClient = new Client(new MsgRecieve()
				{
					
					@Override
					public void getMsg(String s)
					{
						textArea.setText(textArea.getText()+"\r\n"+ s);
						
					}
				} , textField_IP.getText() , Integer.parseInt(textField_Port.getText()) );
				
			}
		});
		btnConnect.setBounds(10, 11, 89, 23);
		contentPane.add(btnConnect);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 49, 599, 373);
		contentPane.add(textArea);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 448, 509, 23);
		contentPane.add(textField);
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xClient.send(textField.getText());
				textField.setText("");
				
			}
		});
		btnSend.setBounds(530, 448, 89, 23);
		contentPane.add(btnSend);
		
		textField_IP = new JTextField();
		textField_IP.setText("127.0.0.1");
		textField_IP.setBounds(158, 11, 187, 20);
		contentPane.add(textField_IP);
		textField_IP.setColumns(10);
		
		textField_Port = new JTextField();
		textField_Port.setText("1234");
		textField_Port.setColumns(10);
		textField_Port.setBounds(389, 11, 187, 20);
		contentPane.add(textField_Port);
	}

}
