package semplest.server.protocol;

public class CreditCardProfile
{
	private final Integer creditCardProfilePk;
	private final String customerRefNum;
	private final Integer customerFk;
	
	public CreditCardProfile(Integer creditCardProfilePk, String customerRefNum, Integer customerFk)
	{
		this.creditCardProfilePk = creditCardProfilePk;
		this.customerRefNum = customerRefNum;
		this.customerFk = customerFk;
	}

	public Integer getCreditCardProfilePk()
	{
		return creditCardProfilePk;
	}

	public String getCustomerRefNum()
	{
		return customerRefNum;
	}

	public Integer getCustomerFk()
	{
		return customerFk;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creditCardProfilePk == null) ? 0 : creditCardProfilePk.hashCode());
		result = prime * result + ((customerFk == null) ? 0 : customerFk.hashCode());
		result = prime * result + ((customerRefNum == null) ? 0 : customerRefNum.hashCode());
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
		CreditCardProfile other = (CreditCardProfile) obj;
		if (creditCardProfilePk == null)
		{
			if (other.creditCardProfilePk != null)
				return false;
		}
		else if (!creditCardProfilePk.equals(other.creditCardProfilePk))
			return false;
		if (customerFk == null)
		{
			if (other.customerFk != null)
				return false;
		}
		else if (!customerFk.equals(other.customerFk))
			return false;
		if (customerRefNum == null)
		{
			if (other.customerRefNum != null)
				return false;
		}
		else if (!customerRefNum.equals(other.customerRefNum))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "CreditCardProfile [creditCardProfilePk=" + creditCardProfilePk + ", customerRefNum=" + customerRefNum + ", customerFk=" + customerFk + "]";
	}

	
	
}
