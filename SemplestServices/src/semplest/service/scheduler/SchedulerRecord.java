package semplest.service.scheduler;

public class SchedulerRecord
{
// CustomerID, Integer ProductGroup, Integer PromotionID, String StartTime
	private Integer scheduleID;
	private Integer CustomerID;
	private Integer ProductGroupID;
	private Integer PromotionID;
	private String scheduleOrderID;
	private long timeToRunInMS;
	private Integer UserID;
	private boolean IsDelete = false;

	public long getTimeToRunInMS()
	{
		return timeToRunInMS;
	}

	public void setTimeToRunInMS(long timeToRunInMS)
	{
		this.timeToRunInMS = timeToRunInMS;
	}

	

	
	
	public String getScheduleOrderID()
	{
		return scheduleOrderID;
	}

	public void setScheduleOrderID(String scheduleOrderID)
	{
		this.scheduleOrderID = scheduleOrderID;
	}
	

	public boolean isDelete()
	{
		return IsDelete;
	}

	public void setDelete(boolean isDelete)
	{
		IsDelete = isDelete;
	}

	public Integer getScheduleID()
	{
		return scheduleID;
	}

	public void setScheduleID(Integer scheduleID)
	{
		this.scheduleID = scheduleID;
	}

	public Integer getCustomerID()
	{
		return CustomerID;
	}

	public void setCustomerID(Integer customerID)
	{
		CustomerID = customerID;
	}

	public Integer getProductGroupID()
	{
		return ProductGroupID;
	}

	public void setProductGroupID(Integer productGroupID)
	{
		ProductGroupID = productGroupID;
	}

	public Integer getPromotionID()
	{
		return PromotionID;
	}

	public void setPromotionID(Integer promotionID)
	{
		PromotionID = promotionID;
	}

	public boolean isIsDelete()
	{
		return IsDelete;
	}

	public void setIsDelete(boolean isDelete)
	{
		IsDelete = isDelete;
	}

	public Integer getUserID()
	{
		return UserID;
	}

	public void setUserID(Integer userID)
	{
		UserID = userID;
	}
	
}
