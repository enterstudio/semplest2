package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.AdGroupCriterionOperation;
import com.google.api.adwords.v201109.cm.AdGroupCriterionReturnValue;
import com.google.api.adwords.v201109.cm.AdGroupCriterionServiceInterface;
import com.google.api.adwords.v201109.cm.ApiException;

public class AdGroupCriterionRetriableGoogleOperation extends AbstractRetriableGoogleOperation<AdGroupCriterionReturnValue>
{ 					
	private final AdGroupCriterionServiceInterface service;
	private final AdGroupCriterionOperation[] operations;

	public AdGroupCriterionRetriableGoogleOperation(final AdGroupCriterionServiceInterface service, final AdGroupCriterionOperation[] operations, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.operations = operations;
	}
	
	protected AdGroupCriterionReturnValue porformCustomOperation() throws ApiException, RemoteException
	{
		return service.mutate(operations);	
	}		
}
