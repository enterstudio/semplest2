/**
 * TargetAssociation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class TargetAssociation  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.DeviceOSTarget deviceOSTarget;

    private java.lang.Long id;

    public TargetAssociation() {
    }

    public TargetAssociation(
           com.microsoft.adcenter.v8.DeviceOSTarget deviceOSTarget,
           java.lang.Long id) {
           this.deviceOSTarget = deviceOSTarget;
           this.id = id;
    }


    /**
     * Gets the deviceOSTarget value for this TargetAssociation.
     * 
     * @return deviceOSTarget
     */
    public com.microsoft.adcenter.v8.DeviceOSTarget getDeviceOSTarget() {
        return deviceOSTarget;
    }


    /**
     * Sets the deviceOSTarget value for this TargetAssociation.
     * 
     * @param deviceOSTarget
     */
    public void setDeviceOSTarget(com.microsoft.adcenter.v8.DeviceOSTarget deviceOSTarget) {
        this.deviceOSTarget = deviceOSTarget;
    }


    /**
     * Gets the id value for this TargetAssociation.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this TargetAssociation.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TargetAssociation)) return false;
        TargetAssociation other = (TargetAssociation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.deviceOSTarget==null && other.getDeviceOSTarget()==null) || 
             (this.deviceOSTarget!=null &&
              this.deviceOSTarget.equals(other.getDeviceOSTarget()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId())));
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
        if (getDeviceOSTarget() != null) {
            _hashCode += getDeviceOSTarget().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TargetAssociation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TargetAssociation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deviceOSTarget");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceOSTarget"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceOSTarget"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
