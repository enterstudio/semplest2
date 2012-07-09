package semplest.server.protocol.google;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import semplest.util.SemplestUtils;

import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.cm.CampaignCriterion;
import com.google.api.adwords.v201109.cm.CampaignCriterionOperation;
import com.google.api.adwords.v201109.cm.CampaignCriterionReturnValue;
import com.google.api.adwords.v201109.cm.CampaignCriterionServiceInterface;
import com.google.api.adwords.v201109.cm.Criterion;
import com.google.api.adwords.v201109.cm.Keyword;
import com.google.api.adwords.v201109.cm.NegativeCampaignCriterion;
import com.google.api.adwords.v201109.cm.RateExceededError;

public class CampaignCriterionMutateRetriableFilterableGoogleOperation extends AbstractRetriableGoogleOperation<CampaignCriterionReturnValue>
{
	private static final Logger logger = Logger.getLogger(CampaignCriterionMutateRetriableFilterableGoogleOperation.class);

	private final CampaignCriterionServiceInterface service;
	private CampaignCriterionOperation[] operations;
	private final Map<CampaignCriterionOperation, String> operationsRemovedToErrorMessageMap;

	public CampaignCriterionMutateRetriableFilterableGoogleOperation(final CampaignCriterionServiceInterface service, final CampaignCriterionOperation[] operations, final Integer maxRetries)
	{
		super(maxRetries);
		this.service = service;
		this.operations = operations;
		operationsRemovedToErrorMessageMap = new HashMap<CampaignCriterionOperation, String>();
	}

	protected CampaignCriterionReturnValue performCustomOperation() throws ApiException, RemoteException
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
			logger.info(errMsg + ". Encountered RateExceededError.  Will sleep for " + retryAfterSeconds + " seconds");
			Thread.sleep(retryAfterSeconds * SemplestUtils.SECOND);
		}
		else if (googleViolations != null)
		{
			logger.info(errMsg + ". Encountered PolicyViolationError(s):\n" + SemplestUtils.getEasilyReadableString(googleViolations));
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
		final List<CampaignCriterionOperation> operationListUmodifiable = Arrays.asList(operations);
		final List<CampaignCriterionOperation> operationList = new ArrayList<CampaignCriterionOperation>(operationListUmodifiable);
		final List<CampaignCriterionOperation> operationsToRemove = new ArrayList<CampaignCriterionOperation>();
		final Map<CampaignCriterionOperation, String> operationsToErrorMessageMapForRemoval = new HashMap<CampaignCriterionOperation, String>();
		for (final GoogleViolation googleViolation : googleViolations)
		{
			final String violatingText = googleViolation.getPolicyViolatingText();
			for (final CampaignCriterionOperation operation : operationList)
			{
				final CampaignCriterion campaignCriterion = operation.getOperand();
				if (campaignCriterion instanceof NegativeCampaignCriterion)
				{
					final NegativeCampaignCriterion negativeCampaignCriterion = (NegativeCampaignCriterion) campaignCriterion;
					final Criterion criterion = negativeCampaignCriterion.getCriterion();
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
							operationsToErrorMessageMapForRemoval.put(operation, errMessage);
						}
					}
				}
			}
		}
		operationList.removeAll(operationsToRemove);
		operationsRemovedToErrorMessageMap.putAll(operationsToErrorMessageMapForRemoval);
		operations = operationList.toArray(new CampaignCriterionOperation[operationList.size()]);
		logger.info("Removed the following " + operationsToErrorMessageMapForRemoval.size() + " operations from original set of operations, resulting in latest " + operations.length + " operations:\n" + SemplestUtils.getEasilyReadableString(operationsToErrorMessageMapForRemoval));
	}

	public Map<CampaignCriterionOperation, String> getRemovedOperations()
	{
		return operationsRemovedToErrorMessageMap;
	}
}
