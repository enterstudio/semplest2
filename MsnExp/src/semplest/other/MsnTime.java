package semplest.other;

import org.joda.time.DateTime;

import com.microsoft.adcenter.v8.Date;
import com.microsoft.adcenter.v8.ReportTime;

public class MsnTime {
	private final Date date;
	
	public MsnTime(DateTime dateTime) {
		this.date = convert(dateTime);
	}
	
	public Date asDate() {
		Date ret = new Date();
		ret.setDay(date.getDay());
		ret.setMonth(date.getMonth());
		ret.setYear(date.getYear());
		return ret;
	}
	
	private Date convert(DateTime start) {
		Date ret = new Date();
		ret.setDay(start.getDayOfMonth());
		ret.setMonth(start.getMonthOfYear());
		ret.setYear(start.getYear());
		return ret;
	}
	
	public ReportTime reportTimeTill(DateTime reportEndDate, DateTime now) {
		return reportTimeTill(new MsnTime(reportEndDate), new MsnTime(now));
	}
	
	public ReportTime reportTimeTill(MsnTime reportEndDate, MsnTime now) {
		if (reportEndDate.isAfter(now)) {
			return reportTime(this.asDate(), now.asDate());
		}
		Date start = this.asDate();
		Date end = reportEndDate.asDate();
		return reportTime(start, end);
	}
	
	/**
	 * Set dates of the report to span between a set number of days before this time.
	 * 
	 * @param days
	 */
	public ReportTime asReportTimeEndTimeWithStartingMinusDays(int days) {
		ReportTime time = new ReportTime();
		MsnTime start = minusDays(days);
		time.setCustomDateRangeStart(start.asDate());
		time.setCustomDateRangeEnd(asDate());
		return time;
	}
	
	public MsnTime minusDays(int days) {
		return new MsnTime(asJodaDate().minusDays(days));
	}
	
	public MsnTime plusDays(int days) {
		return new MsnTime(asJodaDate().plusDays(days));
	}
	
	public boolean isAfter(MsnTime otherTime) {
		return asJodaDate().isAfter(otherTime.asJodaDate());
	}
	
	private DateTime asJodaDate() {
		return new DateTime(date.getYear(), date.getMonth(), date.getDay(), 0, 0, 0, 0);
	}
	
	private ReportTime reportTime(Date start, Date end) {
		ReportTime time = new ReportTime();
		time.setCustomDateRangeStart(start);
		time.setCustomDateRangeEnd(end);
		return time;
	}
}
