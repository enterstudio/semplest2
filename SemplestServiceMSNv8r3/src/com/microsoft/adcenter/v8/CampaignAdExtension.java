/**
 * CampaignAdExtension.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class CampaignAdExtension  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.AdExtension2 adExtension;

    private long campaignId;

    private com.microsoft.adcenter.v8.CampaignAdExtensionEditorialStatus editorialStatus;

    public CampaignAdExtension() {
    }

    public CampaignAdExtension(
           com.microsoft.adcenter.v8.AdExtension2 adExtension,
           long campaignId,
           com.microsoft.adcenter.v8.CampaignAdExtensionEditorialStatus editorialStatus) {
           this.adExtension = adExtension;
           this.campaignId = campaignId;
           this.editorialStatus = editorialStatus;
    }


    /**
     * Gets the adExtension value for this CampaignAdExtension.
     * 
     * @return adExtension
     */
    public com.microsoft.adcenter.v8.AdExtension2 getAdExtension() {
        return adExtension;
    }


    /**
     * Sets the adExtension value for this CampaignAdExtension.
     * 
     * @param adExtension
     */
    public void setAdExtension(com.microsoft.adcenter.v8.AdExtension2 adExtension) {
        this.adExtension = adExtension;
    }


    /**
     * Gets the campaignId value for this CampaignAdExtension.
     * 
     * @return campaignId
     */
    public long getCampaignId() {
        return campaignId;
    }


    /**
     * Sets the campaignId value for this CampaignAdExtension.
     * 
     * @param campaignId
     */
    public void setCampaignId(long campaignId) {
        this.campaignId = campaignId;
    }


    /**
     * Gets the editorialStatus value for this CampaignAdExtension.
     * 
     * @return editorialStatus
     */
    public com.microsoft.adcenter.v8.CampaignAdExtensionEditorialStatus getEditorialStatus() {
        return editorialStatus;
    }


    /**
     * Sets the editorialStatus value for this CampaignAdExtension.
     * 
     * @param editorialStatus
     */
    public void setEditorialStatus(com.microsoft.adcenter.v8.CampaignAdExtensionEditorialStatus editorialStatus) {
        this.editorialStatus = editorialStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CampaignAdExtension)) return false;
        CampaignAdExtension other = (CampaignAdExtension) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.adExtension==null && other.getAdExtension()==null) || 
             (this.adExtension!=null &&
              this.adExtension.equals(other.getAdExtension()))) &&
            this.campaignId == other.getCampaignId() &&
            ((this.editorialStatus==null && other.getEditorialStatus()==null) || 
             (this.editorialStatus!=null &&
              this.editorialStatus.equals(other.getEditorialStatus())));
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
        if (getAdExtension() != null) {
            _hashCode += getAdExtension().hashCode();
        }
        _hashCode += new Long(getCampaignId()).hashCode();
        if (getEditorialStatus() != null) {
            _hashCode += getEditorialStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CampaignAdExtension.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignAdExtension"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adExtension");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtension"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtension2"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campaignId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editorialStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignAdExtensionEditorialStatus"));
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
