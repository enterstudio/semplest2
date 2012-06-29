package semplest.server.protocol.google;

import java.rmi.RemoteException;

import com.google.api.adwords.v201109.cm.ApiException;

public class BudgetOrderMutateRetriableGoogleOperation extends AbstractRetriableGoogleOperation<com.google.api.adwords.v201109_1.billing.BudgetOrderReturnValue>
{ 					
	private final com.google.api.adwords.v201109_1.billing.BudgetOrderServiceInterface service;
	private final com.google.api.adwords.v201109_1.billing.BudgetOrderOperation[] operations;

	public BudgetOrderMutateRetriableGoogleOperation(final com.google.api.adwords.v201109_1.billing.BudgetOrderServiceInterface budgetOrderService, final com.google.api.adwords.v201109_1.billing.BudgetOrderOperation[] operations, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = budgetOrderService;
		this.operations = operations;
	}
	
	protected com.google.api.adwords.v201109_1.billing.BudgetOrderReturnValue porformCustomOperation() throws ApiException, RemoteException
	{
		return service.mutate(operations);	
	}		
}
