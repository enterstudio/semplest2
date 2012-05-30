/**
 * UpdateBusinessesRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class UpdateBusinessesRequest  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.Business[] businesses;

    public UpdateBusinessesRequest() {
    }

    public UpdateBusinessesRequest(
           com.microsoft.adcenter.v8.Business[] businesses) {
           this.businesses = businesses;
    }


    /**
     * Gets the businesses value for this UpdateBusinessesRequest.
     * 
     * @return businesses
     */
    public com.microsoft.adcenter.v8.Business[] getBusinesses() {
        return businesses;
    }


    /**
     * Sets the businesses value for this UpdateBusinessesRequest.
     * 
     * @param businesses
     */
    public void setBusinesses(com.microsoft.adcenter.v8.Business[] businesses) {
        this.businesses = businesses;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateBusinessesRequest)) return false;
        UpdateBusinessesRequest other = (UpdateBusinessesRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.businesses==null && other.getBusinesses()==null) || 
             (this.businesses!=null &&
              java.util.Arrays.equals(this.businesses, other.getBusinesses())));
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
        if (getBusinesses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBusinesses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBusinesses(), i);
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
        new org.apache.axis.description.TypeDesc(UpdateBusinessesRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateBusinessesRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businesses");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Businesses"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Business"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Business"));
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
