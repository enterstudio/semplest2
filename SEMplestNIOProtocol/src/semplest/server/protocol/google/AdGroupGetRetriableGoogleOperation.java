package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.AdGroupPage;
import com.google.api.adwords.v201109.cm.AdGroupServiceInterface;
import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.cm.Selector;

public class AdGroupGetRetriableGoogleOperation extends AbstractRetriableGoogleOperation<AdGroupPage>
{ 					
	private final AdGroupServiceInterface service;
	private final Selector selector;

	public AdGroupGetRetriableGoogleOperation(final AdGroupServiceInterface service, final Selector selector, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.selector = selector;
	}
	
	protected AdGroupPage performCustomOperation() throws ApiException, RemoteException
	{
		return service.get(selector);	
	}		
}
