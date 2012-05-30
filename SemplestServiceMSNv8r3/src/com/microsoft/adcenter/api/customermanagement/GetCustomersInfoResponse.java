/**
 * GetCustomersInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement;

public class GetCustomersInfoResponse  implements java.io.Serializable {
    private com.microsoft.adcenter.api.customermanagement.Entities.CustomerInfo[] customersInfo;

    public GetCustomersInfoResponse() {
    }

    public GetCustomersInfoResponse(
           com.microsoft.adcenter.api.customermanagement.Entities.CustomerInfo[] customersInfo) {
           this.customersInfo = customersInfo;
    }


    /**
     * Gets the customersInfo value for this GetCustomersInfoResponse.
     * 
     * @return customersInfo
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.CustomerInfo[] getCustomersInfo() {
        return customersInfo;
    }


    /**
     * Sets the customersInfo value for this GetCustomersInfoResponse.
     * 
     * @param customersInfo
     */
    public void setCustomersInfo(com.microsoft.adcenter.api.customermanagement.Entities.CustomerInfo[] customersInfo) {
        this.customersInfo = customersInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetCustomersInfoResponse)) return false;
        GetCustomersInfoResponse other = (GetCustomersInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customersInfo==null && other.getCustomersInfo()==null) || 
             (this.customersInfo!=null &&
              java.util.Arrays.equals(this.customersInfo, other.getCustomersInfo())));
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
        if (getCustomersInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCustomersInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCustomersInfo(), i);
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
        new org.apache.axis.description.TypeDesc(GetCustomersInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetCustomersInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customersInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "CustomersInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CustomerInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CustomerInfo"));
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
