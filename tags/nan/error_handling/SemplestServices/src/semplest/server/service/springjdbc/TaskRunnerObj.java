package semplest.server.service.springjdbc;

public class TaskRunnerObj
{
	private String ServiceName;
	private String MethodName;
	private String Parameters;
	private Integer SchedulePK;
	private Integer TaskExecutionOrder;
	public String getServiceName()
	{
		return ServiceName;
	}
	public void setServiceName(String serviceName)
	{
		ServiceName = serviceName;
	}
	public String getMethodName()
	{
		return MethodName;
	}
	public void setMethodName(String methodName)
	{
		MethodName = methodName;
	}
	public String getParameters()
	{
		return Parameters;
	}
	public void setParameters(String parameters)
	{
		Parameters = parameters;
	}
	public Integer getSchedulePK()
	{
		return SchedulePK;
	}
	public void setSchedulePK(Integer schedulePK)
	{
		SchedulePK = schedulePK;
	}
	public Integer getTaskExecutionOrder()
	{
		return TaskExecutionOrder;
	}
	public void setTaskExecutionOrder(Integer taskExecutionOrder)
	{
		TaskExecutionOrder = taskExecutionOrder;
	}

}
