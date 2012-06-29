package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.cm.CampaignPage;
import com.google.api.adwords.v201109.cm.CampaignServiceInterface;
import com.google.api.adwords.v201109.cm.Selector;

public class CampaignGetRetriableGoogleOperation extends AbstractRetriableGoogleOperation<CampaignPage>
{ 					
	private final CampaignServiceInterface service;
	private final Selector selector;

	public CampaignGetRetriableGoogleOperation(final CampaignServiceInterface service, final Selector selector, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.selector = selector;
	}
	
	protected CampaignPage porformCustomOperation() throws ApiException, RemoteException
	{
		return service.get(selector);	
	}		
}
