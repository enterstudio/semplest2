/**
 * ManageAccountsRequestInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Entities;

public class ManageAccountsRequestInfo  implements java.io.Serializable {
    private java.lang.String[] advertiserAccountNumbers;

    private java.lang.String agencyCustomerNumber;

    private java.util.Calendar requestDate;

    private com.microsoft.adcenter.api.customermanagement.Entities.Date effectiveDate;

    private java.lang.Long id;

    private com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestStatus status;

    public ManageAccountsRequestInfo() {
    }

    public ManageAccountsRequestInfo(
           java.lang.String[] advertiserAccountNumbers,
           java.lang.String agencyCustomerNumber,
           java.util.Calendar requestDate,
           com.microsoft.adcenter.api.customermanagement.Entities.Date effectiveDate,
           java.lang.Long id,
           com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestStatus status) {
           this.advertiserAccountNumbers = advertiserAccountNumbers;
           this.agencyCustomerNumber = agencyCustomerNumber;
           this.requestDate = requestDate;
           this.effectiveDate = effectiveDate;
           this.id = id;
           this.status = status;
    }


    /**
     * Gets the advertiserAccountNumbers value for this ManageAccountsRequestInfo.
     * 
     * @return advertiserAccountNumbers
     */
    public java.lang.String[] getAdvertiserAccountNumbers() {
        return advertiserAccountNumbers;
    }


    /**
     * Sets the advertiserAccountNumbers value for this ManageAccountsRequestInfo.
     * 
     * @param advertiserAccountNumbers
     */
    public void setAdvertiserAccountNumbers(java.lang.String[] advertiserAccountNumbers) {
        this.advertiserAccountNumbers = advertiserAccountNumbers;
    }


    /**
     * Gets the agencyCustomerNumber value for this ManageAccountsRequestInfo.
     * 
     * @return agencyCustomerNumber
     */
    public java.lang.String getAgencyCustomerNumber() {
        return agencyCustomerNumber;
    }


    /**
     * Sets the agencyCustomerNumber value for this ManageAccountsRequestInfo.
     * 
     * @param agencyCustomerNumber
     */
    public void setAgencyCustomerNumber(java.lang.String agencyCustomerNumber) {
        this.agencyCustomerNumber = agencyCustomerNumber;
    }


    /**
     * Gets the requestDate value for this ManageAccountsRequestInfo.
     * 
     * @return requestDate
     */
    public java.util.Calendar getRequestDate() {
        return requestDate;
    }


    /**
     * Sets the requestDate value for this ManageAccountsRequestInfo.
     * 
     * @param requestDate
     */
    public void setRequestDate(java.util.Calendar requestDate) {
        this.requestDate = requestDate;
    }


    /**
     * Gets the effectiveDate value for this ManageAccountsRequestInfo.
     * 
     * @return effectiveDate
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.Date getEffectiveDate() {
        return effectiveDate;
    }


    /**
     * Sets the effectiveDate value for this ManageAccountsRequestInfo.
     * 
     * @param effectiveDate
     */
    public void setEffectiveDate(com.microsoft.adcenter.api.customermanagement.Entities.Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    /**
     * Gets the id value for this ManageAccountsRequestInfo.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this ManageAccountsRequestInfo.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the status value for this ManageAccountsRequestInfo.
     * 
     * @return status
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestStatus getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ManageAccountsRequestInfo.
     * 
     * @param status
     */
    public void setStatus(com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestStatus status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ManageAccountsRequestInfo)) return false;
        ManageAccountsRequestInfo other = (ManageAccountsRequestInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.advertiserAccountNumbers==null && other.getAdvertiserAccountNumbers()==null) || 
             (this.advertiserAccountNumbers!=null &&
              java.util.Arrays.equals(this.advertiserAccountNumbers, other.getAdvertiserAccountNumbers()))) &&
            ((this.agencyCustomerNumber==null && other.getAgencyCustomerNumber()==null) || 
             (this.agencyCustomerNumber!=null &&
              this.agencyCustomerNumber.equals(other.getAgencyCustomerNumber()))) &&
            ((this.requestDate==null && other.getRequestDate()==null) || 
             (this.requestDate!=null &&
              this.requestDate.equals(other.getRequestDate()))) &&
            ((this.effectiveDate==null && other.getEffectiveDate()==null) || 
             (this.effectiveDate!=null &&
              this.effectiveDate.equals(other.getEffectiveDate()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
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
        if (getAdvertiserAccountNumbers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAdvertiserAccountNumbers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAdvertiserAccountNumbers(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAgencyCustomerNumber() != null) {
            _hashCode += getAgencyCustomerNumber().hashCode();
        }
        if (getRequestDate() != null) {
            _hashCode += getRequestDate().hashCode();
        }
        if (getEffectiveDate() != null) {
            _hashCode += getEffectiveDate().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ManageAccountsRequestInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("advertiserAccountNumbers");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AdvertiserAccountNumbers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agencyCustomerNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AgencyCustomerNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "RequestDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "EffectiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestStatus"));
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
