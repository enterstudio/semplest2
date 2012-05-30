/**
 * SendRequestToStopManagingAccountsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement;

public class SendRequestToStopManagingAccountsRequest  implements java.io.Serializable {
    private com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequest manageAccountsRequest;

    public SendRequestToStopManagingAccountsRequest() {
    }

    public SendRequestToStopManagingAccountsRequest(
           com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequest manageAccountsRequest) {
           this.manageAccountsRequest = manageAccountsRequest;
    }


    /**
     * Gets the manageAccountsRequest value for this SendRequestToStopManagingAccountsRequest.
     * 
     * @return manageAccountsRequest
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequest getManageAccountsRequest() {
        return manageAccountsRequest;
    }


    /**
     * Sets the manageAccountsRequest value for this SendRequestToStopManagingAccountsRequest.
     * 
     * @param manageAccountsRequest
     */
    public void setManageAccountsRequest(com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequest manageAccountsRequest) {
        this.manageAccountsRequest = manageAccountsRequest;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendRequestToStopManagingAccountsRequest)) return false;
        SendRequestToStopManagingAccountsRequest other = (SendRequestToStopManagingAccountsRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.manageAccountsRequest==null && other.getManageAccountsRequest()==null) || 
             (this.manageAccountsRequest!=null &&
              this.manageAccountsRequest.equals(other.getManageAccountsRequest())));
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
        if (getManageAccountsRequest() != null) {
            _hashCode += getManageAccountsRequest().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SendRequestToStopManagingAccountsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">SendRequestToStopManagingAccountsRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("manageAccountsRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "ManageAccountsRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequest"));
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
