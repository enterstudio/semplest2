/**
 * Ad.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class Ad  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.AdEditorialStatus editorialStatus;

    private java.lang.Long id;

    private com.microsoft.adcenter.v8.AdStatus status;

    private com.microsoft.adcenter.v8.AdType type;

    public Ad() {
    }

    public Ad(
           com.microsoft.adcenter.v8.AdEditorialStatus editorialStatus,
           java.lang.Long id,
           com.microsoft.adcenter.v8.AdStatus status,
           com.microsoft.adcenter.v8.AdType type) {
           this.editorialStatus = editorialStatus;
           this.id = id;
           this.status = status;
           this.type = type;
    }


    /**
     * Gets the editorialStatus value for this Ad.
     * 
     * @return editorialStatus
     */
    public com.microsoft.adcenter.v8.AdEditorialStatus getEditorialStatus() {
        return editorialStatus;
    }


    /**
     * Sets the editorialStatus value for this Ad.
     * 
     * @param editorialStatus
     */
    public void setEditorialStatus(com.microsoft.adcenter.v8.AdEditorialStatus editorialStatus) {
        this.editorialStatus = editorialStatus;
    }


    /**
     * Gets the id value for this Ad.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this Ad.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the status value for this Ad.
     * 
     * @return status
     */
    public com.microsoft.adcenter.v8.AdStatus getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Ad.
     * 
     * @param status
     */
    public void setStatus(com.microsoft.adcenter.v8.AdStatus status) {
        this.status = status;
    }


    /**
     * Gets the type value for this Ad.
     * 
     * @return type
     */
    public com.microsoft.adcenter.v8.AdType getType() {
        return type;
    }


    /**
     * Sets the type value for this Ad.
     * 
     * @param type
     */
    public void setType(com.microsoft.adcenter.v8.AdType type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ad)) return false;
        Ad other = (Ad) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.editorialStatus==null && other.getEditorialStatus()==null) || 
             (this.editorialStatus!=null &&
              this.editorialStatus.equals(other.getEditorialStatus()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
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
        if (getEditorialStatus() != null) {
            _hashCode += getEditorialStatus().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ad.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Ad"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editorialStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdEditorialStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Type"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdType"));
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
