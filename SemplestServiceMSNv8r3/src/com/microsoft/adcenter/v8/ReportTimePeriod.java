/**
 * ReportTimePeriod.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class ReportTimePeriod implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected ReportTimePeriod(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Today = "Today";
    public static final java.lang.String _Yesterday = "Yesterday";
    public static final java.lang.String _LastSevenDays = "LastSevenDays";
    public static final java.lang.String _ThisWeek = "ThisWeek";
    public static final java.lang.String _LastWeek = "LastWeek";
    public static final java.lang.String _LastFourWeeks = "LastFourWeeks";
    public static final java.lang.String _ThisMonth = "ThisMonth";
    public static final java.lang.String _LastMonth = "LastMonth";
    public static final java.lang.String _LastThreeMonths = "LastThreeMonths";
    public static final java.lang.String _LastSixMonths = "LastSixMonths";
    public static final java.lang.String _ThisYear = "ThisYear";
    public static final java.lang.String _LastYear = "LastYear";
    public static final ReportTimePeriod Today = new ReportTimePeriod(_Today);
    public static final ReportTimePeriod Yesterday = new ReportTimePeriod(_Yesterday);
    public static final ReportTimePeriod LastSevenDays = new ReportTimePeriod(_LastSevenDays);
    public static final ReportTimePeriod ThisWeek = new ReportTimePeriod(_ThisWeek);
    public static final ReportTimePeriod LastWeek = new ReportTimePeriod(_LastWeek);
    public static final ReportTimePeriod LastFourWeeks = new ReportTimePeriod(_LastFourWeeks);
    public static final ReportTimePeriod ThisMonth = new ReportTimePeriod(_ThisMonth);
    public static final ReportTimePeriod LastMonth = new ReportTimePeriod(_LastMonth);
    public static final ReportTimePeriod LastThreeMonths = new ReportTimePeriod(_LastThreeMonths);
    public static final ReportTimePeriod LastSixMonths = new ReportTimePeriod(_LastSixMonths);
    public static final ReportTimePeriod ThisYear = new ReportTimePeriod(_ThisYear);
    public static final ReportTimePeriod LastYear = new ReportTimePeriod(_LastYear);
    public java.lang.String getValue() { return _value_;}
    public static ReportTimePeriod fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        ReportTimePeriod enumeration = (ReportTimePeriod)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static ReportTimePeriod fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(ReportTimePeriod.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportTimePeriod"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
