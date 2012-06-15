package semplest.server.protocol.google;

import java.util.List;

import semplest.util.SemplestUtils;

public class GoogleUpdateAdsRequest
{
	private final String accountID;
	private final Long adGroupID;
	private final List<UpdateAdRequest> updateRequests;
	
	public GoogleUpdateAdsRequest(String accountID, Long adGroupID, List<UpdateAdRequest> updateRequests)
	{
		this.accountID = accountID;
		this.adGroupID = adGroupID;
		this.updateRequests = updateRequests;
	}

	public String getAccountID()
	{
		return accountID;
	}

	public Long getAdGroupID()
	{
		return adGroupID;
	}

	public List<UpdateAdRequest> getUpdateRequests()
	{
		return updateRequests;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountID == null) ? 0 : accountID.hashCode());
		result = prime * result + ((adGroupID == null) ? 0 : adGroupID.hashCode());
		result = prime * result + ((updateRequests == null) ? 0 : updateRequests.hashCode());
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
		GoogleUpdateAdsRequest other = (GoogleUpdateAdsRequest) obj;
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
		if (updateRequests == null)
		{
			if (other.updateRequests != null)
				return false;
		}
		else if (!updateRequests.equals(other.updateRequests))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "GoogleUpdateAdsRequest [accountID=" + accountID + ", adGroupID=" + adGroupID + ", updateRequests=" + updateRequests + "]";
	}
	
	public String toStringPretty()
	{
		return "GoogleUpdateAdsRequest [accountID=" + accountID + ", adGroupID=" + adGroupID + ", updateRequests:" + SemplestUtils.getEasilyReadableString(updateRequests) + "]";
	}
}
