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
	private Double BudgetToAddToNextCycle;
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
	public Double getBudgetToAddToNextCycle()
	{
		return BudgetToAddToNextCycle;
	}
	public void setBudgetToAddToNextCycle(Double budgetToAddToNextCycle)
	{
		BudgetToAddToNextCycle = budgetToAddToNextCycle;
	}
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
	
}
