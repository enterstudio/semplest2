/**
 * AdExtension.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class AdExtension  implements java.io.Serializable {
    private long campaignId;

    private java.lang.Boolean enableLocationExtension;

    private com.microsoft.adcenter.v8.PhoneExtension phoneExtension;

    public AdExtension() {
    }

    public AdExtension(
           long campaignId,
           java.lang.Boolean enableLocationExtension,
           com.microsoft.adcenter.v8.PhoneExtension phoneExtension) {
           this.campaignId = campaignId;
           this.enableLocationExtension = enableLocationExtension;
           this.phoneExtension = phoneExtension;
    }


    /**
     * Gets the campaignId value for this AdExtension.
     * 
     * @return campaignId
     */
    public long getCampaignId() {
        return campaignId;
    }


    /**
     * Sets the campaignId value for this AdExtension.
     * 
     * @param campaignId
     */
    public void setCampaignId(long campaignId) {
        this.campaignId = campaignId;
    }


    /**
     * Gets the enableLocationExtension value for this AdExtension.
     * 
     * @return enableLocationExtension
     */
    public java.lang.Boolean getEnableLocationExtension() {
        return enableLocationExtension;
    }


    /**
     * Sets the enableLocationExtension value for this AdExtension.
     * 
     * @param enableLocationExtension
     */
    public void setEnableLocationExtension(java.lang.Boolean enableLocationExtension) {
        this.enableLocationExtension = enableLocationExtension;
    }


    /**
     * Gets the phoneExtension value for this AdExtension.
     * 
     * @return phoneExtension
     */
    public com.microsoft.adcenter.v8.PhoneExtension getPhoneExtension() {
        return phoneExtension;
    }


    /**
     * Sets the phoneExtension value for this AdExtension.
     * 
     * @param phoneExtension
     */
    public void setPhoneExtension(com.microsoft.adcenter.v8.PhoneExtension phoneExtension) {
        this.phoneExtension = phoneExtension;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AdExtension)) return false;
        AdExtension other = (AdExtension) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.campaignId == other.getCampaignId() &&
            ((this.enableLocationExtension==null && other.getEnableLocationExtension()==null) || 
             (this.enableLocationExtension!=null &&
              this.enableLocationExtension.equals(other.getEnableLocationExtension()))) &&
            ((this.phoneExtension==null && other.getPhoneExtension()==null) || 
             (this.phoneExtension!=null &&
              this.phoneExtension.equals(other.getPhoneExtension())));
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
        _hashCode += new Long(getCampaignId()).hashCode();
        if (getEnableLocationExtension() != null) {
            _hashCode += getEnableLocationExtension().hashCode();
        }
        if (getPhoneExtension() != null) {
            _hashCode += getPhoneExtension().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AdExtension.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtension"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campaignId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enableLocationExtension");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EnableLocationExtension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phoneExtension");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PhoneExtension"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PhoneExtension"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
