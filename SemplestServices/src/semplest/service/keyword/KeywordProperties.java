package semplest.service.keyword;

import java.util.List;

public interface KeywordProperties
{
	Integer getNumMinimumWords();
	Integer getTargetNumCategories();
	Integer getTargetNumKeywords();	
	String getLuceneDirectory();
	String getDmozDescriptionFile();
	String getLog4jPropertyFile();
	List<String> getValidCategoryTypes();
}
