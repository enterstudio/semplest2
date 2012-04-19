package semplest.service.scheduler;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import semplest.server.service.ServiceInterface;

public class SemplestSchedulerService  implements ServiceInterface
{
	private static final Logger logger = Logger.getLogger(SemplestSchedulerService.class);

	@Override
	public String ServiceGet(String methodName, String jsonStr) throws Exception
	{
		try
		{
			logger.debug("Running Google Service " + methodName + ":" + jsonStr);
			SemplestSchedulerServiceImpl service = new SemplestSchedulerServiceImpl();
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
