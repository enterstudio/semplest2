package netty;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.jboss.netty.handler.codec.base64.Base64;

public class TestClient
{
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
