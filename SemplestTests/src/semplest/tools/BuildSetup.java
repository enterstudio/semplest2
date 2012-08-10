package semplest.tools;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

public class BuildSetup {
	
	//Configurations
	private final static String DevJdbc = "jdbc:jtds:sqlserver://172.18.9.23/semplest";
	private final static String TestJdbc = "jdbc:jtds:sqlserver://172.18.9.35/semplestTest";
	private final static String ExpJdbc = "jdbc:jtds:sqlserver://172.18.9.23/semplest_testing";
	private final static String ProdJdbc = "jdbc:jtds:sqlserver://10.118.218.132/semplest";		
		
	public static void main(String[] args){		
		if(args == null){
			System.out.println("Please specify arguments.");
			return;
		}		
		if(args.length < 2){
			System.out.println("Not enough arguments specified.");
			return;
		}
		
		BuildSetup setup = new BuildSetup();	
		
		String function = args[0];
		if(function.equalsIgnoreCase("build")){
			String semplestService = args[1];
			setup.setServiceBuild(semplestService);
		}		
		else if(function.equalsIgnoreCase("tool")){
			String toolName = args[1];
			if(toolName.equalsIgnoreCase("systemmonitor")){
				setup.setSystemMonitor();
			}
			else if(toolName.equalsIgnoreCase("systemtest")){
				setup.setSystemTest();
			}
			else{
				System.out.println("The tool you specified is not available.");
			}
		}
		else{
			System.out.println("The first argument is not valid. Please use 'TOOL' or 'BUILD'.");
			return;
		}
	}
	
	public void setSystemTest(){
		String path1 = "/var/lib/hudson/jobs/SEMplestSystemTest/workspace/SemplestServices/src/system.properties";
		String path2 = "/var/lib/hudson/jobs/SEMplestSystemTest/workspace/SemplestTests/src/system.properties";
		
		setPropsJdbc(path1, TestJdbc);
		setPropsJdbc(path2, TestJdbc);
	}
	
	public void setSystemMonitor(){
		String path1 = "/var/lib/hudson/jobs/SEMplestSystemMonitor/workspace/SemplestServices/src/system.properties";
		String path2 = "/var/lib/hudson/jobs/SEMplestSystemMonitor/workspace/SemplestTests/src/system.properties";
				
		setPropsJdbc(path1, ExpJdbc);
		setPropsJdbc(path2, ExpJdbc);
	}
	
	public void setServiceBuild(String semplestService){
		
		//Set service offered and service name in the properties file
		String propertiesFilePath = null;
		//String path2 = "/var/lib/hudson/jobs/SEMplestProductionServiceBuild/workspace/SemplestServices/dist/bin/system.properties";
		String service = null;
		String serviceName = null;		
		
		if(semplestService.equalsIgnoreCase("adengine")){
			propertiesFilePath = "/var/lib/hudson/jobs/ServiceBuild_Adengine/workspace/SemplestServices/src/system.properties";
			service = "semplest.server.service.adengine.SemplestAdengineService";
			serviceName = "SemplestAdengineService";			
		}
		if(semplestService.equalsIgnoreCase("bidding")){
			propertiesFilePath = "/var/lib/hudson/jobs/ServiceBuild_BidGenerator/workspace/SemplestServices/src/system.properties";
			service = "semplest.service.bidding.BidGeneratorService";
			serviceName = "SemplestBidGeneratorService";			
		}
		if(semplestService.equalsIgnoreCase("keyword")){
			propertiesFilePath = "/var/lib/hudson/jobs/ServiceBuild_KeywordGenerator/workspace/SemplestServices/src/system.properties";
			service = "semplest.service.keywords.lda.KeywordGeneratorService";
			serviceName = "SemplestKeywordGeneratorService";			
		}
		if(semplestService.equalsIgnoreCase("mail")){
			propertiesFilePath = "/var/lib/hudson/jobs/ServiceBuild_Mail/workspace/SemplestServices/src/system.properties";
			service = "semplest.server.service.mail.SemplestMailService";
			serviceName = "SemplestMailService";			
		}
		if(semplestService.equalsIgnoreCase("scheduler")){
			propertiesFilePath = "/var/lib/hudson/jobs/ServiceBuild_Scheduler/workspace/SemplestServices/src/system.properties";
			service = "semplest.service.scheduler.SemplestSchedulerService";
			serviceName = "SemplestSchedulerService";			
		}		
		
		setPropsService(propertiesFilePath, service, serviceName);
		//setPropsService(path2, service, serviceName);		
		
		//Set LineHandler for Chase Orbital
		String pathLineHandler1 = "/var/lib/hudson/jobs/SEMplestProductionServiceBuild/workspace/SemplestServices/dist/config/linehandler.properties";
		String pathLineHandler2 = "/var/lib/hudson/jobs/SEMplestProductionServiceBuild/workspace/SemplestServices/config/linehandler.properties";
		//setChaseOrbitalLineHandler(pathLineHandler1);
		//setChaseOrbitalLineHandler(pathLineHandler2);
	}
	
	public void setPropsJdbc(String path, String jdbc){
		try{			
			Properties properties = new Properties();
			FileInputStream in = new FileInputStream(path);
			properties.load(in);
			in.close();		
			
			FileWriter out = new FileWriter(path);
			BufferedWriter writer = new BufferedWriter(out);
			
			Date now = new Date();			
			
			writer.write("#Date: " + now.toString());
			writer.newLine();
			
			writer.append("semplest.service" + " = " + properties.getProperty("semplest.service"));
			writer.newLine();
			writer.append("YAJSW.servicename" + " = " + properties.getProperty("YAJSW.servicename"));
			writer.newLine();
			writer.append("jdbc.driverClassName" + " = " + properties.getProperty("jdbc.driverClassName"));
			writer.newLine();
			writer.append("jdbc.url" + " = " + jdbc);  //update the JDBC link
			writer.newLine();
			writer.append("jdbc.username" + " = " + properties.getProperty("jdbc.username"));
			writer.newLine();
			writer.append("jdbc.password" + " = " + properties.getProperty("jdbc.password"));
			writer.newLine();
			
			writer.close();
		}
		catch(FileNotFoundException e){
			//file not found. probably the service is not installed.
			//do nothing
		}
		catch(IOException e){
			//do nothing
		}
	}
	
	public void setPropsService(String path, String service, String serviceName){
		try{			
			Properties properties = new Properties();
			FileInputStream in = new FileInputStream(path);
			properties.load(in);
			in.close();		
			
			properties.setProperty("semplest.service", service);
			properties.setProperty("YAJSW.servicename", serviceName);
			
			FileOutputStream out = new FileOutputStream(path);
			String comment = "Updated by BuildSetup. " + new Date();
			properties.store(out, comment);
		}
		catch(Exception e){
			//do nothing
		}
	}
	
	public void setChaseOrbitalLineHandler(String path){
		try{
			//read host and failover address from DB
			HashMap<String,String> chaseOrbitalConf = GeneralDB.getChaseOrbitalConf();			
			
			//write the configuration to the properties file
			Properties properties = new Properties();
			FileInputStream in = new FileInputStream(path);
			properties.load(in);
			in.close();		
			
			for(String confName : chaseOrbitalConf.keySet()){
				properties.setProperty(confName, chaseOrbitalConf.get(confName));
			}
			
			FileOutputStream out = new FileOutputStream(path);
			String comment = "Updated by BuildSetup. " + new Date();
			properties.store(out, comment);
		}
		catch(Exception e){
			//do nothing
		}
	}
	
	public void init(){
		
	}
	
}
