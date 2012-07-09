package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.info.ApiUsageInfo;
import com.google.api.adwords.v201109.info.InfoSelector;
import com.google.api.adwords.v201109.info.InfoServiceInterface;

public class InfoServiceGetRetriableGoogleOperation extends AbstractRetriableGoogleOperation<ApiUsageInfo>
{ 					
	private final InfoServiceInterface service;
	private final InfoSelector selector;

	public InfoServiceGetRetriableGoogleOperation(final InfoServiceInterface service, final InfoSelector selector, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.selector = selector;
	}
	
	protected ApiUsageInfo performCustomOperation() throws ApiException, RemoteException
	{
		return service.get(selector);	
	}			
}
