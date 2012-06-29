package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.AdGroupOperation;
import com.google.api.adwords.v201109.cm.AdGroupReturnValue;
import com.google.api.adwords.v201109.cm.AdGroupServiceInterface;
import com.google.api.adwords.v201109.cm.ApiException;

public class AdGroupMutateRetriableGoogleOperation extends AbstractRetriableGoogleOperation<AdGroupReturnValue>
{ 					
	private final AdGroupServiceInterface service;
	private final AdGroupOperation[] operations;

	public AdGroupMutateRetriableGoogleOperation(final AdGroupServiceInterface service, final AdGroupOperation[] operations, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.operations = operations;
	}
	
	protected AdGroupReturnValue porformCustomOperation() throws ApiException, RemoteException
	{
		return service.mutate(operations);	
	}		
}
