package semplest.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import semplest.server.service.ServiceInterface;

public class TestService implements ServiceInterface
{

	@Override
	public String ServiceGet(String methodName, String jsonStr)
	{
		try
		{
			TestServiceImpl service = new TestServiceImpl();
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
