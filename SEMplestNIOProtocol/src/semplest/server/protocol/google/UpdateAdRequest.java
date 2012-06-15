package semplest.server.protocol.google;

public class UpdateAdRequest
{
	private final Long adId;
	private final String newHeadline;
	private final String newDescription1;
	private final String newDescription2;
	private final String newDisplayURL;
	private final String newUrl;
	private final Integer promotionAdID;
	
	public UpdateAdRequest(Long adId, String newHeadline, String newDescription1, String newDescription2, String newDisplayURL, String newUrl, Integer promotionAdID)
	{
		this.adId = adId;
		this.newHeadline = newHeadline;
		this.newDescription1 = newDescription1;
		this.newDescription2 = newDescription2;
		this.newDisplayURL = newDisplayURL;
		this.newUrl = newUrl;
		this.promotionAdID = promotionAdID;
	}

	public Long getAdId()
	{
		return adId;
	}

	public String getNewHeadline()
	{
		return newHeadline;
	}

	public String getNewDescription1()
	{
		return newDescription1;
	}

	public String getNewDescription2()
	{
		return newDescription2;
	}

	public String getNewDisplayURL()
	{
		return newDisplayURL;
	}

	public String getNewUrl()
	{
		return newUrl;
	}

	public Integer getPromotionAdID()
	{
		return promotionAdID;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adId == null) ? 0 : adId.hashCode());
		result = prime * result + ((newDescription1 == null) ? 0 : newDescription1.hashCode());
		result = prime * result + ((newDescription2 == null) ? 0 : newDescription2.hashCode());
		result = prime * result + ((newDisplayURL == null) ? 0 : newDisplayURL.hashCode());
		result = prime * result + ((newHeadline == null) ? 0 : newHeadline.hashCode());
		result = prime * result + ((newUrl == null) ? 0 : newUrl.hashCode());
		result = prime * result + ((promotionAdID == null) ? 0 : promotionAdID.hashCode());
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
		UpdateAdRequest other = (UpdateAdRequest) obj;
		if (adId == null)
		{
			if (other.adId != null)
				return false;
		}
		else if (!adId.equals(other.adId))
			return false;
		if (newDescription1 == null)
		{
			if (other.newDescription1 != null)
				return false;
		}
		else if (!newDescription1.equals(other.newDescription1))
			return false;
		if (newDescription2 == null)
		{
			if (other.newDescription2 != null)
				return false;
		}
		else if (!newDescription2.equals(other.newDescription2))
			return false;
		if (newDisplayURL == null)
		{
			if (other.newDisplayURL != null)
				return false;
		}
		else if (!newDisplayURL.equals(other.newDisplayURL))
			return false;
		if (newHeadline == null)
		{
			if (other.newHeadline != null)
				return false;
		}
		else if (!newHeadline.equals(other.newHeadline))
			return false;
		if (newUrl == null)
		{
			if (other.newUrl != null)
				return false;
		}
		else if (!newUrl.equals(other.newUrl))
			return false;
		if (promotionAdID == null)
		{
			if (other.promotionAdID != null)
				return false;
		}
		else if (!promotionAdID.equals(other.promotionAdID))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "GoogleUpdateAdRequest [adId=" + adId + ", newHeadline=" + newHeadline + ", newDescription1=" + newDescription1 + ", newDescription2="
				+ newDescription2 + ", newDisplayURL=" + newDisplayURL + ", newUrl=" + newUrl + ", promotionAdID=" + promotionAdID + "]";
	}
	
}
