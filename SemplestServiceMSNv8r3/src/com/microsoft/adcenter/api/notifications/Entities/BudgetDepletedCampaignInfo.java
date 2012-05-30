/**
 * BudgetDepletedCampaignInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.notifications.Entities;

public class BudgetDepletedCampaignInfo  extends com.microsoft.adcenter.api.notifications.Entities.CampaignInfo  implements java.io.Serializable {
    private java.lang.String currencyCode;

    private java.util.Calendar budgetDepletedDate;

    public BudgetDepletedCampaignInfo() {
    }

    public BudgetDepletedCampaignInfo(
           java.lang.Long campaignId,
           java.lang.String campaignName,
           java.lang.Double budgetAmount,
           java.lang.String currencyCode,
           java.util.Calendar budgetDepletedDate) {
        super(
            campaignId,
            campaignName,
            budgetAmount);
        this.currencyCode = currencyCode;
        this.budgetDepletedDate = budgetDepletedDate;
    }


    /**
     * Gets the currencyCode value for this BudgetDepletedCampaignInfo.
     * 
     * @return currencyCode
     */
    public java.lang.String getCurrencyCode() {
        return currencyCode;
    }


    /**
     * Sets the currencyCode value for this BudgetDepletedCampaignInfo.
     * 
     * @param currencyCode
     */
    public void setCurrencyCode(java.lang.String currencyCode) {
        this.currencyCode = currencyCode;
    }


    /**
     * Gets the budgetDepletedDate value for this BudgetDepletedCampaignInfo.
     * 
     * @return budgetDepletedDate
     */
    public java.util.Calendar getBudgetDepletedDate() {
        return budgetDepletedDate;
    }


    /**
     * Sets the budgetDepletedDate value for this BudgetDepletedCampaignInfo.
     * 
     * @param budgetDepletedDate
     */
    public void setBudgetDepletedDate(java.util.Calendar budgetDepletedDate) {
        this.budgetDepletedDate = budgetDepletedDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BudgetDepletedCampaignInfo)) return false;
        BudgetDepletedCampaignInfo other = (BudgetDepletedCampaignInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.currencyCode==null && other.getCurrencyCode()==null) || 
             (this.currencyCode!=null &&
              this.currencyCode.equals(other.getCurrencyCode()))) &&
            ((this.budgetDepletedDate==null && other.getBudgetDepletedDate()==null) || 
             (this.budgetDepletedDate!=null &&
              this.budgetDepletedDate.equals(other.getBudgetDepletedDate())));
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
        if (getCurrencyCode() != null) {
            _hashCode += getCurrencyCode().hashCode();
        }
        if (getBudgetDepletedDate() != null) {
            _hashCode += getBudgetDepletedDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BudgetDepletedCampaignInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "BudgetDepletedCampaignInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currencyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "CurrencyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("budgetDepletedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "BudgetDepletedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
