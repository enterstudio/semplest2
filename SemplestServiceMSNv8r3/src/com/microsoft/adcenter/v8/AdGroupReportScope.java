/**
 * AdGroupReportScope.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class AdGroupReportScope  implements java.io.Serializable {
    private long parentAccountId;

    private long parentCampaignId;

    private long adGroupId;

    public AdGroupReportScope() {
    }

    public AdGroupReportScope(
           long parentAccountId,
           long parentCampaignId,
           long adGroupId) {
           this.parentAccountId = parentAccountId;
           this.parentCampaignId = parentCampaignId;
           this.adGroupId = adGroupId;
    }


    /**
     * Gets the parentAccountId value for this AdGroupReportScope.
     * 
     * @return parentAccountId
     */
    public long getParentAccountId() {
        return parentAccountId;
    }


    /**
     * Sets the parentAccountId value for this AdGroupReportScope.
     * 
     * @param parentAccountId
     */
    public void setParentAccountId(long parentAccountId) {
        this.parentAccountId = parentAccountId;
    }


    /**
     * Gets the parentCampaignId value for this AdGroupReportScope.
     * 
     * @return parentCampaignId
     */
    public long getParentCampaignId() {
        return parentCampaignId;
    }


    /**
     * Sets the parentCampaignId value for this AdGroupReportScope.
     * 
     * @param parentCampaignId
     */
    public void setParentCampaignId(long parentCampaignId) {
        this.parentCampaignId = parentCampaignId;
    }


    /**
     * Gets the adGroupId value for this AdGroupReportScope.
     * 
     * @return adGroupId
     */
    public long getAdGroupId() {
        return adGroupId;
    }


    /**
     * Sets the adGroupId value for this AdGroupReportScope.
     * 
     * @param adGroupId
     */
    public void setAdGroupId(long adGroupId) {
        this.adGroupId = adGroupId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AdGroupReportScope)) return false;
        AdGroupReportScope other = (AdGroupReportScope) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.parentAccountId == other.getParentAccountId() &&
            this.parentCampaignId == other.getParentCampaignId() &&
            this.adGroupId == other.getAdGroupId();
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
        _hashCode += new Long(getParentAccountId()).hashCode();
        _hashCode += new Long(getParentCampaignId()).hashCode();
        _hashCode += new Long(getAdGroupId()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AdGroupReportScope.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupReportScope"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentAccountId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ParentAccountId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentCampaignId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ParentCampaignId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adGroupId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
