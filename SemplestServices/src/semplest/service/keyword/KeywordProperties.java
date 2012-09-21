package semplest.service.keyword;

public interface KeywordProperties
{
	public Integer getNumMinimumWords();
	public Integer getTargetNumCategories();
	public String getLuceneDirectory();
	public String getDmozDescriptionFile();
	public String getLog4jPropertyFile();
}
