package semplest.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.microsoft.adcenter.api.customermanagement.Entities.Account;

import semplest.server.service.SemplestConfiguration;
import semplest.server.service.springjdbc.BaseDB;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;

public class CleanUpMsnAccounts extends BaseDB{	
	
	private final static SERVER cleanUpRange = SERVER.DEV; 
	private static boolean useReportData = true;	
	private final static String activeAccountsList = "Z:\\nan\\msnActiveAccounts.txt";
	private final static String whiteList = "Z:\\nan\\msnWhiteListedAccounts.txt";
	private final static String cleanUpReport = "Z:\\nan\\msnCleanUpReport.txt";
	
	private MsnCloudServiceImpl msn;	
	private static enum SERVER {DEV, TEST};	
	
	public static void main(String[] args){
		try{
			CleanUpMsnAccounts cleanUp = new CleanUpMsnAccounts();			
			cleanUp.init();
			
			//clean up the accounts on MSN
			ArrayList<Long> toDeleteAccounts = cleanUp.getToDeleteAccounts();
			ArrayList<Long> deletedAccounts = cleanUp.deleteAccountsFromMsn(toDeleteAccounts);			
			List<Long> stillActiveAccounts = cleanUp.getActiveAccounts();	//check with the still-active accounts after the clean up
						
			//clean up the promotions in DB
			ArrayList<Integer> toDeletePromotionIDs = cleanUp.getToDeletePromotions(toDeleteAccounts);
			cleanUp.deletePromotionsFromDB(toDeleteAccounts, toDeletePromotionIDs);
			
			cleanUp.writeToReport(deletedAccounts, stillActiveAccounts, toDeletePromotionIDs);
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	private ArrayList<Long> deleteAccountsFromMsn(ArrayList<Long> toDeleteAccounts) throws Exception{	
		ArrayList<Long> deletedAccounts = new ArrayList<Long>();		
		
		System.out.println("Deleting Active Accounts from MSN...");
		int i = 0;
		for(Long accountId : toDeleteAccounts){
			try{
				System.out.println("# " + i); i++;
				Account account = msn.getAccountById(accountId);
				if(account.getAccountLifeCycleStatus().getValue().equalsIgnoreCase("active")){					
					boolean ret = msn.deleteAccountById(account);
					if(ret){
						System.out.println(" - deleted account " + accountId);
						deletedAccounts.add(accountId);
					}					
				}				
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}		
		System.out.println("# deleted accounts - " + deletedAccounts.size());		
		
		return deletedAccounts; 
	}
	
	private void deletePromotionsFromDB(ArrayList<Long> toDeleteAccounts, ArrayList<Integer> promotionIDs) throws Exception{		
		System.out.println("Deleting Active Promotions from Database...");
		String sql;
		for(Integer promotionId : promotionIDs){
			sql = "UPDATE PromotionAdengineStatus SET PromotionStatusFK = 5 WHERE PromotionFK = ? AND AdvertisingEngineFK = 1";
			jdbcTemplate.update(sql, new Object[]
					{promotionId});				
			
			sql = "UPDATE Schedule SET IsEnabled = 0, IsInactive = 1 WHERE PromotionFK = ?";
			jdbcTemplate.update(sql, new Object[]
					{promotionId});	
		}
		for(Long accountId : toDeleteAccounts){
			sql = "SELECT aep.AdvertisingEngineCampaignPK FROM AdvertisingEnginePromotion aep WHERE aep.AdvertisingEngineAccountFK = ?";
			List<Integer> list = jdbcTemplate.queryForList(sql, new Object[] 
					{accountId}, Integer.class);
			for(Integer campaignId : list){				
				sql = "DELETE FROM AdvertisingEnginePromotion where AdvertisingEngineCampaignPK = ?";
				jdbcTemplate.update(sql, new Object[]
						{campaignId});				
			}	
			
			sql = "DELETE FROM AdvertisingEngineAccount WHERE AdvertisingEngineAccountPK = ?";
			jdbcTemplate.update(sql, new Object[]
					{accountId});
		}		
		System.out.println("Done");
	}
	
	private ArrayList<Integer> getToDeletePromotions(ArrayList<Long> accounts) throws Exception{
		String sql;
		ArrayList<Integer> promotionIDs = new ArrayList<Integer>();
		
		System.out.println("Promotions need to be deleted:");
		
		for(Long accountId : accounts){
			sql = "SELECT aep.PromotionFK FROM AdvertisingEnginePromotion aep WHERE AdvertisingEngineAccountFK = ?";
			List<Integer> list = jdbcTemplate.queryForList(sql, new Object[] 
					{accountId}, Integer.class);
			for(Integer Id : list){				
				promotionIDs.add(Id);
				System.out.println(Id);				
			}
		}	
		System.out.println("# promotions to be deleted - " + promotionIDs.size());
		
		return promotionIDs;
	}
	
	private ArrayList<Long> getToDeleteAccounts() throws Exception{
		List<Long> activeAccounts = getActiveAccounts();
		ArrayList<Long> whiteListAccounts = getWhiteListAccounts();
		
		ArrayList<Long> toDeleteAccounts = new ArrayList<Long>();
		toDeleteAccounts.addAll(activeAccounts);
		toDeleteAccounts.removeAll(whiteListAccounts);
		
		System.out.println("Accounts to be deleted:");
		for(Long Id : toDeleteAccounts){
			System.out.println(Id);
		}
		System.out.println("# accounts to be deleted - " + toDeleteAccounts.size());
		
		return toDeleteAccounts;
	}
	
	public List<Long> getActiveAccounts() throws Exception{
		List<Long> activeAccounts = new ArrayList<Long>();
		
		if(useReportData){
			activeAccounts = getActiveMsnAccountsFromReport();
		}
		else{
			activeAccounts = msn.getActiveAccountIDs();
		}
		
		System.out.println("Active Accounts on MSN:");
		for(Long Id : activeAccounts){
			System.out.println(Id);
		}
		System.out.println("# active accounts on MSN - " + activeAccounts.size());
		
		return activeAccounts;
	}
	
	private ArrayList<Long> getActiveMsnAccountsFromReport() throws Exception{
		
		String filePath = activeAccountsList;
		ArrayList<Long> activeAccounts = new ArrayList<Long>();	
		BufferedReader in = new BufferedReader(new FileReader(filePath));			
		
	    String str;
	    while ((str = in.readLine()) != null) {
	    	String [] lineContent = str.split(":");
	    	if(lineContent[0].trim().equals("Account Name")){
	    		//This line contains an accountId
	    		Long accountId = Long.valueOf(lineContent[3].trim());
	    		activeAccounts.add(accountId);
	    	}	        
	    }
	    in.close();    		    
	
		return activeAccounts;
	}
	
	private ArrayList<Long> getWhiteListAccounts() throws Exception{		
		
		String filePath = whiteList;
		ArrayList<Long> whiteListAccounts = new ArrayList<Long>();											
		BufferedReader in = new BufferedReader(new FileReader(filePath));
			
		System.out.println("White-listed Accounts:");
	    String str;
	    while ((str = in.readLine()) != null) {
	    	String [] lineContent = str.split(":");
	    	if(lineContent[0].trim().equals("Account Name")){
	    		Long accountId = Long.valueOf(lineContent[3].trim());
	    		whiteListAccounts.add(accountId);
		    	System.out.println(accountId);
	    	}	        
	    }
	    in.close();
	    
	    System.out.println("# accounts on the white list - " + whiteListAccounts.size());
		
		return whiteListAccounts;
	}
	
	private void writeToReport(ArrayList<Long> deletedAccounts, List<Long> stillActiveAccounts, ArrayList<Integer> deletedPromotionIDs){
		try{
			FileWriter fstream = new FileWriter(cleanUpReport);
			BufferedWriter out = new BufferedWriter(fstream);
			
			out.write("***** Report of Cleaning Up Accounts On MSN *****");
			out.append("Date: " + new Date());
			out.append(" ");
			
			out.append("Accounts that have been deleted from MSN:");
			for(Long id : deletedAccounts){
				out.append("  - " + id);
			}
			
			out.append("Accounts that are still alive on MSN:");
			for(Long id : stillActiveAccounts){
				out.append("  - " + id);
			}
			
			out.append("Promotions that have been deleted from the Database of " + cleanUpRange.name() + ":");
			for(Integer id : deletedPromotionIDs){
				out.append("  - " + id);
			}
			
			out.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void init() throws Exception{
		try{
			setProps(cleanUpRange);
			
			//Load the configuration
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			Object object = new Object();
			SemplestConfiguration configDB = new SemplestConfiguration(object);
			Thread configThread = new Thread(configDB);
			configThread.start();
			synchronized (object)
			{
				object.wait();
			}
			
			msn = new MsnCloudServiceImpl();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void setProps(SERVER server) throws Exception{
		String path = "C:\\SEMplest_workspace\\SemplestTests\\src\\system.properties";				
		
		String jdbc;
		if(server.equals(SERVER.DEV)){
			useReportData = true;
			jdbc = "jdbc:jtds:sqlserver://172.18.9.23/semplest";
		}
		else if(server.equals(SERVER.TEST)){
			jdbc = "jdbc:jtds:sqlserver://172.18.9.35/semplestTest";
		}
		else{
			useReportData = true;
			jdbc = "jdbc:jtds:sqlserver://172.18.9.35/semplestTest";
		}
		
		Properties properties = new Properties();
		FileInputStream in = new FileInputStream(path);
		properties.load(in);
		in.close();		
		
		FileWriter out = new FileWriter(path);
		BufferedWriter writer = new BufferedWriter(out);			
		
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
}
