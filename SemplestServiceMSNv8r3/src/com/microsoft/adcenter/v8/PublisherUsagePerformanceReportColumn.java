/**
 * PublisherUsagePerformanceReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class PublisherUsagePerformanceReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected PublisherUsagePerformanceReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _AccountNumber = "AccountNumber";
    public static final java.lang.String _AccountId = "AccountId";
    public static final java.lang.String _TimePeriod = "TimePeriod";
    public static final java.lang.String _LanguageAndRegion = "LanguageAndRegion";
    public static final java.lang.String _CampaignName = "CampaignName";
    public static final java.lang.String _CampaignId = "CampaignId";
    public static final java.lang.String _AdGroupName = "AdGroupName";
    public static final java.lang.String _AdGroupId = "AdGroupId";
    public static final java.lang.String _CurrencyCode = "CurrencyCode";
    public static final java.lang.String _AdDistribution = "AdDistribution";
    public static final java.lang.String _PublisherUrl = "PublisherUrl";
    public static final java.lang.String _Impressions = "Impressions";
    public static final java.lang.String _Clicks = "Clicks";
    public static final java.lang.String _Ctr = "Ctr";
    public static final java.lang.String _AverageCpc = "AverageCpc";
    public static final java.lang.String _Spend = "Spend";
    public static final java.lang.String _AveragePosition = "AveragePosition";
    public static final java.lang.String _Conversions = "Conversions";
    public static final java.lang.String _ConversionRate = "ConversionRate";
    public static final java.lang.String _CostPerConversion = "CostPerConversion";
    public static final java.lang.String _AverageCpm = "AverageCpm";
    public static final java.lang.String _PricingModel = "PricingModel";
    public static final java.lang.String _Language = "Language";
    public static final PublisherUsagePerformanceReportColumn AccountName = new PublisherUsagePerformanceReportColumn(_AccountName);
    public static final PublisherUsagePerformanceReportColumn AccountNumber = new PublisherUsagePerformanceReportColumn(_AccountNumber);
    public static final PublisherUsagePerformanceReportColumn AccountId = new PublisherUsagePerformanceReportColumn(_AccountId);
    public static final PublisherUsagePerformanceReportColumn TimePeriod = new PublisherUsagePerformanceReportColumn(_TimePeriod);
    public static final PublisherUsagePerformanceReportColumn LanguageAndRegion = new PublisherUsagePerformanceReportColumn(_LanguageAndRegion);
    public static final PublisherUsagePerformanceReportColumn CampaignName = new PublisherUsagePerformanceReportColumn(_CampaignName);
    public static final PublisherUsagePerformanceReportColumn CampaignId = new PublisherUsagePerformanceReportColumn(_CampaignId);
    public static final PublisherUsagePerformanceReportColumn AdGroupName = new PublisherUsagePerformanceReportColumn(_AdGroupName);
    public static final PublisherUsagePerformanceReportColumn AdGroupId = new PublisherUsagePerformanceReportColumn(_AdGroupId);
    public static final PublisherUsagePerformanceReportColumn CurrencyCode = new PublisherUsagePerformanceReportColumn(_CurrencyCode);
    public static final PublisherUsagePerformanceReportColumn AdDistribution = new PublisherUsagePerformanceReportColumn(_AdDistribution);
    public static final PublisherUsagePerformanceReportColumn PublisherUrl = new PublisherUsagePerformanceReportColumn(_PublisherUrl);
    public static final PublisherUsagePerformanceReportColumn Impressions = new PublisherUsagePerformanceReportColumn(_Impressions);
    public static final PublisherUsagePerformanceReportColumn Clicks = new PublisherUsagePerformanceReportColumn(_Clicks);
    public static final PublisherUsagePerformanceReportColumn Ctr = new PublisherUsagePerformanceReportColumn(_Ctr);
    public static final PublisherUsagePerformanceReportColumn AverageCpc = new PublisherUsagePerformanceReportColumn(_AverageCpc);
    public static final PublisherUsagePerformanceReportColumn Spend = new PublisherUsagePerformanceReportColumn(_Spend);
    public static final PublisherUsagePerformanceReportColumn AveragePosition = new PublisherUsagePerformanceReportColumn(_AveragePosition);
    public static final PublisherUsagePerformanceReportColumn Conversions = new PublisherUsagePerformanceReportColumn(_Conversions);
    public static final PublisherUsagePerformanceReportColumn ConversionRate = new PublisherUsagePerformanceReportColumn(_ConversionRate);
    public static final PublisherUsagePerformanceReportColumn CostPerConversion = new PublisherUsagePerformanceReportColumn(_CostPerConversion);
    public static final PublisherUsagePerformanceReportColumn AverageCpm = new PublisherUsagePerformanceReportColumn(_AverageCpm);
    public static final PublisherUsagePerformanceReportColumn PricingModel = new PublisherUsagePerformanceReportColumn(_PricingModel);
    public static final PublisherUsagePerformanceReportColumn Language = new PublisherUsagePerformanceReportColumn(_Language);
    public java.lang.String getValue() { return _value_;}
    public static PublisherUsagePerformanceReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        PublisherUsagePerformanceReportColumn enumeration = (PublisherUsagePerformanceReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static PublisherUsagePerformanceReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(PublisherUsagePerformanceReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PublisherUsagePerformanceReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
