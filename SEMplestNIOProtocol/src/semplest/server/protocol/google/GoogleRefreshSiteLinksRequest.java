package semplest.server.protocol.google;

import java.util.List;

import semplest.util.SemplestUtils;

public class GoogleRefreshSiteLinksRequest
{
	private final String accountID;
	private final Long campaignID;
	private final List<GoogleSiteLink> siteLinks;
	
	public GoogleRefreshSiteLinksRequest(String accountID, Long campaignID, List<GoogleSiteLink> siteLinks)
	{
		this.accountID = accountID;
		this.campaignID = campaignID;
		this.siteLinks = siteLinks;
	}

	public String getAccountID()
	{
		return accountID;
	}

	public Long getCampaignID()
	{
		return campaignID;
	}
		
	public List<GoogleSiteLink> getSiteLinks()
	{
		return siteLinks;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountID == null) ? 0 : accountID.hashCode());
		result = prime * result + ((campaignID == null) ? 0 : campaignID.hashCode());
		result = prime * result + ((siteLinks == null) ? 0 : siteLinks.hashCode());
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
		GoogleRefreshSiteLinksRequest other = (GoogleRefreshSiteLinksRequest) obj;
		if (accountID == null)
		{
			if (other.accountID != null)
				return false;
		}
		else if (!accountID.equals(other.accountID))
			return false;
		if (campaignID == null)
		{
			if (other.campaignID != null)
				return false;
		}
		else if (!campaignID.equals(other.campaignID))
			return false;
		if (siteLinks == null)
		{
			if (other.siteLinks != null)
				return false;
		}
		else if (!siteLinks.equals(other.siteLinks))
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "GoogleRefreshSiteLinksRequest [accountID=" + accountID + ", campaignID=" + campaignID + ", siteLinks=" + siteLinks + "]";
	}

	public String toStringPretty()
	{
		return "GoogleRefreshSiteLinksRequest [accountID=" + accountID + ", campaignID=" + campaignID + ", siteLinks:\n" + SemplestUtils.getEasilyReadableString(siteLinks) + "]";
	}
}
