/**
 * LowBudgetBalanceCampaignInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.notifications.Entities;

public class LowBudgetBalanceCampaignInfo  extends com.microsoft.adcenter.api.notifications.Entities.CampaignInfo  implements java.io.Serializable {
    private java.lang.Double estimatedBudgetBalance;

    private java.lang.Integer estimatedImpressions;

    public LowBudgetBalanceCampaignInfo() {
    }

    public LowBudgetBalanceCampaignInfo(
           java.lang.Long campaignId,
           java.lang.String campaignName,
           java.lang.Double budgetAmount,
           java.lang.Double estimatedBudgetBalance,
           java.lang.Integer estimatedImpressions) {
        super(
            campaignId,
            campaignName,
            budgetAmount);
        this.estimatedBudgetBalance = estimatedBudgetBalance;
        this.estimatedImpressions = estimatedImpressions;
    }


    /**
     * Gets the estimatedBudgetBalance value for this LowBudgetBalanceCampaignInfo.
     * 
     * @return estimatedBudgetBalance
     */
    public java.lang.Double getEstimatedBudgetBalance() {
        return estimatedBudgetBalance;
    }


    /**
     * Sets the estimatedBudgetBalance value for this LowBudgetBalanceCampaignInfo.
     * 
     * @param estimatedBudgetBalance
     */
    public void setEstimatedBudgetBalance(java.lang.Double estimatedBudgetBalance) {
        this.estimatedBudgetBalance = estimatedBudgetBalance;
    }


    /**
     * Gets the estimatedImpressions value for this LowBudgetBalanceCampaignInfo.
     * 
     * @return estimatedImpressions
     */
    public java.lang.Integer getEstimatedImpressions() {
        return estimatedImpressions;
    }


    /**
     * Sets the estimatedImpressions value for this LowBudgetBalanceCampaignInfo.
     * 
     * @param estimatedImpressions
     */
    public void setEstimatedImpressions(java.lang.Integer estimatedImpressions) {
        this.estimatedImpressions = estimatedImpressions;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LowBudgetBalanceCampaignInfo)) return false;
        LowBudgetBalanceCampaignInfo other = (LowBudgetBalanceCampaignInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.estimatedBudgetBalance==null && other.getEstimatedBudgetBalance()==null) || 
             (this.estimatedBudgetBalance!=null &&
              this.estimatedBudgetBalance.equals(other.getEstimatedBudgetBalance()))) &&
            ((this.estimatedImpressions==null && other.getEstimatedImpressions()==null) || 
             (this.estimatedImpressions!=null &&
              this.estimatedImpressions.equals(other.getEstimatedImpressions())));
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
        if (getEstimatedBudgetBalance() != null) {
            _hashCode += getEstimatedBudgetBalance().hashCode();
        }
        if (getEstimatedImpressions() != null) {
            _hashCode += getEstimatedImpressions().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LowBudgetBalanceCampaignInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "LowBudgetBalanceCampaignInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estimatedBudgetBalance");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "EstimatedBudgetBalance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estimatedImpressions");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "EstimatedImpressions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
