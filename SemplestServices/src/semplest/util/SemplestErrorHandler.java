package semplest.util;

import semplest.server.service.SEMplestService;
import semplest.server.service.springjdbc.SemplestDB;

public class SemplestErrorHandler {
	private String serviceName;
	
	public SemplestErrorHandler(){
		serviceName = SEMplestService.properties.getProperty("YAJSW.servicename");
	}

	public void logToDatabase(Exception e){		 
		SemplestDB db = new SemplestDB();
		db.logError(e, serviceName);
	}
}
