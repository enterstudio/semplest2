/**
 * Customer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Entities;

public class Customer  implements java.io.Serializable {
    private com.microsoft.adcenter.api.customermanagement.Entities.Address customerAddress;

    private com.microsoft.adcenter.api.customermanagement.Entities.CustomerFinancialStatus customerFinancialStatus;

    private java.lang.Long id;

    private com.microsoft.adcenter.api.customermanagement.Entities.Industry industry;

    private java.lang.Long lastModifiedByUserId;

    private java.util.Calendar lastModifiedTime;

    private java.lang.String marketCountry;

    private com.microsoft.adcenter.api.customermanagement.Entities.LanguageType marketLanguage;

    private java.lang.String name;

    private com.microsoft.adcenter.api.customermanagement.Entities.ServiceLevel serviceLevel;

    private com.microsoft.adcenter.api.customermanagement.Entities.CustomerLifeCycleStatus customerLifeCycleStatus;

    private byte[] timeStamp;

    private java.lang.String number;

    public Customer() {
    }

    public Customer(
           com.microsoft.adcenter.api.customermanagement.Entities.Address customerAddress,
           com.microsoft.adcenter.api.customermanagement.Entities.CustomerFinancialStatus customerFinancialStatus,
           java.lang.Long id,
           com.microsoft.adcenter.api.customermanagement.Entities.Industry industry,
           java.lang.Long lastModifiedByUserId,
           java.util.Calendar lastModifiedTime,
           java.lang.String marketCountry,
           com.microsoft.adcenter.api.customermanagement.Entities.LanguageType marketLanguage,
           java.lang.String name,
           com.microsoft.adcenter.api.customermanagement.Entities.ServiceLevel serviceLevel,
           com.microsoft.adcenter.api.customermanagement.Entities.CustomerLifeCycleStatus customerLifeCycleStatus,
           byte[] timeStamp,
           java.lang.String number) {
           this.customerAddress = customerAddress;
           this.customerFinancialStatus = customerFinancialStatus;
           this.id = id;
           this.industry = industry;
           this.lastModifiedByUserId = lastModifiedByUserId;
           this.lastModifiedTime = lastModifiedTime;
           this.marketCountry = marketCountry;
           this.marketLanguage = marketLanguage;
           this.name = name;
           this.serviceLevel = serviceLevel;
           this.customerLifeCycleStatus = customerLifeCycleStatus;
           this.timeStamp = timeStamp;
           this.number = number;
    }


    /**
     * Gets the customerAddress value for this Customer.
     * 
     * @return customerAddress
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.Address getCustomerAddress() {
        return customerAddress;
    }


    /**
     * Sets the customerAddress value for this Customer.
     * 
     * @param customerAddress
     */
    public void setCustomerAddress(com.microsoft.adcenter.api.customermanagement.Entities.Address customerAddress) {
        this.customerAddress = customerAddress;
    }


    /**
     * Gets the customerFinancialStatus value for this Customer.
     * 
     * @return customerFinancialStatus
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.CustomerFinancialStatus getCustomerFinancialStatus() {
        return customerFinancialStatus;
    }


    /**
     * Sets the customerFinancialStatus value for this Customer.
     * 
     * @param customerFinancialStatus
     */
    public void setCustomerFinancialStatus(com.microsoft.adcenter.api.customermanagement.Entities.CustomerFinancialStatus customerFinancialStatus) {
        this.customerFinancialStatus = customerFinancialStatus;
    }


    /**
     * Gets the id value for this Customer.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this Customer.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the industry value for this Customer.
     * 
     * @return industry
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.Industry getIndustry() {
        return industry;
    }


    /**
     * Sets the industry value for this Customer.
     * 
     * @param industry
     */
    public void setIndustry(com.microsoft.adcenter.api.customermanagement.Entities.Industry industry) {
        this.industry = industry;
    }


    /**
     * Gets the lastModifiedByUserId value for this Customer.
     * 
     * @return lastModifiedByUserId
     */
    public java.lang.Long getLastModifiedByUserId() {
        return lastModifiedByUserId;
    }


    /**
     * Sets the lastModifiedByUserId value for this Customer.
     * 
     * @param lastModifiedByUserId
     */
    public void setLastModifiedByUserId(java.lang.Long lastModifiedByUserId) {
        this.lastModifiedByUserId = lastModifiedByUserId;
    }


    /**
     * Gets the lastModifiedTime value for this Customer.
     * 
     * @return lastModifiedTime
     */
    public java.util.Calendar getLastModifiedTime() {
        return lastModifiedTime;
    }


    /**
     * Sets the lastModifiedTime value for this Customer.
     * 
     * @param lastModifiedTime
     */
    public void setLastModifiedTime(java.util.Calendar lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }


    /**
     * Gets the marketCountry value for this Customer.
     * 
     * @return marketCountry
     */
    public java.lang.String getMarketCountry() {
        return marketCountry;
    }


    /**
     * Sets the marketCountry value for this Customer.
     * 
     * @param marketCountry
     */
    public void setMarketCountry(java.lang.String marketCountry) {
        this.marketCountry = marketCountry;
    }


    /**
     * Gets the marketLanguage value for this Customer.
     * 
     * @return marketLanguage
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.LanguageType getMarketLanguage() {
        return marketLanguage;
    }


    /**
     * Sets the marketLanguage value for this Customer.
     * 
     * @param marketLanguage
     */
    public void setMarketLanguage(com.microsoft.adcenter.api.customermanagement.Entities.LanguageType marketLanguage) {
        this.marketLanguage = marketLanguage;
    }


    /**
     * Gets the name value for this Customer.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Customer.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the serviceLevel value for this Customer.
     * 
     * @return serviceLevel
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.ServiceLevel getServiceLevel() {
        return serviceLevel;
    }


    /**
     * Sets the serviceLevel value for this Customer.
     * 
     * @param serviceLevel
     */
    public void setServiceLevel(com.microsoft.adcenter.api.customermanagement.Entities.ServiceLevel serviceLevel) {
        this.serviceLevel = serviceLevel;
    }


    /**
     * Gets the customerLifeCycleStatus value for this Customer.
     * 
     * @return customerLifeCycleStatus
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.CustomerLifeCycleStatus getCustomerLifeCycleStatus() {
        return customerLifeCycleStatus;
    }


    /**
     * Sets the customerLifeCycleStatus value for this Customer.
     * 
     * @param customerLifeCycleStatus
     */
    public void setCustomerLifeCycleStatus(com.microsoft.adcenter.api.customermanagement.Entities.CustomerLifeCycleStatus customerLifeCycleStatus) {
        this.customerLifeCycleStatus = customerLifeCycleStatus;
    }


    /**
     * Gets the timeStamp value for this Customer.
     * 
     * @return timeStamp
     */
    public byte[] getTimeStamp() {
        return timeStamp;
    }


    /**
     * Sets the timeStamp value for this Customer.
     * 
     * @param timeStamp
     */
    public void setTimeStamp(byte[] timeStamp) {
        this.timeStamp = timeStamp;
    }


    /**
     * Gets the number value for this Customer.
     * 
     * @return number
     */
    public java.lang.String getNumber() {
        return number;
    }


    /**
     * Sets the number value for this Customer.
     * 
     * @param number
     */
    public void setNumber(java.lang.String number) {
        this.number = number;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Customer)) return false;
        Customer other = (Customer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customerAddress==null && other.getCustomerAddress()==null) || 
             (this.customerAddress!=null &&
              this.customerAddress.equals(other.getCustomerAddress()))) &&
            ((this.customerFinancialStatus==null && other.getCustomerFinancialStatus()==null) || 
             (this.customerFinancialStatus!=null &&
              this.customerFinancialStatus.equals(other.getCustomerFinancialStatus()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.industry==null && other.getIndustry()==null) || 
             (this.industry!=null &&
              this.industry.equals(other.getIndustry()))) &&
            ((this.lastModifiedByUserId==null && other.getLastModifiedByUserId()==null) || 
             (this.lastModifiedByUserId!=null &&
              this.lastModifiedByUserId.equals(other.getLastModifiedByUserId()))) &&
            ((this.lastModifiedTime==null && other.getLastModifiedTime()==null) || 
             (this.lastModifiedTime!=null &&
              this.lastModifiedTime.equals(other.getLastModifiedTime()))) &&
            ((this.marketCountry==null && other.getMarketCountry()==null) || 
             (this.marketCountry!=null &&
              this.marketCountry.equals(other.getMarketCountry()))) &&
            ((this.marketLanguage==null && other.getMarketLanguage()==null) || 
             (this.marketLanguage!=null &&
              this.marketLanguage.equals(other.getMarketLanguage()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.serviceLevel==null && other.getServiceLevel()==null) || 
             (this.serviceLevel!=null &&
              this.serviceLevel.equals(other.getServiceLevel()))) &&
            ((this.customerLifeCycleStatus==null && other.getCustomerLifeCycleStatus()==null) || 
             (this.customerLifeCycleStatus!=null &&
              this.customerLifeCycleStatus.equals(other.getCustomerLifeCycleStatus()))) &&
            ((this.timeStamp==null && other.getTimeStamp()==null) || 
             (this.timeStamp!=null &&
              java.util.Arrays.equals(this.timeStamp, other.getTimeStamp()))) &&
            ((this.number==null && other.getNumber()==null) || 
             (this.number!=null &&
              this.number.equals(other.getNumber())));
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
        if (getCustomerAddress() != null) {
            _hashCode += getCustomerAddress().hashCode();
        }
        if (getCustomerFinancialStatus() != null) {
            _hashCode += getCustomerFinancialStatus().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIndustry() != null) {
            _hashCode += getIndustry().hashCode();
        }
        if (getLastModifiedByUserId() != null) {
            _hashCode += getLastModifiedByUserId().hashCode();
        }
        if (getLastModifiedTime() != null) {
            _hashCode += getLastModifiedTime().hashCode();
        }
        if (getMarketCountry() != null) {
            _hashCode += getMarketCountry().hashCode();
        }
        if (getMarketLanguage() != null) {
            _hashCode += getMarketLanguage().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getServiceLevel() != null) {
            _hashCode += getServiceLevel().hashCode();
        }
        if (getCustomerLifeCycleStatus() != null) {
            _hashCode += getCustomerLifeCycleStatus().hashCode();
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
        if (getNumber() != null) {
            _hashCode += getNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Customer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Customer"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CustomerAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Address"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerFinancialStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CustomerFinancialStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CustomerFinancialStatus"));
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
        elemField.setFieldName("industry");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Industry"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Industry"));
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
        elemField.setFieldName("marketCountry");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "MarketCountry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("marketLanguage");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "MarketLanguage"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "LanguageType"));
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
        elemField.setFieldName("serviceLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ServiceLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ServiceLevel"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerLifeCycleStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CustomerLifeCycleStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CustomerLifeCycleStatus"));
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
        elemField.setFieldName("number");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Number"));
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
