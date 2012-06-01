package semplest.server.ESB;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import javax.jms.JMSException;
import javax.servlet.AsyncContext;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.queue.ActiveMQConnection;

public class AsyncServiceDispatcher implements Runnable
{
	private static final Logger logger = Logger.getLogger(AsyncServiceDispatcher.class);
	private static ProtocolJSON json = new ProtocolJSON();

	private AsyncContext asyncContext;

	public AsyncServiceDispatcher(AsyncContext asyncContext)
	{
		this.asyncContext = asyncContext;
	}

	public void run()
	{
		/*
		 * put the work into the Message Queue
		 */
		
		
		//save the AsynchContext for the return from the Queue
		String uniqueID = (String) asyncContext.getRequest().getAttribute("uniqueID");
		ESBServer.esb.getServletAsynchContextMap().put(uniqueID, asyncContext);

		String serviceRequested = (String) asyncContext.getRequest().getAttribute("service");
		String methodName = (String) asyncContext.getRequest().getAttribute("method");
		String jsonStr = (String) asyncContext.getRequest().getAttribute("json");
		logger.info("sending request id " + uniqueID + ":" + serviceRequested + ":" + methodName);  
		
		try
		{
			
			ActiveMQConnection cn = ESBServer.esb.getMQConnection();
			ServiceRegistrationData serviceData = getServiceInstanceToUse(serviceRequested);
			logger.debug("Add to service queue " + serviceData.getESBSendQueueName() + " rec on " + serviceData.getESBRecQueueName());
			cn.sendMessage(serviceData.getESBSendQueueName(), methodName, ProtocolJSON.createBytePacketFromString(jsonStr),uniqueID);
		}
		catch (JMSException e)
		{
			logger.error("Error running request id " + uniqueID + ":" + serviceRequested + ":" + methodName + " ERROR: " + e.getMessage()); 
			e.printStackTrace();
		}
		catch (Exception e)
		{
			//If service is not available (service not registered with ESB), send client error message
			HashMap<String, String> errorMap = new HashMap<String, String>();
			errorMap.put("errorMessage", e.getMessage());
			errorMap.put("errorType", "Exception");
			errorMap.put("errorID", uniqueID);
			String ret = json.createJSONHashmap(errorMap);

			asyncContext.getResponse().setContentType("text/html");
			try
			{
				asyncContext.getResponse().setContentLength(ESBServer.esb.getServerData().getHeaderBufferSize() + 12);
				PrintWriter out = asyncContext.getResponse().getWriter();
				out.print(ret);
				out.flush();
			}
			catch (Exception err)
			{
				logger.error(err.getMessage(), err);
			}
			asyncContext.complete();


		}
	}
	
	/*
	 * place holder for choosing the Service instance for a request.
	 */
	private ServiceRegistrationData getServiceInstanceToUse(String serviceOffered) throws Exception
	{
		// implement round robin

		ConcurrentHashMap<String, ServiceRegistrationData> serviceRegistrationMap = ESBServer.esb.getServiceRegistrationMap();
		Vector<String> servicesList = ESBServer.esb.getServiceNameList(serviceOffered);
		int currentIndex = ESBServer.esb.readCurrentServiceIndexAndIncrement(serviceOffered);
		
		if (servicesList != null && servicesList.size() > 0)
		{
			int index = currentIndex % servicesList.size();
			logger.debug("using service index:" + index + " name " + servicesList.get(index));
			return serviceRegistrationMap.get(servicesList.get(index));
		}
		else
		{
			logger.debug("No Service for " + serviceOffered + " Available");
			throw new Exception("No Service for " + serviceOffered + " Available");
		}
	}
}
