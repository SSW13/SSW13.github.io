import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dicread extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dicread frame = new Dicread();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dicread() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt1 = new JTextField();
		txt1.setBounds(143, 49, 116, 22);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JButton btnSEARCH = new JButton("SEARCH");
		btnSEARCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Scanner sc;
				try {
					sc = new Scanner(new File("D://xxx.txt"),"utf8");
					while(sc.hasNext())
					{
						String s = sc.nextLine();
						String [] ss = s.split(",");
						if (txt1.getText().equals(ss[0]))
						{
							label.setText(ss[1]);
						}
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnSEARCH.setBounds(140, 81, 97, 25);
		contentPane.add(btnSEARCH);
		
		label = new JLabel("New label");
		label.setBounds(91, 139, 56, 16);
		contentPane.add(label);
	}

}