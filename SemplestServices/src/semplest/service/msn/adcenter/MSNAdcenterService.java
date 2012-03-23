package semplest.service.msn.adcenter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import semplest.other.AdCenterCredentials;
import semplest.other.AdCenterCredentialsProduction;
import semplest.other.TimeServer;
import semplest.other.TimeServerImpl;
import semplest.server.service.ServiceInterface;

public class MSNAdcenterService implements ServiceInterface
{
	private static final Logger logger = Logger.getLogger(MSNAdcenterService.class);

	@Override
	public String ServiceGet(String methodName, String jsonStr)
	{
		try
		{
			AdCenterCredentials adCenterCredentials = new AdCenterCredentialsProduction();
			TimeServer timeServer = new TimeServerImpl();
		
			logger.debug("Running MSN Service:" + methodName + ":" + jsonStr);
			MsnCloudServiceImpl service = new MsnCloudServiceImpl(adCenterCredentials,timeServer);
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
		return "MSNAdcenterService Error running " + methodName ;
		
	}

}
