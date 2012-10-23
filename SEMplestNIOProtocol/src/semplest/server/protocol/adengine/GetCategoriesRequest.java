package semplest.server.protocol.adengine;

import java.util.Set;

public class GetCategoriesRequest
{
	private final Set<String> relevantTerms;

	public GetCategoriesRequest(Set<String> relevantTerms)
	{
		this.relevantTerms = relevantTerms;
	}

	public Set<String> getRelevantTerms()
	{
		return relevantTerms;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((relevantTerms == null) ? 0 : relevantTerms.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GetCategoriesRequest other = (GetCategoriesRequest) obj;
		if (relevantTerms == null)
		{
			if (other.relevantTerms != null)
				return false;
		}
		else if (!relevantTerms.equals(other.relevantTerms))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "GetCategoriesRequest [relevantTerms=" + relevantTerms + "]";
	}
	
}
