/**
 * BudgetOpportunity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_Optimizer_Api_DataContracts_Entities;

public class BudgetOpportunity  extends org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_Optimizer_Api_DataContracts_Entities.Opportunity  implements java.io.Serializable {
    private java.util.Calendar budgetDepletionDate;

    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_Optimizer_Api_DataContracts.BudgetLimitType budgetType;

    private java.lang.Long campaignId;

    private java.lang.Double currentBudget;

    private java.lang.Integer increaseInClicks;

    private java.lang.Integer increaseInImpressions;

    private java.lang.Integer percentageIncreaseInClicks;

    private java.lang.Integer percentageIncreaseInImpressions;

    private java.lang.Double recommendedBudget;

    public BudgetOpportunity() {
    }

    public BudgetOpportunity(
           java.util.Calendar expirationDate,
           java.lang.String opportunityKey,
           java.util.Calendar budgetDepletionDate,
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_Optimizer_Api_DataContracts.BudgetLimitType budgetType,
           java.lang.Long campaignId,
           java.lang.Double currentBudget,
           java.lang.Integer increaseInClicks,
           java.lang.Integer increaseInImpressions,
           java.lang.Integer percentageIncreaseInClicks,
           java.lang.Integer percentageIncreaseInImpressions,
           java.lang.Double recommendedBudget) {
        super(
            expirationDate,
            opportunityKey);
        this.budgetDepletionDate = budgetDepletionDate;
        this.budgetType = budgetType;
        this.campaignId = campaignId;
        this.currentBudget = currentBudget;
        this.increaseInClicks = increaseInClicks;
        this.increaseInImpressions = increaseInImpressions;
        this.percentageIncreaseInClicks = percentageIncreaseInClicks;
        this.percentageIncreaseInImpressions = percentageIncreaseInImpressions;
        this.recommendedBudget = recommendedBudget;
    }


    /**
     * Gets the budgetDepletionDate value for this BudgetOpportunity.
     * 
     * @return budgetDepletionDate
     */
    public java.util.Calendar getBudgetDepletionDate() {
        return budgetDepletionDate;
    }


    /**
     * Sets the budgetDepletionDate value for this BudgetOpportunity.
     * 
     * @param budgetDepletionDate
     */
    public void setBudgetDepletionDate(java.util.Calendar budgetDepletionDate) {
        this.budgetDepletionDate = budgetDepletionDate;
    }


    /**
     * Gets the budgetType value for this BudgetOpportunity.
     * 
     * @return budgetType
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_Optimizer_Api_DataContracts.BudgetLimitType getBudgetType() {
        return budgetType;
    }


    /**
     * Sets the budgetType value for this BudgetOpportunity.
     * 
     * @param budgetType
     */
    public void setBudgetType(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_Optimizer_Api_DataContracts.BudgetLimitType budgetType) {
        this.budgetType = budgetType;
    }


    /**
     * Gets the campaignId value for this BudgetOpportunity.
     * 
     * @return campaignId
     */
    public java.lang.Long getCampaignId() {
        return campaignId;
    }


    /**
     * Sets the campaignId value for this BudgetOpportunity.
     * 
     * @param campaignId
     */
    public void setCampaignId(java.lang.Long campaignId) {
        this.campaignId = campaignId;
    }


    /**
     * Gets the currentBudget value for this BudgetOpportunity.
     * 
     * @return currentBudget
     */
    public java.lang.Double getCurrentBudget() {
        return currentBudget;
    }


    /**
     * Sets the currentBudget value for this BudgetOpportunity.
     * 
     * @param currentBudget
     */
    public void setCurrentBudget(java.lang.Double currentBudget) {
        this.currentBudget = currentBudget;
    }


    /**
     * Gets the increaseInClicks value for this BudgetOpportunity.
     * 
     * @return increaseInClicks
     */
    public java.lang.Integer getIncreaseInClicks() {
        return increaseInClicks;
    }


    /**
     * Sets the increaseInClicks value for this BudgetOpportunity.
     * 
     * @param increaseInClicks
     */
    public void setIncreaseInClicks(java.lang.Integer increaseInClicks) {
        this.increaseInClicks = increaseInClicks;
    }


    /**
     * Gets the increaseInImpressions value for this BudgetOpportunity.
     * 
     * @return increaseInImpressions
     */
    public java.lang.Integer getIncreaseInImpressions() {
        return increaseInImpressions;
    }


    /**
     * Sets the increaseInImpressions value for this BudgetOpportunity.
     * 
     * @param increaseInImpressions
     */
    public void setIncreaseInImpressions(java.lang.Integer increaseInImpressions) {
        this.increaseInImpressions = increaseInImpressions;
    }


    /**
     * Gets the percentageIncreaseInClicks value for this BudgetOpportunity.
     * 
     * @return percentageIncreaseInClicks
     */
    public java.lang.Integer getPercentageIncreaseInClicks() {
        return percentageIncreaseInClicks;
    }


    /**
     * Sets the percentageIncreaseInClicks value for this BudgetOpportunity.
     * 
     * @param percentageIncreaseInClicks
     */
    public void setPercentageIncreaseInClicks(java.lang.Integer percentageIncreaseInClicks) {
        this.percentageIncreaseInClicks = percentageIncreaseInClicks;
    }


    /**
     * Gets the percentageIncreaseInImpressions value for this BudgetOpportunity.
     * 
     * @return percentageIncreaseInImpressions
     */
    public java.lang.Integer getPercentageIncreaseInImpressions() {
        return percentageIncreaseInImpressions;
    }


    /**
     * Sets the percentageIncreaseInImpressions value for this BudgetOpportunity.
     * 
     * @param percentageIncreaseInImpressions
     */
    public void setPercentageIncreaseInImpressions(java.lang.Integer percentageIncreaseInImpressions) {
        this.percentageIncreaseInImpressions = percentageIncreaseInImpressions;
    }


    /**
     * Gets the recommendedBudget value for this BudgetOpportunity.
     * 
     * @return recommendedBudget
     */
    public java.lang.Double getRecommendedBudget() {
        return recommendedBudget;
    }


    /**
     * Sets the recommendedBudget value for this BudgetOpportunity.
     * 
     * @param recommendedBudget
     */
    public void setRecommendedBudget(java.lang.Double recommendedBudget) {
        this.recommendedBudget = recommendedBudget;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BudgetOpportunity)) return false;
        BudgetOpportunity other = (BudgetOpportunity) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.budgetDepletionDate==null && other.getBudgetDepletionDate()==null) || 
             (this.budgetDepletionDate!=null &&
              this.budgetDepletionDate.equals(other.getBudgetDepletionDate()))) &&
            ((this.budgetType==null && other.getBudgetType()==null) || 
             (this.budgetType!=null &&
              this.budgetType.equals(other.getBudgetType()))) &&
            ((this.campaignId==null && other.getCampaignId()==null) || 
             (this.campaignId!=null &&
              this.campaignId.equals(other.getCampaignId()))) &&
            ((this.currentBudget==null && other.getCurrentBudget()==null) || 
             (this.currentBudget!=null &&
              this.currentBudget.equals(other.getCurrentBudget()))) &&
            ((this.increaseInClicks==null && other.getIncreaseInClicks()==null) || 
             (this.increaseInClicks!=null &&
              this.increaseInClicks.equals(other.getIncreaseInClicks()))) &&
            ((this.increaseInImpressions==null && other.getIncreaseInImpressions()==null) || 
             (this.increaseInImpressions!=null &&
              this.increaseInImpressions.equals(other.getIncreaseInImpressions()))) &&
            ((this.percentageIncreaseInClicks==null && other.getPercentageIncreaseInClicks()==null) || 
             (this.percentageIncreaseInClicks!=null &&
              this.percentageIncreaseInClicks.equals(other.getPercentageIncreaseInClicks()))) &&
            ((this.percentageIncreaseInImpressions==null && other.getPercentageIncreaseInImpressions()==null) || 
             (this.percentageIncreaseInImpressions!=null &&
              this.percentageIncreaseInImpressions.equals(other.getPercentageIncreaseInImpressions()))) &&
            ((this.recommendedBudget==null && other.getRecommendedBudget()==null) || 
             (this.recommendedBudget!=null &&
              this.recommendedBudget.equals(other.getRecommendedBudget())));
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
        if (getBudgetDepletionDate() != null) {
            _hashCode += getBudgetDepletionDate().hashCode();
        }
        if (getBudgetType() != null) {
            _hashCode += getBudgetType().hashCode();
        }
        if (getCampaignId() != null) {
            _hashCode += getCampaignId().hashCode();
        }
        if (getCurrentBudget() != null) {
            _hashCode += getCurrentBudget().hashCode();
        }
        if (getIncreaseInClicks() != null) {
            _hashCode += getIncreaseInClicks().hashCode();
        }
        if (getIncreaseInImpressions() != null) {
            _hashCode += getIncreaseInImpressions().hashCode();
        }
        if (getPercentageIncreaseInClicks() != null) {
            _hashCode += getPercentageIncreaseInClicks().hashCode();
        }
        if (getPercentageIncreaseInImpressions() != null) {
            _hashCode += getPercentageIncreaseInImpressions().hashCode();
        }
        if (getRecommendedBudget() != null) {
            _hashCode += getRecommendedBudget().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BudgetOpportunity.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "BudgetOpportunity"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("budgetDepletionDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "BudgetDepletionDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("budgetType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "BudgetType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts", "BudgetLimitType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campaignId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "CampaignId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentBudget");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "CurrentBudget"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("increaseInClicks");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "IncreaseInClicks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("increaseInImpressions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "IncreaseInImpressions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("percentageIncreaseInClicks");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "PercentageIncreaseInClicks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("percentageIncreaseInImpressions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "PercentageIncreaseInImpressions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recommendedBudget");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "RecommendedBudget"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
