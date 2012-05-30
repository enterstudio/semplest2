/**
 * KeywordKPI.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts;

public class KeywordKPI  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType matchType;

    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AdPosition adPosition;

    private java.lang.Integer clicks;

    private java.lang.Integer impressions;

    private java.lang.Double averageCPC;

    private java.lang.Double CTR;

    private java.lang.Double totalCost;

    private java.lang.Double averageBid;

    public KeywordKPI() {
    }

    public KeywordKPI(
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType matchType,
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AdPosition adPosition,
           java.lang.Integer clicks,
           java.lang.Integer impressions,
           java.lang.Double averageCPC,
           java.lang.Double CTR,
           java.lang.Double totalCost,
           java.lang.Double averageBid) {
           this.matchType = matchType;
           this.adPosition = adPosition;
           this.clicks = clicks;
           this.impressions = impressions;
           this.averageCPC = averageCPC;
           this.CTR = CTR;
           this.totalCost = totalCost;
           this.averageBid = averageBid;
    }


    /**
     * Gets the matchType value for this KeywordKPI.
     * 
     * @return matchType
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType getMatchType() {
        return matchType;
    }


    /**
     * Sets the matchType value for this KeywordKPI.
     * 
     * @param matchType
     */
    public void setMatchType(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType matchType) {
        this.matchType = matchType;
    }


    /**
     * Gets the adPosition value for this KeywordKPI.
     * 
     * @return adPosition
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AdPosition getAdPosition() {
        return adPosition;
    }


    /**
     * Sets the adPosition value for this KeywordKPI.
     * 
     * @param adPosition
     */
    public void setAdPosition(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AdPosition adPosition) {
        this.adPosition = adPosition;
    }


    /**
     * Gets the clicks value for this KeywordKPI.
     * 
     * @return clicks
     */
    public java.lang.Integer getClicks() {
        return clicks;
    }


    /**
     * Sets the clicks value for this KeywordKPI.
     * 
     * @param clicks
     */
    public void setClicks(java.lang.Integer clicks) {
        this.clicks = clicks;
    }


    /**
     * Gets the impressions value for this KeywordKPI.
     * 
     * @return impressions
     */
    public java.lang.Integer getImpressions() {
        return impressions;
    }


    /**
     * Sets the impressions value for this KeywordKPI.
     * 
     * @param impressions
     */
    public void setImpressions(java.lang.Integer impressions) {
        this.impressions = impressions;
    }


    /**
     * Gets the averageCPC value for this KeywordKPI.
     * 
     * @return averageCPC
     */
    public java.lang.Double getAverageCPC() {
        return averageCPC;
    }


    /**
     * Sets the averageCPC value for this KeywordKPI.
     * 
     * @param averageCPC
     */
    public void setAverageCPC(java.lang.Double averageCPC) {
        this.averageCPC = averageCPC;
    }


    /**
     * Gets the CTR value for this KeywordKPI.
     * 
     * @return CTR
     */
    public java.lang.Double getCTR() {
        return CTR;
    }


    /**
     * Sets the CTR value for this KeywordKPI.
     * 
     * @param CTR
     */
    public void setCTR(java.lang.Double CTR) {
        this.CTR = CTR;
    }


    /**
     * Gets the totalCost value for this KeywordKPI.
     * 
     * @return totalCost
     */
    public java.lang.Double getTotalCost() {
        return totalCost;
    }


    /**
     * Sets the totalCost value for this KeywordKPI.
     * 
     * @param totalCost
     */
    public void setTotalCost(java.lang.Double totalCost) {
        this.totalCost = totalCost;
    }


    /**
     * Gets the averageBid value for this KeywordKPI.
     * 
     * @return averageBid
     */
    public java.lang.Double getAverageBid() {
        return averageBid;
    }


    /**
     * Sets the averageBid value for this KeywordKPI.
     * 
     * @param averageBid
     */
    public void setAverageBid(java.lang.Double averageBid) {
        this.averageBid = averageBid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof KeywordKPI)) return false;
        KeywordKPI other = (KeywordKPI) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.matchType==null && other.getMatchType()==null) || 
             (this.matchType!=null &&
              this.matchType.equals(other.getMatchType()))) &&
            ((this.adPosition==null && other.getAdPosition()==null) || 
             (this.adPosition!=null &&
              this.adPosition.equals(other.getAdPosition()))) &&
            ((this.clicks==null && other.getClicks()==null) || 
             (this.clicks!=null &&
              this.clicks.equals(other.getClicks()))) &&
            ((this.impressions==null && other.getImpressions()==null) || 
             (this.impressions!=null &&
              this.impressions.equals(other.getImpressions()))) &&
            ((this.averageCPC==null && other.getAverageCPC()==null) || 
             (this.averageCPC!=null &&
              this.averageCPC.equals(other.getAverageCPC()))) &&
            ((this.CTR==null && other.getCTR()==null) || 
             (this.CTR!=null &&
              this.CTR.equals(other.getCTR()))) &&
            ((this.totalCost==null && other.getTotalCost()==null) || 
             (this.totalCost!=null &&
              this.totalCost.equals(other.getTotalCost()))) &&
            ((this.averageBid==null && other.getAverageBid()==null) || 
             (this.averageBid!=null &&
              this.averageBid.equals(other.getAverageBid())));
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
        if (getMatchType() != null) {
            _hashCode += getMatchType().hashCode();
        }
        if (getAdPosition() != null) {
            _hashCode += getAdPosition().hashCode();
        }
        if (getClicks() != null) {
            _hashCode += getClicks().hashCode();
        }
        if (getImpressions() != null) {
            _hashCode += getImpressions().hashCode();
        }
        if (getAverageCPC() != null) {
            _hashCode += getAverageCPC().hashCode();
        }
        if (getCTR() != null) {
            _hashCode += getCTR().hashCode();
        }
        if (getTotalCost() != null) {
            _hashCode += getTotalCost().hashCode();
        }
        if (getAverageBid() != null) {
            _hashCode += getAverageBid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(KeywordKPI.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordKPI"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matchType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "MatchType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "MatchType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adPosition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AdPosition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AdPosition"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clicks");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Clicks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impressions");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Impressions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("averageCPC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AverageCPC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CTR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "CTR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalCost");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "TotalCost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("averageBid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AverageBid"));
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
