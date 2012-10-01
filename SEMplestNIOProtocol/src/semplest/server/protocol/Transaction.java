package semplest.server.protocol;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction
{
	private final Integer pk;
	private final Integer creditCardProfileFK;
	private final BigDecimal amount;
	private final java.util.Date createdDate;
	private final java.util.Date editedDate;
	private final String authCode;
	private final String txRefNum;
	
	public Transaction(Integer pk, Integer creditCardProfileFK, BigDecimal amount, Date createdDate, Date editedDate, String authCode, String txRefNum)
	{
		this.pk = pk;
		this.creditCardProfileFK = creditCardProfileFK;
		this.amount = amount;
		this.createdDate = createdDate;
		this.editedDate = editedDate;
		this.authCode = authCode;
		this.txRefNum = txRefNum;
	}

	public Integer getPk()
	{
		return pk;
	}

	public Integer getCreditCardProfileFK()
	{
		return creditCardProfileFK;
	}

	public BigDecimal getAmount()
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

	public String getAuthCode()
	{
		return authCode;
	}

	public String getTxRefNum()
	{
		return txRefNum;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((authCode == null) ? 0 : authCode.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((creditCardProfileFK == null) ? 0 : creditCardProfileFK.hashCode());
		result = prime * result + ((editedDate == null) ? 0 : editedDate.hashCode());
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		result = prime * result + ((txRefNum == null) ? 0 : txRefNum.hashCode());
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
		if (authCode == null)
		{
			if (other.authCode != null)
				return false;
		}
		else if (!authCode.equals(other.authCode))
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
		if (editedDate == null)
		{
			if (other.editedDate != null)
				return false;
		}
		else if (!editedDate.equals(other.editedDate))
			return false;
		if (pk == null)
		{
			if (other.pk != null)
				return false;
		}
		else if (!pk.equals(other.pk))
			return false;
		if (txRefNum == null)
		{
			if (other.txRefNum != null)
				return false;
		}
		else if (!txRefNum.equals(other.txRefNum))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Transaction [pk=" + pk + ", creditCardProfileFK=" + creditCardProfileFK + ", amount=" + amount + ", createdDate=" + createdDate + ", editedDate=" + editedDate + ", authCode=" + authCode + ", txRefNum=" + txRefNum + "]";
	}
	
	
}
