/**
 * AcceptRequestToManageAccountsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement;

public class AcceptRequestToManageAccountsRequest  implements java.io.Serializable {
    private java.lang.Long manageAccountsRequestId;

    private java.lang.Long paymentMethodId;

    public AcceptRequestToManageAccountsRequest() {
    }

    public AcceptRequestToManageAccountsRequest(
           java.lang.Long manageAccountsRequestId,
           java.lang.Long paymentMethodId) {
           this.manageAccountsRequestId = manageAccountsRequestId;
           this.paymentMethodId = paymentMethodId;
    }


    /**
     * Gets the manageAccountsRequestId value for this AcceptRequestToManageAccountsRequest.
     * 
     * @return manageAccountsRequestId
     */
    public java.lang.Long getManageAccountsRequestId() {
        return manageAccountsRequestId;
    }


    /**
     * Sets the manageAccountsRequestId value for this AcceptRequestToManageAccountsRequest.
     * 
     * @param manageAccountsRequestId
     */
    public void setManageAccountsRequestId(java.lang.Long manageAccountsRequestId) {
        this.manageAccountsRequestId = manageAccountsRequestId;
    }


    /**
     * Gets the paymentMethodId value for this AcceptRequestToManageAccountsRequest.
     * 
     * @return paymentMethodId
     */
    public java.lang.Long getPaymentMethodId() {
        return paymentMethodId;
    }


    /**
     * Sets the paymentMethodId value for this AcceptRequestToManageAccountsRequest.
     * 
     * @param paymentMethodId
     */
    public void setPaymentMethodId(java.lang.Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AcceptRequestToManageAccountsRequest)) return false;
        AcceptRequestToManageAccountsRequest other = (AcceptRequestToManageAccountsRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.manageAccountsRequestId==null && other.getManageAccountsRequestId()==null) || 
             (this.manageAccountsRequestId!=null &&
              this.manageAccountsRequestId.equals(other.getManageAccountsRequestId()))) &&
            ((this.paymentMethodId==null && other.getPaymentMethodId()==null) || 
             (this.paymentMethodId!=null &&
              this.paymentMethodId.equals(other.getPaymentMethodId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getManageAccountsRequestId() != null) {
            _hashCode += getManageAccountsRequestId().hashCode();
        }
        if (getPaymentMethodId() != null) {
            _hashCode += getPaymentMethodId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AcceptRequestToManageAccountsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">AcceptRequestToManageAccountsRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("manageAccountsRequestId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "ManageAccountsRequestId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentMethodId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "PaymentMethodId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
