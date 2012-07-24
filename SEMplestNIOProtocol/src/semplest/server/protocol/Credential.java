package semplest.server.protocol;

public class Credential
{
	private final Integer credentialPK;
	private final Integer usersFK;
	private final String username;
	private final String password;
	private final Boolean rememberMe;
	private final String securityQuestion;
	private final String securityAnswer;
	
	public Credential(Integer credentialPK, Integer usersFK, String username, String password, Boolean rememberMe, String securityQuestion, String securityAnswer)
	{
		this.credentialPK = credentialPK;
		this.usersFK = usersFK;
		this.username = username;
		this.password = password;
		this.rememberMe = rememberMe;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}

	public Integer getCredentialPK()
	{
		return credentialPK;
	}

	public Integer getUsersFK()
	{
		return usersFK;
	}

	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}

	public Boolean getRememberMe()
	{
		return rememberMe;
	}

	public String getSecurityQuestion()
	{
		return securityQuestion;
	}

	public String getSecurityAnswer()
	{
		return securityAnswer;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((credentialPK == null) ? 0 : credentialPK.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((rememberMe == null) ? 0 : rememberMe.hashCode());
		result = prime * result + ((securityAnswer == null) ? 0 : securityAnswer.hashCode());
		result = prime * result + ((securityQuestion == null) ? 0 : securityQuestion.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((usersFK == null) ? 0 : usersFK.hashCode());
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
		Credential other = (Credential) obj;
		if (credentialPK == null)
		{
			if (other.credentialPK != null)
				return false;
		}
		else if (!credentialPK.equals(other.credentialPK))
			return false;
		if (password == null)
		{
			if (other.password != null)
				return false;
		}
		else if (!password.equals(other.password))
			return false;
		if (rememberMe == null)
		{
			if (other.rememberMe != null)
				return false;
		}
		else if (!rememberMe.equals(other.rememberMe))
			return false;
		if (securityAnswer == null)
		{
			if (other.securityAnswer != null)
				return false;
		}
		else if (!securityAnswer.equals(other.securityAnswer))
			return false;
		if (securityQuestion == null)
		{
			if (other.securityQuestion != null)
				return false;
		}
		else if (!securityQuestion.equals(other.securityQuestion))
			return false;
		if (username == null)
		{
			if (other.username != null)
				return false;
		}
		else if (!username.equals(other.username))
			return false;
		if (usersFK == null)
		{
			if (other.usersFK != null)
				return false;
		}
		else if (!usersFK.equals(other.usersFK))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Credential [credentialPK=" + credentialPK + ", usersFK=" + usersFK + ", username=" + username + ", password=" + password + ", rememberMe=" + rememberMe + ", securityQuestion=" + securityQuestion + ", securityAnswer=" + securityAnswer + "]";
	}
	
}
