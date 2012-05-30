/**
 * AccountFinancialStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Entities;

public class AccountFinancialStatus implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AccountFinancialStatus(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Proposed = "Proposed";
    public static final java.lang.String _PendingCreditCheck = "PendingCreditCheck";
    public static final java.lang.String _ClearFinancialStatus = "ClearFinancialStatus";
    public static final java.lang.String _SoldToOnly = "SoldToOnly";
    public static final java.lang.String _CreditWarning = "CreditWarning";
    public static final java.lang.String _Hold = "Hold";
    public static final java.lang.String _WriteOff = "WriteOff";
    public static final java.lang.String _TaxOnHold = "TaxOnHold";
    public static final java.lang.String _UserHold = "UserHold";
    public static final AccountFinancialStatus Proposed = new AccountFinancialStatus(_Proposed);
    public static final AccountFinancialStatus PendingCreditCheck = new AccountFinancialStatus(_PendingCreditCheck);
    public static final AccountFinancialStatus ClearFinancialStatus = new AccountFinancialStatus(_ClearFinancialStatus);
    public static final AccountFinancialStatus SoldToOnly = new AccountFinancialStatus(_SoldToOnly);
    public static final AccountFinancialStatus CreditWarning = new AccountFinancialStatus(_CreditWarning);
    public static final AccountFinancialStatus Hold = new AccountFinancialStatus(_Hold);
    public static final AccountFinancialStatus WriteOff = new AccountFinancialStatus(_WriteOff);
    public static final AccountFinancialStatus TaxOnHold = new AccountFinancialStatus(_TaxOnHold);
    public static final AccountFinancialStatus UserHold = new AccountFinancialStatus(_UserHold);
    public java.lang.String getValue() { return _value_;}
    public static AccountFinancialStatus fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        AccountFinancialStatus enumeration = (AccountFinancialStatus)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static AccountFinancialStatus fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(AccountFinancialStatus.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountFinancialStatus"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
