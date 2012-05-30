/**
 * AddInsertionOrderRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customerbilling;

public class AddInsertionOrderRequest  implements java.io.Serializable {
    private com.microsoft.adcenter.api.customermanagement.Entities.InsertionOrder insertionOrder;

    public AddInsertionOrderRequest() {
    }

    public AddInsertionOrderRequest(
           com.microsoft.adcenter.api.customermanagement.Entities.InsertionOrder insertionOrder) {
           this.insertionOrder = insertionOrder;
    }


    /**
     * Gets the insertionOrder value for this AddInsertionOrderRequest.
     * 
     * @return insertionOrder
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.InsertionOrder getInsertionOrder() {
        return insertionOrder;
    }


    /**
     * Sets the insertionOrder value for this AddInsertionOrderRequest.
     * 
     * @param insertionOrder
     */
    public void setInsertionOrder(com.microsoft.adcenter.api.customermanagement.Entities.InsertionOrder insertionOrder) {
        this.insertionOrder = insertionOrder;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AddInsertionOrderRequest)) return false;
        AddInsertionOrderRequest other = (AddInsertionOrderRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.insertionOrder==null && other.getInsertionOrder()==null) || 
             (this.insertionOrder!=null &&
              this.insertionOrder.equals(other.getInsertionOrder())));
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
        if (getInsertionOrder() != null) {
            _hashCode += getInsertionOrder().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AddInsertionOrderRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">AddInsertionOrderRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insertionOrder");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "InsertionOrder"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "InsertionOrder"));
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
