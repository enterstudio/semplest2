package semplest.server.service.springjdbc;

public class CustomerObj
{
	private Integer CustomerPK;
	private String Name;
	private Double TotalCycleTargetBudget;
	private String CampaignCycleType;
	private Integer CycleInDays;
	private String BillType;
	private java.sql.Date CreatedDate;
	private java.sql.Date EditedDate;
	public Integer getCustomerPK()
	{
		return CustomerPK;
	}
	public void setCustomerPK(Integer customerPK)
	{
		CustomerPK = customerPK;
	}
	public String getName()
	{
		return Name;
	}
	public void setName(String name)
	{
		Name = name;
	}
	public Double getTotalCycleTargetBudget()
	{
		return TotalCycleTargetBudget;
	}
	public void setTotalCycleTargetBudget(Double totalCycleTargetBudget)
	{
		TotalCycleTargetBudget = totalCycleTargetBudget;
	}
	public String getCampaignCycleType()
	{
		return CampaignCycleType;
	}
	public void setCampaignCycleType(String campaignCycleType)
	{
		CampaignCycleType = campaignCycleType;
	}
	public Integer getCycleInDays()
	{
		return CycleInDays;
	}
	public void setCycleInDays(Integer cycleInDays)
	{
		CycleInDays = cycleInDays;
	}
	public String getBillType()
	{
		return BillType;
	}
	public void setBillType(String billType)
	{
		BillType = billType;
	}
	public java.sql.Date getCreatedDate()
	{
		return CreatedDate;
	}
	public void setCreatedDate(java.sql.Date createdDate)
	{
		CreatedDate = createdDate;
	}
	public java.sql.Date getEditedDate()
	{
		return EditedDate;
	}
	public void setEditedDate(java.sql.Date editedDate)
	{
		EditedDate = editedDate;
	}
	

}
