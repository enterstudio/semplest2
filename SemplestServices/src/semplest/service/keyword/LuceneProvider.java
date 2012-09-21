package semplest.service.keyword;

import java.util.List;

public interface LuceneProvider
{
	List<String> search(String queryString, int numResults) throws Exception;
}
