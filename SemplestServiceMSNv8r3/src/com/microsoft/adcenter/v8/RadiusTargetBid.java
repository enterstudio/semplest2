/**
 * RadiusTargetBid.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class RadiusTargetBid  implements java.io.Serializable {
    private java.lang.Long id;

    private com.microsoft.adcenter.v8.IncrementalBidPercentage incrementalBid;

    private double latitudeDegrees;

    private double longitudeDegrees;

    private java.lang.String name;

    private int radius;

    public RadiusTargetBid() {
    }

    public RadiusTargetBid(
           java.lang.Long id,
           com.microsoft.adcenter.v8.IncrementalBidPercentage incrementalBid,
           double latitudeDegrees,
           double longitudeDegrees,
           java.lang.String name,
           int radius) {
           this.id = id;
           this.incrementalBid = incrementalBid;
           this.latitudeDegrees = latitudeDegrees;
           this.longitudeDegrees = longitudeDegrees;
           this.name = name;
           this.radius = radius;
    }


    /**
     * Gets the id value for this RadiusTargetBid.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this RadiusTargetBid.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the incrementalBid value for this RadiusTargetBid.
     * 
     * @return incrementalBid
     */
    public com.microsoft.adcenter.v8.IncrementalBidPercentage getIncrementalBid() {
        return incrementalBid;
    }


    /**
     * Sets the incrementalBid value for this RadiusTargetBid.
     * 
     * @param incrementalBid
     */
    public void setIncrementalBid(com.microsoft.adcenter.v8.IncrementalBidPercentage incrementalBid) {
        this.incrementalBid = incrementalBid;
    }


    /**
     * Gets the latitudeDegrees value for this RadiusTargetBid.
     * 
     * @return latitudeDegrees
     */
    public double getLatitudeDegrees() {
        return latitudeDegrees;
    }


    /**
     * Sets the latitudeDegrees value for this RadiusTargetBid.
     * 
     * @param latitudeDegrees
     */
    public void setLatitudeDegrees(double latitudeDegrees) {
        this.latitudeDegrees = latitudeDegrees;
    }


    /**
     * Gets the longitudeDegrees value for this RadiusTargetBid.
     * 
     * @return longitudeDegrees
     */
    public double getLongitudeDegrees() {
        return longitudeDegrees;
    }


    /**
     * Sets the longitudeDegrees value for this RadiusTargetBid.
     * 
     * @param longitudeDegrees
     */
    public void setLongitudeDegrees(double longitudeDegrees) {
        this.longitudeDegrees = longitudeDegrees;
    }


    /**
     * Gets the name value for this RadiusTargetBid.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this RadiusTargetBid.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the radius value for this RadiusTargetBid.
     * 
     * @return radius
     */
    public int getRadius() {
        return radius;
    }


    /**
     * Sets the radius value for this RadiusTargetBid.
     * 
     * @param radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RadiusTargetBid)) return false;
        RadiusTargetBid other = (RadiusTargetBid) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.incrementalBid==null && other.getIncrementalBid()==null) || 
             (this.incrementalBid!=null &&
              this.incrementalBid.equals(other.getIncrementalBid()))) &&
            this.latitudeDegrees == other.getLatitudeDegrees() &&
            this.longitudeDegrees == other.getLongitudeDegrees() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIncrementalBid() != null) {
            _hashCode += getIncrementalBid().hashCode();
        }
        _hashCode += new Double(getLatitudeDegrees()).hashCode();
        _hashCode += new Double(getLongitudeDegrees()).hashCode();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += getRadius();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RadiusTargetBid.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RadiusTargetBid"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("incrementalBid");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "IncrementalBid"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "IncrementalBidPercentage"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("latitudeDegrees");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "LatitudeDegrees"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("longitudeDegrees");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "LongitudeDegrees"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
