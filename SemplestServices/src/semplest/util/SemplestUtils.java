package semplest.util;

public final class SemplestUtils
{
	public static final Long GOOGLE_MONEY_UNIT = 1000000L;
	
	public static final String getTrimmedNonNullString(final String s)
	{
		if (s == null) 
		{
			return "";
		}
		else
		{
			return s.trim();
		}
	}
}
