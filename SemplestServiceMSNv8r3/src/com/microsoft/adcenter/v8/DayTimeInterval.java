/**
 * DayTimeInterval.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class DayTimeInterval  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.TimeOfTheDay begin;

    private com.microsoft.adcenter.v8.TimeOfTheDay end;

    public DayTimeInterval() {
    }

    public DayTimeInterval(
           com.microsoft.adcenter.v8.TimeOfTheDay begin,
           com.microsoft.adcenter.v8.TimeOfTheDay end) {
           this.begin = begin;
           this.end = end;
    }


    /**
     * Gets the begin value for this DayTimeInterval.
     * 
     * @return begin
     */
    public com.microsoft.adcenter.v8.TimeOfTheDay getBegin() {
        return begin;
    }


    /**
     * Sets the begin value for this DayTimeInterval.
     * 
     * @param begin
     */
    public void setBegin(com.microsoft.adcenter.v8.TimeOfTheDay begin) {
        this.begin = begin;
    }


    /**
     * Gets the end value for this DayTimeInterval.
     * 
     * @return end
     */
    public com.microsoft.adcenter.v8.TimeOfTheDay getEnd() {
        return end;
    }


    /**
     * Sets the end value for this DayTimeInterval.
     * 
     * @param end
     */
    public void setEnd(com.microsoft.adcenter.v8.TimeOfTheDay end) {
        this.end = end;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DayTimeInterval)) return false;
        DayTimeInterval other = (DayTimeInterval) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.begin==null && other.getBegin()==null) || 
             (this.begin!=null &&
              this.begin.equals(other.getBegin()))) &&
            ((this.end==null && other.getEnd()==null) || 
             (this.end!=null &&
              this.end.equals(other.getEnd())));
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
        if (getBegin() != null) {
            _hashCode += getBegin().hashCode();
        }
        if (getEnd() != null) {
            _hashCode += getEnd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DayTimeInterval.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DayTimeInterval"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("begin");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Begin"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TimeOfTheDay"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("end");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "End"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TimeOfTheDay"));
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
