/**
 * Target.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class Target  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.AgeTarget age;

    private com.microsoft.adcenter.v8.DayTarget day;

    private com.microsoft.adcenter.v8.DeviceTarget device;

    private com.microsoft.adcenter.v8.GenderTarget gender;

    private com.microsoft.adcenter.v8.HourTarget hour;

    private java.lang.Long id;

    private java.lang.Boolean isLibraryTarget;

    private com.microsoft.adcenter.v8.LocationTarget location;

    private java.lang.String name;

    public Target() {
    }

    public Target(
           com.microsoft.adcenter.v8.AgeTarget age,
           com.microsoft.adcenter.v8.DayTarget day,
           com.microsoft.adcenter.v8.DeviceTarget device,
           com.microsoft.adcenter.v8.GenderTarget gender,
           com.microsoft.adcenter.v8.HourTarget hour,
           java.lang.Long id,
           java.lang.Boolean isLibraryTarget,
           com.microsoft.adcenter.v8.LocationTarget location,
           java.lang.String name) {
           this.age = age;
           this.day = day;
           this.device = device;
           this.gender = gender;
           this.hour = hour;
           this.id = id;
           this.isLibraryTarget = isLibraryTarget;
           this.location = location;
           this.name = name;
    }


    /**
     * Gets the age value for this Target.
     * 
     * @return age
     */
    public com.microsoft.adcenter.v8.AgeTarget getAge() {
        return age;
    }


    /**
     * Sets the age value for this Target.
     * 
     * @param age
     */
    public void setAge(com.microsoft.adcenter.v8.AgeTarget age) {
        this.age = age;
    }


    /**
     * Gets the day value for this Target.
     * 
     * @return day
     */
    public com.microsoft.adcenter.v8.DayTarget getDay() {
        return day;
    }


    /**
     * Sets the day value for this Target.
     * 
     * @param day
     */
    public void setDay(com.microsoft.adcenter.v8.DayTarget day) {
        this.day = day;
    }


    /**
     * Gets the device value for this Target.
     * 
     * @return device
     */
    public com.microsoft.adcenter.v8.DeviceTarget getDevice() {
        return device;
    }


    /**
     * Sets the device value for this Target.
     * 
     * @param device
     */
    public void setDevice(com.microsoft.adcenter.v8.DeviceTarget device) {
        this.device = device;
    }


    /**
     * Gets the gender value for this Target.
     * 
     * @return gender
     */
    public com.microsoft.adcenter.v8.GenderTarget getGender() {
        return gender;
    }


    /**
     * Sets the gender value for this Target.
     * 
     * @param gender
     */
    public void setGender(com.microsoft.adcenter.v8.GenderTarget gender) {
        this.gender = gender;
    }


    /**
     * Gets the hour value for this Target.
     * 
     * @return hour
     */
    public com.microsoft.adcenter.v8.HourTarget getHour() {
        return hour;
    }


    /**
     * Sets the hour value for this Target.
     * 
     * @param hour
     */
    public void setHour(com.microsoft.adcenter.v8.HourTarget hour) {
        this.hour = hour;
    }


    /**
     * Gets the id value for this Target.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this Target.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the isLibraryTarget value for this Target.
     * 
     * @return isLibraryTarget
     */
    public java.lang.Boolean getIsLibraryTarget() {
        return isLibraryTarget;
    }


    /**
     * Sets the isLibraryTarget value for this Target.
     * 
     * @param isLibraryTarget
     */
    public void setIsLibraryTarget(java.lang.Boolean isLibraryTarget) {
        this.isLibraryTarget = isLibraryTarget;
    }


    /**
     * Gets the location value for this Target.
     * 
     * @return location
     */
    public com.microsoft.adcenter.v8.LocationTarget getLocation() {
        return location;
    }


    /**
     * Sets the location value for this Target.
     * 
     * @param location
     */
    public void setLocation(com.microsoft.adcenter.v8.LocationTarget location) {
        this.location = location;
    }


    /**
     * Gets the name value for this Target.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Target.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Target)) return false;
        Target other = (Target) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.age==null && other.getAge()==null) || 
             (this.age!=null &&
              this.age.equals(other.getAge()))) &&
            ((this.day==null && other.getDay()==null) || 
             (this.day!=null &&
              this.day.equals(other.getDay()))) &&
            ((this.device==null && other.getDevice()==null) || 
             (this.device!=null &&
              this.device.equals(other.getDevice()))) &&
            ((this.gender==null && other.getGender()==null) || 
             (this.gender!=null &&
              this.gender.equals(other.getGender()))) &&
            ((this.hour==null && other.getHour()==null) || 
             (this.hour!=null &&
              this.hour.equals(other.getHour()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.isLibraryTarget==null && other.getIsLibraryTarget()==null) || 
             (this.isLibraryTarget!=null &&
              this.isLibraryTarget.equals(other.getIsLibraryTarget()))) &&
            ((this.location==null && other.getLocation()==null) || 
             (this.location!=null &&
              this.location.equals(other.getLocation()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName())));
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
        if (getAge() != null) {
            _hashCode += getAge().hashCode();
        }
        if (getDay() != null) {
            _hashCode += getDay().hashCode();
        }
        if (getDevice() != null) {
            _hashCode += getDevice().hashCode();
        }
        if (getGender() != null) {
            _hashCode += getGender().hashCode();
        }
        if (getHour() != null) {
            _hashCode += getHour().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIsLibraryTarget() != null) {
            _hashCode += getIsLibraryTarget().hashCode();
        }
        if (getLocation() != null) {
            _hashCode += getLocation().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Target.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Target"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("age");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Age"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeTarget"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("day");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Day"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DayTarget"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("device");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Device"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceTarget"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gender");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Gender"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GenderTarget"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hour");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Hour"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HourTarget"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isLibraryTarget");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "IsLibraryTarget"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("location");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Location"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "LocationTarget"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
