package semplest.server.protocol.google;

public class GoogleAdIdSemplestAdIdPair
{
	private final Long googleAdId;
	private final Integer semplestAdId;
	
	public GoogleAdIdSemplestAdIdPair(Long googleAdId, Integer semplestAdId)
	{
		this.googleAdId = googleAdId;
		this.semplestAdId = semplestAdId;
	}

	public Long getGoogleAdId()
	{
		return googleAdId;
	}

	public Integer getSemplestAdId()
	{
		return semplestAdId;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((googleAdId == null) ? 0 : googleAdId.hashCode());
		result = prime * result + ((semplestAdId == null) ? 0 : semplestAdId.hashCode());
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
		GoogleAdIdSemplestAdIdPair other = (GoogleAdIdSemplestAdIdPair) obj;
		if (googleAdId == null)
		{
			if (other.googleAdId != null)
				return false;
		}
		else if (!googleAdId.equals(other.googleAdId))
			return false;
		if (semplestAdId == null)
		{
			if (other.semplestAdId != null)
				return false;
		}
		else if (!semplestAdId.equals(other.semplestAdId))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "GoogleAdIdSemplestAdIdPair [googleAdId=" + googleAdId + ", semplestAdId=" + semplestAdId + "]";
	}
	
}
