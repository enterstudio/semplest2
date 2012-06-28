package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.cm.CampaignCriterionOperation;
import com.google.api.adwords.v201109.cm.CampaignCriterionReturnValue;
import com.google.api.adwords.v201109.cm.CampaignCriterionServiceInterface;

public class CampaignCriterionRetriableGoogleOperation extends AbstractRetriableGoogleOperation<CampaignCriterionReturnValue>
{ 					
	private final CampaignCriterionServiceInterface campaignCriterionService;
	private final CampaignCriterionOperation[] operations;

	public CampaignCriterionRetriableGoogleOperation(final CampaignCriterionServiceInterface campaignCriterionService, final CampaignCriterionOperation[] operations, final Integer maxRetries)
	{
		super(maxRetries);
		this.campaignCriterionService = campaignCriterionService;
		this.operations = operations;
	}
	
	public void porformCustomOperation() throws ApiException, RemoteException
	{
		results = campaignCriterionService.mutate(operations);	
	}		
}
