package semplest.server.protocol.google;

public interface RetriableGoogleOperation<T>
{
	T performOperation() throws Exception;
	Integer getMaxRetries();
}