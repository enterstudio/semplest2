/**
 * HourRange.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class HourRange implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected HourRange(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _ThreeAMToSevenAM = "ThreeAMToSevenAM";
    public static final java.lang.String _SevenAMToElevenAM = "SevenAMToElevenAM";
    public static final java.lang.String _ElevenAMToTwoPM = "ElevenAMToTwoPM";
    public static final java.lang.String _TwoPMToSixPM = "TwoPMToSixPM";
    public static final java.lang.String _SixPMToElevenPM = "SixPMToElevenPM";
    public static final java.lang.String _ElevenPMToThreeAM = "ElevenPMToThreeAM";
    public static final HourRange ThreeAMToSevenAM = new HourRange(_ThreeAMToSevenAM);
    public static final HourRange SevenAMToElevenAM = new HourRange(_SevenAMToElevenAM);
    public static final HourRange ElevenAMToTwoPM = new HourRange(_ElevenAMToTwoPM);
    public static final HourRange TwoPMToSixPM = new HourRange(_TwoPMToSixPM);
    public static final HourRange SixPMToElevenPM = new HourRange(_SixPMToElevenPM);
    public static final HourRange ElevenPMToThreeAM = new HourRange(_ElevenPMToThreeAM);
    public java.lang.String getValue() { return _value_;}
    public static HourRange fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        HourRange enumeration = (HourRange)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static HourRange fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(HourRange.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HourRange"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
