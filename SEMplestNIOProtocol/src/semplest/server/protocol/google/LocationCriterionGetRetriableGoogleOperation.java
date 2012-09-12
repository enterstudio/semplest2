package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.cm.LocationCriterion;
import com.google.api.adwords.v201109.cm.LocationCriterionServiceInterface;
import com.google.api.adwords.v201109.cm.Selector;

public class LocationCriterionGetRetriableGoogleOperation extends AbstractRetriableGoogleOperation<LocationCriterion[]>
{ 					
	private final LocationCriterionServiceInterface service;
	private final Selector selector;

	public LocationCriterionGetRetriableGoogleOperation(final LocationCriterionServiceInterface service, final Selector selector, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.selector = selector;
	}
	
	protected LocationCriterion[] performCustomOperation() throws ApiException, RemoteException
	{
		return service.get(selector);	
	}	
}
