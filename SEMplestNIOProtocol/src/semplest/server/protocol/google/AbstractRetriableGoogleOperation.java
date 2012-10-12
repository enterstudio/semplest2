package semplest.server.protocol.google;

import java.rmi.RemoteException;
import java.util.List;

import org.apache.log4j.Logger;

import semplest.server.protocol.RetriableOperation;
import semplest.util.SemplestUtils;

import com.google.api.adwords.v201109.cm.ApiError;
import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.cm.DatabaseError;
import com.google.api.adwords.v201109.cm.PolicyViolationError;
import com.google.api.adwords.v201109.cm.PolicyViolationKey;
import com.google.api.adwords.v201109.cm.RateExceededError;

public abstract class AbstractRetriableGoogleOperation<T> implements RetriableOperation<T>
{		
	private static final Logger logger = Logger.getLogger(AbstractRetriableGoogleOperation.class);
	
	protected final Integer maxRetries;
	
	protected AbstractRetriableGoogleOperation(final Integer maxRetries)
	{
		this.maxRetries = maxRetries;
	}
	
	@Override
	public T performOperation() throws Exception 
	{			
		for (int i = 1; i <= maxRetries; ++i)
		{
			try 
			{
				logger.info("Attempt #" + i);	
				
				// this for testing only
				/*if (this instanceof AdGroupCriterionMutateRetriableFilterableGoogleOperation)
				{
					if (SemplestUtils.getRandomIntBetween0AndSpecifiedInt(2) == 0)
					{
						final ApiError apiError = new PolicyViolationError("fieldPath1", "Test Trigger", "This is a simulated error", "apiErrorType1", new PolicyViolationKey("policyName1", "best medical care"), "externalPolicyName1", "externalPolicyUrl1", "externalPolicyDescription1", Boolean.TRUE,null);
						final ApiError[] apiErrors = new ApiError[]{apiError};
						throw new ApiException("Randomly generated exception for testing", "this is only for testing", apiErrors);
					}
					else
					{
						return performCustomOperation();
					}
				}
				else
				{*/
					return performCustomOperation();
				//}
			}
			catch (ApiException e)
			{
				handleApiException(e);
				Thread.sleep(1 * SemplestUtils.SECOND);
			}
		}
		throw new Exception("Problem performing operation because maximum num of retries reached [" + maxRetries + "]");
	}
	
	protected abstract T performCustomOperation() throws ApiException, RemoteException;
	
	protected void handleApiException(final ApiException e) throws Exception
	{
		final String errMsg = "Problem performing operation: " + e.dumpToString();
		logger.error(errMsg, e);
		final RateExceededError rateExceededError = getRateExceededError(e);
		final DatabaseError databaseError = getDatabaseError(e);
		if (rateExceededError != null)
		{
			final Integer retryAfterSeconds = getRetryAfterSeconds(rateExceededError);
			logger.info("Encountered RateExceededError.  Will sleep for " + retryAfterSeconds + " seconds");
			Thread.sleep(retryAfterSeconds * SemplestUtils.SECOND);			
		}
		else if (databaseError != null)
		{
			logger.info("Encountered DatabaseError.  Will sleep for " + SemplestUtils.DEFAULT_API_SLEEP_SECS + " seconds");
			Thread.sleep(SemplestUtils.DEFAULT_API_SLEEP_SECS * SemplestUtils.SECOND);		
		}
		else
		{
			final List<GoogleViolation> validations = SemplestUtils.getGoogleViolations_v201109(e);
			if (validations != null && !validations.isEmpty())
			{
				logger.info("Encountered Validation Problems:\n" + SemplestUtils.getEasilyReadableString(validations));
			}
			logger.info("Encountered ApiException.  Will try again (if not yet hit the limit of [" + maxRetries + "] times ).");
		}
	}
	
	public static DatabaseError getDatabaseError(final ApiException e)
	{
		final ApiError[] apiErrors = e.getErrors();
		if (apiErrors != null)
		{
			for (final ApiError apiError : apiErrors)
			{
				if (apiError instanceof DatabaseError)
				{
					final DatabaseError databaseError = (DatabaseError)apiError;
					return databaseError;						
				}
			}
		}
		return null;
	}
	
	public static RateExceededError getRateExceededError(final ApiException e)
	{
		final ApiError[] apiErrors = e.getErrors();
		if (apiErrors != null)
		{
			for (final ApiError apiError : apiErrors)
			{
				if (apiError instanceof RateExceededError)
				{
					final RateExceededError rateExceededError = (RateExceededError)apiError;
					return rateExceededError;						
				}
			}
		}
		return null;
	}
	
	public static Integer getRetryAfterSeconds(final RateExceededError rateExceededError)
	{		
		final Integer retryAfterSecondsFromError = rateExceededError.getRetryAfterSeconds();	
		if (retryAfterSecondsFromError != 0)
		{
			return retryAfterSecondsFromError;
		}
		return SemplestUtils.DEFAULT_API_SLEEP_SECS;
	}
}