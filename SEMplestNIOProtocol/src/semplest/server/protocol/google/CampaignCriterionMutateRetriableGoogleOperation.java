package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.cm.CampaignCriterionOperation;
import com.google.api.adwords.v201109.cm.CampaignCriterionReturnValue;
import com.google.api.adwords.v201109.cm.CampaignCriterionServiceInterface;

public class CampaignCriterionMutateRetriableGoogleOperation extends AbstractRetriableGoogleOperation<CampaignCriterionReturnValue>
{ 					
	private final CampaignCriterionServiceInterface service;
	private final CampaignCriterionOperation[] operations;

	public CampaignCriterionMutateRetriableGoogleOperation(final CampaignCriterionServiceInterface service, final CampaignCriterionOperation[] operations, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.operations = operations;
	}
	
	protected CampaignCriterionReturnValue performCustomOperation() throws ApiException, RemoteException
	{
		return service.mutate(operations);	
	}		
}
