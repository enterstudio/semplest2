/**
 * SignupCustomerRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement;

public class SignupCustomerRequest  implements java.io.Serializable {
    private com.microsoft.adcenter.api.customermanagement.Entities.Customer customer;

    private com.microsoft.adcenter.api.customermanagement.Entities.User user;

    private com.microsoft.adcenter.api.customermanagement.Entities.Account account;

    private java.lang.Long parentCustomerId;

    private com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType applicationScope;

    public SignupCustomerRequest() {
    }

    public SignupCustomerRequest(
           com.microsoft.adcenter.api.customermanagement.Entities.Customer customer,
           com.microsoft.adcenter.api.customermanagement.Entities.User user,
           com.microsoft.adcenter.api.customermanagement.Entities.Account account,
           java.lang.Long parentCustomerId,
           com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType applicationScope) {
           this.customer = customer;
           this.user = user;
           this.account = account;
           this.parentCustomerId = parentCustomerId;
           this.applicationScope = applicationScope;
    }


    /**
     * Gets the customer value for this SignupCustomerRequest.
     * 
     * @return customer
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.Customer getCustomer() {
        return customer;
    }


    /**
     * Sets the customer value for this SignupCustomerRequest.
     * 
     * @param customer
     */
    public void setCustomer(com.microsoft.adcenter.api.customermanagement.Entities.Customer customer) {
        this.customer = customer;
    }


    /**
     * Gets the user value for this SignupCustomerRequest.
     * 
     * @return user
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.User getUser() {
        return user;
    }


    /**
     * Sets the user value for this SignupCustomerRequest.
     * 
     * @param user
     */
    public void setUser(com.microsoft.adcenter.api.customermanagement.Entities.User user) {
        this.user = user;
    }


    /**
     * Gets the account value for this SignupCustomerRequest.
     * 
     * @return account
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.Account getAccount() {
        return account;
    }


    /**
     * Sets the account value for this SignupCustomerRequest.
     * 
     * @param account
     */
    public void setAccount(com.microsoft.adcenter.api.customermanagement.Entities.Account account) {
        this.account = account;
    }


    /**
     * Gets the parentCustomerId value for this SignupCustomerRequest.
     * 
     * @return parentCustomerId
     */
    public java.lang.Long getParentCustomerId() {
        return parentCustomerId;
    }


    /**
     * Sets the parentCustomerId value for this SignupCustomerRequest.
     * 
     * @param parentCustomerId
     */
    public void setParentCustomerId(java.lang.Long parentCustomerId) {
        this.parentCustomerId = parentCustomerId;
    }


    /**
     * Gets the applicationScope value for this SignupCustomerRequest.
     * 
     * @return applicationScope
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType getApplicationScope() {
        return applicationScope;
    }


    /**
     * Sets the applicationScope value for this SignupCustomerRequest.
     * 
     * @param applicationScope
     */
    public void setApplicationScope(com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType applicationScope) {
        this.applicationScope = applicationScope;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SignupCustomerRequest)) return false;
        SignupCustomerRequest other = (SignupCustomerRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customer==null && other.getCustomer()==null) || 
             (this.customer!=null &&
              this.customer.equals(other.getCustomer()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
            ((this.account==null && other.getAccount()==null) || 
             (this.account!=null &&
              this.account.equals(other.getAccount()))) &&
            ((this.parentCustomerId==null && other.getParentCustomerId()==null) || 
             (this.parentCustomerId!=null &&
              this.parentCustomerId.equals(other.getParentCustomerId()))) &&
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
        if (getCustomer() != null) {
            _hashCode += getCustomer().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        if (getAccount() != null) {
            _hashCode += getAccount().hashCode();
        }
        if (getParentCustomerId() != null) {
            _hashCode += getParentCustomerId().hashCode();
        }
        if (getApplicationScope() != null) {
            _hashCode += getApplicationScope().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SignupCustomerRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">SignupCustomerRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "Customer"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Customer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "User"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "User"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("account");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "Account"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Account"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentCustomerId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "ParentCustomerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationScope");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "ApplicationScope"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ApplicationType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
