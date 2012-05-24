package semplest.server.service;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class NioBugMain 
{
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException
	{
		Socket s = new Socket("localhost", 9090);
		System.out.println("created");
		//String jsonStr = json.createJSONFromSocketDataObj(pingData);
		final byte[] b = "{abc:xyz}".getBytes();
		s.getOutputStream().write(b);
		Thread.sleep(3000);
		s.getOutputStream().flush();
		Thread.sleep(3000);
		s.close();
	}
}
