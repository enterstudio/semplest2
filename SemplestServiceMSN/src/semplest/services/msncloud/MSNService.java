package semplest.services.msncloud;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import semplest.other.AdCenterCredentials;
import semplest.other.AdCenterCredentialsProduction;
import semplest.other.TimeServer;
import semplest.other.TimeServerImpl;

public class MSNService implements ServiceInterface
{
	private static final Logger logger = Logger.getLogger(MSNService.class);
	
	@Override
	public String ServiceGet(String methodName, String jsonStr)
	{
		try
		{
			AdCenterCredentials adCenterCredentials = new AdCenterCredentialsProduction();
			TimeServer timeServer = new TimeServerImpl();
		
			MsnCloudServiceImpl service = new MsnCloudServiceImpl(adCenterCredentials,timeServer);
			Class[] parameterTypes = new Class[] {String.class};
			Method method = service.getClass().getMethod(methodName, parameterTypes);
			return (String) method.invoke(service,jsonStr);
		}
		catch (SecurityException e)
		{
			logger.error("Problem", e);
		}
		catch (IllegalArgumentException e)
		{
			logger.error("Problem", e);
		}
		catch (NoSuchMethodException e)
		{
			logger.error("Problem", e);
		}
		catch (IllegalAccessException e)
		{
			logger.error("Problem", e);
		}
		catch (InvocationTargetException e)
		{
			logger.error("Problem", e);
		}
		return "Error running " + methodName ;
		
	}

}
