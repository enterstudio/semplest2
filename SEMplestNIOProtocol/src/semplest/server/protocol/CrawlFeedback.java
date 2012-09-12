package semplest.server.protocol;

public class CrawlFeedback
{
	private final String url;
	private final String content;
	private final String feedback;
	
	public CrawlFeedback(String url, String content, String feedback)
	{
		this.url = url;
		this.content = content;
		this.feedback = feedback;
	}

	public String getUrl()
	{
		return url;
	}

	public String getContent()
	{
		return content;
	}

	public String getFeedback()
	{
		return feedback;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((feedback == null) ? 0 : feedback.hashCode());
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
		CrawlFeedback other = (CrawlFeedback) obj;
		if (content == null)
		{
			if (other.content != null)
				return false;
		}
		else if (!content.equals(other.content))
			return false;
		if (feedback == null)
		{
			if (other.feedback != null)
				return false;
		}
		else if (!feedback.equals(other.feedback))
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
		return "CrawlFeedback [url=" + url + ", content=" + content + ", feedback=" + feedback + "]";
	}
	
}
