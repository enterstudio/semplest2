/**
 * MigrationStatusInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class MigrationStatusInfo  implements java.io.Serializable {
    private java.lang.String migrationType;

    private java.util.Calendar startTimeInUtc;

    private com.microsoft.adcenter.v8.MigrationStatus status;

    public MigrationStatusInfo() {
    }

    public MigrationStatusInfo(
           java.lang.String migrationType,
           java.util.Calendar startTimeInUtc,
           com.microsoft.adcenter.v8.MigrationStatus status) {
           this.migrationType = migrationType;
           this.startTimeInUtc = startTimeInUtc;
           this.status = status;
    }


    /**
     * Gets the migrationType value for this MigrationStatusInfo.
     * 
     * @return migrationType
     */
    public java.lang.String getMigrationType() {
        return migrationType;
    }


    /**
     * Sets the migrationType value for this MigrationStatusInfo.
     * 
     * @param migrationType
     */
    public void setMigrationType(java.lang.String migrationType) {
        this.migrationType = migrationType;
    }


    /**
     * Gets the startTimeInUtc value for this MigrationStatusInfo.
     * 
     * @return startTimeInUtc
     */
    public java.util.Calendar getStartTimeInUtc() {
        return startTimeInUtc;
    }


    /**
     * Sets the startTimeInUtc value for this MigrationStatusInfo.
     * 
     * @param startTimeInUtc
     */
    public void setStartTimeInUtc(java.util.Calendar startTimeInUtc) {
        this.startTimeInUtc = startTimeInUtc;
    }


    /**
     * Gets the status value for this MigrationStatusInfo.
     * 
     * @return status
     */
    public com.microsoft.adcenter.v8.MigrationStatus getStatus() {
        return status;
    }


    /**
     * Sets the status value for this MigrationStatusInfo.
     * 
     * @param status
     */
    public void setStatus(com.microsoft.adcenter.v8.MigrationStatus status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MigrationStatusInfo)) return false;
        MigrationStatusInfo other = (MigrationStatusInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.migrationType==null && other.getMigrationType()==null) || 
             (this.migrationType!=null &&
              this.migrationType.equals(other.getMigrationType()))) &&
            ((this.startTimeInUtc==null && other.getStartTimeInUtc()==null) || 
             (this.startTimeInUtc!=null &&
              this.startTimeInUtc.equals(other.getStartTimeInUtc()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus())));
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
        if (getMigrationType() != null) {
            _hashCode += getMigrationType().hashCode();
        }
        if (getStartTimeInUtc() != null) {
            _hashCode += getStartTimeInUtc().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MigrationStatusInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MigrationStatusInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("migrationType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MigrationType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startTimeInUtc");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "StartTimeInUtc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MigrationStatus"));
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
