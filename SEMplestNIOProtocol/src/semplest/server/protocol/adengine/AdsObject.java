package semplest.server.protocol.adengine;

import java.util.Comparator;

public class AdsObject
{
	private Integer PromotionAdsPK;
	private Integer PromotionFK;
	private String AdTitle;
	private String AdTextLine1;
	private String AdTextLine2;
	private Long AdEngineAdID;
	private boolean IsDeleted;
	private java.util.Date CreatedDate;
	private java.util.Date DeletedDate;
		
	public AdsObject() {}  // needed by Spring
	
	public AdsObject(Integer promotionAdsPK, Integer promotionFK, String adTitle, String adTextLine1, String adTextLine2, Long adEngineAdID, boolean isDeleted, java.util.Date createdDate, java.util.Date deletedDate)
	{
		PromotionAdsPK = promotionAdsPK;
		PromotionFK = promotionFK;
		AdTitle = adTitle;
		AdTextLine1 = adTextLine1;
		AdTextLine2 = adTextLine2;
		AdEngineAdID = adEngineAdID;
		IsDeleted = isDeleted;		
		CreatedDate = createdDate;
		DeletedDate = deletedDate;
	}
	
	public String getAdTitle()
	{
		return AdTitle;
	}
	public void setAdTitle(String adTitle)
	{
		AdTitle = adTitle;
	}
	public Integer getPromotionAdsPK()
	{
		return PromotionAdsPK;
	}
	public void setPromotionAdsPK(Integer promotionAdsPK)
	{
		PromotionAdsPK = promotionAdsPK;
	}
	public Integer getPromotionFK()
	{
		return PromotionFK;
	}
	public void setPromotionFK(Integer promotionFK)
	{
		PromotionFK = promotionFK;
	}
	public Long getAdEngineAdID()
	{
		return AdEngineAdID;
	}
	public void setAdEngineAdID(Long adEngineAdID)
	{
		AdEngineAdID = adEngineAdID;
	}
	public String getAdTextLine1()
	{
		return AdTextLine1;
	}
	public void setAdTextLine1(String adTextLine1)
	{
		AdTextLine1 = adTextLine1;
	}
	public String getAdTextLine2()
	{
		return AdTextLine2;
	}
	public void setAdTextLine2(String adTextLine2)
	{
		AdTextLine2 = adTextLine2;
	}
	
	public boolean isIsDeleted()
	{
		return IsDeleted;
	}

	public void setIsDeleted(boolean isDeleted)
	{
		IsDeleted = isDeleted;
	}

	public java.util.Date getCreatedDate()
	{
		return CreatedDate;
	}

	public void setCreatedDate(java.util.Date createdDate)
	{
		CreatedDate = createdDate;
	}

	public java.util.Date getDeletedDate()
	{
		return DeletedDate;
	}

	public void setDeletedDate(java.util.Date deletedDate)
	{
		DeletedDate = deletedDate;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AdEngineAdID == null) ? 0 : AdEngineAdID.hashCode());
		result = prime * result + ((AdTextLine1 == null) ? 0 : AdTextLine1.hashCode());
		result = prime * result + ((AdTextLine2 == null) ? 0 : AdTextLine2.hashCode());
		result = prime * result + ((AdTitle == null) ? 0 : AdTitle.hashCode());
		result = prime * result + ((CreatedDate == null) ? 0 : CreatedDate.hashCode());
		result = prime * result + ((DeletedDate == null) ? 0 : DeletedDate.hashCode());
		result = prime * result + (IsDeleted ? 1231 : 1237);
		result = prime * result + ((PromotionAdsPK == null) ? 0 : PromotionAdsPK.hashCode());
		result = prime * result + ((PromotionFK == null) ? 0 : PromotionFK.hashCode());
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
		AdsObject other = (AdsObject) obj;
		if (AdEngineAdID == null)
		{
			if (other.AdEngineAdID != null)
				return false;
		}
		else if (!AdEngineAdID.equals(other.AdEngineAdID))
			return false;
		if (AdTextLine1 == null)
		{
			if (other.AdTextLine1 != null)
				return false;
		}
		else if (!AdTextLine1.equals(other.AdTextLine1))
			return false;
		if (AdTextLine2 == null)
		{
			if (other.AdTextLine2 != null)
				return false;
		}
		else if (!AdTextLine2.equals(other.AdTextLine2))
			return false;
		if (AdTitle == null)
		{
			if (other.AdTitle != null)
				return false;
		}
		else if (!AdTitle.equals(other.AdTitle))
			return false;
		if (CreatedDate == null)
		{
			if (other.CreatedDate != null)
				return false;
		}
		else if (!CreatedDate.equals(other.CreatedDate))
			return false;
		if (DeletedDate == null)
		{
			if (other.DeletedDate != null)
				return false;
		}
		else if (!DeletedDate.equals(other.DeletedDate))
			return false;
		if (IsDeleted != other.IsDeleted)
			return false;
		if (PromotionAdsPK == null)
		{
			if (other.PromotionAdsPK != null)
				return false;
		}
		else if (!PromotionAdsPK.equals(other.PromotionAdsPK))
			return false;
		if (PromotionFK == null)
		{
			if (other.PromotionFK != null)
				return false;
		}
		else if (!PromotionFK.equals(other.PromotionFK))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "AdsObject [PromotionAdsPK=" + PromotionAdsPK + ", PromotionFK=" + PromotionFK + ", AdTitle=" + AdTitle + ", AdTextLine1="
				+ AdTextLine1 + ", AdTextLine2=" + AdTextLine2 + ", AdEngineAdID=" + AdEngineAdID + ", IsDeleted=" + IsDeleted + ", CreatedDate="
				+ CreatedDate + ", DeletedDate=" + DeletedDate + "]";
	}

	/**
	 * Sorts in descending order of AdEngineAdID
	 */
	public static Comparator<AdsObject> AD_ENGINE_AD_ID_COMPARATOR = new Comparator<AdsObject>() 
	{
		@Override
		public int compare(final AdsObject ad1, final AdsObject ad2)
		{
			final Long adEngineAdId1 = ad1.getAdEngineAdID();
			final Long adEngineAdId2 = ad2.getAdEngineAdID();
			if (adEngineAdId1 == null && adEngineAdId2 == null)
			{
				return 0;
			}
			else if (adEngineAdId1 != null && adEngineAdId2 == null)
			{
				return -1;
			}
			else if (adEngineAdId1 == null && adEngineAdId2 != null)
			{
				return 1;
			}
			return adEngineAdId2.compareTo(adEngineAdId1);
		}		
	};
}
