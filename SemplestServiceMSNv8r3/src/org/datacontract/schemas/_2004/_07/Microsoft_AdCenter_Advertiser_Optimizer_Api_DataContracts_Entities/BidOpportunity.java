/**
 * BidOpportunity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_Optimizer_Api_DataContracts_Entities;

public class BidOpportunity  extends org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_Optimizer_Api_DataContracts_Entities.Opportunity  implements java.io.Serializable {
    private java.lang.Long adGroupId;

    private java.lang.Double currentBid;

    private java.lang.Integer estimatedIncreaseInClicks;

    private java.lang.Double estimatedIncreaseInCost;

    private java.lang.Integer estimatedIncreaseInImpressions;

    private java.lang.Long keywordId;

    private java.lang.String matchType;

    private java.lang.Double suggestedBid;

    public BidOpportunity() {
    }

    public BidOpportunity(
           java.util.Calendar expirationDate,
           java.lang.String opportunityKey,
           java.lang.Long adGroupId,
           java.lang.Double currentBid,
           java.lang.Integer estimatedIncreaseInClicks,
           java.lang.Double estimatedIncreaseInCost,
           java.lang.Integer estimatedIncreaseInImpressions,
           java.lang.Long keywordId,
           java.lang.String matchType,
           java.lang.Double suggestedBid) {
        super(
            expirationDate,
            opportunityKey);
        this.adGroupId = adGroupId;
        this.currentBid = currentBid;
        this.estimatedIncreaseInClicks = estimatedIncreaseInClicks;
        this.estimatedIncreaseInCost = estimatedIncreaseInCost;
        this.estimatedIncreaseInImpressions = estimatedIncreaseInImpressions;
        this.keywordId = keywordId;
        this.matchType = matchType;
        this.suggestedBid = suggestedBid;
    }


    /**
     * Gets the adGroupId value for this BidOpportunity.
     * 
     * @return adGroupId
     */
    public java.lang.Long getAdGroupId() {
        return adGroupId;
    }


    /**
     * Sets the adGroupId value for this BidOpportunity.
     * 
     * @param adGroupId
     */
    public void setAdGroupId(java.lang.Long adGroupId) {
        this.adGroupId = adGroupId;
    }


    /**
     * Gets the currentBid value for this BidOpportunity.
     * 
     * @return currentBid
     */
    public java.lang.Double getCurrentBid() {
        return currentBid;
    }


    /**
     * Sets the currentBid value for this BidOpportunity.
     * 
     * @param currentBid
     */
    public void setCurrentBid(java.lang.Double currentBid) {
        this.currentBid = currentBid;
    }


    /**
     * Gets the estimatedIncreaseInClicks value for this BidOpportunity.
     * 
     * @return estimatedIncreaseInClicks
     */
    public java.lang.Integer getEstimatedIncreaseInClicks() {
        return estimatedIncreaseInClicks;
    }


    /**
     * Sets the estimatedIncreaseInClicks value for this BidOpportunity.
     * 
     * @param estimatedIncreaseInClicks
     */
    public void setEstimatedIncreaseInClicks(java.lang.Integer estimatedIncreaseInClicks) {
        this.estimatedIncreaseInClicks = estimatedIncreaseInClicks;
    }


    /**
     * Gets the estimatedIncreaseInCost value for this BidOpportunity.
     * 
     * @return estimatedIncreaseInCost
     */
    public java.lang.Double getEstimatedIncreaseInCost() {
        return estimatedIncreaseInCost;
    }


    /**
     * Sets the estimatedIncreaseInCost value for this BidOpportunity.
     * 
     * @param estimatedIncreaseInCost
     */
    public void setEstimatedIncreaseInCost(java.lang.Double estimatedIncreaseInCost) {
        this.estimatedIncreaseInCost = estimatedIncreaseInCost;
    }


    /**
     * Gets the estimatedIncreaseInImpressions value for this BidOpportunity.
     * 
     * @return estimatedIncreaseInImpressions
     */
    public java.lang.Integer getEstimatedIncreaseInImpressions() {
        return estimatedIncreaseInImpressions;
    }


    /**
     * Sets the estimatedIncreaseInImpressions value for this BidOpportunity.
     * 
     * @param estimatedIncreaseInImpressions
     */
    public void setEstimatedIncreaseInImpressions(java.lang.Integer estimatedIncreaseInImpressions) {
        this.estimatedIncreaseInImpressions = estimatedIncreaseInImpressions;
    }


    /**
     * Gets the keywordId value for this BidOpportunity.
     * 
     * @return keywordId
     */
    public java.lang.Long getKeywordId() {
        return keywordId;
    }


    /**
     * Sets the keywordId value for this BidOpportunity.
     * 
     * @param keywordId
     */
    public void setKeywordId(java.lang.Long keywordId) {
        this.keywordId = keywordId;
    }


    /**
     * Gets the matchType value for this BidOpportunity.
     * 
     * @return matchType
     */
    public java.lang.String getMatchType() {
        return matchType;
    }


    /**
     * Sets the matchType value for this BidOpportunity.
     * 
     * @param matchType
     */
    public void setMatchType(java.lang.String matchType) {
        this.matchType = matchType;
    }


    /**
     * Gets the suggestedBid value for this BidOpportunity.
     * 
     * @return suggestedBid
     */
    public java.lang.Double getSuggestedBid() {
        return suggestedBid;
    }


    /**
     * Sets the suggestedBid value for this BidOpportunity.
     * 
     * @param suggestedBid
     */
    public void setSuggestedBid(java.lang.Double suggestedBid) {
        this.suggestedBid = suggestedBid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BidOpportunity)) return false;
        BidOpportunity other = (BidOpportunity) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.adGroupId==null && other.getAdGroupId()==null) || 
             (this.adGroupId!=null &&
              this.adGroupId.equals(other.getAdGroupId()))) &&
            ((this.currentBid==null && other.getCurrentBid()==null) || 
             (this.currentBid!=null &&
              this.currentBid.equals(other.getCurrentBid()))) &&
            ((this.estimatedIncreaseInClicks==null && other.getEstimatedIncreaseInClicks()==null) || 
             (this.estimatedIncreaseInClicks!=null &&
              this.estimatedIncreaseInClicks.equals(other.getEstimatedIncreaseInClicks()))) &&
            ((this.estimatedIncreaseInCost==null && other.getEstimatedIncreaseInCost()==null) || 
             (this.estimatedIncreaseInCost!=null &&
              this.estimatedIncreaseInCost.equals(other.getEstimatedIncreaseInCost()))) &&
            ((this.estimatedIncreaseInImpressions==null && other.getEstimatedIncreaseInImpressions()==null) || 
             (this.estimatedIncreaseInImpressions!=null &&
              this.estimatedIncreaseInImpressions.equals(other.getEstimatedIncreaseInImpressions()))) &&
            ((this.keywordId==null && other.getKeywordId()==null) || 
             (this.keywordId!=null &&
              this.keywordId.equals(other.getKeywordId()))) &&
            ((this.matchType==null && other.getMatchType()==null) || 
             (this.matchType!=null &&
              this.matchType.equals(other.getMatchType()))) &&
            ((this.suggestedBid==null && other.getSuggestedBid()==null) || 
             (this.suggestedBid!=null &&
              this.suggestedBid.equals(other.getSuggestedBid())));
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
        if (getAdGroupId() != null) {
            _hashCode += getAdGroupId().hashCode();
        }
        if (getCurrentBid() != null) {
            _hashCode += getCurrentBid().hashCode();
        }
        if (getEstimatedIncreaseInClicks() != null) {
            _hashCode += getEstimatedIncreaseInClicks().hashCode();
        }
        if (getEstimatedIncreaseInCost() != null) {
            _hashCode += getEstimatedIncreaseInCost().hashCode();
        }
        if (getEstimatedIncreaseInImpressions() != null) {
            _hashCode += getEstimatedIncreaseInImpressions().hashCode();
        }
        if (getKeywordId() != null) {
            _hashCode += getKeywordId().hashCode();
        }
        if (getMatchType() != null) {
            _hashCode += getMatchType().hashCode();
        }
        if (getSuggestedBid() != null) {
            _hashCode += getSuggestedBid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BidOpportunity.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "BidOpportunity"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adGroupId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "AdGroupId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentBid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "CurrentBid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estimatedIncreaseInClicks");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "EstimatedIncreaseInClicks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estimatedIncreaseInCost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "EstimatedIncreaseInCost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estimatedIncreaseInImpressions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "EstimatedIncreaseInImpressions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keywordId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "KeywordId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matchType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "MatchType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suggestedBid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "SuggestedBid"));
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
