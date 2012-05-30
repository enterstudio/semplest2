/**
 * BehavioralPerformanceReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class BehavioralPerformanceReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected BehavioralPerformanceReportColumn(java.lang.String value) {
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
    public static final java.lang.String _BehavioralId = "BehavioralId";
    public static final java.lang.String _BehavioralName = "BehavioralName";
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
    public static final BehavioralPerformanceReportColumn AccountName = new BehavioralPerformanceReportColumn(_AccountName);
    public static final BehavioralPerformanceReportColumn AccountNumber = new BehavioralPerformanceReportColumn(_AccountNumber);
    public static final BehavioralPerformanceReportColumn AccountId = new BehavioralPerformanceReportColumn(_AccountId);
    public static final BehavioralPerformanceReportColumn TimePeriod = new BehavioralPerformanceReportColumn(_TimePeriod);
    public static final BehavioralPerformanceReportColumn LanguageAndRegion = new BehavioralPerformanceReportColumn(_LanguageAndRegion);
    public static final BehavioralPerformanceReportColumn CampaignName = new BehavioralPerformanceReportColumn(_CampaignName);
    public static final BehavioralPerformanceReportColumn CampaignId = new BehavioralPerformanceReportColumn(_CampaignId);
    public static final BehavioralPerformanceReportColumn AdGroupName = new BehavioralPerformanceReportColumn(_AdGroupName);
    public static final BehavioralPerformanceReportColumn AdGroupId = new BehavioralPerformanceReportColumn(_AdGroupId);
    public static final BehavioralPerformanceReportColumn BehavioralId = new BehavioralPerformanceReportColumn(_BehavioralId);
    public static final BehavioralPerformanceReportColumn BehavioralName = new BehavioralPerformanceReportColumn(_BehavioralName);
    public static final BehavioralPerformanceReportColumn AdId = new BehavioralPerformanceReportColumn(_AdId);
    public static final BehavioralPerformanceReportColumn DestinationUrl = new BehavioralPerformanceReportColumn(_DestinationUrl);
    public static final BehavioralPerformanceReportColumn CurrentMaxCpc = new BehavioralPerformanceReportColumn(_CurrentMaxCpc);
    public static final BehavioralPerformanceReportColumn CurrencyCode = new BehavioralPerformanceReportColumn(_CurrencyCode);
    public static final BehavioralPerformanceReportColumn MatchType = new BehavioralPerformanceReportColumn(_MatchType);
    public static final BehavioralPerformanceReportColumn AdDistribution = new BehavioralPerformanceReportColumn(_AdDistribution);
    public static final BehavioralPerformanceReportColumn Impressions = new BehavioralPerformanceReportColumn(_Impressions);
    public static final BehavioralPerformanceReportColumn Clicks = new BehavioralPerformanceReportColumn(_Clicks);
    public static final BehavioralPerformanceReportColumn Ctr = new BehavioralPerformanceReportColumn(_Ctr);
    public static final BehavioralPerformanceReportColumn AverageCpc = new BehavioralPerformanceReportColumn(_AverageCpc);
    public static final BehavioralPerformanceReportColumn Spend = new BehavioralPerformanceReportColumn(_Spend);
    public static final BehavioralPerformanceReportColumn AveragePosition = new BehavioralPerformanceReportColumn(_AveragePosition);
    public static final BehavioralPerformanceReportColumn Conversions = new BehavioralPerformanceReportColumn(_Conversions);
    public static final BehavioralPerformanceReportColumn ConversionRate = new BehavioralPerformanceReportColumn(_ConversionRate);
    public static final BehavioralPerformanceReportColumn CostPerConversion = new BehavioralPerformanceReportColumn(_CostPerConversion);
    public static final BehavioralPerformanceReportColumn AdType = new BehavioralPerformanceReportColumn(_AdType);
    public static final BehavioralPerformanceReportColumn AverageCpm = new BehavioralPerformanceReportColumn(_AverageCpm);
    public static final BehavioralPerformanceReportColumn PricingModel = new BehavioralPerformanceReportColumn(_PricingModel);
    public java.lang.String getValue() { return _value_;}
    public static BehavioralPerformanceReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        BehavioralPerformanceReportColumn enumeration = (BehavioralPerformanceReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static BehavioralPerformanceReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(BehavioralPerformanceReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BehavioralPerformanceReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
