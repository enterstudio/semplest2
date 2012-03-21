package semplest.server.ESB;

public class ESBServerData
{
	private String RegServicePort = null;
	private String BrokerName = null;
	private String BrokerPort = null;
	private String BrokerIP = null;
	private String JerseyPackage = null;
	private String WebServerPort = null;
	private int AsynchServletCorePoolSize;
	private int AsynchServletMaxPoolSize;
	private int AsynchServletMaxWorkInQueue;
	private int AsynchCallDefaultTimeoutMS;
	
	public String getRegServicePort()
	{
		return RegServicePort;
	}
	public void setRegServicePort(String regServicePort)
	{
		RegServicePort = regServicePort;
	}
	public String getBrokerName()
	{
		return BrokerName;
	}
	public void setBrokerName(String brokerName)
	{
		BrokerName = brokerName;
	}
	public String getBrokerPort()
	{
		return BrokerPort;
	}
	public void setBrokerPort(String brokerPort)
	{
		BrokerPort = brokerPort;
	}
	public String getJerseyPackage()
	{
		return JerseyPackage;
	}
	public void setJerseyPackage(String jerseyPackage)
	{
		JerseyPackage = jerseyPackage;
	}
	public String getWebServerPort()
	{
		return WebServerPort;
	}
	public void setWebServerPort(String webServerPort)
	{
		WebServerPort = webServerPort;
	}
	public String getBrokerIP()
	{
		return BrokerIP;
	}
	public void setBrokerIP(String brokerIP)
	{
		BrokerIP = brokerIP;
	}
	
	public int getAsynchServletCorePoolSize()
	{
		return AsynchServletCorePoolSize;
	}
	public void setAsynchServletCorePoolSize(int asynchServletCorePoolSize)
	{
		AsynchServletCorePoolSize = asynchServletCorePoolSize;
	}
	public int getAsynchServletMaxPoolSize()
	{
		return AsynchServletMaxPoolSize;
	}
	public void setAsynchServletMaxPoolSize(int asynchServletMaxPoolSize)
	{
		AsynchServletMaxPoolSize = asynchServletMaxPoolSize;
	}
	public int getAsynchServletMaxWorkInQueue()
	{
		return AsynchServletMaxWorkInQueue;
	}
	public void setAsynchServletMaxWorkInQueue(int asynchServletMaxWorkInQueue)
	{
		AsynchServletMaxWorkInQueue = asynchServletMaxWorkInQueue;
	}
	public int getAsynchCallDefaultTimeoutMS()
	{
		return AsynchCallDefaultTimeoutMS;
	}
	public void setAsynchCallDefaultTimeoutMS(int asynchCallDefaultTimeoutMS)
	{
		AsynchCallDefaultTimeoutMS = asynchCallDefaultTimeoutMS;
	}

}
