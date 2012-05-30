/**
 * AccountThroughAdGroupReportScope.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class AccountThroughAdGroupReportScope  implements java.io.Serializable {
    private long[] accountIds;

    private com.microsoft.adcenter.v8.AdGroupReportScope[] adGroups;

    private com.microsoft.adcenter.v8.CampaignReportScope[] campaigns;

    public AccountThroughAdGroupReportScope() {
    }

    public AccountThroughAdGroupReportScope(
           long[] accountIds,
           com.microsoft.adcenter.v8.AdGroupReportScope[] adGroups,
           com.microsoft.adcenter.v8.CampaignReportScope[] campaigns) {
           this.accountIds = accountIds;
           this.adGroups = adGroups;
           this.campaigns = campaigns;
    }


    /**
     * Gets the accountIds value for this AccountThroughAdGroupReportScope.
     * 
     * @return accountIds
     */
    public long[] getAccountIds() {
        return accountIds;
    }


    /**
     * Sets the accountIds value for this AccountThroughAdGroupReportScope.
     * 
     * @param accountIds
     */
    public void setAccountIds(long[] accountIds) {
        this.accountIds = accountIds;
    }


    /**
     * Gets the adGroups value for this AccountThroughAdGroupReportScope.
     * 
     * @return adGroups
     */
    public com.microsoft.adcenter.v8.AdGroupReportScope[] getAdGroups() {
        return adGroups;
    }


    /**
     * Sets the adGroups value for this AccountThroughAdGroupReportScope.
     * 
     * @param adGroups
     */
    public void setAdGroups(com.microsoft.adcenter.v8.AdGroupReportScope[] adGroups) {
        this.adGroups = adGroups;
    }


    /**
     * Gets the campaigns value for this AccountThroughAdGroupReportScope.
     * 
     * @return campaigns
     */
    public com.microsoft.adcenter.v8.CampaignReportScope[] getCampaigns() {
        return campaigns;
    }


    /**
     * Sets the campaigns value for this AccountThroughAdGroupReportScope.
     * 
     * @param campaigns
     */
    public void setCampaigns(com.microsoft.adcenter.v8.CampaignReportScope[] campaigns) {
        this.campaigns = campaigns;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccountThroughAdGroupReportScope)) return false;
        AccountThroughAdGroupReportScope other = (AccountThroughAdGroupReportScope) obj;
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
            ((this.adGroups==null && other.getAdGroups()==null) || 
             (this.adGroups!=null &&
              java.util.Arrays.equals(this.adGroups, other.getAdGroups()))) &&
            ((this.campaigns==null && other.getCampaigns()==null) || 
             (this.campaigns!=null &&
              java.util.Arrays.equals(this.campaigns, other.getCampaigns())));
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccountThroughAdGroupReportScope.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountThroughAdGroupReportScope"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountIds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adGroups");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroups"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupReportScope"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupReportScope"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campaigns");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Campaigns"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignReportScope"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignReportScope"));
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
