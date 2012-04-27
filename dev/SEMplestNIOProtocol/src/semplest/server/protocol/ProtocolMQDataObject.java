package semplest.server.protocol;

public class ProtocolMQDataObject
{
	
	
	private String uniqueID = null;
	private Byte typeOP;
	private String service = null;
	private String method = null;
	
	
	public String getuniqueID()
	{
		return uniqueID;
	}
	public void setUniqueID(String uniqueID)
	{
		this.uniqueID = uniqueID;
	}
	public Byte gettypeOP()
	{
		return typeOP;
	}
	public void setTypeOP(Byte typeOP)
	{
		this.typeOP = typeOP;
	}
	public String getservice()
	{
		return service;
	}
	public void setService(String service)
	{
		this.service = service;
	}
	public String getmethod()
	{
		return method;
	}
	public void setMethod(String method)
	{
		this.method = method;
	}

}
