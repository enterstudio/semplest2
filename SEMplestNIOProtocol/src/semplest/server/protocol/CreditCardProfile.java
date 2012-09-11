package semplest.server.protocol;

public class CreditCardProfile
{
	private final Integer creditCardProfilePk;
	private final String customerRefNum;
	private final String authCode;
	private final String txRefNum;
	private final Integer promotionFk;
	private final Integer customerFk;
	
	public CreditCardProfile(Integer creditCardProfilePk, String customerRefNum, String authCode, String txRefNum, Integer promotionFk, Integer customerFk)
	{
		this.creditCardProfilePk = creditCardProfilePk;
		this.customerRefNum = customerRefNum;
		this.authCode = authCode;
		this.txRefNum = txRefNum;
		this.promotionFk = promotionFk;
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

	public String getAuthCode()
	{
		return authCode;
	}

	public String getTxRefNum()
	{
		return txRefNum;
	}

	public Integer getPromotionFk()
	{
		return promotionFk;
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
		result = prime * result + ((authCode == null) ? 0 : authCode.hashCode());
		result = prime * result + ((creditCardProfilePk == null) ? 0 : creditCardProfilePk.hashCode());
		result = prime * result + ((customerFk == null) ? 0 : customerFk.hashCode());
		result = prime * result + ((customerRefNum == null) ? 0 : customerRefNum.hashCode());
		result = prime * result + ((promotionFk == null) ? 0 : promotionFk.hashCode());
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
		CreditCardProfile other = (CreditCardProfile) obj;
		if (authCode == null)
		{
			if (other.authCode != null)
				return false;
		}
		else if (!authCode.equals(other.authCode))
			return false;
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
		if (promotionFk == null)
		{
			if (other.promotionFk != null)
				return false;
		}
		else if (!promotionFk.equals(other.promotionFk))
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
		return "CreditCardProfile [creditCardProfilePk=" + creditCardProfilePk + ", customerRefNum=" + customerRefNum + ", authCode=" + authCode + ", txRefNum=" + txRefNum + ", promotionFk=" + promotionFk + ", customerFk=" + customerFk + "]";
	}
	
}
