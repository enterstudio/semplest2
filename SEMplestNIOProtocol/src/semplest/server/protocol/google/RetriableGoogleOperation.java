package semplest.server.protocol.google;

public interface RetriableGoogleOperation<T>
{
	void performOperation() throws Exception;
	Integer getMaxRetries();
	T getResults();		
}