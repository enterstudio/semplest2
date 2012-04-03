package semplest.service.keywords.lda;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import semplest.server.service.ServiceInterface;

public class KeywordGeneratorService implements ServiceInterface
{
	private static final Logger logger = Logger.getLogger(KeywordGeneratorService.class);

	@Override
	public String ServiceGet(String methodName, String jsonStr)
	{
		try
		{
			logger.debug("Running Keyword LDA Service " + methodName + ":" + jsonStr);
			KeywordGeneratorServiceImpl service = new KeywordGeneratorServiceImpl();
			Class[] parameterTypes = new Class[] {String.class};
			Method method = service.getClass().getMethod(methodName, parameterTypes);
			return (String) method.invoke(service,jsonStr);
		}
		catch (Exception e)
		{
			logger.error(e);
			e.printStackTrace();
		}
		
		return "Keyword LDA Service Error running " + methodName ;
	}

}
