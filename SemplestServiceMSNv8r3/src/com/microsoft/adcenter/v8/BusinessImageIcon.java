/**
 * BusinessImageIcon.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class BusinessImageIcon  implements java.io.Serializable {
    private java.lang.Long customIconAssetId;

    private com.microsoft.adcenter.v8.StandardBusinessIcon standardBusinessIcon;

    public BusinessImageIcon() {
    }

    public BusinessImageIcon(
           java.lang.Long customIconAssetId,
           com.microsoft.adcenter.v8.StandardBusinessIcon standardBusinessIcon) {
           this.customIconAssetId = customIconAssetId;
           this.standardBusinessIcon = standardBusinessIcon;
    }


    /**
     * Gets the customIconAssetId value for this BusinessImageIcon.
     * 
     * @return customIconAssetId
     */
    public java.lang.Long getCustomIconAssetId() {
        return customIconAssetId;
    }


    /**
     * Sets the customIconAssetId value for this BusinessImageIcon.
     * 
     * @param customIconAssetId
     */
    public void setCustomIconAssetId(java.lang.Long customIconAssetId) {
        this.customIconAssetId = customIconAssetId;
    }


    /**
     * Gets the standardBusinessIcon value for this BusinessImageIcon.
     * 
     * @return standardBusinessIcon
     */
    public com.microsoft.adcenter.v8.StandardBusinessIcon getStandardBusinessIcon() {
        return standardBusinessIcon;
    }


    /**
     * Sets the standardBusinessIcon value for this BusinessImageIcon.
     * 
     * @param standardBusinessIcon
     */
    public void setStandardBusinessIcon(com.microsoft.adcenter.v8.StandardBusinessIcon standardBusinessIcon) {
        this.standardBusinessIcon = standardBusinessIcon;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BusinessImageIcon)) return false;
        BusinessImageIcon other = (BusinessImageIcon) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customIconAssetId==null && other.getCustomIconAssetId()==null) || 
             (this.customIconAssetId!=null &&
              this.customIconAssetId.equals(other.getCustomIconAssetId()))) &&
            ((this.standardBusinessIcon==null && other.getStandardBusinessIcon()==null) || 
             (this.standardBusinessIcon!=null &&
              this.standardBusinessIcon.equals(other.getStandardBusinessIcon())));
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
        if (getCustomIconAssetId() != null) {
            _hashCode += getCustomIconAssetId().hashCode();
        }
        if (getStandardBusinessIcon() != null) {
            _hashCode += getStandardBusinessIcon().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BusinessImageIcon.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessImageIcon"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customIconAssetId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CustomIconAssetId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("standardBusinessIcon");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "StandardBusinessIcon"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "StandardBusinessIcon"));
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
