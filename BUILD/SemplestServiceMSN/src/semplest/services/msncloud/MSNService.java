package semplest.services.msncloud;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import semplest.other.AdCenterCredentials;
import semplest.other.AdCenterCredentialsProduction;
import semplest.other.TimeServer;
import semplest.other.TimeServerImpl;

public class MSNService implements ServiceInterface
{

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchMethodException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error running " + methodName ;
		
	}

}
