package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import Server.MsgRecieve;

public class Client
{
	Socket xSocket;
	MsgRecieve xrecieve;
	Scanner scanner;
	PrintWriter printwriter;
	

	public Client(MsgRecieve recieve,String host ,int port) {
		xrecieve = recieve;
		try
		{
			xSocket = new Socket(host,port);
			scanner = new Scanner(xSocket.getInputStream());
			printwriter = new PrintWriter(xSocket.getOutputStream());
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t = new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				while(true) {
					String s = scanner.nextLine();
					xrecieve.getMsg(s);
				}
				
			}
		});
		t.start();
	}
	
	public void send(String s) {
		printwriter.println(s);
		printwriter.flush();
	}
}
