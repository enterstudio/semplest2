package semplest.server.protocol.google;

public class GoogleViolation
{	
	private final String errorType;
	private final String errorMessage;
	private final String fieldPath;
	private final String shortFieldPath;
	
	private final Boolean isPolicyViolationError;
	
	private final String policyName;
	private final String policyDescription;
	private final String policyViolatingText;
	
	public GoogleViolation(String errorType, String errorMessage, String fieldPath, String shortFieldPath)
	{
		this.errorType = errorType;
		this.errorMessage = errorMessage;
		this.fieldPath = fieldPath;
		this.shortFieldPath = shortFieldPath;
		this.isPolicyViolationError = Boolean.FALSE;
		this.policyName = null;
		this.policyDescription = null;
		this.policyViolatingText = null;
	}
	
	public GoogleViolation(String errorType, String errorMessage, String fieldPath, String shortFieldPath, String policyName, String policyDescription, String policyViolatingText)
	{
		this.errorType = errorType;
		this.errorMessage = errorMessage;
		this.fieldPath = fieldPath;
		this.shortFieldPath = shortFieldPath;
		this.isPolicyViolationError = Boolean.TRUE;
		this.policyName = policyName;
		this.policyDescription = policyDescription;
		this.policyViolatingText = policyViolatingText;
	}

	public String getErrorType()
	{
		return errorType;
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public String getFieldPath()
	{
		return fieldPath;
	}

	public String getShortFieldPath()
	{
		return shortFieldPath;
	}

	public Boolean getIsPolicyViolationError()
	{
		return isPolicyViolationError;
	}

	public String getPolicyName()
	{
		return policyName;
	}

	public String getPolicyDescription()
	{
		return policyDescription;
	}

	public String getPolicyViolatingText()
	{
		return policyViolatingText;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errorMessage == null) ? 0 : errorMessage.hashCode());
		result = prime * result + ((errorType == null) ? 0 : errorType.hashCode());
		result = prime * result + ((fieldPath == null) ? 0 : fieldPath.hashCode());
		result = prime * result + ((isPolicyViolationError == null) ? 0 : isPolicyViolationError.hashCode());
		result = prime * result + ((policyDescription == null) ? 0 : policyDescription.hashCode());
		result = prime * result + ((policyName == null) ? 0 : policyName.hashCode());
		result = prime * result + ((policyViolatingText == null) ? 0 : policyViolatingText.hashCode());
		result = prime * result + ((shortFieldPath == null) ? 0 : shortFieldPath.hashCode());
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
		GoogleViolation other = (GoogleViolation) obj;
		if (errorMessage == null)
		{
			if (other.errorMessage != null)
				return false;
		}
		else if (!errorMessage.equals(other.errorMessage))
			return false;
		if (errorType == null)
		{
			if (other.errorType != null)
				return false;
		}
		else if (!errorType.equals(other.errorType))
			return false;
		if (fieldPath == null)
		{
			if (other.fieldPath != null)
				return false;
		}
		else if (!fieldPath.equals(other.fieldPath))
			return false;
		if (isPolicyViolationError == null)
		{
			if (other.isPolicyViolationError != null)
				return false;
		}
		else if (!isPolicyViolationError.equals(other.isPolicyViolationError))
			return false;
		if (policyDescription == null)
		{
			if (other.policyDescription != null)
				return false;
		}
		else if (!policyDescription.equals(other.policyDescription))
			return false;
		if (policyName == null)
		{
			if (other.policyName != null)
				return false;
		}
		else if (!policyName.equals(other.policyName))
			return false;
		if (policyViolatingText == null)
		{
			if (other.policyViolatingText != null)
				return false;
		}
		else if (!policyViolatingText.equals(other.policyViolatingText))
			return false;
		if (shortFieldPath == null)
		{
			if (other.shortFieldPath != null)
				return false;
		}
		else if (!shortFieldPath.equals(other.shortFieldPath))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "GoogleViolation [errorType=" + errorType + ", errorMessage=" + errorMessage + ", fieldPath=" + fieldPath + ", shortFieldPath="
				+ shortFieldPath + ", isPolicyViolationError=" + isPolicyViolationError + ", policyName=" + policyName + ", policyDescription="
				+ policyDescription + ", policyViolatingText=" + policyViolatingText + "]";
	}
	
}
