package semplest.system.monitor;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.services.client.api.KeywordLDAServiceClient;
import semplest.services.client.api.SemplestAdEngineServiceClient;
import semplest.services.client.api.SemplestBiddingServiceClient;
import semplest.services.client.api.SemplestMailServiceClient;
import semplest.services.client.api.SemplestSchedulerServiceClient;
import semplest.system.monitor.MonitorObject.SERVICE;

public class SystemMonitor {			
	
	public static void main(String[] args){		
		
		setPropertiesFile();
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		//Configure the Services
		SemplestAdEngineServiceClient adEngineService = new SemplestAdEngineServiceClient(null);
		SemplestBiddingServiceClient biddingService = new SemplestBiddingServiceClient(null, null);
		KeywordLDAServiceClient keywordService = new KeywordLDAServiceClient(null);
		SemplestMailServiceClient mailService = new SemplestMailServiceClient(null);
		SemplestSchedulerServiceClient schedulerService = new SemplestSchedulerServiceClient(null);
		
		//Start the Monitors
		executor.execute(new MonitorThread(SERVICE.AdEngine, adEngineService));
		executor.execute(new MonitorThread(SERVICE.Bidding, biddingService));
		executor.execute(new MonitorThread(SERVICE.Keyword, keywordService));
		executor.execute(new MonitorThread(SERVICE.Mail, mailService));
		executor.execute(new MonitorThread(SERVICE.Scheduler, schedulerService));
		
		executor.shutdown();
	}		
	
	private static void setPropertiesFile(){
		try{
			final String PROPSFILE = "bin/system.properties";
			String jdbc = "jdbc:jtds:sqlserver://172.18.9.23/semplest_testing";		
			
			Properties properties = new Properties();
			FileInputStream in = new FileInputStream(PROPSFILE);
			properties.load(in);
			in.close();				
			FileWriter out = new FileWriter(PROPSFILE);
			BufferedWriter writer = new BufferedWriter(out);			
			
			writer.append("semplest.service" + " = " + properties.getProperty("semplest.service")); writer.newLine();		
			writer.append("YAJSW.servicename" + " = " + properties.getProperty("YAJSW.servicename")); writer.newLine();
			writer.append("jdbc.driverClassName" + " = " + properties.getProperty("jdbc.driverClassName")); writer.newLine();
			writer.append("jdbc.url" + " = " + jdbc); writer.newLine();
			writer.append("jdbc.username" + " = " + properties.getProperty("jdbc.username")); writer.newLine();
			writer.append("jdbc.password" + " = " + properties.getProperty("jdbc.password")); writer.newLine();
			
			writer.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}				
	}
}
