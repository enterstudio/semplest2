package semplest.server.protocol;

import java.util.Date;

public class User
{
	private final Integer userPk;
	private final Integer customerFk;
	private final String firstName;
	private final String middleInidial;
	private final String lastName;
	private final String email;
	private final java.util.Date createdDate;
	private final java.util.Date editedDate;
	private final Boolean isActive;	
	private final Boolean isRegistered;
	private final java.util.Date lastEmailReminderDate;
	
	public User(Integer userPk, Integer customerFk, String firstName, String middleInidial, String lastName, String email, Boolean isActive, Boolean isRegistered, Date createdDate, Date editedDate, Date lastEmailReminderDate)
	{
		this.userPk = userPk;
		this.customerFk = customerFk;
		this.firstName = firstName;
		this.middleInidial = middleInidial;
		this.lastName = lastName;
		this.email = email;
		this.createdDate = createdDate;
		this.editedDate = editedDate;
		this.isActive = isActive;
		this.isRegistered = isRegistered;
		this.lastEmailReminderDate = lastEmailReminderDate;
	}

	public Integer getUserPk()
	{
		return userPk;
	}

	public Integer getCustomerFk()
	{
		return customerFk;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getMiddleInidial()
	{
		return middleInidial;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public java.util.Date getCreatedDate()
	{
		return createdDate;
	}

	public java.util.Date getEditedDate()
	{
		return editedDate;
	}

	public Boolean getIsActive()
	{
		return isActive;
	}

	public Boolean getIsRegistered()
	{
		return isRegistered;
	}

	public java.util.Date getLastEmailReminderDate()
	{
		return lastEmailReminderDate;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((customerFk == null) ? 0 : customerFk.hashCode());
		result = prime * result + ((editedDate == null) ? 0 : editedDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((isRegistered == null) ? 0 : isRegistered.hashCode());
		result = prime * result + ((lastEmailReminderDate == null) ? 0 : lastEmailReminderDate.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleInidial == null) ? 0 : middleInidial.hashCode());
		result = prime * result + ((userPk == null) ? 0 : userPk.hashCode());
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
		User other = (User) obj;
		if (createdDate == null)
		{
			if (other.createdDate != null)
				return false;
		}
		else if (!createdDate.equals(other.createdDate))
			return false;
		if (customerFk == null)
		{
			if (other.customerFk != null)
				return false;
		}
		else if (!customerFk.equals(other.customerFk))
			return false;
		if (editedDate == null)
		{
			if (other.editedDate != null)
				return false;
		}
		else if (!editedDate.equals(other.editedDate))
			return false;
		if (email == null)
		{
			if (other.email != null)
				return false;
		}
		else if (!email.equals(other.email))
			return false;
		if (firstName == null)
		{
			if (other.firstName != null)
				return false;
		}
		else if (!firstName.equals(other.firstName))
			return false;
		if (isActive == null)
		{
			if (other.isActive != null)
				return false;
		}
		else if (!isActive.equals(other.isActive))
			return false;
		if (isRegistered == null)
		{
			if (other.isRegistered != null)
				return false;
		}
		else if (!isRegistered.equals(other.isRegistered))
			return false;
		if (lastEmailReminderDate == null)
		{
			if (other.lastEmailReminderDate != null)
				return false;
		}
		else if (!lastEmailReminderDate.equals(other.lastEmailReminderDate))
			return false;
		if (lastName == null)
		{
			if (other.lastName != null)
				return false;
		}
		else if (!lastName.equals(other.lastName))
			return false;
		if (middleInidial == null)
		{
			if (other.middleInidial != null)
				return false;
		}
		else if (!middleInidial.equals(other.middleInidial))
			return false;
		if (userPk == null)
		{
			if (other.userPk != null)
				return false;
		}
		else if (!userPk.equals(other.userPk))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "User [userPk=" + userPk + ", customerFk=" + customerFk + ", firstName=" + firstName + ", middleInidial=" + middleInidial + ", lastName=" + lastName + ", email=" + email + ", createdDate=" + createdDate + ", editedDate=" + editedDate + ", isActive=" + isActive + ", isRegistered="
				+ isRegistered + ", lastEmailReminderDate=" + lastEmailReminderDate + "]";
	}
	
}
