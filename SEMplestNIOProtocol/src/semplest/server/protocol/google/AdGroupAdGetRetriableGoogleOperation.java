package semplest.server.protocol.google;

import java.rmi.RemoteException;
import java.util.List;

import com.google.api.adwords.v201109.cm.AdGroupAdPage;
import com.google.api.adwords.v201109.cm.AdGroupAdServiceInterface;
import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.cm.Selector;

public class AdGroupAdGetRetriableGoogleOperation extends AbstractRetriableGoogleOperation<AdGroupAdPage>
{ 					
	private final AdGroupAdServiceInterface service;
	private final Selector selector;

	public AdGroupAdGetRetriableGoogleOperation(final AdGroupAdServiceInterface service, final Selector selector, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.selector = selector;
	}
	
	protected AdGroupAdPage performCustomOperation() throws ApiException, RemoteException
	{
		return service.get(selector);	
	}
}
