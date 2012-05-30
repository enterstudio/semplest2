/**
 * TrafficSourcesReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class TrafficSourcesReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected TrafficSourcesReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _AccountNumber = "AccountNumber";
    public static final java.lang.String _AccountId = "AccountId";
    public static final java.lang.String _TimePeriod = "TimePeriod";
    public static final java.lang.String _Source = "Source";
    public static final java.lang.String _Goal = "Goal";
    public static final java.lang.String _Step1Count = "Step1Count";
    public static final java.lang.String _Step2Count = "Step2Count";
    public static final java.lang.String _Step3Count = "Step3Count";
    public static final java.lang.String _Step4Count = "Step4Count";
    public static final java.lang.String _Step5Count = "Step5Count";
    public static final java.lang.String _Conversions = "Conversions";
    public static final java.lang.String _Assists = "Assists";
    public static final java.lang.String _FunnelConversionRate = "FunnelConversionRate";
    public static final java.lang.String _Revenue = "Revenue";
    public static final java.lang.String _RevenuePerConversion = "RevenuePerConversion";
    public static final TrafficSourcesReportColumn AccountName = new TrafficSourcesReportColumn(_AccountName);
    public static final TrafficSourcesReportColumn AccountNumber = new TrafficSourcesReportColumn(_AccountNumber);
    public static final TrafficSourcesReportColumn AccountId = new TrafficSourcesReportColumn(_AccountId);
    public static final TrafficSourcesReportColumn TimePeriod = new TrafficSourcesReportColumn(_TimePeriod);
    public static final TrafficSourcesReportColumn Source = new TrafficSourcesReportColumn(_Source);
    public static final TrafficSourcesReportColumn Goal = new TrafficSourcesReportColumn(_Goal);
    public static final TrafficSourcesReportColumn Step1Count = new TrafficSourcesReportColumn(_Step1Count);
    public static final TrafficSourcesReportColumn Step2Count = new TrafficSourcesReportColumn(_Step2Count);
    public static final TrafficSourcesReportColumn Step3Count = new TrafficSourcesReportColumn(_Step3Count);
    public static final TrafficSourcesReportColumn Step4Count = new TrafficSourcesReportColumn(_Step4Count);
    public static final TrafficSourcesReportColumn Step5Count = new TrafficSourcesReportColumn(_Step5Count);
    public static final TrafficSourcesReportColumn Conversions = new TrafficSourcesReportColumn(_Conversions);
    public static final TrafficSourcesReportColumn Assists = new TrafficSourcesReportColumn(_Assists);
    public static final TrafficSourcesReportColumn FunnelConversionRate = new TrafficSourcesReportColumn(_FunnelConversionRate);
    public static final TrafficSourcesReportColumn Revenue = new TrafficSourcesReportColumn(_Revenue);
    public static final TrafficSourcesReportColumn RevenuePerConversion = new TrafficSourcesReportColumn(_RevenuePerConversion);
    public java.lang.String getValue() { return _value_;}
    public static TrafficSourcesReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        TrafficSourcesReportColumn enumeration = (TrafficSourcesReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static TrafficSourcesReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(TrafficSourcesReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TrafficSourcesReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
