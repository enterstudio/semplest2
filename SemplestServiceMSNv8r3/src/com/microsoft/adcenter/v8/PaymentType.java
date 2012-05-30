/**
 * PaymentType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class PaymentType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected PaymentType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Cash = "Cash";
    public static final java.lang.String _AmericanExpress = "AmericanExpress";
    public static final java.lang.String _MasterCard = "MasterCard";
    public static final java.lang.String _DinersClub = "DinersClub";
    public static final java.lang.String _DirectDebit = "DirectDebit";
    public static final java.lang.String _Visa = "Visa";
    public static final java.lang.String _TravellersCheck = "TravellersCheck";
    public static final java.lang.String _PayPal = "PayPal";
    public static final java.lang.String _Invoice = "Invoice";
    public static final java.lang.String _CashOnDelivery = "CashOnDelivery";
    public static final java.lang.String _Other = "Other";
    public static final PaymentType Cash = new PaymentType(_Cash);
    public static final PaymentType AmericanExpress = new PaymentType(_AmericanExpress);
    public static final PaymentType MasterCard = new PaymentType(_MasterCard);
    public static final PaymentType DinersClub = new PaymentType(_DinersClub);
    public static final PaymentType DirectDebit = new PaymentType(_DirectDebit);
    public static final PaymentType Visa = new PaymentType(_Visa);
    public static final PaymentType TravellersCheck = new PaymentType(_TravellersCheck);
    public static final PaymentType PayPal = new PaymentType(_PayPal);
    public static final PaymentType Invoice = new PaymentType(_Invoice);
    public static final PaymentType CashOnDelivery = new PaymentType(_CashOnDelivery);
    public static final PaymentType Other = new PaymentType(_Other);
    public java.lang.String getValue() { return _value_;}
    public static PaymentType fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        PaymentType enumeration = (PaymentType)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static PaymentType fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(PaymentType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PaymentType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
