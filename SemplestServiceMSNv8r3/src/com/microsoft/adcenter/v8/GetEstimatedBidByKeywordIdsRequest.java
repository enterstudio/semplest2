/**
 * GetEstimatedBidByKeywordIdsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GetEstimatedBidByKeywordIdsRequest  implements java.io.Serializable {
    private long[] keywordIds;

    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.TargetAdPosition targetPositionForAds;

    public GetEstimatedBidByKeywordIdsRequest() {
    }

    public GetEstimatedBidByKeywordIdsRequest(
           long[] keywordIds,
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.TargetAdPosition targetPositionForAds) {
           this.keywordIds = keywordIds;
           this.targetPositionForAds = targetPositionForAds;
    }


    /**
     * Gets the keywordIds value for this GetEstimatedBidByKeywordIdsRequest.
     * 
     * @return keywordIds
     */
    public long[] getKeywordIds() {
        return keywordIds;
    }


    /**
     * Sets the keywordIds value for this GetEstimatedBidByKeywordIdsRequest.
     * 
     * @param keywordIds
     */
    public void setKeywordIds(long[] keywordIds) {
        this.keywordIds = keywordIds;
    }


    /**
     * Gets the targetPositionForAds value for this GetEstimatedBidByKeywordIdsRequest.
     * 
     * @return targetPositionForAds
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.TargetAdPosition getTargetPositionForAds() {
        return targetPositionForAds;
    }


    /**
     * Sets the targetPositionForAds value for this GetEstimatedBidByKeywordIdsRequest.
     * 
     * @param targetPositionForAds
     */
    public void setTargetPositionForAds(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.TargetAdPosition targetPositionForAds) {
        this.targetPositionForAds = targetPositionForAds;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEstimatedBidByKeywordIdsRequest)) return false;
        GetEstimatedBidByKeywordIdsRequest other = (GetEstimatedBidByKeywordIdsRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.keywordIds==null && other.getKeywordIds()==null) || 
             (this.keywordIds!=null &&
              java.util.Arrays.equals(this.keywordIds, other.getKeywordIds()))) &&
            ((this.targetPositionForAds==null && other.getTargetPositionForAds()==null) || 
             (this.targetPositionForAds!=null &&
              this.targetPositionForAds.equals(other.getTargetPositionForAds())));
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
        if (getKeywordIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKeywordIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getKeywordIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTargetPositionForAds() != null) {
            _hashCode += getTargetPositionForAds().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEstimatedBidByKeywordIdsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedBidByKeywordIdsRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keywordIds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("targetPositionForAds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TargetPositionForAds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "TargetAdPosition"));
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
