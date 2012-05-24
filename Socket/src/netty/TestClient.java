package netty;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.jboss.netty.handler.codec.base64.Base64;

public class TestClient
{
	static final Logger logger = Logger.getLogger(TestClient.class);
	
	public static void main(String[] args)
	{
		int firstMessageSize = 3;

		ArrayList<Integer> firstMessage = new ArrayList<Integer>(firstMessageSize);
		for (int i = 0; i < firstMessageSize; i++)
		{
			firstMessage.add(Integer.valueOf(i));
		}
		try
		{

			Socket s = new Socket("localhost", 8888);
			Base64 base64;
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream obj_out = new ObjectOutputStream(bos);
			obj_out.writeObject(firstMessage.toArray());
			s.getOutputStream().write(bos.toByteArray());
			s.getOutputStream().flush();
		}
		catch (UnknownHostException e)
		{
			logger.error("Problem", e);
		}
		catch (IOException e)
		{
			logger.error("Problem", e);
		}
	}

}
