/**
 * AccountInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Entities;

public class AccountInfo  implements java.io.Serializable {
    private java.lang.Long id;

    private java.lang.String name;

    private java.lang.String number;

    private com.microsoft.adcenter.api.customermanagement.Entities.AccountLifeCycleStatus accountLifeCycleStatus;

    private org.apache.axis.types.UnsignedByte pauseReason;

    public AccountInfo() {
    }

    public AccountInfo(
           java.lang.Long id,
           java.lang.String name,
           java.lang.String number,
           com.microsoft.adcenter.api.customermanagement.Entities.AccountLifeCycleStatus accountLifeCycleStatus,
           org.apache.axis.types.UnsignedByte pauseReason) {
           this.id = id;
           this.name = name;
           this.number = number;
           this.accountLifeCycleStatus = accountLifeCycleStatus;
           this.pauseReason = pauseReason;
    }


    /**
     * Gets the id value for this AccountInfo.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this AccountInfo.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the name value for this AccountInfo.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this AccountInfo.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the number value for this AccountInfo.
     * 
     * @return number
     */
    public java.lang.String getNumber() {
        return number;
    }


    /**
     * Sets the number value for this AccountInfo.
     * 
     * @param number
     */
    public void setNumber(java.lang.String number) {
        this.number = number;
    }


    /**
     * Gets the accountLifeCycleStatus value for this AccountInfo.
     * 
     * @return accountLifeCycleStatus
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.AccountLifeCycleStatus getAccountLifeCycleStatus() {
        return accountLifeCycleStatus;
    }


    /**
     * Sets the accountLifeCycleStatus value for this AccountInfo.
     * 
     * @param accountLifeCycleStatus
     */
    public void setAccountLifeCycleStatus(com.microsoft.adcenter.api.customermanagement.Entities.AccountLifeCycleStatus accountLifeCycleStatus) {
        this.accountLifeCycleStatus = accountLifeCycleStatus;
    }


    /**
     * Gets the pauseReason value for this AccountInfo.
     * 
     * @return pauseReason
     */
    public org.apache.axis.types.UnsignedByte getPauseReason() {
        return pauseReason;
    }


    /**
     * Sets the pauseReason value for this AccountInfo.
     * 
     * @param pauseReason
     */
    public void setPauseReason(org.apache.axis.types.UnsignedByte pauseReason) {
        this.pauseReason = pauseReason;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccountInfo)) return false;
        AccountInfo other = (AccountInfo) obj;
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
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.number==null && other.getNumber()==null) || 
             (this.number!=null &&
              this.number.equals(other.getNumber()))) &&
            ((this.accountLifeCycleStatus==null && other.getAccountLifeCycleStatus()==null) || 
             (this.accountLifeCycleStatus!=null &&
              this.accountLifeCycleStatus.equals(other.getAccountLifeCycleStatus()))) &&
            ((this.pauseReason==null && other.getPauseReason()==null) || 
             (this.pauseReason!=null &&
              this.pauseReason.equals(other.getPauseReason())));
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getNumber() != null) {
            _hashCode += getNumber().hashCode();
        }
        if (getAccountLifeCycleStatus() != null) {
            _hashCode += getAccountLifeCycleStatus().hashCode();
        }
        if (getPauseReason() != null) {
            _hashCode += getPauseReason().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccountInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("number");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Number"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountLifeCycleStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountLifeCycleStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountLifeCycleStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pauseReason");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "PauseReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
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
