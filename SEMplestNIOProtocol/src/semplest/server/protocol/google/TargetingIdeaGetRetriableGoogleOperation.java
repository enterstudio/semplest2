package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.o.TargetingIdeaPage;
import com.google.api.adwords.v201109.o.TargetingIdeaSelector;
import com.google.api.adwords.v201109.o.TargetingIdeaServiceInterface;

public class TargetingIdeaGetRetriableGoogleOperation extends AbstractRetriableGoogleOperation<TargetingIdeaPage>
{ 					
	private final TargetingIdeaServiceInterface service;
	private final TargetingIdeaSelector selector;

	public TargetingIdeaGetRetriableGoogleOperation(final TargetingIdeaServiceInterface service, final TargetingIdeaSelector selector, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.selector = selector;
	}
	
	protected TargetingIdeaPage porformCustomOperation() throws ApiException, RemoteException
	{
		return service.get(selector);	
	}		
}
