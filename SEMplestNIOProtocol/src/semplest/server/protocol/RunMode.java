package semplest.server.protocol;

import java.util.Arrays;
import java.util.List;

public enum RunMode
{
	DEVELOPMENT ("DEV"), 
	TEST ("TEST"),
	UAT ("UAT"),  
	PRODUCTION ("PRODUCTION");
	
	private final String name;
	
	RunMode(final String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}

	public static RunMode fromName(final String name)
	{
		final RunMode[] runModes = RunMode.values();
		for (final RunMode runMode : runModes)
		{
			if (runMode.getName().equals(name))
			{
				return runMode;
			}
		}
		return null;
	}
	
	public static List<RunMode> getValidRunModes()
	{
		final RunMode[] runModes = RunMode.values();
		return Arrays.asList(runModes);
	}
		
}
