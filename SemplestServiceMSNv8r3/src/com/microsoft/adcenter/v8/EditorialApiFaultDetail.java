/**
 * EditorialApiFaultDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class EditorialApiFaultDetail  extends com.microsoft.adapi.ApplicationFault  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.BatchError[] batchErrors;

    private com.microsoft.adcenter.v8.EditorialError[] editorialErrors;

    private com.microsoft.adcenter.v8.OperationError[] operationErrors;

    public EditorialApiFaultDetail() {
    }

    public EditorialApiFaultDetail(
           java.lang.String trackingId,
           com.microsoft.adcenter.v8.BatchError[] batchErrors,
           com.microsoft.adcenter.v8.EditorialError[] editorialErrors,
           com.microsoft.adcenter.v8.OperationError[] operationErrors) {
        super(
            trackingId);
        this.batchErrors = batchErrors;
        this.editorialErrors = editorialErrors;
        this.operationErrors = operationErrors;
    }


    /**
     * Gets the batchErrors value for this EditorialApiFaultDetail.
     * 
     * @return batchErrors
     */
    public com.microsoft.adcenter.v8.BatchError[] getBatchErrors() {
        return batchErrors;
    }


    /**
     * Sets the batchErrors value for this EditorialApiFaultDetail.
     * 
     * @param batchErrors
     */
    public void setBatchErrors(com.microsoft.adcenter.v8.BatchError[] batchErrors) {
        this.batchErrors = batchErrors;
    }


    /**
     * Gets the editorialErrors value for this EditorialApiFaultDetail.
     * 
     * @return editorialErrors
     */
    public com.microsoft.adcenter.v8.EditorialError[] getEditorialErrors() {
        return editorialErrors;
    }


    /**
     * Sets the editorialErrors value for this EditorialApiFaultDetail.
     * 
     * @param editorialErrors
     */
    public void setEditorialErrors(com.microsoft.adcenter.v8.EditorialError[] editorialErrors) {
        this.editorialErrors = editorialErrors;
    }


    /**
     * Gets the operationErrors value for this EditorialApiFaultDetail.
     * 
     * @return operationErrors
     */
    public com.microsoft.adcenter.v8.OperationError[] getOperationErrors() {
        return operationErrors;
    }


    /**
     * Sets the operationErrors value for this EditorialApiFaultDetail.
     * 
     * @param operationErrors
     */
    public void setOperationErrors(com.microsoft.adcenter.v8.OperationError[] operationErrors) {
        this.operationErrors = operationErrors;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EditorialApiFaultDetail)) return false;
        EditorialApiFaultDetail other = (EditorialApiFaultDetail) obj;
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
              java.util.Arrays.equals(this.batchErrors, other.getBatchErrors()))) &&
            ((this.editorialErrors==null && other.getEditorialErrors()==null) || 
             (this.editorialErrors!=null &&
              java.util.Arrays.equals(this.editorialErrors, other.getEditorialErrors()))) &&
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
        if (getEditorialErrors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEditorialErrors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEditorialErrors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
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
        new org.apache.axis.description.TypeDesc(EditorialApiFaultDetail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialApiFaultDetail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("batchErrors");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BatchErrors"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BatchError"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BatchError"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editorialErrors");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialErrors"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialError"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialError"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operationErrors");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "OperationErrors"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "OperationError"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "OperationError"));
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
