/**
 * GetAdExtensionsByCampaignIdsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GetAdExtensionsByCampaignIdsRequest  implements java.io.Serializable {
    private java.lang.Long accountId;

    private long[] campaignIds;

    private java.lang.String[] adExtensionType;

    public GetAdExtensionsByCampaignIdsRequest() {
    }

    public GetAdExtensionsByCampaignIdsRequest(
           java.lang.Long accountId,
           long[] campaignIds,
           java.lang.String[] adExtensionType) {
           this.accountId = accountId;
           this.campaignIds = campaignIds;
           this.adExtensionType = adExtensionType;
    }


    /**
     * Gets the accountId value for this GetAdExtensionsByCampaignIdsRequest.
     * 
     * @return accountId
     */
    public java.lang.Long getAccountId() {
        return accountId;
    }


    /**
     * Sets the accountId value for this GetAdExtensionsByCampaignIdsRequest.
     * 
     * @param accountId
     */
    public void setAccountId(java.lang.Long accountId) {
        this.accountId = accountId;
    }


    /**
     * Gets the campaignIds value for this GetAdExtensionsByCampaignIdsRequest.
     * 
     * @return campaignIds
     */
    public long[] getCampaignIds() {
        return campaignIds;
    }


    /**
     * Sets the campaignIds value for this GetAdExtensionsByCampaignIdsRequest.
     * 
     * @param campaignIds
     */
    public void setCampaignIds(long[] campaignIds) {
        this.campaignIds = campaignIds;
    }


    /**
     * Gets the adExtensionType value for this GetAdExtensionsByCampaignIdsRequest.
     * 
     * @return adExtensionType
     */
    public java.lang.String[] getAdExtensionType() {
        return adExtensionType;
    }


    /**
     * Sets the adExtensionType value for this GetAdExtensionsByCampaignIdsRequest.
     * 
     * @param adExtensionType
     */
    public void setAdExtensionType(java.lang.String[] adExtensionType) {
        this.adExtensionType = adExtensionType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAdExtensionsByCampaignIdsRequest)) return false;
        GetAdExtensionsByCampaignIdsRequest other = (GetAdExtensionsByCampaignIdsRequest) obj;
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
            ((this.campaignIds==null && other.getCampaignIds()==null) || 
             (this.campaignIds!=null &&
              java.util.Arrays.equals(this.campaignIds, other.getCampaignIds()))) &&
            ((this.adExtensionType==null && other.getAdExtensionType()==null) || 
             (this.adExtensionType!=null &&
              java.util.Arrays.equals(this.adExtensionType, other.getAdExtensionType())));
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
        if (getCampaignIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCampaignIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCampaignIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAdExtensionType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAdExtensionType());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAdExtensionType(), i);
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
        new org.apache.axis.description.TypeDesc(GetAdExtensionsByCampaignIdsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdExtensionsByCampaignIdsRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campaignIds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adExtensionType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionType"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionsTypeFilter"));
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
