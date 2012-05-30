/**
 * GetKeywordEditorialReasonsByIdsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GetKeywordEditorialReasonsByIdsRequest  implements java.io.Serializable {
    private long[] keywordIds;

    private java.lang.Long accountId;

    public GetKeywordEditorialReasonsByIdsRequest() {
    }

    public GetKeywordEditorialReasonsByIdsRequest(
           long[] keywordIds,
           java.lang.Long accountId) {
           this.keywordIds = keywordIds;
           this.accountId = accountId;
    }


    /**
     * Gets the keywordIds value for this GetKeywordEditorialReasonsByIdsRequest.
     * 
     * @return keywordIds
     */
    public long[] getKeywordIds() {
        return keywordIds;
    }


    /**
     * Sets the keywordIds value for this GetKeywordEditorialReasonsByIdsRequest.
     * 
     * @param keywordIds
     */
    public void setKeywordIds(long[] keywordIds) {
        this.keywordIds = keywordIds;
    }


    /**
     * Gets the accountId value for this GetKeywordEditorialReasonsByIdsRequest.
     * 
     * @return accountId
     */
    public java.lang.Long getAccountId() {
        return accountId;
    }


    /**
     * Sets the accountId value for this GetKeywordEditorialReasonsByIdsRequest.
     * 
     * @param accountId
     */
    public void setAccountId(java.lang.Long accountId) {
        this.accountId = accountId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetKeywordEditorialReasonsByIdsRequest)) return false;
        GetKeywordEditorialReasonsByIdsRequest other = (GetKeywordEditorialReasonsByIdsRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.keywordIds==null && other.getKeywordIds()==null) || 
             (this.keywordIds!=null &&
              java.util.Arrays.equals(this.keywordIds, other.getKeywordIds()))) &&
            ((this.accountId==null && other.getAccountId()==null) || 
             (this.accountId!=null &&
              this.accountId.equals(other.getAccountId())));
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
        if (getKeywordIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKeywordIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getKeywordIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAccountId() != null) {
            _hashCode += getAccountId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetKeywordEditorialReasonsByIdsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordEditorialReasonsByIdsRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keywordIds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
