package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.AdGroupBidLandscapePage;
import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.cm.DataServiceInterface;
import com.google.api.adwords.v201109.cm.Selector;

public class DataServiceAdGroupBidLandscapeGetRetriableGoogleOperation extends AbstractRetriableGoogleOperation<AdGroupBidLandscapePage>
{ 					
	private final DataServiceInterface service;
	private final Selector selector;
	 
	public DataServiceAdGroupBidLandscapeGetRetriableGoogleOperation(final DataServiceInterface service, final Selector selector, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.selector = selector;
	}
	
	protected AdGroupBidLandscapePage porformCustomOperation() throws ApiException, RemoteException
	{
		return service.getAdGroupBidLandscape(selector);	
	}		
}
