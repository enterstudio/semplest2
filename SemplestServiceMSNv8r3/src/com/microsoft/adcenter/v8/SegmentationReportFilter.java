/**
 * SegmentationReportFilter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class SegmentationReportFilter  implements java.io.Serializable {
    private java.lang.String[] ageGroup;

    private java.lang.String[] country;

    private java.lang.String[] gender;

    private long[] goalIds;

    private java.lang.String[] keywords;

    public SegmentationReportFilter() {
    }

    public SegmentationReportFilter(
           java.lang.String[] ageGroup,
           java.lang.String[] country,
           java.lang.String[] gender,
           long[] goalIds,
           java.lang.String[] keywords) {
           this.ageGroup = ageGroup;
           this.country = country;
           this.gender = gender;
           this.goalIds = goalIds;
           this.keywords = keywords;
    }


    /**
     * Gets the ageGroup value for this SegmentationReportFilter.
     * 
     * @return ageGroup
     */
    public java.lang.String[] getAgeGroup() {
        return ageGroup;
    }


    /**
     * Sets the ageGroup value for this SegmentationReportFilter.
     * 
     * @param ageGroup
     */
    public void setAgeGroup(java.lang.String[] ageGroup) {
        this.ageGroup = ageGroup;
    }


    /**
     * Gets the country value for this SegmentationReportFilter.
     * 
     * @return country
     */
    public java.lang.String[] getCountry() {
        return country;
    }


    /**
     * Sets the country value for this SegmentationReportFilter.
     * 
     * @param country
     */
    public void setCountry(java.lang.String[] country) {
        this.country = country;
    }


    /**
     * Gets the gender value for this SegmentationReportFilter.
     * 
     * @return gender
     */
    public java.lang.String[] getGender() {
        return gender;
    }


    /**
     * Sets the gender value for this SegmentationReportFilter.
     * 
     * @param gender
     */
    public void setGender(java.lang.String[] gender) {
        this.gender = gender;
    }


    /**
     * Gets the goalIds value for this SegmentationReportFilter.
     * 
     * @return goalIds
     */
    public long[] getGoalIds() {
        return goalIds;
    }


    /**
     * Sets the goalIds value for this SegmentationReportFilter.
     * 
     * @param goalIds
     */
    public void setGoalIds(long[] goalIds) {
        this.goalIds = goalIds;
    }


    /**
     * Gets the keywords value for this SegmentationReportFilter.
     * 
     * @return keywords
     */
    public java.lang.String[] getKeywords() {
        return keywords;
    }


    /**
     * Sets the keywords value for this SegmentationReportFilter.
     * 
     * @param keywords
     */
    public void setKeywords(java.lang.String[] keywords) {
        this.keywords = keywords;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SegmentationReportFilter)) return false;
        SegmentationReportFilter other = (SegmentationReportFilter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ageGroup==null && other.getAgeGroup()==null) || 
             (this.ageGroup!=null &&
              java.util.Arrays.equals(this.ageGroup, other.getAgeGroup()))) &&
            ((this.country==null && other.getCountry()==null) || 
             (this.country!=null &&
              java.util.Arrays.equals(this.country, other.getCountry()))) &&
            ((this.gender==null && other.getGender()==null) || 
             (this.gender!=null &&
              java.util.Arrays.equals(this.gender, other.getGender()))) &&
            ((this.goalIds==null && other.getGoalIds()==null) || 
             (this.goalIds!=null &&
              java.util.Arrays.equals(this.goalIds, other.getGoalIds()))) &&
            ((this.keywords==null && other.getKeywords()==null) || 
             (this.keywords!=null &&
              java.util.Arrays.equals(this.keywords, other.getKeywords())));
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
        if (getAgeGroup() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAgeGroup());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAgeGroup(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCountry() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCountry());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCountry(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGender() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGender());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGender(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGoalIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGoalIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGoalIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SegmentationReportFilter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SegmentationReportFilter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ageGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeGroupReportFilter"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("country");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Country"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CountryReportFilter"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gender");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Gender"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GenderReportFilter"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("goalIds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GoalIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keywords");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Keywords"));
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
