/**
 * Business.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class Business  implements java.io.Serializable {
    private java.lang.String addressLine1;

    private java.lang.String addressLine2;

    private com.microsoft.adcenter.v8.BusinessImageIcon businessImageIcon;

    private java.lang.String city;

    private java.lang.String countryOrRegion;

    private java.lang.String description;

    private java.lang.String email;

    private com.microsoft.adcenter.v8.BusinessGeoCodeStatus geoCodeStatus;

    private com.microsoft.adcenter.v8.HoursOfOperation[] hrsOfOperation;

    private java.lang.Long id;

    private java.lang.Boolean isOpen24Hours;

    private java.lang.Double latitudeDegrees;

    private java.lang.Double longitudeDegrees;

    private java.lang.String name;

    private java.lang.String otherPaymentTypeDesc;

    private com.microsoft.adcenter.v8.PaymentType[] payment;

    private java.lang.String phone;

    private java.lang.String stateOrProvince;

    private com.microsoft.adcenter.v8.BusinessStatus status;

    private java.lang.String URL;

    private java.lang.String zipOrPostalCode;

    public Business() {
    }

    public Business(
           java.lang.String addressLine1,
           java.lang.String addressLine2,
           com.microsoft.adcenter.v8.BusinessImageIcon businessImageIcon,
           java.lang.String city,
           java.lang.String countryOrRegion,
           java.lang.String description,
           java.lang.String email,
           com.microsoft.adcenter.v8.BusinessGeoCodeStatus geoCodeStatus,
           com.microsoft.adcenter.v8.HoursOfOperation[] hrsOfOperation,
           java.lang.Long id,
           java.lang.Boolean isOpen24Hours,
           java.lang.Double latitudeDegrees,
           java.lang.Double longitudeDegrees,
           java.lang.String name,
           java.lang.String otherPaymentTypeDesc,
           com.microsoft.adcenter.v8.PaymentType[] payment,
           java.lang.String phone,
           java.lang.String stateOrProvince,
           com.microsoft.adcenter.v8.BusinessStatus status,
           java.lang.String URL,
           java.lang.String zipOrPostalCode) {
           this.addressLine1 = addressLine1;
           this.addressLine2 = addressLine2;
           this.businessImageIcon = businessImageIcon;
           this.city = city;
           this.countryOrRegion = countryOrRegion;
           this.description = description;
           this.email = email;
           this.geoCodeStatus = geoCodeStatus;
           this.hrsOfOperation = hrsOfOperation;
           this.id = id;
           this.isOpen24Hours = isOpen24Hours;
           this.latitudeDegrees = latitudeDegrees;
           this.longitudeDegrees = longitudeDegrees;
           this.name = name;
           this.otherPaymentTypeDesc = otherPaymentTypeDesc;
           this.payment = payment;
           this.phone = phone;
           this.stateOrProvince = stateOrProvince;
           this.status = status;
           this.URL = URL;
           this.zipOrPostalCode = zipOrPostalCode;
    }


    /**
     * Gets the addressLine1 value for this Business.
     * 
     * @return addressLine1
     */
    public java.lang.String getAddressLine1() {
        return addressLine1;
    }


    /**
     * Sets the addressLine1 value for this Business.
     * 
     * @param addressLine1
     */
    public void setAddressLine1(java.lang.String addressLine1) {
        this.addressLine1 = addressLine1;
    }


    /**
     * Gets the addressLine2 value for this Business.
     * 
     * @return addressLine2
     */
    public java.lang.String getAddressLine2() {
        return addressLine2;
    }


    /**
     * Sets the addressLine2 value for this Business.
     * 
     * @param addressLine2
     */
    public void setAddressLine2(java.lang.String addressLine2) {
        this.addressLine2 = addressLine2;
    }


    /**
     * Gets the businessImageIcon value for this Business.
     * 
     * @return businessImageIcon
     */
    public com.microsoft.adcenter.v8.BusinessImageIcon getBusinessImageIcon() {
        return businessImageIcon;
    }


    /**
     * Sets the businessImageIcon value for this Business.
     * 
     * @param businessImageIcon
     */
    public void setBusinessImageIcon(com.microsoft.adcenter.v8.BusinessImageIcon businessImageIcon) {
        this.businessImageIcon = businessImageIcon;
    }


    /**
     * Gets the city value for this Business.
     * 
     * @return city
     */
    public java.lang.String getCity() {
        return city;
    }


    /**
     * Sets the city value for this Business.
     * 
     * @param city
     */
    public void setCity(java.lang.String city) {
        this.city = city;
    }


    /**
     * Gets the countryOrRegion value for this Business.
     * 
     * @return countryOrRegion
     */
    public java.lang.String getCountryOrRegion() {
        return countryOrRegion;
    }


    /**
     * Sets the countryOrRegion value for this Business.
     * 
     * @param countryOrRegion
     */
    public void setCountryOrRegion(java.lang.String countryOrRegion) {
        this.countryOrRegion = countryOrRegion;
    }


    /**
     * Gets the description value for this Business.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Business.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the email value for this Business.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this Business.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the geoCodeStatus value for this Business.
     * 
     * @return geoCodeStatus
     */
    public com.microsoft.adcenter.v8.BusinessGeoCodeStatus getGeoCodeStatus() {
        return geoCodeStatus;
    }


    /**
     * Sets the geoCodeStatus value for this Business.
     * 
     * @param geoCodeStatus
     */
    public void setGeoCodeStatus(com.microsoft.adcenter.v8.BusinessGeoCodeStatus geoCodeStatus) {
        this.geoCodeStatus = geoCodeStatus;
    }


    /**
     * Gets the hrsOfOperation value for this Business.
     * 
     * @return hrsOfOperation
     */
    public com.microsoft.adcenter.v8.HoursOfOperation[] getHrsOfOperation() {
        return hrsOfOperation;
    }


    /**
     * Sets the hrsOfOperation value for this Business.
     * 
     * @param hrsOfOperation
     */
    public void setHrsOfOperation(com.microsoft.adcenter.v8.HoursOfOperation[] hrsOfOperation) {
        this.hrsOfOperation = hrsOfOperation;
    }


    /**
     * Gets the id value for this Business.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this Business.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the isOpen24Hours value for this Business.
     * 
     * @return isOpen24Hours
     */
    public java.lang.Boolean getIsOpen24Hours() {
        return isOpen24Hours;
    }


    /**
     * Sets the isOpen24Hours value for this Business.
     * 
     * @param isOpen24Hours
     */
    public void setIsOpen24Hours(java.lang.Boolean isOpen24Hours) {
        this.isOpen24Hours = isOpen24Hours;
    }


    /**
     * Gets the latitudeDegrees value for this Business.
     * 
     * @return latitudeDegrees
     */
    public java.lang.Double getLatitudeDegrees() {
        return latitudeDegrees;
    }


    /**
     * Sets the latitudeDegrees value for this Business.
     * 
     * @param latitudeDegrees
     */
    public void setLatitudeDegrees(java.lang.Double latitudeDegrees) {
        this.latitudeDegrees = latitudeDegrees;
    }


    /**
     * Gets the longitudeDegrees value for this Business.
     * 
     * @return longitudeDegrees
     */
    public java.lang.Double getLongitudeDegrees() {
        return longitudeDegrees;
    }


    /**
     * Sets the longitudeDegrees value for this Business.
     * 
     * @param longitudeDegrees
     */
    public void setLongitudeDegrees(java.lang.Double longitudeDegrees) {
        this.longitudeDegrees = longitudeDegrees;
    }


    /**
     * Gets the name value for this Business.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Business.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the otherPaymentTypeDesc value for this Business.
     * 
     * @return otherPaymentTypeDesc
     */
    public java.lang.String getOtherPaymentTypeDesc() {
        return otherPaymentTypeDesc;
    }


    /**
     * Sets the otherPaymentTypeDesc value for this Business.
     * 
     * @param otherPaymentTypeDesc
     */
    public void setOtherPaymentTypeDesc(java.lang.String otherPaymentTypeDesc) {
        this.otherPaymentTypeDesc = otherPaymentTypeDesc;
    }


    /**
     * Gets the payment value for this Business.
     * 
     * @return payment
     */
    public com.microsoft.adcenter.v8.PaymentType[] getPayment() {
        return payment;
    }


    /**
     * Sets the payment value for this Business.
     * 
     * @param payment
     */
    public void setPayment(com.microsoft.adcenter.v8.PaymentType[] payment) {
        this.payment = payment;
    }


    /**
     * Gets the phone value for this Business.
     * 
     * @return phone
     */
    public java.lang.String getPhone() {
        return phone;
    }


    /**
     * Sets the phone value for this Business.
     * 
     * @param phone
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }


    /**
     * Gets the stateOrProvince value for this Business.
     * 
     * @return stateOrProvince
     */
    public java.lang.String getStateOrProvince() {
        return stateOrProvince;
    }


    /**
     * Sets the stateOrProvince value for this Business.
     * 
     * @param stateOrProvince
     */
    public void setStateOrProvince(java.lang.String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }


    /**
     * Gets the status value for this Business.
     * 
     * @return status
     */
    public com.microsoft.adcenter.v8.BusinessStatus getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Business.
     * 
     * @param status
     */
    public void setStatus(com.microsoft.adcenter.v8.BusinessStatus status) {
        this.status = status;
    }


    /**
     * Gets the URL value for this Business.
     * 
     * @return URL
     */
    public java.lang.String getURL() {
        return URL;
    }


    /**
     * Sets the URL value for this Business.
     * 
     * @param URL
     */
    public void setURL(java.lang.String URL) {
        this.URL = URL;
    }


    /**
     * Gets the zipOrPostalCode value for this Business.
     * 
     * @return zipOrPostalCode
     */
    public java.lang.String getZipOrPostalCode() {
        return zipOrPostalCode;
    }


    /**
     * Sets the zipOrPostalCode value for this Business.
     * 
     * @param zipOrPostalCode
     */
    public void setZipOrPostalCode(java.lang.String zipOrPostalCode) {
        this.zipOrPostalCode = zipOrPostalCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Business)) return false;
        Business other = (Business) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.addressLine1==null && other.getAddressLine1()==null) || 
             (this.addressLine1!=null &&
              this.addressLine1.equals(other.getAddressLine1()))) &&
            ((this.addressLine2==null && other.getAddressLine2()==null) || 
             (this.addressLine2!=null &&
              this.addressLine2.equals(other.getAddressLine2()))) &&
            ((this.businessImageIcon==null && other.getBusinessImageIcon()==null) || 
             (this.businessImageIcon!=null &&
              this.businessImageIcon.equals(other.getBusinessImageIcon()))) &&
            ((this.city==null && other.getCity()==null) || 
             (this.city!=null &&
              this.city.equals(other.getCity()))) &&
            ((this.countryOrRegion==null && other.getCountryOrRegion()==null) || 
             (this.countryOrRegion!=null &&
              this.countryOrRegion.equals(other.getCountryOrRegion()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.geoCodeStatus==null && other.getGeoCodeStatus()==null) || 
             (this.geoCodeStatus!=null &&
              this.geoCodeStatus.equals(other.getGeoCodeStatus()))) &&
            ((this.hrsOfOperation==null && other.getHrsOfOperation()==null) || 
             (this.hrsOfOperation!=null &&
              java.util.Arrays.equals(this.hrsOfOperation, other.getHrsOfOperation()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.isOpen24Hours==null && other.getIsOpen24Hours()==null) || 
             (this.isOpen24Hours!=null &&
              this.isOpen24Hours.equals(other.getIsOpen24Hours()))) &&
            ((this.latitudeDegrees==null && other.getLatitudeDegrees()==null) || 
             (this.latitudeDegrees!=null &&
              this.latitudeDegrees.equals(other.getLatitudeDegrees()))) &&
            ((this.longitudeDegrees==null && other.getLongitudeDegrees()==null) || 
             (this.longitudeDegrees!=null &&
              this.longitudeDegrees.equals(other.getLongitudeDegrees()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.otherPaymentTypeDesc==null && other.getOtherPaymentTypeDesc()==null) || 
             (this.otherPaymentTypeDesc!=null &&
              this.otherPaymentTypeDesc.equals(other.getOtherPaymentTypeDesc()))) &&
            ((this.payment==null && other.getPayment()==null) || 
             (this.payment!=null &&
              java.util.Arrays.equals(this.payment, other.getPayment()))) &&
            ((this.phone==null && other.getPhone()==null) || 
             (this.phone!=null &&
              this.phone.equals(other.getPhone()))) &&
            ((this.stateOrProvince==null && other.getStateOrProvince()==null) || 
             (this.stateOrProvince!=null &&
              this.stateOrProvince.equals(other.getStateOrProvince()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.URL==null && other.getURL()==null) || 
             (this.URL!=null &&
              this.URL.equals(other.getURL()))) &&
            ((this.zipOrPostalCode==null && other.getZipOrPostalCode()==null) || 
             (this.zipOrPostalCode!=null &&
              this.zipOrPostalCode.equals(other.getZipOrPostalCode())));
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
        if (getAddressLine1() != null) {
            _hashCode += getAddressLine1().hashCode();
        }
        if (getAddressLine2() != null) {
            _hashCode += getAddressLine2().hashCode();
        }
        if (getBusinessImageIcon() != null) {
            _hashCode += getBusinessImageIcon().hashCode();
        }
        if (getCity() != null) {
            _hashCode += getCity().hashCode();
        }
        if (getCountryOrRegion() != null) {
            _hashCode += getCountryOrRegion().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getGeoCodeStatus() != null) {
            _hashCode += getGeoCodeStatus().hashCode();
        }
        if (getHrsOfOperation() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHrsOfOperation());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHrsOfOperation(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIsOpen24Hours() != null) {
            _hashCode += getIsOpen24Hours().hashCode();
        }
        if (getLatitudeDegrees() != null) {
            _hashCode += getLatitudeDegrees().hashCode();
        }
        if (getLongitudeDegrees() != null) {
            _hashCode += getLongitudeDegrees().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getOtherPaymentTypeDesc() != null) {
            _hashCode += getOtherPaymentTypeDesc().hashCode();
        }
        if (getPayment() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPayment());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPayment(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPhone() != null) {
            _hashCode += getPhone().hashCode();
        }
        if (getStateOrProvince() != null) {
            _hashCode += getStateOrProvince().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getURL() != null) {
            _hashCode += getURL().hashCode();
        }
        if (getZipOrPostalCode() != null) {
            _hashCode += getZipOrPostalCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Business.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Business"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressLine1");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddressLine1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressLine2");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddressLine2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessImageIcon");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessImageIcon"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessImageIcon"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("city");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "City"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countryOrRegion");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CountryOrRegion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("geoCodeStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GeoCodeStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessGeoCodeStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hrsOfOperation");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HrsOfOperation"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HoursOfOperation"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HoursOfOperation"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isOpen24Hours");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "IsOpen24Hours"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("latitudeDegrees");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "LatitudeDegrees"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("longitudeDegrees");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "LongitudeDegrees"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otherPaymentTypeDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "OtherPaymentTypeDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payment");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Payment"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PaymentType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PaymentType"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phone");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Phone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stateOrProvince");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "StateOrProvince"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("URL");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "URL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zipOrPostalCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ZipOrPostalCode"));
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
