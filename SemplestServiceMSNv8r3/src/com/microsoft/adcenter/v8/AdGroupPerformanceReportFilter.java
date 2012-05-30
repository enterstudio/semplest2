/**
 * AdGroupPerformanceReportFilter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class AdGroupPerformanceReportFilter  implements java.io.Serializable {
    private java.lang.String[] adDistribution;

    private java.lang.String[] deviceType;

    private java.lang.String[] languageAndRegion;

    private java.lang.String[] languageCode;

    private java.lang.String[] status;

    public AdGroupPerformanceReportFilter() {
    }

    public AdGroupPerformanceReportFilter(
           java.lang.String[] adDistribution,
           java.lang.String[] deviceType,
           java.lang.String[] languageAndRegion,
           java.lang.String[] languageCode,
           java.lang.String[] status) {
           this.adDistribution = adDistribution;
           this.deviceType = deviceType;
           this.languageAndRegion = languageAndRegion;
           this.languageCode = languageCode;
           this.status = status;
    }


    /**
     * Gets the adDistribution value for this AdGroupPerformanceReportFilter.
     * 
     * @return adDistribution
     */
    public java.lang.String[] getAdDistribution() {
        return adDistribution;
    }


    /**
     * Sets the adDistribution value for this AdGroupPerformanceReportFilter.
     * 
     * @param adDistribution
     */
    public void setAdDistribution(java.lang.String[] adDistribution) {
        this.adDistribution = adDistribution;
    }


    /**
     * Gets the deviceType value for this AdGroupPerformanceReportFilter.
     * 
     * @return deviceType
     */
    public java.lang.String[] getDeviceType() {
        return deviceType;
    }


    /**
     * Sets the deviceType value for this AdGroupPerformanceReportFilter.
     * 
     * @param deviceType
     */
    public void setDeviceType(java.lang.String[] deviceType) {
        this.deviceType = deviceType;
    }


    /**
     * Gets the languageAndRegion value for this AdGroupPerformanceReportFilter.
     * 
     * @return languageAndRegion
     */
    public java.lang.String[] getLanguageAndRegion() {
        return languageAndRegion;
    }


    /**
     * Sets the languageAndRegion value for this AdGroupPerformanceReportFilter.
     * 
     * @param languageAndRegion
     */
    public void setLanguageAndRegion(java.lang.String[] languageAndRegion) {
        this.languageAndRegion = languageAndRegion;
    }


    /**
     * Gets the languageCode value for this AdGroupPerformanceReportFilter.
     * 
     * @return languageCode
     */
    public java.lang.String[] getLanguageCode() {
        return languageCode;
    }


    /**
     * Sets the languageCode value for this AdGroupPerformanceReportFilter.
     * 
     * @param languageCode
     */
    public void setLanguageCode(java.lang.String[] languageCode) {
        this.languageCode = languageCode;
    }


    /**
     * Gets the status value for this AdGroupPerformanceReportFilter.
     * 
     * @return status
     */
    public java.lang.String[] getStatus() {
        return status;
    }


    /**
     * Sets the status value for this AdGroupPerformanceReportFilter.
     * 
     * @param status
     */
    public void setStatus(java.lang.String[] status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AdGroupPerformanceReportFilter)) return false;
        AdGroupPerformanceReportFilter other = (AdGroupPerformanceReportFilter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.adDistribution==null && other.getAdDistribution()==null) || 
             (this.adDistribution!=null &&
              java.util.Arrays.equals(this.adDistribution, other.getAdDistribution()))) &&
            ((this.deviceType==null && other.getDeviceType()==null) || 
             (this.deviceType!=null &&
              java.util.Arrays.equals(this.deviceType, other.getDeviceType()))) &&
            ((this.languageAndRegion==null && other.getLanguageAndRegion()==null) || 
             (this.languageAndRegion!=null &&
              java.util.Arrays.equals(this.languageAndRegion, other.getLanguageAndRegion()))) &&
            ((this.languageCode==null && other.getLanguageCode()==null) || 
             (this.languageCode!=null &&
              java.util.Arrays.equals(this.languageCode, other.getLanguageCode()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              java.util.Arrays.equals(this.status, other.getStatus())));
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
        if (getAdDistribution() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAdDistribution());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAdDistribution(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDeviceType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDeviceType());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDeviceType(), i);
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
        if (getStatus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStatus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStatus(), i);
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
        new org.apache.axis.description.TypeDesc(AdGroupPerformanceReportFilter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupPerformanceReportFilter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adDistribution");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdDistribution"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdDistributionReportFilter"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deviceType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceType"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceTypeReportFilter"));
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
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupStatusReportFilter"));
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
