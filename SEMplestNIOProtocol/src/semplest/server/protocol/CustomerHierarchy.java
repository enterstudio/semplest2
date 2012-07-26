package semplest.server.protocol;

import java.util.Date;

public class CustomerHierarchy
{
	private final Integer hierarchyID;
	private final Integer custsomerID;
	private final Integer parentCustomerID;
	private final java.util.Date createdDate;
	
	public CustomerHierarchy(Integer hierarchyID, Integer custsomerID, Integer parentCustomerID, Date createdDate)
	{
		this.hierarchyID = hierarchyID;
		this.custsomerID = custsomerID;
		this.parentCustomerID = parentCustomerID;
		this.createdDate = createdDate;
	}

	public Integer getHierarchyID()
	{
		return hierarchyID;
	}

	public Integer getCustsomerID()
	{
		return custsomerID;
	}

	public Integer getParentCustomerID()
	{
		return parentCustomerID;
	}

	public java.util.Date getCreatedDate()
	{
		return createdDate;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((custsomerID == null) ? 0 : custsomerID.hashCode());
		result = prime * result + ((hierarchyID == null) ? 0 : hierarchyID.hashCode());
		result = prime * result + ((parentCustomerID == null) ? 0 : parentCustomerID.hashCode());
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
		CustomerHierarchy other = (CustomerHierarchy) obj;
		if (createdDate == null)
		{
			if (other.createdDate != null)
				return false;
		}
		else if (!createdDate.equals(other.createdDate))
			return false;
		if (custsomerID == null)
		{
			if (other.custsomerID != null)
				return false;
		}
		else if (!custsomerID.equals(other.custsomerID))
			return false;
		if (hierarchyID == null)
		{
			if (other.hierarchyID != null)
				return false;
		}
		else if (!hierarchyID.equals(other.hierarchyID))
			return false;
		if (parentCustomerID == null)
		{
			if (other.parentCustomerID != null)
				return false;
		}
		else if (!parentCustomerID.equals(other.parentCustomerID))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "CustomerHierarchy [hierarchyID=" + hierarchyID + ", custsomerID=" + custsomerID + ", parentCustomerID=" + parentCustomerID + ", createdDate=" + createdDate + "]";
	}
	
}
