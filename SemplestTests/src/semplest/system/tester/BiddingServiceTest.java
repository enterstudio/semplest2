package semplest.system.tester;

import java.util.List;
import java.util.Map;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.adengine.AdEngineInitialData;
import semplest.server.protocol.adengine.BudgetObject;
import semplest.services.client.api.SemplestBiddingServiceClient;
import semplest.services.client.interfaces.SemplestBiddingInterface;

public class BiddingServiceTest implements SemplestBiddingInterface
{

	private String serviceName = "Bidding";

	private SemplestBiddingServiceClient biddingService;

	public int Test_BiddingService(String serviceURL)
	{
		try
		{
			SystemTestFunc.PrintServiceHeader(serviceName);
			SystemTestDataModel.errorCounter = 0;

			biddingService = new SemplestBiddingServiceClient(serviceURL, null);

			/* ***** List of Methods ***** */
			GetMonthlyBudgetPercentPerSE(null, null);
			getInitialValues(null, null, null);
			setBidsInitial(null, null, null);
			setBidsUpdate(null, null, null);

			/* ***** End of List of Methods ***** */

		}
		catch (Exception e)
		{
			SystemTestFunc.PrintLineSeperator();
			SystemTestFunc.ErrorHandler(e);
		}

		SystemTestFunc.PrintServiceFooter(serviceName, SystemTestDataModel.errorCounter);
		SystemTestDataModel.biddingErrors = SystemTestDataModel.errorCounter;
		return SystemTestDataModel.errorCounter;
	}

	@Override
	public Map<AdEngine, Double> GetMonthlyBudgetPercentPerSE(Integer promotionID, List<AdEngine> searchEngine) throws Exception
	{
		SystemTestFunc.PrintLineSeperator();
		try
		{
			SystemTestFunc.PrintMethodCall("GetMonthlyBudgetPercentPerSE(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList");
			Map<AdEngine, Double> ret = biddingService.GetMonthlyBudgetPercentPerSE(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList);

			for (AdEngine a : ret.keySet())
			{
				System.out.println("AdEngine = " + a);
				System.out.println("	- MonthlyBudgetPercent = " + ret.get(a));
			}

			// Verification
			if (ret.size() != SystemTestDataModel.adEngineList.size())
			{
				SystemTestFunc.ErrorHandler("MonthlyBudgetPercentPerSE not returned for all the AdEngines.");
			}
		}
		catch (Exception e)
		{
			SystemTestFunc.ErrorHandler(e);
		}

		return null;
	}

	@Override
	public Map<AdEngine, AdEngineInitialData> getInitialValues(Integer promotionID, List<AdEngine> searchEngine, Double totalMonthlyBudget) throws Exception
	{
		SystemTestFunc.PrintLineSeperator();
		try
		{
			SystemTestFunc.PrintMethodCall("getInitialValues(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList, SystemTestDataModel.bidding_TotalMonthlyBudget)");
			Map<AdEngine, AdEngineInitialData> ret = biddingService.getInitialValues(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList, SystemTestDataModel.bidding_TotalMonthlyBudget);

			for (AdEngine a : ret.keySet())
			{
				System.out.println("AdEngine = " + a);
				AdEngineInitialData d = ret.get(a);
				System.out.println("	- " + d.toString());
			}

			// Verification
			if (ret.size() != SystemTestDataModel.adEngineList.size())
			{
				SystemTestFunc.ErrorHandler("InitialValues not returned for all the AdEngines.");
			}
		}
		catch (Exception e)
		{
			SystemTestFunc.ErrorHandler(e);
		}
		return null;
	}

	@Override
	public Boolean setBidsInitial(Integer promotionID, AdEngine searchEngine, BudgetObject budgetData) throws Exception
	{
		SystemTestFunc.PrintLineSeperator();
		try
		{
			for (AdEngine adEngine : SystemTestDataModel.adEngineList)
			{
				System.out.println("Using AdEngine - " + adEngine);

				SystemTestFunc.PrintMethodCall("setBidsInitial(SystemTestDataModel.semplestPromotionId, adEngine, SystemTestDataModel.bidding_BudgetData)");
				boolean ret = biddingService.setBidsInitial(SystemTestDataModel.semplestPromotionId, adEngine, SystemTestDataModel.bidding_BudgetData);

				// Verification
				if (!ret)
				{
					SystemTestFunc.ErrorHandler("SetBidsInitial failed.");
				}
			}
		}
		catch (Exception e)
		{
			SystemTestFunc.ErrorHandler(e);
		}
		return null;
	}

	@Override
	public Boolean setBidsUpdate(Integer promotionID, AdEngine searchEngine, BudgetObject budgetData) throws Exception
	{
		SystemTestFunc.PrintLineSeperator();
		try
		{
			for (AdEngine adEngine : SystemTestDataModel.adEngineList)
			{
				System.out.println("Using AdEngine - " + adEngine);

				SystemTestFunc.PrintMethodCall("setBidsUpdate(SystemTestDataModel.semplestPromotionId, adEngine, SystemTestDataModel.bidding_BudgetData)");
				boolean ret = biddingService.setBidsUpdate(SystemTestDataModel.semplestPromotionId, adEngine, SystemTestDataModel.bidding_BudgetData);

				// Verification
				if (!ret)
				{
					SystemTestFunc.ErrorHandler("SetBidsUpdate failed.");
				}
			}
		}
		catch (Exception e)
		{
			SystemTestFunc.ErrorHandler(e);
		}
		return null;
	}

	// Unused methods
	@Override
	public Map<String, Double> getBid(String accountID, Long campaignID, Long adGroupID, List<String> keywords) throws Exception
	{
		return null;
	}

	@Override
	public void getBidsInitialNaive(String accountID, Long campaignID, Long adGroupID, AdEngine searchEngine) throws Exception
	{
	}

	@Override
	public void getBidsUpdateNaive(String accountID, Long campaignID, Long adGroupID, AdEngine searchEngine) throws Exception
	{
	}

	// unrelated methods
	@Override
	public void initializeService(String input) throws Exception
	{
	}

	@Override
	public String checkStatus(String input1, String input2) throws Exception
	{
		return null;
	}
}
