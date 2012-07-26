package semplest.server.protocol;

import java.util.Date;

public class RegistrationLinkDecryptedInfo
{
	private final Integer userID;
	private final java.util.Date dateTime;
	private final String username;
	private final String password;
	
	public RegistrationLinkDecryptedInfo(Integer userID, Date dateTime, String username, String password)
	{
		this.userID = userID;
		this.dateTime = dateTime;
		this.username = username;
		this.password = password;
	}

	public Integer getUserID()
	{
		return userID;
	}

	public java.util.Date getDateTime()
	{
		return dateTime;
	}

	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		RegistrationLinkDecryptedInfo other = (RegistrationLinkDecryptedInfo) obj;
		if (dateTime == null)
		{
			if (other.dateTime != null)
				return false;
		}
		else if (!dateTime.equals(other.dateTime))
			return false;
		if (password == null)
		{
			if (other.password != null)
				return false;
		}
		else if (!password.equals(other.password))
			return false;
		if (userID == null)
		{
			if (other.userID != null)
				return false;
		}
		else if (!userID.equals(other.userID))
			return false;
		if (username == null)
		{
			if (other.username != null)
				return false;
		}
		else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "RegistrationLinkDecryptedInfo [userID=" + userID + ", dateTime=" + dateTime + ", username=" + username + ", password=" + password + "]";
	}
	
}
