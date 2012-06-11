package semplest.util;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.google.api.adwords.v201109.cm.TextAd;
import com.google.gson.reflect.TypeToken;

public final class SemplestUtils
{
	public static final DateFormat DATE_FORMAT_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
	public static final DateFormat DATE_FORMAT_YYYYMMDD_HHmmss = new SimpleDateFormat("yyyyMMdd HHmmss");
	public static final Long GOOGLE_MONEY_UNIT = 1000000L;
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	public static final Type TYPE_LIST_OF_STRINGS = new TypeToken<List<String>>(){}.getType();
	public static final Type TYPE_LIST_OF_INTEGERS = new TypeToken<List<Integer>>(){}.getType();
	public static final Type TYPE_LIST_OF_LONGS = new TypeToken<List<Long>>(){}.getType();
	public static final Type TYPE_MAP_OF_STRING_TO_STRING = new TypeToken<Map<String, String>>(){}.getType();
	
	public static final String getTextAdString(final TextAd textAd)
	{
		final Long id = textAd.getId();
		final String desciption1 = textAd.getDescription1();
		final String desciption2 = textAd.getDescription2();
		final String headline = textAd.getHeadline();
		final String displayUrl = textAd.getDisplayUrl();
		final String url = textAd.getUrl();
		return "TextAd[id=" + id + ",desciption1=" + desciption1 + ",desciption2=" + desciption2 + ",headline=" + headline + ",displayUrl=" + displayUrl + ",url=" + url + "]";
	}
	
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
