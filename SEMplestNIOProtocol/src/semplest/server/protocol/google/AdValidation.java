package semplest.server.protocol.google;

public class AdValidation
{
	private String policyName;
	private String policyDescription;
	private String violatingText;
	private String field;
	private Boolean isPolicyViolationError;
	public String getPolicyName()
	{
		return policyName;
	}
	public void setPolicyName(String policyName)
	{
		this.policyName = policyName;
	}
	public String getPolicyDescription()
	{
		return policyDescription;
	}
	public void setPolicyDescription(String policyDescription)
	{
		this.policyDescription = policyDescription;
	}
	public String getViolatingText()
	{
		return violatingText;
	}
	public void setViolatingText(String violatingText)
	{
		this.violatingText = violatingText;
	}
	public String getField()
	{
		return field;
	}
	public void setField(String field)
	{
		this.field = field;
	}
	public Boolean getIsPolicyViolationError()
	{
		return isPolicyViolationError;
	}
	public void setIsPolicyViolationError(Boolean isPolicyViolationError)
	{
		this.isPolicyViolationError = isPolicyViolationError;
	}

}
