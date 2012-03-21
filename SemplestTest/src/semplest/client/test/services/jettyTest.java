package semplest.client.test.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import com.sun.jersey.spi.container.servlet.ServletContainer;


public class jettyTest
{

	

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			BasicConfigurator.configure();
			Server server = new Server(9777);		
			ServletHolder sh = new ServletHolder(ServletContainer.class);		
			sh.setInitParameter("com.sun.jersey.config.property.resourceConfigClass","com.sun.jersey.api.core.PackagesResourceConfig");		
			//sh.setInitParameter("com.sun.jersey.config.property.packages","semplest.server.jetty.test");
			// un-comment these to enable tracing of requests and responses
			//		sh.setInitParameter("com.sun.jersey.config.feature.Debug", "true");
			//		sh.setInitParameter("com.sun.jersey.config.feature.Trace", "true");//		
			//		sh.setInitParameter("com.sun.jersey.spi.container.ContainerRequestFilters", "com.sun.jersey.api.container.filter.LoggingFilter");
			//		sh.setInitParameter("com.sun.jersey.spi.container.ContainerResponseFilters", "com.sun.jersey.api.container.filter.LoggingFilter");		
			ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);		
			context.setContextPath("/");		
			context.addServlet(sh, "/*");
			context.addServlet("semplest.client.test.services.AsyncServlet", "/*");
			server.setHandler(context);		
			QueuedThreadPool qtp = new QueuedThreadPool(10);		
			qtp.setName("ApiServe");		
			server.setThreadPool(qtp);        		
			server.start();
		}
		catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
