/**
 * GetBusinessesInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GetBusinessesInfoResponse  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.BusinessInfo[] businessesInfo;

    public GetBusinessesInfoResponse() {
    }

    public GetBusinessesInfoResponse(
           com.microsoft.adcenter.v8.BusinessInfo[] businessesInfo) {
           this.businessesInfo = businessesInfo;
    }


    /**
     * Gets the businessesInfo value for this GetBusinessesInfoResponse.
     * 
     * @return businessesInfo
     */
    public com.microsoft.adcenter.v8.BusinessInfo[] getBusinessesInfo() {
        return businessesInfo;
    }


    /**
     * Sets the businessesInfo value for this GetBusinessesInfoResponse.
     * 
     * @param businessesInfo
     */
    public void setBusinessesInfo(com.microsoft.adcenter.v8.BusinessInfo[] businessesInfo) {
        this.businessesInfo = businessesInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetBusinessesInfoResponse)) return false;
        GetBusinessesInfoResponse other = (GetBusinessesInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.businessesInfo==null && other.getBusinessesInfo()==null) || 
             (this.businessesInfo!=null &&
              java.util.Arrays.equals(this.businessesInfo, other.getBusinessesInfo())));
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
        if (getBusinessesInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBusinessesInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBusinessesInfo(), i);
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
        new org.apache.axis.description.TypeDesc(GetBusinessesInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetBusinessesInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessesInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessesInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessInfo"));
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
