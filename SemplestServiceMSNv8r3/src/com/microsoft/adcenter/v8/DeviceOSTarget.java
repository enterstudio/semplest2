/**
 * DeviceOSTarget.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class DeviceOSTarget  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.DeviceOS[] deviceOSList;

    public DeviceOSTarget() {
    }

    public DeviceOSTarget(
           com.microsoft.adcenter.v8.DeviceOS[] deviceOSList) {
           this.deviceOSList = deviceOSList;
    }


    /**
     * Gets the deviceOSList value for this DeviceOSTarget.
     * 
     * @return deviceOSList
     */
    public com.microsoft.adcenter.v8.DeviceOS[] getDeviceOSList() {
        return deviceOSList;
    }


    /**
     * Sets the deviceOSList value for this DeviceOSTarget.
     * 
     * @param deviceOSList
     */
    public void setDeviceOSList(com.microsoft.adcenter.v8.DeviceOS[] deviceOSList) {
        this.deviceOSList = deviceOSList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeviceOSTarget)) return false;
        DeviceOSTarget other = (DeviceOSTarget) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.deviceOSList==null && other.getDeviceOSList()==null) || 
             (this.deviceOSList!=null &&
              java.util.Arrays.equals(this.deviceOSList, other.getDeviceOSList())));
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
        if (getDeviceOSList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDeviceOSList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDeviceOSList(), i);
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
        new org.apache.axis.description.TypeDesc(DeviceOSTarget.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceOSTarget"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deviceOSList");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceOSList"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceOS"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceOS"));
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
