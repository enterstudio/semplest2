package semplest.server.protocol.google;

import semplest.util.SemplestUtils;

public class GoogleAddAdRequest
{
	private final Integer promotionAdID;
	private final String headline;
	private final String description1;
	private final String description2;
	
	public GoogleAddAdRequest(Integer promotionAdID, String headline, String description1, String description2)
	{
		this.promotionAdID = promotionAdID;
		this.headline = SemplestUtils.getTrimmedNonNullString(headline);
		this.description1 = SemplestUtils.getTrimmedNonNullString(description1);
		this.description2 = SemplestUtils.getTrimmedNonNullString(description2);
	}
	
	public Integer getPromotionAdID()
	{
		return promotionAdID;
	}

	public String getHeadline()
	{
		return headline;
	}

	public String getDescription1()
	{
		return description1;
	}

	public String getDescription2()
	{
		return description2;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description1 == null) ? 0 : description1.hashCode());
		result = prime * result + ((description2 == null) ? 0 : description2.hashCode());
		result = prime * result + ((headline == null) ? 0 : headline.hashCode());
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
		GoogleAddAdRequest other = (GoogleAddAdRequest) obj;
		if (description1 == null)
		{
			if (other.description1 != null)
				return false;
		}
		else if (!description1.equals(other.description1))
			return false;
		if (description2 == null)
		{
			if (other.description2 != null)
				return false;
		}
		else if (!description2.equals(other.description2))
			return false;
		if (headline == null)
		{
			if (other.headline != null)
				return false;
		}
		else if (!headline.equals(other.headline))
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
		return "GoogleAddAdTextRequest [promotionAdID=" + promotionAdID + ", headline=" + headline + ", description1=" + description1
				+ ", description2=" + description2 + "]";
	}

}
