package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.AdGroupCriterionPage;
import com.google.api.adwords.v201109.cm.AdGroupCriterionServiceInterface;
import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.cm.Selector;

public class AdGroupCriterionGetRetriableGoogleOperation extends AbstractRetriableGoogleOperation<AdGroupCriterionPage>
{ 					
	private final AdGroupCriterionServiceInterface service;
	private final Selector selector;

	public AdGroupCriterionGetRetriableGoogleOperation(final AdGroupCriterionServiceInterface service, final Selector selector, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.selector = selector;
	}
	
	protected AdGroupCriterionPage porformCustomOperation() throws ApiException, RemoteException
	{
		return service.get(selector);	
	}		
}
