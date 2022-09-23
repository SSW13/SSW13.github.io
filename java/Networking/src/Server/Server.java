package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server
{
	ServerSocket xServerSocket;
	MsgRecieve reciever;
	ArrayList<ServerSideClient> list;
		
	public Server(MsgRecieve x_reciever) {
		
		reciever = x_reciever;
		list = new ArrayList<ServerSideClient>();
		
		try
		{
			xServerSocket = new ServerSocket(1234);
			
			Thread t = new Thread(new Runnable()
			{
				
				@Override
				public void run()
				{
					while(true) {
						try
						{
							Socket socket = xServerSocket.accept();
							ServerSideClient ssc = new ServerSideClient(socket, reciever);
							list.add(ssc);
						} catch (IOException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			});
			t.start();
			
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendAll(String s) {
		for(ServerSideClient ss : list) {
			ss.send(s);
		}
	}

}
