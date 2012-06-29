package semplest.server.protocol.google;

public class MsnEditorialApiFaultDetail
{
	private final Integer code;
	private final String errorCode;
	private final Integer index;
	private final String disapprovedText;
	private final String message;
	private final String publisherCountry;
	
	public MsnEditorialApiFaultDetail(Integer code, String errorCode, Integer index, String disapprovedText, String message, String publisherCountry)
	{
		this.code = code;
		this.errorCode = errorCode;
		this.index = index;
		this.disapprovedText = disapprovedText;
		this.message = message;
		this.publisherCountry = publisherCountry;
	}

	public Integer getCode()
	{
		return code;
	}

	public String getErrorCode()
	{
		return errorCode;
	}

	public Integer getIndex()
	{
		return index;
	}

	public String getDisapprovedText()
	{
		return disapprovedText;
	}

	public String getMessage()
	{
		return message;
	}

	public String getPublisherCountry()
	{
		return publisherCountry;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((publisherCountry == null) ? 0 : publisherCountry.hashCode());
		result = prime * result + ((disapprovedText == null) ? 0 : disapprovedText.hashCode());
		result = prime * result + ((errorCode == null) ? 0 : errorCode.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
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
		MsnEditorialApiFaultDetail other = (MsnEditorialApiFaultDetail) obj;
		if (code == null)
		{
			if (other.code != null)
				return false;
		}
		else if (!code.equals(other.code))
			return false;
		if (publisherCountry == null)
		{
			if (other.publisherCountry != null)
				return false;
		}
		else if (!publisherCountry.equals(other.publisherCountry))
			return false;
		if (disapprovedText == null)
		{
			if (other.disapprovedText != null)
				return false;
		}
		else if (!disapprovedText.equals(other.disapprovedText))
			return false;
		if (errorCode == null)
		{
			if (other.errorCode != null)
				return false;
		}
		else if (!errorCode.equals(other.errorCode))
			return false;
		if (index == null)
		{
			if (other.index != null)
				return false;
		}
		else if (!index.equals(other.index))
			return false;
		if (message == null)
		{
			if (other.message != null)
				return false;
		}
		else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "MsnEditorialApiFaultDetail [code=" + code + ", errorCode=" + errorCode + ", index=" + index + ", disapprovedText=" + disapprovedText
				+ ", message=" + message + ", publisherCountry=" + publisherCountry + "]";
	}
	
}
