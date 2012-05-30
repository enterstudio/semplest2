/**
 * EditorialError.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class EditorialError  implements java.io.Serializable {
    private java.lang.Boolean appealable;

    private java.lang.Integer code;

    private java.lang.String disapprovedText;

    private java.lang.String errorCode;

    private java.lang.Integer index;

    private java.lang.String message;

    private java.lang.String publisherCountry;

    public EditorialError() {
    }

    public EditorialError(
           java.lang.Boolean appealable,
           java.lang.Integer code,
           java.lang.String disapprovedText,
           java.lang.String errorCode,
           java.lang.Integer index,
           java.lang.String message,
           java.lang.String publisherCountry) {
           this.appealable = appealable;
           this.code = code;
           this.disapprovedText = disapprovedText;
           this.errorCode = errorCode;
           this.index = index;
           this.message = message;
           this.publisherCountry = publisherCountry;
    }


    /**
     * Gets the appealable value for this EditorialError.
     * 
     * @return appealable
     */
    public java.lang.Boolean getAppealable() {
        return appealable;
    }


    /**
     * Sets the appealable value for this EditorialError.
     * 
     * @param appealable
     */
    public void setAppealable(java.lang.Boolean appealable) {
        this.appealable = appealable;
    }


    /**
     * Gets the code value for this EditorialError.
     * 
     * @return code
     */
    public java.lang.Integer getCode() {
        return code;
    }


    /**
     * Sets the code value for this EditorialError.
     * 
     * @param code
     */
    public void setCode(java.lang.Integer code) {
        this.code = code;
    }


    /**
     * Gets the disapprovedText value for this EditorialError.
     * 
     * @return disapprovedText
     */
    public java.lang.String getDisapprovedText() {
        return disapprovedText;
    }


    /**
     * Sets the disapprovedText value for this EditorialError.
     * 
     * @param disapprovedText
     */
    public void setDisapprovedText(java.lang.String disapprovedText) {
        this.disapprovedText = disapprovedText;
    }


    /**
     * Gets the errorCode value for this EditorialError.
     * 
     * @return errorCode
     */
    public java.lang.String getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this EditorialError.
     * 
     * @param errorCode
     */
    public void setErrorCode(java.lang.String errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the index value for this EditorialError.
     * 
     * @return index
     */
    public java.lang.Integer getIndex() {
        return index;
    }


    /**
     * Sets the index value for this EditorialError.
     * 
     * @param index
     */
    public void setIndex(java.lang.Integer index) {
        this.index = index;
    }


    /**
     * Gets the message value for this EditorialError.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this EditorialError.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the publisherCountry value for this EditorialError.
     * 
     * @return publisherCountry
     */
    public java.lang.String getPublisherCountry() {
        return publisherCountry;
    }


    /**
     * Sets the publisherCountry value for this EditorialError.
     * 
     * @param publisherCountry
     */
    public void setPublisherCountry(java.lang.String publisherCountry) {
        this.publisherCountry = publisherCountry;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EditorialError)) return false;
        EditorialError other = (EditorialError) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.appealable==null && other.getAppealable()==null) || 
             (this.appealable!=null &&
              this.appealable.equals(other.getAppealable()))) &&
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.disapprovedText==null && other.getDisapprovedText()==null) || 
             (this.disapprovedText!=null &&
              this.disapprovedText.equals(other.getDisapprovedText()))) &&
            ((this.errorCode==null && other.getErrorCode()==null) || 
             (this.errorCode!=null &&
              this.errorCode.equals(other.getErrorCode()))) &&
            ((this.index==null && other.getIndex()==null) || 
             (this.index!=null &&
              this.index.equals(other.getIndex()))) &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            ((this.publisherCountry==null && other.getPublisherCountry()==null) || 
             (this.publisherCountry!=null &&
              this.publisherCountry.equals(other.getPublisherCountry())));
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
        if (getAppealable() != null) {
            _hashCode += getAppealable().hashCode();
        }
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getDisapprovedText() != null) {
            _hashCode += getDisapprovedText().hashCode();
        }
        if (getErrorCode() != null) {
            _hashCode += getErrorCode().hashCode();
        }
        if (getIndex() != null) {
            _hashCode += getIndex().hashCode();
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getPublisherCountry() != null) {
            _hashCode += getPublisherCountry().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EditorialError.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialError"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("appealable");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Appealable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("disapprovedText");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DisapprovedText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ErrorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("index");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Index"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Message"));
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
