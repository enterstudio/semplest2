/**
 * AddInsertionOrderResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customerbilling;

public class AddInsertionOrderResponse  implements java.io.Serializable {
    private java.lang.Long insertionOrderId;

    private java.util.Calendar createTime;

    public AddInsertionOrderResponse() {
    }

    public AddInsertionOrderResponse(
           java.lang.Long insertionOrderId,
           java.util.Calendar createTime) {
           this.insertionOrderId = insertionOrderId;
           this.createTime = createTime;
    }


    /**
     * Gets the insertionOrderId value for this AddInsertionOrderResponse.
     * 
     * @return insertionOrderId
     */
    public java.lang.Long getInsertionOrderId() {
        return insertionOrderId;
    }


    /**
     * Sets the insertionOrderId value for this AddInsertionOrderResponse.
     * 
     * @param insertionOrderId
     */
    public void setInsertionOrderId(java.lang.Long insertionOrderId) {
        this.insertionOrderId = insertionOrderId;
    }


    /**
     * Gets the createTime value for this AddInsertionOrderResponse.
     * 
     * @return createTime
     */
    public java.util.Calendar getCreateTime() {
        return createTime;
    }


    /**
     * Sets the createTime value for this AddInsertionOrderResponse.
     * 
     * @param createTime
     */
    public void setCreateTime(java.util.Calendar createTime) {
        this.createTime = createTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AddInsertionOrderResponse)) return false;
        AddInsertionOrderResponse other = (AddInsertionOrderResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.insertionOrderId==null && other.getInsertionOrderId()==null) || 
             (this.insertionOrderId!=null &&
              this.insertionOrderId.equals(other.getInsertionOrderId()))) &&
            ((this.createTime==null && other.getCreateTime()==null) || 
             (this.createTime!=null &&
              this.createTime.equals(other.getCreateTime())));
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
        if (getInsertionOrderId() != null) {
            _hashCode += getInsertionOrderId().hashCode();
        }
        if (getCreateTime() != null) {
            _hashCode += getCreateTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AddInsertionOrderResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">AddInsertionOrderResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insertionOrderId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "InsertionOrderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createTime");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "CreateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
