/**
 * GetAdGroupsByCampaignIdResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GetAdGroupsByCampaignIdResponse  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.AdGroup[] adGroups;

    public GetAdGroupsByCampaignIdResponse() {
    }

    public GetAdGroupsByCampaignIdResponse(
           com.microsoft.adcenter.v8.AdGroup[] adGroups) {
           this.adGroups = adGroups;
    }


    /**
     * Gets the adGroups value for this GetAdGroupsByCampaignIdResponse.
     * 
     * @return adGroups
     */
    public com.microsoft.adcenter.v8.AdGroup[] getAdGroups() {
        return adGroups;
    }


    /**
     * Sets the adGroups value for this GetAdGroupsByCampaignIdResponse.
     * 
     * @param adGroups
     */
    public void setAdGroups(com.microsoft.adcenter.v8.AdGroup[] adGroups) {
        this.adGroups = adGroups;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAdGroupsByCampaignIdResponse)) return false;
        GetAdGroupsByCampaignIdResponse other = (GetAdGroupsByCampaignIdResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.adGroups==null && other.getAdGroups()==null) || 
             (this.adGroups!=null &&
              java.util.Arrays.equals(this.adGroups, other.getAdGroups())));
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
        if (getAdGroups() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAdGroups());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAdGroups(), i);
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
        new org.apache.axis.description.TypeDesc(GetAdGroupsByCampaignIdResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdGroupsByCampaignIdResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adGroups");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroups"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroup"));
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