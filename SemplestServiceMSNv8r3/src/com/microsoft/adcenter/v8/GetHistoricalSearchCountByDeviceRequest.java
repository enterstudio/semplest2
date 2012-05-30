/**
 * GetHistoricalSearchCountByDeviceRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GetHistoricalSearchCountByDeviceRequest  implements java.io.Serializable {
    private java.lang.String[] keywords;

    private java.lang.String language;

    private java.lang.String[] publisherCountries;

    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.DayMonthAndYear startTimePeriod;

    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.DayMonthAndYear endTimePeriod;

    private java.lang.String timePeriodRollup;

    private java.lang.String[] devices;

    public GetHistoricalSearchCountByDeviceRequest() {
    }

    public GetHistoricalSearchCountByDeviceRequest(
           java.lang.String[] keywords,
           java.lang.String language,
           java.lang.String[] publisherCountries,
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.DayMonthAndYear startTimePeriod,
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.DayMonthAndYear endTimePeriod,
           java.lang.String timePeriodRollup,
           java.lang.String[] devices) {
           this.keywords = keywords;
           this.language = language;
           this.publisherCountries = publisherCountries;
           this.startTimePeriod = startTimePeriod;
           this.endTimePeriod = endTimePeriod;
           this.timePeriodRollup = timePeriodRollup;
           this.devices = devices;
    }


    /**
     * Gets the keywords value for this GetHistoricalSearchCountByDeviceRequest.
     * 
     * @return keywords
     */
    public java.lang.String[] getKeywords() {
        return keywords;
    }


    /**
     * Sets the keywords value for this GetHistoricalSearchCountByDeviceRequest.
     * 
     * @param keywords
     */
    public void setKeywords(java.lang.String[] keywords) {
        this.keywords = keywords;
    }


    /**
     * Gets the language value for this GetHistoricalSearchCountByDeviceRequest.
     * 
     * @return language
     */
    public java.lang.String getLanguage() {
        return language;
    }


    /**
     * Sets the language value for this GetHistoricalSearchCountByDeviceRequest.
     * 
     * @param language
     */
    public void setLanguage(java.lang.String language) {
        this.language = language;
    }


    /**
     * Gets the publisherCountries value for this GetHistoricalSearchCountByDeviceRequest.
     * 
     * @return publisherCountries
     */
    public java.lang.String[] getPublisherCountries() {
        return publisherCountries;
    }


    /**
     * Sets the publisherCountries value for this GetHistoricalSearchCountByDeviceRequest.
     * 
     * @param publisherCountries
     */
    public void setPublisherCountries(java.lang.String[] publisherCountries) {
        this.publisherCountries = publisherCountries;
    }


    /**
     * Gets the startTimePeriod value for this GetHistoricalSearchCountByDeviceRequest.
     * 
     * @return startTimePeriod
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.DayMonthAndYear getStartTimePeriod() {
        return startTimePeriod;
    }


    /**
     * Sets the startTimePeriod value for this GetHistoricalSearchCountByDeviceRequest.
     * 
     * @param startTimePeriod
     */
    public void setStartTimePeriod(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.DayMonthAndYear startTimePeriod) {
        this.startTimePeriod = startTimePeriod;
    }


    /**
     * Gets the endTimePeriod value for this GetHistoricalSearchCountByDeviceRequest.
     * 
     * @return endTimePeriod
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.DayMonthAndYear getEndTimePeriod() {
        return endTimePeriod;
    }


    /**
     * Sets the endTimePeriod value for this GetHistoricalSearchCountByDeviceRequest.
     * 
     * @param endTimePeriod
     */
    public void setEndTimePeriod(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.DayMonthAndYear endTimePeriod) {
        this.endTimePeriod = endTimePeriod;
    }


    /**
     * Gets the timePeriodRollup value for this GetHistoricalSearchCountByDeviceRequest.
     * 
     * @return timePeriodRollup
     */
    public java.lang.String getTimePeriodRollup() {
        return timePeriodRollup;
    }


    /**
     * Sets the timePeriodRollup value for this GetHistoricalSearchCountByDeviceRequest.
     * 
     * @param timePeriodRollup
     */
    public void setTimePeriodRollup(java.lang.String timePeriodRollup) {
        this.timePeriodRollup = timePeriodRollup;
    }


    /**
     * Gets the devices value for this GetHistoricalSearchCountByDeviceRequest.
     * 
     * @return devices
     */
    public java.lang.String[] getDevices() {
        return devices;
    }


    /**
     * Sets the devices value for this GetHistoricalSearchCountByDeviceRequest.
     * 
     * @param devices
     */
    public void setDevices(java.lang.String[] devices) {
        this.devices = devices;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetHistoricalSearchCountByDeviceRequest)) return false;
        GetHistoricalSearchCountByDeviceRequest other = (GetHistoricalSearchCountByDeviceRequest) obj;
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
            ((this.language==null && other.getLanguage()==null) || 
             (this.language!=null &&
              this.language.equals(other.getLanguage()))) &&
            ((this.publisherCountries==null && other.getPublisherCountries()==null) || 
             (this.publisherCountries!=null &&
              java.util.Arrays.equals(this.publisherCountries, other.getPublisherCountries()))) &&
            ((this.startTimePeriod==null && other.getStartTimePeriod()==null) || 
             (this.startTimePeriod!=null &&
              this.startTimePeriod.equals(other.getStartTimePeriod()))) &&
            ((this.endTimePeriod==null && other.getEndTimePeriod()==null) || 
             (this.endTimePeriod!=null &&
              this.endTimePeriod.equals(other.getEndTimePeriod()))) &&
            ((this.timePeriodRollup==null && other.getTimePeriodRollup()==null) || 
             (this.timePeriodRollup!=null &&
              this.timePeriodRollup.equals(other.getTimePeriodRollup()))) &&
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
        if (getStartTimePeriod() != null) {
            _hashCode += getStartTimePeriod().hashCode();
        }
        if (getEndTimePeriod() != null) {
            _hashCode += getEndTimePeriod().hashCode();
        }
        if (getTimePeriodRollup() != null) {
            _hashCode += getTimePeriodRollup().hashCode();
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
        new org.apache.axis.description.TypeDesc(GetHistoricalSearchCountByDeviceRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalSearchCountByDeviceRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keywords");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Keywords"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string"));
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
        elemField.setFieldName("startTimePeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "StartTimePeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "DayMonthAndYear"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endTimePeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EndTimePeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "DayMonthAndYear"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timePeriodRollup");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TimePeriodRollup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
