/**
 * AdPerformanceReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class AdPerformanceReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AdPerformanceReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _AccountNumber = "AccountNumber";
    public static final java.lang.String _TimePeriod = "TimePeriod";
    public static final java.lang.String _LanguageAndRegion = "LanguageAndRegion";
    public static final java.lang.String _CampaignName = "CampaignName";
    public static final java.lang.String _AdGroupName = "AdGroupName";
    public static final java.lang.String _AdId = "AdId";
    public static final java.lang.String _AdGroupId = "AdGroupId";
    public static final java.lang.String _AdTitle = "AdTitle";
    public static final java.lang.String _AdDescription = "AdDescription";
    public static final java.lang.String _AdType = "AdType";
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
    public static final java.lang.String _AverageCpm = "AverageCpm";
    public static final java.lang.String _PricingModel = "PricingModel";
    public static final java.lang.String _DestinationUrl = "DestinationUrl";
    public static final java.lang.String _DeviceType = "DeviceType";
    public static final java.lang.String _Language = "Language";
    public static final java.lang.String _DisplayUrl = "DisplayUrl";
    public static final AdPerformanceReportColumn AccountName = new AdPerformanceReportColumn(_AccountName);
    public static final AdPerformanceReportColumn AccountNumber = new AdPerformanceReportColumn(_AccountNumber);
    public static final AdPerformanceReportColumn TimePeriod = new AdPerformanceReportColumn(_TimePeriod);
    public static final AdPerformanceReportColumn LanguageAndRegion = new AdPerformanceReportColumn(_LanguageAndRegion);
    public static final AdPerformanceReportColumn CampaignName = new AdPerformanceReportColumn(_CampaignName);
    public static final AdPerformanceReportColumn AdGroupName = new AdPerformanceReportColumn(_AdGroupName);
    public static final AdPerformanceReportColumn AdId = new AdPerformanceReportColumn(_AdId);
    public static final AdPerformanceReportColumn AdGroupId = new AdPerformanceReportColumn(_AdGroupId);
    public static final AdPerformanceReportColumn AdTitle = new AdPerformanceReportColumn(_AdTitle);
    public static final AdPerformanceReportColumn AdDescription = new AdPerformanceReportColumn(_AdDescription);
    public static final AdPerformanceReportColumn AdType = new AdPerformanceReportColumn(_AdType);
    public static final AdPerformanceReportColumn CurrencyCode = new AdPerformanceReportColumn(_CurrencyCode);
    public static final AdPerformanceReportColumn AdDistribution = new AdPerformanceReportColumn(_AdDistribution);
    public static final AdPerformanceReportColumn Impressions = new AdPerformanceReportColumn(_Impressions);
    public static final AdPerformanceReportColumn Clicks = new AdPerformanceReportColumn(_Clicks);
    public static final AdPerformanceReportColumn Ctr = new AdPerformanceReportColumn(_Ctr);
    public static final AdPerformanceReportColumn AverageCpc = new AdPerformanceReportColumn(_AverageCpc);
    public static final AdPerformanceReportColumn Spend = new AdPerformanceReportColumn(_Spend);
    public static final AdPerformanceReportColumn AveragePosition = new AdPerformanceReportColumn(_AveragePosition);
    public static final AdPerformanceReportColumn Conversions = new AdPerformanceReportColumn(_Conversions);
    public static final AdPerformanceReportColumn ConversionRate = new AdPerformanceReportColumn(_ConversionRate);
    public static final AdPerformanceReportColumn CostPerConversion = new AdPerformanceReportColumn(_CostPerConversion);
    public static final AdPerformanceReportColumn AverageCpm = new AdPerformanceReportColumn(_AverageCpm);
    public static final AdPerformanceReportColumn PricingModel = new AdPerformanceReportColumn(_PricingModel);
    public static final AdPerformanceReportColumn DestinationUrl = new AdPerformanceReportColumn(_DestinationUrl);
    public static final AdPerformanceReportColumn DeviceType = new AdPerformanceReportColumn(_DeviceType);
    public static final AdPerformanceReportColumn Language = new AdPerformanceReportColumn(_Language);
    public static final AdPerformanceReportColumn DisplayUrl = new AdPerformanceReportColumn(_DisplayUrl);
    public java.lang.String getValue() { return _value_;}
    public static AdPerformanceReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        AdPerformanceReportColumn enumeration = (AdPerformanceReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static AdPerformanceReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(AdPerformanceReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdPerformanceReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
