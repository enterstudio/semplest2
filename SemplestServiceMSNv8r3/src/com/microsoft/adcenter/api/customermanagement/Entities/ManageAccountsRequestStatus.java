/**
 * ManageAccountsRequestStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Entities;

public class ManageAccountsRequestStatus implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected ManageAccountsRequestStatus(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Accepted = "Accepted";
    public static final java.lang.String _Cancelled = "Cancelled";
    public static final java.lang.String _Declined = "Declined";
    public static final java.lang.String _Failed = "Failed";
    public static final java.lang.String _Inactive = "Inactive";
    public static final java.lang.String _InProgress = "InProgress";
    public static final java.lang.String _Pending = "Pending";
    public static final java.lang.String _Succeeded = "Succeeded";
    public static final ManageAccountsRequestStatus Accepted = new ManageAccountsRequestStatus(_Accepted);
    public static final ManageAccountsRequestStatus Cancelled = new ManageAccountsRequestStatus(_Cancelled);
    public static final ManageAccountsRequestStatus Declined = new ManageAccountsRequestStatus(_Declined);
    public static final ManageAccountsRequestStatus Failed = new ManageAccountsRequestStatus(_Failed);
    public static final ManageAccountsRequestStatus Inactive = new ManageAccountsRequestStatus(_Inactive);
    public static final ManageAccountsRequestStatus InProgress = new ManageAccountsRequestStatus(_InProgress);
    public static final ManageAccountsRequestStatus Pending = new ManageAccountsRequestStatus(_Pending);
    public static final ManageAccountsRequestStatus Succeeded = new ManageAccountsRequestStatus(_Succeeded);
    public java.lang.String getValue() { return _value_;}
    public static ManageAccountsRequestStatus fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        ManageAccountsRequestStatus enumeration = (ManageAccountsRequestStatus)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static ManageAccountsRequestStatus fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(ManageAccountsRequestStatus.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestStatus"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
