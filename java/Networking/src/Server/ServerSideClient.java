package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerSideClient
{
	Socket xSocket;
	Scanner scanner;
	PrintWriter printwriter;
	MsgRecieve reciever;
	
	public ServerSideClient(Socket xxSocket,MsgRecieve x_reciever) {
		xSocket = xxSocket;
		reciever = x_reciever;
		try
		{
			scanner = new Scanner(xSocket.getInputStream());
			printwriter = new PrintWriter(xSocket.getOutputStream());
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
					reciever.getMsg(s);
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
