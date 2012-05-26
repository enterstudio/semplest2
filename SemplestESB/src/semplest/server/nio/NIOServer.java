package semplest.server.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import javax.jms.JMSException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import semplest.server.ESB.ESBServer;
import semplest.server.ESB.ServiceRegistrationData;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.ProtocolSocketDataObject;

public class NIOServer implements Runnable
{
	// The host:port combination to listen on
	private InetAddress hostAddress;
	private int port;
	// The channel on which we'll accept connections
	private ServerSocketChannel serverChannel;
	// The selector we'll be monitoring
	private Selector selector;
	// The buffer into which we'll read data when it's available
	private ByteBuffer readBuffer = ByteBuffer.allocate(8192);
	private ProcessRequestWorker worker = null;
	private ESBServer esbServer = null;
	// A list of PendingChange instances
	private List<ChangeRequest> pendingChanges = new LinkedList<ChangeRequest>();
	// Maps a SocketChannel to a list of ByteBuffer instances
	private Map<SocketChannel, List<ByteBuffer>> pendingData = new HashMap<SocketChannel, List<ByteBuffer>>();
	private ProtocolJSON json = new ProtocolJSON();
	private ServicePingHandlerNIO pingHandler = null;
	private ReentrantLock selectorGuard = new ReentrantLock() ;
	static final Logger logger = Logger.getLogger(NIOServer.class);

	public NIOServer(InetAddress hostAddress, int port, ProcessRequestWorker worker, ESBServer esbServer) throws IOException
	{
		this.hostAddress = hostAddress;
		this.port = port;
		this.selector = this.initSelector();
		this.worker = worker;
		this.esbServer = esbServer;
	}

