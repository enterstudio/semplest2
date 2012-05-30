/**
 * Keyword.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class Keyword  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.Bid broadMatchBid;

    private com.microsoft.adcenter.v8.Bid contentMatchBid;

    private com.microsoft.adcenter.v8.KeywordEditorialStatus editorialStatus;

    private com.microsoft.adcenter.v8.Bid exactMatchBid;

    private java.lang.Long id;

    private java.lang.String[] negativeKeywords;

    private java.lang.String param1;

    private java.lang.String param2;

    private java.lang.String param3;

    private com.microsoft.adcenter.v8.Bid phraseMatchBid;

    private com.microsoft.adcenter.v8.KeywordStatus status;

    private java.lang.String text;

    public Keyword() {
    }

    public Keyword(
           com.microsoft.adcenter.v8.Bid broadMatchBid,
           com.microsoft.adcenter.v8.Bid contentMatchBid,
           com.microsoft.adcenter.v8.KeywordEditorialStatus editorialStatus,
           com.microsoft.adcenter.v8.Bid exactMatchBid,
           java.lang.Long id,
           java.lang.String[] negativeKeywords,
           java.lang.String param1,
           java.lang.String param2,
           java.lang.String param3,
           com.microsoft.adcenter.v8.Bid phraseMatchBid,
           com.microsoft.adcenter.v8.KeywordStatus status,
           java.lang.String text) {
           this.broadMatchBid = broadMatchBid;
           this.contentMatchBid = contentMatchBid;
           this.editorialStatus = editorialStatus;
           this.exactMatchBid = exactMatchBid;
           this.id = id;
           this.negativeKeywords = negativeKeywords;
           this.param1 = param1;
           this.param2 = param2;
           this.param3 = param3;
           this.phraseMatchBid = phraseMatchBid;
           this.status = status;
           this.text = text;
    }


    /**
     * Gets the broadMatchBid value for this Keyword.
     * 
     * @return broadMatchBid
     */
    public com.microsoft.adcenter.v8.Bid getBroadMatchBid() {
        return broadMatchBid;
    }


    /**
     * Sets the broadMatchBid value for this Keyword.
     * 
     * @param broadMatchBid
     */
    public void setBroadMatchBid(com.microsoft.adcenter.v8.Bid broadMatchBid) {
        this.broadMatchBid = broadMatchBid;
    }


    /**
     * Gets the contentMatchBid value for this Keyword.
     * 
     * @return contentMatchBid
     */
    public com.microsoft.adcenter.v8.Bid getContentMatchBid() {
        return contentMatchBid;
    }


    /**
     * Sets the contentMatchBid value for this Keyword.
     * 
     * @param contentMatchBid
     */
    public void setContentMatchBid(com.microsoft.adcenter.v8.Bid contentMatchBid) {
        this.contentMatchBid = contentMatchBid;
    }


    /**
     * Gets the editorialStatus value for this Keyword.
     * 
     * @return editorialStatus
     */
    public com.microsoft.adcenter.v8.KeywordEditorialStatus getEditorialStatus() {
        return editorialStatus;
    }


    /**
     * Sets the editorialStatus value for this Keyword.
     * 
     * @param editorialStatus
     */
    public void setEditorialStatus(com.microsoft.adcenter.v8.KeywordEditorialStatus editorialStatus) {
        this.editorialStatus = editorialStatus;
    }


    /**
     * Gets the exactMatchBid value for this Keyword.
     * 
     * @return exactMatchBid
     */
    public com.microsoft.adcenter.v8.Bid getExactMatchBid() {
        return exactMatchBid;
    }


    /**
     * Sets the exactMatchBid value for this Keyword.
     * 
     * @param exactMatchBid
     */
    public void setExactMatchBid(com.microsoft.adcenter.v8.Bid exactMatchBid) {
        this.exactMatchBid = exactMatchBid;
    }


    /**
     * Gets the id value for this Keyword.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this Keyword.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the negativeKeywords value for this Keyword.
     * 
     * @return negativeKeywords
     */
    public java.lang.String[] getNegativeKeywords() {
        return negativeKeywords;
    }


    /**
     * Sets the negativeKeywords value for this Keyword.
     * 
     * @param negativeKeywords
     */
    public void setNegativeKeywords(java.lang.String[] negativeKeywords) {
        this.negativeKeywords = negativeKeywords;
    }


    /**
     * Gets the param1 value for this Keyword.
     * 
     * @return param1
     */
    public java.lang.String getParam1() {
        return param1;
    }


    /**
     * Sets the param1 value for this Keyword.
     * 
     * @param param1
     */
    public void setParam1(java.lang.String param1) {
        this.param1 = param1;
    }


    /**
     * Gets the param2 value for this Keyword.
     * 
     * @return param2
     */
    public java.lang.String getParam2() {
        return param2;
    }


    /**
     * Sets the param2 value for this Keyword.
     * 
     * @param param2
     */
    public void setParam2(java.lang.String param2) {
        this.param2 = param2;
    }


    /**
     * Gets the param3 value for this Keyword.
     * 
     * @return param3
     */
    public java.lang.String getParam3() {
        return param3;
    }


    /**
     * Sets the param3 value for this Keyword.
     * 
     * @param param3
     */
    public void setParam3(java.lang.String param3) {
        this.param3 = param3;
    }


    /**
     * Gets the phraseMatchBid value for this Keyword.
     * 
     * @return phraseMatchBid
     */
    public com.microsoft.adcenter.v8.Bid getPhraseMatchBid() {
        return phraseMatchBid;
    }


    /**
     * Sets the phraseMatchBid value for this Keyword.
     * 
     * @param phraseMatchBid
     */
    public void setPhraseMatchBid(com.microsoft.adcenter.v8.Bid phraseMatchBid) {
        this.phraseMatchBid = phraseMatchBid;
    }


    /**
     * Gets the status value for this Keyword.
     * 
     * @return status
     */
    public com.microsoft.adcenter.v8.KeywordStatus getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Keyword.
     * 
     * @param status
     */
    public void setStatus(com.microsoft.adcenter.v8.KeywordStatus status) {
        this.status = status;
    }


    /**
     * Gets the text value for this Keyword.
     * 
     * @return text
     */
    public java.lang.String getText() {
        return text;
    }


    /**
     * Sets the text value for this Keyword.
     * 
     * @param text
     */
    public void setText(java.lang.String text) {
        this.text = text;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Keyword)) return false;
        Keyword other = (Keyword) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.broadMatchBid==null && other.getBroadMatchBid()==null) || 
             (this.broadMatchBid!=null &&
              this.broadMatchBid.equals(other.getBroadMatchBid()))) &&
            ((this.contentMatchBid==null && other.getContentMatchBid()==null) || 
             (this.contentMatchBid!=null &&
              this.contentMatchBid.equals(other.getContentMatchBid()))) &&
            ((this.editorialStatus==null && other.getEditorialStatus()==null) || 
             (this.editorialStatus!=null &&
              this.editorialStatus.equals(other.getEditorialStatus()))) &&
            ((this.exactMatchBid==null && other.getExactMatchBid()==null) || 
             (this.exactMatchBid!=null &&
              this.exactMatchBid.equals(other.getExactMatchBid()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.negativeKeywords==null && other.getNegativeKeywords()==null) || 
             (this.negativeKeywords!=null &&
              java.util.Arrays.equals(this.negativeKeywords, other.getNegativeKeywords()))) &&
            ((this.param1==null && other.getParam1()==null) || 
             (this.param1!=null &&
              this.param1.equals(other.getParam1()))) &&
            ((this.param2==null && other.getParam2()==null) || 
             (this.param2!=null &&
              this.param2.equals(other.getParam2()))) &&
            ((this.param3==null && other.getParam3()==null) || 
             (this.param3!=null &&
              this.param3.equals(other.getParam3()))) &&
            ((this.phraseMatchBid==null && other.getPhraseMatchBid()==null) || 
             (this.phraseMatchBid!=null &&
              this.phraseMatchBid.equals(other.getPhraseMatchBid()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.text==null && other.getText()==null) || 
             (this.text!=null &&
              this.text.equals(other.getText())));
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
        if (getBroadMatchBid() != null) {
            _hashCode += getBroadMatchBid().hashCode();
        }
        if (getContentMatchBid() != null) {
            _hashCode += getContentMatchBid().hashCode();
        }
        if (getEditorialStatus() != null) {
            _hashCode += getEditorialStatus().hashCode();
        }
        if (getExactMatchBid() != null) {
            _hashCode += getExactMatchBid().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getNegativeKeywords() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNegativeKeywords());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNegativeKeywords(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getParam1() != null) {
            _hashCode += getParam1().hashCode();
        }
        if (getParam2() != null) {
            _hashCode += getParam2().hashCode();
        }
        if (getParam3() != null) {
            _hashCode += getParam3().hashCode();
        }
        if (getPhraseMatchBid() != null) {
            _hashCode += getPhraseMatchBid().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getText() != null) {
            _hashCode += getText().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Keyword.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Keyword"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("broadMatchBid");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BroadMatchBid"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Bid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contentMatchBid");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ContentMatchBid"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Bid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editorialStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordEditorialStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exactMatchBid");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ExactMatchBid"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Bid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("negativeKeywords");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "NegativeKeywords"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("param1");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Param1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("param2");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Param2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("param3");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Param3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phraseMatchBid");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PhraseMatchBid"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Bid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("text");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Text"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
