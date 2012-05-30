/**
 * AdExtensionDimensionReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class AdExtensionDimensionReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AdExtensionDimensionReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountId = "AccountId";
    public static final java.lang.String _AdExtensionType = "AdExtensionType";
    public static final java.lang.String _AdExtensionId = "AdExtensionId";
    public static final java.lang.String _AdExtensionVersion = "AdExtensionVersion";
    public static final java.lang.String _Status = "Status";
    public static final java.lang.String _AdExtensionPropertyId = "AdExtensionPropertyId";
    public static final java.lang.String _AdExtensionPropertyValue = "AdExtensionPropertyValue";
    public static final AdExtensionDimensionReportColumn AccountId = new AdExtensionDimensionReportColumn(_AccountId);
    public static final AdExtensionDimensionReportColumn AdExtensionType = new AdExtensionDimensionReportColumn(_AdExtensionType);
    public static final AdExtensionDimensionReportColumn AdExtensionId = new AdExtensionDimensionReportColumn(_AdExtensionId);
    public static final AdExtensionDimensionReportColumn AdExtensionVersion = new AdExtensionDimensionReportColumn(_AdExtensionVersion);
    public static final AdExtensionDimensionReportColumn Status = new AdExtensionDimensionReportColumn(_Status);
    public static final AdExtensionDimensionReportColumn AdExtensionPropertyId = new AdExtensionDimensionReportColumn(_AdExtensionPropertyId);
    public static final AdExtensionDimensionReportColumn AdExtensionPropertyValue = new AdExtensionDimensionReportColumn(_AdExtensionPropertyValue);
    public java.lang.String getValue() { return _value_;}
    public static AdExtensionDimensionReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        AdExtensionDimensionReportColumn enumeration = (AdExtensionDimensionReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static AdExtensionDimensionReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(AdExtensionDimensionReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionDimensionReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
