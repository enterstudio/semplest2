package semplest.service.keyword;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class KeywordPropertiesImpl extends KeywordPropertiesAbstractImpl
{
	public KeywordPropertiesImpl() throws Exception
	{
		final Properties properties = new Properties();
		final String propertiesFileName = "properties/KeywordService.properties";
		try
		{			
			final InputStream inputStream = new FileInputStream(propertiesFileName);
			properties.load(inputStream);
		}
		catch(IOException e)
		{
			throw new Exception("Problem initializing properties from file [" + propertiesFileName + "]");
		}
		initialize(properties);
	}
		
}
