/**
 * NotificationTypeNull.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.notifications.Entities;

public class NotificationTypeNull implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected NotificationTypeNull(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _CreditCardPendingExpiration = "CreditCardPendingExpiration";
    public static final java.lang.String _DepletedBudget = "DepletedBudget";
    public static final java.lang.String _EditorialRejection = "EditorialRejection";
    public static final java.lang.String _ExpiredCreditCard = "ExpiredCreditCard";
    public static final java.lang.String _ExpiredInsertionOrder = "ExpiredInsertionOrder";
    public static final java.lang.String _LowBudgetBalance = "LowBudgetBalance";
    public static final NotificationTypeNull CreditCardPendingExpiration = new NotificationTypeNull(_CreditCardPendingExpiration);
    public static final NotificationTypeNull DepletedBudget = new NotificationTypeNull(_DepletedBudget);
    public static final NotificationTypeNull EditorialRejection = new NotificationTypeNull(_EditorialRejection);
    public static final NotificationTypeNull ExpiredCreditCard = new NotificationTypeNull(_ExpiredCreditCard);
    public static final NotificationTypeNull ExpiredInsertionOrder = new NotificationTypeNull(_ExpiredInsertionOrder);
    public static final NotificationTypeNull LowBudgetBalance = new NotificationTypeNull(_LowBudgetBalance);
    public java.lang.String getValue() { return _value_;}
    public static NotificationTypeNull fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        NotificationTypeNull enumeration = (NotificationTypeNull)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static NotificationTypeNull fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(NotificationTypeNull.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "NotificationType>null"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
