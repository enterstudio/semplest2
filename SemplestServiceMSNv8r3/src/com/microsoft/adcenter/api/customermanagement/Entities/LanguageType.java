/**
 * LanguageType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Entities;

public class LanguageType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected LanguageType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Danish = "Danish";
    public static final java.lang.String _Dutch = "Dutch";
    public static final java.lang.String _English = "English";
    public static final java.lang.String _Finnish = "Finnish";
    public static final java.lang.String _French = "French";
    public static final java.lang.String _German = "German";
    public static final java.lang.String _Italian = "Italian";
    public static final java.lang.String _Japanese = "Japanese";
    public static final java.lang.String _Norwegian = "Norwegian";
    public static final java.lang.String _Portuguese = "Portuguese";
    public static final java.lang.String _Swedish = "Swedish";
    public static final java.lang.String _Spanish = "Spanish";
    public static final java.lang.String _Arabic = "Arabic";
    public static final java.lang.String _Hebrew = "Hebrew";
    public static final java.lang.String _Korean = "Korean";
    public static final java.lang.String _Russian = "Russian";
    public static final java.lang.String _Chinese = "Chinese";
    public static final LanguageType Danish = new LanguageType(_Danish);
    public static final LanguageType Dutch = new LanguageType(_Dutch);
    public static final LanguageType English = new LanguageType(_English);
    public static final LanguageType Finnish = new LanguageType(_Finnish);
    public static final LanguageType French = new LanguageType(_French);
    public static final LanguageType German = new LanguageType(_German);
    public static final LanguageType Italian = new LanguageType(_Italian);
    public static final LanguageType Japanese = new LanguageType(_Japanese);
    public static final LanguageType Norwegian = new LanguageType(_Norwegian);
    public static final LanguageType Portuguese = new LanguageType(_Portuguese);
    public static final LanguageType Swedish = new LanguageType(_Swedish);
    public static final LanguageType Spanish = new LanguageType(_Spanish);
    public static final LanguageType Arabic = new LanguageType(_Arabic);
    public static final LanguageType Hebrew = new LanguageType(_Hebrew);
    public static final LanguageType Korean = new LanguageType(_Korean);
    public static final LanguageType Russian = new LanguageType(_Russian);
    public static final LanguageType Chinese = new LanguageType(_Chinese);
    public java.lang.String getValue() { return _value_;}
    public static LanguageType fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        LanguageType enumeration = (LanguageType)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static LanguageType fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(LanguageType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "LanguageType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
