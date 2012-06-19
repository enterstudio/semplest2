package semplest.analysis.reports.utils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import semplest.server.protocol.adengine.ReportObject;

public class createReportsOverTime {

	/**
	 * Store data aggrupated by match Type and keyword
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String matchType = "Broad";
		String[] dates = {"20120525" , "20120526" ,"20120527" , "20120528" , "20120529" , "20120530", "20120531" };
				 /*"20120601", "20120602" , "20120603", "20120604" ,"20120605" ,"20120606" , "20120607" ,
				 "20120608" , "20120609", "20120610", "20120611" ,"20120612" , "20120613" ,"20120614"  , 
				 "20120615"  , "20120616" ,"20120617" ,"20120618" };*/
		String basePath = "/semplest/data/dailyReportObjects/PiperHallTest/";
		
		//Loading msn Data
		ReportObject[] repArrayMSN = loadAndMergeReports(dates, basePath, "_MSNReport.robj");
		//Loading google Data
		ReportObject[] repArrayGoogle = loadAndMergeReports(dates, basePath, "_GoogleReport.robj");

		
		//Get Total report grouped by keyword
		HashMap<String, ArrayList<ReportObject>> mapReportMSNTotal = ReportUtils.groupReportPerMatchType(repArrayMSN, matchType);
		HashMap<String, ArrayList<ReportObject>> mapReportGoogleTotal = ReportUtils.groupReportPerMatchType(repArrayGoogle, matchType);
		
		//Get Reports grouped by date
		HashMap<String, ArrayList<ReportObject>> mapReportMSNDaily = ReportUtils.groupReportPerDate(repArrayMSN);
		HashMap<String, ArrayList<ReportObject>> mapReportGoogleDaily = ReportUtils.groupReportPerDate(repArrayGoogle);
		
		//Get Reports grouped by keyword and date
		HashMap<String,HashMap<String, ArrayList<ReportObject>>> mapReportMSNDailybyKw = 
				ReportUtils.groupReportPerDateAndKeyword(mapReportMSNDaily, matchType);
		HashMap<String,HashMap<String, ArrayList<ReportObject>>> mapReportGoogleDailybyKw = 
				ReportUtils.groupReportPerDateAndKeyword(mapReportGoogleDaily, matchType);
		
		
		//****************** Analysis **************************************************
		
		// General comparison
		
		int totalMSNImpr, totalMSNClicks;
		int totalGoogleImpr, totalGoogleClicks;
		double totalMsnAveCpc, totalMsnAvePos, totalMsnAveFPCPC, totalMsnAveQS;
		double totalGoogleAveCpc, totalGoogleAvePos, totalGoogleAveFPCPC, totalGoogleAveQS;
		int totalKwWithImpMsn=0, totalKwWithClickMsn=0;
		int totalKwWithImpGoogle=0, totalKwWithClickGoogle=0;
		int totalOverlapKwWithImp=0;
		int totalOverlapKwWithClicks=0;
		
		Set<String> keySet = mapReportMSNTotal.keySet();
		totalKwWithImpMsn = keySet.size();
		for(String kw : keySet){

		}
		
	}
	private static ReportObject[] loadAndMergeReports(String[] dates, String basePath, String extension) throws Exception{
		ArrayList<ReportObject> reps = new ArrayList<ReportObject>();
		for(String date : dates){
			String path = basePath+date+"/"+date+extension;
			ReportObject[] repsAux = (ReportObject[]) ReportUtils.loadSerializedObject(path);
			if(repsAux!=null){
				reps.addAll(new ArrayList<ReportObject>(Arrays.asList(repsAux)));
			}
			System.out.println("Loaded "+path);
		}
		ReportObject[] repArray = new ReportObject[reps.size()];
		reps.toArray(repArray);
		return repArray;
	}

}
