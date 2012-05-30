/**
 * GetUserResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement;

public class GetUserResponse  implements java.io.Serializable {
    private com.microsoft.adcenter.api.customermanagement.Entities.User user;

    private int[] roles;

    private long[] accounts;

    private long[] customers;

    public GetUserResponse() {
    }

    public GetUserResponse(
           com.microsoft.adcenter.api.customermanagement.Entities.User user,
           int[] roles,
           long[] accounts,
           long[] customers) {
           this.user = user;
           this.roles = roles;
           this.accounts = accounts;
           this.customers = customers;
    }


    /**
     * Gets the user value for this GetUserResponse.
     * 
     * @return user
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.User getUser() {
        return user;
    }


    /**
     * Sets the user value for this GetUserResponse.
     * 
     * @param user
     */
    public void setUser(com.microsoft.adcenter.api.customermanagement.Entities.User user) {
        this.user = user;
    }


    /**
     * Gets the roles value for this GetUserResponse.
     * 
     * @return roles
     */
    public int[] getRoles() {
        return roles;
    }


    /**
     * Sets the roles value for this GetUserResponse.
     * 
     * @param roles
     */
    public void setRoles(int[] roles) {
        this.roles = roles;
    }


    /**
     * Gets the accounts value for this GetUserResponse.
     * 
     * @return accounts
     */
    public long[] getAccounts() {
        return accounts;
    }


    /**
     * Sets the accounts value for this GetUserResponse.
     * 
     * @param accounts
     */
    public void setAccounts(long[] accounts) {
        this.accounts = accounts;
    }


    /**
     * Gets the customers value for this GetUserResponse.
     * 
     * @return customers
     */
    public long[] getCustomers() {
        return customers;
    }


    /**
     * Sets the customers value for this GetUserResponse.
     * 
     * @param customers
     */
    public void setCustomers(long[] customers) {
        this.customers = customers;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetUserResponse)) return false;
        GetUserResponse other = (GetUserResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
            ((this.roles==null && other.getRoles()==null) || 
             (this.roles!=null &&
              java.util.Arrays.equals(this.roles, other.getRoles()))) &&
            ((this.accounts==null && other.getAccounts()==null) || 
             (this.accounts!=null &&
              java.util.Arrays.equals(this.accounts, other.getAccounts()))) &&
            ((this.customers==null && other.getCustomers()==null) || 
             (this.customers!=null &&
              java.util.Arrays.equals(this.customers, other.getCustomers())));
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
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        if (getRoles() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRoles());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRoles(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAccounts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccounts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccounts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCustomers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCustomers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCustomers(), i);
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
        new org.apache.axis.description.TypeDesc(GetUserResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetUserResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "User"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "User"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roles");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "Roles"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accounts");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "Accounts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customers");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "Customers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long"));
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
