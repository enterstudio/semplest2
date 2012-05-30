/**
 * GetNegativeKeywordsByAdGroupIdsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GetNegativeKeywordsByAdGroupIdsResponse  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.AdGroupNegativeKeywords[] adGroupNegativeKeywords;

    public GetNegativeKeywordsByAdGroupIdsResponse() {
    }

    public GetNegativeKeywordsByAdGroupIdsResponse(
           com.microsoft.adcenter.v8.AdGroupNegativeKeywords[] adGroupNegativeKeywords) {
           this.adGroupNegativeKeywords = adGroupNegativeKeywords;
    }


    /**
     * Gets the adGroupNegativeKeywords value for this GetNegativeKeywordsByAdGroupIdsResponse.
     * 
     * @return adGroupNegativeKeywords
     */
    public com.microsoft.adcenter.v8.AdGroupNegativeKeywords[] getAdGroupNegativeKeywords() {
        return adGroupNegativeKeywords;
    }


    /**
     * Sets the adGroupNegativeKeywords value for this GetNegativeKeywordsByAdGroupIdsResponse.
     * 
     * @param adGroupNegativeKeywords
     */
    public void setAdGroupNegativeKeywords(com.microsoft.adcenter.v8.AdGroupNegativeKeywords[] adGroupNegativeKeywords) {
        this.adGroupNegativeKeywords = adGroupNegativeKeywords;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetNegativeKeywordsByAdGroupIdsResponse)) return false;
        GetNegativeKeywordsByAdGroupIdsResponse other = (GetNegativeKeywordsByAdGroupIdsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.adGroupNegativeKeywords==null && other.getAdGroupNegativeKeywords()==null) || 
             (this.adGroupNegativeKeywords!=null &&
              java.util.Arrays.equals(this.adGroupNegativeKeywords, other.getAdGroupNegativeKeywords())));
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
        if (getAdGroupNegativeKeywords() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAdGroupNegativeKeywords());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAdGroupNegativeKeywords(), i);
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
        new org.apache.axis.description.TypeDesc(GetNegativeKeywordsByAdGroupIdsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeKeywordsByAdGroupIdsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adGroupNegativeKeywords");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupNegativeKeywords"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupNegativeKeywords"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupNegativeKeywords"));
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
