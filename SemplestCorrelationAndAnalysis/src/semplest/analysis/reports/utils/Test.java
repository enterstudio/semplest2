package semplest.analysis.reports.utils;

import org.joda.time.DateTime;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DateTime lastDay = new DateTime(2012,5,23,0,0,0,0);
		DateTime firstDay = new DateTime(2012,5,22,0,0,0,0);
		int year = lastDay.getYear();
		
		String str = String.format("%4d%02d%02d", lastDay.getYear(),lastDay.getMonthOfYear(),lastDay.getDayOfMonth());
		System.out.printf(str);

	}

}
