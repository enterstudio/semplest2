/**
 * AdDynamicTextPerformanceReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class AdDynamicTextPerformanceReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AdDynamicTextPerformanceReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _AccountNumber = "AccountNumber";
    public static final java.lang.String _TimePeriod = "TimePeriod";
    public static final java.lang.String _LanguageAndRegion = "LanguageAndRegion";
    public static final java.lang.String _AdGroupName = "AdGroupName";
    public static final java.lang.String _AdGroupId = "AdGroupId";
    public static final java.lang.String _Keyword = "Keyword";
    public static final java.lang.String _AdId = "AdId";
    public static final java.lang.String _AdTitle = "AdTitle";
    public static final java.lang.String _AdType = "AdType";
    public static final java.lang.String _DestinationUrl = "DestinationUrl";
    public static final java.lang.String _Param1 = "Param1";
    public static final java.lang.String _Param2 = "Param2";
    public static final java.lang.String _Param3 = "Param3";
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
    public static final java.lang.String _DeviceType = "DeviceType";
    public static final java.lang.String _Language = "Language";
    public static final AdDynamicTextPerformanceReportColumn AccountName = new AdDynamicTextPerformanceReportColumn(_AccountName);
    public static final AdDynamicTextPerformanceReportColumn AccountNumber = new AdDynamicTextPerformanceReportColumn(_AccountNumber);
    public static final AdDynamicTextPerformanceReportColumn TimePeriod = new AdDynamicTextPerformanceReportColumn(_TimePeriod);
    public static final AdDynamicTextPerformanceReportColumn LanguageAndRegion = new AdDynamicTextPerformanceReportColumn(_LanguageAndRegion);
    public static final AdDynamicTextPerformanceReportColumn AdGroupName = new AdDynamicTextPerformanceReportColumn(_AdGroupName);
    public static final AdDynamicTextPerformanceReportColumn AdGroupId = new AdDynamicTextPerformanceReportColumn(_AdGroupId);
    public static final AdDynamicTextPerformanceReportColumn Keyword = new AdDynamicTextPerformanceReportColumn(_Keyword);
    public static final AdDynamicTextPerformanceReportColumn AdId = new AdDynamicTextPerformanceReportColumn(_AdId);
    public static final AdDynamicTextPerformanceReportColumn AdTitle = new AdDynamicTextPerformanceReportColumn(_AdTitle);
    public static final AdDynamicTextPerformanceReportColumn AdType = new AdDynamicTextPerformanceReportColumn(_AdType);
    public static final AdDynamicTextPerformanceReportColumn DestinationUrl = new AdDynamicTextPerformanceReportColumn(_DestinationUrl);
    public static final AdDynamicTextPerformanceReportColumn Param1 = new AdDynamicTextPerformanceReportColumn(_Param1);
    public static final AdDynamicTextPerformanceReportColumn Param2 = new AdDynamicTextPerformanceReportColumn(_Param2);
    public static final AdDynamicTextPerformanceReportColumn Param3 = new AdDynamicTextPerformanceReportColumn(_Param3);
    public static final AdDynamicTextPerformanceReportColumn CurrencyCode = new AdDynamicTextPerformanceReportColumn(_CurrencyCode);
    public static final AdDynamicTextPerformanceReportColumn AdDistribution = new AdDynamicTextPerformanceReportColumn(_AdDistribution);
    public static final AdDynamicTextPerformanceReportColumn Impressions = new AdDynamicTextPerformanceReportColumn(_Impressions);
    public static final AdDynamicTextPerformanceReportColumn Clicks = new AdDynamicTextPerformanceReportColumn(_Clicks);
    public static final AdDynamicTextPerformanceReportColumn Ctr = new AdDynamicTextPerformanceReportColumn(_Ctr);
    public static final AdDynamicTextPerformanceReportColumn AverageCpc = new AdDynamicTextPerformanceReportColumn(_AverageCpc);
    public static final AdDynamicTextPerformanceReportColumn Spend = new AdDynamicTextPerformanceReportColumn(_Spend);
    public static final AdDynamicTextPerformanceReportColumn AveragePosition = new AdDynamicTextPerformanceReportColumn(_AveragePosition);
    public static final AdDynamicTextPerformanceReportColumn Conversions = new AdDynamicTextPerformanceReportColumn(_Conversions);
    public static final AdDynamicTextPerformanceReportColumn ConversionRate = new AdDynamicTextPerformanceReportColumn(_ConversionRate);
    public static final AdDynamicTextPerformanceReportColumn CostPerConversion = new AdDynamicTextPerformanceReportColumn(_CostPerConversion);
    public static final AdDynamicTextPerformanceReportColumn AverageCpm = new AdDynamicTextPerformanceReportColumn(_AverageCpm);
    public static final AdDynamicTextPerformanceReportColumn PricingModel = new AdDynamicTextPerformanceReportColumn(_PricingModel);
    public static final AdDynamicTextPerformanceReportColumn DeviceType = new AdDynamicTextPerformanceReportColumn(_DeviceType);
    public static final AdDynamicTextPerformanceReportColumn Language = new AdDynamicTextPerformanceReportColumn(_Language);
    public java.lang.String getValue() { return _value_;}
    public static AdDynamicTextPerformanceReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        AdDynamicTextPerformanceReportColumn enumeration = (AdDynamicTextPerformanceReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static AdDynamicTextPerformanceReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(AdDynamicTextPerformanceReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdDynamicTextPerformanceReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
