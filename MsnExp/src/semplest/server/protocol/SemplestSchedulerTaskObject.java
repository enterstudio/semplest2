package semplest.server.protocol;

public class SemplestSchedulerTaskObject
{
	private String clientServiceName;
	private String methodName;
	private String parameters;
	
	public String getMethodName()
	{
		return methodName;
	}
	public void setMethodName(String methodName)
	{
		this.methodName = methodName;
	}
	public String getParameters()
	{
		return parameters;
	}
	public void setParameters(String parameters)
	{
		this.parameters = parameters;
	}
	public String getClientServiceName()
	{
		return clientServiceName;
	}
	public void setClientServiceName(String clientServiceName)
	{
		this.clientServiceName = clientServiceName;
	}
	

}
