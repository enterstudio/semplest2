/**
 * BusinessTargetBid.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class BusinessTargetBid  implements java.io.Serializable {
    private long businessId;

    private com.microsoft.adcenter.v8.IncrementalBidPercentage incrementalBid;

    private int radius;

    public BusinessTargetBid() {
    }

    public BusinessTargetBid(
           long businessId,
           com.microsoft.adcenter.v8.IncrementalBidPercentage incrementalBid,
           int radius) {
           this.businessId = businessId;
           this.incrementalBid = incrementalBid;
           this.radius = radius;
    }


    /**
     * Gets the businessId value for this BusinessTargetBid.
     * 
     * @return businessId
     */
    public long getBusinessId() {
        return businessId;
    }


    /**
     * Sets the businessId value for this BusinessTargetBid.
     * 
     * @param businessId
     */
    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }


    /**
     * Gets the incrementalBid value for this BusinessTargetBid.
     * 
     * @return incrementalBid
     */
    public com.microsoft.adcenter.v8.IncrementalBidPercentage getIncrementalBid() {
        return incrementalBid;
    }


    /**
     * Sets the incrementalBid value for this BusinessTargetBid.
     * 
     * @param incrementalBid
     */
    public void setIncrementalBid(com.microsoft.adcenter.v8.IncrementalBidPercentage incrementalBid) {
        this.incrementalBid = incrementalBid;
    }


    /**
     * Gets the radius value for this BusinessTargetBid.
     * 
     * @return radius
     */
    public int getRadius() {
        return radius;
    }


    /**
     * Sets the radius value for this BusinessTargetBid.
     * 
     * @param radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BusinessTargetBid)) return false;
        BusinessTargetBid other = (BusinessTargetBid) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.businessId == other.getBusinessId() &&
            ((this.incrementalBid==null && other.getIncrementalBid()==null) || 
             (this.incrementalBid!=null &&
              this.incrementalBid.equals(other.getIncrementalBid()))) &&
            this.radius == other.getRadius();
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
        _hashCode += new Long(getBusinessId()).hashCode();
        if (getIncrementalBid() != null) {
            _hashCode += getIncrementalBid().hashCode();
        }
        _hashCode += getRadius();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BusinessTargetBid.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessTargetBid"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("incrementalBid");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "IncrementalBid"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "IncrementalBidPercentage"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("radius");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Radius"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
