/**
 * AccountLifeCycleStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Entities;

public class AccountLifeCycleStatus implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AccountLifeCycleStatus(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Draft = "Draft";
    public static final java.lang.String _Active = "Active";
    public static final java.lang.String _Inactive = "Inactive";
    public static final java.lang.String _Pause = "Pause";
    public static final java.lang.String _Pending = "Pending";
    public static final AccountLifeCycleStatus Draft = new AccountLifeCycleStatus(_Draft);
    public static final AccountLifeCycleStatus Active = new AccountLifeCycleStatus(_Active);
    public static final AccountLifeCycleStatus Inactive = new AccountLifeCycleStatus(_Inactive);
    public static final AccountLifeCycleStatus Pause = new AccountLifeCycleStatus(_Pause);
    public static final AccountLifeCycleStatus Pending = new AccountLifeCycleStatus(_Pending);
    public java.lang.String getValue() { return _value_;}
    public static AccountLifeCycleStatus fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        AccountLifeCycleStatus enumeration = (AccountLifeCycleStatus)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static AccountLifeCycleStatus fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(AccountLifeCycleStatus.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountLifeCycleStatus"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
