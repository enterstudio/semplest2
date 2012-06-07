
package semplest.keywordsnonprod.multiwords;

import java.util.Calendar;
import java.util.HashMap;

import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MonthAndYear;

import semplest.service.msn.adcenter.MsnCloudException;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;

public class CreateGramsFromCrawl {
	

	public static void main(String[] args) {
		
		
		MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
			
		Long accountID = null;
		Calendar cal = Calendar.getInstance();
		MonthAndYear startMonth = new MonthAndYear();
		startMonth.setMonth(cal.get(Calendar.MONTH) + 1);
		startMonth.setYear(cal.get(Calendar.YEAR) - 1);
		
		String[] keywords = new String[]{"wedding flowers"};
		
		try {
			HashMap<String, int[][]> kwVolume = msn.getKeywordVolumes(accountID, keywords, startMonth);
			for(String s : keywords){
				int [][] res = kwVolume.get(s);
				if(res!=null){
					for (int i=0; i< res.length; i++){
						System.out.println(res[i][0]+"-"+res[i][1]+":"+res[i][2]);
					}
				}
			}
		} catch (MsnCloudException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		



	}

}
