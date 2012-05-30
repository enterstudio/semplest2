/**
 * GetHistoricalKeywordPerformanceByDeviceRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GetHistoricalKeywordPerformanceByDeviceRequest  implements java.io.Serializable {
    private java.lang.String[] keywords;

    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.TimeInterval timeInterval;

    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AdPosition targetAdPosition;

    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType[] matchTypes;

    private java.lang.String language;

    private java.lang.String[] publisherCountries;

    private java.lang.String[] devices;

    public GetHistoricalKeywordPerformanceByDeviceRequest() {
    }

    public GetHistoricalKeywordPerformanceByDeviceRequest(
           java.lang.String[] keywords,
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.TimeInterval timeInterval,
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AdPosition targetAdPosition,
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType[] matchTypes,
           java.lang.String language,
           java.lang.String[] publisherCountries,
           java.lang.String[] devices) {
           this.keywords = keywords;
           this.timeInterval = timeInterval;
           this.targetAdPosition = targetAdPosition;
           this.matchTypes = matchTypes;
           this.language = language;
           this.publisherCountries = publisherCountries;
           this.devices = devices;
    }


    /**
     * Gets the keywords value for this GetHistoricalKeywordPerformanceByDeviceRequest.
     * 
     * @return keywords
     */
    public java.lang.String[] getKeywords() {
        return keywords;
    }


    /**
     * Sets the keywords value for this GetHistoricalKeywordPerformanceByDeviceRequest.
     * 
     * @param keywords
     */
    public void setKeywords(java.lang.String[] keywords) {
        this.keywords = keywords;
    }


    /**
     * Gets the timeInterval value for this GetHistoricalKeywordPerformanceByDeviceRequest.
     * 
     * @return timeInterval
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.TimeInterval getTimeInterval() {
        return timeInterval;
    }


    /**
     * Sets the timeInterval value for this GetHistoricalKeywordPerformanceByDeviceRequest.
     * 
     * @param timeInterval
     */
    public void setTimeInterval(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }


    /**
     * Gets the targetAdPosition value for this GetHistoricalKeywordPerformanceByDeviceRequest.
     * 
     * @return targetAdPosition
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AdPosition getTargetAdPosition() {
        return targetAdPosition;
    }


    /**
     * Sets the targetAdPosition value for this GetHistoricalKeywordPerformanceByDeviceRequest.
     * 
     * @param targetAdPosition
     */
    public void setTargetAdPosition(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AdPosition targetAdPosition) {
        this.targetAdPosition = targetAdPosition;
    }


    /**
     * Gets the matchTypes value for this GetHistoricalKeywordPerformanceByDeviceRequest.
     * 
     * @return matchTypes
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType[] getMatchTypes() {
        return matchTypes;
    }


    /**
     * Sets the matchTypes value for this GetHistoricalKeywordPerformanceByDeviceRequest.
     * 
     * @param matchTypes
     */
    public void setMatchTypes(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType[] matchTypes) {
        this.matchTypes = matchTypes;
    }


    /**
     * Gets the language value for this GetHistoricalKeywordPerformanceByDeviceRequest.
     * 
     * @return language
     */
    public java.lang.String getLanguage() {
        return language;
    }


    /**
     * Sets the language value for this GetHistoricalKeywordPerformanceByDeviceRequest.
     * 
     * @param language
     */
    public void setLanguage(java.lang.String language) {
        this.language = language;
    }


    /**
     * Gets the publisherCountries value for this GetHistoricalKeywordPerformanceByDeviceRequest.
     * 
     * @return publisherCountries
     */
    public java.lang.String[] getPublisherCountries() {
        return publisherCountries;
    }


    /**
     * Sets the publisherCountries value for this GetHistoricalKeywordPerformanceByDeviceRequest.
     * 
     * @param publisherCountries
     */
    public void setPublisherCountries(java.lang.String[] publisherCountries) {
        this.publisherCountries = publisherCountries;
    }


    /**
     * Gets the devices value for this GetHistoricalKeywordPerformanceByDeviceRequest.
     * 
     * @return devices
     */
    public java.lang.String[] getDevices() {
        return devices;
    }


    /**
     * Sets the devices value for this GetHistoricalKeywordPerformanceByDeviceRequest.
     * 
     * @param devices
     */
    public void setDevices(java.lang.String[] devices) {
        this.devices = devices;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetHistoricalKeywordPerformanceByDeviceRequest)) return false;
        GetHistoricalKeywordPerformanceByDeviceRequest other = (GetHistoricalKeywordPerformanceByDeviceRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.keywords==null && other.getKeywords()==null) || 
             (this.keywords!=null &&
              java.util.Arrays.equals(this.keywords, other.getKeywords()))) &&
            ((this.timeInterval==null && other.getTimeInterval()==null) || 
             (this.timeInterval!=null &&
              this.timeInterval.equals(other.getTimeInterval()))) &&
            ((this.targetAdPosition==null && other.getTargetAdPosition()==null) || 
             (this.targetAdPosition!=null &&
              this.targetAdPosition.equals(other.getTargetAdPosition()))) &&
            ((this.matchTypes==null && other.getMatchTypes()==null) || 
             (this.matchTypes!=null &&
              java.util.Arrays.equals(this.matchTypes, other.getMatchTypes()))) &&
            ((this.language==null && other.getLanguage()==null) || 
             (this.language!=null &&
              this.language.equals(other.getLanguage()))) &&
            ((this.publisherCountries==null && other.getPublisherCountries()==null) || 
             (this.publisherCountries!=null &&
              java.util.Arrays.equals(this.publisherCountries, other.getPublisherCountries()))) &&
            ((this.devices==null && other.getDevices()==null) || 
             (this.devices!=null &&
              java.util.Arrays.equals(this.devices, other.getDevices())));
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
        if (getKeywords() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKeywords());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getKeywords(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTimeInterval() != null) {
            _hashCode += getTimeInterval().hashCode();
        }
        if (getTargetAdPosition() != null) {
            _hashCode += getTargetAdPosition().hashCode();
        }
        if (getMatchTypes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMatchTypes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMatchTypes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLanguage() != null) {
            _hashCode += getLanguage().hashCode();
        }
        if (getPublisherCountries() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPublisherCountries());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPublisherCountries(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDevices() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDevices());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDevices(), i);
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
        new org.apache.axis.description.TypeDesc(GetHistoricalKeywordPerformanceByDeviceRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalKeywordPerformanceByDeviceRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keywords");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Keywords"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeInterval");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TimeInterval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "TimeInterval"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("targetAdPosition");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TargetAdPosition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AdPosition"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matchTypes");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MatchTypes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "MatchType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "MatchType"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("language");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Language"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publisherCountries");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PublisherCountries"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("devices");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Devices"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string"));
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
