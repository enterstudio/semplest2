package semplest.server.service.springjdbc;

import java.util.Date;

public class PromotionObj
{
	private Integer PromotionPK;
	private Integer ProductGroupFK;
	private String PromotionName;
	private String PromotionDescription;
	private String LandingPageURL;
	private Double CycleBudgetAmount;
	private Date StartDate;
	private Date EndDate;
	private Boolean IsPaused;
	private Date CreatedDate;
	private Date EditedDate;
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
	public String getLandingPageURL()
	{
		return LandingPageURL;
	}
	public void setLandingPageURL(String landingPageURL)
	{
		LandingPageURL = landingPageURL;
	}
	public Double getCycleBudgetAmount()
	{
		return CycleBudgetAmount;
	}
	public void setCycleBudgetAmount(Double cycleBudgetAmount)
	{
		CycleBudgetAmount = cycleBudgetAmount;
	}
	public Date getStartDate()
	{
		return StartDate;
	}
	public void setStartDate(Date startDate)
	{
		StartDate = startDate;
	}
	public Date getEndDate()
	{
		return EndDate;
	}
	public void setEndDate(Date endDate)
	{
		EndDate = endDate;
	}
	public Boolean getIsPaused()
	{
		return IsPaused;
	}
	public void setIsPaused(Boolean isPaused)
	{
		IsPaused = isPaused;
	}
	public Date getCreatedDate()
	{
		return CreatedDate;
	}
	public void setCreatedDate(Date createdDate)
	{
		CreatedDate = createdDate;
	}
	public Date getEditedDate()
	{
		return EditedDate;
	}
	public void setEditedDate(Date editedDate)
	{
		EditedDate = editedDate;
	}
}
