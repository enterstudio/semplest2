package semplest.server.protocol.adengine;

public class AdEngineID
{
	private Long accountID;
	private Long campaignID;
	private Long adGroupID;
	public Long getAccountID()
	{
		return accountID;
	}
	public void setAccountID(Long accountID)
	{
		this.accountID = accountID;
	}
	public Long getCampaignID()
	{
		return campaignID;
	}
	public void setCampaignID(Long campaignID)
	{
		this.campaignID = campaignID;
	}
	public Long getAdGroupID()
	{
		return adGroupID;
	}
	public void setAdGroupID(Long adGroupID)
	{
		this.adGroupID = adGroupID;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountID == null) ? 0 : accountID.hashCode());
		result = prime * result + ((adGroupID == null) ? 0 : adGroupID.hashCode());
		result = prime * result + ((campaignID == null) ? 0 : campaignID.hashCode());
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
		AdEngineID other = (AdEngineID) obj;
		if (accountID == null)
		{
			if (other.accountID != null)
				return false;
		}
		else if (!accountID.equals(other.accountID))
			return false;
		if (adGroupID == null)
		{
			if (other.adGroupID != null)
				return false;
		}
		else if (!adGroupID.equals(other.adGroupID))
			return false;
		if (campaignID == null)
		{
			if (other.campaignID != null)
				return false;
		}
		else if (!campaignID.equals(other.campaignID))
			return false;
		return true;
	}
	@Override
	public String toString()
	{
		return "AdEngineID [accountID=" + accountID + ", campaignID=" + campaignID + ", adGroupID=" + adGroupID + "]";
	}
	
	
}
