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

import semplest.server.service.SemplestConfiguration;
import semplest.server.service.springjdbc.BaseDB;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;

public class CleanUpMsnAccounts extends BaseDB{	
	
	private static SERVER cleanUpRange = SERVER.TEST; 
	private static boolean useReportData = true;	
	private static String reportListPath = "Z:\\nan\\msnActiveAccounts.txt";
	private static String whiteListPath = "Z:\\nan\\msnWhiteListedAccounts.txt";
	
	private MsnCloudServiceImpl msn;	
	private static enum SERVER {DEV, TEST};	
	
	public static void main(String[] args){
		try{
			CleanUpMsnAccounts cleanUp = new CleanUpMsnAccounts();			
			cleanUp.init();
			
			ArrayList<Long> toDeleteAccounts = cleanUp.getToDeleteAccounts();
			//cleanUp.deleteAccountsFromMsn(toDeleteAccounts);
			ArrayList<Integer> promotionIDs = cleanUp.getToDeletePromotions(toDeleteAccounts);
			//cleanUp.deletePromotionsFromDB(promotionIDs);
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	private ArrayList<Long> deleteAccountsFromMsn(ArrayList<Long> toDeleteAccounts) throws Exception{		
		
		ArrayList<Long> deletedAccounts = new ArrayList<Long>();
		
		System.out.println("Deleting Active Accounts from MSN...");
		for(Long accountId : toDeleteAccounts){
			try{
				boolean ret = msn.deleteAccountById(accountId);
				if(ret){
					deletedAccounts.add(accountId);
				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Deleted Accounts:");
		for(Long Id : deletedAccounts){
			System.out.println(Id);
		}
		System.out.println("# deleted accounts - " + deletedAccounts.size());
		
		return deletedAccounts;
	}
	
	private void deletePromotionsFromDB(ArrayList<Integer> promotionIDs){		
		System.out.println("Deleting Active Promotions from Database...");
		String sql;
		for(Integer Id : promotionIDs){
			sql = "UPDATE PromotionAdengineStatus SET PromotionStatusFK = 5 WHERE PromotionFK = ? AND AdvertisingEngineFK = 1";
			jdbcTemplate.update(sql, new Object[]
					{Id});
		}
		System.out.println("Done");
	}
	
	private ArrayList<Integer> getToDeletePromotions(ArrayList<Long> accounts) throws Exception{
		String sql;
		ArrayList<Integer> promotionIDs = new ArrayList<Integer>();
		
		System.out.println("Promotions need to be deleted:");
		
		for(Long accountId : accounts){
			sql = "SELECT aep.PromotionFK FROM AdvertisingEnginePromotion aep WHERE AdvertisingEngineAccountFK = ?";
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[] 
					{accountId});
			for(Map<String, Object> map : list){
				for(String s : map.keySet()){
					Integer Id = (Integer)map.get(s);
					promotionIDs.add(Id);
					System.out.println(Id);
				}
			}
		}	
		System.out.println("# promotions to be deleted - " + promotionIDs.size());
		
		return promotionIDs;
	}
	
	private ArrayList<Long> getToDeleteAccounts() throws Exception{
		ArrayList<Long> activeAccounts = getActiveAccounts();
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
	
	private ArrayList<Long> getActiveAccounts() throws Exception{
		ArrayList<Long> activeAccounts = new ArrayList<Long>();
		
		if(useReportData){
			activeAccounts = readReportFile();
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
	
	private ArrayList<Long> readReportFile() throws Exception{
		
		String filePath = reportListPath;
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
		
		String filePath = whiteListPath;
		ArrayList<Long> whiteListAccounts = new ArrayList<Long>();											
		BufferedReader in = new BufferedReader(new FileReader(filePath));
			
		System.out.println("White-listed Accounts:");
	    String str;
	    while ((str = in.readLine()) != null) {
	    	String[] lineContent = str.split(":");
	    	if(lineContent.length > 1){
	    		Long accountId = Long.valueOf(lineContent[1].trim());
		    	whiteListAccounts.add(accountId);
		    	System.out.println(accountId);
	    	}
	    }
	    in.close();
	    
	    System.out.println("# accounts on the white list - " + whiteListAccounts.size());
		
		return whiteListAccounts;
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
