package semplest.analysis.reports.utils;

import java.io.IOException;

import org.joda.time.DateTime;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		ReportUtils.combineFPCPCReports("/semplest/lluis/fpcpcReport.csv", 
				"/semplest/lluis/fpcpcReportGoogle.csv", "/semplest/lluis/fpcpcReportCombined.csv");

	}

}
