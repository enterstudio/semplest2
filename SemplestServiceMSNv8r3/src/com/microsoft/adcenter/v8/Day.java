/**
 * Day.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class Day implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Day(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Sunday = "Sunday";
    public static final java.lang.String _Monday = "Monday";
    public static final java.lang.String _Tuesday = "Tuesday";
    public static final java.lang.String _Wednesday = "Wednesday";
    public static final java.lang.String _Thursday = "Thursday";
    public static final java.lang.String _Friday = "Friday";
    public static final java.lang.String _Saturday = "Saturday";
    public static final Day Sunday = new Day(_Sunday);
    public static final Day Monday = new Day(_Monday);
    public static final Day Tuesday = new Day(_Tuesday);
    public static final Day Wednesday = new Day(_Wednesday);
    public static final Day Thursday = new Day(_Thursday);
    public static final Day Friday = new Day(_Friday);
    public static final Day Saturday = new Day(_Saturday);
    public java.lang.String getValue() { return _value_;}
    public static Day fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        Day enumeration = (Day)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Day fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(Day.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Day"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
