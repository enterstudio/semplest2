package semplest.server.protocol.chaseorbitalgateway;

public class CustomerObject
{
	private String FirstName;
	private String LastName;
	private String Address1;
	private String Address2;
	private String City;
	private String StateAbbr;
	private String ZipCode;
	private String Email;
	private String Phone;
	private String creditCardNumber;
    private String ExpireDateMMYY;
	
	public String getCreditCardNumber()
	{
		return creditCardNumber;
	}
	public String getExpireDateMMYY()
	{
		return ExpireDateMMYY;
	}
	public void setCreditCardNumber(String creditCardNumber)
	{
		this.creditCardNumber = creditCardNumber;
	}
	public void setExpireDateMMYY(String expireDateMMYY)
	{
		ExpireDateMMYY = expireDateMMYY;
	}
	public String getAddress1()
	{
		return Address1;
	}
	public void setAddress1(String address1)
	{
		Address1 = address1;
	}
	public String getAddress2()
	{
		return Address2;
	}
	public void setAddress2(String address2)
	{
		Address2 = address2;
	}
	public String getCity()
	{
		return City;
	}
	public void setCity(String city)
	{
		City = city;
	}
	public String getStateAbbr()
	{
		return StateAbbr;
	}
	public void setStateAbbr(String stateAbbr)
	{
		StateAbbr = stateAbbr;
	}
	public String getZipCode()
	{
		return ZipCode;
	}
	public void setZipCode(String zipCode)
	{
		ZipCode = zipCode;
	}
	public String getEmail()
	{
		return Email;
	}
	public void setEmail(String email)
	{
		Email = email;
	}
	public String getPhone()
	{
		return Phone;
	}
	public void setPhone(String phone)
	{
		Phone = phone;
	}
	public String getFirstName()
	{
		return FirstName;
	}
	public void setFirstName(String firstName)
	{
		FirstName = firstName;
	}
	public String getLastName()
	{
		return LastName;
	}
	public void setLastName(String lastName)
	{
		LastName = lastName;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Address1 == null) ? 0 : Address1.hashCode());
		result = prime * result + ((Address2 == null) ? 0 : Address2.hashCode());
		result = prime * result + ((City == null) ? 0 : City.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((ExpireDateMMYY == null) ? 0 : ExpireDateMMYY.hashCode());
		result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
		result = prime * result + ((LastName == null) ? 0 : LastName.hashCode());
		result = prime * result + ((Phone == null) ? 0 : Phone.hashCode());
		result = prime * result + ((StateAbbr == null) ? 0 : StateAbbr.hashCode());
		result = prime * result + ((ZipCode == null) ? 0 : ZipCode.hashCode());
		result = prime * result + ((creditCardNumber == null) ? 0 : creditCardNumber.hashCode());
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
		CustomerObject other = (CustomerObject) obj;
		if (Address1 == null)
		{
			if (other.Address1 != null)
				return false;
		}
		else if (!Address1.equals(other.Address1))
			return false;
		if (Address2 == null)
		{
			if (other.Address2 != null)
				return false;
		}
		else if (!Address2.equals(other.Address2))
			return false;
		if (City == null)
		{
			if (other.City != null)
				return false;
		}
		else if (!City.equals(other.City))
			return false;
		if (Email == null)
		{
			if (other.Email != null)
				return false;
		}
		else if (!Email.equals(other.Email))
			return false;
		if (ExpireDateMMYY == null)
		{
			if (other.ExpireDateMMYY != null)
				return false;
		}
		else if (!ExpireDateMMYY.equals(other.ExpireDateMMYY))
			return false;
		if (FirstName == null)
		{
			if (other.FirstName != null)
				return false;
		}
		else if (!FirstName.equals(other.FirstName))
			return false;
		if (LastName == null)
		{
			if (other.LastName != null)
				return false;
		}
		else if (!LastName.equals(other.LastName))
			return false;
		if (Phone == null)
		{
			if (other.Phone != null)
				return false;
		}
		else if (!Phone.equals(other.Phone))
			return false;
		if (StateAbbr == null)
		{
			if (other.StateAbbr != null)
				return false;
		}
		else if (!StateAbbr.equals(other.StateAbbr))
			return false;
		if (ZipCode == null)
		{
			if (other.ZipCode != null)
				return false;
		}
		else if (!ZipCode.equals(other.ZipCode))
			return false;
		if (creditCardNumber == null)
		{
			if (other.creditCardNumber != null)
				return false;
		}
		else if (!creditCardNumber.equals(other.creditCardNumber))
			return false;
		return true;
	}
	@Override
	public String toString()
	{
		return "CustomerObject [FirstName=" + FirstName + ", LastName=" + LastName + ", Address1=" + Address1 + ", Address2=" + Address2 + ", City="
				+ City + ", StateAbbr=" + StateAbbr + ", ZipCode=" + ZipCode + ", Email=" + Email + ", Phone=" + Phone + ", creditCardNumber="
				+ creditCardNumber + ", ExpireDateMMYY=" + ExpireDateMMYY + "]";
	}

}
