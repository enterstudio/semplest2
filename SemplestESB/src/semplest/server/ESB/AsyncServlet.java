package semplest.server.ESB;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Executor;

import javax.servlet.AsyncContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.UrlEncoded;

@WebServlet(urlPatterns = "/semplest", asyncSupported = true)
public class AsyncServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AsyncServlet.class);
	private Executor executor = null;
	private Long defaultTimeoutMS;

	@Override
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		executor = ESBServer.esb.getExecutor();
		defaultTimeoutMS = Long.valueOf(ESBServer.esb.getServerData().getAsynchCallDefaultTimeoutMS());
		logger.info("SERVLET init");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// parse the query String
		MultiMap<String> queryStrParams = new MultiMap<String>();
		if (request.getQueryString() != null)
		{
			UrlEncoded.decodeTo(request.getQueryString(), queryStrParams, "UTF-8");
		}
		String json = queryStrParams.getString("jsonStr");
		String service = queryStrParams.getString("service");
		String method = queryStrParams.getString("method");
		if (service == null || method == null)
		{
			logger.error("Must provide a Serive and method in query string");
			response.getOutputStream().print("ERROR: Must provide a Service and method in query string");
			return;
		}
		logger.info("AsyncServlet: Processing request: " + service + ":" + method + ":" + json + ". on thread: " + Thread.currentThread().getId()
				+ ":" + Thread.currentThread().getName() + "[" + new Date() + "]");

		// Unique Work ID used for both getting the AsynchContext and Retrieving
		// from MQ
		String uniqueID = getRandomString(8);
		request.setAttribute("uniqueID", uniqueID);
		// save the request
		request.setAttribute("service", service);
		request.setAttribute("method", method);
		request.setAttribute("json", json);

		/*
		 * Setup timeout on call
		 */
		boolean timeout = false;
		String timeoutParam = queryStrParams.getString("timeout");
		if (timeoutParam != null)
		{
			try
			{
				defaultTimeoutMS = Long.valueOf(timeoutParam);
				timeout = true;
			}
			catch (NumberFormatException e)
			{
				logger.error("Error Setting timeout.  No timeout set on call");
			}

		}
		else if (defaultTimeoutMS != null)
		{
			timeout = true;
		}
		// Start Asynch Context
		AsyncContext asyncCtx = request.startAsync();
		asyncCtx.addListener(new AsyncServletListener());
		if (timeout)
		{
			asyncCtx.setTimeout(defaultTimeoutMS.longValue());
		}
		// delegate long running process to an "async" thread and return
		executor.execute(new AsyncServiceDispatcher(asyncCtx));

		logger.info("AsyncServlet: Sending the work to AsyncServiceDispatcher: " + uniqueID + ". on thread: " + Thread.currentThread().getId() + ":"
				+ Thread.currentThread().getName() + "[" + new Date() + "]");

	}

	private synchronized static String getRandomString(int length)
	{
		UUID uuid = UUID.randomUUID();
		String myRandom = uuid.toString();
		return myRandom.substring(0, length);
	}
}
