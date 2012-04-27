package semplest.other;

import org.joda.time.DateTime;

public interface TimeServer {
	
	public abstract DateTimeFloored getTodaysDate();
	
	public abstract DateTime now();
	
	public abstract DateTime getFirstOfMonth(DateTime in);
	
	public abstract DateTimeFloored getFirstOfCurrentMonthFloored();
	
	public abstract DateTime getLastOfMonth(DateTime in);
	
	public abstract DateTimeFloored getYesterdayFloored();
	
	public abstract DateTimeCeiling getYesterdayCeiling();
	
}