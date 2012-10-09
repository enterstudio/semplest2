package semplest.server.keyword;

import java.io.Serializable;

public class UrlData implements Serializable
{
	private static final long serialVersionUID = 1915773927221597705L;
	
	private final int pk;
	private final String url;
	private final String description;
	private final int domainFk;
	
	public UrlData(int pk, String url, String description, int domainFk)
	{
		this.pk = pk;
		this.url = url;
		this.description = description;
		this.domainFk = domainFk;
	}

	public int getPk()
	{
		return pk;
	}

	public String getUrl()
	{
		return url;
	}

	public String getDescription()
	{
		return description;
	}

	public int getDomainFk()
	{
		return domainFk;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + domainFk;
		result = prime * result + pk;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		UrlData other = (UrlData) obj;
		if (description == null)
		{
			if (other.description != null)
				return false;
		}
		else if (!description.equals(other.description))
			return false;
		if (domainFk != other.domainFk)
			return false;
		if (pk != other.pk)
			return false;
		if (url == null)
		{
			if (other.url != null)
				return false;
		}
		else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "UrlData [pk=" + pk + ", url=" + url + ", description=" + description + ", domainFk=" + domainFk + "]";
	}
	
}
