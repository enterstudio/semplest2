/**
 * AdvertiserAccount.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Entities;

public class AdvertiserAccount  extends com.microsoft.adcenter.api.customermanagement.Entities.Account  implements java.io.Serializable {
    private java.lang.String agencyContactName;

    private java.lang.Long agencyCustomerId;

    private java.lang.Long salesHouseCustomerId;

    public AdvertiserAccount() {
    }

    public AdvertiserAccount(
           com.microsoft.adcenter.api.customermanagement.Entities.AccountType accountType,
           java.lang.Long billToCustomerId,
           java.lang.String countryCode,
           com.microsoft.adcenter.api.customermanagement.Entities.CurrencyType currencyType,
           com.microsoft.adcenter.api.customermanagement.Entities.AccountFinancialStatus accountFinancialStatus,
           java.lang.Long id,
           com.microsoft.adcenter.api.customermanagement.Entities.LanguageType language,
           java.lang.Long lastModifiedByUserId,
           java.util.Calendar lastModifiedTime,
           java.lang.String name,
           java.lang.String number,
           java.lang.Long parentCustomerId,
           java.lang.Long paymentMethodId,
           com.microsoft.adcenter.api.customermanagement.Entities.PaymentMethodType paymentMethodType,
           java.lang.Long primaryUserId,
           com.microsoft.adcenter.api.customermanagement.Entities.AccountLifeCycleStatus accountLifeCycleStatus,
           byte[] timeStamp,
           com.microsoft.adcenter.api.customermanagement.Entities.TimeZoneType timeZone,
           org.apache.axis.types.UnsignedByte pauseReason,
           java.lang.String agencyContactName,
           java.lang.Long agencyCustomerId,
           java.lang.Long salesHouseCustomerId) {
        super(
            accountType,
            billToCustomerId,
            countryCode,
            currencyType,
            accountFinancialStatus,
            id,
            language,
            lastModifiedByUserId,
            lastModifiedTime,
            name,
            number,
            parentCustomerId,
            paymentMethodId,
            paymentMethodType,
            primaryUserId,
            accountLifeCycleStatus,
            timeStamp,
            timeZone,
            pauseReason);
        this.agencyContactName = agencyContactName;
        this.agencyCustomerId = agencyCustomerId;
        this.salesHouseCustomerId = salesHouseCustomerId;
    }


    /**
     * Gets the agencyContactName value for this AdvertiserAccount.
     * 
     * @return agencyContactName
     */
    public java.lang.String getAgencyContactName() {
        return agencyContactName;
    }


    /**
     * Sets the agencyContactName value for this AdvertiserAccount.
     * 
     * @param agencyContactName
     */
    public void setAgencyContactName(java.lang.String agencyContactName) {
        this.agencyContactName = agencyContactName;
    }


    /**
     * Gets the agencyCustomerId value for this AdvertiserAccount.
     * 
     * @return agencyCustomerId
     */
    public java.lang.Long getAgencyCustomerId() {
        return agencyCustomerId;
    }


    /**
     * Sets the agencyCustomerId value for this AdvertiserAccount.
     * 
     * @param agencyCustomerId
     */
    public void setAgencyCustomerId(java.lang.Long agencyCustomerId) {
        this.agencyCustomerId = agencyCustomerId;
    }


    /**
     * Gets the salesHouseCustomerId value for this AdvertiserAccount.
     * 
     * @return salesHouseCustomerId
     */
    public java.lang.Long getSalesHouseCustomerId() {
        return salesHouseCustomerId;
    }


    /**
     * Sets the salesHouseCustomerId value for this AdvertiserAccount.
     * 
     * @param salesHouseCustomerId
     */
    public void setSalesHouseCustomerId(java.lang.Long salesHouseCustomerId) {
        this.salesHouseCustomerId = salesHouseCustomerId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AdvertiserAccount)) return false;
        AdvertiserAccount other = (AdvertiserAccount) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.agencyContactName==null && other.getAgencyContactName()==null) || 
             (this.agencyContactName!=null &&
              this.agencyContactName.equals(other.getAgencyContactName()))) &&
            ((this.agencyCustomerId==null && other.getAgencyCustomerId()==null) || 
             (this.agencyCustomerId!=null &&
              this.agencyCustomerId.equals(other.getAgencyCustomerId()))) &&
            ((this.salesHouseCustomerId==null && other.getSalesHouseCustomerId()==null) || 
             (this.salesHouseCustomerId!=null &&
              this.salesHouseCustomerId.equals(other.getSalesHouseCustomerId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getAgencyContactName() != null) {
            _hashCode += getAgencyContactName().hashCode();
        }
        if (getAgencyCustomerId() != null) {
            _hashCode += getAgencyCustomerId().hashCode();
        }
        if (getSalesHouseCustomerId() != null) {
            _hashCode += getSalesHouseCustomerId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AdvertiserAccount.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AdvertiserAccount"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agencyContactName");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AgencyContactName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agencyCustomerId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AgencyCustomerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salesHouseCustomerId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "SalesHouseCustomerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
