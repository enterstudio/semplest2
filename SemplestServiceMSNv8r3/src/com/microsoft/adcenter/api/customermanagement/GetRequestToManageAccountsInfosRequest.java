/**
 * GetRequestToManageAccountsInfosRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement;

public class GetRequestToManageAccountsInfosRequest  implements java.io.Serializable {
    private java.lang.String accountNumber;

    private java.lang.String customerNumber;

    private java.util.Calendar requestsSentAfter;

    private java.util.Calendar requestsSentBefore;

    private com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestStatus[] requestStatusFilter;

    private com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestType[] requestTypeFilter;

    public GetRequestToManageAccountsInfosRequest() {
    }

    public GetRequestToManageAccountsInfosRequest(
           java.lang.String accountNumber,
           java.lang.String customerNumber,
           java.util.Calendar requestsSentAfter,
           java.util.Calendar requestsSentBefore,
           com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestStatus[] requestStatusFilter,
           com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestType[] requestTypeFilter) {
           this.accountNumber = accountNumber;
           this.customerNumber = customerNumber;
           this.requestsSentAfter = requestsSentAfter;
           this.requestsSentBefore = requestsSentBefore;
           this.requestStatusFilter = requestStatusFilter;
           this.requestTypeFilter = requestTypeFilter;
    }


    /**
     * Gets the accountNumber value for this GetRequestToManageAccountsInfosRequest.
     * 
     * @return accountNumber
     */
    public java.lang.String getAccountNumber() {
        return accountNumber;
    }


    /**
     * Sets the accountNumber value for this GetRequestToManageAccountsInfosRequest.
     * 
     * @param accountNumber
     */
    public void setAccountNumber(java.lang.String accountNumber) {
        this.accountNumber = accountNumber;
    }


    /**
     * Gets the customerNumber value for this GetRequestToManageAccountsInfosRequest.
     * 
     * @return customerNumber
     */
    public java.lang.String getCustomerNumber() {
        return customerNumber;
    }


    /**
     * Sets the customerNumber value for this GetRequestToManageAccountsInfosRequest.
     * 
     * @param customerNumber
     */
    public void setCustomerNumber(java.lang.String customerNumber) {
        this.customerNumber = customerNumber;
    }


    /**
     * Gets the requestsSentAfter value for this GetRequestToManageAccountsInfosRequest.
     * 
     * @return requestsSentAfter
     */
    public java.util.Calendar getRequestsSentAfter() {
        return requestsSentAfter;
    }


    /**
     * Sets the requestsSentAfter value for this GetRequestToManageAccountsInfosRequest.
     * 
     * @param requestsSentAfter
     */
    public void setRequestsSentAfter(java.util.Calendar requestsSentAfter) {
        this.requestsSentAfter = requestsSentAfter;
    }


    /**
     * Gets the requestsSentBefore value for this GetRequestToManageAccountsInfosRequest.
     * 
     * @return requestsSentBefore
     */
    public java.util.Calendar getRequestsSentBefore() {
        return requestsSentBefore;
    }


    /**
     * Sets the requestsSentBefore value for this GetRequestToManageAccountsInfosRequest.
     * 
     * @param requestsSentBefore
     */
    public void setRequestsSentBefore(java.util.Calendar requestsSentBefore) {
        this.requestsSentBefore = requestsSentBefore;
    }


    /**
     * Gets the requestStatusFilter value for this GetRequestToManageAccountsInfosRequest.
     * 
     * @return requestStatusFilter
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestStatus[] getRequestStatusFilter() {
        return requestStatusFilter;
    }


    /**
     * Sets the requestStatusFilter value for this GetRequestToManageAccountsInfosRequest.
     * 
     * @param requestStatusFilter
     */
    public void setRequestStatusFilter(com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestStatus[] requestStatusFilter) {
        this.requestStatusFilter = requestStatusFilter;
    }


    /**
     * Gets the requestTypeFilter value for this GetRequestToManageAccountsInfosRequest.
     * 
     * @return requestTypeFilter
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestType[] getRequestTypeFilter() {
        return requestTypeFilter;
    }


    /**
     * Sets the requestTypeFilter value for this GetRequestToManageAccountsInfosRequest.
     * 
     * @param requestTypeFilter
     */
    public void setRequestTypeFilter(com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestType[] requestTypeFilter) {
        this.requestTypeFilter = requestTypeFilter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetRequestToManageAccountsInfosRequest)) return false;
        GetRequestToManageAccountsInfosRequest other = (GetRequestToManageAccountsInfosRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountNumber==null && other.getAccountNumber()==null) || 
             (this.accountNumber!=null &&
              this.accountNumber.equals(other.getAccountNumber()))) &&
            ((this.customerNumber==null && other.getCustomerNumber()==null) || 
             (this.customerNumber!=null &&
              this.customerNumber.equals(other.getCustomerNumber()))) &&
            ((this.requestsSentAfter==null && other.getRequestsSentAfter()==null) || 
             (this.requestsSentAfter!=null &&
              this.requestsSentAfter.equals(other.getRequestsSentAfter()))) &&
            ((this.requestsSentBefore==null && other.getRequestsSentBefore()==null) || 
             (this.requestsSentBefore!=null &&
              this.requestsSentBefore.equals(other.getRequestsSentBefore()))) &&
            ((this.requestStatusFilter==null && other.getRequestStatusFilter()==null) || 
             (this.requestStatusFilter!=null &&
              java.util.Arrays.equals(this.requestStatusFilter, other.getRequestStatusFilter()))) &&
            ((this.requestTypeFilter==null && other.getRequestTypeFilter()==null) || 
             (this.requestTypeFilter!=null &&
              java.util.Arrays.equals(this.requestTypeFilter, other.getRequestTypeFilter())));
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
        if (getAccountNumber() != null) {
            _hashCode += getAccountNumber().hashCode();
        }
        if (getCustomerNumber() != null) {
            _hashCode += getCustomerNumber().hashCode();
        }
        if (getRequestsSentAfter() != null) {
            _hashCode += getRequestsSentAfter().hashCode();
        }
        if (getRequestsSentBefore() != null) {
            _hashCode += getRequestsSentBefore().hashCode();
        }
        if (getRequestStatusFilter() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRequestStatusFilter());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRequestStatusFilter(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRequestTypeFilter() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRequestTypeFilter());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRequestTypeFilter(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetRequestToManageAccountsInfosRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetRequestToManageAccountsInfosRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "AccountNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "CustomerNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestsSentAfter");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "RequestsSentAfter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestsSentBefore");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "RequestsSentBefore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestStatusFilter");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "RequestStatusFilter"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestStatus"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestTypeFilter");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "RequestTypeFilter"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestType"));
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
