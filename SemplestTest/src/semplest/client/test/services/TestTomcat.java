package semplest.client.test.services;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.log4j.BasicConfigurator;

public class TestTomcat
{

	public static void main(String[] args)
	{
		try
		{
			BasicConfigurator.configure();

			Tomcat tomcat = new Tomcat();
			tomcat.setPort(8080);

			Context ctx = tomcat.addContext("/", new File(".").getAbsolutePath());
			Tomcat.addServlet(ctx, "hello", new AsyncServlet());
			ctx.addServletMapping("/semplest", "hello");
		
			tomcat.start();
			tomcat.getServer().await();

		}
		catch (NumberFormatException e)
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
