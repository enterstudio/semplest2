package semplest.test.systemmonitor;

import java.util.HashMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.ProtocolEnum.ServiceStatus;
import semplest.server.service.SemplestConfiguration;
import semplest.services.client.api.SemplestAdEngineServiceClient;
import semplest.test.other.InstallationSetup.ServerConfiguration;
import semplest.test.systemmonitor.MonitorData.SERVER;

public class SystemMonitoring {	
	
	//Configurations
	private final static String DevEsbUrl = "http://VMDEVJAVA1:9898/semplest";		
	private final static String TestEsbUrl = "http://VMJAVA1:9898/semplest";		
	private final static String ProdEsbUrl = "http://VMDEVJAVA1:9898/semplest";			
	
	private static HashMap<SERVER, MonitorData> monitorDataTemplate = new HashMap<SERVER, MonitorData>();		
	
	
	public void Monitor_BiddingService(){
		
	}
	
	public void Monitor_KeywordService(){
		
	}
	
	public void Monitor_SchedulerService(){
		//Both Scheduler and Database are tested in this part
		
	}
	
	public void init(){
		try{
			//Load configurations
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			Object object = new Object();
			SemplestConfiguration configDB = new SemplestConfiguration(object);
			Thread configThread = new Thread(configDB);
			configThread.start();
			synchronized (object)
			{
				object.wait();
			}
			
			//Set up Server Box data
			monitorDataTemplate.put(SERVER.DEV, new MonitorData(DevEsbUrl));
			monitorDataTemplate.put(SERVER.TEST, new MonitorData(TestEsbUrl));
			monitorDataTemplate.put(SERVER.PROD, new MonitorData(ProdEsbUrl));
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
