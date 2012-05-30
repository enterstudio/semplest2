/**
 * SitePerformanceReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class SitePerformanceReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected SitePerformanceReportColumn(java.lang.String value) {
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
    public static final java.lang.String _Site = "Site";
    public static final java.lang.String _SiteId = "SiteId";
    public static final java.lang.String _AdId = "AdId";
    public static final java.lang.String _DestinationUrl = "DestinationUrl";
    public static final java.lang.String _CurrentMaxCpc = "CurrentMaxCpc";
    public static final java.lang.String _CurrencyCode = "CurrencyCode";
    public static final java.lang.String _MatchType = "MatchType";
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
    public static final java.lang.String _AdType = "AdType";
    public static final java.lang.String _AverageCpm = "AverageCpm";
    public static final java.lang.String _PricingModel = "PricingModel";
    public static final java.lang.String _DeviceType = "DeviceType";
    public static final java.lang.String _Language = "Language";
    public static final SitePerformanceReportColumn AccountName = new SitePerformanceReportColumn(_AccountName);
    public static final SitePerformanceReportColumn AccountNumber = new SitePerformanceReportColumn(_AccountNumber);
    public static final SitePerformanceReportColumn AccountId = new SitePerformanceReportColumn(_AccountId);
    public static final SitePerformanceReportColumn TimePeriod = new SitePerformanceReportColumn(_TimePeriod);
    public static final SitePerformanceReportColumn LanguageAndRegion = new SitePerformanceReportColumn(_LanguageAndRegion);
    public static final SitePerformanceReportColumn CampaignName = new SitePerformanceReportColumn(_CampaignName);
    public static final SitePerformanceReportColumn CampaignId = new SitePerformanceReportColumn(_CampaignId);
    public static final SitePerformanceReportColumn AdGroupName = new SitePerformanceReportColumn(_AdGroupName);
    public static final SitePerformanceReportColumn AdGroupId = new SitePerformanceReportColumn(_AdGroupId);
    public static final SitePerformanceReportColumn Site = new SitePerformanceReportColumn(_Site);
    public static final SitePerformanceReportColumn SiteId = new SitePerformanceReportColumn(_SiteId);
    public static final SitePerformanceReportColumn AdId = new SitePerformanceReportColumn(_AdId);
    public static final SitePerformanceReportColumn DestinationUrl = new SitePerformanceReportColumn(_DestinationUrl);
    public static final SitePerformanceReportColumn CurrentMaxCpc = new SitePerformanceReportColumn(_CurrentMaxCpc);
    public static final SitePerformanceReportColumn CurrencyCode = new SitePerformanceReportColumn(_CurrencyCode);
    public static final SitePerformanceReportColumn MatchType = new SitePerformanceReportColumn(_MatchType);
    public static final SitePerformanceReportColumn AdDistribution = new SitePerformanceReportColumn(_AdDistribution);
    public static final SitePerformanceReportColumn Impressions = new SitePerformanceReportColumn(_Impressions);
    public static final SitePerformanceReportColumn Clicks = new SitePerformanceReportColumn(_Clicks);
    public static final SitePerformanceReportColumn Ctr = new SitePerformanceReportColumn(_Ctr);
    public static final SitePerformanceReportColumn AverageCpc = new SitePerformanceReportColumn(_AverageCpc);
    public static final SitePerformanceReportColumn Spend = new SitePerformanceReportColumn(_Spend);
    public static final SitePerformanceReportColumn AveragePosition = new SitePerformanceReportColumn(_AveragePosition);
    public static final SitePerformanceReportColumn Conversions = new SitePerformanceReportColumn(_Conversions);
    public static final SitePerformanceReportColumn ConversionRate = new SitePerformanceReportColumn(_ConversionRate);
    public static final SitePerformanceReportColumn CostPerConversion = new SitePerformanceReportColumn(_CostPerConversion);
    public static final SitePerformanceReportColumn AdType = new SitePerformanceReportColumn(_AdType);
    public static final SitePerformanceReportColumn AverageCpm = new SitePerformanceReportColumn(_AverageCpm);
    public static final SitePerformanceReportColumn PricingModel = new SitePerformanceReportColumn(_PricingModel);
    public static final SitePerformanceReportColumn DeviceType = new SitePerformanceReportColumn(_DeviceType);
    public static final SitePerformanceReportColumn Language = new SitePerformanceReportColumn(_Language);
    public java.lang.String getValue() { return _value_;}
    public static SitePerformanceReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        SitePerformanceReportColumn enumeration = (SitePerformanceReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static SitePerformanceReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(SitePerformanceReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SitePerformanceReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
