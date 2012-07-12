package semplest.test;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.microsoft.adapi.AdApiFaultDetail;
import com.microsoft.adcenter.api.customermanagement.GetAccountsInfoRequest;
import com.microsoft.adcenter.api.customermanagement.GetAccountsInfoResponse;
import com.microsoft.adcenter.api.customermanagement.ICustomerManagementService;
import com.microsoft.adcenter.api.customermanagement.Entities.AccountInfo;
import com.microsoft.adcenter.api.customermanagement.Exception.ApiFault;
import com.microsoft.adcenter.v8.Campaign;

import semplest.server.service.SemplestConfiguration;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;

public class ReportActiveCampaigns {
	
	MsnCloudServiceImpl msn;
	PrintStream pr;
	public static void main(String[] args) throws Exception{
		ReportActiveCampaigns rep = new ReportActiveCampaigns();
		rep.getAccountsAndActiveCampaigns();
		
	}
	public ReportActiveCampaigns() throws Exception{
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
		Object object = new Object();
		SemplestConfiguration configDB = new SemplestConfiguration(object);
		Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
	
		BasicConfigurator.configure();
		msn = new MsnCloudServiceImpl();
		
		pr = new PrintStream(new FileOutputStream("/semplest/data/msnActiveCampaignsReport2.txt"));
		
	}
	public void getAccountsAndActiveCampaigns() throws AdApiFaultDetail, ApiFault, RemoteException{
		ICustomerManagementService customerManagementService = msn.getCustomerManagementService();
		HashMap<String, Double> accountIDs = new HashMap<String, Double>();
		GetAccountsInfoRequest req = new GetAccountsInfoRequest();
		GetAccountsInfoResponse signupCustomerResponse = customerManagementService.getAccountsInfo(req);
		AccountInfo[] acInf = signupCustomerResponse.getAccountsInfo();
		for (int i = 0; i < acInf.length; i++)
		{
			Long accountID;
			if(acInf[i].getAccountLifeCycleStatus().getValue().equalsIgnoreCase("active")){
				accountID = acInf[i].getId();
				
				Campaign[] campaigns =msn.getCampaignsByAccountId(accountID);
				ArrayList<Campaign> activeCampaigns = new ArrayList<Campaign>();
				for(Campaign camp : campaigns){
					if(camp.getStatus().getValue().equalsIgnoreCase("active")){
						activeCampaigns.add(camp);
					}
				}
				if(!activeCampaigns.isEmpty()){
					pr.println("Account Name: " + acInf[i].getName()+" <-> Number : "+acInf[i].getNumber()+" <-> ID: "+acInf[i].getId());
					System.out.println("Account Name: " + acInf[i].getName()+" <-> Number : "+acInf[i].getNumber()+" <-> ID: "+acInf[i].getId());
					for(Campaign camp : activeCampaigns){
						if(camp.getStatus().getValue().equalsIgnoreCase("active")){
							pr.print("\tActive Campaign Name:" +camp.getName()+ "(id:"+ camp.getId() +")\n");
							System.out.print("\tActive Campaign Name:" +camp.getName()+ "(id:"+ camp.getId() +")\n");
						}
					}
				}
			}
		}

	}
		
		
		
}

