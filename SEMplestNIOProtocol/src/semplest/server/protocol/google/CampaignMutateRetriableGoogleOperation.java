package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.cm.CampaignOperation;
import com.google.api.adwords.v201109.cm.CampaignReturnValue;
import com.google.api.adwords.v201109.cm.CampaignServiceInterface;

public class CampaignMutateRetriableGoogleOperation extends AbstractRetriableGoogleOperation<CampaignReturnValue>
{ 					
	private final CampaignServiceInterface service;
	private final CampaignOperation[] operations;

	public CampaignMutateRetriableGoogleOperation(final CampaignServiceInterface service, final CampaignOperation[] operations, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.operations = operations;
	}
	
	protected CampaignReturnValue porformCustomOperation() throws ApiException, RemoteException
	{
		return service.mutate(operations);	
	}		
}
