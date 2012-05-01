package semplest.test.unittest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.joda.time.DateTime;

import com.microsoft.adcenter.v8.ReportAggregation;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.SemplestString;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.msn.MsnAccountObject;
import semplest.server.service.adengine.SemplestAdengineServiceImpl;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;
import semplest.other.MsnManagementIds;

public class UnitTests {
	
	private static String now;
	
	public static void main(String[] args)
	{
		/*
		 * List of services/methods that needs to be tested:
		 * 	- SemplestAdengineService
		 * 	- MsnCloudService
		 * 	- GoogleAdwordsService
		 * 	- KeywordsService
		 * 	- BiddingService
		 * 
		 */				
		try{
			//Create Report
			DateFormat dateFormat = new SimpleDateFormat("_MM-dd-yy_HHmm");
			Date date = new Date();
			now = dateFormat.format(date);
			String reportName = "UnitTestReport" + now + ".txt";
			String reportPath = "\\Z:\\TestReports\\" + reportName;
			PrintStream out = new PrintStream(new FileOutputStream(reportPath));
			System.setOut(out);
			
			System.out.println("******************************************");
			System.out.println("*                                        *");
			System.out.println("*       SEMplest Unit Test Report        *");
			System.out.println("*                                        *");
			System.out.println("******************************************");
			System.out.println("Report Time: " + now);
			System.out.println("   ");
			
			//Start Test
			MsnServiceTest msnServiceTest = new MsnServiceTest();
			msnServiceTest.Test_MsnServices();	
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("ERROR:");
			System.out.println(e.getMessage());
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println(" ");
			System.out.println("******************************************");
			System.out.println("*                                        *");
			System.out.println("*       SEMplest Unit Test FAILED        *");
			System.out.println("*                                        *");
			System.out.println("******************************************");
		}
			
	}
	
	public void Test1_AdengineService(){
		//function not finished yet
		try{
			SemplestAdengineServiceImpl adengineService = new SemplestAdengineServiceImpl();
			int customerID = 0;
			Long productGroupID = 0L;
			int PromotionID = 0;
			ArrayList<String> adEngineList = new ArrayList<String>();
			adEngineList.add(AdEngine.Google.name());
			adEngineList.add(AdEngine.MSN.name());
			adengineService.AddPromotionToAdEngine(customerID, productGroupID, PromotionID, adEngineList);
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	

}
