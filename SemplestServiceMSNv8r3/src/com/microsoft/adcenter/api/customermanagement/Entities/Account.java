/**
 * Account.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Entities;

public class Account  implements java.io.Serializable {
    private com.microsoft.adcenter.api.customermanagement.Entities.AccountType accountType;

    private java.lang.Long billToCustomerId;

    private java.lang.String countryCode;

    private com.microsoft.adcenter.api.customermanagement.Entities.CurrencyType currencyType;

    private com.microsoft.adcenter.api.customermanagement.Entities.AccountFinancialStatus accountFinancialStatus;

    private java.lang.Long id;

    private com.microsoft.adcenter.api.customermanagement.Entities.LanguageType language;

    private java.lang.Long lastModifiedByUserId;

    private java.util.Calendar lastModifiedTime;

    private java.lang.String name;

    private java.lang.String number;

    private java.lang.Long parentCustomerId;

    private java.lang.Long paymentMethodId;

    private com.microsoft.adcenter.api.customermanagement.Entities.PaymentMethodType paymentMethodType;

    private java.lang.Long primaryUserId;

    private com.microsoft.adcenter.api.customermanagement.Entities.AccountLifeCycleStatus accountLifeCycleStatus;

    private byte[] timeStamp;

    private com.microsoft.adcenter.api.customermanagement.Entities.TimeZoneType timeZone;

    private org.apache.axis.types.UnsignedByte pauseReason;

    public Account() {
    }

    public Account(
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
           org.apache.axis.types.UnsignedByte pauseReason) {
           this.accountType = accountType;
           this.billToCustomerId = billToCustomerId;
           this.countryCode = countryCode;
           this.currencyType = currencyType;
           this.accountFinancialStatus = accountFinancialStatus;
           this.id = id;
           this.language = language;
           this.lastModifiedByUserId = lastModifiedByUserId;
           this.lastModifiedTime = lastModifiedTime;
           this.name = name;
           this.number = number;
           this.parentCustomerId = parentCustomerId;
           this.paymentMethodId = paymentMethodId;
           this.paymentMethodType = paymentMethodType;
           this.primaryUserId = primaryUserId;
           this.accountLifeCycleStatus = accountLifeCycleStatus;
           this.timeStamp = timeStamp;
           this.timeZone = timeZone;
           this.pauseReason = pauseReason;
    }


    /**
     * Gets the accountType value for this Account.
     * 
     * @return accountType
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.AccountType getAccountType() {
        return accountType;
    }


    /**
     * Sets the accountType value for this Account.
     * 
     * @param accountType
     */
    public void setAccountType(com.microsoft.adcenter.api.customermanagement.Entities.AccountType accountType) {
        this.accountType = accountType;
    }


    /**
     * Gets the billToCustomerId value for this Account.
     * 
     * @return billToCustomerId
     */
    public java.lang.Long getBillToCustomerId() {
        return billToCustomerId;
    }


    /**
     * Sets the billToCustomerId value for this Account.
     * 
     * @param billToCustomerId
     */
    public void setBillToCustomerId(java.lang.Long billToCustomerId) {
        this.billToCustomerId = billToCustomerId;
    }


    /**
     * Gets the countryCode value for this Account.
     * 
     * @return countryCode
     */
    public java.lang.String getCountryCode() {
        return countryCode;
    }


    /**
     * Sets the countryCode value for this Account.
     * 
     * @param countryCode
     */
    public void setCountryCode(java.lang.String countryCode) {
        this.countryCode = countryCode;
    }


    /**
     * Gets the currencyType value for this Account.
     * 
     * @return currencyType
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.CurrencyType getCurrencyType() {
        return currencyType;
    }


    /**
     * Sets the currencyType value for this Account.
     * 
     * @param currencyType
     */
    public void setCurrencyType(com.microsoft.adcenter.api.customermanagement.Entities.CurrencyType currencyType) {
        this.currencyType = currencyType;
    }


    /**
     * Gets the accountFinancialStatus value for this Account.
     * 
     * @return accountFinancialStatus
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.AccountFinancialStatus getAccountFinancialStatus() {
        return accountFinancialStatus;
    }


    /**
     * Sets the accountFinancialStatus value for this Account.
     * 
     * @param accountFinancialStatus
     */
    public void setAccountFinancialStatus(com.microsoft.adcenter.api.customermanagement.Entities.AccountFinancialStatus accountFinancialStatus) {
        this.accountFinancialStatus = accountFinancialStatus;
    }


    /**
     * Gets the id value for this Account.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this Account.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the language value for this Account.
     * 
     * @return language
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.LanguageType getLanguage() {
        return language;
    }


    /**
     * Sets the language value for this Account.
     * 
     * @param language
     */
    public void setLanguage(com.microsoft.adcenter.api.customermanagement.Entities.LanguageType language) {
        this.language = language;
    }


    /**
     * Gets the lastModifiedByUserId value for this Account.
     * 
     * @return lastModifiedByUserId
     */
    public java.lang.Long getLastModifiedByUserId() {
        return lastModifiedByUserId;
    }


    /**
     * Sets the lastModifiedByUserId value for this Account.
     * 
     * @param lastModifiedByUserId
     */
    public void setLastModifiedByUserId(java.lang.Long lastModifiedByUserId) {
        this.lastModifiedByUserId = lastModifiedByUserId;
    }


    /**
     * Gets the lastModifiedTime value for this Account.
     * 
     * @return lastModifiedTime
     */
    public java.util.Calendar getLastModifiedTime() {
        return lastModifiedTime;
    }


    /**
     * Sets the lastModifiedTime value for this Account.
     * 
     * @param lastModifiedTime
     */
    public void setLastModifiedTime(java.util.Calendar lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }


    /**
     * Gets the name value for this Account.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Account.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the number value for this Account.
     * 
     * @return number
     */
    public java.lang.String getNumber() {
        return number;
    }


    /**
     * Sets the number value for this Account.
     * 
     * @param number
     */
    public void setNumber(java.lang.String number) {
        this.number = number;
    }


    /**
     * Gets the parentCustomerId value for this Account.
     * 
     * @return parentCustomerId
     */
    public java.lang.Long getParentCustomerId() {
        return parentCustomerId;
    }


    /**
     * Sets the parentCustomerId value for this Account.
     * 
     * @param parentCustomerId
     */
    public void setParentCustomerId(java.lang.Long parentCustomerId) {
        this.parentCustomerId = parentCustomerId;
    }


    /**
     * Gets the paymentMethodId value for this Account.
     * 
     * @return paymentMethodId
     */
    public java.lang.Long getPaymentMethodId() {
        return paymentMethodId;
    }


    /**
     * Sets the paymentMethodId value for this Account.
     * 
     * @param paymentMethodId
     */
    public void setPaymentMethodId(java.lang.Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }


    /**
     * Gets the paymentMethodType value for this Account.
     * 
     * @return paymentMethodType
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.PaymentMethodType getPaymentMethodType() {
        return paymentMethodType;
    }


    /**
     * Sets the paymentMethodType value for this Account.
     * 
     * @param paymentMethodType
     */
    public void setPaymentMethodType(com.microsoft.adcenter.api.customermanagement.Entities.PaymentMethodType paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }


    /**
     * Gets the primaryUserId value for this Account.
     * 
     * @return primaryUserId
     */
    public java.lang.Long getPrimaryUserId() {
        return primaryUserId;
    }


    /**
     * Sets the primaryUserId value for this Account.
     * 
     * @param primaryUserId
     */
    public void setPrimaryUserId(java.lang.Long primaryUserId) {
        this.primaryUserId = primaryUserId;
    }


    /**
     * Gets the accountLifeCycleStatus value for this Account.
     * 
     * @return accountLifeCycleStatus
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.AccountLifeCycleStatus getAccountLifeCycleStatus() {
        return accountLifeCycleStatus;
    }


    /**
     * Sets the accountLifeCycleStatus value for this Account.
     * 
     * @param accountLifeCycleStatus
     */
    public void setAccountLifeCycleStatus(com.microsoft.adcenter.api.customermanagement.Entities.AccountLifeCycleStatus accountLifeCycleStatus) {
        this.accountLifeCycleStatus = accountLifeCycleStatus;
    }


    /**
     * Gets the timeStamp value for this Account.
     * 
     * @return timeStamp
     */
    public byte[] getTimeStamp() {
        return timeStamp;
    }


    /**
     * Sets the timeStamp value for this Account.
     * 
     * @param timeStamp
     */
    public void setTimeStamp(byte[] timeStamp) {
        this.timeStamp = timeStamp;
    }


    /**
     * Gets the timeZone value for this Account.
     * 
     * @return timeZone
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.TimeZoneType getTimeZone() {
        return timeZone;
    }


    /**
     * Sets the timeZone value for this Account.
     * 
     * @param timeZone
     */
    public void setTimeZone(com.microsoft.adcenter.api.customermanagement.Entities.TimeZoneType timeZone) {
        this.timeZone = timeZone;
    }


    /**
     * Gets the pauseReason value for this Account.
     * 
     * @return pauseReason
     */
    public org.apache.axis.types.UnsignedByte getPauseReason() {
        return pauseReason;
    }


    /**
     * Sets the pauseReason value for this Account.
     * 
     * @param pauseReason
     */
    public void setPauseReason(org.apache.axis.types.UnsignedByte pauseReason) {
        this.pauseReason = pauseReason;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Account)) return false;
        Account other = (Account) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountType==null && other.getAccountType()==null) || 
             (this.accountType!=null &&
              this.accountType.equals(other.getAccountType()))) &&
            ((this.billToCustomerId==null && other.getBillToCustomerId()==null) || 
             (this.billToCustomerId!=null &&
              this.billToCustomerId.equals(other.getBillToCustomerId()))) &&
            ((this.countryCode==null && other.getCountryCode()==null) || 
             (this.countryCode!=null &&
              this.countryCode.equals(other.getCountryCode()))) &&
            ((this.currencyType==null && other.getCurrencyType()==null) || 
             (this.currencyType!=null &&
              this.currencyType.equals(other.getCurrencyType()))) &&
            ((this.accountFinancialStatus==null && other.getAccountFinancialStatus()==null) || 
             (this.accountFinancialStatus!=null &&
              this.accountFinancialStatus.equals(other.getAccountFinancialStatus()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.language==null && other.getLanguage()==null) || 
             (this.language!=null &&
              this.language.equals(other.getLanguage()))) &&
            ((this.lastModifiedByUserId==null && other.getLastModifiedByUserId()==null) || 
             (this.lastModifiedByUserId!=null &&
              this.lastModifiedByUserId.equals(other.getLastModifiedByUserId()))) &&
            ((this.lastModifiedTime==null && other.getLastModifiedTime()==null) || 
             (this.lastModifiedTime!=null &&
              this.lastModifiedTime.equals(other.getLastModifiedTime()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.number==null && other.getNumber()==null) || 
             (this.number!=null &&
              this.number.equals(other.getNumber()))) &&
            ((this.parentCustomerId==null && other.getParentCustomerId()==null) || 
             (this.parentCustomerId!=null &&
              this.parentCustomerId.equals(other.getParentCustomerId()))) &&
            ((this.paymentMethodId==null && other.getPaymentMethodId()==null) || 
             (this.paymentMethodId!=null &&
              this.paymentMethodId.equals(other.getPaymentMethodId()))) &&
            ((this.paymentMethodType==null && other.getPaymentMethodType()==null) || 
             (this.paymentMethodType!=null &&
              this.paymentMethodType.equals(other.getPaymentMethodType()))) &&
            ((this.primaryUserId==null && other.getPrimaryUserId()==null) || 
             (this.primaryUserId!=null &&
              this.primaryUserId.equals(other.getPrimaryUserId()))) &&
            ((this.accountLifeCycleStatus==null && other.getAccountLifeCycleStatus()==null) || 
             (this.accountLifeCycleStatus!=null &&
              this.accountLifeCycleStatus.equals(other.getAccountLifeCycleStatus()))) &&
            ((this.timeStamp==null && other.getTimeStamp()==null) || 
             (this.timeStamp!=null &&
              java.util.Arrays.equals(this.timeStamp, other.getTimeStamp()))) &&
            ((this.timeZone==null && other.getTimeZone()==null) || 
             (this.timeZone!=null &&
              this.timeZone.equals(other.getTimeZone()))) &&
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
        if (getAccountType() != null) {
            _hashCode += getAccountType().hashCode();
        }
        if (getBillToCustomerId() != null) {
            _hashCode += getBillToCustomerId().hashCode();
        }
        if (getCountryCode() != null) {
            _hashCode += getCountryCode().hashCode();
        }
        if (getCurrencyType() != null) {
            _hashCode += getCurrencyType().hashCode();
        }
        if (getAccountFinancialStatus() != null) {
            _hashCode += getAccountFinancialStatus().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getLanguage() != null) {
            _hashCode += getLanguage().hashCode();
        }
        if (getLastModifiedByUserId() != null) {
            _hashCode += getLastModifiedByUserId().hashCode();
        }
        if (getLastModifiedTime() != null) {
            _hashCode += getLastModifiedTime().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getNumber() != null) {
            _hashCode += getNumber().hashCode();
        }
        if (getParentCustomerId() != null) {
            _hashCode += getParentCustomerId().hashCode();
        }
        if (getPaymentMethodId() != null) {
            _hashCode += getPaymentMethodId().hashCode();
        }
        if (getPaymentMethodType() != null) {
            _hashCode += getPaymentMethodType().hashCode();
        }
        if (getPrimaryUserId() != null) {
            _hashCode += getPrimaryUserId().hashCode();
        }
        if (getAccountLifeCycleStatus() != null) {
            _hashCode += getAccountLifeCycleStatus().hashCode();
        }
        if (getTimeStamp() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTimeStamp());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTimeStamp(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTimeZone() != null) {
            _hashCode += getTimeZone().hashCode();
        }
        if (getPauseReason() != null) {
            _hashCode += getPauseReason().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Account.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Account"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountType"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("billToCustomerId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "BillToCustomerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CountryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currencyType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CurrencyType"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CurrencyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountFinancialStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountFinancialStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountFinancialStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("language");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Language"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "LanguageType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastModifiedByUserId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "LastModifiedByUserId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastModifiedTime");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "LastModifiedTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
        elemField.setFieldName("parentCustomerId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ParentCustomerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentMethodId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "PaymentMethodId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentMethodType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "PaymentMethodType"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "PaymentMethodType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primaryUserId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "PrimaryUserId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountLifeCycleStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountLifeCycleStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountLifeCycleStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeStamp");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "TimeStamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeZone");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "TimeZone"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "TimeZoneType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
