package semplest.util;

import java.util.Date;

import org.apache.log4j.Logger;

import semplest.server.service.SEMplestService;
import semplest.server.service.springjdbc.BaseDB;
import semplest.server.service.springjdbc.SemplestDB;

public class SemplestErrorHandler {	

	private static final Logger logger = Logger.getLogger(SEMplestService.class);
	
	public static void logToDatabase(Exception e){		 
		try{
			if(SEMplestService.properties == null) return;
			
			String serviceName = SEMplestService.properties.getProperty("YAJSW.servicename");
			SemplestDB.logError(e, serviceName);
		}
		catch(Exception e1){
			logger.debug("Error logging error to the databse - " + e1.getMessage());
		}
	}
	
	public static void logTest(Date timestamp, String ID, String field1, String field2, String field3){
		if(SEMplestService.properties == null) return;		
		
		String jdbc = SEMplestService.properties.getProperty("jdbc.url");
		if(!jdbc.equals("jdbc:jtds:sqlserver://172.18.9.23/semplest_test")) return;
		
		//only do it when we're on test mode
		TestDB db = new TestDB();
		db.logTest(timestamp, ID, field1, field2, field3);
	}
	
	private static class TestDB extends BaseDB {
		public void logTest(Date timestamp, String ID, String field1, String field2, String field3){					
			try
			{
				String sql = "INSERT TestData(Timestamp,Identify,field1,field2,field3) " +
						"VALUES(?,?,?,?,?)";
				
				jdbcTemplate.update(sql, new Object[]
						{timestamp, ID, field1, field2, field3});
			}
			catch (Exception e1)
			{
				//do nothing
			}
		}
	}
}
