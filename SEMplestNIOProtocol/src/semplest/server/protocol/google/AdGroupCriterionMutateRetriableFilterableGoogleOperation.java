package semplest.server.protocol.google;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private final Map<AdGroupCriterionOperation, String> operationsRemovedToPkMap;

	public AdGroupCriterionMutateRetriableFilterableGoogleOperation(final AdGroupCriterionServiceInterface service,
			final AdGroupCriterionOperation[] operations, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.operations = operations;
		operationsRemovedToPkMap = new HashMap<AdGroupCriterionOperation, String>();
	}

	@Override
	protected AdGroupCriterionReturnValue performCustomOperation() throws ApiException, RemoteException
	{
		return service.mutate(operations);
	}

	@Override
	protected void handleApiException(final ApiException e) throws Exception
	{
		final String errMsg = "Problem performing operation: " + e.dumpToString();
		final RateExceededError rateExceededError = getRateExceededError(e);
		final List<GoogleViolation> googleViolations = SemplestUtils.getGoogleViolations_v201109(e);
		if (rateExceededError != null)
		{
			final Integer retryAfterSeconds = getRetryAfterSeconds(rateExceededError);
			logger.info(errMsg + ".  Encountered RateExceededError.  Will sleep for " + retryAfterSeconds + " seconds");
			Thread.sleep(retryAfterSeconds * SemplestUtils.SECOND);
		}
		else if (googleViolations != null)
		{
			logger.info(errMsg + ".  Encountered PolicyViolationError(s):\n" + SemplestUtils.getEasilyReadableString(googleViolations));
			filterRequest(googleViolations);
		}
		else
		{
			throw new Exception(errMsg, e);
		}
	}

	protected void filterRequest(final List<GoogleViolation> googleViolations) throws ApiException, RemoteException
	{
		logger.info("Will try to filter out these " + googleViolations.size() + " GoogleViolations from " + operations.length
				+ " AdGroupCriterionOperations:\n" + googleViolations);
		final List<AdGroupCriterionOperation> operationListUmodifiable = Arrays.asList(operations);
		final List<AdGroupCriterionOperation> operationList = new ArrayList<AdGroupCriterionOperation>(operationListUmodifiable);
		final List<AdGroupCriterionOperation> operationsToRemove = new ArrayList<AdGroupCriterionOperation>();
		final Map<AdGroupCriterionOperation, String> operationsToPkMapForRemoval = new HashMap<AdGroupCriterionOperation, String>();
		for (final GoogleViolation googleViolation : googleViolations)
		{
			final String violatingText = googleViolation.getPolicyViolatingText();
			for (final AdGroupCriterionOperation operation : operationList)
			{
				final Criterion criterion = operation.getOperand().getCriterion();
				if (criterion instanceof Keyword)
				{
					final Keyword keyword = (Keyword) criterion;
					final String keywordText = keyword.getText();
					final String keywordNonNullTrimmedText = SemplestUtils.getTrimmedNonNullString(keywordText);
					final String violatingNonNullTrimmedText = SemplestUtils.getTrimmedNonNullString(violatingText);
					if (keywordNonNullTrimmedText.toUpperCase().contains(violatingNonNullTrimmedText.toUpperCase()))
					{
						final String errMessage = googleViolation.toString();
						operationsToRemove.add(operation);
						operationsToPkMapForRemoval.put(operation, errMessage);
					}
				}
			}
		}
		operationList.removeAll(operationsToRemove);
		operationsRemovedToPkMap.putAll(operationsToPkMapForRemoval);
		operations = operationList.toArray(new AdGroupCriterionOperation[operationList.size()]);
		logger.info("Removed the following " + operationsToPkMapForRemoval.size()
				+ " operations from original set of operations, resulting in latest " + operations.length + " operations:\n"
				+ SemplestUtils.getEasilyReadableString(operationsToPkMapForRemoval));
	}

	public Map<AdGroupCriterionOperation, String> getRemovedOperations()
	{
		return operationsRemovedToPkMap;
	}
}
