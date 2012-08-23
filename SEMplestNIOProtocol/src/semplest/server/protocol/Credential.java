package semplest.server.protocol;

public class Credential
{
	private final Integer credentialPK;
	private final Integer usersFK;
	private final String username;
	private final String encryptedPassword;
	private final String decryptedPassword;
	private final Boolean rememberMe;
	private final String securityQuestion;
	private final String securityAnswer;
	
	public Credential(Integer credentialPK, Integer usersFK, String username, String encryptedPassword, String decryptedPassword, Boolean rememberMe, String securityQuestion, String securityAnswer)
	{
		this.credentialPK = credentialPK;
		this.usersFK = usersFK;
		this.username = username;		
		this.rememberMe = rememberMe;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.encryptedPassword = encryptedPassword;
		this.decryptedPassword = decryptedPassword;
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

	public String getEncryptedPassword()
	{
		return encryptedPassword;
	}

	public String getDecryptedPassword()
	{
		return decryptedPassword;
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
		result = prime * result + ((decryptedPassword == null) ? 0 : decryptedPassword.hashCode());
		result = prime * result + ((encryptedPassword == null) ? 0 : encryptedPassword.hashCode());
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
		if (decryptedPassword == null)
		{
			if (other.decryptedPassword != null)
				return false;
		}
		else if (!decryptedPassword.equals(other.decryptedPassword))
			return false;
		if (encryptedPassword == null)
		{
			if (other.encryptedPassword != null)
				return false;
		}
		else if (!encryptedPassword.equals(other.encryptedPassword))
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
		return "Credential [credentialPK=" + credentialPK + ", usersFK=" + usersFK + ", username=" + username + ", encryptedPassword=" + encryptedPassword + ", decryptedPassword=" + decryptedPassword + ", rememberMe=" + rememberMe + ", securityQuestion=" + securityQuestion + ", securityAnswer="
				+ securityAnswer + "]";
	}
	
}
