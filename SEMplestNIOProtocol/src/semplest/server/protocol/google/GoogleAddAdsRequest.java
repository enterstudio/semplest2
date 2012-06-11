package semplest.server.protocol.google;

import java.util.List;

import semplest.util.SemplestUtils;

public class GoogleAddAdsRequest
{
	private final String accountID;
	private final Long adGroupID;
	private final String displayURL; 
	private final String url;
	private final List<GoogleAddAdRequest> addAdTextRequests;
	
	public GoogleAddAdsRequest(String accountID, Long adGroupID, String displayURL, String url, List<GoogleAddAdRequest> addAdTextRequests)
	{
		this.accountID = accountID;
		this.adGroupID = adGroupID;
		this.displayURL = displayURL;
		this.url = url;
		this.addAdTextRequests = addAdTextRequests;
	}

	public String getAccountID()
	{
		return accountID;
	}

	public Long getAdGroupID()
	{
		return adGroupID;
	}

	public String getDisplayURL()
	{
		return displayURL;
	}

	public String getUrl()
	{
		return url;
	}

	public List<GoogleAddAdRequest> getAddAdTextRequests()
	{
		return addAdTextRequests;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountID == null) ? 0 : accountID.hashCode());
		result = prime * result + ((adGroupID == null) ? 0 : adGroupID.hashCode());
		result = prime * result + ((addAdTextRequests == null) ? 0 : addAdTextRequests.hashCode());
		result = prime * result + ((displayURL == null) ? 0 : displayURL.hashCode());
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
		GoogleAddAdsRequest other = (GoogleAddAdsRequest) obj;
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
		if (addAdTextRequests == null)
		{
			if (other.addAdTextRequests != null)
				return false;
		}
		else if (!addAdTextRequests.equals(other.addAdTextRequests))
			return false;
		if (displayURL == null)
		{
			if (other.displayURL != null)
				return false;
		}
		else if (!displayURL.equals(other.displayURL))
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
		return "GoogleAddAdsRequest [accountID=" + accountID + ", adGroupID=" + adGroupID + ", displayURL=" + displayURL + ", url=" + url
				+ ", addAdTextRequests=" + addAdTextRequests + "]";
	}
	
	public String toStringPretty()
	{
		final String textRequestsEasilyReadableString = SemplestUtils.getEasilyReadableString(addAdTextRequests);
		return "GoogleAddAdsRequest [accountID=" + accountID + ", adGroupID=" + adGroupID + ", displayURL=" + displayURL + ", url=" + url + ", addAdTextRequests...\n" + textRequestsEasilyReadableString + "]";
	}
}
