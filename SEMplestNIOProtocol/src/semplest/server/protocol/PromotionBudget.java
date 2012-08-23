package semplest.server.protocol;

import java.math.BigDecimal;
import java.util.Date;

public class PromotionBudget
{
	private final Integer pk;
	private final Integer promotionFK;
	private final BigDecimal budgetToAddAmount;
	private final java.util.Date budgetToAddDate;
	private final Boolean isValid;
	private final Boolean isAppliedToPromotion;
	private final BigDecimal budgetCarryOverAmount;	
	private final java.util.Date createDate;
	private final Transaction transaction;
	
	public PromotionBudget(Integer pk, Integer promotionFK, BigDecimal budgetToAddAmount, Date budgetToAddDate, Boolean isValid, Boolean isAppliedToPromotion, BigDecimal budgetCarryOverAmount, Date createDate, Transaction transaction)
	{
		this.pk = pk;
		this.promotionFK = promotionFK;
		this.budgetToAddAmount = budgetToAddAmount;
		this.budgetToAddDate = budgetToAddDate;
		this.isValid = isValid;
		this.isAppliedToPromotion = isAppliedToPromotion;
		this.budgetCarryOverAmount = budgetCarryOverAmount;
		this.createDate = createDate;
		this.transaction = transaction;
	}
	
	public Transaction getTransaction()
	{
		return transaction;
	}

	public Integer getPk()
	{
		return pk;
	}

	public Integer getPromotionFK()
	{
		return promotionFK;
	}

	public BigDecimal getBudgetToAddAmount()
	{
		return budgetToAddAmount;
	}

	public java.util.Date getBudgetToAddDate()
	{
		return budgetToAddDate;
	}

	public Boolean getIsValid()
	{
		return isValid;
	}

	public Boolean getIsAppliedToPromotion()
	{
		return isAppliedToPromotion;
	}

	public BigDecimal getBudgetCarryOverAmount()
	{
		return budgetCarryOverAmount;
	}

	public java.util.Date getCreateDate()
	{
		return createDate;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((budgetCarryOverAmount == null) ? 0 : budgetCarryOverAmount.hashCode());
		result = prime * result + ((budgetToAddAmount == null) ? 0 : budgetToAddAmount.hashCode());
		result = prime * result + ((budgetToAddDate == null) ? 0 : budgetToAddDate.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((isAppliedToPromotion == null) ? 0 : isAppliedToPromotion.hashCode());
		result = prime * result + ((isValid == null) ? 0 : isValid.hashCode());
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		result = prime * result + ((promotionFK == null) ? 0 : promotionFK.hashCode());
		result = prime * result + ((transaction == null) ? 0 : transaction.hashCode());
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
		PromotionBudget other = (PromotionBudget) obj;
		if (budgetCarryOverAmount == null)
		{
			if (other.budgetCarryOverAmount != null)
				return false;
		}
		else if (!budgetCarryOverAmount.equals(other.budgetCarryOverAmount))
			return false;
		if (budgetToAddAmount == null)
		{
			if (other.budgetToAddAmount != null)
				return false;
		}
		else if (!budgetToAddAmount.equals(other.budgetToAddAmount))
			return false;
		if (budgetToAddDate == null)
		{
			if (other.budgetToAddDate != null)
				return false;
		}
		else if (!budgetToAddDate.equals(other.budgetToAddDate))
			return false;
		if (createDate == null)
		{
			if (other.createDate != null)
				return false;
		}
		else if (!createDate.equals(other.createDate))
			return false;
		if (isAppliedToPromotion == null)
		{
			if (other.isAppliedToPromotion != null)
				return false;
		}
		else if (!isAppliedToPromotion.equals(other.isAppliedToPromotion))
			return false;
		if (isValid == null)
		{
			if (other.isValid != null)
				return false;
		}
		else if (!isValid.equals(other.isValid))
			return false;
		if (pk == null)
		{
			if (other.pk != null)
				return false;
		}
		else if (!pk.equals(other.pk))
			return false;
		if (promotionFK == null)
		{
			if (other.promotionFK != null)
				return false;
		}
		else if (!promotionFK.equals(other.promotionFK))
			return false;
		if (transaction == null)
		{
			if (other.transaction != null)
				return false;
		}
		else if (!transaction.equals(other.transaction))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "PromotionBudget [pk=" + pk + ", promotionFK=" + promotionFK + ", budgetToAddAmount=" + budgetToAddAmount + ", budgetToAddDate=" + budgetToAddDate + ", isValid=" + isValid + ", isAppliedToPromotion=" + isAppliedToPromotion + ", budgetCarryOverAmount=" + budgetCarryOverAmount
				+ ", createDate=" + createDate + ", transaction=" + transaction + "]";
	}
	
}
