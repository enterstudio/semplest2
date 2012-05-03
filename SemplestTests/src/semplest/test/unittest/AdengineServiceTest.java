package semplest.test.unittest;

import java.util.ArrayList;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.service.adengine.SemplestAdengineServiceImpl;

public class AdengineServiceTest {
	
	public void Test_AdengineService(){
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
