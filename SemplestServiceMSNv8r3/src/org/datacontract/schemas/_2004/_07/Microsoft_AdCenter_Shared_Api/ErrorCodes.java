/**
 * ErrorCodes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Microsoft_AdCenter_Shared_Api;

public class ErrorCodes implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected ErrorCodes(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _InternalError = "InternalError";
    public static final java.lang.String _NullRequest = "NullRequest";
    public static final java.lang.String _InvalidCredentials = "InvalidCredentials";
    public static final java.lang.String _UserIsNotAuthorized = "UserIsNotAuthorized";
    public static final java.lang.String _QuotaNotAvailable = "QuotaNotAvailable";
    public static final java.lang.String _InvalidDateObject = "InvalidDateObject";
    public static final java.lang.String _RequestMissingHeaders = "RequestMissingHeaders";
    public static final java.lang.String _ApiInputValidationError = "ApiInputValidationError";
    public static final java.lang.String _APIExecutionError = "APIExecutionError";
    public static final java.lang.String _NullParameter = "NullParameter";
    public static final java.lang.String _OperationNotSupported = "OperationNotSupported";
    public static final java.lang.String _InvalidVersion = "InvalidVersion";
    public static final java.lang.String _NullArrayArgument = "NullArrayArgument";
    public static final java.lang.String _ConcurrentRequestOverLimit = "ConcurrentRequestOverLimit";
    public static final java.lang.String _InvalidAccount = "InvalidAccount";
    public static final java.lang.String _TimestampNotMatch = "TimestampNotMatch";
    public static final java.lang.String _EntityNotExistent = "EntityNotExistent";
    public static final java.lang.String _NameTooLong = "NameTooLong";
    public static final java.lang.String _FilterListOverLimit = "FilterListOverLimit";
    public static final java.lang.String _InvalidAccountId = "InvalidAccountId";
    public static final java.lang.String _InvalidCustomerId = "InvalidCustomerId";
    public static final java.lang.String _CustomerIdHasToBeSpecified = "CustomerIdHasToBeSpecified";
    public static final java.lang.String _AccountIdHasToBeSpecified = "AccountIdHasToBeSpecified";
    public static final java.lang.String _FutureFeatureCode = "FutureFeatureCode";
    public static final java.lang.String _InvalidOpportunityKeysList = "InvalidOpportunityKeysList";
    public static final java.lang.String _OpportunityExpired = "OpportunityExpired";
    public static final java.lang.String _OpportunityAlreadyApplied = "OpportunityAlreadyApplied";
    public static final java.lang.String _OpportunityKeysArrayShouldNotBeNullOrEmpty = "OpportunityKeysArrayShouldNotBeNullOrEmpty";
    public static final java.lang.String _OpportunityKeysArrayExceedsLimit = "OpportunityKeysArrayExceedsLimit";
    public static final java.lang.String _InvalidOpportunityKey = "InvalidOpportunityKey";
    public static final java.lang.String _CampaignBudgetAmountIsAboveLimit = "CampaignBudgetAmountIsAboveLimit";
    public static final java.lang.String _CampaignBudgetAmountIsBelowConfiguredLimit = "CampaignBudgetAmountIsBelowConfiguredLimit";
    public static final java.lang.String _CampaignBudgetAmountIsLessThanSpendAmount = "CampaignBudgetAmountIsLessThanSpendAmount";
    public static final java.lang.String _CampaignBudgetLessThanAdGroupBudget = "CampaignBudgetLessThanAdGroupBudget";
    public static final java.lang.String _CampaignDailyTargetBudgetAmountIsInvalid = "CampaignDailyTargetBudgetAmountIsInvalid";
    public static final java.lang.String _IncrementalBudgetAmountRequiredForDayTarget = "IncrementalBudgetAmountRequiredForDayTarget";
    public static final java.lang.String _BidsAmountsGreaterThanCeilingPrice = "BidsAmountsGreaterThanCeilingPrice";
    public static final java.lang.String _KeywordExactBidAmountsGreaterThanCeilingPrice = "KeywordExactBidAmountsGreaterThanCeilingPrice";
    public static final java.lang.String _KeywordPhraseBidAmountsGreaterThanCeilingPrice = "KeywordPhraseBidAmountsGreaterThanCeilingPrice";
    public static final java.lang.String _KeywordBroadBidAmountsGreaterThanCeilingPrice = "KeywordBroadBidAmountsGreaterThanCeilingPrice";
    public static final java.lang.String _BidAmountsLessThanFloorPrice = "BidAmountsLessThanFloorPrice";
    public static final java.lang.String _KeywordExactBidAmountsLessThanFloorPrice = "KeywordExactBidAmountsLessThanFloorPrice";
    public static final java.lang.String _KeywordPhraseBidAmountsLessThanFloorPrice = "KeywordPhraseBidAmountsLessThanFloorPrice";
    public static final java.lang.String _KeywordBroadBidAmountsLessThanFloorPrice = "KeywordBroadBidAmountsLessThanFloorPrice";
    public static final ErrorCodes InternalError = new ErrorCodes(_InternalError);
    public static final ErrorCodes NullRequest = new ErrorCodes(_NullRequest);
    public static final ErrorCodes InvalidCredentials = new ErrorCodes(_InvalidCredentials);
    public static final ErrorCodes UserIsNotAuthorized = new ErrorCodes(_UserIsNotAuthorized);
    public static final ErrorCodes QuotaNotAvailable = new ErrorCodes(_QuotaNotAvailable);
    public static final ErrorCodes InvalidDateObject = new ErrorCodes(_InvalidDateObject);
    public static final ErrorCodes RequestMissingHeaders = new ErrorCodes(_RequestMissingHeaders);
    public static final ErrorCodes ApiInputValidationError = new ErrorCodes(_ApiInputValidationError);
    public static final ErrorCodes APIExecutionError = new ErrorCodes(_APIExecutionError);
    public static final ErrorCodes NullParameter = new ErrorCodes(_NullParameter);
    public static final ErrorCodes OperationNotSupported = new ErrorCodes(_OperationNotSupported);
    public static final ErrorCodes InvalidVersion = new ErrorCodes(_InvalidVersion);
    public static final ErrorCodes NullArrayArgument = new ErrorCodes(_NullArrayArgument);
    public static final ErrorCodes ConcurrentRequestOverLimit = new ErrorCodes(_ConcurrentRequestOverLimit);
    public static final ErrorCodes InvalidAccount = new ErrorCodes(_InvalidAccount);
    public static final ErrorCodes TimestampNotMatch = new ErrorCodes(_TimestampNotMatch);
    public static final ErrorCodes EntityNotExistent = new ErrorCodes(_EntityNotExistent);
    public static final ErrorCodes NameTooLong = new ErrorCodes(_NameTooLong);
    public static final ErrorCodes FilterListOverLimit = new ErrorCodes(_FilterListOverLimit);
    public static final ErrorCodes InvalidAccountId = new ErrorCodes(_InvalidAccountId);
    public static final ErrorCodes InvalidCustomerId = new ErrorCodes(_InvalidCustomerId);
    public static final ErrorCodes CustomerIdHasToBeSpecified = new ErrorCodes(_CustomerIdHasToBeSpecified);
    public static final ErrorCodes AccountIdHasToBeSpecified = new ErrorCodes(_AccountIdHasToBeSpecified);
    public static final ErrorCodes FutureFeatureCode = new ErrorCodes(_FutureFeatureCode);
    public static final ErrorCodes InvalidOpportunityKeysList = new ErrorCodes(_InvalidOpportunityKeysList);
    public static final ErrorCodes OpportunityExpired = new ErrorCodes(_OpportunityExpired);
    public static final ErrorCodes OpportunityAlreadyApplied = new ErrorCodes(_OpportunityAlreadyApplied);
    public static final ErrorCodes OpportunityKeysArrayShouldNotBeNullOrEmpty = new ErrorCodes(_OpportunityKeysArrayShouldNotBeNullOrEmpty);
    public static final ErrorCodes OpportunityKeysArrayExceedsLimit = new ErrorCodes(_OpportunityKeysArrayExceedsLimit);
    public static final ErrorCodes InvalidOpportunityKey = new ErrorCodes(_InvalidOpportunityKey);
    public static final ErrorCodes CampaignBudgetAmountIsAboveLimit = new ErrorCodes(_CampaignBudgetAmountIsAboveLimit);
    public static final ErrorCodes CampaignBudgetAmountIsBelowConfiguredLimit = new ErrorCodes(_CampaignBudgetAmountIsBelowConfiguredLimit);
    public static final ErrorCodes CampaignBudgetAmountIsLessThanSpendAmount = new ErrorCodes(_CampaignBudgetAmountIsLessThanSpendAmount);
    public static final ErrorCodes CampaignBudgetLessThanAdGroupBudget = new ErrorCodes(_CampaignBudgetLessThanAdGroupBudget);
    public static final ErrorCodes CampaignDailyTargetBudgetAmountIsInvalid = new ErrorCodes(_CampaignDailyTargetBudgetAmountIsInvalid);
    public static final ErrorCodes IncrementalBudgetAmountRequiredForDayTarget = new ErrorCodes(_IncrementalBudgetAmountRequiredForDayTarget);
    public static final ErrorCodes BidsAmountsGreaterThanCeilingPrice = new ErrorCodes(_BidsAmountsGreaterThanCeilingPrice);
    public static final ErrorCodes KeywordExactBidAmountsGreaterThanCeilingPrice = new ErrorCodes(_KeywordExactBidAmountsGreaterThanCeilingPrice);
    public static final ErrorCodes KeywordPhraseBidAmountsGreaterThanCeilingPrice = new ErrorCodes(_KeywordPhraseBidAmountsGreaterThanCeilingPrice);
    public static final ErrorCodes KeywordBroadBidAmountsGreaterThanCeilingPrice = new ErrorCodes(_KeywordBroadBidAmountsGreaterThanCeilingPrice);
    public static final ErrorCodes BidAmountsLessThanFloorPrice = new ErrorCodes(_BidAmountsLessThanFloorPrice);
    public static final ErrorCodes KeywordExactBidAmountsLessThanFloorPrice = new ErrorCodes(_KeywordExactBidAmountsLessThanFloorPrice);
    public static final ErrorCodes KeywordPhraseBidAmountsLessThanFloorPrice = new ErrorCodes(_KeywordPhraseBidAmountsLessThanFloorPrice);
    public static final ErrorCodes KeywordBroadBidAmountsLessThanFloorPrice = new ErrorCodes(_KeywordBroadBidAmountsLessThanFloorPrice);
    public java.lang.String getValue() { return _value_;}
    public static ErrorCodes fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        ErrorCodes enumeration = (ErrorCodes)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static ErrorCodes fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ErrorCodes.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Shared.Api", "ErrorCodes"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
