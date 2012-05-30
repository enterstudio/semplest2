/**
 * TacticChannelReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class TacticChannelReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected TacticChannelReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _AccountNumber = "AccountNumber";
    public static final java.lang.String _AccountId = "AccountId";
    public static final java.lang.String _TimePeriod = "TimePeriod";
    public static final java.lang.String _Tactic = "Tactic";
    public static final java.lang.String _Channel = "Channel";
    public static final java.lang.String _ThirdPartyCampaign = "ThirdPartyCampaign";
    public static final java.lang.String _ThirdPartyAdGroup = "ThirdPartyAdGroup";
    public static final java.lang.String _ThirdPartyTerm = "ThirdPartyTerm";
    public static final java.lang.String _CampaignName = "CampaignName";
    public static final java.lang.String _CampaignId = "CampaignId";
    public static final java.lang.String _AdGroupName = "AdGroupName";
    public static final java.lang.String _AdGroupId = "AdGroupId";
    public static final java.lang.String _Keyword = "Keyword";
    public static final java.lang.String _KeywordId = "KeywordId";
    public static final java.lang.String _Goal = "Goal";
    public static final java.lang.String _Step1Count = "Step1Count";
    public static final java.lang.String _Step2Count = "Step2Count";
    public static final java.lang.String _Step3Count = "Step3Count";
    public static final java.lang.String _Step4Count = "Step4Count";
    public static final java.lang.String _Step5Count = "Step5Count";
    public static final java.lang.String _Conversions = "Conversions";
    public static final java.lang.String _Assists = "Assists";
    public static final java.lang.String _Spend = "Spend";
    public static final java.lang.String _FunnelConversionRate = "FunnelConversionRate";
    public static final java.lang.String _Revenue = "Revenue";
    public static final java.lang.String _ReturnOnAdSpend = "ReturnOnAdSpend";
    public static final TacticChannelReportColumn AccountName = new TacticChannelReportColumn(_AccountName);
    public static final TacticChannelReportColumn AccountNumber = new TacticChannelReportColumn(_AccountNumber);
    public static final TacticChannelReportColumn AccountId = new TacticChannelReportColumn(_AccountId);
    public static final TacticChannelReportColumn TimePeriod = new TacticChannelReportColumn(_TimePeriod);
    public static final TacticChannelReportColumn Tactic = new TacticChannelReportColumn(_Tactic);
    public static final TacticChannelReportColumn Channel = new TacticChannelReportColumn(_Channel);
    public static final TacticChannelReportColumn ThirdPartyCampaign = new TacticChannelReportColumn(_ThirdPartyCampaign);
    public static final TacticChannelReportColumn ThirdPartyAdGroup = new TacticChannelReportColumn(_ThirdPartyAdGroup);
    public static final TacticChannelReportColumn ThirdPartyTerm = new TacticChannelReportColumn(_ThirdPartyTerm);
    public static final TacticChannelReportColumn CampaignName = new TacticChannelReportColumn(_CampaignName);
    public static final TacticChannelReportColumn CampaignId = new TacticChannelReportColumn(_CampaignId);
    public static final TacticChannelReportColumn AdGroupName = new TacticChannelReportColumn(_AdGroupName);
    public static final TacticChannelReportColumn AdGroupId = new TacticChannelReportColumn(_AdGroupId);
    public static final TacticChannelReportColumn Keyword = new TacticChannelReportColumn(_Keyword);
    public static final TacticChannelReportColumn KeywordId = new TacticChannelReportColumn(_KeywordId);
    public static final TacticChannelReportColumn Goal = new TacticChannelReportColumn(_Goal);
    public static final TacticChannelReportColumn Step1Count = new TacticChannelReportColumn(_Step1Count);
    public static final TacticChannelReportColumn Step2Count = new TacticChannelReportColumn(_Step2Count);
    public static final TacticChannelReportColumn Step3Count = new TacticChannelReportColumn(_Step3Count);
    public static final TacticChannelReportColumn Step4Count = new TacticChannelReportColumn(_Step4Count);
    public static final TacticChannelReportColumn Step5Count = new TacticChannelReportColumn(_Step5Count);
    public static final TacticChannelReportColumn Conversions = new TacticChannelReportColumn(_Conversions);
    public static final TacticChannelReportColumn Assists = new TacticChannelReportColumn(_Assists);
    public static final TacticChannelReportColumn Spend = new TacticChannelReportColumn(_Spend);
    public static final TacticChannelReportColumn FunnelConversionRate = new TacticChannelReportColumn(_FunnelConversionRate);
    public static final TacticChannelReportColumn Revenue = new TacticChannelReportColumn(_Revenue);
    public static final TacticChannelReportColumn ReturnOnAdSpend = new TacticChannelReportColumn(_ReturnOnAdSpend);
    public java.lang.String getValue() { return _value_;}
    public static TacticChannelReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        TacticChannelReportColumn enumeration = (TacticChannelReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static TacticChannelReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(TacticChannelReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TacticChannelReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
