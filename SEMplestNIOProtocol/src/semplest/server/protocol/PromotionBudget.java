package semplest.server.protocol;

import java.util.Date;
import java.util.List;

public class PromotionBudget
{
	private final Integer pk;
	private final Integer transactionPK;
	private final Integer promotionFK;
	private final Double budgetToAddAmount;
	private final java.util.Date budgetToAddDate;
	private final Boolean isValid;
	private final Boolean isAppliedToPromotion;
	private final Double budgetCarryOverAmount;	
	private final java.util.Date createDate;
	private final List<Transaction> transactions;
	
	public PromotionBudget(Integer pk, Integer transactionPK, Integer promotionFK, Double budgetToAddAmount, Date budgetToAddDate, Boolean isValid, Boolean isAppliedToPromotion, Double budgetCarryOverAmount, Date createDate, List<Transaction> transactions)
	{
		this.pk = pk;
		this.transactionPK = transactionPK;
		this.promotionFK = promotionFK;
		this.budgetToAddAmount = budgetToAddAmount;
		this.budgetToAddDate = budgetToAddDate;
		this.isValid = isValid;
		this.isAppliedToPromotion = isAppliedToPromotion;
		this.budgetCarryOverAmount = budgetCarryOverAmount;
		this.createDate = createDate;
		this.transactions = transactions;
	}
	
	public List<Transaction> getTransactions()
	{
		return transactions;
	}

	public Integer getPk()
	{
		return pk;
	}

	public Integer getTransactionPK()
	{
		return transactionPK;
	}

	public Integer getPromotionFK()
	{
		return promotionFK;
	}

	public Double getBudgetToAddAmount()
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

	public Double getBudgetCarryOverAmount()
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
		result = prime * result + ((transactionPK == null) ? 0 : transactionPK.hashCode());
		result = prime * result + ((transactions == null) ? 0 : transactions.hashCode());
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
		if (transactionPK == null)
		{
			if (other.transactionPK != null)
				return false;
		}
		else if (!transactionPK.equals(other.transactionPK))
			return false;
		if (transactions == null)
		{
			if (other.transactions != null)
				return false;
		}
		else if (!transactions.equals(other.transactions))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "PromotionBudget [pk=" + pk + ", transactionPK=" + transactionPK + ", promotionFK=" + promotionFK + ", budgetToAddAmount=" + budgetToAddAmount + ", budgetToAddDate=" + budgetToAddDate + ", isValid=" + isValid + ", isAppliedToPromotion=" + isAppliedToPromotion
				+ ", budgetCarryOverAmount=" + budgetCarryOverAmount + ", createDate=" + createDate + ", transactions=" + transactions + "]";
	}
	
}
