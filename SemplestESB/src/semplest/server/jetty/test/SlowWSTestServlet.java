package semplest.server.jetty.test;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

import org.apache.log4j.Logger;

@WebServlet(name = "myServlet", urlPatterns ={ "/slowprocess" }, asyncSupported = true)

public class SlowWSTestServlet extends HttpServlet
{
	private static final Logger logger = Logger.getLogger(SlowWSTestServlet.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		AsyncContext aCtx = request.startAsync(request, response);
		ServletContext appScope = request.getServletContext();
		((Queue<AsyncContext>) appScope.getAttribute("slowWebServiceJobQueue")).add(aCtx);
	}
	@WebListener
	public class SlowWebService implements ServletContextListener
	{

		public void contextInitialized(ServletContextEvent sce)
		{
			Queue<AsyncContext> jobQueue = new ConcurrentLinkedQueue<AsyncContext>();
			sce.getServletContext().setAttribute("slowWebServiceJobQueue", jobQueue);
			// pool size matching Web services capacity
			Executor executor = Executors.newFixedThreadPool(10);
			while (true)
			{
				if (!jobQueue.isEmpty())
				{
					final AsyncContext aCtx = jobQueue.poll();
					executor.execute(new Runnable()
					{
						public void run()
						{
							ServletRequest request = aCtx.getRequest();
							// get parameteres
							// invoke a Web service endpoint
							// set results
							String result = "hello";
							try
							{
								aCtx.getResponse().getWriter().print(result);
							}
							catch (IOException e)
							{
								logger.error("Problem", e);
							}
						}
					});
				}
			}
		}

		public void contextDestroyed(ServletContextEvent sce)
		{
		}
	}

}
