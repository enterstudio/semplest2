/**
 * CampaignAdExtensionCollection.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class CampaignAdExtensionCollection  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.CampaignAdExtension[] campaignAdExtensions;

    public CampaignAdExtensionCollection() {
    }

    public CampaignAdExtensionCollection(
           com.microsoft.adcenter.v8.CampaignAdExtension[] campaignAdExtensions) {
           this.campaignAdExtensions = campaignAdExtensions;
    }


    /**
     * Gets the campaignAdExtensions value for this CampaignAdExtensionCollection.
     * 
     * @return campaignAdExtensions
     */
    public com.microsoft.adcenter.v8.CampaignAdExtension[] getCampaignAdExtensions() {
        return campaignAdExtensions;
    }


    /**
     * Sets the campaignAdExtensions value for this CampaignAdExtensionCollection.
     * 
     * @param campaignAdExtensions
     */
    public void setCampaignAdExtensions(com.microsoft.adcenter.v8.CampaignAdExtension[] campaignAdExtensions) {
        this.campaignAdExtensions = campaignAdExtensions;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CampaignAdExtensionCollection)) return false;
        CampaignAdExtensionCollection other = (CampaignAdExtensionCollection) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.campaignAdExtensions==null && other.getCampaignAdExtensions()==null) || 
             (this.campaignAdExtensions!=null &&
              java.util.Arrays.equals(this.campaignAdExtensions, other.getCampaignAdExtensions())));
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
        if (getCampaignAdExtensions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCampaignAdExtensions());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCampaignAdExtensions(), i);
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
        new org.apache.axis.description.TypeDesc(CampaignAdExtensionCollection.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignAdExtensionCollection"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campaignAdExtensions");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignAdExtensions"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignAdExtension"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignAdExtension"));
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
