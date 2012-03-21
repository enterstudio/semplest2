package semplest.client.test.services;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.AsyncContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * User: Monsty Date: Jul 23, 2010 Time: 9:43:25 PM An introduction to Servlet
 * 3.0 and Java 6 (TC JUG) (c) Software Engineering Solutions, Inc.
 */
@WebServlet(urlPatterns = "/AsyncServlet", asyncSupported = true)
public class AsyncServlet extends HttpServlet
{
	private static final Logger logger = Logger.getLogger(AsyncServlet.class);

	private Executor executor = new ThreadPoolExecutor(10, 10, 50000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(100));
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		logger.info("SERVLET init Context Listener > Initialized");
		// 2. Creation of a global async Executor
		//Executor executor = new ThreadPoolExecutor(10, 10, 50000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(100));
		//sce.getServletContext().setAttribute("executor", executor);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
		
		logger.info("AsyncServlet: Processing request: " + request.getParameter("id") + ". on thread: " + Thread.currentThread().getId() + ":"
				+ Thread.currentThread().getName() + "[" + new Date() + "]");

		request.setAttribute("receivedAt", new Date());

		boolean dispatch = false;
		String dispatchParam = request.getParameter("dispatch");
		if ("true".equalsIgnoreCase(dispatchParam))
			dispatch = true;

		boolean timeout = false;
		String timeoutParam = request.getParameter("timeout");
		if ("true".equalsIgnoreCase(timeoutParam))
			timeout = true;

		AsyncContext asyncCtx = request.startAsync();
		asyncCtx.addListener(new MyAsyncListener());
		if (timeout)
		{
			asyncCtx.setTimeout(1000);
		}

		//Executor executor = (Executor) request.getServletContext().getAttribute("executor");
		// delegate long running process to an "async" thread
		executor.execute(new AsyncRequestProcessor(asyncCtx, dispatch));

		logger.info("AsyncServlet: Returning after request: " + request.getParameter("id") + ". on thread: " + Thread.currentThread().getId() + ":"
				+ Thread.currentThread().getName() + "[" + new Date() + "]");

		// Watch out for concurrency issues at this point
		// between the "main" thread and the "async" thread
		// main thread returns now -
		// - returning from service() does not commit the response
		// - so client still waits patiently
	}
}
