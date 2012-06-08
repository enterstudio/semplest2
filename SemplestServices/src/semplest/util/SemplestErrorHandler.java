package semplest.util;

import org.apache.log4j.Logger;

import semplest.server.service.SEMplestService;
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
}
