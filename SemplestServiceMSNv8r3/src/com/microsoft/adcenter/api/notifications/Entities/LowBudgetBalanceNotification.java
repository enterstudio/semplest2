/**
 * LowBudgetBalanceNotification.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.notifications.Entities;

public class LowBudgetBalanceNotification  extends com.microsoft.adcenter.api.notifications.Entities.AccountNotification  implements java.io.Serializable {
    private java.lang.Long customerId;

    private com.microsoft.adcenter.api.notifications.Entities.LowBudgetBalanceCampaignInfo[] affectedCampaigns;

    private java.lang.String accountName;

    public LowBudgetBalanceNotification() {
    }

    public LowBudgetBalanceNotification(
           java.lang.Long notificationId,
           java.util.Calendar notificationDate,
           java.lang.String[] notificationType,
           java.lang.Long accountId,
           java.lang.String accountNumber,
           java.lang.Long customerId,
           com.microsoft.adcenter.api.notifications.Entities.LowBudgetBalanceCampaignInfo[] affectedCampaigns,
           java.lang.String accountName) {
        super(
            notificationId,
            notificationDate,
            notificationType,
            accountId,
            accountNumber);
        this.customerId = customerId;
        this.affectedCampaigns = affectedCampaigns;
        this.accountName = accountName;
    }


    /**
     * Gets the customerId value for this LowBudgetBalanceNotification.
     * 
     * @return customerId
     */
    public java.lang.Long getCustomerId() {
        return customerId;
    }


    /**
     * Sets the customerId value for this LowBudgetBalanceNotification.
     * 
     * @param customerId
     */
    public void setCustomerId(java.lang.Long customerId) {
        this.customerId = customerId;
    }


    /**
     * Gets the affectedCampaigns value for this LowBudgetBalanceNotification.
     * 
     * @return affectedCampaigns
     */
    public com.microsoft.adcenter.api.notifications.Entities.LowBudgetBalanceCampaignInfo[] getAffectedCampaigns() {
        return affectedCampaigns;
    }


    /**
     * Sets the affectedCampaigns value for this LowBudgetBalanceNotification.
     * 
     * @param affectedCampaigns
     */
    public void setAffectedCampaigns(com.microsoft.adcenter.api.notifications.Entities.LowBudgetBalanceCampaignInfo[] affectedCampaigns) {
        this.affectedCampaigns = affectedCampaigns;
    }


    /**
     * Gets the accountName value for this LowBudgetBalanceNotification.
     * 
     * @return accountName
     */
    public java.lang.String getAccountName() {
        return accountName;
    }


    /**
     * Sets the accountName value for this LowBudgetBalanceNotification.
     * 
     * @param accountName
     */
    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LowBudgetBalanceNotification)) return false;
        LowBudgetBalanceNotification other = (LowBudgetBalanceNotification) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.customerId==null && other.getCustomerId()==null) || 
             (this.customerId!=null &&
              this.customerId.equals(other.getCustomerId()))) &&
            ((this.affectedCampaigns==null && other.getAffectedCampaigns()==null) || 
             (this.affectedCampaigns!=null &&
              java.util.Arrays.equals(this.affectedCampaigns, other.getAffectedCampaigns()))) &&
            ((this.accountName==null && other.getAccountName()==null) || 
             (this.accountName!=null &&
              this.accountName.equals(other.getAccountName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCustomerId() != null) {
            _hashCode += getCustomerId().hashCode();
        }
        if (getAffectedCampaigns() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAffectedCampaigns());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAffectedCampaigns(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAccountName() != null) {
            _hashCode += getAccountName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LowBudgetBalanceNotification.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "LowBudgetBalanceNotification"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "CustomerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("affectedCampaigns");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "AffectedCampaigns"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "LowBudgetBalanceCampaignInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "LowBudgetBalanceCampaignInfo"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountName");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "AccountName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
