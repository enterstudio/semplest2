package semplest.other;

import org.joda.time.DateTime;

public class TimeServerImpl implements TimeServer {
	private DateUtil dateUtil;
	
	public TimeServerImpl() {
		dateUtil = new DateUtil();
	}
	
	@Override
	public DateTimeFloored getTodaysDate() {
		return DateTimeFloored.today();
	}
	
	@Override
	public DateTime now() {
		return new DateTime();
	}
	
	@Override
	public DateTime getFirstOfMonth(DateTime in) {
		return dateUtil.getFirstOfMonth(in);
	}
	
	@Override
	public DateTimeFloored getFirstOfCurrentMonthFloored() {
		return new DateTimeFloored(dateUtil.getFirstOfMonth(now()));
	}
	
	@Override
	public DateTime getLastOfMonth(DateTime in) {
		return dateUtil.getLastOfMonth(in);
	}
	
	@Override
	public DateTimeFloored getYesterdayFloored() {
		return DateTimeFloored.yesterday();
	}
	
	@Override
	public DateTimeCeiling getYesterdayCeiling() {
		return new DateTimeCeiling(now().minusDays(1));
	}
	
	public DateUtil getDateUtil() {
		return dateUtil;
	}
	
	void setDateUtil(DateUtil dateUtil) {
		this.dateUtil = dateUtil;
	}
	
}
