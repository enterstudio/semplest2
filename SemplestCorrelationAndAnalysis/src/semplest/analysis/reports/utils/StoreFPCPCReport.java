package semplest.analysis.reports.utils;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import semplest.analysis.reports.google.GoogleReportTools;
import semplest.analysis.reports.msn.MSNReportTools;
import semplest.server.protocol.adengine.ReportObject;
import semplest.service.msn.adcenter.MSNAdcenterServiceClientTest;

public class StoreFPCPCReport {

	/**
	 * Stores ReportObjects for the date specified for each Search Engine.
	 * The report will be stored as a serialized report object and the numerical data will be stored in .csv format
	 * @param args
	 * args[0] googleAccountName
	 * args[1] googleAccountId
	 * args[2] msnCampaignIndex
	 * args[3] msnAccountName
	 * args[4] msnCampaignIndex
	 * args[5] baseStorePath (i.e. "/semplest/data/")
	 * args[6] dateString (YYYYMMDD)
	 */
	private static final Logger logger = Logger.getLogger(MSNAdcenterServiceClientTest.class);
	
	public static void main(String[] args) throws Exception {
		
		//Store MSN Reports for specified date
		MSNReportTools repTMSN = new MSNReportTools(args[3],Integer.valueOf(args[4]));
		ArrayList<String> fpcpcMSN = repTMSN.getFPCPCreportForCampaign();
		ReportUtils.saveArrayListString(fpcpcMSN, args[5]+args[6]+"fpcpcReportMSN.csv");
		
		//Store Google Reports for specified date
		GoogleReportTools repTGoogle = new GoogleReportTools(args[0], Long.valueOf(args[1]), Integer.valueOf(args[2]));
		ArrayList<String> msnReport = ReportUtils.readFile(args[5]+args[6]+"fpcpcReportMSN.csv");
		ArrayList<String> keywords = new ArrayList<String>();
		for(String line : msnReport){
			String[] parts = line.split(",");
			keywords.add(parts[0].replaceAll("^\\s+", "").replace("\\s+$", ""));
			
		}
		ArrayList<String> fpcpcGoogle = repTGoogle.getFPCPCreportForKeywords(keywords,"/home/lluis/Downloads/Keywordreport.csv" );
		ReportUtils.saveArrayListString(fpcpcGoogle, args[5]+args[6]+"fpcpcReportGoogle.csv");
		
		
	}

}
