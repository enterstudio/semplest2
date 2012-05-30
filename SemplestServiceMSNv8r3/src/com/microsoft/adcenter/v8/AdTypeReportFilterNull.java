/**
 * AdTypeReportFilterNull.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class AdTypeReportFilterNull implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AdTypeReportFilterNull(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Text = "Text";
    public static final java.lang.String _Mobile = "Mobile";
    public static final java.lang.String _Image = "Image";
    public static final java.lang.String _RichMedia = "RichMedia";
    public static final java.lang.String _Local = "Local";
    public static final java.lang.String _ThirdPartyCreative = "ThirdPartyCreative";
    public static final java.lang.String _RichAd = "RichAd";
    public static final AdTypeReportFilterNull Text = new AdTypeReportFilterNull(_Text);
    public static final AdTypeReportFilterNull Mobile = new AdTypeReportFilterNull(_Mobile);
    public static final AdTypeReportFilterNull Image = new AdTypeReportFilterNull(_Image);
    public static final AdTypeReportFilterNull RichMedia = new AdTypeReportFilterNull(_RichMedia);
    public static final AdTypeReportFilterNull Local = new AdTypeReportFilterNull(_Local);
    public static final AdTypeReportFilterNull ThirdPartyCreative = new AdTypeReportFilterNull(_ThirdPartyCreative);
    public static final AdTypeReportFilterNull RichAd = new AdTypeReportFilterNull(_RichAd);
    public java.lang.String getValue() { return _value_;}
    public static AdTypeReportFilterNull fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        AdTypeReportFilterNull enumeration = (AdTypeReportFilterNull)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static AdTypeReportFilterNull fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(AdTypeReportFilterNull.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdTypeReportFilter>null"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
