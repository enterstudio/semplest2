/**
 * AgeGroupReportFilterNull.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class AgeGroupReportFilterNull implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AgeGroupReportFilterNull(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Unknown = "Unknown";
    public static final java.lang.String _Ages0to12 = "Ages0to12";
    public static final java.lang.String _Ages13to17 = "Ages13to17";
    public static final java.lang.String _Ages18to24 = "Ages18to24";
    public static final java.lang.String _Ages25to34 = "Ages25to34";
    public static final java.lang.String _Ages35to49 = "Ages35to49";
    public static final java.lang.String _Ages50to64 = "Ages50to64";
    public static final java.lang.String _Ages65plus = "Ages65plus";
    public static final AgeGroupReportFilterNull Unknown = new AgeGroupReportFilterNull(_Unknown);
    public static final AgeGroupReportFilterNull Ages0to12 = new AgeGroupReportFilterNull(_Ages0to12);
    public static final AgeGroupReportFilterNull Ages13to17 = new AgeGroupReportFilterNull(_Ages13to17);
    public static final AgeGroupReportFilterNull Ages18to24 = new AgeGroupReportFilterNull(_Ages18to24);
    public static final AgeGroupReportFilterNull Ages25to34 = new AgeGroupReportFilterNull(_Ages25to34);
    public static final AgeGroupReportFilterNull Ages35to49 = new AgeGroupReportFilterNull(_Ages35to49);
    public static final AgeGroupReportFilterNull Ages50to64 = new AgeGroupReportFilterNull(_Ages50to64);
    public static final AgeGroupReportFilterNull Ages65plus = new AgeGroupReportFilterNull(_Ages65plus);
    public java.lang.String getValue() { return _value_;}
    public static AgeGroupReportFilterNull fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        AgeGroupReportFilterNull enumeration = (AgeGroupReportFilterNull)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static AgeGroupReportFilterNull fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(AgeGroupReportFilterNull.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeGroupReportFilter>null"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
