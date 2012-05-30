/**
 * GetAdExtensionsByCampaignIdsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GetAdExtensionsByCampaignIdsResponse  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.CampaignAdExtensionCollection[] campaignAdExtensionCollection;

    public GetAdExtensionsByCampaignIdsResponse() {
    }

    public GetAdExtensionsByCampaignIdsResponse(
           com.microsoft.adcenter.v8.CampaignAdExtensionCollection[] campaignAdExtensionCollection) {
           this.campaignAdExtensionCollection = campaignAdExtensionCollection;
    }


    /**
     * Gets the campaignAdExtensionCollection value for this GetAdExtensionsByCampaignIdsResponse.
     * 
     * @return campaignAdExtensionCollection
     */
    public com.microsoft.adcenter.v8.CampaignAdExtensionCollection[] getCampaignAdExtensionCollection() {
        return campaignAdExtensionCollection;
    }


    /**
     * Sets the campaignAdExtensionCollection value for this GetAdExtensionsByCampaignIdsResponse.
     * 
     * @param campaignAdExtensionCollection
     */
    public void setCampaignAdExtensionCollection(com.microsoft.adcenter.v8.CampaignAdExtensionCollection[] campaignAdExtensionCollection) {
        this.campaignAdExtensionCollection = campaignAdExtensionCollection;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAdExtensionsByCampaignIdsResponse)) return false;
        GetAdExtensionsByCampaignIdsResponse other = (GetAdExtensionsByCampaignIdsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.campaignAdExtensionCollection==null && other.getCampaignAdExtensionCollection()==null) || 
             (this.campaignAdExtensionCollection!=null &&
              java.util.Arrays.equals(this.campaignAdExtensionCollection, other.getCampaignAdExtensionCollection())));
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
        if (getCampaignAdExtensionCollection() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCampaignAdExtensionCollection());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCampaignAdExtensionCollection(), i);
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
        new org.apache.axis.description.TypeDesc(GetAdExtensionsByCampaignIdsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdExtensionsByCampaignIdsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campaignAdExtensionCollection");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignAdExtensionCollection"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignAdExtensionCollection"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignAdExtensionCollection"));
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
