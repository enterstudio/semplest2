/**
 * ComponentTypeFilterNull.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class ComponentTypeFilterNull implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected ComponentTypeFilterNull(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Basic = "Basic";
    public static final java.lang.String _Deeplink = "Deeplink";
    public static final java.lang.String _Form = "Form";
    public static final java.lang.String _Image = "Image";
    public static final java.lang.String _FavoriteIcon = "FavoriteIcon";
    public static final java.lang.String _Video = "Video";
    public static final java.lang.String _TitledLink = "TitledLink";
    public static final ComponentTypeFilterNull Basic = new ComponentTypeFilterNull(_Basic);
    public static final ComponentTypeFilterNull Deeplink = new ComponentTypeFilterNull(_Deeplink);
    public static final ComponentTypeFilterNull Form = new ComponentTypeFilterNull(_Form);
    public static final ComponentTypeFilterNull Image = new ComponentTypeFilterNull(_Image);
    public static final ComponentTypeFilterNull FavoriteIcon = new ComponentTypeFilterNull(_FavoriteIcon);
    public static final ComponentTypeFilterNull Video = new ComponentTypeFilterNull(_Video);
    public static final ComponentTypeFilterNull TitledLink = new ComponentTypeFilterNull(_TitledLink);
    public java.lang.String getValue() { return _value_;}
    public static ComponentTypeFilterNull fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        ComponentTypeFilterNull enumeration = (ComponentTypeFilterNull)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static ComponentTypeFilterNull fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(ComponentTypeFilterNull.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ComponentTypeFilter>null"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
