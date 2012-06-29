package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.cm.CriterionBidLandscapePage;
import com.google.api.adwords.v201109.cm.DataServiceInterface;
import com.google.api.adwords.v201109.cm.Selector;

public class DataServiceCriterionBidLandscapeGetRetriableGoogleOperation extends AbstractRetriableGoogleOperation<CriterionBidLandscapePage>
{ 					
	private final DataServiceInterface service;
	private final Selector selector;
	 
	public DataServiceCriterionBidLandscapeGetRetriableGoogleOperation(final DataServiceInterface service, final Selector selector, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.selector = selector;
	}
	
	protected CriterionBidLandscapePage porformCustomOperation() throws ApiException, RemoteException
	{
		return service.getCriterionBidLandscape(selector);	
	}		
}
