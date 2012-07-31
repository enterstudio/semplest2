package semplest.server.service.springjdbc;

import java.util.Date;

public class PromotionObj
{
	/*
	 * p.PromotionPK,p.ProductGroupFK,p.PromotionName,p.PromotionDescription,p.LandingPageURL,
		p.PromotionBudgetAmount,p.PromotionStartDate, p.PromotionEndDate,bc.BudgetCycle,
		p.BudgetToAddToNextCycle,p.CycleStartDate,
		p.RemainingBudgetInCycle,p.StartBudgetInCycle,
		p.EditedDate, p.IsLaunched, p.IsCompleted,p.IsPaused,p.CreatedDate 
	 */
	private Integer PromotionPK;
	private Integer ProductGroupFK;
	private String PromotionName;
	private String PromotionDescription;
	private String LandingPageURL;
	private String DisplayURL;	
	private Double PromotionBudgetAmount;
	private Date PromotionStartDate;
	private Date PromotionEndDate;
	private String BudgetCycle;
	//private Double BudgetToAddToNextCycle;
	private Date CycleStartDate;
	private Double RemainingBudgetInCycle;
	private Double StartBudgetInCycle;
	private Date EditedDate;
	private Boolean isLaunched; 
	private Boolean isCompleted;
	private Boolean isPaused;
	private Date CreatedDate;
	private Long AdvertisingEngineCampaignPK;
	private Long AdvertisingEngineAdGroupID;
	private Long AdvertisingEngineAccountPK; 
	private String AdvertisingEngine;
	private String AdvertisingEngineAccountNumber;
	
	public String getDisplayURL()
	{
		return DisplayURL;
	}
	public void setDisplayURL(String displayURL)
	{
		DisplayURL = displayURL;
	}
	public Integer getPromotionPK()
	{
		return PromotionPK;
	}
	public void setPromotionPK(Integer promotionPK)
	{
		PromotionPK = promotionPK;
	}
	public Integer getProductGroupFK()
	{
		return ProductGroupFK;
	}
	public void setProductGroupFK(Integer productGroupFK)
	{
		ProductGroupFK = productGroupFK;
	}
	public String getPromotionName()
	{
		return PromotionName;
	}
	public void setPromotionName(String promotionName)
	{
		PromotionName = promotionName;
	}
	public String getPromotionDescription()
	{
		return PromotionDescription;
	}
	public void setPromotionDescription(String promotionDescription)
	{
		PromotionDescription = promotionDescription;
	}
	public Double getPromotionBudgetAmount()
	{
		return PromotionBudgetAmount;
	}
	public void setPromotionBudgetAmount(Double promotionBudgetAmount)
	{
		PromotionBudgetAmount = promotionBudgetAmount;
	}
	public Date getPromotionStartDate()
	{
		return PromotionStartDate;
	}
	public void setPromotionStartDate(Date promotionStartDate)
	{
		PromotionStartDate = promotionStartDate;
	}
	public Date getPromotionEndDate()
	{
		return PromotionEndDate;
	}
	public void setPromotionEndDate(Date promotionEndDate)
	{
		PromotionEndDate = promotionEndDate;
	}
	public String getBudgetCycle()
	{
		return BudgetCycle;
	}
	public void setBudgetCycle(String budgetCycle)
	{
		BudgetCycle = budgetCycle;
	}
	/*
	public Double getBudgetToAddToNextCycle()
	{
		return BudgetToAddToNextCycle;
	}
	public void setBudgetToAddToNextCycle(Double budgetToAddToNextCycle)
	{
		BudgetToAddToNextCycle = budgetToAddToNextCycle;
	}
	*/
	public Date getCycleStartDate()
	{
		return CycleStartDate;
	}
	public void setCycleStartDate(Date cycleStartDate)
	{
		CycleStartDate = cycleStartDate;
	}
	public Double getRemainingBudgetInCycle()
	{
		return RemainingBudgetInCycle;
	}
	public void setRemainingBudgetInCycle(Double remainingBudgetInCycle)
	{
		RemainingBudgetInCycle = remainingBudgetInCycle;
	}
	public Double getStartBudgetInCycle()
	{
		return StartBudgetInCycle;
	}
	public void setStartBudgetInCycle(Double startBudgetInCycle)
	{
		StartBudgetInCycle = startBudgetInCycle;
	}
	public Date getEditedDate()
	{
		return EditedDate;
	}
	public void setEditedDate(Date editedDate)
	{
		EditedDate = editedDate;
	}
	public Boolean getIsLaunched()
	{
		return isLaunched;
	}
	public void setIsLaunched(Boolean isLaunched)
	{
		this.isLaunched = isLaunched;
	}
	public Boolean getIsCompleted()
	{
		return isCompleted;
	}
	public void setIsCompleted(Boolean isCompleted)
	{
		this.isCompleted = isCompleted;
	}
	public Boolean getIsPaused()
	{
		return isPaused;
	}
	public void setIsPaused(Boolean isPaused)
	{
		this.isPaused = isPaused;
	}
	public Date getCreatedDate()
	{
		return CreatedDate;
	}
	public void setCreatedDate(Date createdDate)
	{
		CreatedDate = createdDate;
	}
	public String getLandingPageURL()
	{
		return LandingPageURL;
	}
	public void setLandingPageURL(String landingPageURL)
	{
		LandingPageURL = landingPageURL;
	}
	
