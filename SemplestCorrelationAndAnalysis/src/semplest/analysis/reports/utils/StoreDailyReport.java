package semplest.analysis.reports.utils;

import org.apache.log4j.Logger;

import semplest.analysis.reports.google.GoogleReportTools;
import semplest.analysis.reports.msn.MSNReportTools;
import semplest.server.protocol.adengine.ReportObject;
import semplest.service.msn.adcenter.MSNAdcenterServiceClientTest;

public class StoreDailyReport {

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
		//Store Google Reports for specified date
		GoogleReportTools repTGoogle = new GoogleReportTools(args[0], Long.valueOf(args[1]), Integer.valueOf(args[2]));
		ReportObject[] repsG = repTGoogle.getKeywordReportObjects(args[6], args[6]);
		ReportUtils.saveSerializedObject(repsG, args[5]+args[6]+"/"+args[6]+"_GoogleReport.robj");
		ReportUtils.saveReportDataCSV(repsG, args[5]+args[6]+"/"+args[6]+"_GoogleReport");
		
		//Store MSN Reports for specified date
		MSNReportTools repTMSN = new MSNReportTools(args[3],Integer.valueOf(args[4]));
		ReportObject[] repsM = repTMSN.getKeywordReportObjects(args[6], args[6]);
		ReportUtils.saveSerializedObject(repsM, args[5]+args[6]+"/"+args[6]+"_MSNReport.robj");
		ReportUtils.saveReportDataCSV(repsM, args[5]+args[6]+"/"+args[6]+"_MSNReport");
	}

}
