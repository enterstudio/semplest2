/**
 * SearchQueryPerformanceReportFilter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class SearchQueryPerformanceReportFilter  implements java.io.Serializable {
    private java.lang.String[] adStatus;

    private java.lang.String[] adType;

    private java.lang.String[] campaignStatus;

    private java.lang.String[] deliveredMatchType;

    private java.lang.String[] languageAndRegion;

    private java.lang.String[] languageCode;

    private java.lang.String[] searchQueries;

    public SearchQueryPerformanceReportFilter() {
    }

    public SearchQueryPerformanceReportFilter(
           java.lang.String[] adStatus,
           java.lang.String[] adType,
           java.lang.String[] campaignStatus,
           java.lang.String[] deliveredMatchType,
           java.lang.String[] languageAndRegion,
           java.lang.String[] languageCode,
           java.lang.String[] searchQueries) {
           this.adStatus = adStatus;
           this.adType = adType;
           this.campaignStatus = campaignStatus;
           this.deliveredMatchType = deliveredMatchType;
           this.languageAndRegion = languageAndRegion;
           this.languageCode = languageCode;
           this.searchQueries = searchQueries;
    }


    /**
     * Gets the adStatus value for this SearchQueryPerformanceReportFilter.
     * 
     * @return adStatus
     */
    public java.lang.String[] getAdStatus() {
        return adStatus;
    }


    /**
     * Sets the adStatus value for this SearchQueryPerformanceReportFilter.
     * 
     * @param adStatus
     */
    public void setAdStatus(java.lang.String[] adStatus) {
        this.adStatus = adStatus;
    }


    /**
     * Gets the adType value for this SearchQueryPerformanceReportFilter.
     * 
     * @return adType
     */
    public java.lang.String[] getAdType() {
        return adType;
    }


    /**
     * Sets the adType value for this SearchQueryPerformanceReportFilter.
     * 
     * @param adType
     */
    public void setAdType(java.lang.String[] adType) {
        this.adType = adType;
    }


    /**
     * Gets the campaignStatus value for this SearchQueryPerformanceReportFilter.
     * 
     * @return campaignStatus
     */
    public java.lang.String[] getCampaignStatus() {
        return campaignStatus;
    }


    /**
     * Sets the campaignStatus value for this SearchQueryPerformanceReportFilter.
     * 
     * @param campaignStatus
     */
    public void setCampaignStatus(java.lang.String[] campaignStatus) {
        this.campaignStatus = campaignStatus;
    }


    /**
     * Gets the deliveredMatchType value for this SearchQueryPerformanceReportFilter.
     * 
     * @return deliveredMatchType
     */
    public java.lang.String[] getDeliveredMatchType() {
        return deliveredMatchType;
    }


    /**
     * Sets the deliveredMatchType value for this SearchQueryPerformanceReportFilter.
     * 
     * @param deliveredMatchType
     */
    public void setDeliveredMatchType(java.lang.String[] deliveredMatchType) {
        this.deliveredMatchType = deliveredMatchType;
    }


    /**
     * Gets the languageAndRegion value for this SearchQueryPerformanceReportFilter.
     * 
     * @return languageAndRegion
     */
    public java.lang.String[] getLanguageAndRegion() {
        return languageAndRegion;
    }


    /**
     * Sets the languageAndRegion value for this SearchQueryPerformanceReportFilter.
     * 
     * @param languageAndRegion
     */
    public void setLanguageAndRegion(java.lang.String[] languageAndRegion) {
        this.languageAndRegion = languageAndRegion;
    }


    /**
     * Gets the languageCode value for this SearchQueryPerformanceReportFilter.
     * 
     * @return languageCode
     */
    public java.lang.String[] getLanguageCode() {
        return languageCode;
    }


    /**
     * Sets the languageCode value for this SearchQueryPerformanceReportFilter.
     * 
     * @param languageCode
     */
    public void setLanguageCode(java.lang.String[] languageCode) {
        this.languageCode = languageCode;
    }


    /**
     * Gets the searchQueries value for this SearchQueryPerformanceReportFilter.
     * 
     * @return searchQueries
     */
    public java.lang.String[] getSearchQueries() {
        return searchQueries;
    }


    /**
     * Sets the searchQueries value for this SearchQueryPerformanceReportFilter.
     * 
     * @param searchQueries
     */
    public void setSearchQueries(java.lang.String[] searchQueries) {
        this.searchQueries = searchQueries;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchQueryPerformanceReportFilter)) return false;
        SearchQueryPerformanceReportFilter other = (SearchQueryPerformanceReportFilter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.adStatus==null && other.getAdStatus()==null) || 
             (this.adStatus!=null &&
              java.util.Arrays.equals(this.adStatus, other.getAdStatus()))) &&
            ((this.adType==null && other.getAdType()==null) || 
             (this.adType!=null &&
              java.util.Arrays.equals(this.adType, other.getAdType()))) &&
            ((this.campaignStatus==null && other.getCampaignStatus()==null) || 
             (this.campaignStatus!=null &&
              java.util.Arrays.equals(this.campaignStatus, other.getCampaignStatus()))) &&
            ((this.deliveredMatchType==null && other.getDeliveredMatchType()==null) || 
             (this.deliveredMatchType!=null &&
              java.util.Arrays.equals(this.deliveredMatchType, other.getDeliveredMatchType()))) &&
            ((this.languageAndRegion==null && other.getLanguageAndRegion()==null) || 
             (this.languageAndRegion!=null &&
              java.util.Arrays.equals(this.languageAndRegion, other.getLanguageAndRegion()))) &&
            ((this.languageCode==null && other.getLanguageCode()==null) || 
             (this.languageCode!=null &&
              java.util.Arrays.equals(this.languageCode, other.getLanguageCode()))) &&
            ((this.searchQueries==null && other.getSearchQueries()==null) || 
             (this.searchQueries!=null &&
              java.util.Arrays.equals(this.searchQueries, other.getSearchQueries())));
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
        if (getAdStatus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAdStatus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAdStatus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAdType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAdType());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAdType(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCampaignStatus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCampaignStatus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCampaignStatus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDeliveredMatchType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDeliveredMatchType());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDeliveredMatchType(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLanguageAndRegion() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLanguageAndRegion());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLanguageAndRegion(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLanguageCode() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLanguageCode());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLanguageCode(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSearchQueries() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSearchQueries());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSearchQueries(), i);
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
        new org.apache.axis.description.TypeDesc(SearchQueryPerformanceReportFilter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SearchQueryPerformanceReportFilter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdStatusReportFilter"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdType"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdTypeReportFilter"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campaignStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignStatusReportFilter"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deliveredMatchType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeliveredMatchType"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeliveredMatchTypeReportFilter"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("languageAndRegion");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "LanguageAndRegion"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "LanguageAndRegionReportFilter"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("languageCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "LanguageCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchQueries");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SearchQueries"));
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
