/**
 * ConversionPerformanceReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class ConversionPerformanceReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected ConversionPerformanceReportColumn(java.lang.String value) {
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
    public static final java.lang.String _Impressions = "Impressions";
    public static final java.lang.String _Clicks = "Clicks";
    public static final java.lang.String _Ctr = "Ctr";
    public static final java.lang.String _Assists = "Assists";
    public static final java.lang.String _Conversions = "Conversions";
    public static final java.lang.String _ConversionRate = "ConversionRate";
    public static final java.lang.String _Spend = "Spend";
    public static final java.lang.String _ExtendedCost = "ExtendedCost";
    public static final java.lang.String _Revenue = "Revenue";
    public static final java.lang.String _ReturnOnAdSpend = "ReturnOnAdSpend";
    public static final java.lang.String _CostPerConversion = "CostPerConversion";
    public static final java.lang.String _CostPerAssist = "CostPerAssist";
    public static final java.lang.String _RevenuePerConversion = "RevenuePerConversion";
    public static final java.lang.String _RevenuePerAssist = "RevenuePerAssist";
    public static final java.lang.String _DeviceType = "DeviceType";
    public static final ConversionPerformanceReportColumn AccountName = new ConversionPerformanceReportColumn(_AccountName);
    public static final ConversionPerformanceReportColumn AccountNumber = new ConversionPerformanceReportColumn(_AccountNumber);
    public static final ConversionPerformanceReportColumn AccountId = new ConversionPerformanceReportColumn(_AccountId);
    public static final ConversionPerformanceReportColumn TimePeriod = new ConversionPerformanceReportColumn(_TimePeriod);
    public static final ConversionPerformanceReportColumn CampaignName = new ConversionPerformanceReportColumn(_CampaignName);
    public static final ConversionPerformanceReportColumn CampaignId = new ConversionPerformanceReportColumn(_CampaignId);
    public static final ConversionPerformanceReportColumn AdGroupName = new ConversionPerformanceReportColumn(_AdGroupName);
    public static final ConversionPerformanceReportColumn AdGroupId = new ConversionPerformanceReportColumn(_AdGroupId);
    public static final ConversionPerformanceReportColumn Keyword = new ConversionPerformanceReportColumn(_Keyword);
    public static final ConversionPerformanceReportColumn KeywordId = new ConversionPerformanceReportColumn(_KeywordId);
    public static final ConversionPerformanceReportColumn Impressions = new ConversionPerformanceReportColumn(_Impressions);
    public static final ConversionPerformanceReportColumn Clicks = new ConversionPerformanceReportColumn(_Clicks);
    public static final ConversionPerformanceReportColumn Ctr = new ConversionPerformanceReportColumn(_Ctr);
    public static final ConversionPerformanceReportColumn Assists = new ConversionPerformanceReportColumn(_Assists);
    public static final ConversionPerformanceReportColumn Conversions = new ConversionPerformanceReportColumn(_Conversions);
    public static final ConversionPerformanceReportColumn ConversionRate = new ConversionPerformanceReportColumn(_ConversionRate);
    public static final ConversionPerformanceReportColumn Spend = new ConversionPerformanceReportColumn(_Spend);
    public static final ConversionPerformanceReportColumn ExtendedCost = new ConversionPerformanceReportColumn(_ExtendedCost);
    public static final ConversionPerformanceReportColumn Revenue = new ConversionPerformanceReportColumn(_Revenue);
    public static final ConversionPerformanceReportColumn ReturnOnAdSpend = new ConversionPerformanceReportColumn(_ReturnOnAdSpend);
    public static final ConversionPerformanceReportColumn CostPerConversion = new ConversionPerformanceReportColumn(_CostPerConversion);
    public static final ConversionPerformanceReportColumn CostPerAssist = new ConversionPerformanceReportColumn(_CostPerAssist);
    public static final ConversionPerformanceReportColumn RevenuePerConversion = new ConversionPerformanceReportColumn(_RevenuePerConversion);
    public static final ConversionPerformanceReportColumn RevenuePerAssist = new ConversionPerformanceReportColumn(_RevenuePerAssist);
    public static final ConversionPerformanceReportColumn DeviceType = new ConversionPerformanceReportColumn(_DeviceType);
    public java.lang.String getValue() { return _value_;}
    public static ConversionPerformanceReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        ConversionPerformanceReportColumn enumeration = (ConversionPerformanceReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static ConversionPerformanceReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(ConversionPerformanceReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ConversionPerformanceReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
