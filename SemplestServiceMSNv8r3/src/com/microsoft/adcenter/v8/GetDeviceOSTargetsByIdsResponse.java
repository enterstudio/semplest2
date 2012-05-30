/**
 * GetDeviceOSTargetsByIdsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GetDeviceOSTargetsByIdsResponse  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.TargetAssociation[] targetAssociations;

    public GetDeviceOSTargetsByIdsResponse() {
    }

    public GetDeviceOSTargetsByIdsResponse(
           com.microsoft.adcenter.v8.TargetAssociation[] targetAssociations) {
           this.targetAssociations = targetAssociations;
    }


    /**
     * Gets the targetAssociations value for this GetDeviceOSTargetsByIdsResponse.
     * 
     * @return targetAssociations
     */
    public com.microsoft.adcenter.v8.TargetAssociation[] getTargetAssociations() {
        return targetAssociations;
    }


    /**
     * Sets the targetAssociations value for this GetDeviceOSTargetsByIdsResponse.
     * 
     * @param targetAssociations
     */
    public void setTargetAssociations(com.microsoft.adcenter.v8.TargetAssociation[] targetAssociations) {
        this.targetAssociations = targetAssociations;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDeviceOSTargetsByIdsResponse)) return false;
        GetDeviceOSTargetsByIdsResponse other = (GetDeviceOSTargetsByIdsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.targetAssociations==null && other.getTargetAssociations()==null) || 
             (this.targetAssociations!=null &&
              java.util.Arrays.equals(this.targetAssociations, other.getTargetAssociations())));
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
        if (getTargetAssociations() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTargetAssociations());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTargetAssociations(), i);
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
        new org.apache.axis.description.TypeDesc(GetDeviceOSTargetsByIdsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetDeviceOSTargetsByIdsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("targetAssociations");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TargetAssociations"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TargetAssociation"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TargetAssociation"));
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
