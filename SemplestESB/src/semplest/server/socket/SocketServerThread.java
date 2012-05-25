package semplest.server.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SocketServerThread implements Runnable
{
	private final int port; 
	private static final Logger logger = Logger.getLogger(SocketServerThread.class);
	
	public static void main(String[] args)
	{
		PropertyConfigurator.configure("properties/log4j_server.properties");

		
		SocketServerThread server = new SocketServerThread(8888);
		Thread serverThread = new Thread(server);
		serverThread.setDaemon(true);
		serverThread.start();
		try
		{
			serverThread.join();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SocketServerThread(int port)
	{
		this.port = port;
	}
	@Override
	public void run()
	{
		try
		{
			ServerSocket serversock = new ServerSocket(port);
			while (true)
			{
				Socket s = serversock.accept();
				logger.debug("Accept Client");
				Thread client = new Thread(new ServerClientSocketThread(s));
				client.start();
			}
		}
		catch (IOException e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}

	}

}
