/**
 * HoursOfOperation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class HoursOfOperation  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.Day day;

    private com.microsoft.adcenter.v8.DayTimeInterval openTime1;

    private com.microsoft.adcenter.v8.DayTimeInterval openTime2;

    public HoursOfOperation() {
    }

    public HoursOfOperation(
           com.microsoft.adcenter.v8.Day day,
           com.microsoft.adcenter.v8.DayTimeInterval openTime1,
           com.microsoft.adcenter.v8.DayTimeInterval openTime2) {
           this.day = day;
           this.openTime1 = openTime1;
           this.openTime2 = openTime2;
    }


    /**
     * Gets the day value for this HoursOfOperation.
     * 
     * @return day
     */
    public com.microsoft.adcenter.v8.Day getDay() {
        return day;
    }


    /**
     * Sets the day value for this HoursOfOperation.
     * 
     * @param day
     */
    public void setDay(com.microsoft.adcenter.v8.Day day) {
        this.day = day;
    }


    /**
     * Gets the openTime1 value for this HoursOfOperation.
     * 
     * @return openTime1
     */
    public com.microsoft.adcenter.v8.DayTimeInterval getOpenTime1() {
        return openTime1;
    }


    /**
     * Sets the openTime1 value for this HoursOfOperation.
     * 
     * @param openTime1
     */
    public void setOpenTime1(com.microsoft.adcenter.v8.DayTimeInterval openTime1) {
        this.openTime1 = openTime1;
    }


    /**
     * Gets the openTime2 value for this HoursOfOperation.
     * 
     * @return openTime2
     */
    public com.microsoft.adcenter.v8.DayTimeInterval getOpenTime2() {
        return openTime2;
    }


    /**
     * Sets the openTime2 value for this HoursOfOperation.
     * 
     * @param openTime2
     */
    public void setOpenTime2(com.microsoft.adcenter.v8.DayTimeInterval openTime2) {
        this.openTime2 = openTime2;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HoursOfOperation)) return false;
        HoursOfOperation other = (HoursOfOperation) obj;
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
            ((this.openTime1==null && other.getOpenTime1()==null) || 
             (this.openTime1!=null &&
              this.openTime1.equals(other.getOpenTime1()))) &&
            ((this.openTime2==null && other.getOpenTime2()==null) || 
             (this.openTime2!=null &&
              this.openTime2.equals(other.getOpenTime2())));
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
        if (getOpenTime1() != null) {
            _hashCode += getOpenTime1().hashCode();
        }
        if (getOpenTime2() != null) {
            _hashCode += getOpenTime2().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HoursOfOperation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HoursOfOperation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("day");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Day"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Day"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openTime1");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "openTime1"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DayTimeInterval"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openTime2");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "openTime2"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DayTimeInterval"));
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
