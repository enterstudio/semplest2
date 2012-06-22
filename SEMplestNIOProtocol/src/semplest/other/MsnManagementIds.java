package semplest.other;

/**
 * Notes on Customer vs User vs Account
 * ---------
 * General Notes
 * ---------
 * There is a one to one relationship between Account - Customer - User (hence this object)
 * Current the Account name does not appear to be used (The Customer name is used instead)
 * All three ids should be saved since how to retrieve them is unclear
 * Creating two customer with the same name is allowed but it confuses the system (Same User name is not allowed)
 * ---------
 * CUSTOMER
 * ---------
 * Customer is "above" User and Account
 * very high level information like the industry and market the customers works in
 * ---------
 * USER
 * ---------
 * Contact (address, email...) and basic information (Name, job...)
 * contains password
 * ---------
 * ACCOUNT
 * ---------
 * Object "in control" of the Campaigns API (i.e. an account must be specficied in order to do anything in the campaign
 * mangement API)
 * 
 * @author kristian
 */
public class MsnManagementIds 
{
	private final Long accountId;
	private final String accountNumber;
	private final Long customerId;
	private final Long userId;
	
	
	public MsnManagementIds(Long accountId, String accountNumber, Long customerId, Long userId) 
	{
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.customerId = customerId;
		this.userId = userId;
	}
	
	public Long getAccountId() {
		return accountId;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	
	public Long getUserId() {
		return userId;
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
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		MsnManagementIds other = (MsnManagementIds) obj;
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
		if (customerId == null)
		{
			if (other.customerId != null)
				return false;
		}
		else if (!customerId.equals(other.customerId))
			return false;
		if (userId == null)
		{
			if (other.userId != null)
				return false;
		}
		else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "MsnManagementIds [accountId=" + accountId + ", accountNumber=" + accountNumber + ", customerId=" + customerId + ", userId=" + userId
				+ "]";
	}

	
}
