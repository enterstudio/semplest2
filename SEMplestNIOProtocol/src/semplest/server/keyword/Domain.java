package semplest.server.keyword;

import java.io.Serializable;
import java.util.List;

public class Domain implements Serializable
{
	private static final long serialVersionUID = -4057437433053258600L;
	
	private final int pk;
	private final String domain;
	private List<UrlData> urlDatas;
	
	public Domain(int pk, String domain, List<UrlData> urlDatas)
	{
		this.pk = pk;
		this.domain = domain;
		this.urlDatas = urlDatas;
	}
	
	public Domain(int pk, String domain)
	{
		this.pk = pk;
		this.domain = domain;
	}
	
	public List<UrlData> getUrlDatas()
	{
		return urlDatas;
	}

	public void setUrlDatas(List<UrlData> urlDatas)
	{
		this.urlDatas = urlDatas;
	}

	public int getPk()
	{
		return pk;
	}

	public String getDomain()
	{
		return domain;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + pk;
		result = prime * result + ((urlDatas == null) ? 0 : urlDatas.hashCode());
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
		Domain other = (Domain) obj;
		if (domain == null)
		{
			if (other.domain != null)
				return false;
		}
		else if (!domain.equals(other.domain))
			return false;
		if (pk != other.pk)
			return false;
		if (urlDatas == null)
		{
			if (other.urlDatas != null)
				return false;
		}
		else if (!urlDatas.equals(other.urlDatas))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Domain [pk=" + pk + ", domain=" + domain + ", urlDatas=" + urlDatas + "]";
	}

		
}
