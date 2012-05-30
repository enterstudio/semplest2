/**
 * ImpressionsPerDayRange.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class ImpressionsPerDayRange  implements java.io.Serializable {
    private java.lang.Integer maximum;

    private java.lang.Integer minimum;

    public ImpressionsPerDayRange() {
    }

    public ImpressionsPerDayRange(
           java.lang.Integer maximum,
           java.lang.Integer minimum) {
           this.maximum = maximum;
           this.minimum = minimum;
    }


    /**
     * Gets the maximum value for this ImpressionsPerDayRange.
     * 
     * @return maximum
     */
    public java.lang.Integer getMaximum() {
        return maximum;
    }


    /**
     * Sets the maximum value for this ImpressionsPerDayRange.
     * 
     * @param maximum
     */
    public void setMaximum(java.lang.Integer maximum) {
        this.maximum = maximum;
    }


    /**
     * Gets the minimum value for this ImpressionsPerDayRange.
     * 
     * @return minimum
     */
    public java.lang.Integer getMinimum() {
        return minimum;
    }


    /**
     * Sets the minimum value for this ImpressionsPerDayRange.
     * 
     * @param minimum
     */
    public void setMinimum(java.lang.Integer minimum) {
        this.minimum = minimum;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ImpressionsPerDayRange)) return false;
        ImpressionsPerDayRange other = (ImpressionsPerDayRange) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.maximum==null && other.getMaximum()==null) || 
             (this.maximum!=null &&
              this.maximum.equals(other.getMaximum()))) &&
            ((this.minimum==null && other.getMinimum()==null) || 
             (this.minimum!=null &&
              this.minimum.equals(other.getMinimum())));
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
        if (getMaximum() != null) {
            _hashCode += getMaximum().hashCode();
        }
        if (getMinimum() != null) {
            _hashCode += getMinimum().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ImpressionsPerDayRange.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ImpressionsPerDayRange"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maximum");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Maximum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minimum");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Minimum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
