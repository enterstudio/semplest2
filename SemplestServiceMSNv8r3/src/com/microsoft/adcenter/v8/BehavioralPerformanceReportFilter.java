/**
 * BehavioralPerformanceReportFilter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class BehavioralPerformanceReportFilter  implements java.io.Serializable {
    private java.lang.String[] adDistribution;

    private java.lang.String[] adType;

    private long[] behavioralIds;

    private java.lang.String[] deliveredMatchType;

    private java.lang.String[] languageAndRegion;

    public BehavioralPerformanceReportFilter() {
    }

    public BehavioralPerformanceReportFilter(
           java.lang.String[] adDistribution,
           java.lang.String[] adType,
           long[] behavioralIds,
           java.lang.String[] deliveredMatchType,
           java.lang.String[] languageAndRegion) {
           this.adDistribution = adDistribution;
           this.adType = adType;
           this.behavioralIds = behavioralIds;
           this.deliveredMatchType = deliveredMatchType;
           this.languageAndRegion = languageAndRegion;
    }


    /**
     * Gets the adDistribution value for this BehavioralPerformanceReportFilter.
     * 
     * @return adDistribution
     */
    public java.lang.String[] getAdDistribution() {
        return adDistribution;
    }


    /**
     * Sets the adDistribution value for this BehavioralPerformanceReportFilter.
     * 
     * @param adDistribution
     */
    public void setAdDistribution(java.lang.String[] adDistribution) {
        this.adDistribution = adDistribution;
    }


    /**
     * Gets the adType value for this BehavioralPerformanceReportFilter.
     * 
     * @return adType
     */
    public java.lang.String[] getAdType() {
        return adType;
    }


    /**
     * Sets the adType value for this BehavioralPerformanceReportFilter.
     * 
     * @param adType
     */
    public void setAdType(java.lang.String[] adType) {
        this.adType = adType;
    }


    /**
     * Gets the behavioralIds value for this BehavioralPerformanceReportFilter.
     * 
     * @return behavioralIds
     */
    public long[] getBehavioralIds() {
        return behavioralIds;
    }


    /**
     * Sets the behavioralIds value for this BehavioralPerformanceReportFilter.
     * 
     * @param behavioralIds
     */
    public void setBehavioralIds(long[] behavioralIds) {
        this.behavioralIds = behavioralIds;
    }


    /**
     * Gets the deliveredMatchType value for this BehavioralPerformanceReportFilter.
     * 
     * @return deliveredMatchType
     */
    public java.lang.String[] getDeliveredMatchType() {
        return deliveredMatchType;
    }


    /**
     * Sets the deliveredMatchType value for this BehavioralPerformanceReportFilter.
     * 
     * @param deliveredMatchType
     */
    public void setDeliveredMatchType(java.lang.String[] deliveredMatchType) {
        this.deliveredMatchType = deliveredMatchType;
    }


    /**
     * Gets the languageAndRegion value for this BehavioralPerformanceReportFilter.
     * 
     * @return languageAndRegion
     */
    public java.lang.String[] getLanguageAndRegion() {
        return languageAndRegion;
    }


    /**
     * Sets the languageAndRegion value for this BehavioralPerformanceReportFilter.
     * 
     * @param languageAndRegion
     */
    public void setLanguageAndRegion(java.lang.String[] languageAndRegion) {
        this.languageAndRegion = languageAndRegion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BehavioralPerformanceReportFilter)) return false;
        BehavioralPerformanceReportFilter other = (BehavioralPerformanceReportFilter) obj;
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
            ((this.adType==null && other.getAdType()==null) || 
             (this.adType!=null &&
              java.util.Arrays.equals(this.adType, other.getAdType()))) &&
            ((this.behavioralIds==null && other.getBehavioralIds()==null) || 
             (this.behavioralIds!=null &&
              java.util.Arrays.equals(this.behavioralIds, other.getBehavioralIds()))) &&
            ((this.deliveredMatchType==null && other.getDeliveredMatchType()==null) || 
             (this.deliveredMatchType!=null &&
              java.util.Arrays.equals(this.deliveredMatchType, other.getDeliveredMatchType()))) &&
            ((this.languageAndRegion==null && other.getLanguageAndRegion()==null) || 
             (this.languageAndRegion!=null &&
              java.util.Arrays.equals(this.languageAndRegion, other.getLanguageAndRegion())));
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
        if (getBehavioralIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBehavioralIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBehavioralIds(), i);
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BehavioralPerformanceReportFilter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BehavioralPerformanceReportFilter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adDistribution");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdDistribution"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdDistributionReportFilter"));
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
        elemField.setFieldName("behavioralIds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BehavioralIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long"));
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
