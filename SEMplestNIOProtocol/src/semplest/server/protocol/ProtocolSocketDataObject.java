package semplest.server.protocol;


public class ProtocolSocketDataObject
{

	private byte header;
	
	private String messageQueuePort = null;
	private String messageQueueIP = null;
	private String clientServiceName = null;
	private String ServiceSendQueueName = null;
	private String ServiceRecQueueName = null;
	private String ServiceOffered = null;
	private int pingFrequency;
	private String error = null;
	
	public byte getheader()
	{
		return header;
	}
	public void setHeader(byte header)
	{
		this.header = header;
	}
	
	public String getmessageQueuePort()
	{
		return messageQueuePort;
	}
	public void setmessageQueuePort(String mQPort)
	{
		messageQueuePort = mQPort;
	}
	public String getmessageQueueIP()
	{
		return messageQueueIP;
	}
	public void setmessageQueueIP(String mQIP)
	{
		messageQueueIP = mQIP;
	}
	public String getclientServiceName()
	{
		return clientServiceName;
	}
	public void setclientServiceName(String clientServiceName)
	{
		this.clientServiceName = clientServiceName;
	}
	public String getServiceSendQueueName()
	{
		return ServiceSendQueueName;
	}
	public void setServiceSendQueueName(String serviceSendQueueName)
	{
		ServiceSendQueueName = serviceSendQueueName;
	}
	public String getServiceRecQueueName()
	{
		return ServiceRecQueueName;
	}
	public void setServiceRecQueueName(String serviceRecQueueName)
	{
		ServiceRecQueueName = serviceRecQueueName;
	}
	public String getServiceOffered()
	{
		return ServiceOffered;
	}
	public void setServiceOffered(String serviceOffered)
	{
		ServiceOffered = serviceOffered;
	}
	public int getPingFrequency()
	{
		return pingFrequency;
	}
	public void setPingFrequency(int pingFrequency)
	{
		this.pingFrequency = pingFrequency;
	}
	public String getError()
	{
		return error;
	}
	public void setError(String error)
	{
		this.error = error;
	}
	
}
