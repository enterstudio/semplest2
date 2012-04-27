package semplest.other;

import java.util.Comparator;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

/**
 * Given a DateTime, sets the timestamp to EOD (11:59:59.999).
 * 
 * @author anthony
 */

public class DateTimeCeiling {
	public static Comparator<DateTimeCeiling> byDayAscending() {
		return new Comparator<DateTimeCeiling>() {
			@Override
			public int compare(DateTimeCeiling o1, DateTimeCeiling o2) {
				if (o1.ceilingDate.isBefore(o2.ceilingDate))
					return -1;
				else if (o1.ceilingDate.isAfter(o2.ceilingDate))
					return 1;
				else
					return 0;
			}
		};
	}
	
	public static F2<DateTimeCeiling, DateTimeCeiling, Boolean> dateTimeCeilingsAreEqual() {
		return new F2<DateTimeCeiling, DateTimeCeiling, Boolean>() {
			@Override
			public Boolean apply(DateTimeCeiling a, DateTimeCeiling b) {
				return a.equals(b);
			}
		};
	}
	
	private final DateTime ceilingDate;
	
	public DateTimeCeiling() {
		this(new DateTime());
	}
	
	public DateTimeCeiling(DateTime date) {
		this.ceilingDate = ceiling(date);
	}
	
	private DateTime ceiling(DateTime dateTime) {
		return dateTime.withMillisOfDay(0).plusDays(1).minusMillis(1);
	}
	
	public DateTime getDate() {
		return ceilingDate;
	}
	
	public DateTimeCeiling plusDays(int n) {
		return new DateTimeCeiling(ceilingDate.plusDays(n));
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ceilingDate == null) ? 0 : ceilingDate.hashCode());
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
		DateTimeCeiling other = (DateTimeCeiling) obj;
		if (ceilingDate == null) {
			if (other.ceilingDate != null)
				return false;
		} else if (!ceilingDate.equals(other.ceilingDate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return ceilingDate.toString();
	}
	
	public static DateTimeCeiling yesterday() {
		return new DateTimeCeiling(new DateTime().minusDays(1));
	}
	
	public static DateTimeCeiling today() {
		return new DateTimeCeiling();
	}
	
	public static DateTimeCeiling with(int year, int month, int day) {
		return new DateTimeCeiling(new DateTime(year, month, day, 0, 0, 0, 0));
	}
	
	public static DateTimeCeiling with(LocalDate localDate) {
		return DateTimeCeiling.with(localDate.getYear(), localDate.getMonthOfYear(), localDate.getDayOfMonth());
	}
	
	public static F<DateTime, DateTimeCeiling> dateTimeToDateTimeCeiling() {
		return new F<DateTime, DateTimeCeiling>() {
			@Override
			public DateTimeCeiling apply(DateTime a) {
				return new DateTimeCeiling(a);
			}
			
		};
	}
	
	public static F<DateTimeCeiling, DateTime> dateTimeCeilingToDateTime() {
		return new F<DateTimeCeiling, DateTime>() {
			@Override
			public DateTime apply(DateTimeCeiling a) {
				return a.getDate();
			}
			
		};
	}
	
	public static F<DateTimeCeiling, DateTimeCeiling> incrementDateTimeCeilingByOneDay() {
		return new F<DateTimeCeiling, DateTimeCeiling>() {
			@Override
			public DateTimeCeiling apply(DateTimeCeiling a) {
				return a.plusDays(1);
			}
		};
	}
	
	public boolean isFirstOfTheMonth() {
		return ceilingDate.getDayOfMonth() == 1;
	}
	
	public boolean isSunday() {
		return ceilingDate.getDayOfWeek() == DateTimeConstants.SUNDAY;
	}
	
	public boolean isSaturday() {
		return ceilingDate.getDayOfWeek() == DateTimeConstants.SATURDAY;
	}
	
	public static F<LocalDate, DateTimeCeiling> localDateToDateTimeCeiling() {
		return new F<LocalDate, DateTimeCeiling>() {
			@Override
			public DateTimeCeiling apply(LocalDate a) {
				return with(a);
			}
		};
	}
	
	public static F<DateTime, DateTimeCeiling> fromDate() {
		return new F<DateTime, DateTimeCeiling>() {
			
			@Override
			public DateTimeCeiling apply(DateTime a) {
				return new DateTimeCeiling(a);
			}
		};
		
	}
}