/**
 * AdGroupStatusReportFilterNull.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class AdGroupStatusReportFilterNull implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AdGroupStatusReportFilterNull(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Submitted = "Submitted";
    public static final java.lang.String _Deleted = "Deleted";
    public static final java.lang.String _Expired = "Expired";
    public static final java.lang.String _Draft = "Draft";
    public static final java.lang.String _Paused = "Paused";
    public static final java.lang.String _Active = "Active";
    public static final AdGroupStatusReportFilterNull Submitted = new AdGroupStatusReportFilterNull(_Submitted);
    public static final AdGroupStatusReportFilterNull Deleted = new AdGroupStatusReportFilterNull(_Deleted);
    public static final AdGroupStatusReportFilterNull Expired = new AdGroupStatusReportFilterNull(_Expired);
    public static final AdGroupStatusReportFilterNull Draft = new AdGroupStatusReportFilterNull(_Draft);
    public static final AdGroupStatusReportFilterNull Paused = new AdGroupStatusReportFilterNull(_Paused);
    public static final AdGroupStatusReportFilterNull Active = new AdGroupStatusReportFilterNull(_Active);
    public java.lang.String getValue() { return _value_;}
    public static AdGroupStatusReportFilterNull fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        AdGroupStatusReportFilterNull enumeration = (AdGroupStatusReportFilterNull)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static AdGroupStatusReportFilterNull fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(AdGroupStatusReportFilterNull.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupStatusReportFilter>null"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
