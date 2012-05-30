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
}
