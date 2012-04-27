package semplest.other;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.Interval;

/**
 * Takes a datetime in and drops all minutes, seconds, and milliseconds to make the
 * datetime midinite. Because we only care about the date not the time.
 * 
 * @author zacharyshaw
 */

public class DateTimeFloored {
	
	private final DateTime flooredDate;
	
	public DateTimeFloored() {
		this(new DateTime());
	}
	
	public DateTimeFloored(DateTime dateTimeToBeFloored) {
		this.flooredDate = floor(dateTimeToBeFloored);
	}
	
	private DateTime floor(DateTime dateTime) {
		return dateTime.withMillisOfDay(0);
	}
	
	public DateTime getDate() {
		return flooredDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flooredDate == null) ? 0 : flooredDate.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateTimeFloored other = (DateTimeFloored) obj;
		if (flooredDate == null) {
			if (other.flooredDate != null)
				return false;
		} else if (!flooredDate.equals(other.flooredDate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return flooredDate.toString();
	}
	
	public static DateTimeFloored yesterday() {
		return new DateTimeFloored(new DateTime().minusDays(1));
	}
	
	public static DateTimeFloored today() {
		return new DateTimeFloored();
	}
	
	public static DateTimeFloored with(int year, int month, int day) {
		return new DateTimeFloored(new DateTime(year, month, day, 0, 0, 0, 0));
	}
	
	public boolean isFirstOfTheMonth() {
		return flooredDate.getDayOfMonth() == 1;
	}
	
	public boolean isSunday() {
		return flooredDate.getDayOfWeek() == DateTimeConstants.SUNDAY;
	}
	
	public boolean isSaturday() {
		return flooredDate.getDayOfWeek() == DateTimeConstants.SATURDAY;
	}
	
	public DateTimeFloored plusDays(int days) {
		return new DateTimeFloored(flooredDate.plusDays(days));
	}
	
	public Interval toInterval() {
		return new Interval(getDate(), new DateTimeCeiling(getDate()).getDate());
	}
}