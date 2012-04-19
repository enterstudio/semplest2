package semplest.server.protocol;

public class TaskOutput
{
	private Boolean isSuccessful;
	private String errorMessage = null;
	private Object result;
	private Class returnType;
	
	public Boolean getIsSuccessful()
	{
		return isSuccessful;
	}
	public void setIsSuccessful(Boolean isSuccessful)
	{
		this.isSuccessful = isSuccessful;
	}
	public String getErrorMessage()
	{
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}
	public Object getResult()
	{
		return result;
	}
	public void setResult(Object result)
	{
		this.result = result;
	}
	public Class getReturnType()
	{
		return returnType;
	}
	public void setReturnType(Class returnType)
	{
		this.returnType = returnType;
	}

}
