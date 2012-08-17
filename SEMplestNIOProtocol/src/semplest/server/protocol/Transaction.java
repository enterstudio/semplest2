package semplest.server.protocol;

import java.util.Date;

public class Transaction
{
	private final Integer pk;
	private final Integer customerFK;
	private final PayType payType;
	private final TransactionType transactionType;
	private final Integer creditCardProfileFK;
	private final Double amount;
	private final java.util.Date createdDate;
	private final java.util.Date editedDate;
	
	private Transaction(Integer pk, Integer customerFK, PayType payType, TransactionType transactionType, Integer creditCardProfileFK, Double amount, Date createdDate, Date editedDate)
	{
		this.pk = pk;
		this.customerFK = customerFK;
		this.payType = payType;
		this.transactionType = transactionType;
		this.creditCardProfileFK = creditCardProfileFK;
		this.amount = amount;
		this.createdDate = createdDate;
		this.editedDate = editedDate;
	}

	public Integer getPk()
	{
		return pk;
	}

	public Integer getCustomerFK()
	{
		return customerFK;
	}

	public PayType getPayType()
	{
		return payType;
	}

	public TransactionType getTransactionType()
	{
		return transactionType;
	}

	public Integer getCreditCardProfileFK()
	{
		return creditCardProfileFK;
	}

	public Double getAmount()
	{
		return amount;
	}

	public java.util.Date getCreatedDate()
	{
		return createdDate;
	}

	public java.util.Date getEditedDate()
	{
		return editedDate;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((creditCardProfileFK == null) ? 0 : creditCardProfileFK.hashCode());
		result = prime * result + ((customerFK == null) ? 0 : customerFK.hashCode());
		result = prime * result + ((editedDate == null) ? 0 : editedDate.hashCode());
		result = prime * result + ((payType == null) ? 0 : payType.hashCode());
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
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
		Transaction other = (Transaction) obj;
		if (amount == null)
		{
			if (other.amount != null)
				return false;
		}
		else if (!amount.equals(other.amount))
			return false;
		if (createdDate == null)
		{
			if (other.createdDate != null)
				return false;
		}
		else if (!createdDate.equals(other.createdDate))
			return false;
		if (creditCardProfileFK == null)
		{
			if (other.creditCardProfileFK != null)
				return false;
		}
		else if (!creditCardProfileFK.equals(other.creditCardProfileFK))
			return false;
		if (customerFK == null)
		{
			if (other.customerFK != null)
				return false;
		}
		else if (!customerFK.equals(other.customerFK))
			return false;
		if (editedDate == null)
		{
			if (other.editedDate != null)
				return false;
		}
		else if (!editedDate.equals(other.editedDate))
			return false;
		if (payType != other.payType)
			return false;
		if (pk == null)
		{
			if (other.pk != null)
				return false;
		}
		else if (!pk.equals(other.pk))
			return false;
		if (transactionType != other.transactionType)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Transaction [pk=" + pk + ", customerFK=" + customerFK + ", payType=" + payType + ", transactionType=" + transactionType + ", creditCardProfileFK=" + creditCardProfileFK + ", amount=" + amount + ", createdDate=" + createdDate + ", editedDate=" + editedDate + "]";
	}
	
}
