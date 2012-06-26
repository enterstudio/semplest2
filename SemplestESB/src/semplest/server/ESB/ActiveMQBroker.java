package semplest.server.ESB;

import org.apache.activemq.broker.BrokerService;
import org.apache.log4j.Logger;

public class ActiveMQBroker implements Runnable
{
	private BrokerService broker = null;
	private final String brokerName;
	private final String host;
	private final String port;
	
	static final Logger logger = Logger.getLogger(ActiveMQBroker.class);
	//private final String queueName;
	public ActiveMQBroker(String brokerName, String host, String port)
	{
		this.port = port;
		this.host = host;
		this.brokerName = brokerName;
	}
	public void run()
	{
		try
		{
			broker = new BrokerService();
			broker.setBrokerName(brokerName);
			broker.setUseShutdownHook(false);
			//Add plugin
			//broker.setPlugins(new BrokerPlugin[]{new JaasAuthenticationPlugin()});
			broker.addConnector("tcp://" + host + ":" + port);
			broker.start();
		}
		catch (Exception e)
		{
			logger.error("Broker Error ", e);
		}
	}

	

}
