package semplest.analysis.reports.utils;

import java.io.IOException;

import org.joda.time.DateTime;

import semplest.server.protocol.adengine.ReportObject;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ReportObject[] reps = (ReportObject[]) ReportUtils.loadSerializedObject("/semplest/data/dailyReportObjects/PiperHallTest/20120531/20120531_GoogleReport.robj");
		ReportUtils.saveReportDataCSV(reps, "/semplest/data/dailyReportObjects/PiperHallTest/20120531/20120531_GoogleReport");

	}

}
