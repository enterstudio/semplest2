/**
 * CountryReportFilterNull.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class CountryReportFilterNull implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected CountryReportFilterNull(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Canada = "Canada";
    public static final java.lang.String _France = "France";
    public static final java.lang.String _Singapore = "Singapore";
    public static final java.lang.String _UnitedKingdom = "UnitedKingdom";
    public static final java.lang.String _UnitedStates = "UnitedStates";
    public static final CountryReportFilterNull Canada = new CountryReportFilterNull(_Canada);
    public static final CountryReportFilterNull France = new CountryReportFilterNull(_France);
    public static final CountryReportFilterNull Singapore = new CountryReportFilterNull(_Singapore);
    public static final CountryReportFilterNull UnitedKingdom = new CountryReportFilterNull(_UnitedKingdom);
    public static final CountryReportFilterNull UnitedStates = new CountryReportFilterNull(_UnitedStates);
    public java.lang.String getValue() { return _value_;}
    public static CountryReportFilterNull fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        CountryReportFilterNull enumeration = (CountryReportFilterNull)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static CountryReportFilterNull fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(CountryReportFilterNull.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CountryReportFilter>null"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
