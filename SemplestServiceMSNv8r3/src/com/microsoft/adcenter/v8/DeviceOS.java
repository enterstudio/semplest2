/**
 * DeviceOS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class DeviceOS  implements java.io.Serializable {
    private java.lang.String deviceName;

    private java.lang.String OSName;

    public DeviceOS() {
    }

    public DeviceOS(
           java.lang.String deviceName,
           java.lang.String OSName) {
           this.deviceName = deviceName;
           this.OSName = OSName;
    }


    /**
     * Gets the deviceName value for this DeviceOS.
     * 
     * @return deviceName
     */
    public java.lang.String getDeviceName() {
        return deviceName;
    }


    /**
     * Sets the deviceName value for this DeviceOS.
     * 
     * @param deviceName
     */
    public void setDeviceName(java.lang.String deviceName) {
        this.deviceName = deviceName;
    }


    /**
     * Gets the OSName value for this DeviceOS.
     * 
     * @return OSName
     */
    public java.lang.String getOSName() {
        return OSName;
    }


    /**
     * Sets the OSName value for this DeviceOS.
     * 
     * @param OSName
     */
    public void setOSName(java.lang.String OSName) {
        this.OSName = OSName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeviceOS)) return false;
        DeviceOS other = (DeviceOS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.deviceName==null && other.getDeviceName()==null) || 
             (this.deviceName!=null &&
              this.deviceName.equals(other.getDeviceName()))) &&
            ((this.OSName==null && other.getOSName()==null) || 
             (this.OSName!=null &&
              this.OSName.equals(other.getOSName())));
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
        if (getDeviceName() != null) {
            _hashCode += getDeviceName().hashCode();
        }
        if (getOSName() != null) {
            _hashCode += getOSName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DeviceOS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceOS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deviceName");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OSName");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "OSName"));
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
