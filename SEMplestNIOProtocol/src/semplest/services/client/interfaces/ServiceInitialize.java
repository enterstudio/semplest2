package semplest.services.client.interfaces;

public interface ServiceInitialize
{
	public abstract void initializeService(String input) throws Exception;	
	public abstract String checkStatus(String input1, String input2) throws Exception;  //Check Status of the Service
}
