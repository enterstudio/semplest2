package semplest.analysis.reports.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

import semplest.server.protocol.adengine.ReportObject;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
		
		//ReportObject[] reps = (ReportObject[]) ReportUtils.loadSerializedObject("/semplest/data/dailyReportObjects/PiperHallTest/20120525/20120525_MSNReport.robj");
		//ReportUtils.saveReportDataCSV(reps, "/semplest/data/dailyReportObjects/PiperHallTest/20120525/20120525_MSNReport");
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date dat = df.parse("20120303");
		String date = df.format(dat);
		System.out.println(date);
	}

}
