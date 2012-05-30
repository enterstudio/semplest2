/**
 * ApiFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Exception;

public class ApiFault  extends com.microsoft.adapi.ApplicationFault  implements java.io.Serializable {
    private com.microsoft.adcenter.api.customermanagement.Exception.OperationError[] operationErrors;

    public ApiFault() {
    }

    public ApiFault(
           java.lang.String trackingId,
           com.microsoft.adcenter.api.customermanagement.Exception.OperationError[] operationErrors) {
        super(
            trackingId);
        this.operationErrors = operationErrors;
    }


    /**
     * Gets the operationErrors value for this ApiFault.
     * 
     * @return operationErrors
     */
    public com.microsoft.adcenter.api.customermanagement.Exception.OperationError[] getOperationErrors() {
        return operationErrors;
    }


    /**
     * Sets the operationErrors value for this ApiFault.
     * 
     * @param operationErrors
     */
    public void setOperationErrors(com.microsoft.adcenter.api.customermanagement.Exception.OperationError[] operationErrors) {
        this.operationErrors = operationErrors;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ApiFault)) return false;
        ApiFault other = (ApiFault) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.operationErrors==null && other.getOperationErrors()==null) || 
             (this.operationErrors!=null &&
              java.util.Arrays.equals(this.operationErrors, other.getOperationErrors())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getOperationErrors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOperationErrors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOperationErrors(), i);
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
        new org.apache.axis.description.TypeDesc(ApiFault.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operationErrors");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "OperationErrors"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "OperationError"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "OperationError"));
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


    /**
     * Writes the exception data to the faultDetails
     */
    public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, this);
    }
}
