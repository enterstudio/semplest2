/**
 * AdExtensionByAdsReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class AdExtensionByAdsReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AdExtensionByAdsReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _TimePeriod = "TimePeriod";
    public static final java.lang.String _CampaignName = "CampaignName";
    public static final java.lang.String _CampaignId = "CampaignId";
    public static final java.lang.String _AdGroupName = "AdGroupName";
    public static final java.lang.String _AdGroupId = "AdGroupId";
    public static final java.lang.String _AdTitle = "AdTitle";
    public static final java.lang.String _AdId = "AdId";
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
    public static final AdExtensionByAdsReportColumn AccountName = new AdExtensionByAdsReportColumn(_AccountName);
    public static final AdExtensionByAdsReportColumn TimePeriod = new AdExtensionByAdsReportColumn(_TimePeriod);
    public static final AdExtensionByAdsReportColumn CampaignName = new AdExtensionByAdsReportColumn(_CampaignName);
    public static final AdExtensionByAdsReportColumn CampaignId = new AdExtensionByAdsReportColumn(_CampaignId);
    public static final AdExtensionByAdsReportColumn AdGroupName = new AdExtensionByAdsReportColumn(_AdGroupName);
    public static final AdExtensionByAdsReportColumn AdGroupId = new AdExtensionByAdsReportColumn(_AdGroupId);
    public static final AdExtensionByAdsReportColumn AdTitle = new AdExtensionByAdsReportColumn(_AdTitle);
    public static final AdExtensionByAdsReportColumn AdId = new AdExtensionByAdsReportColumn(_AdId);
    public static final AdExtensionByAdsReportColumn AdExtensionType = new AdExtensionByAdsReportColumn(_AdExtensionType);
    public static final AdExtensionByAdsReportColumn DeviceType = new AdExtensionByAdsReportColumn(_DeviceType);
    public static final AdExtensionByAdsReportColumn DeviceOS = new AdExtensionByAdsReportColumn(_DeviceOS);
    public static final AdExtensionByAdsReportColumn Impressions = new AdExtensionByAdsReportColumn(_Impressions);
    public static final AdExtensionByAdsReportColumn Clicks = new AdExtensionByAdsReportColumn(_Clicks);
    public static final AdExtensionByAdsReportColumn TotalClicks = new AdExtensionByAdsReportColumn(_TotalClicks);
    public static final AdExtensionByAdsReportColumn Conversions = new AdExtensionByAdsReportColumn(_Conversions);
    public static final AdExtensionByAdsReportColumn Ctr = new AdExtensionByAdsReportColumn(_Ctr);
    public static final AdExtensionByAdsReportColumn AverageCpc = new AdExtensionByAdsReportColumn(_AverageCpc);
    public static final AdExtensionByAdsReportColumn ConversionRate = new AdExtensionByAdsReportColumn(_ConversionRate);
    public static final AdExtensionByAdsReportColumn Spend = new AdExtensionByAdsReportColumn(_Spend);
    public static final AdExtensionByAdsReportColumn AdExtensionId = new AdExtensionByAdsReportColumn(_AdExtensionId);
    public static final AdExtensionByAdsReportColumn AdExtensionVersion = new AdExtensionByAdsReportColumn(_AdExtensionVersion);
    public static final AdExtensionByAdsReportColumn AccountNumber = new AdExtensionByAdsReportColumn(_AccountNumber);
    public static final AdExtensionByAdsReportColumn AccountId = new AdExtensionByAdsReportColumn(_AccountId);
    public java.lang.String getValue() { return _value_;}
    public static AdExtensionByAdsReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        AdExtensionByAdsReportColumn enumeration = (AdExtensionByAdsReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static AdExtensionByAdsReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(AdExtensionByAdsReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionByAdsReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
