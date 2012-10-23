package semplest.service.keyword;

import java.util.List;

public class LuceneProviderMockImpl implements LuceneProvider
{
	private final List<String> mockSearchResults;
	
	public LuceneProviderMockImpl(final List<String> mockSearchResults)
	{
		this.mockSearchResults = mockSearchResults;	
	}
	
	public List<String> search(final String queryString, final int numResults) throws Exception
	{
		return mockSearchResults; 
	}
}
