/**
 * GetEstimatedBidByKeywordIdsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GetEstimatedBidByKeywordIdsResponse  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordIdEstimatedBid[] keywordEstimatedBids;

    public GetEstimatedBidByKeywordIdsResponse() {
    }

    public GetEstimatedBidByKeywordIdsResponse(
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordIdEstimatedBid[] keywordEstimatedBids) {
           this.keywordEstimatedBids = keywordEstimatedBids;
    }


    /**
     * Gets the keywordEstimatedBids value for this GetEstimatedBidByKeywordIdsResponse.
     * 
     * @return keywordEstimatedBids
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordIdEstimatedBid[] getKeywordEstimatedBids() {
        return keywordEstimatedBids;
    }


    /**
     * Sets the keywordEstimatedBids value for this GetEstimatedBidByKeywordIdsResponse.
     * 
     * @param keywordEstimatedBids
     */
    public void setKeywordEstimatedBids(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordIdEstimatedBid[] keywordEstimatedBids) {
        this.keywordEstimatedBids = keywordEstimatedBids;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEstimatedBidByKeywordIdsResponse)) return false;
        GetEstimatedBidByKeywordIdsResponse other = (GetEstimatedBidByKeywordIdsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.keywordEstimatedBids==null && other.getKeywordEstimatedBids()==null) || 
             (this.keywordEstimatedBids!=null &&
              java.util.Arrays.equals(this.keywordEstimatedBids, other.getKeywordEstimatedBids())));
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
        if (getKeywordEstimatedBids() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKeywordEstimatedBids());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getKeywordEstimatedBids(), i);
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
        new org.apache.axis.description.TypeDesc(GetEstimatedBidByKeywordIdsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedBidByKeywordIdsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keywordEstimatedBids");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordEstimatedBids"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordIdEstimatedBid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordIdEstimatedBid"));
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
