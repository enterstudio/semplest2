/**
 * GetDisplayInvoicesRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customerbilling;

public class GetDisplayInvoicesRequest  implements java.io.Serializable {
    private long[] invoiceIds;

    private com.microsoft.adcenter.api.customermanagement.Entities.DataType type;

    public GetDisplayInvoicesRequest() {
    }

    public GetDisplayInvoicesRequest(
           long[] invoiceIds,
           com.microsoft.adcenter.api.customermanagement.Entities.DataType type) {
           this.invoiceIds = invoiceIds;
           this.type = type;
    }


    /**
     * Gets the invoiceIds value for this GetDisplayInvoicesRequest.
     * 
     * @return invoiceIds
     */
    public long[] getInvoiceIds() {
        return invoiceIds;
    }


    /**
     * Sets the invoiceIds value for this GetDisplayInvoicesRequest.
     * 
     * @param invoiceIds
     */
    public void setInvoiceIds(long[] invoiceIds) {
        this.invoiceIds = invoiceIds;
    }


    /**
     * Gets the type value for this GetDisplayInvoicesRequest.
     * 
     * @return type
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.DataType getType() {
        return type;
    }


    /**
     * Sets the type value for this GetDisplayInvoicesRequest.
     * 
     * @param type
     */
    public void setType(com.microsoft.adcenter.api.customermanagement.Entities.DataType type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDisplayInvoicesRequest)) return false;
        GetDisplayInvoicesRequest other = (GetDisplayInvoicesRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.invoiceIds==null && other.getInvoiceIds()==null) || 
             (this.invoiceIds!=null &&
              java.util.Arrays.equals(this.invoiceIds, other.getInvoiceIds()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType())));
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
        if (getInvoiceIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInvoiceIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInvoiceIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDisplayInvoicesRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetDisplayInvoicesRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("invoiceIds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "InvoiceIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "Type"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "DataType"));
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
