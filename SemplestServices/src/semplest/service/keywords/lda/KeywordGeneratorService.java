package semplest.service.keywords.lda;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import semplest.server.service.SEMplestService;
import semplest.server.service.ServiceInterface;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.util.SemplestErrorHandler;

public class KeywordGeneratorService implements ServiceInterface
{
	private static final Logger logger = Logger.getLogger(KeywordGeneratorService.class);

	@Override
	public String ServiceGet(String methodName, String jsonStr) throws Exception
	{
		try
		{
			logger.debug("Running Keyword LDA Service " + methodName + ":" + jsonStr);
			final KeywordGeneratorServiceImpl service = new KeywordGeneratorServiceImpl();
			final Class[] parameterTypes = new Class[]{String.class};
			Method method = service.getClass().getMethod(methodName, parameterTypes);
			return (String) method.invoke(service,jsonStr);
		}
		catch (Exception e)
		{
			logger.error("ServiceGet Error: " + e.getMessage(), e);
			SemplestErrorHandler.logToDatabase(new Exception("ServiceGet - " + e.getMessage(), e));
			throw e;	
		}
	}

}
