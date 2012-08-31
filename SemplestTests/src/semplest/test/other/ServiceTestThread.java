package semplest.test.other;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import semplest.services.client.test.TestService2Client;

public class ServiceTestThread implements Runnable
{

	private int sleep_time;
	private String reportPath;
	private FileWriter writer;
	boolean noError = true;

	private static String testUrl = "http://172.18.9.26:9898/semplest";

	public ServiceTestThread(int sleep_time)
	{
		super();
		this.sleep_time = sleep_time;
	}

	@Override
	public void run()
	{
		try
		{

			String reportName = "Test_Stress_ESB_" + System.currentTimeMillis();

			reportPath = "Z:\\TestReports\\ScalabilityTest\\" + reportName + ".csv";
			writer = new FileWriter(reportPath);
			// writer.append("Computation");
			// writer.append(',');
			writer.append("Latency");
			writer.append('\n');
			writer.flush();

			while (true)
			{
				// while(noError){
				try
				{
					Date now = new Date();
					System.out.println("TEST SERVICE >>> " + now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds());

					TestService2Client ts = new TestService2Client(testUrl);

					long start = System.currentTimeMillis();
					String ret = ts.TestMethod("nan");
					long time = System.currentTimeMillis() - start;
					System.out.println("--- " + ret + " >>> " + time);

					// String[] ret1 = ret.split("=");
					// writer.append(ret1[1]);
					// writer.append(',');
					writer.append(String.valueOf(time));
					writer.append('\n');

					writer.flush();

					Thread.sleep(sleep_time);
				}
				catch (Exception e)
				{
					e.printStackTrace();
					try
					{
						writer.append("ERROR:");
						writer.append(',');
						Date now = new Date();
						writer.append(now.toString());
						writer.append(',');
						writer.append(e.getMessage());
						writer.append(',');
						StackTraceElement[] ste = e.getStackTrace();
						for (StackTraceElement s : ste)
						{
							writer.append(s.getClassName());
							writer.append(':');
							writer.append(s.getMethodName());
							writer.append(':');
							writer.append(String.valueOf(s.getLineNumber()));
							writer.append(',');
						}
						writer.append('\n');
						writer.flush();
						noError = false;
					}
					catch (IOException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				writer.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
