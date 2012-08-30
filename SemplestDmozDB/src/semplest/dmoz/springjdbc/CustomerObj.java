package semplest.dmoz.springjdbc;

public class CustomerObj
{
	private Integer CustomerPK;
	private String Name;
	private Double TotalTargetCycleBudget;
	private String CampaignCycleType;
	private Integer CycleInDays;
	private String BillType;
	private java.util.Date CreatedDate;
	private java.util.Date EditedDate;
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
	public java.util.Date getCreatedDate()
	{
		return CreatedDate;
	}
	public void setCreatedDate(java.util.Date createdDate)
	{
		CreatedDate = createdDate;
	}
	public java.util.Date getEditedDate()
	{
		return EditedDate;
	}
	public void setEditedDate(java.util.Date editedDate)
	{
		EditedDate = editedDate;
	}
	public Double getTotalTargetCycleBudget()
	{
		return TotalTargetCycleBudget;
	}
	public void setTotalTargetCycleBudget(Double totalTargetCycleBudget)
	{
		TotalTargetCycleBudget = totalTargetCycleBudget;
	}
	

}
