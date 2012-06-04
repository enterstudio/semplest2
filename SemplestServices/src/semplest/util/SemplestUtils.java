package semplest.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class SemplestUtils
{
	public static final DateFormat DATE_FORMAT_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
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
