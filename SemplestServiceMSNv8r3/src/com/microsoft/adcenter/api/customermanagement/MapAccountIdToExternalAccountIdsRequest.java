/**
 * MapAccountIdToExternalAccountIdsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement;

public class MapAccountIdToExternalAccountIdsRequest  implements java.io.Serializable {
    private java.lang.Long accountId;

    private java.lang.String[] externalAccountIds;

    public MapAccountIdToExternalAccountIdsRequest() {
    }

    public MapAccountIdToExternalAccountIdsRequest(
           java.lang.Long accountId,
           java.lang.String[] externalAccountIds) {
           this.accountId = accountId;
           this.externalAccountIds = externalAccountIds;
    }


    /**
     * Gets the accountId value for this MapAccountIdToExternalAccountIdsRequest.
     * 
     * @return accountId
     */
    public java.lang.Long getAccountId() {
        return accountId;
    }


    /**
     * Sets the accountId value for this MapAccountIdToExternalAccountIdsRequest.
     * 
     * @param accountId
     */
    public void setAccountId(java.lang.Long accountId) {
        this.accountId = accountId;
    }


    /**
     * Gets the externalAccountIds value for this MapAccountIdToExternalAccountIdsRequest.
     * 
     * @return externalAccountIds
     */
    public java.lang.String[] getExternalAccountIds() {
        return externalAccountIds;
    }


    /**
     * Sets the externalAccountIds value for this MapAccountIdToExternalAccountIdsRequest.
     * 
     * @param externalAccountIds
     */
    public void setExternalAccountIds(java.lang.String[] externalAccountIds) {
        this.externalAccountIds = externalAccountIds;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MapAccountIdToExternalAccountIdsRequest)) return false;
        MapAccountIdToExternalAccountIdsRequest other = (MapAccountIdToExternalAccountIdsRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountId==null && other.getAccountId()==null) || 
             (this.accountId!=null &&
              this.accountId.equals(other.getAccountId()))) &&
            ((this.externalAccountIds==null && other.getExternalAccountIds()==null) || 
             (this.externalAccountIds!=null &&
              java.util.Arrays.equals(this.externalAccountIds, other.getExternalAccountIds())));
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
        if (getAccountId() != null) {
            _hashCode += getAccountId().hashCode();
        }
        if (getExternalAccountIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExternalAccountIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExternalAccountIds(), i);
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
        new org.apache.axis.description.TypeDesc(MapAccountIdToExternalAccountIdsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">MapAccountIdToExternalAccountIdsRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "AccountId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("externalAccountIds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "ExternalAccountIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string"));
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
