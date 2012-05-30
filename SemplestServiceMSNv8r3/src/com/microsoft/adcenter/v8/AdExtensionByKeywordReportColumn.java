/**
 * AdExtensionByKeywordReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class AdExtensionByKeywordReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AdExtensionByKeywordReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _TimePeriod = "TimePeriod";
    public static final java.lang.String _CampaignName = "CampaignName";
    public static final java.lang.String _CampaignId = "CampaignId";
    public static final java.lang.String _AdGroupName = "AdGroupName";
    public static final java.lang.String _AdGroupId = "AdGroupId";
    public static final java.lang.String _Keyword = "Keyword";
    public static final java.lang.String _KeywordId = "KeywordId";
    public static final java.lang.String _AdExtensionType = "AdExtensionType";
    public static final java.lang.String _DeviceType = "DeviceType";
    public static final java.lang.String _DeviceOS = "DeviceOS";
    public static final java.lang.String _Impressions = "Impressions";
    public static final java.lang.String _Clicks = "Clicks";
    public static final java.lang.String _TotalClicks = "TotalClicks";
    public static final java.lang.String _Conversions = "Conversions";
    public static final java.lang.String _Ctr = "Ctr";
    public static final java.lang.String _AverageCpc = "AverageCpc";
    public static final java.lang.String _ConversionRate = "ConversionRate";
    public static final java.lang.String _Spend = "Spend";
    public static final java.lang.String _AdExtensionId = "AdExtensionId";
    public static final java.lang.String _AdExtensionVersion = "AdExtensionVersion";
    public static final java.lang.String _AccountNumber = "AccountNumber";
    public static final java.lang.String _AccountId = "AccountId";
    public static final AdExtensionByKeywordReportColumn AccountName = new AdExtensionByKeywordReportColumn(_AccountName);
    public static final AdExtensionByKeywordReportColumn TimePeriod = new AdExtensionByKeywordReportColumn(_TimePeriod);
    public static final AdExtensionByKeywordReportColumn CampaignName = new AdExtensionByKeywordReportColumn(_CampaignName);
    public static final AdExtensionByKeywordReportColumn CampaignId = new AdExtensionByKeywordReportColumn(_CampaignId);
    public static final AdExtensionByKeywordReportColumn AdGroupName = new AdExtensionByKeywordReportColumn(_AdGroupName);
    public static final AdExtensionByKeywordReportColumn AdGroupId = new AdExtensionByKeywordReportColumn(_AdGroupId);
    public static final AdExtensionByKeywordReportColumn Keyword = new AdExtensionByKeywordReportColumn(_Keyword);
    public static final AdExtensionByKeywordReportColumn KeywordId = new AdExtensionByKeywordReportColumn(_KeywordId);
    public static final AdExtensionByKeywordReportColumn AdExtensionType = new AdExtensionByKeywordReportColumn(_AdExtensionType);
    public static final AdExtensionByKeywordReportColumn DeviceType = new AdExtensionByKeywordReportColumn(_DeviceType);
    public static final AdExtensionByKeywordReportColumn DeviceOS = new AdExtensionByKeywordReportColumn(_DeviceOS);
    public static final AdExtensionByKeywordReportColumn Impressions = new AdExtensionByKeywordReportColumn(_Impressions);
    public static final AdExtensionByKeywordReportColumn Clicks = new AdExtensionByKeywordReportColumn(_Clicks);
    public static final AdExtensionByKeywordReportColumn TotalClicks = new AdExtensionByKeywordReportColumn(_TotalClicks);
    public static final AdExtensionByKeywordReportColumn Conversions = new AdExtensionByKeywordReportColumn(_Conversions);
    public static final AdExtensionByKeywordReportColumn Ctr = new AdExtensionByKeywordReportColumn(_Ctr);
    public static final AdExtensionByKeywordReportColumn AverageCpc = new AdExtensionByKeywordReportColumn(_AverageCpc);
    public static final AdExtensionByKeywordReportColumn ConversionRate = new AdExtensionByKeywordReportColumn(_ConversionRate);
    public static final AdExtensionByKeywordReportColumn Spend = new AdExtensionByKeywordReportColumn(_Spend);
    public static final AdExtensionByKeywordReportColumn AdExtensionId = new AdExtensionByKeywordReportColumn(_AdExtensionId);
    public static final AdExtensionByKeywordReportColumn AdExtensionVersion = new AdExtensionByKeywordReportColumn(_AdExtensionVersion);
    public static final AdExtensionByKeywordReportColumn AccountNumber = new AdExtensionByKeywordReportColumn(_AccountNumber);
    public static final AdExtensionByKeywordReportColumn AccountId = new AdExtensionByKeywordReportColumn(_AccountId);
    public java.lang.String getValue() { return _value_;}
    public static AdExtensionByKeywordReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        AdExtensionByKeywordReportColumn enumeration = (AdExtensionByKeywordReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static AdExtensionByKeywordReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(AdExtensionByKeywordReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionByKeywordReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
