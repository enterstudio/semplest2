/**
 * DownloadCampaignHierarchyRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class DownloadCampaignHierarchyRequest  implements java.io.Serializable {
    private long[] accountIds;

    private com.microsoft.adcenter.v8.CampaignScope[] campaigns;

    private java.util.Calendar lastSyncTimeInUTC;

    private java.lang.String[] entityFilter;

    public DownloadCampaignHierarchyRequest() {
    }

    public DownloadCampaignHierarchyRequest(
           long[] accountIds,
           com.microsoft.adcenter.v8.CampaignScope[] campaigns,
           java.util.Calendar lastSyncTimeInUTC,
           java.lang.String[] entityFilter) {
           this.accountIds = accountIds;
           this.campaigns = campaigns;
           this.lastSyncTimeInUTC = lastSyncTimeInUTC;
           this.entityFilter = entityFilter;
    }


    /**
     * Gets the accountIds value for this DownloadCampaignHierarchyRequest.
     * 
     * @return accountIds
     */
    public long[] getAccountIds() {
        return accountIds;
    }


    /**
     * Sets the accountIds value for this DownloadCampaignHierarchyRequest.
     * 
     * @param accountIds
     */
    public void setAccountIds(long[] accountIds) {
        this.accountIds = accountIds;
    }


    /**
     * Gets the campaigns value for this DownloadCampaignHierarchyRequest.
     * 
     * @return campaigns
     */
    public com.microsoft.adcenter.v8.CampaignScope[] getCampaigns() {
        return campaigns;
    }


    /**
     * Sets the campaigns value for this DownloadCampaignHierarchyRequest.
     * 
     * @param campaigns
     */
    public void setCampaigns(com.microsoft.adcenter.v8.CampaignScope[] campaigns) {
        this.campaigns = campaigns;
    }


    /**
     * Gets the lastSyncTimeInUTC value for this DownloadCampaignHierarchyRequest.
     * 
     * @return lastSyncTimeInUTC
     */
    public java.util.Calendar getLastSyncTimeInUTC() {
        return lastSyncTimeInUTC;
    }


    /**
     * Sets the lastSyncTimeInUTC value for this DownloadCampaignHierarchyRequest.
     * 
     * @param lastSyncTimeInUTC
     */
    public void setLastSyncTimeInUTC(java.util.Calendar lastSyncTimeInUTC) {
        this.lastSyncTimeInUTC = lastSyncTimeInUTC;
    }


    /**
     * Gets the entityFilter value for this DownloadCampaignHierarchyRequest.
     * 
     * @return entityFilter
     */
    public java.lang.String[] getEntityFilter() {
        return entityFilter;
    }


    /**
     * Sets the entityFilter value for this DownloadCampaignHierarchyRequest.
     * 
     * @param entityFilter
     */
    public void setEntityFilter(java.lang.String[] entityFilter) {
        this.entityFilter = entityFilter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DownloadCampaignHierarchyRequest)) return false;
        DownloadCampaignHierarchyRequest other = (DownloadCampaignHierarchyRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountIds==null && other.getAccountIds()==null) || 
             (this.accountIds!=null &&
              java.util.Arrays.equals(this.accountIds, other.getAccountIds()))) &&
            ((this.campaigns==null && other.getCampaigns()==null) || 
             (this.campaigns!=null &&
              java.util.Arrays.equals(this.campaigns, other.getCampaigns()))) &&
            ((this.lastSyncTimeInUTC==null && other.getLastSyncTimeInUTC()==null) || 
             (this.lastSyncTimeInUTC!=null &&
              this.lastSyncTimeInUTC.equals(other.getLastSyncTimeInUTC()))) &&
            ((this.entityFilter==null && other.getEntityFilter()==null) || 
             (this.entityFilter!=null &&
              java.util.Arrays.equals(this.entityFilter, other.getEntityFilter())));
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
        if (getAccountIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccountIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccountIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCampaigns() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCampaigns());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCampaigns(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLastSyncTimeInUTC() != null) {
            _hashCode += getLastSyncTimeInUTC().hashCode();
        }
        if (getEntityFilter() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEntityFilter());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEntityFilter(), i);
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
        new org.apache.axis.description.TypeDesc(DownloadCampaignHierarchyRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DownloadCampaignHierarchyRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountIds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campaigns");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Campaigns"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignScope"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignScope"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastSyncTimeInUTC");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "LastSyncTimeInUTC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entityFilter");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EntityFilter"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DownloadEntityFilter"));
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
