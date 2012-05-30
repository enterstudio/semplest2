/**
 * DeviceTypeReportFilterNull.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class DeviceTypeReportFilterNull implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected DeviceTypeReportFilterNull(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Computer = "Computer";
    public static final java.lang.String _SmartPhone = "SmartPhone";
    public static final java.lang.String _NonSmartPhone = "NonSmartPhone";
    public static final java.lang.String _Tablet = "Tablet";
    public static final DeviceTypeReportFilterNull Computer = new DeviceTypeReportFilterNull(_Computer);
    public static final DeviceTypeReportFilterNull SmartPhone = new DeviceTypeReportFilterNull(_SmartPhone);
    public static final DeviceTypeReportFilterNull NonSmartPhone = new DeviceTypeReportFilterNull(_NonSmartPhone);
    public static final DeviceTypeReportFilterNull Tablet = new DeviceTypeReportFilterNull(_Tablet);
    public java.lang.String getValue() { return _value_;}
    public static DeviceTypeReportFilterNull fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        DeviceTypeReportFilterNull enumeration = (DeviceTypeReportFilterNull)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static DeviceTypeReportFilterNull fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(DeviceTypeReportFilterNull.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceTypeReportFilter>null"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
