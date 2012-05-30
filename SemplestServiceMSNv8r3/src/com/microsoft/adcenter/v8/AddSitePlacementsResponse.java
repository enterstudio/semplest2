/**
 * AddSitePlacementsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class AddSitePlacementsResponse  implements java.io.Serializable {
    private long[] sitePlacementIds;

    public AddSitePlacementsResponse() {
    }

    public AddSitePlacementsResponse(
           long[] sitePlacementIds) {
           this.sitePlacementIds = sitePlacementIds;
    }


    /**
     * Gets the sitePlacementIds value for this AddSitePlacementsResponse.
     * 
     * @return sitePlacementIds
     */
    public long[] getSitePlacementIds() {
        return sitePlacementIds;
    }


    /**
     * Sets the sitePlacementIds value for this AddSitePlacementsResponse.
     * 
     * @param sitePlacementIds
     */
    public void setSitePlacementIds(long[] sitePlacementIds) {
        this.sitePlacementIds = sitePlacementIds;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AddSitePlacementsResponse)) return false;
        AddSitePlacementsResponse other = (AddSitePlacementsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sitePlacementIds==null && other.getSitePlacementIds()==null) || 
             (this.sitePlacementIds!=null &&
              java.util.Arrays.equals(this.sitePlacementIds, other.getSitePlacementIds())));
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
        if (getSitePlacementIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSitePlacementIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSitePlacementIds(), i);
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
        new org.apache.axis.description.TypeDesc(AddSitePlacementsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddSitePlacementsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sitePlacementIds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SitePlacementIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long"));
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
