/**
 * RichAdComponentPerformanceReportFilter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class RichAdComponentPerformanceReportFilter  implements java.io.Serializable {
    private java.lang.String[] componentType;

    private java.lang.String[] richAdSubType;

    public RichAdComponentPerformanceReportFilter() {
    }

    public RichAdComponentPerformanceReportFilter(
           java.lang.String[] componentType,
           java.lang.String[] richAdSubType) {
           this.componentType = componentType;
           this.richAdSubType = richAdSubType;
    }


    /**
     * Gets the componentType value for this RichAdComponentPerformanceReportFilter.
     * 
     * @return componentType
     */
    public java.lang.String[] getComponentType() {
        return componentType;
    }


    /**
     * Sets the componentType value for this RichAdComponentPerformanceReportFilter.
     * 
     * @param componentType
     */
    public void setComponentType(java.lang.String[] componentType) {
        this.componentType = componentType;
    }


    /**
     * Gets the richAdSubType value for this RichAdComponentPerformanceReportFilter.
     * 
     * @return richAdSubType
     */
    public java.lang.String[] getRichAdSubType() {
        return richAdSubType;
    }


    /**
     * Sets the richAdSubType value for this RichAdComponentPerformanceReportFilter.
     * 
     * @param richAdSubType
     */
    public void setRichAdSubType(java.lang.String[] richAdSubType) {
        this.richAdSubType = richAdSubType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RichAdComponentPerformanceReportFilter)) return false;
        RichAdComponentPerformanceReportFilter other = (RichAdComponentPerformanceReportFilter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.componentType==null && other.getComponentType()==null) || 
             (this.componentType!=null &&
              java.util.Arrays.equals(this.componentType, other.getComponentType()))) &&
            ((this.richAdSubType==null && other.getRichAdSubType()==null) || 
             (this.richAdSubType!=null &&
              java.util.Arrays.equals(this.richAdSubType, other.getRichAdSubType())));
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
        if (getComponentType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getComponentType());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getComponentType(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRichAdSubType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRichAdSubType());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRichAdSubType(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RichAdComponentPerformanceReportFilter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RichAdComponentPerformanceReportFilter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("componentType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ComponentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ComponentTypeFilter"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("richAdSubType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RichAdSubType"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RichAdSubTypeFilter"));
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
