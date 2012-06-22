package semplest.server.protocol.adengine;

public class AdEngineAccountIdGroup
{
	private final Long accountId;
	private final String accountNumber;
	
	public AdEngineAccountIdGroup(Long accountId, String accountNumber)
	{
		this.accountId = accountId;
		this.accountNumber = accountNumber;
	}

	public Long getAccountId()
	{
		return accountId;
	}

	public String getAccountNumber()
	{
		return accountNumber;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
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
		AdEngineAccountIdGroup other = (AdEngineAccountIdGroup) obj;
		if (accountId == null)
		{
			if (other.accountId != null)
				return false;
		}
		else if (!accountId.equals(other.accountId))
			return false;
		if (accountNumber == null)
		{
			if (other.accountNumber != null)
				return false;
		}
		else if (!accountNumber.equals(other.accountNumber))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "AdEngineAccountIdGroup [accountId=" + accountId + ", accountNumber=" + accountNumber + "]";
	}
	
}
