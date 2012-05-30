/**
 * FindAccountsOrCustomersInfoRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement;

public class FindAccountsOrCustomersInfoRequest  implements java.io.Serializable {
    private java.lang.String filter;

    private java.lang.Integer topN;

    private com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType applicationScope;

    public FindAccountsOrCustomersInfoRequest() {
    }

    public FindAccountsOrCustomersInfoRequest(
           java.lang.String filter,
           java.lang.Integer topN,
           com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType applicationScope) {
           this.filter = filter;
           this.topN = topN;
           this.applicationScope = applicationScope;
    }


    /**
     * Gets the filter value for this FindAccountsOrCustomersInfoRequest.
     * 
     * @return filter
     */
    public java.lang.String getFilter() {
        return filter;
    }


    /**
     * Sets the filter value for this FindAccountsOrCustomersInfoRequest.
     * 
     * @param filter
     */
    public void setFilter(java.lang.String filter) {
        this.filter = filter;
    }


    /**
     * Gets the topN value for this FindAccountsOrCustomersInfoRequest.
     * 
     * @return topN
     */
    public java.lang.Integer getTopN() {
        return topN;
    }


    /**
     * Sets the topN value for this FindAccountsOrCustomersInfoRequest.
     * 
     * @param topN
     */
    public void setTopN(java.lang.Integer topN) {
        this.topN = topN;
    }


    /**
     * Gets the applicationScope value for this FindAccountsOrCustomersInfoRequest.
     * 
     * @return applicationScope
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType getApplicationScope() {
        return applicationScope;
    }


    /**
     * Sets the applicationScope value for this FindAccountsOrCustomersInfoRequest.
     * 
     * @param applicationScope
     */
    public void setApplicationScope(com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType applicationScope) {
        this.applicationScope = applicationScope;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FindAccountsOrCustomersInfoRequest)) return false;
        FindAccountsOrCustomersInfoRequest other = (FindAccountsOrCustomersInfoRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.filter==null && other.getFilter()==null) || 
             (this.filter!=null &&
              this.filter.equals(other.getFilter()))) &&
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
        if (getFilter() != null) {
            _hashCode += getFilter().hashCode();
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
        new org.apache.axis.description.TypeDesc(FindAccountsOrCustomersInfoRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">FindAccountsOrCustomersInfoRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filter");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "Filter"));
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
