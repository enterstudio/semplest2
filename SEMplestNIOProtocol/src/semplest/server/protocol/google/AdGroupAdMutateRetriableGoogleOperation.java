package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.AdGroupAdOperation;
import com.google.api.adwords.v201109.cm.AdGroupAdReturnValue;
import com.google.api.adwords.v201109.cm.AdGroupAdServiceInterface;
import com.google.api.adwords.v201109.cm.ApiException;

public class AdGroupAdMutateRetriableGoogleOperation extends AbstractRetriableGoogleOperation<AdGroupAdReturnValue>
{ 					
	private final AdGroupAdServiceInterface service;
	private final AdGroupAdOperation[] operations;

	public AdGroupAdMutateRetriableGoogleOperation(final AdGroupAdServiceInterface service, final AdGroupAdOperation[] operations, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.operations = operations;
	}
	
	protected AdGroupAdReturnValue porformCustomOperation() throws ApiException, RemoteException
	{
		return service.mutate(operations);	
	}		
}
