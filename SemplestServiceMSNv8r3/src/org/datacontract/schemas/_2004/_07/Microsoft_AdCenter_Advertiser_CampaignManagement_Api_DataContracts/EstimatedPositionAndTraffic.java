/**
 * EstimatedPositionAndTraffic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts;

public class EstimatedPositionAndTraffic  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType matchType;

    private java.lang.Integer minClicksPerWeek;

    private java.lang.Integer maxClicksPerWeek;

    private java.lang.Double averageCPC;

    private java.lang.Integer minImpressionsPerWeek;

    private java.lang.Integer maxImpressionsPerWeek;

    private java.lang.Double CTR;

    private java.lang.Double minTotalCostPerWeek;

    private java.lang.Double maxTotalCostPerWeek;

    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.Currency currency;

    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AdPosition estimatedAdPosition;

    public EstimatedPositionAndTraffic() {
    }

    public EstimatedPositionAndTraffic(
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType matchType,
           java.lang.Integer minClicksPerWeek,
           java.lang.Integer maxClicksPerWeek,
           java.lang.Double averageCPC,
           java.lang.Integer minImpressionsPerWeek,
           java.lang.Integer maxImpressionsPerWeek,
           java.lang.Double CTR,
           java.lang.Double minTotalCostPerWeek,
           java.lang.Double maxTotalCostPerWeek,
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.Currency currency,
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AdPosition estimatedAdPosition) {
           this.matchType = matchType;
           this.minClicksPerWeek = minClicksPerWeek;
           this.maxClicksPerWeek = maxClicksPerWeek;
           this.averageCPC = averageCPC;
           this.minImpressionsPerWeek = minImpressionsPerWeek;
           this.maxImpressionsPerWeek = maxImpressionsPerWeek;
           this.CTR = CTR;
           this.minTotalCostPerWeek = minTotalCostPerWeek;
           this.maxTotalCostPerWeek = maxTotalCostPerWeek;
           this.currency = currency;
           this.estimatedAdPosition = estimatedAdPosition;
    }


    /**
     * Gets the matchType value for this EstimatedPositionAndTraffic.
     * 
     * @return matchType
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType getMatchType() {
        return matchType;
    }


    /**
     * Sets the matchType value for this EstimatedPositionAndTraffic.
     * 
     * @param matchType
     */
    public void setMatchType(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType matchType) {
        this.matchType = matchType;
    }


    /**
     * Gets the minClicksPerWeek value for this EstimatedPositionAndTraffic.
     * 
     * @return minClicksPerWeek
     */
    public java.lang.Integer getMinClicksPerWeek() {
        return minClicksPerWeek;
    }


    /**
     * Sets the minClicksPerWeek value for this EstimatedPositionAndTraffic.
     * 
     * @param minClicksPerWeek
     */
    public void setMinClicksPerWeek(java.lang.Integer minClicksPerWeek) {
        this.minClicksPerWeek = minClicksPerWeek;
    }


    /**
     * Gets the maxClicksPerWeek value for this EstimatedPositionAndTraffic.
     * 
     * @return maxClicksPerWeek
     */
    public java.lang.Integer getMaxClicksPerWeek() {
        return maxClicksPerWeek;
    }


    /**
     * Sets the maxClicksPerWeek value for this EstimatedPositionAndTraffic.
     * 
     * @param maxClicksPerWeek
     */
    public void setMaxClicksPerWeek(java.lang.Integer maxClicksPerWeek) {
        this.maxClicksPerWeek = maxClicksPerWeek;
    }


    /**
     * Gets the averageCPC value for this EstimatedPositionAndTraffic.
     * 
     * @return averageCPC
     */
    public java.lang.Double getAverageCPC() {
        return averageCPC;
    }


    /**
     * Sets the averageCPC value for this EstimatedPositionAndTraffic.
     * 
     * @param averageCPC
     */
    public void setAverageCPC(java.lang.Double averageCPC) {
        this.averageCPC = averageCPC;
    }


    /**
     * Gets the minImpressionsPerWeek value for this EstimatedPositionAndTraffic.
     * 
     * @return minImpressionsPerWeek
     */
    public java.lang.Integer getMinImpressionsPerWeek() {
        return minImpressionsPerWeek;
    }


    /**
     * Sets the minImpressionsPerWeek value for this EstimatedPositionAndTraffic.
     * 
     * @param minImpressionsPerWeek
     */
    public void setMinImpressionsPerWeek(java.lang.Integer minImpressionsPerWeek) {
        this.minImpressionsPerWeek = minImpressionsPerWeek;
    }


    /**
     * Gets the maxImpressionsPerWeek value for this EstimatedPositionAndTraffic.
     * 
     * @return maxImpressionsPerWeek
     */
    public java.lang.Integer getMaxImpressionsPerWeek() {
        return maxImpressionsPerWeek;
    }


    /**
     * Sets the maxImpressionsPerWeek value for this EstimatedPositionAndTraffic.
     * 
     * @param maxImpressionsPerWeek
     */
    public void setMaxImpressionsPerWeek(java.lang.Integer maxImpressionsPerWeek) {
        this.maxImpressionsPerWeek = maxImpressionsPerWeek;
    }


    /**
     * Gets the CTR value for this EstimatedPositionAndTraffic.
     * 
     * @return CTR
     */
    public java.lang.Double getCTR() {
        return CTR;
    }


    /**
     * Sets the CTR value for this EstimatedPositionAndTraffic.
     * 
     * @param CTR
     */
    public void setCTR(java.lang.Double CTR) {
        this.CTR = CTR;
    }


    /**
     * Gets the minTotalCostPerWeek value for this EstimatedPositionAndTraffic.
     * 
     * @return minTotalCostPerWeek
     */
    public java.lang.Double getMinTotalCostPerWeek() {
        return minTotalCostPerWeek;
    }


    /**
     * Sets the minTotalCostPerWeek value for this EstimatedPositionAndTraffic.
     * 
     * @param minTotalCostPerWeek
     */
    public void setMinTotalCostPerWeek(java.lang.Double minTotalCostPerWeek) {
        this.minTotalCostPerWeek = minTotalCostPerWeek;
    }


    /**
     * Gets the maxTotalCostPerWeek value for this EstimatedPositionAndTraffic.
     * 
     * @return maxTotalCostPerWeek
     */
    public java.lang.Double getMaxTotalCostPerWeek() {
        return maxTotalCostPerWeek;
    }


    /**
     * Sets the maxTotalCostPerWeek value for this EstimatedPositionAndTraffic.
     * 
     * @param maxTotalCostPerWeek
     */
    public void setMaxTotalCostPerWeek(java.lang.Double maxTotalCostPerWeek) {
        this.maxTotalCostPerWeek = maxTotalCostPerWeek;
    }


    /**
     * Gets the currency value for this EstimatedPositionAndTraffic.
     * 
     * @return currency
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.Currency getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this EstimatedPositionAndTraffic.
     * 
     * @param currency
     */
    public void setCurrency(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.Currency currency) {
        this.currency = currency;
    }


    /**
     * Gets the estimatedAdPosition value for this EstimatedPositionAndTraffic.
     * 
     * @return estimatedAdPosition
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AdPosition getEstimatedAdPosition() {
        return estimatedAdPosition;
    }


    /**
     * Sets the estimatedAdPosition value for this EstimatedPositionAndTraffic.
     * 
     * @param estimatedAdPosition
     */
    public void setEstimatedAdPosition(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AdPosition estimatedAdPosition) {
        this.estimatedAdPosition = estimatedAdPosition;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EstimatedPositionAndTraffic)) return false;
        EstimatedPositionAndTraffic other = (EstimatedPositionAndTraffic) obj;
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
            ((this.minClicksPerWeek==null && other.getMinClicksPerWeek()==null) || 
             (this.minClicksPerWeek!=null &&
              this.minClicksPerWeek.equals(other.getMinClicksPerWeek()))) &&
            ((this.maxClicksPerWeek==null && other.getMaxClicksPerWeek()==null) || 
             (this.maxClicksPerWeek!=null &&
              this.maxClicksPerWeek.equals(other.getMaxClicksPerWeek()))) &&
            ((this.averageCPC==null && other.getAverageCPC()==null) || 
             (this.averageCPC!=null &&
              this.averageCPC.equals(other.getAverageCPC()))) &&
            ((this.minImpressionsPerWeek==null && other.getMinImpressionsPerWeek()==null) || 
             (this.minImpressionsPerWeek!=null &&
              this.minImpressionsPerWeek.equals(other.getMinImpressionsPerWeek()))) &&
            ((this.maxImpressionsPerWeek==null && other.getMaxImpressionsPerWeek()==null) || 
             (this.maxImpressionsPerWeek!=null &&
              this.maxImpressionsPerWeek.equals(other.getMaxImpressionsPerWeek()))) &&
            ((this.CTR==null && other.getCTR()==null) || 
             (this.CTR!=null &&
              this.CTR.equals(other.getCTR()))) &&
            ((this.minTotalCostPerWeek==null && other.getMinTotalCostPerWeek()==null) || 
             (this.minTotalCostPerWeek!=null &&
              this.minTotalCostPerWeek.equals(other.getMinTotalCostPerWeek()))) &&
            ((this.maxTotalCostPerWeek==null && other.getMaxTotalCostPerWeek()==null) || 
             (this.maxTotalCostPerWeek!=null &&
              this.maxTotalCostPerWeek.equals(other.getMaxTotalCostPerWeek()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.estimatedAdPosition==null && other.getEstimatedAdPosition()==null) || 
             (this.estimatedAdPosition!=null &&
              this.estimatedAdPosition.equals(other.getEstimatedAdPosition())));
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
        if (getMinClicksPerWeek() != null) {
            _hashCode += getMinClicksPerWeek().hashCode();
        }
        if (getMaxClicksPerWeek() != null) {
            _hashCode += getMaxClicksPerWeek().hashCode();
        }
        if (getAverageCPC() != null) {
            _hashCode += getAverageCPC().hashCode();
        }
        if (getMinImpressionsPerWeek() != null) {
            _hashCode += getMinImpressionsPerWeek().hashCode();
        }
        if (getMaxImpressionsPerWeek() != null) {
            _hashCode += getMaxImpressionsPerWeek().hashCode();
        }
        if (getCTR() != null) {
            _hashCode += getCTR().hashCode();
        }
        if (getMinTotalCostPerWeek() != null) {
            _hashCode += getMinTotalCostPerWeek().hashCode();
        }
        if (getMaxTotalCostPerWeek() != null) {
            _hashCode += getMaxTotalCostPerWeek().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getEstimatedAdPosition() != null) {
            _hashCode += getEstimatedAdPosition().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EstimatedPositionAndTraffic.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "EstimatedPositionAndTraffic"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matchType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "MatchType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "MatchType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minClicksPerWeek");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "MinClicksPerWeek"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxClicksPerWeek");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "MaxClicksPerWeek"));
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
        elemField.setFieldName("minImpressionsPerWeek");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "MinImpressionsPerWeek"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxImpressionsPerWeek");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "MaxImpressionsPerWeek"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("minTotalCostPerWeek");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "MinTotalCostPerWeek"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxTotalCostPerWeek");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "MaxTotalCostPerWeek"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Currency"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estimatedAdPosition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "EstimatedAdPosition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AdPosition"));
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
