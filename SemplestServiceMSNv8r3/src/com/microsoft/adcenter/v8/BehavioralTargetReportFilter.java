/**
 * BehavioralTargetReportFilter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class BehavioralTargetReportFilter  implements java.io.Serializable {
    private java.lang.String[] adDistribution;

    private long[] behavioralIds;

    private java.lang.String[] languageAndRegion;

    public BehavioralTargetReportFilter() {
    }

    public BehavioralTargetReportFilter(
           java.lang.String[] adDistribution,
           long[] behavioralIds,
           java.lang.String[] languageAndRegion) {
           this.adDistribution = adDistribution;
           this.behavioralIds = behavioralIds;
           this.languageAndRegion = languageAndRegion;
    }


    /**
     * Gets the adDistribution value for this BehavioralTargetReportFilter.
     * 
     * @return adDistribution
     */
    public java.lang.String[] getAdDistribution() {
        return adDistribution;
    }


    /**
     * Sets the adDistribution value for this BehavioralTargetReportFilter.
     * 
     * @param adDistribution
     */
    public void setAdDistribution(java.lang.String[] adDistribution) {
        this.adDistribution = adDistribution;
    }


    /**
     * Gets the behavioralIds value for this BehavioralTargetReportFilter.
     * 
     * @return behavioralIds
     */
    public long[] getBehavioralIds() {
        return behavioralIds;
    }


    /**
     * Sets the behavioralIds value for this BehavioralTargetReportFilter.
     * 
     * @param behavioralIds
     */
    public void setBehavioralIds(long[] behavioralIds) {
        this.behavioralIds = behavioralIds;
    }


    /**
     * Gets the languageAndRegion value for this BehavioralTargetReportFilter.
     * 
     * @return languageAndRegion
     */
    public java.lang.String[] getLanguageAndRegion() {
        return languageAndRegion;
    }


    /**
     * Sets the languageAndRegion value for this BehavioralTargetReportFilter.
     * 
     * @param languageAndRegion
     */
    public void setLanguageAndRegion(java.lang.String[] languageAndRegion) {
        this.languageAndRegion = languageAndRegion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BehavioralTargetReportFilter)) return false;
        BehavioralTargetReportFilter other = (BehavioralTargetReportFilter) obj;
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
            ((this.behavioralIds==null && other.getBehavioralIds()==null) || 
             (this.behavioralIds!=null &&
              java.util.Arrays.equals(this.behavioralIds, other.getBehavioralIds()))) &&
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
        new org.apache.axis.description.TypeDesc(BehavioralTargetReportFilter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BehavioralTargetReportFilter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adDistribution");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdDistribution"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdDistributionReportFilter"));
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
