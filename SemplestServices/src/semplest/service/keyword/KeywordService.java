package semplest.service.keyword;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import semplest.server.service.ServiceInterface;
import semplest.service.scheduler.SemplestSchedulerServiceImpl;

public class KeywordService implements ServiceInterface
{
	private static final Logger logger = Logger.getLogger(KeywordService.class);

	@Override
	public String ServiceGet(final String methodName, final String jsonStr) throws Exception
	{
		final String operationDescription = "Keyword Service Method [" + methodName + "] with Params [" + jsonStr + "]";
		try
		{
			logger.debug("Running " + operationDescription);
			final KeywordServiceImpl service = new KeywordServiceImpl();
			final Class[] parameterTypes = new Class[]{String.class};
			final Method method = service.getClass().getMethod(methodName, parameterTypes);
			final String results = (String)method.invoke(service, jsonStr);
			return results;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem running " + operationDescription;
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

}