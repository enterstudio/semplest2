package semplest.server.protocol.adengine;

public enum SemplestCampaignStatus
{
	ACTIVE(com.google.api.adwords.v201109.cm.CampaignStatus.ACTIVE, com.microsoft.adcenter.v8.CampaignStatus.Active), 
	PAUSED(com.google.api.adwords.v201109.cm.CampaignStatus.PAUSED, com.microsoft.adcenter.v8.CampaignStatus.Paused);
	
	private final com.google.api.adwords.v201109.cm.CampaignStatus googleCampaignStatus;
	private final com.microsoft.adcenter.v8.CampaignStatus msnCampaignStatus;
	
	SemplestCampaignStatus(final com.google.api.adwords.v201109.cm.CampaignStatus googleCampaignStatus, com.microsoft.adcenter.v8.CampaignStatus msnCampaignStatus)
	{
		this.googleCampaignStatus = googleCampaignStatus;
		this.msnCampaignStatus = msnCampaignStatus;
	}
	
	public com.google.api.adwords.v201109.cm.CampaignStatus getGoogleCampaignStatus()
	{
		return googleCampaignStatus;
	}
	
	public com.microsoft.adcenter.v8.CampaignStatus getMsnCampaignStatus()
	{
		return msnCampaignStatus;
	}
}
