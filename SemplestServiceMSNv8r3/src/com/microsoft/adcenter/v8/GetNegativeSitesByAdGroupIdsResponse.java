/**
 * GetNegativeSitesByAdGroupIdsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GetNegativeSitesByAdGroupIdsResponse  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.AdGroupNegativeSites[] adGroupNegativeSites;

    public GetNegativeSitesByAdGroupIdsResponse() {
    }

    public GetNegativeSitesByAdGroupIdsResponse(
           com.microsoft.adcenter.v8.AdGroupNegativeSites[] adGroupNegativeSites) {
           this.adGroupNegativeSites = adGroupNegativeSites;
    }


    /**
     * Gets the adGroupNegativeSites value for this GetNegativeSitesByAdGroupIdsResponse.
     * 
     * @return adGroupNegativeSites
     */
    public com.microsoft.adcenter.v8.AdGroupNegativeSites[] getAdGroupNegativeSites() {
        return adGroupNegativeSites;
    }


    /**
     * Sets the adGroupNegativeSites value for this GetNegativeSitesByAdGroupIdsResponse.
     * 
     * @param adGroupNegativeSites
     */
    public void setAdGroupNegativeSites(com.microsoft.adcenter.v8.AdGroupNegativeSites[] adGroupNegativeSites) {
        this.adGroupNegativeSites = adGroupNegativeSites;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetNegativeSitesByAdGroupIdsResponse)) return false;
        GetNegativeSitesByAdGroupIdsResponse other = (GetNegativeSitesByAdGroupIdsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.adGroupNegativeSites==null && other.getAdGroupNegativeSites()==null) || 
             (this.adGroupNegativeSites!=null &&
              java.util.Arrays.equals(this.adGroupNegativeSites, other.getAdGroupNegativeSites())));
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
        if (getAdGroupNegativeSites() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAdGroupNegativeSites());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAdGroupNegativeSites(), i);
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
        new org.apache.axis.description.TypeDesc(GetNegativeSitesByAdGroupIdsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeSitesByAdGroupIdsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adGroupNegativeSites");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupNegativeSites"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupNegativeSites"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupNegativeSites"));
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
