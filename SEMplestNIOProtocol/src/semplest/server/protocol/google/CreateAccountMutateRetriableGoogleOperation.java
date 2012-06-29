package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.mcm.Account;
import com.google.api.adwords.v201109.mcm.CreateAccountOperation;
import com.google.api.adwords.v201109.mcm.CreateAccountServiceInterface;

public class CreateAccountMutateRetriableGoogleOperation extends AbstractRetriableGoogleOperation<Account[]>
{ 					
	private final CreateAccountServiceInterface service;
	private final CreateAccountOperation[] operations;

	public CreateAccountMutateRetriableGoogleOperation(final CreateAccountServiceInterface service, final CreateAccountOperation[] operations, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.operations = operations;
	}
	
	protected Account[] porformCustomOperation() throws ApiException, RemoteException
	{
		return service.mutate(operations);	
	}		
}
