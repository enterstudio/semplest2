package semplest.server.protocol;

public interface RetriableOperation<T>
{
	T performOperation() throws Exception;
}