package SocketServer;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.ProtocolSocketDataObject;

public class TestClient
{
	private static final Logger logger = Logger.getLogger(TestClient.class);
	private static ProtocolJSON json = new ProtocolJSON();
	private static String host = "localhost"; //semplest-dev1";
	private static int port = 9999;
	public static void main(String[] args)
	{
		
		ProtocolSocketDataObject regdata = new ProtocolSocketDataObject();
		regdata.setHeader(ProtocolJSON.SEMplest_REGISTER);
		regdata.setclientServiceName("T");
		regdata.setServiceOffered("X");
		regdata.setPingFrequency(10000);

		// convert to JSON
		try
		{
			PropertyConfigurator.configure("properties/log4j_server.properties");
			String jsonStr = json.createJSONFromSocketDataObj(regdata);
			byte[] regPacket = ProtocolJSON.createBytePacketFromString(jsonStr);
			System.out.println("Send regPacket " + jsonStr);
			Socket s = new Socket(host, port);
			
			s.getOutputStream().write(regPacket);
			byte[] response = new byte[8192];
			int num = s.getInputStream().read(response);
			System.out.println(num);
			ProtocolSocketDataObject data = json.createSocketDataObjFromJSON(ProtocolJSON.convertbytesToString(response));
			if (data.getheader() == ProtocolJSON.SEMplest_REGISTER)
			{
				// create a Pi thread
				
					System.out.println("Start Pinging....with Frequency=" + 1000);
					PingService ping = new PingService(s,host, port, "T",
							1000);
					Thread pingThread = new Thread(ping);
					pingThread.setPriority(Thread.MAX_PRIORITY);
					pingThread.start();
				
				// create a connection to the destination queue
				//System.out.println("setting up MQ IP: " + data.getmessageQueueIP() + ":" + data.getmessageQueuePort() + " sendQ=" + data.getServiceSendQueueName() + " RecQ=" +  data.getServiceRecQueueName());
				//mq = new ServiceActiveMQConnection(data.getmessageQueueIP(), data.getmessageQueuePort());
				//mq.createProducer(data.getServiceSendQueueName());
				//mq.createConsumer(data.getServiceRecQueueName());
				
				//System.out.println("Service registered " + data.getServiceSendQueueName());
				

			}
			else
			{
				System.out.println("ERROR - The Data Header rec from ESB was not SEMplest REGISTER");
				
			}
			
		}
		catch (UnknownHostException e)
		{
			logger.error("Problem", e);
		}
		
		catch (IOException e)
		{
			logger.error("Problem", e);
		}
	
		// send the Registration pacjket
		// nioClient.send(regPacket, handler);
	}

}
