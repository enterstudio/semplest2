/**
 * SuggestKeywordsFromExistingKeywordsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class SuggestKeywordsFromExistingKeywordsRequest  implements java.io.Serializable {
    private java.lang.String[] keywords;

    private java.lang.String language;

    private java.lang.String[] publisherCountries;

    private java.lang.Integer maxSuggestionsPerKeyword;

    private java.lang.Integer suggestionType;

    public SuggestKeywordsFromExistingKeywordsRequest() {
    }

    public SuggestKeywordsFromExistingKeywordsRequest(
           java.lang.String[] keywords,
           java.lang.String language,
           java.lang.String[] publisherCountries,
           java.lang.Integer maxSuggestionsPerKeyword,
           java.lang.Integer suggestionType) {
           this.keywords = keywords;
           this.language = language;
           this.publisherCountries = publisherCountries;
           this.maxSuggestionsPerKeyword = maxSuggestionsPerKeyword;
           this.suggestionType = suggestionType;
    }


    /**
     * Gets the keywords value for this SuggestKeywordsFromExistingKeywordsRequest.
     * 
     * @return keywords
     */
    public java.lang.String[] getKeywords() {
        return keywords;
    }


    /**
     * Sets the keywords value for this SuggestKeywordsFromExistingKeywordsRequest.
     * 
     * @param keywords
     */
    public void setKeywords(java.lang.String[] keywords) {
        this.keywords = keywords;
    }


    /**
     * Gets the language value for this SuggestKeywordsFromExistingKeywordsRequest.
     * 
     * @return language
     */
    public java.lang.String getLanguage() {
        return language;
    }


    /**
     * Sets the language value for this SuggestKeywordsFromExistingKeywordsRequest.
     * 
     * @param language
     */
    public void setLanguage(java.lang.String language) {
        this.language = language;
    }


    /**
     * Gets the publisherCountries value for this SuggestKeywordsFromExistingKeywordsRequest.
     * 
     * @return publisherCountries
     */
    public java.lang.String[] getPublisherCountries() {
        return publisherCountries;
    }


    /**
     * Sets the publisherCountries value for this SuggestKeywordsFromExistingKeywordsRequest.
     * 
     * @param publisherCountries
     */
    public void setPublisherCountries(java.lang.String[] publisherCountries) {
        this.publisherCountries = publisherCountries;
    }


    /**
     * Gets the maxSuggestionsPerKeyword value for this SuggestKeywordsFromExistingKeywordsRequest.
     * 
     * @return maxSuggestionsPerKeyword
     */
    public java.lang.Integer getMaxSuggestionsPerKeyword() {
        return maxSuggestionsPerKeyword;
    }


    /**
     * Sets the maxSuggestionsPerKeyword value for this SuggestKeywordsFromExistingKeywordsRequest.
     * 
     * @param maxSuggestionsPerKeyword
     */
    public void setMaxSuggestionsPerKeyword(java.lang.Integer maxSuggestionsPerKeyword) {
        this.maxSuggestionsPerKeyword = maxSuggestionsPerKeyword;
    }


    /**
     * Gets the suggestionType value for this SuggestKeywordsFromExistingKeywordsRequest.
     * 
     * @return suggestionType
     */
    public java.lang.Integer getSuggestionType() {
        return suggestionType;
    }


    /**
     * Sets the suggestionType value for this SuggestKeywordsFromExistingKeywordsRequest.
     * 
     * @param suggestionType
     */
    public void setSuggestionType(java.lang.Integer suggestionType) {
        this.suggestionType = suggestionType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SuggestKeywordsFromExistingKeywordsRequest)) return false;
        SuggestKeywordsFromExistingKeywordsRequest other = (SuggestKeywordsFromExistingKeywordsRequest) obj;
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
            ((this.maxSuggestionsPerKeyword==null && other.getMaxSuggestionsPerKeyword()==null) || 
             (this.maxSuggestionsPerKeyword!=null &&
              this.maxSuggestionsPerKeyword.equals(other.getMaxSuggestionsPerKeyword()))) &&
            ((this.suggestionType==null && other.getSuggestionType()==null) || 
             (this.suggestionType!=null &&
              this.suggestionType.equals(other.getSuggestionType())));
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
        if (getMaxSuggestionsPerKeyword() != null) {
            _hashCode += getMaxSuggestionsPerKeyword().hashCode();
        }
        if (getSuggestionType() != null) {
            _hashCode += getSuggestionType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SuggestKeywordsFromExistingKeywordsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SuggestKeywordsFromExistingKeywordsRequest"));
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
        elemField.setFieldName("maxSuggestionsPerKeyword");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MaxSuggestionsPerKeyword"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suggestionType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SuggestionType"));
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
