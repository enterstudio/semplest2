package semplest.server.protocol.adengine;

public class SiteLink
{
	private Integer SiteLinkPK;
	private Integer PromotionFK;
	private String LinkText;
	private String LinkURL;
	
	public Integer getSiteLinkPK()
	{
		return SiteLinkPK;
	}
	public void setSiteLinkPK(Integer siteLinkPK)
	{
		SiteLinkPK = siteLinkPK;
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
		result = prime * result + ((PromotionFK == null) ? 0 : PromotionFK.hashCode());
		result = prime * result + ((SiteLinkPK == null) ? 0 : SiteLinkPK.hashCode());
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
		SiteLink other = (SiteLink) obj;
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
		if (PromotionFK == null)
		{
			if (other.PromotionFK != null)
				return false;
		}
		else if (!PromotionFK.equals(other.PromotionFK))
			return false;
		if (SiteLinkPK == null)
		{
			if (other.SiteLinkPK != null)
				return false;
		}
		else if (!SiteLinkPK.equals(other.SiteLinkPK))
			return false;
		return true;
	}
	@Override
	public String toString()
	{
		return "SiteLink [SiteLinkPK=" + SiteLinkPK + ", PromotionAdsFK=" + PromotionFK + ", LinkText=" + LinkText + ", LinkURL=" + LinkURL + "]";
	}
	public Integer getPromotionFK()
	{
		return PromotionFK;
	}
	public void setPromotionFK(Integer promotionFK)
	{
		PromotionFK = promotionFK;
	}
	
}
