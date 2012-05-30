/**
 * KeywordIdEstimatedPosition.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts;

public class KeywordIdEstimatedPosition  implements java.io.Serializable {
    private java.lang.Long keywordId;

    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordEstimatedPosition keywordEstimatedPosition;

    public KeywordIdEstimatedPosition() {
    }

    public KeywordIdEstimatedPosition(
           java.lang.Long keywordId,
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordEstimatedPosition keywordEstimatedPosition) {
           this.keywordId = keywordId;
           this.keywordEstimatedPosition = keywordEstimatedPosition;
    }


    /**
     * Gets the keywordId value for this KeywordIdEstimatedPosition.
     * 
     * @return keywordId
     */
    public java.lang.Long getKeywordId() {
        return keywordId;
    }


    /**
     * Sets the keywordId value for this KeywordIdEstimatedPosition.
     * 
     * @param keywordId
     */
    public void setKeywordId(java.lang.Long keywordId) {
        this.keywordId = keywordId;
    }


    /**
     * Gets the keywordEstimatedPosition value for this KeywordIdEstimatedPosition.
     * 
     * @return keywordEstimatedPosition
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordEstimatedPosition getKeywordEstimatedPosition() {
        return keywordEstimatedPosition;
    }


    /**
     * Sets the keywordEstimatedPosition value for this KeywordIdEstimatedPosition.
     * 
     * @param keywordEstimatedPosition
     */
    public void setKeywordEstimatedPosition(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordEstimatedPosition keywordEstimatedPosition) {
        this.keywordEstimatedPosition = keywordEstimatedPosition;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof KeywordIdEstimatedPosition)) return false;
        KeywordIdEstimatedPosition other = (KeywordIdEstimatedPosition) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.keywordId==null && other.getKeywordId()==null) || 
             (this.keywordId!=null &&
              this.keywordId.equals(other.getKeywordId()))) &&
            ((this.keywordEstimatedPosition==null && other.getKeywordEstimatedPosition()==null) || 
             (this.keywordEstimatedPosition!=null &&
              this.keywordEstimatedPosition.equals(other.getKeywordEstimatedPosition())));
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
        if (getKeywordId() != null) {
            _hashCode += getKeywordId().hashCode();
        }
        if (getKeywordEstimatedPosition() != null) {
            _hashCode += getKeywordEstimatedPosition().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(KeywordIdEstimatedPosition.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordIdEstimatedPosition"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keywordId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keywordEstimatedPosition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordEstimatedPosition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordEstimatedPosition"));
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
