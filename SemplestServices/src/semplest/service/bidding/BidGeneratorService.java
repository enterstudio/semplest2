package semplest.service.bidding;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import semplest.server.service.ServiceInterface;



public class BidGeneratorService implements ServiceInterface {

	private static final Logger logger = Logger.getLogger(BidGeneratorService.class);

	@Override
	public String ServiceGet(String methodName, String jsonStr)
	{
		try
		{
			logger.debug("Running bid generation service " + methodName + ":" + jsonStr);
			BidGeneratorServiceImpl service = new BidGeneratorServiceImpl();
			Class[] parameterTypes = new Class[] {String.class};
			Method method = service.getClass().getMethod(methodName, parameterTypes);
			return (String) method.invoke(service,jsonStr);
		}
		catch (Exception e)
		{
			logger.error(e);
			e.printStackTrace();
		}
		
		return "Bid Generation Service Error running " + methodName ;
	}

}
