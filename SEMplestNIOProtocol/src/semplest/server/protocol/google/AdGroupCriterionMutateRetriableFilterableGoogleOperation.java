package semplest.server.protocol.google;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import semplest.util.SemplestUtils;

import com.google.api.adwords.v201109.cm.AdGroupCriterionOperation;
import com.google.api.adwords.v201109.cm.AdGroupCriterionReturnValue;
import com.google.api.adwords.v201109.cm.AdGroupCriterionServiceInterface;
import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.cm.Criterion;
import com.google.api.adwords.v201109.cm.Keyword;
import com.google.api.adwords.v201109.cm.RateExceededError;

public class AdGroupCriterionMutateRetriableFilterableGoogleOperation extends AbstractRetriableGoogleOperation<AdGroupCriterionReturnValue>
{ 					
	private static final Logger logger = Logger.getLogger(AdGroupCriterionMutateRetriableFilterableGoogleOperation.class);
	
	private final AdGroupCriterionServiceInterface service;
	private AdGroupCriterionOperation[] operations;
	private final List<AdGroupCriterionOperation> operationsRemoved;

	public AdGroupCriterionMutateRetriableFilterableGoogleOperation(final AdGroupCriterionServiceInterface service, final AdGroupCriterionOperation[] operations, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.operations = operations;
		operationsRemoved = new ArrayList<AdGroupCriterionOperation>();
	}
	
	@Override
	protected AdGroupCriterionReturnValue porformCustomOperation() throws ApiException, RemoteException
	{
		return service.mutate(operations);	
	}
	
	@Override
	protected void handleApiException(final ApiException e) throws Exception
	{
		final String errMsg = "Problem performing operation: " + e.dumpToString();
		logger.error(errMsg, e);		
		final RateExceededError rateExceededError = getRateExceededError(e);
		final List<GoogleViolation> googleViolations = SemplestUtils.getGoogleViolations_v201109(e); 
		if (rateExceededError != null)
		{
			final Integer retryAfterSeconds = getRetryAfterSeconds(rateExceededError);
			logger.info("Encountered RateExceededError.  Will sleep for " + retryAfterSeconds + " seconds");
			Thread.sleep(retryAfterSeconds * SemplestUtils.SECOND);
		}
		else if (googleViolations != null)
		{
			logger.info("Encountered PolicyViolationError(s):\n" + SemplestUtils.getEasilyReadableString(googleViolations));
			filterRequest(googleViolations);
		}
		else
		{
			throw new Exception(errMsg, e);
		}
	}

	protected void filterRequest(final List<GoogleViolation> googleViolations) throws ApiException, RemoteException
	{
		logger.info("Will try to filter out these " + googleViolations.size() + " GoogleViolations from " + operations.length + " AdGroupCriterionOperations:\n" + googleViolations);		
		final List<AdGroupCriterionOperation> operationListUmodifiable = Arrays.asList(operations);
		final List<AdGroupCriterionOperation> operationList = new ArrayList<AdGroupCriterionOperation>(operationListUmodifiable);
		final List<AdGroupCriterionOperation> operationsToRemove = new ArrayList<AdGroupCriterionOperation>(); 
		for (final GoogleViolation googleViolation : googleViolations)
		{
			final String violatingText = googleViolation.getPolicyViolatingText();
			for (final AdGroupCriterionOperation operation : operationList)
			{
				final Criterion criterion = operation.getOperand().getCriterion();
				if (criterion instanceof Keyword)
				{
					final Keyword keyword = (Keyword)criterion;
					final String keywordText = keyword.getText();
					final String keywordNonNullTrimmedText = SemplestUtils.getTrimmedNonNullString(keywordText);
					final String violatingNonNullTrimmedText = SemplestUtils.getTrimmedNonNullString(violatingText);
					if (keywordNonNullTrimmedText.toUpperCase().contains(violatingNonNullTrimmedText.toUpperCase()))
					{
						operationsToRemove.add(operation);
					}					
				}
			}			
		}
		operationList.removeAll(operationsToRemove);
		operationsRemoved.addAll(operationsToRemove);
		operations = operationList.toArray(new AdGroupCriterionOperation[operationList.size()]);
		logger.info("Removed " + operationsToRemove.size() + " operations from original set of operations, resulting in latest " + operations.length + " operations");
	}		
	
	public List<AdGroupCriterionOperation> getRemovedOperations()
	{
		return operationsRemoved;
	}
}
