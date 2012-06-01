package semplest.util;

public final class SemplestUtils
{
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
