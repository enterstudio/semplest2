/**
 * LocationTarget.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class LocationTarget  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.BusinessTarget businessTarget;

    private com.microsoft.adcenter.v8.CityTarget cityTarget;

    private com.microsoft.adcenter.v8.CountryTarget countryTarget;

    private java.lang.Boolean hasPhysicalIntent;

    private com.microsoft.adcenter.v8.MetroAreaTarget metroAreaTarget;

    private com.microsoft.adcenter.v8.RadiusTarget radiusTarget;

    private com.microsoft.adcenter.v8.StateTarget stateTarget;

    private java.lang.Boolean targetAllLocations;

    public LocationTarget() {
    }

    public LocationTarget(
           com.microsoft.adcenter.v8.BusinessTarget businessTarget,
           com.microsoft.adcenter.v8.CityTarget cityTarget,
           com.microsoft.adcenter.v8.CountryTarget countryTarget,
           java.lang.Boolean hasPhysicalIntent,
           com.microsoft.adcenter.v8.MetroAreaTarget metroAreaTarget,
           com.microsoft.adcenter.v8.RadiusTarget radiusTarget,
           com.microsoft.adcenter.v8.StateTarget stateTarget,
           java.lang.Boolean targetAllLocations) {
           this.businessTarget = businessTarget;
           this.cityTarget = cityTarget;
           this.countryTarget = countryTarget;
           this.hasPhysicalIntent = hasPhysicalIntent;
           this.metroAreaTarget = metroAreaTarget;
           this.radiusTarget = radiusTarget;
           this.stateTarget = stateTarget;
           this.targetAllLocations = targetAllLocations;
    }


    /**
     * Gets the businessTarget value for this LocationTarget.
     * 
     * @return businessTarget
     */
    public com.microsoft.adcenter.v8.BusinessTarget getBusinessTarget() {
        return businessTarget;
    }


    /**
     * Sets the businessTarget value for this LocationTarget.
     * 
     * @param businessTarget
     */
    public void setBusinessTarget(com.microsoft.adcenter.v8.BusinessTarget businessTarget) {
        this.businessTarget = businessTarget;
    }


    /**
     * Gets the cityTarget value for this LocationTarget.
     * 
     * @return cityTarget
     */
    public com.microsoft.adcenter.v8.CityTarget getCityTarget() {
        return cityTarget;
    }


    /**
     * Sets the cityTarget value for this LocationTarget.
     * 
     * @param cityTarget
     */
    public void setCityTarget(com.microsoft.adcenter.v8.CityTarget cityTarget) {
        this.cityTarget = cityTarget;
    }


    /**
     * Gets the countryTarget value for this LocationTarget.
     * 
     * @return countryTarget
     */
    public com.microsoft.adcenter.v8.CountryTarget getCountryTarget() {
        return countryTarget;
    }


    /**
     * Sets the countryTarget value for this LocationTarget.
     * 
     * @param countryTarget
     */
    public void setCountryTarget(com.microsoft.adcenter.v8.CountryTarget countryTarget) {
        this.countryTarget = countryTarget;
    }


    /**
     * Gets the hasPhysicalIntent value for this LocationTarget.
     * 
     * @return hasPhysicalIntent
     */
    public java.lang.Boolean getHasPhysicalIntent() {
        return hasPhysicalIntent;
    }


    /**
     * Sets the hasPhysicalIntent value for this LocationTarget.
     * 
     * @param hasPhysicalIntent
     */
    public void setHasPhysicalIntent(java.lang.Boolean hasPhysicalIntent) {
        this.hasPhysicalIntent = hasPhysicalIntent;
    }


    /**
     * Gets the metroAreaTarget value for this LocationTarget.
     * 
     * @return metroAreaTarget
     */
    public com.microsoft.adcenter.v8.MetroAreaTarget getMetroAreaTarget() {
        return metroAreaTarget;
    }


    /**
     * Sets the metroAreaTarget value for this LocationTarget.
     * 
     * @param metroAreaTarget
     */
    public void setMetroAreaTarget(com.microsoft.adcenter.v8.MetroAreaTarget metroAreaTarget) {
        this.metroAreaTarget = metroAreaTarget;
    }


    /**
     * Gets the radiusTarget value for this LocationTarget.
     * 
     * @return radiusTarget
     */
    public com.microsoft.adcenter.v8.RadiusTarget getRadiusTarget() {
        return radiusTarget;
    }


    /**
     * Sets the radiusTarget value for this LocationTarget.
     * 
     * @param radiusTarget
     */
    public void setRadiusTarget(com.microsoft.adcenter.v8.RadiusTarget radiusTarget) {
        this.radiusTarget = radiusTarget;
    }


    /**
     * Gets the stateTarget value for this LocationTarget.
     * 
     * @return stateTarget
     */
    public com.microsoft.adcenter.v8.StateTarget getStateTarget() {
        return stateTarget;
    }


    /**
     * Sets the stateTarget value for this LocationTarget.
     * 
     * @param stateTarget
     */
    public void setStateTarget(com.microsoft.adcenter.v8.StateTarget stateTarget) {
        this.stateTarget = stateTarget;
    }


    /**
     * Gets the targetAllLocations value for this LocationTarget.
     * 
     * @return targetAllLocations
     */
    public java.lang.Boolean getTargetAllLocations() {
        return targetAllLocations;
    }


    /**
     * Sets the targetAllLocations value for this LocationTarget.
     * 
     * @param targetAllLocations
     */
    public void setTargetAllLocations(java.lang.Boolean targetAllLocations) {
        this.targetAllLocations = targetAllLocations;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LocationTarget)) return false;
        LocationTarget other = (LocationTarget) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.businessTarget==null && other.getBusinessTarget()==null) || 
             (this.businessTarget!=null &&
              this.businessTarget.equals(other.getBusinessTarget()))) &&
            ((this.cityTarget==null && other.getCityTarget()==null) || 
             (this.cityTarget!=null &&
              this.cityTarget.equals(other.getCityTarget()))) &&
            ((this.countryTarget==null && other.getCountryTarget()==null) || 
             (this.countryTarget!=null &&
              this.countryTarget.equals(other.getCountryTarget()))) &&
            ((this.hasPhysicalIntent==null && other.getHasPhysicalIntent()==null) || 
             (this.hasPhysicalIntent!=null &&
              this.hasPhysicalIntent.equals(other.getHasPhysicalIntent()))) &&
            ((this.metroAreaTarget==null && other.getMetroAreaTarget()==null) || 
             (this.metroAreaTarget!=null &&
              this.metroAreaTarget.equals(other.getMetroAreaTarget()))) &&
            ((this.radiusTarget==null && other.getRadiusTarget()==null) || 
             (this.radiusTarget!=null &&
              this.radiusTarget.equals(other.getRadiusTarget()))) &&
            ((this.stateTarget==null && other.getStateTarget()==null) || 
             (this.stateTarget!=null &&
              this.stateTarget.equals(other.getStateTarget()))) &&
            ((this.targetAllLocations==null && other.getTargetAllLocations()==null) || 
             (this.targetAllLocations!=null &&
              this.targetAllLocations.equals(other.getTargetAllLocations())));
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
        if (getBusinessTarget() != null) {
            _hashCode += getBusinessTarget().hashCode();
        }
        if (getCityTarget() != null) {
            _hashCode += getCityTarget().hashCode();
        }
        if (getCountryTarget() != null) {
            _hashCode += getCountryTarget().hashCode();
        }
        if (getHasPhysicalIntent() != null) {
            _hashCode += getHasPhysicalIntent().hashCode();
        }
        if (getMetroAreaTarget() != null) {
            _hashCode += getMetroAreaTarget().hashCode();
        }
        if (getRadiusTarget() != null) {
            _hashCode += getRadiusTarget().hashCode();
        }
        if (getStateTarget() != null) {
            _hashCode += getStateTarget().hashCode();
        }
        if (getTargetAllLocations() != null) {
            _hashCode += getTargetAllLocations().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LocationTarget.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "LocationTarget"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessTarget");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessTarget"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessTarget"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityTarget");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CityTarget"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CityTarget"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countryTarget");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CountryTarget"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CountryTarget"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hasPhysicalIntent");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HasPhysicalIntent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metroAreaTarget");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MetroAreaTarget"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MetroAreaTarget"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("radiusTarget");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RadiusTarget"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RadiusTarget"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stateTarget");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "StateTarget"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "StateTarget"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("targetAllLocations");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TargetAllLocations"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
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
