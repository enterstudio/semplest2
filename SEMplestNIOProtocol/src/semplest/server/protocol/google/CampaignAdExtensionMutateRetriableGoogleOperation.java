package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109_1.cm.CampaignAdExtensionOperation;
import com.google.api.adwords.v201109_1.cm.CampaignAdExtensionReturnValue;
import com.google.api.adwords.v201109_1.cm.CampaignAdExtensionServiceInterface;

public class CampaignAdExtensionMutateRetriableGoogleOperation extends AbstractRetriableGoogleOperation<CampaignAdExtensionReturnValue>
{ 					
	private final CampaignAdExtensionServiceInterface service;
	private final CampaignAdExtensionOperation[] operations;

	public CampaignAdExtensionMutateRetriableGoogleOperation(final CampaignAdExtensionServiceInterface campaignAdExtensionService, final CampaignAdExtensionOperation[] operations, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = campaignAdExtensionService;
		this.operations = operations;
	}
	
	protected CampaignAdExtensionReturnValue porformCustomOperation() throws ApiException, RemoteException
	{
		return service.mutate(operations);	
	}		
}
