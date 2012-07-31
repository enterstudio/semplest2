package semplest.system.tester;

public class SystemTester {

	private static final String serviceURL = "http://VMJAVA1:9898/semplest";
	
	public static void main(String[] args){
		try{			
			String reportPath = args[0];
			
			SystemTestFunc.InitializeReport(reportPath);			
			SystemTestFunc.InitializeSystemTest();
			
			AdEngineServiceTest adEngineTest = new AdEngineServiceTest();
			BiddingServiceTest biddingTest = new BiddingServiceTest();
			KeywordServiceTest keywordTest = new KeywordServiceTest();
			MailServiceTest mailTest = new MailServiceTest();
			
			adEngineTest.Test_AdEngineService(serviceURL);
			biddingTest.Test_BiddingService(serviceURL);
			keywordTest.Test_KeywordService(serviceURL);
			mailTest.Test_MailService(serviceURL);
			
			SystemTestFunc.CleanUpTestData();			
			SystemTestFunc.FinalizeReport();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
