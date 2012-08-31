package semplest.test.other;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.springjdbc.SemplestDB;

public class OtherTests
{

	public static void main(String[] args)
	{
		try
		{
			// Load configurations
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			Object object = new Object();
			SemplestConfiguration configDB = new SemplestConfiguration(object);
			Thread configThread = new Thread(configDB);
			configThread.start();
			synchronized (object)
			{
				object.wait();
			}

			OtherTests t = new OtherTests();
			t.test1();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test1() throws Exception
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, -2);
		Date startDate = cal.getTime();
		Date endDate = new Date(); // df.parse("07/21/2012");

		Integer promotionID = 70;

		List<ReportObject> reportObjListYesterday = SemplestDB.getReportData(promotionID, AdEngine.Google, startDate, null);
		System.out.println("Number of entries: " + reportObjListYesterday.size());

	}
}
