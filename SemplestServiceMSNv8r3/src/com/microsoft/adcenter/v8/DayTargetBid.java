/**
 * DayTargetBid.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class DayTargetBid  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.Day day;

    private com.microsoft.adcenter.v8.IncrementalBidPercentage incrementalBid;

    public DayTargetBid() {
    }

    public DayTargetBid(
           com.microsoft.adcenter.v8.Day day,
           com.microsoft.adcenter.v8.IncrementalBidPercentage incrementalBid) {
           this.day = day;
           this.incrementalBid = incrementalBid;
    }


    /**
     * Gets the day value for this DayTargetBid.
     * 
     * @return day
     */
    public com.microsoft.adcenter.v8.Day getDay() {
        return day;
    }


    /**
     * Sets the day value for this DayTargetBid.
     * 
     * @param day
     */
    public void setDay(com.microsoft.adcenter.v8.Day day) {
        this.day = day;
    }


    /**
     * Gets the incrementalBid value for this DayTargetBid.
     * 
     * @return incrementalBid
     */
    public com.microsoft.adcenter.v8.IncrementalBidPercentage getIncrementalBid() {
        return incrementalBid;
    }


    /**
     * Sets the incrementalBid value for this DayTargetBid.
     * 
     * @param incrementalBid
     */
    public void setIncrementalBid(com.microsoft.adcenter.v8.IncrementalBidPercentage incrementalBid) {
        this.incrementalBid = incrementalBid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DayTargetBid)) return false;
        DayTargetBid other = (DayTargetBid) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.day==null && other.getDay()==null) || 
             (this.day!=null &&
              this.day.equals(other.getDay()))) &&
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
        if (getDay() != null) {
            _hashCode += getDay().hashCode();
        }
        if (getIncrementalBid() != null) {
            _hashCode += getIncrementalBid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DayTargetBid.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DayTargetBid"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("day");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Day"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Day"));
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
