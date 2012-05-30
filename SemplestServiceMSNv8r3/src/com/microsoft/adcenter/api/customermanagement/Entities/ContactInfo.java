/**
 * ContactInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Entities;

public class ContactInfo  implements java.io.Serializable {
    private com.microsoft.adcenter.api.customermanagement.Entities.Address address;

    private java.lang.Boolean contactByPhone;

    private java.lang.Boolean contactByPostalMail;

    private java.lang.String email;

    private com.microsoft.adcenter.api.customermanagement.Entities.EmailFormat emailFormat;

    private java.lang.String fax;

    private java.lang.String homePhone;

    private java.lang.Long id;

    private java.lang.String mobile;

    private java.lang.String phone1;

    private java.lang.String phone2;

    public ContactInfo() {
    }

    public ContactInfo(
           com.microsoft.adcenter.api.customermanagement.Entities.Address address,
           java.lang.Boolean contactByPhone,
           java.lang.Boolean contactByPostalMail,
           java.lang.String email,
           com.microsoft.adcenter.api.customermanagement.Entities.EmailFormat emailFormat,
           java.lang.String fax,
           java.lang.String homePhone,
           java.lang.Long id,
           java.lang.String mobile,
           java.lang.String phone1,
           java.lang.String phone2) {
           this.address = address;
           this.contactByPhone = contactByPhone;
           this.contactByPostalMail = contactByPostalMail;
           this.email = email;
           this.emailFormat = emailFormat;
           this.fax = fax;
           this.homePhone = homePhone;
           this.id = id;
           this.mobile = mobile;
           this.phone1 = phone1;
           this.phone2 = phone2;
    }


    /**
     * Gets the address value for this ContactInfo.
     * 
     * @return address
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.Address getAddress() {
        return address;
    }


    /**
     * Sets the address value for this ContactInfo.
     * 
     * @param address
     */
    public void setAddress(com.microsoft.adcenter.api.customermanagement.Entities.Address address) {
        this.address = address;
    }


    /**
     * Gets the contactByPhone value for this ContactInfo.
     * 
     * @return contactByPhone
     */
    public java.lang.Boolean getContactByPhone() {
        return contactByPhone;
    }


    /**
     * Sets the contactByPhone value for this ContactInfo.
     * 
     * @param contactByPhone
     */
    public void setContactByPhone(java.lang.Boolean contactByPhone) {
        this.contactByPhone = contactByPhone;
    }


    /**
     * Gets the contactByPostalMail value for this ContactInfo.
     * 
     * @return contactByPostalMail
     */
    public java.lang.Boolean getContactByPostalMail() {
        return contactByPostalMail;
    }


    /**
     * Sets the contactByPostalMail value for this ContactInfo.
     * 
     * @param contactByPostalMail
     */
    public void setContactByPostalMail(java.lang.Boolean contactByPostalMail) {
        this.contactByPostalMail = contactByPostalMail;
    }


    /**
     * Gets the email value for this ContactInfo.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this ContactInfo.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the emailFormat value for this ContactInfo.
     * 
     * @return emailFormat
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.EmailFormat getEmailFormat() {
        return emailFormat;
    }


    /**
     * Sets the emailFormat value for this ContactInfo.
     * 
     * @param emailFormat
     */
    public void setEmailFormat(com.microsoft.adcenter.api.customermanagement.Entities.EmailFormat emailFormat) {
        this.emailFormat = emailFormat;
    }


    /**
     * Gets the fax value for this ContactInfo.
     * 
     * @return fax
     */
    public java.lang.String getFax() {
        return fax;
    }


    /**
     * Sets the fax value for this ContactInfo.
     * 
     * @param fax
     */
    public void setFax(java.lang.String fax) {
        this.fax = fax;
    }


    /**
     * Gets the homePhone value for this ContactInfo.
     * 
     * @return homePhone
     */
    public java.lang.String getHomePhone() {
        return homePhone;
    }


    /**
     * Sets the homePhone value for this ContactInfo.
     * 
     * @param homePhone
     */
    public void setHomePhone(java.lang.String homePhone) {
        this.homePhone = homePhone;
    }


    /**
     * Gets the id value for this ContactInfo.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this ContactInfo.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the mobile value for this ContactInfo.
     * 
     * @return mobile
     */
    public java.lang.String getMobile() {
        return mobile;
    }


    /**
     * Sets the mobile value for this ContactInfo.
     * 
     * @param mobile
     */
    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }


    /**
     * Gets the phone1 value for this ContactInfo.
     * 
     * @return phone1
     */
    public java.lang.String getPhone1() {
        return phone1;
    }


    /**
     * Sets the phone1 value for this ContactInfo.
     * 
     * @param phone1
     */
    public void setPhone1(java.lang.String phone1) {
        this.phone1 = phone1;
    }


    /**
     * Gets the phone2 value for this ContactInfo.
     * 
     * @return phone2
     */
    public java.lang.String getPhone2() {
        return phone2;
    }


    /**
     * Sets the phone2 value for this ContactInfo.
     * 
     * @param phone2
     */
    public void setPhone2(java.lang.String phone2) {
        this.phone2 = phone2;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ContactInfo)) return false;
        ContactInfo other = (ContactInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.contactByPhone==null && other.getContactByPhone()==null) || 
             (this.contactByPhone!=null &&
              this.contactByPhone.equals(other.getContactByPhone()))) &&
            ((this.contactByPostalMail==null && other.getContactByPostalMail()==null) || 
             (this.contactByPostalMail!=null &&
              this.contactByPostalMail.equals(other.getContactByPostalMail()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.emailFormat==null && other.getEmailFormat()==null) || 
             (this.emailFormat!=null &&
              this.emailFormat.equals(other.getEmailFormat()))) &&
            ((this.fax==null && other.getFax()==null) || 
             (this.fax!=null &&
              this.fax.equals(other.getFax()))) &&
            ((this.homePhone==null && other.getHomePhone()==null) || 
             (this.homePhone!=null &&
              this.homePhone.equals(other.getHomePhone()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.mobile==null && other.getMobile()==null) || 
             (this.mobile!=null &&
              this.mobile.equals(other.getMobile()))) &&
            ((this.phone1==null && other.getPhone1()==null) || 
             (this.phone1!=null &&
              this.phone1.equals(other.getPhone1()))) &&
            ((this.phone2==null && other.getPhone2()==null) || 
             (this.phone2!=null &&
              this.phone2.equals(other.getPhone2())));
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
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getContactByPhone() != null) {
            _hashCode += getContactByPhone().hashCode();
        }
        if (getContactByPostalMail() != null) {
            _hashCode += getContactByPostalMail().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getEmailFormat() != null) {
            _hashCode += getEmailFormat().hashCode();
        }
        if (getFax() != null) {
            _hashCode += getFax().hashCode();
        }
        if (getHomePhone() != null) {
            _hashCode += getHomePhone().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getMobile() != null) {
            _hashCode += getMobile().hashCode();
        }
        if (getPhone1() != null) {
            _hashCode += getPhone1().hashCode();
        }
        if (getPhone2() != null) {
            _hashCode += getPhone2().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ContactInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ContactInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Address"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Address"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactByPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ContactByPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactByPostalMail");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ContactByPostalMail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "EmailFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "EmailFormat"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fax");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Fax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("homePhone");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "HomePhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("mobile");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Mobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phone1");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Phone1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phone2");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Phone2"));
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
