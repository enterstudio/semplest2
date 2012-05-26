package semplest.server.ESB;

import javax.jms.MessageProducer;

import semplest.server.socket.ServicePingHandler;

public class ServiceRegistrationData
{
	
	private String ESBSendQueueName = null;
	private String ESBRecQueueName = null;
	private String serviceOffered = null;
	private MessageProducer messageProducer = null;
	private ServicePingHandler pingHandler = null;
	
	private java.util.Date regTime = null;
	
	public java.util.Date getRegTime()
	{
		return regTime;
	}
	public void setRegTime(java.util.Date regTime)
	{
		this.regTime = regTime;
	}
	public MessageProducer getMessageProducer()
	{
		return messageProducer;
	}
	public void setMessageProducer(MessageProducer messageProducer)
	{
		this.messageProducer = messageProducer;
	}
	public String getESBSendQueueName()
	{
		return ESBSendQueueName;
	}
	public void setESBSendQueueName(String eSBSendQueueName)
	{
		ESBSendQueueName = eSBSendQueueName;
	}
	public String getESBRecQueueName()
	{
		return ESBRecQueueName;
	}
	public void setESBRecQueueName(String eSBRecQueueName)
	{
		ESBRecQueueName = eSBRecQueueName;
	}
	public ServicePingHandler getPingHandler()
	{
		return pingHandler;
	}
	public void setPingHandler(ServicePingHandler pingHandler)
	{
		this.pingHandler = pingHandler;
	}
	public String getServiceOffered()
	{
		return serviceOffered;
	}
	public void setServiceOffered(String serviceOffered)
	{
		this.serviceOffered = serviceOffered;
	}
	
	

}
