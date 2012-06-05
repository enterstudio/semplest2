package semplest.server.protocol.google;

public class GoogleSiteLink
{

	private String LinkText;
	private String LinkURL;
	
	public GoogleSiteLink() {} // needed by spring
	
	public GoogleSiteLink(String linkText, String linkURL)
	{
		LinkText = linkText;
		LinkURL = linkURL;
	}

	public String getLinkText()
	{
		return LinkText;
	}
	public void setLinkText(String linkText)
	{
		LinkText = linkText;
	}
	public String getLinkURL()
	{
		return LinkURL;
	}
	public void setLinkURL(String linkURL)
	{
		LinkURL = linkURL;
	}
		
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LinkText == null) ? 0 : LinkText.hashCode());
		result = prime * result + ((LinkURL == null) ? 0 : LinkURL.hashCode());
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
		GoogleSiteLink other = (GoogleSiteLink) obj;
		if (LinkText == null)
		{
			if (other.LinkText != null)
				return false;
		}
		else if (!LinkText.equals(other.LinkText))
			return false;
		if (LinkURL == null)
		{
			if (other.LinkURL != null)
				return false;
		}
		else if (!LinkURL.equals(other.LinkURL))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "GoogleSiteLink [LinkText=" + LinkText + ", LinkURL=" + LinkURL + "]";
	}
	
	
}
