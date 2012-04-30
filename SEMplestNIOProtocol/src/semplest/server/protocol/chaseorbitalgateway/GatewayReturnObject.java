package semplest.server.protocol.chaseorbitalgateway;

public class GatewayReturnObject
{
	//Quick return parameters
	private String xmlReturn = null;
	private Boolean isGood;
	private Boolean isError;
	private Boolean isQuickResponse;
	private Boolean isApproved;
	private Boolean isDeclined;
	private String AuthCode;
	private String TxRefNum;
	private String ResponseCode;
	private String Status;
	private String Message;
	private String AVSCode;
	private String CVV2ResponseCode;
	//Profile
	private String CustomerRefNum = null;
	
	public Boolean getIsGood()
	{
		return isGood;
	}
	public void setIsGood(Boolean isGood)
	{
		this.isGood = isGood;
	}
	public Boolean getIsError()
	{
		return isError;
	}
	public void setIsError(Boolean isError)
	{
		this.isError = isError;
	}
	public Boolean getIsQuickResponse()
	{
		return isQuickResponse;
	}
	public void setIsQuickResponse(Boolean isQuickResponse)
	{
		this.isQuickResponse = isQuickResponse;
	}
	public Boolean getIsApproved()
	{
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved)
	{
		this.isApproved = isApproved;
	}
	public Boolean getIsDeclined()
	{
		return isDeclined;
	}
	public void setIsDeclined(Boolean isDeclined)
	{
		this.isDeclined = isDeclined;
	}
	public String getAuthCode()
	{
		return AuthCode;
	}
	public void setAuthCode(String authCode)
	{
		AuthCode = authCode;
	}
	public String getTxRefNum()
	{
		return TxRefNum;
	}
	public void setTxRefNum(String txRefNum)
	{
		TxRefNum = txRefNum;
	}
	public String getResponseCode()
	{
		return ResponseCode;
	}
	public void setResponseCode(String responseCode)
	{
		ResponseCode = responseCode;
	}
	public String getStatus()
	{
		return Status;
	}
	public void setStatus(String status)
	{
		Status = status;
	}
	public String getMessage()
	{
		return Message;
	}
	public void setMessage(String message)
	{
		Message = message;
	}
	public String getAVSCode()
	{
		return AVSCode;
	}
	public void setAVSCode(String aVSCode)
	{
		AVSCode = aVSCode;
	}
	public String getCVV2ResponseCode()
	{
		return CVV2ResponseCode;
	}
	public void setCVV2ResponseCode(String cVV2ResponseCode)
	{
		CVV2ResponseCode = cVV2ResponseCode;
	}
	public String getXmlReturn()
	{
		return xmlReturn;
	}
	public void setXmlReturn(String xmlReturn)
	{
		this.xmlReturn = xmlReturn;
	}
	public String getCustomerRefNum()
	{
		return CustomerRefNum;
	}
	public void setCustomerRefNum(String customerRefNum)
	{
		CustomerRefNum = customerRefNum;
	}

}
