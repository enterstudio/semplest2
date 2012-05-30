/**
 * DeleteAdExtensionsFromCampaignsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class DeleteAdExtensionsFromCampaignsRequest  implements java.io.Serializable {
    private java.lang.Long accountId;

    private com.microsoft.adcenter.v8.AdExtensionIdToCampaignIdAssociation[] adExtensionIdToCampaignIdAssociations;

    public DeleteAdExtensionsFromCampaignsRequest() {
    }

    public DeleteAdExtensionsFromCampaignsRequest(
           java.lang.Long accountId,
           com.microsoft.adcenter.v8.AdExtensionIdToCampaignIdAssociation[] adExtensionIdToCampaignIdAssociations) {
           this.accountId = accountId;
           this.adExtensionIdToCampaignIdAssociations = adExtensionIdToCampaignIdAssociations;
    }


    /**
     * Gets the accountId value for this DeleteAdExtensionsFromCampaignsRequest.
     * 
     * @return accountId
     */
    public java.lang.Long getAccountId() {
        return accountId;
    }


    /**
     * Sets the accountId value for this DeleteAdExtensionsFromCampaignsRequest.
     * 
     * @param accountId
     */
    public void setAccountId(java.lang.Long accountId) {
        this.accountId = accountId;
    }


    /**
     * Gets the adExtensionIdToCampaignIdAssociations value for this DeleteAdExtensionsFromCampaignsRequest.
     * 
     * @return adExtensionIdToCampaignIdAssociations
     */
    public com.microsoft.adcenter.v8.AdExtensionIdToCampaignIdAssociation[] getAdExtensionIdToCampaignIdAssociations() {
        return adExtensionIdToCampaignIdAssociations;
    }


    /**
     * Sets the adExtensionIdToCampaignIdAssociations value for this DeleteAdExtensionsFromCampaignsRequest.
     * 
     * @param adExtensionIdToCampaignIdAssociations
     */
    public void setAdExtensionIdToCampaignIdAssociations(com.microsoft.adcenter.v8.AdExtensionIdToCampaignIdAssociation[] adExtensionIdToCampaignIdAssociations) {
        this.adExtensionIdToCampaignIdAssociations = adExtensionIdToCampaignIdAssociations;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeleteAdExtensionsFromCampaignsRequest)) return false;
        DeleteAdExtensionsFromCampaignsRequest other = (DeleteAdExtensionsFromCampaignsRequest) obj;
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
            ((this.adExtensionIdToCampaignIdAssociations==null && other.getAdExtensionIdToCampaignIdAssociations()==null) || 
             (this.adExtensionIdToCampaignIdAssociations!=null &&
              java.util.Arrays.equals(this.adExtensionIdToCampaignIdAssociations, other.getAdExtensionIdToCampaignIdAssociations())));
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
        if (getAdExtensionIdToCampaignIdAssociations() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAdExtensionIdToCampaignIdAssociations());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAdExtensionIdToCampaignIdAssociations(), i);
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
        new org.apache.axis.description.TypeDesc(DeleteAdExtensionsFromCampaignsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteAdExtensionsFromCampaignsRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adExtensionIdToCampaignIdAssociations");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionIdToCampaignIdAssociations"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionIdToCampaignIdAssociation"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionIdToCampaignIdAssociation"));
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
