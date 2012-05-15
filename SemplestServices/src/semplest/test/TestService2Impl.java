package semplest.test;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;

import semplest.server.service.SemplestConfiguration;
import semplest.services.client.interfaces.TestServiceInterface;


public class TestService2Impl implements TestServiceInterface
{
	public static String eol = System.getProperty("line.separator");
	private static Gson gson = new Gson();

	@Override
	public String TestMethod(String jsonStr)
	{
		try{
			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");		
			String reportName = "SchedulerTest" + ".txt";
			String reportPath = "\\Z:\\TestReports\\" + reportName;			
			PrintStream out = new PrintStream(new FileOutputStream(reportPath));
			System.setOut(out);	
			
			long begin =System.currentTimeMillis();
			
			Date start = new Date();
			String startTime = dateFormat.format(start);
			
			doWork();
			
			Date end = new Date();
			String endTime = dateFormat.format(end);		
			
			long total =  System.currentTimeMillis() - begin;			
			System.out.println(startTime + "-" + endTime + " [" + total + "] " + jsonStr);		
			
			out.close();
			
			//interpret the jsoStr for the method
			return gson.toJson(total);
		}
		catch(Exception e){
			e.printStackTrace();
			return gson.toJson(e.getMessage());
		}
	}
	private void doWork()
	{
		try{						
			//Thread.sleep(60000);  //wait for 1 minute!
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void initializeService(String input) throws Exception {
		/*
		 * Read in the Config Data from DB into HashMap<key, Object> SemplestConfiguation.configData
		 */
		Object object = new Object();
		SemplestConfiguration configDB = new SemplestConfiguration(object);
		Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		
	}


}
