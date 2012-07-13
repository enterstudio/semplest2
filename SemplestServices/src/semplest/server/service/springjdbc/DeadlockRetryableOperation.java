package semplest.server.service.springjdbc;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.retry.RetryCallback;
import org.springframework.batch.retry.RetryContext;
import org.springframework.batch.retry.policy.SimpleRetryPolicy;
import org.springframework.batch.retry.support.RetryTemplate;

public class DeadlockRetryableOperation<T>
{
	private static final Logger logger = Logger.getLogger(DeadlockRetryableOperation.class);
	
	public T executeRetryOnDeadlock(final int maxNumRetries) throws Exception
	{
		final SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
		final List<Class<? extends Throwable>> retryableExceptionClasses = new ArrayList<Class<? extends Throwable>>();
		retryableExceptionClasses.add(org.springframework.dao.DeadlockLoserDataAccessException.class);		
		final RetryTemplate template = new RetryTemplate();		
		retryPolicy.setRetryableExceptionClasses(retryableExceptionClasses);
		retryPolicy.setMaxAttempts(maxNumRetries);
		template.setRetryPolicy(retryPolicy);		
		try
		{
			final T results = template.execute(new RetryCallback<T>() 
												 {
													    public T doWithRetry(RetryContext context) throws Exception
													    {
													        logger.info("Attempt #" + context.getRetryCount() + 1);
													        
															final T results = null;
													        return results;
													    }								    
												 });
			return results;
		}
		catch (Exception e)
		{
			throw new Exception("Problem performing operation even after max " + maxNumRetries + " retries", e);
		}
	}
}