	/*
	 * Main selector loop
	 */
	public void run()
	{
		while (true)
		{
			try
			{
				// Process any pending changes
				synchronized (this.pendingChanges)
				{
					Iterator<ChangeRequest> changes = this.pendingChanges.iterator();
					while (changes.hasNext())
					{
						ChangeRequest change = (ChangeRequest) changes.next();
						switch (change.type)
						{
						case ChangeRequest.CHANGEOPS:
							SelectionKey key = change.socket.keyFor(this.selector);
							key.interestOps(change.ops);
						}
					}
					this.pendingChanges.clear();
				}

				selectorGuard.lock();
				selectorGuard.unlock();
				// Wait for an event one of the registered channels
				int numKeys = this.selector.select();

				// Iterate over the set of keys for which events are available
				Iterator<SelectionKey> selectedKeys = this.selector.selectedKeys().iterator();
				while (selectedKeys.hasNext())
				{
					SelectionKey key = (SelectionKey) selectedKeys.next();
					selectedKeys.remove();

					if (!key.isValid())
					{
						continue;
					}

					// Check what event is available and deal with it
					if (key.isAcceptable())
					{
						this.accept(key);
					}
					else if (key.isReadable())
					{
						this.read(key);
					}
					else if (key.isWritable())
					{
						this.write(key);
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void send(SocketChannel socket, byte[] data)
	{

		// Lock the selector guard to prevent another select until complete
		selectorGuard.lock();

		try
		{
			synchronized (this.pendingChanges)
			{
				// Indicate we want the interest ops set changed
				this.pendingChanges.add(new ChangeRequest(socket, ChangeRequest.CHANGEOPS, SelectionKey.OP_WRITE));

				// And queue the data we want written
				synchronized (this.pendingData)
				{
					// Queue is an ArrayList of ByteBuffer
					List<ByteBuffer> queue = (List<ByteBuffer>) this.pendingData.get(socket);
					if (queue == null)
					{
						queue = new ArrayList<ByteBuffer>();
						this.pendingData.put(socket, queue);
					}
					queue.add(ByteBuffer.wrap(data));
				}
			}
			selector.wakeup();

		}
		finally
		{
			selectorGuard.unlock();
		}

	}

	/*
	 * on Accept - register the Read operation
	 */
	private void accept(SelectionKey key) throws IOException
	{
		// For an accept to be pending the channel must be a server socket
		// channel.
		ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();

		// Accept the connection and make it non-blocking
		SocketChannel socketChannel = serverSocketChannel.accept();
		// Socket socket = socketChannel.socket();
		socketChannel.configureBlocking(false);

		// Register the new SocketChannel with our Selector, indicating
		// we'd like to be notified when there's data waiting to be read
		socketChannel.register(this.selector, SelectionKey.OP_READ);
	}

	/*
	 * reads data off the channel and passes the data to worker thread for
	 * processing
	 */
	private void read(SelectionKey key) throws IOException
	{
		SocketChannel socketChannel = (SocketChannel) key.channel();

		// Clear out our read buffer so it's ready for new data
		this.readBuffer.clear();

		// Attempt to read off the channel
		int numRead;
		try
		{
			numRead = socketChannel.read(this.readBuffer);
			if (numRead < 0)
			{
				logger.warn("Remote Socket shutdown...closing NIO connection");
				key.channel().close();
				return;
			}
			else if (numRead == 0)
			{
				logger.warn("Remote Socket Read numRead = 0");
				return;
			}
			else
			{
				// Hand the data off to our worker thread
				this.worker.processData(this, socketChannel, this.readBuffer.array(), numRead);
			}
		}
		catch (IOException e)
		{
			// The remote forcibly closed the connection, cancel
			// the selection key and close the channel.
			logger.error("IOException in NIO Read..Closing Connection " + e.getMessage());
			key.channel().close();
			return;
		}

	}

	private void write(SelectionKey key) throws IOException
	{
		SocketChannel socketChannel = (SocketChannel) key.channel();

		synchronized (this.pendingData)
		{
			List<ByteBuffer> queue = (List<ByteBuffer>) this.pendingData.get(socketChannel);

			// Write until there's not more data ...
			while (!queue.isEmpty())
			{
				ByteBuffer buf = (ByteBuffer) queue.get(0);
				// buf.flip();
				socketChannel.write(buf);
				if (buf.remaining() > 0)
				{
					// ... or the socket's buffer fills up
					break;
				}
				queue.remove(0);
			}

			if (queue.isEmpty())
			{
				// We wrote away all data, so we're no longer interested
				// in writing on this socket. Switch back to waiting for
				// data.
				key.interestOps(SelectionKey.OP_READ);
			}
		}
	}

	/*
	 * setup the selector to wait on Socket Accept
	 */
	private Selector initSelector() throws IOException
	{
		// Create a new selector
		Selector socketSelector = SelectorProvider.provider().openSelector();

		// Create a new non-blocking server socket channel
		this.serverChannel = ServerSocketChannel.open();
		serverChannel.configureBlocking(false);

		// Bind the server socket to the specified address and port
		InetSocketAddress isa = new InetSocketAddress(this.hostAddress, this.port);
		serverChannel.socket().bind(isa);

		// Register the server socket channel, indicating an interest in
		// accepting new connections
		serverChannel.register(socketSelector, SelectionKey.OP_ACCEPT);

		return socketSelector;
	}


	public void RegisterClient(SocketChannel socket, ProtocolSocketDataObject response) throws JsonParseException, JsonMappingException, IOException,
			JMSException
	{

		// ProtocolSocketDataObject response =
		// json.createSocketDataObjFromJSON(data.toString());
		String clientServiceName = response.getclientServiceName();
		String serviceOffered = response.getServiceOffered();
		int pingFreqMS = response.getPingFrequency();
		logger.debug("Registered Client " + clientServiceName + " service offered=" + serviceOffered);

		ConcurrentHashMap<String, ServiceRegistrationData> serviceRegistrationMap = ESBServer.esb.getServiceRegistrationMap();
		// Make sure not already registered
		if (!serviceRegistrationMap.containsKey(clientServiceName))
		{
			// add Queue to ActiveMQ
			String serviceSendQueueName = clientServiceName + "_Send";
			String serviceRecQueueName = clientServiceName + "_Rec";
			// ESB produces messages on the Serive Rec Queue
			this.esbServer.getMQConnection().createProducerAndConsumerQueue(serviceRecQueueName, serviceSendQueueName);
			// ESB Rec messares on the Service send queue
			// this.esbServer.getMQConnection().createConsumer(serviceSendQueueName);
			ServiceRegistrationData regData = new ServiceRegistrationData();
			regData.setMessageProducer(this.esbServer.getMQConnection().getMessageProducerByQueue(serviceRecQueueName));
			regData.setESBRecQueueName(serviceSendQueueName);
			regData.setESBSendQueueName(serviceRecQueueName);
			regData.setRegTime(new java.util.Date());
			regData.setServiceOffered(serviceOffered);
			// create thread for handling ping
			ServicePingHandlerNIO pingHandler = new ServicePingHandlerNIO(this, this.esbServer, clientServiceName, serviceOffered, pingFreqMS);
			//regData.setPingHandler(pingHandler);
			Thread pingThread = new Thread(pingHandler);
			pingThread.setPriority(Thread.MAX_PRIORITY);
			pingThread.start();
			serviceRegistrationMap.put(clientServiceName, regData);
			ESBServer.esb.setServiceNameList(serviceOffered, clientServiceName);
			// setup currentServiceIndexMap
			if (!ESBServer.esb.getCurrentServiceIndexMap().containsKey(serviceOffered))
			{
				AtomicInteger currentServiceIndex = new AtomicInteger(0);
				ESBServer.esb.getCurrentServiceIndexMap().put(serviceOffered, currentServiceIndex);
			}
			// send back queue name for client to connect to as new destination
			ProtocolSocketDataObject returndata = new ProtocolSocketDataObject();
			returndata.setHeader(ProtocolJSON.SEMplest_REGISTER);
			returndata.setServiceSendQueueName(serviceSendQueueName);
			returndata.setServiceRecQueueName(serviceRecQueueName);
			returndata.setmessageQueueIP(esbServer.getServerData().getBrokerIP());
			returndata.setmessageQueuePort(esbServer.getServerData().getBrokerPort());
			String jsonStr = json.createJSONFromSocketDataObj(returndata);
			byte[] returnData = ProtocolJSON.createBytePacketFromString(jsonStr);
			send(socket, returnData);
			logger.info("Register " + clientServiceName);
		}
		else
		// already registered
		{
			logger.info("Already Registered " + clientServiceName);
		}

	}

	public void ShutdownFromClient(ProtocolSocketDataObject socketDataObject)
	{
		String client = socketDataObject.getclientServiceName();
		logger.debug("Received Shutdown request from " + client);
		ConcurrentHashMap<String, ServiceRegistrationData> serviceRegistrationMap = ESBServer.esb.getServiceRegistrationMap();
		Vector<String> servicesList = ESBServer.esb.getServiceNameList(serviceRegistrationMap.get(client).getServiceOffered());
		if (serviceRegistrationMap.containsKey(client))
		{
			serviceRegistrationMap.remove(client);
			logger.debug(client + "removed in registrationMap size=" + serviceRegistrationMap.size());
			if (servicesList.contains(client))
			{
				servicesList.remove(client);
			}
			logger.debug("Removed: " + client);
		}
		else
		{
			logger.debug(client + "not in registrationMap");
		}
	}

	public void ClientPing(SocketChannel socket, ProtocolSocketDataObject socketDataObject)
	{

		try
		{
			ConcurrentHashMap<String, ServiceRegistrationData> serviceRegistrationMap = ESBServer.esb.getServiceRegistrationMap();
			// Vector<String> servicesList = ESBServer.esb.getServicesList();
			logger.info("PING " + socketDataObject.getclientServiceName() + " serviceRegistrationMap size" + serviceRegistrationMap.size());
			ServiceRegistrationData regData = serviceRegistrationMap.get(socketDataObject.getclientServiceName());
			if (regData == null)
			{
				logger.error("Registration Data for:" + socketDataObject.getclientServiceName() + " is NULL");
			}
			else
			{
				regData.getPingHandler().handleResponse(socketDataObject.getclientServiceName());
				ProtocolSocketDataObject returndata = new ProtocolSocketDataObject();
				returndata.setHeader(ProtocolJSON.SEMplest_PING);
				String jsonStr = json.createJSONFromSocketDataObj(returndata);
				byte[] returnData = ProtocolJSON.createBytePacketFromString(jsonStr);
				logger.debug("Send response back to Client: " + socketDataObject.getclientServiceName());
				send(socket, returnData);
			}
		}
		catch (Exception e)
		{
			logger.error("Error ping " + e.getMessage());
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args)
	{
		try
		{
			ProcessRequestWorker worker = new ProcessRequestWorker();
			new Thread(worker).start();
			new Thread(new NIOServer(null, 9090, worker, new ESBServer())).start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
