/**
 * GetKeywordLocationsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GetKeywordLocationsRequest  implements java.io.Serializable {
    private java.lang.String[] keywords;

    private java.lang.String language;

    private java.lang.String publisherCountry;

    private java.lang.String[] device;

    private java.lang.Integer level;

    private java.lang.String parentCountry;

    private java.lang.Integer maxLocations;

    public GetKeywordLocationsRequest() {
    }

    public GetKeywordLocationsRequest(
           java.lang.String[] keywords,
           java.lang.String language,
           java.lang.String publisherCountry,
           java.lang.String[] device,
           java.lang.Integer level,
           java.lang.String parentCountry,
           java.lang.Integer maxLocations) {
           this.keywords = keywords;
           this.language = language;
           this.publisherCountry = publisherCountry;
           this.device = device;
           this.level = level;
           this.parentCountry = parentCountry;
           this.maxLocations = maxLocations;
    }


    /**
     * Gets the keywords value for this GetKeywordLocationsRequest.
     * 
     * @return keywords
     */
    public java.lang.String[] getKeywords() {
        return keywords;
    }


    /**
     * Sets the keywords value for this GetKeywordLocationsRequest.
     * 
     * @param keywords
     */
    public void setKeywords(java.lang.String[] keywords) {
        this.keywords = keywords;
    }


    /**
     * Gets the language value for this GetKeywordLocationsRequest.
     * 
     * @return language
     */
    public java.lang.String getLanguage() {
        return language;
    }


    /**
     * Sets the language value for this GetKeywordLocationsRequest.
     * 
     * @param language
     */
    public void setLanguage(java.lang.String language) {
        this.language = language;
    }


    /**
     * Gets the publisherCountry value for this GetKeywordLocationsRequest.
     * 
     * @return publisherCountry
     */
    public java.lang.String getPublisherCountry() {
        return publisherCountry;
    }


    /**
     * Sets the publisherCountry value for this GetKeywordLocationsRequest.
     * 
     * @param publisherCountry
     */
    public void setPublisherCountry(java.lang.String publisherCountry) {
        this.publisherCountry = publisherCountry;
    }


    /**
     * Gets the device value for this GetKeywordLocationsRequest.
     * 
     * @return device
     */
    public java.lang.String[] getDevice() {
        return device;
    }


    /**
     * Sets the device value for this GetKeywordLocationsRequest.
     * 
     * @param device
     */
    public void setDevice(java.lang.String[] device) {
        this.device = device;
    }


    /**
     * Gets the level value for this GetKeywordLocationsRequest.
     * 
     * @return level
     */
    public java.lang.Integer getLevel() {
        return level;
    }


    /**
     * Sets the level value for this GetKeywordLocationsRequest.
     * 
     * @param level
     */
    public void setLevel(java.lang.Integer level) {
        this.level = level;
    }


    /**
     * Gets the parentCountry value for this GetKeywordLocationsRequest.
     * 
     * @return parentCountry
     */
    public java.lang.String getParentCountry() {
        return parentCountry;
    }


    /**
     * Sets the parentCountry value for this GetKeywordLocationsRequest.
     * 
     * @param parentCountry
     */
    public void setParentCountry(java.lang.String parentCountry) {
        this.parentCountry = parentCountry;
    }


    /**
     * Gets the maxLocations value for this GetKeywordLocationsRequest.
     * 
     * @return maxLocations
     */
    public java.lang.Integer getMaxLocations() {
        return maxLocations;
    }


    /**
     * Sets the maxLocations value for this GetKeywordLocationsRequest.
     * 
     * @param maxLocations
     */
    public void setMaxLocations(java.lang.Integer maxLocations) {
        this.maxLocations = maxLocations;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetKeywordLocationsRequest)) return false;
        GetKeywordLocationsRequest other = (GetKeywordLocationsRequest) obj;
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
            ((this.publisherCountry==null && other.getPublisherCountry()==null) || 
             (this.publisherCountry!=null &&
              this.publisherCountry.equals(other.getPublisherCountry()))) &&
            ((this.device==null && other.getDevice()==null) || 
             (this.device!=null &&
              java.util.Arrays.equals(this.device, other.getDevice()))) &&
            ((this.level==null && other.getLevel()==null) || 
             (this.level!=null &&
              this.level.equals(other.getLevel()))) &&
            ((this.parentCountry==null && other.getParentCountry()==null) || 
             (this.parentCountry!=null &&
              this.parentCountry.equals(other.getParentCountry()))) &&
            ((this.maxLocations==null && other.getMaxLocations()==null) || 
             (this.maxLocations!=null &&
              this.maxLocations.equals(other.getMaxLocations())));
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
        if (getPublisherCountry() != null) {
            _hashCode += getPublisherCountry().hashCode();
        }
        if (getDevice() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDevice());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDevice(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLevel() != null) {
            _hashCode += getLevel().hashCode();
        }
        if (getParentCountry() != null) {
            _hashCode += getParentCountry().hashCode();
        }
        if (getMaxLocations() != null) {
            _hashCode += getMaxLocations().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetKeywordLocationsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordLocationsRequest"));
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
        elemField.setFieldName("publisherCountry");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PublisherCountry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("device");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Device"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("level");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Level"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentCountry");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ParentCountry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxLocations");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MaxLocations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
