package semplest.test.other;

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


public class InstallationSetup {

	private HashMap<String, String> properties = new HashMap<String, String>();
	
	public static void main(String args[]){		
		
		InstallationSetup is = new InstallationSetup();
		try {
			InetAddress ownIP = InetAddress.getLocalHost();
			String hostName = ownIP.getHostName();			
			
			if(hostName.equals("VMDEVJAVA1")){
				//DEV Box ESB
				is.EsbDev();
			}
			
			if(hostName.equals("VMDEVJAVA2")){
				//DEV Box Services
				is.ServiceDev();
			}
			
			if(hostName.equals("VMJAVA1")){
				//TEST Box ESB
				is.EsbTest();
			}
			
			if(hostName.equals("VMJAVA2")){
				//TEST Box Services
				is.ServiceTest();
			}			
			
			if(hostName.equals("VMDEVJAVA3")){
				//DEV Box Keyword Service
				is.KeywordDev();
			}
			
			if(hostName.equals("VMJAVA3")){
				//TEST Box Keyword Service
				is.KeywordTest();
			}			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void EsbDev() throws Exception{
		String esbProps = "C:\\SEMplestESB\\properties\\system.properties";
		
		Properties properties = new Properties();
		FileInputStream in = new FileInputStream(esbProps);
		properties.load(in);
		in.close();		
		
		properties.setProperty("BrokerIP", "VMDEVJAVA1");		
		
		FileOutputStream out = new FileOutputStream(esbProps);	
		properties.store(out,"ESB on Dev Box. Updated by InstallationSetup (Nan).");
		out.close();
	}
	
	public void EsbTest() throws Exception{
		String esbProps = "C:\\SEMplestESB\\properties\\system.properties";
		
		Properties properties = new Properties();
		FileInputStream in = new FileInputStream(esbProps);
		properties.load(in);
		in.close();		
		
		properties.setProperty("BrokerIP", "VMJAVA1");		
		
		FileOutputStream out = new FileOutputStream(esbProps);	
		properties.store(out,"ESB on Test Box. Updated by InstallationSetup (Nan).");
		out.close();
	}
	
	public void ServiceDev(){
		String service;
		
		service = "SemplestAdengineService";
		setServicePropsDev(service);
		
		service = "SemplestBidGeneratorService";
		setServicePropsDev(service);
		
		service = "SemplestChaseOrbitalGatewayService";
		setServicePropsDev(service);
		
		service = "SemplestMailService";
		setServicePropsDev(service);
		
		service = "SemplestSchedulerService";
		setServicePropsDev(service);
	}
	
	public void ServiceTest(){
		String service;
		
		service = "SemplestAdengineService";
		setServicePropsTest(service);
		
		service = "SemplestBidGeneratorService";
		setServicePropsTest(service);
		
		service = "SemplestChaseOrbitalGatewayService";
		setServicePropsTest(service);
		
		service = "SemplestMailService";
		setServicePropsTest(service);
		
		service = "SemplestSchedulerService";
		setServicePropsTest(service);
	}
	
	public void KeywordDev(){
		String service = "SemplestKeywordGeneratorService";
		setServicePropsDev(service);
	}
	
	public void KeywordTest(){
		String service = "SemplestKeywordGeneratorService";
		setServicePropsTest(service);
	}
	
	public void setServicePropsDev(String serviceName){		
		try{
			String path = "C:\\" + serviceName + "\\bin\\system.properties";
			Properties properties = new Properties();
			FileInputStream in = new FileInputStream(path);
			properties.load(in);
			in.close();		
			
			String jdbc = "jdbc:jtds:sqlserver://172.18.9.23/semplest";
			String comment = "Service on Dev Box. Updated by InstallationSetup (Nan).";
			writeProps(path, properties, jdbc, comment);
		}
		catch(FileNotFoundException e){
			//file not found. probably the service is not installed.
			//do nothing
		}
		catch(IOException e){
			//do nothing
		}
	}
	
	public void setServicePropsTest(String serviceName){		
		try{
			String path = "C:\\" + serviceName + "\\bin\\system.properties";
			Properties properties = new Properties();
			FileInputStream in = new FileInputStream(path);
			properties.load(in);
			in.close();		
			
			String jdbc = "jdbc:jtds:sqlserver://172.18.9.35/semplest";
			String comment = "Service on Test Box. Updated by InstallationSetup (Nan).";
			writeProps(path, properties, jdbc, comment);
		}
		catch(FileNotFoundException e){
			//file not found. probably the service is not installed.
			//do nothing
		}
		catch(IOException e){
			//do nothing
		}
	}	
	
	public void writeProps(String filePath, Properties props, String jdbc, String comment){
		
		try{
			
			FileWriter out = new FileWriter(filePath);
			BufferedWriter writer = new BufferedWriter(out);
			
			Date now = new Date();
			
			writer.write("#" + comment);
			writer.newLine();
			
			writer.write("#Date: " + now.toString());
			writer.newLine();
			
			writer.append("semplest.service" + " = " + props.getProperty("semplest.service"));
			writer.newLine();
			writer.append("YAJSW.servicename" + " = " + props.getProperty("YAJSW.servicename"));
			writer.newLine();
			writer.append("jdbc.driverClassName" + " = " + props.getProperty("jdbc.driverClassName"));
			writer.newLine();
			writer.append("jdbc.url" + " = " + jdbc);  //update the JDBC link
			writer.newLine();
			writer.append("jdbc.username" + " = " + props.getProperty("jdbc.username"));
			writer.newLine();
			writer.append("jdbc.password" + " = " + props.getProperty("jdbc.password"));
			writer.newLine();
			
			writer.close();
		
		}
		catch(Exception e){
			//do nothing
		}
		
	}
	
}
