package semplest.other;

import org.joda.time.DateTime;

public class DateUtil {
	public DateTime getFirstOfMonth(DateTime in) {
		// first of month
		return in.dayOfMonth().withMinimumValue().withMillisOfDay(0);
	}
	
	public DateTime getLastOfMonth(DateTime in) {
		// end of month
		return in.dayOfMonth().withMaximumValue().withTime(23, 59, 59, 999);
	}
	
	public int daysInMonth(DateTime in) {
		return in.dayOfMonth().withMaximumValue().getDayOfMonth();
	}
}
