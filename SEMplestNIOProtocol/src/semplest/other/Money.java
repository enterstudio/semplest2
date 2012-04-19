package semplest.other;

import java.io.Serializable;
import java.math.BigDecimal;


import javax.xml.bind.annotation.XmlAttribute;

/**
 * 100,000 milliCents == 1 Dollar
 * 1,000 milliCents == 1 cent
 * Conversions will always round down - 99 Cents = 0 Dollars, 999 MicroCents = 0 Cents, 199 cents = 1 Dollar etc.
 */

public class Money implements Comparable<Money>, Serializable {
	private static final int DECIMAL_PLACES_IN_MILLI = 5;
	private static final long serialVersionUID = 1L;
	@XmlAttribute
	private final long milliCents;
	
	public Money() {
		milliCents = 0;
	}
	
	public Money(long milliCents) {
		this.milliCents = milliCents;
	}
	
	public static Money withMilliCents(long milliCents) {
		return new Money(milliCents);
	}
	
	public static Money withMicroDollars(long microDollars) {
		return new Money(microDollars / 10);
	}
	
	public static Money withCents(long cents) {
		return new Money(cents * 1000);
	}
	
	public static Money withDollars(long dollars) {
		return new Money(dollars * 100000);
	}
	
	public static Money withDollars(double d) {
		return withMilliCents(BigDecimal.valueOf(d).movePointRight(DECIMAL_PLACES_IN_MILLI).longValue());
	}
	
	public static Money zero() {
		return withMilliCents(0);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (milliCents ^ (milliCents >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Money)) {
			return false;
		}
		Money other = (Money) obj;
		if (milliCents != other.milliCents) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return prettyWithMilliCents();
	}
	
	public long getMilliCents() {
		return milliCents;
	}
	
	public long getCents() {
		return milliCents / 1000;
	}
	
	public long getDollars() {
		return milliCents / 100000;
	}
	
	public long getMicroDollars() {
		return milliCents * 10;
	}
	
	public boolean greaterThan(Money otherMoney) {
		return milliCents > otherMoney.milliCents;
	}
	
	public Boolean greaterThanOrEqual(Money other) {
		return milliCents >= other.milliCents;
	}
	
	public Money minus(Money money) {
		return Money.withMilliCents(milliCents - money.milliCents);
	}
	
	public Money plus(Money money) {
		return Money.withMilliCents(milliCents + money.milliCents);
	}
	
	public Money inDollars() {
		return Money.withDollars(getDollars());
	}
	
	public String prettyWithCentsOnly() {
		return "" + dollarFormat(getDollars()) + "." + positiveCentFormatBetween0and99(minus(inDollars()).getCents());
	}
	
	public String prettyWithMilliCents() {
		Money remainder = minus(inDollars());
		String val = "" + dollarFormat(getDollars()) + "." + String.format("%05d", remainder.getMilliCents());
		
		return val;
	}
	
	private String positiveCentFormatBetween0and99(long cents) {
		if (cents > 9) {
			return "" + cents;
		}
		return "0" + cents;
	}
	
	private String dollarFormat(long dollars) {
		if (dollars == 0) {
			return "";
		}
		return "" + dollars;
	}
	
	public boolean lessThan(Money otherMoney) {
		return milliCents < otherMoney.milliCents;
	}
	
	public double getDoubleDollars() {
		double amount = getDollars();
		amount += (double) minus(inDollars()).getMilliCents() / 100000;
		return amount;
	}
	
	@Override
	public int compareTo(Money o) {
		return new Long(milliCents).compareTo(new Long(o.milliCents));
	}
	
	public Money divideBy(int denominator) {
		return Money.withMilliCents(milliCents / denominator);
	}
	
	public Money divideBy(double denominator) {
		return Money.withMilliCents((long) (milliCents / denominator));
	}
	
	public Money times(double multiplier) {
		return Money.withMilliCents((long) (milliCents * multiplier));
	}
	
	public Money roundToNearestCent() {
		Money cents = Money.withCents(getCents());
		Money milliCents = minus(cents);
		if (milliCents.greaterThan(Money.withMilliCents(499))) {
			return cents.plus(Money.withCents(1));
		}
		return cents;
	}
}
