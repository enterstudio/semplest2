package semplest.service.google.adwords;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import semplest.server.service.ServiceInterface;

public class GoogleAdwordsService implements ServiceInterface
{
	private static final Logger logger = Logger.getLogger(GoogleAdwordsService.class);

	@Override
	public String ServiceGet(String methodName, String jsonStr)
	{
		try
		{
			GoogleAdwordsServiceImpl service = new GoogleAdwordsServiceImpl();
			Class[] parameterTypes = new Class[] {String.class};
			Method method = service.getClass().getMethod(methodName, parameterTypes);
			return (String) method.invoke(service,jsonStr);
		}
		catch (SecurityException e)
		{
			logger.error(e);
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			logger.error(e);
			e.printStackTrace();
		}
		catch (NoSuchMethodException e)
		{
			logger.error(e);
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			logger.error(e);
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			logger.error(e);
			e.printStackTrace();
		}
		return "GoogleAdwordsService Error running " + methodName ;
		
	}

}
