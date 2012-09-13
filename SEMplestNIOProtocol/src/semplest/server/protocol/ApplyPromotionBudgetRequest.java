package semplest.server.protocol;

import java.math.BigDecimal;
import java.util.Date;

public class ApplyPromotionBudgetRequest
{
	// params for updating promotion
	private final Integer promotionID;
	private final java.util.Date newCycleStartDate;
	private final java.util.Date newCycleEndDate;
	private final BigDecimal newRemainingBudget;
	
	// params for updating promotion budget
	private final Integer promotionBudgetID;
	private final Integer transactionID;
	private final BigDecimal spendIncurredThisMonth;
	private final BigDecimal budgetCarryOverAmount;
	
	// params for inserting new promotion budget
	private final java.util.Date newBudgetToAddDate;
	private final BigDecimal newBudgetToAddAmount;
	
	private final Integer customerID;

	public ApplyPromotionBudgetRequest(Integer promotionID, Date newCycleStartDate, Date newCycleEndDate, BigDecimal newRemainingBudget, Integer transactionID, Integer promotionBudgetID, BigDecimal spendIncurredThisMonth, BigDecimal budgetCarryOverAmount, Date newBudgetToAddDate, BigDecimal newBudgetToAddAmount,
			Integer customerID)
	{
		super();
		this.promotionID = promotionID;
		this.newCycleStartDate = newCycleStartDate;
		this.newCycleEndDate = newCycleEndDate;
		this.newRemainingBudget = newRemainingBudget;
		this.transactionID = transactionID;
		this.promotionBudgetID = promotionBudgetID;
		this.spendIncurredThisMonth = spendIncurredThisMonth;
		this.budgetCarryOverAmount = budgetCarryOverAmount;
		this.newBudgetToAddDate = newBudgetToAddDate;
		this.newBudgetToAddAmount = newBudgetToAddAmount;
		this.customerID = customerID;
	}
	
	public Integer getTransactionID()
	{
		return transactionID;
	}

	public Integer getPromotionID()
	{
		return promotionID;
	}

	public java.util.Date getNewCycleStartDate()
	{
		return newCycleStartDate;
	}

	public java.util.Date getNewCycleEndDate()
	{
		return newCycleEndDate;
	}

	public BigDecimal getNewRemainingBudget()
	{
		return newRemainingBudget;
	}

	public Integer getPromotionBudgetID()
	{
		return promotionBudgetID;
	}

	public BigDecimal getSpendIncurredThisMonth()
	{
		return spendIncurredThisMonth;
	}

	public BigDecimal getBudgetCarryOverAmount()
	{
		return budgetCarryOverAmount;
	}

	public java.util.Date getNewBudgetToAddDate()
	{
		return newBudgetToAddDate;
	}

	public BigDecimal getNewBudgetToAddAmount()
	{
		return newBudgetToAddAmount;
	}

	public Integer getCustomerID()
	{
		return customerID;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((budgetCarryOverAmount == null) ? 0 : budgetCarryOverAmount.hashCode());
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
		result = prime * result + ((newBudgetToAddAmount == null) ? 0 : newBudgetToAddAmount.hashCode());
		result = prime * result + ((newBudgetToAddDate == null) ? 0 : newBudgetToAddDate.hashCode());
		result = prime * result + ((newCycleEndDate == null) ? 0 : newCycleEndDate.hashCode());
		result = prime * result + ((newCycleStartDate == null) ? 0 : newCycleStartDate.hashCode());
		result = prime * result + ((newRemainingBudget == null) ? 0 : newRemainingBudget.hashCode());
		result = prime * result + ((promotionBudgetID == null) ? 0 : promotionBudgetID.hashCode());
		result = prime * result + ((promotionID == null) ? 0 : promotionID.hashCode());
		result = prime * result + ((spendIncurredThisMonth == null) ? 0 : spendIncurredThisMonth.hashCode());
		result = prime * result + ((transactionID == null) ? 0 : transactionID.hashCode());
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
		ApplyPromotionBudgetRequest other = (ApplyPromotionBudgetRequest) obj;
		if (budgetCarryOverAmount == null)
		{
			if (other.budgetCarryOverAmount != null)
				return false;
		}
		else if (!budgetCarryOverAmount.equals(other.budgetCarryOverAmount))
			return false;
		if (customerID == null)
		{
			if (other.customerID != null)
				return false;
		}
		else if (!customerID.equals(other.customerID))
			return false;
		if (newBudgetToAddAmount == null)
		{
			if (other.newBudgetToAddAmount != null)
				return false;
		}
		else if (!newBudgetToAddAmount.equals(other.newBudgetToAddAmount))
			return false;
		if (newBudgetToAddDate == null)
		{
			if (other.newBudgetToAddDate != null)
				return false;
		}
		else if (!newBudgetToAddDate.equals(other.newBudgetToAddDate))
			return false;
		if (newCycleEndDate == null)
		{
			if (other.newCycleEndDate != null)
				return false;
		}
		else if (!newCycleEndDate.equals(other.newCycleEndDate))
			return false;
		if (newCycleStartDate == null)
		{
			if (other.newCycleStartDate != null)
				return false;
		}
		else if (!newCycleStartDate.equals(other.newCycleStartDate))
			return false;
		if (newRemainingBudget == null)
		{
			if (other.newRemainingBudget != null)
				return false;
		}
		else if (!newRemainingBudget.equals(other.newRemainingBudget))
			return false;
		if (promotionBudgetID == null)
		{
			if (other.promotionBudgetID != null)
				return false;
		}
		else if (!promotionBudgetID.equals(other.promotionBudgetID))
			return false;
		if (promotionID == null)
		{
			if (other.promotionID != null)
				return false;
		}
		else if (!promotionID.equals(other.promotionID))
			return false;
		if (spendIncurredThisMonth == null)
		{
			if (other.spendIncurredThisMonth != null)
				return false;
		}
		else if (!spendIncurredThisMonth.equals(other.spendIncurredThisMonth))
			return false;
		if (transactionID == null)
		{
			if (other.transactionID != null)
				return false;
		}
		else if (!transactionID.equals(other.transactionID))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "ApplyPromotionBudgetRequest [promotionID=" + promotionID + ", newCycleStartDate=" + newCycleStartDate + ", newCycleEndDate=" + newCycleEndDate + ", newRemainingBudget=" + newRemainingBudget + ", promotionBudgetID=" + promotionBudgetID + ", transactionID=" + transactionID
				+ ", spendIncurredThisMonth=" + spendIncurredThisMonth + ", budgetCarryOverAmount=" + budgetCarryOverAmount + ", newBudgetToAddDate=" + newBudgetToAddDate + ", newBudgetToAddAmount=" + newBudgetToAddAmount + ", customerID=" + customerID + "]";
	}
			
}
