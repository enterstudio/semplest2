package semplest.services.client.interfaces;


public interface TestServiceInterface extends ServiceInitialize
{
	public abstract String TestMethod(String uniqueID) throws Exception;
}
