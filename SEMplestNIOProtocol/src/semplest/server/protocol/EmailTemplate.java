package semplest.server.protocol;

public class EmailTemplate
{
	private final Integer code;
	private final Integer customerFK;
	private final EmailType emailType;
	private final String emailFrom;
	private final String emailSubject;
	private final String emailBody;
			
	public EmailTemplate(final Integer code, final Integer customerFK, final EmailType emailType, final String emailFrom, final String emailSubject, final String emailBody)
	{
		this.code = code;
		this.customerFK = customerFK;
		this.emailType = emailType;
		this.emailFrom = emailFrom;
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;
	}

	public Integer getCode()
	{
		return code;
	}

	public Integer getCustomerFK()
	{
		return customerFK;
	}

	public EmailType getEmailType()
	{
		return emailType;
	}

	public String getEmailFrom()
	{
		return emailFrom;
	}

	public String getEmailSubject()
	{
		return emailSubject;
	}

	public String getEmailBody()
	{
		return emailBody;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((customerFK == null) ? 0 : customerFK.hashCode());
		result = prime * result + ((emailBody == null) ? 0 : emailBody.hashCode());
		result = prime * result + ((emailFrom == null) ? 0 : emailFrom.hashCode());
		result = prime * result + ((emailSubject == null) ? 0 : emailSubject.hashCode());
		result = prime * result + ((emailType == null) ? 0 : emailType.hashCode());
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
		EmailTemplate other = (EmailTemplate) obj;
		if (code == null)
		{
			if (other.code != null)
				return false;
		}
		else if (!code.equals(other.code))
			return false;
		if (customerFK == null)
		{
			if (other.customerFK != null)
				return false;
		}
		else if (!customerFK.equals(other.customerFK))
			return false;
		if (emailBody == null)
		{
			if (other.emailBody != null)
				return false;
		}
		else if (!emailBody.equals(other.emailBody))
			return false;
		if (emailFrom == null)
		{
			if (other.emailFrom != null)
				return false;
		}
		else if (!emailFrom.equals(other.emailFrom))
			return false;
		if (emailSubject == null)
		{
			if (other.emailSubject != null)
				return false;
		}
		else if (!emailSubject.equals(other.emailSubject))
			return false;
		if (emailType != other.emailType)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "EmailTemplate [code=" + code + ", customerFK=" + customerFK + ", emailType=" + emailType + ", emailFrom=" + emailFrom + ", emailSubject=" + emailSubject + ", emailBody=" + emailBody + "]";
	}
		
}
