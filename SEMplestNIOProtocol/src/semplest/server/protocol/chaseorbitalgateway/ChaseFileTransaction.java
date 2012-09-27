package semplest.server.protocol.chaseorbitalgateway;

import java.math.BigDecimal;
import java.util.Date;

public class ChaseFileTransaction
{
	private final String cardType;	
	private final String cardNumber;	
	private final String transactionType;	
	private final BigDecimal amount;	
	private final String responseCode;  // 00 means good, otherwise something is wrong with the transaction	
	private final java.util.Date dateTime;	
	private final java.util.Date settlementDateTime;
	private final String orderNum;
	private final String orderDescription;
	private final String batchId;
	private final String entrySourceId;
	private final String customerProfileNum;
	
	public ChaseFileTransaction(String cardType, String cardNumber, String transactionType, BigDecimal amount, String responseCode, Date dateTime, Date settlementDateTime, String orderNum, String orderDescription, String batchId, String entrySourceId, String customerProfileNum)
	{
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.transactionType = transactionType;
		this.amount = amount;
		this.responseCode = responseCode;
		this.dateTime = dateTime;
		this.settlementDateTime = settlementDateTime;
		this.orderNum = orderNum;
		this.orderDescription = orderDescription;
		this.batchId = batchId;
		this.entrySourceId = entrySourceId;
		this.customerProfileNum = customerProfileNum;
	}

	public String getCardType()
	{
		return cardType;
	}

	public String getCardNumber()
	{
		return cardNumber;
	}

	public String getTransactionType()
	{
		return transactionType;
	}

	public BigDecimal getAmount()
	{
		return amount;
	}

	public String getResponseCode()
	{
		return responseCode;
	}

	public java.util.Date getDateTime()
	{
		return dateTime;
	}

	public java.util.Date getSettlementDateTime()
	{
		return settlementDateTime;
	}

	public String getOrderNum()
	{
		return orderNum;
	}

	public String getOrderDescription()
	{
		return orderDescription;
	}

	public String getBatchId()
	{
		return batchId;
	}

	public String getEntrySourceId()
	{
		return entrySourceId;
	}

	public String getCustomerProfileNum()
	{
		return customerProfileNum;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((customerProfileNum == null) ? 0 : customerProfileNum.hashCode());
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((entrySourceId == null) ? 0 : entrySourceId.hashCode());
		result = prime * result + ((orderDescription == null) ? 0 : orderDescription.hashCode());
		result = prime * result + ((orderNum == null) ? 0 : orderNum.hashCode());
		result = prime * result + ((responseCode == null) ? 0 : responseCode.hashCode());
		result = prime * result + ((settlementDateTime == null) ? 0 : settlementDateTime.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
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
		ChaseFileTransaction other = (ChaseFileTransaction) obj;
		if (amount == null)
		{
			if (other.amount != null)
				return false;
		}
		else if (!amount.equals(other.amount))
			return false;
		if (batchId == null)
		{
			if (other.batchId != null)
				return false;
		}
		else if (!batchId.equals(other.batchId))
			return false;
		if (cardNumber == null)
		{
			if (other.cardNumber != null)
				return false;
		}
		else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (cardType == null)
		{
			if (other.cardType != null)
				return false;
		}
		else if (!cardType.equals(other.cardType))
			return false;
		if (customerProfileNum == null)
		{
			if (other.customerProfileNum != null)
				return false;
		}
		else if (!customerProfileNum.equals(other.customerProfileNum))
			return false;
		if (dateTime == null)
		{
			if (other.dateTime != null)
				return false;
		}
		else if (!dateTime.equals(other.dateTime))
			return false;
		if (entrySourceId == null)
		{
			if (other.entrySourceId != null)
				return false;
		}
		else if (!entrySourceId.equals(other.entrySourceId))
			return false;
		if (orderDescription == null)
		{
			if (other.orderDescription != null)
				return false;
		}
		else if (!orderDescription.equals(other.orderDescription))
			return false;
		if (orderNum == null)
		{
			if (other.orderNum != null)
				return false;
		}
		else if (!orderNum.equals(other.orderNum))
			return false;
		if (responseCode == null)
		{
			if (other.responseCode != null)
				return false;
		}
		else if (!responseCode.equals(other.responseCode))
			return false;
		if (settlementDateTime == null)
		{
			if (other.settlementDateTime != null)
				return false;
		}
		else if (!settlementDateTime.equals(other.settlementDateTime))
			return false;
		if (transactionType == null)
		{
			if (other.transactionType != null)
				return false;
		}
		else if (!transactionType.equals(other.transactionType))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "ChaseFileTransaction [cardType=" + cardType + ", cardNumber=" + cardNumber + ", transactionType=" + transactionType + ", amount=" + amount + ", responseCode=" + responseCode + ", dateTime=" + dateTime + ", settlementDateTime=" + settlementDateTime + ", orderNum=" + orderNum
				+ ", orderDescription=" + orderDescription + ", batchId=" + batchId + ", entrySourceId=" + entrySourceId + ", customerProfileNum=" + customerProfileNum + "]";
	}
	
}
