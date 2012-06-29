package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.cm.CampaignCriterionPage;
import com.google.api.adwords.v201109.cm.CampaignCriterionServiceInterface;
import com.google.api.adwords.v201109.cm.Selector;

public class CampaignCriterionGetRetriableGoogleOperation extends AbstractRetriableGoogleOperation<CampaignCriterionPage>
{ 					
	private final CampaignCriterionServiceInterface service;
	private final Selector selector;

	public CampaignCriterionGetRetriableGoogleOperation(final CampaignCriterionServiceInterface service, final Selector selector, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.selector = selector;
	}
	
	protected CampaignCriterionPage porformCustomOperation() throws ApiException, RemoteException
	{
		return service.get(selector);	
	}		
}
