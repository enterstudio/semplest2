package semplest.server.protocol.chaseorbitalgateway;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

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
	
	//New Order
	private String OrderID = null;
	private String amountRequestedNoDecimal = null;
	private String amountRedeemedNoDecimal = null;
	private String remainingBalanceNoDecimal = null;
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
	public String getOrderID()
	{
		return OrderID;
	}
	public void setOrderID(String orderID)
	{
		OrderID = orderID;
	}
	public String getAmountRequestedNoDecimal()
	{
		return amountRequestedNoDecimal;
	}
	public void setAmountRequestedNoDecimal(String amountRequestedNoDecimal)
	{
		this.amountRequestedNoDecimal = amountRequestedNoDecimal;
	}
	public String getAmountRedeemedNoDecimal()
	{
		return amountRedeemedNoDecimal;
	}
	public void setAmountRedeemedNoDecimal(String amountRedeemedNoDecimal)
	{
		this.amountRedeemedNoDecimal = amountRedeemedNoDecimal;
	}
	public String getRemainingBalanceNoDecimal()
	{
		return remainingBalanceNoDecimal;
	}
	public void setRemainingBalanceNoDecimal(String remainingBalanceNoDecimal)
	{
		this.remainingBalanceNoDecimal = remainingBalanceNoDecimal;
	}
	
	@Override
	public String toString() {
		return "GatewayReturnObject [xmlReturn=" + xmlReturn + ", isGood="
				+ isGood + ", isError=" + isError + ", isQuickResponse="
				+ isQuickResponse + ", isApproved=" + isApproved
				+ ", isDeclined=" + isDeclined + ", AuthCode=" + AuthCode
				+ ", TxRefNum=" + TxRefNum + ", ResponseCode=" + ResponseCode
				+ ", Status=" + Status + ", Message=" + Message + ", AVSCode="
				+ AVSCode + ", CVV2ResponseCode=" + CVV2ResponseCode
				+ ", OrderID=" + OrderID + ", amountRequestedNoDecimal="
				+ amountRequestedNoDecimal + ", amountRedeemedNoDecimal="
				+ amountRedeemedNoDecimal + ", remainingBalanceNoDecimal="
				+ remainingBalanceNoDecimal + ", CustomerRefNum="
				+ CustomerRefNum + "]";
	}
	
	public String toStringPretty() throws TransformerException 
	{		
		final TransformerFactory tf = TransformerFactory.newInstance();
		tf.setAttribute("indent-number", 2);
		final Transformer t = tf.newTransformer();
		t.setOutputProperty(OutputKeys.INDENT, "yes");
		final StringWriter writer = new StringWriter();
		final StreamResult result = new StreamResult(writer);
		final StreamSource source = new StreamSource(new StringReader(xmlReturn));
		t.transform(source, result);		
		final String xmlStringPretty = result.getWriter().toString();
		return "GatewayReturnObject [xmlReturn\n" + xmlStringPretty + ", isGood="
				+ isGood + ", isError=" + isError + ", isQuickResponse="
				+ isQuickResponse + ", isApproved=" + isApproved
				+ ", isDeclined=" + isDeclined + ", AuthCode=" + AuthCode
				+ ", TxRefNum=" + TxRefNum + ", ResponseCode=" + ResponseCode
				+ ", Status=" + Status + ", Message=" + Message + ", AVSCode="
				+ AVSCode + ", CVV2ResponseCode=" + CVV2ResponseCode
				+ ", OrderID=" + OrderID + ", amountRequestedNoDecimal="
				+ amountRequestedNoDecimal + ", amountRedeemedNoDecimal="
				+ amountRedeemedNoDecimal + ", remainingBalanceNoDecimal="
				+ remainingBalanceNoDecimal + ", CustomerRefNum="
				+ CustomerRefNum + "]";
	}
	
}