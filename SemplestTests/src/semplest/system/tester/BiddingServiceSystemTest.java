package semplest.system.tester;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.adengine.AdEngineInitialData;
import semplest.server.protocol.adengine.BudgetObject;
import semplest.services.client.api.SemplestBiddingServiceClient;
import semplest.services.client.interfaces.SemplestBiddingInterface;

public class BiddingServiceSystemTest implements SemplestBiddingInterface {
	
	private int errorCounter = 0;
	private String vMsg = "Verification FAILED! ";
	
	SemplestBiddingServiceClient biddingService;

	public int Test_BiddingService(String serviceURL){	
		try{
			biddingService = new SemplestBiddingServiceClient(serviceURL, null);
			
			
			
		}
		catch(Exception e){
			System.out.println("------------------------------------------------------------");
			System.out.println("Other Error: ");
			errorHandler(e);
		}
		
		String result = errorCounter > 0 ? "FAILED" : "PASSED";		
		System.out.println(" ");
		System.out.println("####################################################################################");
		System.out.println("#                      Bidding Service (Client) Test "+result+"!                       #");
		System.out.println("####################################################################################");
		
		
		return errorCounter;
	}
	
	@Override
	public Map<AdEngine, Double> GetMonthlyBudgetPercentPerSE(
			Integer promotionID, List<AdEngine> searchEngine) throws Exception {
		
		Map<AdEngine, Double> ret = biddingService.GetMonthlyBudgetPercentPerSE(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList);
		
		for(AdEngine a : ret.keySet()){
			System.out.println();
		}
		
		return null;
	}

	@Override
	public Map<AdEngine, AdEngineInitialData> getInitialValues(
			Integer promotionID, List<AdEngine> searchEngine,
			Double totalMonthlyBudget) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean setBidsInitial(Integer promotionID, AdEngine searchEngine,
			BudgetObject budgetData) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean setBidsUpdate(Integer promotionID, AdEngine searchEngine,
			BudgetObject budgetData) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> getBid(String accountID, Long campaignID,
			Long adGroupID, List<String> keywords) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getBidsInitialNaive(String accountID, Long campaignID,
			Long adGroupID, AdEngine searchEngine) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getBidsUpdateNaive(String accountID, Long campaignID,
			Long adGroupID, AdEngine searchEngine) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	//unrelated methods
	@Override
	public void initializeService(String input) throws Exception {	
	}

	@Override
	public String checkStatus(String input1, String input2) throws Exception {
		return null;
	}

	private void errorHandler(Exception e){
		e.printStackTrace();
		System.out.println("////////////////////////////////////////////////////");	
		System.out.println("ERROR:");
		System.out.println(e.getMessage());
		System.out.println();
		Writer error = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(error);
	    e.printStackTrace(printWriter);
	    System.out.println(error.toString());
		System.out.println("////////////////////////////////////////////////////");			
		
		errorCounter++;
	}
}