	public Long getAdvertisingEngineCampaignPK()
	{
		return AdvertisingEngineCampaignPK;
	}
	public void setAdvertisingEngineCampaignPK(Long advertisingEngineCampaignPK)
	{
		AdvertisingEngineCampaignPK = advertisingEngineCampaignPK;
	}
	public Long getAdvertisingEngineAdGroupID()
	{
		return AdvertisingEngineAdGroupID;
	}
	public void setAdvertisingEngineAdGroupID(Long advertisingEngineAdGroupID)
	{
		AdvertisingEngineAdGroupID = advertisingEngineAdGroupID;
	}
	public Long getAdvertisingEngineAccountPK()
	{
		return AdvertisingEngineAccountPK;
	}
	public void setAdvertisingEngineAccountPK(Long advertisingEngineAccountPK)
	{
		AdvertisingEngineAccountPK = advertisingEngineAccountPK;
	}
	
	public String getAdvertisingEngine()
	{
		return AdvertisingEngine;
	}
	public void setAdvertisingEngine(String advertisingEngine)
	{
		AdvertisingEngine = advertisingEngine;
	}
	public String getAdvertisingEngineAccountNumber()
	{
		return AdvertisingEngineAccountNumber;
	}
	public void setAdvertisingEngineAccountNumber(String advertisingEngineAccountNumber)
	{
		AdvertisingEngineAccountNumber = advertisingEngineAccountNumber;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AdvertisingEngine == null) ? 0 : AdvertisingEngine.hashCode());
		result = prime * result + ((AdvertisingEngineAccountNumber == null) ? 0 : AdvertisingEngineAccountNumber.hashCode());
		result = prime * result + ((AdvertisingEngineAccountPK == null) ? 0 : AdvertisingEngineAccountPK.hashCode());
		result = prime * result + ((AdvertisingEngineAdGroupID == null) ? 0 : AdvertisingEngineAdGroupID.hashCode());
		result = prime * result + ((AdvertisingEngineCampaignPK == null) ? 0 : AdvertisingEngineCampaignPK.hashCode());
		result = prime * result + ((BudgetCycle == null) ? 0 : BudgetCycle.hashCode());
		result = prime * result + ((CreatedDate == null) ? 0 : CreatedDate.hashCode());
		result = prime * result + ((CycleStartDate == null) ? 0 : CycleStartDate.hashCode());
		result = prime * result + ((DisplayURL == null) ? 0 : DisplayURL.hashCode());
		result = prime * result + ((EditedDate == null) ? 0 : EditedDate.hashCode());
		result = prime * result + ((LandingPageURL == null) ? 0 : LandingPageURL.hashCode());
		result = prime * result + ((ProductGroupFK == null) ? 0 : ProductGroupFK.hashCode());
		result = prime * result + ((PromotionBudgetAmount == null) ? 0 : PromotionBudgetAmount.hashCode());
		result = prime * result + ((PromotionDescription == null) ? 0 : PromotionDescription.hashCode());
		result = prime * result + ((PromotionEndDate == null) ? 0 : PromotionEndDate.hashCode());
		result = prime * result + ((PromotionName == null) ? 0 : PromotionName.hashCode());
		result = prime * result + ((PromotionPK == null) ? 0 : PromotionPK.hashCode());
		result = prime * result + ((PromotionStartDate == null) ? 0 : PromotionStartDate.hashCode());
		result = prime * result + ((RemainingBudgetInCycle == null) ? 0 : RemainingBudgetInCycle.hashCode());
		result = prime * result + ((StartBudgetInCycle == null) ? 0 : StartBudgetInCycle.hashCode());
		result = prime * result + ((isCompleted == null) ? 0 : isCompleted.hashCode());
		result = prime * result + ((isLaunched == null) ? 0 : isLaunched.hashCode());
		result = prime * result + ((isPaused == null) ? 0 : isPaused.hashCode());
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
		PromotionObj other = (PromotionObj) obj;
		if (AdvertisingEngine == null)
		{
			if (other.AdvertisingEngine != null)
				return false;
		}
		else if (!AdvertisingEngine.equals(other.AdvertisingEngine))
			return false;
		if (AdvertisingEngineAccountNumber == null)
		{
			if (other.AdvertisingEngineAccountNumber != null)
				return false;
		}
		else if (!AdvertisingEngineAccountNumber.equals(other.AdvertisingEngineAccountNumber))
			return false;
		if (AdvertisingEngineAccountPK == null)
		{
			if (other.AdvertisingEngineAccountPK != null)
				return false;
		}
		else if (!AdvertisingEngineAccountPK.equals(other.AdvertisingEngineAccountPK))
			return false;
		if (AdvertisingEngineAdGroupID == null)
		{
			if (other.AdvertisingEngineAdGroupID != null)
				return false;
		}
		else if (!AdvertisingEngineAdGroupID.equals(other.AdvertisingEngineAdGroupID))
			return false;
		if (AdvertisingEngineCampaignPK == null)
		{
			if (other.AdvertisingEngineCampaignPK != null)
				return false;
		}
		else if (!AdvertisingEngineCampaignPK.equals(other.AdvertisingEngineCampaignPK))
			return false;
		if (BudgetCycle == null)
		{
			if (other.BudgetCycle != null)
				return false;
		}
		else if (!BudgetCycle.equals(other.BudgetCycle))
			return false;
		if (CreatedDate == null)
		{
			if (other.CreatedDate != null)
				return false;
		}
		else if (!CreatedDate.equals(other.CreatedDate))
			return false;
		if (CycleStartDate == null)
		{
			if (other.CycleStartDate != null)
				return false;
		}
		else if (!CycleStartDate.equals(other.CycleStartDate))
			return false;
		if (DisplayURL == null)
		{
			if (other.DisplayURL != null)
				return false;
		}
		else if (!DisplayURL.equals(other.DisplayURL))
			return false;
		if (EditedDate == null)
		{
			if (other.EditedDate != null)
				return false;
		}
		else if (!EditedDate.equals(other.EditedDate))
			return false;
		if (LandingPageURL == null)
		{
			if (other.LandingPageURL != null)
				return false;
		}
		else if (!LandingPageURL.equals(other.LandingPageURL))
			return false;
		if (ProductGroupFK == null)
		{
			if (other.ProductGroupFK != null)
				return false;
		}
		else if (!ProductGroupFK.equals(other.ProductGroupFK))
			return false;
		if (PromotionBudgetAmount == null)
		{
			if (other.PromotionBudgetAmount != null)
				return false;
		}
		else if (!PromotionBudgetAmount.equals(other.PromotionBudgetAmount))
			return false;
		if (PromotionDescription == null)
		{
			if (other.PromotionDescription != null)
				return false;
		}
		else if (!PromotionDescription.equals(other.PromotionDescription))
			return false;
		if (PromotionEndDate == null)
		{
			if (other.PromotionEndDate != null)
				return false;
		}
		else if (!PromotionEndDate.equals(other.PromotionEndDate))
			return false;
		if (PromotionName == null)
		{
			if (other.PromotionName != null)
				return false;
		}
		else if (!PromotionName.equals(other.PromotionName))
			return false;
		if (PromotionPK == null)
		{
			if (other.PromotionPK != null)
				return false;
		}
		else if (!PromotionPK.equals(other.PromotionPK))
			return false;
		if (PromotionStartDate == null)
		{
			if (other.PromotionStartDate != null)
				return false;
		}
		else if (!PromotionStartDate.equals(other.PromotionStartDate))
			return false;
		if (RemainingBudgetInCycle == null)
		{
			if (other.RemainingBudgetInCycle != null)
				return false;
		}
		else if (!RemainingBudgetInCycle.equals(other.RemainingBudgetInCycle))
			return false;
		if (StartBudgetInCycle == null)
		{
			if (other.StartBudgetInCycle != null)
				return false;
		}
		else if (!StartBudgetInCycle.equals(other.StartBudgetInCycle))
			return false;
		if (isCompleted == null)
		{
			if (other.isCompleted != null)
				return false;
		}
		else if (!isCompleted.equals(other.isCompleted))
			return false;
		if (isLaunched == null)
		{
			if (other.isLaunched != null)
				return false;
		}
		else if (!isLaunched.equals(other.isLaunched))
			return false;
		if (isPaused == null)
		{
			if (other.isPaused != null)
				return false;
		}
		else if (!isPaused.equals(other.isPaused))
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "PromotionObj [PromotionPK=" + PromotionPK + ", ProductGroupFK=" + ProductGroupFK + ", PromotionName=" + PromotionName + ", PromotionDescription=" + PromotionDescription + ", LandingPageURL=" + LandingPageURL + ", DisplayURL=" + DisplayURL + ", PromotionBudgetAmount="
				+ PromotionBudgetAmount + ", PromotionStartDate=" + PromotionStartDate + ", PromotionEndDate=" + PromotionEndDate + ", BudgetCycle=" + BudgetCycle + ", CycleStartDate=" + CycleStartDate + ", RemainingBudgetInCycle=" + RemainingBudgetInCycle + ", StartBudgetInCycle="
				+ StartBudgetInCycle + ", EditedDate=" + EditedDate + ", isLaunched=" + isLaunched + ", isCompleted=" + isCompleted + ", isPaused=" + isPaused + ", CreatedDate=" + CreatedDate + ", AdvertisingEngineCampaignPK=" + AdvertisingEngineCampaignPK + ", AdvertisingEngineAdGroupID="
				+ AdvertisingEngineAdGroupID + ", AdvertisingEngineAccountPK=" + AdvertisingEngineAccountPK + ", AdvertisingEngine=" + AdvertisingEngine + ", AdvertisingEngineAccountNumber=" + AdvertisingEngineAccountNumber + "]";
	}
		
}
