/**
 * BehavioralTargetReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class BehavioralTargetReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected BehavioralTargetReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _AccountNumber = "AccountNumber";
    public static final java.lang.String _AccountId = "AccountId";
    public static final java.lang.String _TimePeriod = "TimePeriod";
    public static final java.lang.String _CurrencyCode = "CurrencyCode";
    public static final java.lang.String _CampaignId = "CampaignId";
    public static final java.lang.String _CampaignName = "CampaignName";
    public static final java.lang.String _LanguageAndRegion = "LanguageAndRegion";
    public static final java.lang.String _BehavioralId = "BehavioralId";
    public static final java.lang.String _AdGroupId = "AdGroupId";
    public static final java.lang.String _AdGroupName = "AdGroupName";
    public static final java.lang.String _AdDistribution = "AdDistribution";
    public static final java.lang.String _Impressions = "Impressions";
    public static final java.lang.String _Clicks = "Clicks";
    public static final java.lang.String _Ctr = "Ctr";
    public static final java.lang.String _AverageCpc = "AverageCpc";
    public static final java.lang.String _Spend = "Spend";
    public static final java.lang.String _AveragePosition = "AveragePosition";
    public static final java.lang.String _AverageCpm = "AverageCpm";
    public static final java.lang.String _PricingModel = "PricingModel";
    public static final BehavioralTargetReportColumn AccountName = new BehavioralTargetReportColumn(_AccountName);
    public static final BehavioralTargetReportColumn AccountNumber = new BehavioralTargetReportColumn(_AccountNumber);
    public static final BehavioralTargetReportColumn AccountId = new BehavioralTargetReportColumn(_AccountId);
    public static final BehavioralTargetReportColumn TimePeriod = new BehavioralTargetReportColumn(_TimePeriod);
    public static final BehavioralTargetReportColumn CurrencyCode = new BehavioralTargetReportColumn(_CurrencyCode);
    public static final BehavioralTargetReportColumn CampaignId = new BehavioralTargetReportColumn(_CampaignId);
    public static final BehavioralTargetReportColumn CampaignName = new BehavioralTargetReportColumn(_CampaignName);
    public static final BehavioralTargetReportColumn LanguageAndRegion = new BehavioralTargetReportColumn(_LanguageAndRegion);
    public static final BehavioralTargetReportColumn BehavioralId = new BehavioralTargetReportColumn(_BehavioralId);
    public static final BehavioralTargetReportColumn AdGroupId = new BehavioralTargetReportColumn(_AdGroupId);
    public static final BehavioralTargetReportColumn AdGroupName = new BehavioralTargetReportColumn(_AdGroupName);
    public static final BehavioralTargetReportColumn AdDistribution = new BehavioralTargetReportColumn(_AdDistribution);
    public static final BehavioralTargetReportColumn Impressions = new BehavioralTargetReportColumn(_Impressions);
    public static final BehavioralTargetReportColumn Clicks = new BehavioralTargetReportColumn(_Clicks);
    public static final BehavioralTargetReportColumn Ctr = new BehavioralTargetReportColumn(_Ctr);
    public static final BehavioralTargetReportColumn AverageCpc = new BehavioralTargetReportColumn(_AverageCpc);
    public static final BehavioralTargetReportColumn Spend = new BehavioralTargetReportColumn(_Spend);
    public static final BehavioralTargetReportColumn AveragePosition = new BehavioralTargetReportColumn(_AveragePosition);
    public static final BehavioralTargetReportColumn AverageCpm = new BehavioralTargetReportColumn(_AverageCpm);
    public static final BehavioralTargetReportColumn PricingModel = new BehavioralTargetReportColumn(_PricingModel);
    public java.lang.String getValue() { return _value_;}
    public static BehavioralTargetReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        BehavioralTargetReportColumn enumeration = (BehavioralTargetReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static BehavioralTargetReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(BehavioralTargetReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BehavioralTargetReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
