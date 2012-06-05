package semplest.test.other;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Properties;


public class InstallationSetup {

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
	
	private void setServicePropsDev(String serviceName){		
		try{
			String path = "C:\\" + serviceName + "\\bin\\system.properties";
			Properties properties = new Properties();
			FileInputStream in = new FileInputStream(path);
			properties.load(in);
			in.close();		
			
			properties.setProperty("jdbc.url", "jdbc:jtds:sqlserver://172.18.9.23/semplest");		
			
			FileOutputStream out = new FileOutputStream(path);	
			properties.store(out,"Service on Dev Box. Updated by InstallationSetup (Nan).");
			out.close();
		}
		catch(FileNotFoundException e){
			//file not found. probably the service is not installed.
			//do nothing
		}
		catch(IOException e){
			//do nothing
		}
	}
	
	private void setServicePropsTest(String serviceName){		
		try{
			String path = "C:\\" + serviceName + "\\bin\\system.properties";
			Properties properties = new Properties();
			FileInputStream in = new FileInputStream(path);
			properties.load(in);
			in.close();		
			
			properties.setProperty("jdbc.url", "jdbc:jtds:sqlserver://172.18.9.35/semplest");		
			
			FileOutputStream out = new FileOutputStream(path);	
			properties.store(out,"Service on Test Box. Updated by InstallationSetup (Nan).");
			out.close();
		}
		catch(FileNotFoundException e){
			//file not found. probably the service is not installed.
			//do nothing
		}
		catch(IOException e){
			//do nothing
		}
	}
	
}
