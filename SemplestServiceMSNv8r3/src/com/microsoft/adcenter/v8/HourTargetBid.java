/**
 * HourTargetBid.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class HourTargetBid  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.HourRange hour;

    private com.microsoft.adcenter.v8.IncrementalBidPercentage incrementalBid;

    public HourTargetBid() {
    }

    public HourTargetBid(
           com.microsoft.adcenter.v8.HourRange hour,
           com.microsoft.adcenter.v8.IncrementalBidPercentage incrementalBid) {
           this.hour = hour;
           this.incrementalBid = incrementalBid;
    }


    /**
     * Gets the hour value for this HourTargetBid.
     * 
     * @return hour
     */
    public com.microsoft.adcenter.v8.HourRange getHour() {
        return hour;
    }


    /**
     * Sets the hour value for this HourTargetBid.
     * 
     * @param hour
     */
    public void setHour(com.microsoft.adcenter.v8.HourRange hour) {
        this.hour = hour;
    }


    /**
     * Gets the incrementalBid value for this HourTargetBid.
     * 
     * @return incrementalBid
     */
    public com.microsoft.adcenter.v8.IncrementalBidPercentage getIncrementalBid() {
        return incrementalBid;
    }


    /**
     * Sets the incrementalBid value for this HourTargetBid.
     * 
     * @param incrementalBid
     */
    public void setIncrementalBid(com.microsoft.adcenter.v8.IncrementalBidPercentage incrementalBid) {
        this.incrementalBid = incrementalBid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HourTargetBid)) return false;
        HourTargetBid other = (HourTargetBid) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.hour==null && other.getHour()==null) || 
             (this.hour!=null &&
              this.hour.equals(other.getHour()))) &&
            ((this.incrementalBid==null && other.getIncrementalBid()==null) || 
             (this.incrementalBid!=null &&
              this.incrementalBid.equals(other.getIncrementalBid())));
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
        if (getHour() != null) {
            _hashCode += getHour().hashCode();
        }
        if (getIncrementalBid() != null) {
            _hashCode += getIncrementalBid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HourTargetBid.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HourTargetBid"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hour");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Hour"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HourRange"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("incrementalBid");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "IncrementalBid"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "IncrementalBidPercentage"));
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
