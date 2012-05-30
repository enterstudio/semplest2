/**
 * PhoneExtension.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class PhoneExtension  implements java.io.Serializable {
    private java.lang.String country;

    private java.lang.Boolean enableClickToCallOnly;

    private java.lang.Boolean enablePhoneExtension;

    private java.lang.String phone;

    public PhoneExtension() {
    }

    public PhoneExtension(
           java.lang.String country,
           java.lang.Boolean enableClickToCallOnly,
           java.lang.Boolean enablePhoneExtension,
           java.lang.String phone) {
           this.country = country;
           this.enableClickToCallOnly = enableClickToCallOnly;
           this.enablePhoneExtension = enablePhoneExtension;
           this.phone = phone;
    }


    /**
     * Gets the country value for this PhoneExtension.
     * 
     * @return country
     */
    public java.lang.String getCountry() {
        return country;
    }


    /**
     * Sets the country value for this PhoneExtension.
     * 
     * @param country
     */
    public void setCountry(java.lang.String country) {
        this.country = country;
    }


    /**
     * Gets the enableClickToCallOnly value for this PhoneExtension.
     * 
     * @return enableClickToCallOnly
     */
    public java.lang.Boolean getEnableClickToCallOnly() {
        return enableClickToCallOnly;
    }


    /**
     * Sets the enableClickToCallOnly value for this PhoneExtension.
     * 
     * @param enableClickToCallOnly
     */
    public void setEnableClickToCallOnly(java.lang.Boolean enableClickToCallOnly) {
        this.enableClickToCallOnly = enableClickToCallOnly;
    }


    /**
     * Gets the enablePhoneExtension value for this PhoneExtension.
     * 
     * @return enablePhoneExtension
     */
    public java.lang.Boolean getEnablePhoneExtension() {
        return enablePhoneExtension;
    }


    /**
     * Sets the enablePhoneExtension value for this PhoneExtension.
     * 
     * @param enablePhoneExtension
     */
    public void setEnablePhoneExtension(java.lang.Boolean enablePhoneExtension) {
        this.enablePhoneExtension = enablePhoneExtension;
    }


    /**
     * Gets the phone value for this PhoneExtension.
     * 
     * @return phone
     */
    public java.lang.String getPhone() {
        return phone;
    }


    /**
     * Sets the phone value for this PhoneExtension.
     * 
     * @param phone
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PhoneExtension)) return false;
        PhoneExtension other = (PhoneExtension) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.country==null && other.getCountry()==null) || 
             (this.country!=null &&
              this.country.equals(other.getCountry()))) &&
            ((this.enableClickToCallOnly==null && other.getEnableClickToCallOnly()==null) || 
             (this.enableClickToCallOnly!=null &&
              this.enableClickToCallOnly.equals(other.getEnableClickToCallOnly()))) &&
            ((this.enablePhoneExtension==null && other.getEnablePhoneExtension()==null) || 
             (this.enablePhoneExtension!=null &&
              this.enablePhoneExtension.equals(other.getEnablePhoneExtension()))) &&
            ((this.phone==null && other.getPhone()==null) || 
             (this.phone!=null &&
              this.phone.equals(other.getPhone())));
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
        if (getCountry() != null) {
            _hashCode += getCountry().hashCode();
        }
        if (getEnableClickToCallOnly() != null) {
            _hashCode += getEnableClickToCallOnly().hashCode();
        }
        if (getEnablePhoneExtension() != null) {
            _hashCode += getEnablePhoneExtension().hashCode();
        }
        if (getPhone() != null) {
            _hashCode += getPhone().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PhoneExtension.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PhoneExtension"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("country");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Country"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enableClickToCallOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EnableClickToCallOnly"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enablePhoneExtension");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EnablePhoneExtension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phone");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Phone"));
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
