/**
 * ApiBatchFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Exception;

public class ApiBatchFault  extends com.microsoft.adcenter.api.customermanagement.Exception.ApiFault  implements java.io.Serializable {
    private com.microsoft.adcenter.api.customermanagement.Exception.BatchError[] batchErrors;

    public ApiBatchFault() {
    }

    public ApiBatchFault(
           java.lang.String trackingId,
           com.microsoft.adcenter.api.customermanagement.Exception.OperationError[] operationErrors,
           com.microsoft.adcenter.api.customermanagement.Exception.BatchError[] batchErrors) {
        super(
            trackingId,
            operationErrors);
        this.batchErrors = batchErrors;
    }


    /**
     * Gets the batchErrors value for this ApiBatchFault.
     * 
     * @return batchErrors
     */
    public com.microsoft.adcenter.api.customermanagement.Exception.BatchError[] getBatchErrors() {
        return batchErrors;
    }


    /**
     * Sets the batchErrors value for this ApiBatchFault.
     * 
     * @param batchErrors
     */
    public void setBatchErrors(com.microsoft.adcenter.api.customermanagement.Exception.BatchError[] batchErrors) {
        this.batchErrors = batchErrors;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ApiBatchFault)) return false;
        ApiBatchFault other = (ApiBatchFault) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.batchErrors==null && other.getBatchErrors()==null) || 
             (this.batchErrors!=null &&
              java.util.Arrays.equals(this.batchErrors, other.getBatchErrors())));
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
        if (getBatchErrors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBatchErrors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBatchErrors(), i);
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
        new org.apache.axis.description.TypeDesc(ApiBatchFault.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiBatchFault"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("batchErrors");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "BatchErrors"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "BatchError"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "BatchError"));
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
