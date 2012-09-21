package semplest.service.keyword;

import java.util.Properties;

public abstract class KeywordPropertiesAbstractImpl implements KeywordProperties
{
	private Integer numMinimumWords;
	private Integer numTargetCategories;
	private String luceneDirectory;
	private String dmozDescriptionFile;
	private String log4jPropertyFile;
	
	protected void initialize(final Properties properties)
	{
		final String numMinimumWordsString = properties.getProperty("NUM_MINIMUM_WORDS");
		numMinimumWords = Integer.valueOf(numMinimumWordsString);
		final String numTargetCategoriesString = properties.getProperty("TARGET_NUM_CATEGORIES");
		numTargetCategories = Integer.valueOf(numTargetCategoriesString);
		luceneDirectory = properties.getProperty("LUCENE_DIRECTORY");
		dmozDescriptionFile = properties.getProperty("DMOZ_DESCRIPTION_FILE");	
		log4jPropertyFile = properties.getProperty("LOG4J_PROPERTY_FILE");
	}

	public Integer getNumMinimumWords()
	{
		return numMinimumWords;
	}

	public String getLuceneDirectory()
	{
		return luceneDirectory;
	}
	
	public String getLog4jPropertyFile()
	{
		return log4jPropertyFile;
	}

	public String getDmozDescriptionFile()
	{
		return dmozDescriptionFile;
	}
	
	public Integer getTargetNumCategories()
	{
		return numTargetCategories;
	}
	
}
