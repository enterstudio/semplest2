/**
 * FindAccountsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement;

public class FindAccountsRequest  implements java.io.Serializable {
    private java.lang.Long customerId;

    private java.lang.String accountFilter;

    private java.lang.Integer topN;

    private com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType applicationScope;

    public FindAccountsRequest() {
    }

    public FindAccountsRequest(
           java.lang.Long customerId,
           java.lang.String accountFilter,
           java.lang.Integer topN,
           com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType applicationScope) {
           this.customerId = customerId;
           this.accountFilter = accountFilter;
           this.topN = topN;
           this.applicationScope = applicationScope;
    }


    /**
     * Gets the customerId value for this FindAccountsRequest.
     * 
     * @return customerId
     */
    public java.lang.Long getCustomerId() {
        return customerId;
    }


    /**
     * Sets the customerId value for this FindAccountsRequest.
     * 
     * @param customerId
     */
    public void setCustomerId(java.lang.Long customerId) {
        this.customerId = customerId;
    }


    /**
     * Gets the accountFilter value for this FindAccountsRequest.
     * 
     * @return accountFilter
     */
    public java.lang.String getAccountFilter() {
        return accountFilter;
    }


    /**
     * Sets the accountFilter value for this FindAccountsRequest.
     * 
     * @param accountFilter
     */
    public void setAccountFilter(java.lang.String accountFilter) {
        this.accountFilter = accountFilter;
    }


    /**
     * Gets the topN value for this FindAccountsRequest.
     * 
     * @return topN
     */
    public java.lang.Integer getTopN() {
        return topN;
    }


    /**
     * Sets the topN value for this FindAccountsRequest.
     * 
     * @param topN
     */
    public void setTopN(java.lang.Integer topN) {
        this.topN = topN;
    }


    /**
     * Gets the applicationScope value for this FindAccountsRequest.
     * 
     * @return applicationScope
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType getApplicationScope() {
        return applicationScope;
    }


    /**
     * Sets the applicationScope value for this FindAccountsRequest.
     * 
     * @param applicationScope
     */
    public void setApplicationScope(com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType applicationScope) {
        this.applicationScope = applicationScope;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FindAccountsRequest)) return false;
        FindAccountsRequest other = (FindAccountsRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customerId==null && other.getCustomerId()==null) || 
             (this.customerId!=null &&
              this.customerId.equals(other.getCustomerId()))) &&
            ((this.accountFilter==null && other.getAccountFilter()==null) || 
             (this.accountFilter!=null &&
              this.accountFilter.equals(other.getAccountFilter()))) &&
            ((this.topN==null && other.getTopN()==null) || 
             (this.topN!=null &&
              this.topN.equals(other.getTopN()))) &&
            ((this.applicationScope==null && other.getApplicationScope()==null) || 
             (this.applicationScope!=null &&
              this.applicationScope.equals(other.getApplicationScope())));
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
        if (getCustomerId() != null) {
            _hashCode += getCustomerId().hashCode();
        }
        if (getAccountFilter() != null) {
            _hashCode += getAccountFilter().hashCode();
        }
        if (getTopN() != null) {
            _hashCode += getTopN().hashCode();
        }
        if (getApplicationScope() != null) {
            _hashCode += getApplicationScope().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FindAccountsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">FindAccountsRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "CustomerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountFilter");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "AccountFilter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("topN");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "TopN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationScope");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "ApplicationScope"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ApplicationType"));
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
