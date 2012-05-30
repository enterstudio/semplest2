/**
 * SegmentationReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class SegmentationReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected SegmentationReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _AccountNumber = "AccountNumber";
    public static final java.lang.String _AccountId = "AccountId";
    public static final java.lang.String _TimePeriod = "TimePeriod";
    public static final java.lang.String _CampaignName = "CampaignName";
    public static final java.lang.String _CampaignId = "CampaignId";
    public static final java.lang.String _AdGroupName = "AdGroupName";
    public static final java.lang.String _AdGroupId = "AdGroupId";
    public static final java.lang.String _Keyword = "Keyword";
    public static final java.lang.String _KeywordId = "KeywordId";
    public static final java.lang.String _Goal = "Goal";
    public static final java.lang.String _AgeGroup = "AgeGroup";
    public static final java.lang.String _Gender = "Gender";
    public static final java.lang.String _Country = "Country";
    public static final java.lang.String _State = "State";
    public static final java.lang.String _MetroArea = "MetroArea";
    public static final java.lang.String _Step1Count = "Step1Count";
    public static final java.lang.String _Step2Count = "Step2Count";
    public static final java.lang.String _Step3Count = "Step3Count";
    public static final java.lang.String _Step4Count = "Step4Count";
    public static final java.lang.String _Step5Count = "Step5Count";
    public static final java.lang.String _Conversions = "Conversions";
    public static final java.lang.String _Assists = "Assists";
    public static final java.lang.String _Spend = "Spend";
    public static final java.lang.String _FunnelConversionRate = "FunnelConversionRate";
    public static final java.lang.String _Revenue = "Revenue";
    public static final java.lang.String _ReturnOnAdSpend = "ReturnOnAdSpend";
    public static final SegmentationReportColumn AccountName = new SegmentationReportColumn(_AccountName);
    public static final SegmentationReportColumn AccountNumber = new SegmentationReportColumn(_AccountNumber);
    public static final SegmentationReportColumn AccountId = new SegmentationReportColumn(_AccountId);
    public static final SegmentationReportColumn TimePeriod = new SegmentationReportColumn(_TimePeriod);
    public static final SegmentationReportColumn CampaignName = new SegmentationReportColumn(_CampaignName);
    public static final SegmentationReportColumn CampaignId = new SegmentationReportColumn(_CampaignId);
    public static final SegmentationReportColumn AdGroupName = new SegmentationReportColumn(_AdGroupName);
    public static final SegmentationReportColumn AdGroupId = new SegmentationReportColumn(_AdGroupId);
    public static final SegmentationReportColumn Keyword = new SegmentationReportColumn(_Keyword);
    public static final SegmentationReportColumn KeywordId = new SegmentationReportColumn(_KeywordId);
    public static final SegmentationReportColumn Goal = new SegmentationReportColumn(_Goal);
    public static final SegmentationReportColumn AgeGroup = new SegmentationReportColumn(_AgeGroup);
    public static final SegmentationReportColumn Gender = new SegmentationReportColumn(_Gender);
    public static final SegmentationReportColumn Country = new SegmentationReportColumn(_Country);
    public static final SegmentationReportColumn State = new SegmentationReportColumn(_State);
    public static final SegmentationReportColumn MetroArea = new SegmentationReportColumn(_MetroArea);
    public static final SegmentationReportColumn Step1Count = new SegmentationReportColumn(_Step1Count);
    public static final SegmentationReportColumn Step2Count = new SegmentationReportColumn(_Step2Count);
    public static final SegmentationReportColumn Step3Count = new SegmentationReportColumn(_Step3Count);
    public static final SegmentationReportColumn Step4Count = new SegmentationReportColumn(_Step4Count);
    public static final SegmentationReportColumn Step5Count = new SegmentationReportColumn(_Step5Count);
    public static final SegmentationReportColumn Conversions = new SegmentationReportColumn(_Conversions);
    public static final SegmentationReportColumn Assists = new SegmentationReportColumn(_Assists);
    public static final SegmentationReportColumn Spend = new SegmentationReportColumn(_Spend);
    public static final SegmentationReportColumn FunnelConversionRate = new SegmentationReportColumn(_FunnelConversionRate);
    public static final SegmentationReportColumn Revenue = new SegmentationReportColumn(_Revenue);
    public static final SegmentationReportColumn ReturnOnAdSpend = new SegmentationReportColumn(_ReturnOnAdSpend);
    public java.lang.String getValue() { return _value_;}
    public static SegmentationReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        SegmentationReportColumn enumeration = (SegmentationReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static SegmentationReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(SegmentationReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SegmentationReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
