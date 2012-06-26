package semplest.server.service.adengine;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import semplest.server.service.ServiceInterface;
import semplest.service.scheduler.SemplestSchedulerServiceImpl;

public class SemplestAdengineService implements ServiceInterface
{
	private static final Logger logger = Logger.getLogger(SemplestAdengineService.class);

	@Override
	public String ServiceGet(String methodName, String jsonStr) throws Exception
	{
		try
		{
			logger.debug("Running  SemplestAdengineService Service " + methodName + ":" + jsonStr);
			SemplestAdengineServiceImpl service = new SemplestAdengineServiceImpl();
			Class[] parameterTypes = new Class[]{ String.class };
			Method method = service.getClass().getMethod(methodName, parameterTypes);
			return (String) method.invoke(service, jsonStr);
		}
		catch (Exception e)
		{
			logger.error(methodName + ":" + jsonStr + "- " + e.getMessage(), e);
			throw e;
		}
	}

}