/**
 * UpdateUserRolesRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement;

public class UpdateUserRolesRequest  implements java.io.Serializable {
    private java.lang.Long customerId;

    private java.lang.Long userId;

    private java.lang.Integer newRoleId;

    private long[] newAccountIds;

    private long[] newCustomerIds;

    private java.lang.Integer deleteRoleId;

    private long[] deleteAccountIds;

    private long[] deleteCustomerIds;

    public UpdateUserRolesRequest() {
    }

    public UpdateUserRolesRequest(
           java.lang.Long customerId,
           java.lang.Long userId,
           java.lang.Integer newRoleId,
           long[] newAccountIds,
           long[] newCustomerIds,
           java.lang.Integer deleteRoleId,
           long[] deleteAccountIds,
           long[] deleteCustomerIds) {
           this.customerId = customerId;
           this.userId = userId;
           this.newRoleId = newRoleId;
           this.newAccountIds = newAccountIds;
           this.newCustomerIds = newCustomerIds;
           this.deleteRoleId = deleteRoleId;
           this.deleteAccountIds = deleteAccountIds;
           this.deleteCustomerIds = deleteCustomerIds;
    }


    /**
     * Gets the customerId value for this UpdateUserRolesRequest.
     * 
     * @return customerId
     */
    public java.lang.Long getCustomerId() {
        return customerId;
    }


    /**
     * Sets the customerId value for this UpdateUserRolesRequest.
     * 
     * @param customerId
     */
    public void setCustomerId(java.lang.Long customerId) {
        this.customerId = customerId;
    }


    /**
     * Gets the userId value for this UpdateUserRolesRequest.
     * 
     * @return userId
     */
    public java.lang.Long getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this UpdateUserRolesRequest.
     * 
     * @param userId
     */
    public void setUserId(java.lang.Long userId) {
        this.userId = userId;
    }


    /**
     * Gets the newRoleId value for this UpdateUserRolesRequest.
     * 
     * @return newRoleId
     */
    public java.lang.Integer getNewRoleId() {
        return newRoleId;
    }


    /**
     * Sets the newRoleId value for this UpdateUserRolesRequest.
     * 
     * @param newRoleId
     */
    public void setNewRoleId(java.lang.Integer newRoleId) {
        this.newRoleId = newRoleId;
    }


    /**
     * Gets the newAccountIds value for this UpdateUserRolesRequest.
     * 
     * @return newAccountIds
     */
    public long[] getNewAccountIds() {
        return newAccountIds;
    }


    /**
     * Sets the newAccountIds value for this UpdateUserRolesRequest.
     * 
     * @param newAccountIds
     */
    public void setNewAccountIds(long[] newAccountIds) {
        this.newAccountIds = newAccountIds;
    }


    /**
     * Gets the newCustomerIds value for this UpdateUserRolesRequest.
     * 
     * @return newCustomerIds
     */
    public long[] getNewCustomerIds() {
        return newCustomerIds;
    }


    /**
     * Sets the newCustomerIds value for this UpdateUserRolesRequest.
     * 
     * @param newCustomerIds
     */
    public void setNewCustomerIds(long[] newCustomerIds) {
        this.newCustomerIds = newCustomerIds;
    }


    /**
     * Gets the deleteRoleId value for this UpdateUserRolesRequest.
     * 
     * @return deleteRoleId
     */
    public java.lang.Integer getDeleteRoleId() {
        return deleteRoleId;
    }


    /**
     * Sets the deleteRoleId value for this UpdateUserRolesRequest.
     * 
     * @param deleteRoleId
     */
    public void setDeleteRoleId(java.lang.Integer deleteRoleId) {
        this.deleteRoleId = deleteRoleId;
    }


    /**
     * Gets the deleteAccountIds value for this UpdateUserRolesRequest.
     * 
     * @return deleteAccountIds
     */
    public long[] getDeleteAccountIds() {
        return deleteAccountIds;
    }


    /**
     * Sets the deleteAccountIds value for this UpdateUserRolesRequest.
     * 
     * @param deleteAccountIds
     */
    public void setDeleteAccountIds(long[] deleteAccountIds) {
        this.deleteAccountIds = deleteAccountIds;
    }


    /**
     * Gets the deleteCustomerIds value for this UpdateUserRolesRequest.
     * 
     * @return deleteCustomerIds
     */
    public long[] getDeleteCustomerIds() {
        return deleteCustomerIds;
    }


    /**
     * Sets the deleteCustomerIds value for this UpdateUserRolesRequest.
     * 
     * @param deleteCustomerIds
     */
    public void setDeleteCustomerIds(long[] deleteCustomerIds) {
        this.deleteCustomerIds = deleteCustomerIds;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateUserRolesRequest)) return false;
        UpdateUserRolesRequest other = (UpdateUserRolesRequest) obj;
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
            ((this.userId==null && other.getUserId()==null) || 
             (this.userId!=null &&
              this.userId.equals(other.getUserId()))) &&
            ((this.newRoleId==null && other.getNewRoleId()==null) || 
             (this.newRoleId!=null &&
              this.newRoleId.equals(other.getNewRoleId()))) &&
            ((this.newAccountIds==null && other.getNewAccountIds()==null) || 
             (this.newAccountIds!=null &&
              java.util.Arrays.equals(this.newAccountIds, other.getNewAccountIds()))) &&
            ((this.newCustomerIds==null && other.getNewCustomerIds()==null) || 
             (this.newCustomerIds!=null &&
              java.util.Arrays.equals(this.newCustomerIds, other.getNewCustomerIds()))) &&
            ((this.deleteRoleId==null && other.getDeleteRoleId()==null) || 
             (this.deleteRoleId!=null &&
              this.deleteRoleId.equals(other.getDeleteRoleId()))) &&
            ((this.deleteAccountIds==null && other.getDeleteAccountIds()==null) || 
             (this.deleteAccountIds!=null &&
              java.util.Arrays.equals(this.deleteAccountIds, other.getDeleteAccountIds()))) &&
            ((this.deleteCustomerIds==null && other.getDeleteCustomerIds()==null) || 
             (this.deleteCustomerIds!=null &&
              java.util.Arrays.equals(this.deleteCustomerIds, other.getDeleteCustomerIds())));
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
        if (getUserId() != null) {
            _hashCode += getUserId().hashCode();
        }
        if (getNewRoleId() != null) {
            _hashCode += getNewRoleId().hashCode();
        }
        if (getNewAccountIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNewAccountIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNewAccountIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNewCustomerIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNewCustomerIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNewCustomerIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDeleteRoleId() != null) {
            _hashCode += getDeleteRoleId().hashCode();
        }
        if (getDeleteAccountIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDeleteAccountIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDeleteAccountIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDeleteCustomerIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDeleteCustomerIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDeleteCustomerIds(), i);
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
        new org.apache.axis.description.TypeDesc(UpdateUserRolesRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">UpdateUserRolesRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "CustomerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "UserId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newRoleId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "NewRoleId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newAccountIds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "NewAccountIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newCustomerIds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "NewCustomerIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleteRoleId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "DeleteRoleId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleteAccountIds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "DeleteAccountIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleteCustomerIds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "DeleteCustomerIds"));
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
