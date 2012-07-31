
package semplest.keywordsnonprod.multiwords;

import java.util.Calendar;
import java.util.HashMap;

import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MonthAndYear;

import semplest.server.protocol.msn.MsnCloudException;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;

public class VolumeMSN {
	
	
	public static HashMap<String, Integer> getVolume(MsnCloudServiceImpl msn, String[] keywords) {
		
					
		Long accountID = null;
		Calendar cal = Calendar.getInstance();
		MonthAndYear startMonth = new MonthAndYear();
		startMonth.setMonth(cal.get(Calendar.MONTH) + 1);
		startMonth.setYear(cal.get(Calendar.YEAR) - 1);
		
		HashMap<String,Integer> keywordVolumeMap = new HashMap<String,Integer>();
		
		try {
			HashMap<String, int[][]> kwVolume = msn.getKeywordVolumes(accountID, keywords, startMonth);
			for(String s : keywords){
				int [][] res = kwVolume.get(s);
				if(res!=null){
					int sum=0;
					for (int i=0; i< res.length; i++){
						sum+=res[i][2];
						//System.out.println(res[i][0]+"-"+res[i][1]+":"+res[i][2]);
					}
					keywordVolumeMap.put(s,sum/res.length);
				} else{
					keywordVolumeMap.put(s,null);
				}
					
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return keywordVolumeMap;

	}
	

	public static void main(String[] args) {
		
		
		MsnCloudServiceImpl msn = null;
		try {
			msn = new MsnCloudServiceImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		//String[] keywords = new String[]{"wedding bouquets","wedding flowers","wedding centerpieces"};
		String[] keywords = new String[]{"reliably refer"};
		
		HashMap<String,Integer> keywordVolumeMap=VolumeMSN.getVolume(msn, keywords);
		
		
		if(keywordVolumeMap!=null){
			for(String s : keywords){
				System.out.println(s+": "+keywordVolumeMap.get(s));
			}
		}
		

		



	}

}
