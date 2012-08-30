package semplest.server.protocol;

import java.util.List;

public class DmozEntry
{
	private final List<String> levelNames;
	private Long id;
	private List<String> urls;
	private String description;
	
	public DmozEntry(List<String> levelNames)
	{
		this.levelNames = levelNames;
	}
	
	public DmozEntry(List<String> levelNames, Long id, List<String> urls, String description)
	{
		this.levelNames = levelNames;
		this.id = id;
		this.urls = urls;
		this.description = description;
	}

	public List<String> getLevelNames()
	{
		return levelNames;
	}

	public Long getId()
	{
		return id;
	}

	public List<String> getUrls()
	{
		return urls;
	}

	public String getDescription()
	{
		return description;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}

	public void setUrls(List<String> urls)
	{
		this.urls = urls;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((levelNames == null) ? 0 : levelNames.hashCode());
		result = prime * result + ((urls == null) ? 0 : urls.hashCode());
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
		DmozEntry other = (DmozEntry) obj;
		if (description == null)
		{
			if (other.description != null)
				return false;
		}
		else if (!description.equals(other.description))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		if (levelNames == null)
		{
			if (other.levelNames != null)
				return false;
		}
		else if (!levelNames.equals(other.levelNames))
			return false;
		if (urls == null)
		{
			if (other.urls != null)
				return false;
		}
		else if (!urls.equals(other.urls))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "DmozEntry [levelNames=" + levelNames + ", id=" + id + ", urls=" + urls + ", description=" + description + "]";
	}
	
}
