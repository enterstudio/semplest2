package semplest.services.client.api;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolJSON;
import semplest.services.client.interfaces.SemplestAdengineServiceInterface;

import com.google.gson.Gson;

public class SemplestAdEngineServiceClient extends ServiceRun implements SemplestAdengineServiceInterface
{
	private static String SERVICEOFFERED = "semplest.server.service.adengine.SemplestAdengineService";
	private static String BASEURLTEST = "http://VMDEVJAVA1:9898/semplest"; // VMJAVA1
	private static String timeoutMS = "40000";
	private static Gson gson = new Gson();
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static final Logger logger = Logger.getLogger( SemplestAdEngineServiceClient.class);
	private String baseurl;

	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean AddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, ArrayList<String> adEngineList)
			throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("productGroupID", Integer.toString(productGroupID));
		jsonHash.put("promotionID",Integer.toString(PromotionID));
		String adEngineListStr = gson.toJson(adEngineList,ArrayList.class);
		jsonHash.put("adEngineList",adEngineListStr);
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl, SERVICEOFFERED, "AddPromotionToAdEngine", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

	@Override
	public Boolean PausePromotion(Integer customerID, Integer promotionID, String adEngine) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean PauseProductGroup(Integer customerID, Integer productGroupID, String adEngine) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean DeleteAd(Integer customerID, Integer promotionID, Integer promotionAdID) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean DeleteSiteLinkForAd(Integer customerID, Integer promotionID, Integer promotionAdID, Integer SiteLinkID) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean UpdateGeoTargeting(Integer customerID, Integer productGroupID, Integer GeoTargetingID) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean ExecuteBidProcess(Integer PromotionID, ArrayList<String> adEngine) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

}
