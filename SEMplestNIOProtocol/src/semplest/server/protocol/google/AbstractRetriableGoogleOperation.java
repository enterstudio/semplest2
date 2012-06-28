package semplest.server.protocol.google;

import java.rmi.RemoteException;

import org.apache.log4j.Logger;

import semplest.util.SemplestUtils;

import com.google.api.adwords.v201109.cm.ApiError;
import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.cm.RateExceededError;

public abstract class AbstractRetriableGoogleOperation<T> implements RetriableGoogleOperation<T>
{		
	private static final Logger logger = Logger.getLogger(AbstractRetriableGoogleOperation.class);
	
	protected final Integer maxRetries;
	
	protected AbstractRetriableGoogleOperation(final Integer maxRetries)
	{
		this.maxRetries = maxRetries;
	}
	
	@Override
	public Integer getMaxRetries()
	{
		return maxRetries;
	}
		
	@Override
	public T performOperation() throws Exception 
	{			
		for (int i = 1; i <= maxRetries; ++i)
		{
			try 
			{
				logger.info("Attempt #" + i);
				return porformCustomOperation();					
			}
			catch (ApiException e)
			{
				handleApiException(e);
			}
		}
		throw new Exception("Problem performing operation because maximum num of retries reached [" + maxRetries + "]");
	}
	
	protected abstract T porformCustomOperation() throws ApiException, RemoteException;
	
	protected void handleApiException(final ApiException e) throws Exception
	{
		final String errMsg = "Problem performing operation: " + e.dumpToString();
		logger.error(errMsg, e);
		final RateExceededError rateExceededError = getRateExceededError(e);
		if (rateExceededError == null)
		{
			throw new Exception(errMsg, e);
		}
		final Integer retryAfterSeconds = getRetryAfterSeconds(rateExceededError);
		logger.info("Encountered RateExceededError.  Will sleep for " + retryAfterSeconds + " seconds");
		Thread.sleep(retryAfterSeconds * SemplestUtils.SECOND);				
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