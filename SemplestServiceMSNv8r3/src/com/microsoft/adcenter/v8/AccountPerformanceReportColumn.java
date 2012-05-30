/**
 * AccountPerformanceReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class AccountPerformanceReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AccountPerformanceReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _AccountNumber = "AccountNumber";
    public static final java.lang.String _TimePeriod = "TimePeriod";
    public static final java.lang.String _CurrencyCode = "CurrencyCode";
    public static final java.lang.String _AdDistribution = "AdDistribution";
    public static final java.lang.String _Impressions = "Impressions";
    public static final java.lang.String _Clicks = "Clicks";
    public static final java.lang.String _Ctr = "Ctr";
    public static final java.lang.String _AverageCpc = "AverageCpc";
    public static final java.lang.String _Spend = "Spend";
    public static final java.lang.String _AveragePosition = "AveragePosition";
    public static final java.lang.String _Conversions = "Conversions";
    public static final java.lang.String _ConversionRate = "ConversionRate";
    public static final java.lang.String _CostPerConversion = "CostPerConversion";
    public static final java.lang.String _LowQualityClicks = "LowQualityClicks";
    public static final java.lang.String _LowQualityClicksPercent = "LowQualityClicksPercent";
    public static final java.lang.String _LowQualityImpressions = "LowQualityImpressions";
    public static final java.lang.String _LowQualityImpressionsPercent = "LowQualityImpressionsPercent";
    public static final java.lang.String _LowQualityConversions = "LowQualityConversions";
    public static final java.lang.String _LowQualityConversionRate = "LowQualityConversionRate";
    public static final java.lang.String _AverageCpm = "AverageCpm";
    public static final java.lang.String _DeviceType = "DeviceType";
    public static final java.lang.String _DeviceOS = "DeviceOS";
    public static final java.lang.String _ImpressionSharePercent = "ImpressionSharePercent";
    public static final java.lang.String _ImpressionLostToBudgetPercent = "ImpressionLostToBudgetPercent";
    public static final java.lang.String _ImpressionLostToRankPercent = "ImpressionLostToRankPercent";
    public static final java.lang.String _ImpressionLostToRelevancePercent = "ImpressionLostToRelevancePercent";
    public static final java.lang.String _ImpressionLostToOthersPercent = "ImpressionLostToOthersPercent";
    public static final java.lang.String _ImpressionLostToBidPercent = "ImpressionLostToBidPercent";
    public static final java.lang.String _ImpressionLostToLandingPageRelevancePercent = "ImpressionLostToLandingPageRelevancePercent";
    public static final java.lang.String _ImpressionLostToKeywordRelevancePercent = "ImpressionLostToKeywordRelevancePercent";
    public static final AccountPerformanceReportColumn AccountName = new AccountPerformanceReportColumn(_AccountName);
    public static final AccountPerformanceReportColumn AccountNumber = new AccountPerformanceReportColumn(_AccountNumber);
    public static final AccountPerformanceReportColumn TimePeriod = new AccountPerformanceReportColumn(_TimePeriod);
    public static final AccountPerformanceReportColumn CurrencyCode = new AccountPerformanceReportColumn(_CurrencyCode);
    public static final AccountPerformanceReportColumn AdDistribution = new AccountPerformanceReportColumn(_AdDistribution);
    public static final AccountPerformanceReportColumn Impressions = new AccountPerformanceReportColumn(_Impressions);
    public static final AccountPerformanceReportColumn Clicks = new AccountPerformanceReportColumn(_Clicks);
    public static final AccountPerformanceReportColumn Ctr = new AccountPerformanceReportColumn(_Ctr);
    public static final AccountPerformanceReportColumn AverageCpc = new AccountPerformanceReportColumn(_AverageCpc);
    public static final AccountPerformanceReportColumn Spend = new AccountPerformanceReportColumn(_Spend);
    public static final AccountPerformanceReportColumn AveragePosition = new AccountPerformanceReportColumn(_AveragePosition);
    public static final AccountPerformanceReportColumn Conversions = new AccountPerformanceReportColumn(_Conversions);
    public static final AccountPerformanceReportColumn ConversionRate = new AccountPerformanceReportColumn(_ConversionRate);
    public static final AccountPerformanceReportColumn CostPerConversion = new AccountPerformanceReportColumn(_CostPerConversion);
    public static final AccountPerformanceReportColumn LowQualityClicks = new AccountPerformanceReportColumn(_LowQualityClicks);
    public static final AccountPerformanceReportColumn LowQualityClicksPercent = new AccountPerformanceReportColumn(_LowQualityClicksPercent);
    public static final AccountPerformanceReportColumn LowQualityImpressions = new AccountPerformanceReportColumn(_LowQualityImpressions);
    public static final AccountPerformanceReportColumn LowQualityImpressionsPercent = new AccountPerformanceReportColumn(_LowQualityImpressionsPercent);
    public static final AccountPerformanceReportColumn LowQualityConversions = new AccountPerformanceReportColumn(_LowQualityConversions);
    public static final AccountPerformanceReportColumn LowQualityConversionRate = new AccountPerformanceReportColumn(_LowQualityConversionRate);
    public static final AccountPerformanceReportColumn AverageCpm = new AccountPerformanceReportColumn(_AverageCpm);
    public static final AccountPerformanceReportColumn DeviceType = new AccountPerformanceReportColumn(_DeviceType);
    public static final AccountPerformanceReportColumn DeviceOS = new AccountPerformanceReportColumn(_DeviceOS);
    public static final AccountPerformanceReportColumn ImpressionSharePercent = new AccountPerformanceReportColumn(_ImpressionSharePercent);
    public static final AccountPerformanceReportColumn ImpressionLostToBudgetPercent = new AccountPerformanceReportColumn(_ImpressionLostToBudgetPercent);
    public static final AccountPerformanceReportColumn ImpressionLostToRankPercent = new AccountPerformanceReportColumn(_ImpressionLostToRankPercent);
    public static final AccountPerformanceReportColumn ImpressionLostToRelevancePercent = new AccountPerformanceReportColumn(_ImpressionLostToRelevancePercent);
    public static final AccountPerformanceReportColumn ImpressionLostToOthersPercent = new AccountPerformanceReportColumn(_ImpressionLostToOthersPercent);
    public static final AccountPerformanceReportColumn ImpressionLostToBidPercent = new AccountPerformanceReportColumn(_ImpressionLostToBidPercent);
    public static final AccountPerformanceReportColumn ImpressionLostToLandingPageRelevancePercent = new AccountPerformanceReportColumn(_ImpressionLostToLandingPageRelevancePercent);
    public static final AccountPerformanceReportColumn ImpressionLostToKeywordRelevancePercent = new AccountPerformanceReportColumn(_ImpressionLostToKeywordRelevancePercent);
    public java.lang.String getValue() { return _value_;}
    public static AccountPerformanceReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        AccountPerformanceReportColumn enumeration = (AccountPerformanceReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static AccountPerformanceReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(AccountPerformanceReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountPerformanceReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
