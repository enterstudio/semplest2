/**
 * ExpiredInsertionOrderNotification.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.notifications.Entities;

public class ExpiredInsertionOrderNotification  extends com.microsoft.adcenter.api.notifications.Entities.AccountNotification  implements java.io.Serializable {
    private java.lang.String billToCustomerName;

    public ExpiredInsertionOrderNotification() {
    }

    public ExpiredInsertionOrderNotification(
           java.lang.Long notificationId,
           java.util.Calendar notificationDate,
           java.lang.String[] notificationType,
           java.lang.Long accountId,
           java.lang.String accountNumber,
           java.lang.String billToCustomerName) {
        super(
            notificationId,
            notificationDate,
            notificationType,
            accountId,
            accountNumber);
        this.billToCustomerName = billToCustomerName;
    }


    /**
     * Gets the billToCustomerName value for this ExpiredInsertionOrderNotification.
     * 
     * @return billToCustomerName
     */
    public java.lang.String getBillToCustomerName() {
        return billToCustomerName;
    }


    /**
     * Sets the billToCustomerName value for this ExpiredInsertionOrderNotification.
     * 
     * @param billToCustomerName
     */
    public void setBillToCustomerName(java.lang.String billToCustomerName) {
        this.billToCustomerName = billToCustomerName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExpiredInsertionOrderNotification)) return false;
        ExpiredInsertionOrderNotification other = (ExpiredInsertionOrderNotification) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.billToCustomerName==null && other.getBillToCustomerName()==null) || 
             (this.billToCustomerName!=null &&
              this.billToCustomerName.equals(other.getBillToCustomerName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getBillToCustomerName() != null) {
            _hashCode += getBillToCustomerName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExpiredInsertionOrderNotification.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "ExpiredInsertionOrderNotification"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("billToCustomerName");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "BillToCustomerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
