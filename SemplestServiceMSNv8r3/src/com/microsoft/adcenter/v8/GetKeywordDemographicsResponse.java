/**
 * GetKeywordDemographicsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GetKeywordDemographicsResponse  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordDemographicResult[] keywordDemographicResult;

    public GetKeywordDemographicsResponse() {
    }

    public GetKeywordDemographicsResponse(
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordDemographicResult[] keywordDemographicResult) {
           this.keywordDemographicResult = keywordDemographicResult;
    }


    /**
     * Gets the keywordDemographicResult value for this GetKeywordDemographicsResponse.
     * 
     * @return keywordDemographicResult
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordDemographicResult[] getKeywordDemographicResult() {
        return keywordDemographicResult;
    }


    /**
     * Sets the keywordDemographicResult value for this GetKeywordDemographicsResponse.
     * 
     * @param keywordDemographicResult
     */
    public void setKeywordDemographicResult(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordDemographicResult[] keywordDemographicResult) {
        this.keywordDemographicResult = keywordDemographicResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetKeywordDemographicsResponse)) return false;
        GetKeywordDemographicsResponse other = (GetKeywordDemographicsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.keywordDemographicResult==null && other.getKeywordDemographicResult()==null) || 
             (this.keywordDemographicResult!=null &&
              java.util.Arrays.equals(this.keywordDemographicResult, other.getKeywordDemographicResult())));
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
        if (getKeywordDemographicResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKeywordDemographicResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getKeywordDemographicResult(), i);
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
        new org.apache.axis.description.TypeDesc(GetKeywordDemographicsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordDemographicsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keywordDemographicResult");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordDemographicResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordDemographicResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordDemographicResult"));
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
