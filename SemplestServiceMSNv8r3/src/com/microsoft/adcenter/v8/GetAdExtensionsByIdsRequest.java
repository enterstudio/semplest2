/**
 * GetAdExtensionsByIdsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GetAdExtensionsByIdsRequest  implements java.io.Serializable {
    private java.lang.Long accountId;

    private long[] adExtensionIds;

    private java.lang.String[] adExtensionType;

    public GetAdExtensionsByIdsRequest() {
    }

    public GetAdExtensionsByIdsRequest(
           java.lang.Long accountId,
           long[] adExtensionIds,
           java.lang.String[] adExtensionType) {
           this.accountId = accountId;
           this.adExtensionIds = adExtensionIds;
           this.adExtensionType = adExtensionType;
    }


    /**
     * Gets the accountId value for this GetAdExtensionsByIdsRequest.
     * 
     * @return accountId
     */
    public java.lang.Long getAccountId() {
        return accountId;
    }


    /**
     * Sets the accountId value for this GetAdExtensionsByIdsRequest.
     * 
     * @param accountId
     */
    public void setAccountId(java.lang.Long accountId) {
        this.accountId = accountId;
    }


    /**
     * Gets the adExtensionIds value for this GetAdExtensionsByIdsRequest.
     * 
     * @return adExtensionIds
     */
    public long[] getAdExtensionIds() {
        return adExtensionIds;
    }


    /**
     * Sets the adExtensionIds value for this GetAdExtensionsByIdsRequest.
     * 
     * @param adExtensionIds
     */
    public void setAdExtensionIds(long[] adExtensionIds) {
        this.adExtensionIds = adExtensionIds;
    }


    /**
     * Gets the adExtensionType value for this GetAdExtensionsByIdsRequest.
     * 
     * @return adExtensionType
     */
    public java.lang.String[] getAdExtensionType() {
        return adExtensionType;
    }


    /**
     * Sets the adExtensionType value for this GetAdExtensionsByIdsRequest.
     * 
     * @param adExtensionType
     */
    public void setAdExtensionType(java.lang.String[] adExtensionType) {
        this.adExtensionType = adExtensionType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAdExtensionsByIdsRequest)) return false;
        GetAdExtensionsByIdsRequest other = (GetAdExtensionsByIdsRequest) obj;
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
            ((this.adExtensionIds==null && other.getAdExtensionIds()==null) || 
             (this.adExtensionIds!=null &&
              java.util.Arrays.equals(this.adExtensionIds, other.getAdExtensionIds()))) &&
            ((this.adExtensionType==null && other.getAdExtensionType()==null) || 
             (this.adExtensionType!=null &&
              java.util.Arrays.equals(this.adExtensionType, other.getAdExtensionType())));
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
        if (getAdExtensionIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAdExtensionIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAdExtensionIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAdExtensionType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAdExtensionType());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAdExtensionType(), i);
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
        new org.apache.axis.description.TypeDesc(GetAdExtensionsByIdsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdExtensionsByIdsRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adExtensionIds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adExtensionType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionType"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionsTypeFilter"));
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
