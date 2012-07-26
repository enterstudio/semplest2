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
			String serverIndex = args[1];
			setup.setProductionBuild(serverIndex);
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
		
		setProps(path1, TestJdbc, null);
		setProps(path2, TestJdbc, null);
	}
	
	public void setSystemMonitor(){
		String path1 = "/var/lib/hudson/jobs/SEMplestSystemMonitor/workspace/SemplestServices/src/system.properties";
		String path2 = "/var/lib/hudson/jobs/SEMplestSystemMonitor/workspace/SemplestTests/src/system.properties";
				
		setProps(path1, ExpJdbc, null);
		setProps(path2, ExpJdbc, null);
	}
	
	public void setProductionBuild(String serverIndex){
		String path1 = "/var/lib/hudson/jobs/SEMplestProductionServiceBuild/workspace/SemplestServices/src/system.properties";
		String path2 = "/var/lib/hudson/jobs/SEMplestProductionServiceBuild/workspace/SemplestServices/dist/bin/system.properties";
		
		setProps(path1, ProdJdbc, serverIndex);
		setProps(path2, ProdJdbc, serverIndex);
	}
	
	public void setProps(String path, String jdbc, String serverIndex){
		try{
			String appendIndex = "";
			if(serverIndex != null){
				appendIndex = "_" + serverIndex;
			}
			
			Properties properties = new Properties();
			FileInputStream in = new FileInputStream(path);
			properties.load(in);
			in.close();		
			
			FileWriter out = new FileWriter(path);
			BufferedWriter writer = new BufferedWriter(out);
			
			Date now = new Date();
			String serviceName = properties.getProperty("YAJSW.servicename").trim().split("_")[0];
			
			
			writer.write("#Date: " + now.toString());
			writer.newLine();
			
			writer.append("semplest.service" + " = " + properties.getProperty("semplest.service"));
			writer.newLine();
			writer.append("YAJSW.servicename" + " = " + serviceName + appendIndex);  //update service name
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
	
	public void init(){
		
	}
	
}
