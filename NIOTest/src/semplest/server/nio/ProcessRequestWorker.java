package semplest.server.nio;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

import javax.jms.JMSException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.ProtocolSocketDataObject;

public class ProcessRequestWorker implements Runnable
{
	private List<ServerDataEvent> queue = new LinkedList<ServerDataEvent>();
	private ProtocolJSON json = new ProtocolJSON();
	static final Logger logger = Logger.getLogger(ProcessRequestWorker.class);

	/*
	 * pass the data to the queue for processing
	 */
	public void processData(NIOServer server, SocketChannel socket, byte[] data, int count)
	{
		byte[] dataCopy = new byte[count];
		System.arraycopy(data, 0, dataCopy, 0, count);
		synchronized (queue)
		{
			queue.add(new ServerDataEvent(server, socket, dataCopy));
			queue.notify();
		}
	}

	/*
	 * process the client messages
	 *
	 */
	public void run()
	{
		ServerDataEvent dataEvent;

		while (true)
		{
			// Wait for data to become available
			synchronized (queue)
			{
				while (queue.isEmpty())
				{
					try
					{
						queue.wait();
					}
					catch (InterruptedException e)
					{
					}
				}
				dataEvent = (ServerDataEvent) queue.remove(0);
				//process the event here
				//convert incoming bytes 
				ProtocolSocketDataObject socketDataObject = json.createSocketDataObjFromJSON(ProtocolJSON.convertbytesToString(dataEvent.data));
				byte typeRequest = socketDataObject.getheader();
				try
				{
					if (typeRequest == ProtocolJSON.SEMplest_REGISTER)
					{
						dataEvent.server.RegisterClient(dataEvent.socket, socketDataObject);
					}
					else if (typeRequest == ProtocolJSON.SEMplest_PING)
					{
						dataEvent.server.ClientPing(dataEvent.socket, socketDataObject);
					}
					else if (typeRequest == ProtocolJSON.SEMplest_SHUTDOWN)
					{
						//dataEvent.server.ShutdownFromClient(socketDataObject);
						logger.info("Got request of type ProtocolJSON.SEMplest_SHUTDOWN");
					}
					else
					{
						// Return to sender
						dataEvent.server.send(dataEvent.socket, dataEvent.data);
					}
				}
				catch (JsonParseException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (JsonMappingException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (JMSException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			
		}
	}
}
