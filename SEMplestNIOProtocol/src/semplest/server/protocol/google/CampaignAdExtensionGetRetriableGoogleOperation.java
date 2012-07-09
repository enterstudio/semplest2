package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109_1.cm.CampaignAdExtensionPage;
import com.google.api.adwords.v201109_1.cm.Selector;
import com.google.api.adwords.v201109_1.cm.CampaignAdExtensionServiceInterface;

public class CampaignAdExtensionGetRetriableGoogleOperation extends AbstractRetriableGoogleOperation<CampaignAdExtensionPage>
{ 					
	private final CampaignAdExtensionServiceInterface service;
	private final Selector selector;

	public CampaignAdExtensionGetRetriableGoogleOperation(final CampaignAdExtensionServiceInterface service, final Selector selector, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.selector = selector;
	}
	
	protected CampaignAdExtensionPage performCustomOperation() throws ApiException, RemoteException
	{
		return service.get(selector);	
	}		
}
