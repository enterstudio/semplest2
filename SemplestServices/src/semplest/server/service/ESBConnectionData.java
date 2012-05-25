package semplest.server.service;

public class ESBConnectionData
{
	
	private String ServiceName = null;
	private String ServiceOffered = null;
	private String queueName = null;
	private String serverURI = null;
	private String serverport = null;
	private int PingFrequencyMS;
	private int ESBPingWaitMS;
	private int NumberServiceThreads;
	
	public String getQueueName()
	{
		return queueName;
	}
	public void setQueueName(String queueName)
	{
		this.queueName = queueName;
	}
	public String getServerURI()
	{
		return serverURI;
	}
	public void setServerURI(String serverURI)
	{
		this.serverURI = serverURI;
	}
	public String getServerport()
	{
		return serverport;
	}
	public void setServerport(String serverport)
	{
		this.serverport = serverport;
	}
	public String getServiceName()
	{
		return ServiceName;
	}
	public void setServiceName(String serviceName)
	{
		ServiceName = serviceName;
	}
	public int getPingFrequencyMS()
	{
		return PingFrequencyMS;
	}
	public void setPingFrequencyMS(int pingFrequencyMS)
	{
		PingFrequencyMS = pingFrequencyMS;
	}
	public String getServiceOffered()
	{
		return ServiceOffered;
	}
	public void setServiceOffered(String serviceOffered)
	{
		ServiceOffered = serviceOffered;
	}
	public int getNumberServiceThreads()
	{
		return NumberServiceThreads;
	}
	public void setNumberServiceThreads(int numberServiceThreads)
	{
		NumberServiceThreads = numberServiceThreads;
	}
	public int getESBPingWaitMS()
	{
		return ESBPingWaitMS;
	}
	public void setESBPingWaitMS(int eSBPingWaitMS)
	{
		ESBPingWaitMS = eSBPingWaitMS;
	}
	
	
}
