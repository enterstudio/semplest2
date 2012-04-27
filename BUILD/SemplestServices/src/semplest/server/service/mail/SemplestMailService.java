package semplest.server.service.mail;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import semplest.server.service.ServiceInterface;


public class SemplestMailService implements ServiceInterface
{
	private static final Logger logger = Logger.getLogger(SemplestMailService.class);

	@Override
	public String ServiceGet(String methodName, String jsonStr) throws Exception
	{
		try
		{
			logger.debug("Running Semplest Mail Service " + methodName + ":" + jsonStr);
			SemplestMailServiceImpl service = new SemplestMailServiceImpl();
			Class[] parameterTypes = new Class[]
			{ String.class };
			Method method = service.getClass().getMethod(methodName, parameterTypes);
			return (String) method.invoke(service, jsonStr);
		}
		catch (Exception e)
		{
			logger.error(methodName + ":" + jsonStr + "- " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}


}
