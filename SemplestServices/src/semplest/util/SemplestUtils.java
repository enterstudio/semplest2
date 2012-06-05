package semplest.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public final class SemplestUtils
{
	public static final DateFormat DATE_FORMAT_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
	public static final Long GOOGLE_MONEY_UNIT = 1000000L;
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
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
	
	public static String getEasilyReadableString(final List<?> list)
	{
		if (list == null)
		{
			return "";
		}
		int counter = 0;
		final StringBuffer sb = new StringBuffer();
		for (final Object o : list)
		{
			if (sb.length() != 0)
			{
				sb.append(LINE_SEPARATOR);
			}
			sb.append(++counter).append(": ").append(o);
		}
		return sb.toString();
	}
	
	public static String getEasilyReadableString(final Map<?, ?> m)
	{
		if (m == null)
		{
			return "";
		}
		int counter = 0;
		final StringBuffer sb = new StringBuffer();
		for (final Map.Entry<?, ?> mapEntry : m.entrySet())
		{
			if (sb.length() != 0)
			{
				sb.append(LINE_SEPARATOR);
			}
			sb.append(++counter).append(": ").append(mapEntry.getKey()).append(" -> ").append(mapEntry.getValue());
		}
		return sb.toString();
	}
}
