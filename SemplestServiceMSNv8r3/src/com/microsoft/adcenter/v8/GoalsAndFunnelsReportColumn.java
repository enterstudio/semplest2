/**
 * GoalsAndFunnelsReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GoalsAndFunnelsReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected GoalsAndFunnelsReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _AccountNumber = "AccountNumber";
    public static final java.lang.String _AccountId = "AccountId";
    public static final java.lang.String _TimePeriod = "TimePeriod";
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
    public static final java.lang.String _FunnelConversionRate = "FunnelConversionRate";
    public static final java.lang.String _Spend = "Spend";
    public static final java.lang.String _Revenue = "Revenue";
    public static final java.lang.String _ReturnOnAdSpend = "ReturnOnAdSpend";
    public static final java.lang.String _ExtendedCost = "ExtendedCost";
    public static final GoalsAndFunnelsReportColumn AccountName = new GoalsAndFunnelsReportColumn(_AccountName);
    public static final GoalsAndFunnelsReportColumn AccountNumber = new GoalsAndFunnelsReportColumn(_AccountNumber);
    public static final GoalsAndFunnelsReportColumn AccountId = new GoalsAndFunnelsReportColumn(_AccountId);
    public static final GoalsAndFunnelsReportColumn TimePeriod = new GoalsAndFunnelsReportColumn(_TimePeriod);
    public static final GoalsAndFunnelsReportColumn CampaignName = new GoalsAndFunnelsReportColumn(_CampaignName);
    public static final GoalsAndFunnelsReportColumn CampaignId = new GoalsAndFunnelsReportColumn(_CampaignId);
    public static final GoalsAndFunnelsReportColumn AdGroupName = new GoalsAndFunnelsReportColumn(_AdGroupName);
    public static final GoalsAndFunnelsReportColumn AdGroupId = new GoalsAndFunnelsReportColumn(_AdGroupId);
    public static final GoalsAndFunnelsReportColumn Keyword = new GoalsAndFunnelsReportColumn(_Keyword);
    public static final GoalsAndFunnelsReportColumn KeywordId = new GoalsAndFunnelsReportColumn(_KeywordId);
    public static final GoalsAndFunnelsReportColumn Goal = new GoalsAndFunnelsReportColumn(_Goal);
    public static final GoalsAndFunnelsReportColumn Step1Count = new GoalsAndFunnelsReportColumn(_Step1Count);
    public static final GoalsAndFunnelsReportColumn Step2Count = new GoalsAndFunnelsReportColumn(_Step2Count);
    public static final GoalsAndFunnelsReportColumn Step3Count = new GoalsAndFunnelsReportColumn(_Step3Count);
    public static final GoalsAndFunnelsReportColumn Step4Count = new GoalsAndFunnelsReportColumn(_Step4Count);
    public static final GoalsAndFunnelsReportColumn Step5Count = new GoalsAndFunnelsReportColumn(_Step5Count);
    public static final GoalsAndFunnelsReportColumn Conversions = new GoalsAndFunnelsReportColumn(_Conversions);
    public static final GoalsAndFunnelsReportColumn Assists = new GoalsAndFunnelsReportColumn(_Assists);
    public static final GoalsAndFunnelsReportColumn FunnelConversionRate = new GoalsAndFunnelsReportColumn(_FunnelConversionRate);
    public static final GoalsAndFunnelsReportColumn Spend = new GoalsAndFunnelsReportColumn(_Spend);
    public static final GoalsAndFunnelsReportColumn Revenue = new GoalsAndFunnelsReportColumn(_Revenue);
    public static final GoalsAndFunnelsReportColumn ReturnOnAdSpend = new GoalsAndFunnelsReportColumn(_ReturnOnAdSpend);
    public static final GoalsAndFunnelsReportColumn ExtendedCost = new GoalsAndFunnelsReportColumn(_ExtendedCost);
    public java.lang.String getValue() { return _value_;}
    public static GoalsAndFunnelsReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        GoalsAndFunnelsReportColumn enumeration = (GoalsAndFunnelsReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static GoalsAndFunnelsReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(GoalsAndFunnelsReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GoalsAndFunnelsReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
