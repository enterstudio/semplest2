/**
 * DestinationUrlPerformanceReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class DestinationUrlPerformanceReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected DestinationUrlPerformanceReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _AccountNumber = "AccountNumber";
    public static final java.lang.String _TimePeriod = "TimePeriod";
    public static final java.lang.String _LanguageAndRegion = "LanguageAndRegion";
    public static final java.lang.String _CampaignName = "CampaignName";
    public static final java.lang.String _CampaignId = "CampaignId";
    public static final java.lang.String _AdGroupName = "AdGroupName";
    public static final java.lang.String _AdGroupId = "AdGroupId";
    public static final java.lang.String _AdId = "AdId";
    public static final java.lang.String _CurrencyCode = "CurrencyCode";
    public static final java.lang.String _AdDistribution = "AdDistribution";
    public static final java.lang.String _DestinationUrl = "DestinationUrl";
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
    public static final java.lang.String _DeviceType = "DeviceType";
    public static final java.lang.String _Language = "Language";
    public static final DestinationUrlPerformanceReportColumn AccountName = new DestinationUrlPerformanceReportColumn(_AccountName);
    public static final DestinationUrlPerformanceReportColumn AccountNumber = new DestinationUrlPerformanceReportColumn(_AccountNumber);
    public static final DestinationUrlPerformanceReportColumn TimePeriod = new DestinationUrlPerformanceReportColumn(_TimePeriod);
    public static final DestinationUrlPerformanceReportColumn LanguageAndRegion = new DestinationUrlPerformanceReportColumn(_LanguageAndRegion);
    public static final DestinationUrlPerformanceReportColumn CampaignName = new DestinationUrlPerformanceReportColumn(_CampaignName);
    public static final DestinationUrlPerformanceReportColumn CampaignId = new DestinationUrlPerformanceReportColumn(_CampaignId);
    public static final DestinationUrlPerformanceReportColumn AdGroupName = new DestinationUrlPerformanceReportColumn(_AdGroupName);
    public static final DestinationUrlPerformanceReportColumn AdGroupId = new DestinationUrlPerformanceReportColumn(_AdGroupId);
    public static final DestinationUrlPerformanceReportColumn AdId = new DestinationUrlPerformanceReportColumn(_AdId);
    public static final DestinationUrlPerformanceReportColumn CurrencyCode = new DestinationUrlPerformanceReportColumn(_CurrencyCode);
    public static final DestinationUrlPerformanceReportColumn AdDistribution = new DestinationUrlPerformanceReportColumn(_AdDistribution);
    public static final DestinationUrlPerformanceReportColumn DestinationUrl = new DestinationUrlPerformanceReportColumn(_DestinationUrl);
    public static final DestinationUrlPerformanceReportColumn Impressions = new DestinationUrlPerformanceReportColumn(_Impressions);
    public static final DestinationUrlPerformanceReportColumn Clicks = new DestinationUrlPerformanceReportColumn(_Clicks);
    public static final DestinationUrlPerformanceReportColumn Ctr = new DestinationUrlPerformanceReportColumn(_Ctr);
    public static final DestinationUrlPerformanceReportColumn AverageCpc = new DestinationUrlPerformanceReportColumn(_AverageCpc);
    public static final DestinationUrlPerformanceReportColumn Spend = new DestinationUrlPerformanceReportColumn(_Spend);
    public static final DestinationUrlPerformanceReportColumn AveragePosition = new DestinationUrlPerformanceReportColumn(_AveragePosition);
    public static final DestinationUrlPerformanceReportColumn Conversions = new DestinationUrlPerformanceReportColumn(_Conversions);
    public static final DestinationUrlPerformanceReportColumn ConversionRate = new DestinationUrlPerformanceReportColumn(_ConversionRate);
    public static final DestinationUrlPerformanceReportColumn CostPerConversion = new DestinationUrlPerformanceReportColumn(_CostPerConversion);
    public static final DestinationUrlPerformanceReportColumn AverageCpm = new DestinationUrlPerformanceReportColumn(_AverageCpm);
    public static final DestinationUrlPerformanceReportColumn PricingModel = new DestinationUrlPerformanceReportColumn(_PricingModel);
    public static final DestinationUrlPerformanceReportColumn DeviceType = new DestinationUrlPerformanceReportColumn(_DeviceType);
    public static final DestinationUrlPerformanceReportColumn Language = new DestinationUrlPerformanceReportColumn(_Language);
    public java.lang.String getValue() { return _value_;}
    public static DestinationUrlPerformanceReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        DestinationUrlPerformanceReportColumn enumeration = (DestinationUrlPerformanceReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static DestinationUrlPerformanceReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(DestinationUrlPerformanceReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DestinationUrlPerformanceReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
