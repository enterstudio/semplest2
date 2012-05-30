/**
 * AgeRange.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class AgeRange implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AgeRange(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _EighteenToTwentyFive = "EighteenToTwentyFive";
    public static final java.lang.String _TwentyFiveToThirtyFive = "TwentyFiveToThirtyFive";
    public static final java.lang.String _ThirtyFiveToFifty = "ThirtyFiveToFifty";
    public static final java.lang.String _FiftyToSixtyFive = "FiftyToSixtyFive";
    public static final java.lang.String _SixtyFiveAndAbove = "SixtyFiveAndAbove";
    public static final AgeRange EighteenToTwentyFive = new AgeRange(_EighteenToTwentyFive);
    public static final AgeRange TwentyFiveToThirtyFive = new AgeRange(_TwentyFiveToThirtyFive);
    public static final AgeRange ThirtyFiveToFifty = new AgeRange(_ThirtyFiveToFifty);
    public static final AgeRange FiftyToSixtyFive = new AgeRange(_FiftyToSixtyFive);
    public static final AgeRange SixtyFiveAndAbove = new AgeRange(_SixtyFiveAndAbove);
    public java.lang.String getValue() { return _value_;}
    public static AgeRange fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        AgeRange enumeration = (AgeRange)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static AgeRange fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(AgeRange.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeRange"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
