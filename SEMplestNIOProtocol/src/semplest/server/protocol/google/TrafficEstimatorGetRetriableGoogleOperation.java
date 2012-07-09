package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.o.TrafficEstimatorResult;
import com.google.api.adwords.v201109.o.TrafficEstimatorSelector;
import com.google.api.adwords.v201109.o.TrafficEstimatorServiceInterface;

public class TrafficEstimatorGetRetriableGoogleOperation extends AbstractRetriableGoogleOperation<TrafficEstimatorResult>
{ 					
	private final TrafficEstimatorServiceInterface service;
	private final TrafficEstimatorSelector selector;

	public TrafficEstimatorGetRetriableGoogleOperation(final TrafficEstimatorServiceInterface service, final TrafficEstimatorSelector selector, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.selector = selector;
	}
	
	protected TrafficEstimatorResult performCustomOperation() throws ApiException, RemoteException
	{
		return service.get(selector);	
	}		
}
