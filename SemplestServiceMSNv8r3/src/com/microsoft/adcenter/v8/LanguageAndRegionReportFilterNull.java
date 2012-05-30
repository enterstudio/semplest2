/**
 * LanguageAndRegionReportFilterNull.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class LanguageAndRegionReportFilterNull implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected LanguageAndRegionReportFilterNull(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _EnglishCanada = "EnglishCanada";
    public static final java.lang.String _FrenchCanada = "FrenchCanada";
    public static final java.lang.String _France = "France";
    public static final java.lang.String _Singapore = "Singapore";
    public static final java.lang.String _UnitedKingdom = "UnitedKingdom";
    public static final java.lang.String _UnitedStates = "UnitedStates";
    public static final LanguageAndRegionReportFilterNull EnglishCanada = new LanguageAndRegionReportFilterNull(_EnglishCanada);
    public static final LanguageAndRegionReportFilterNull FrenchCanada = new LanguageAndRegionReportFilterNull(_FrenchCanada);
    public static final LanguageAndRegionReportFilterNull France = new LanguageAndRegionReportFilterNull(_France);
    public static final LanguageAndRegionReportFilterNull Singapore = new LanguageAndRegionReportFilterNull(_Singapore);
    public static final LanguageAndRegionReportFilterNull UnitedKingdom = new LanguageAndRegionReportFilterNull(_UnitedKingdom);
    public static final LanguageAndRegionReportFilterNull UnitedStates = new LanguageAndRegionReportFilterNull(_UnitedStates);
    public java.lang.String getValue() { return _value_;}
    public static LanguageAndRegionReportFilterNull fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        LanguageAndRegionReportFilterNull enumeration = (LanguageAndRegionReportFilterNull)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static LanguageAndRegionReportFilterNull fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(LanguageAndRegionReportFilterNull.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "LanguageAndRegionReportFilter>null"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
