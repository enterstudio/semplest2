/**
 * User.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Entities;

public class User  implements java.io.Serializable {
    private com.microsoft.adcenter.api.customermanagement.Entities.ContactInfo contactInfo;

    private com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType customerAppScope;

    private java.lang.Long customerId;

    private java.lang.Long id;

    private java.lang.String jobTitle;

    private java.lang.Long lastModifiedByUserId;

    private java.util.Calendar lastModifiedTime;

    private com.microsoft.adcenter.api.customermanagement.Entities.LCID lcid;

    private com.microsoft.adcenter.api.customermanagement.Entities.PersonName name;

    private java.lang.String password;

    private java.lang.String secretAnswer;

    private com.microsoft.adcenter.api.customermanagement.Entities.SecretQuestion secretQuestion;

    private com.microsoft.adcenter.api.customermanagement.Entities.UserLifeCycleStatus userLifeCycleStatus;

    private byte[] timeStamp;

    private java.lang.String userName;

    public User() {
    }

    public User(
           com.microsoft.adcenter.api.customermanagement.Entities.ContactInfo contactInfo,
           com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType customerAppScope,
           java.lang.Long customerId,
           java.lang.Long id,
           java.lang.String jobTitle,
           java.lang.Long lastModifiedByUserId,
           java.util.Calendar lastModifiedTime,
           com.microsoft.adcenter.api.customermanagement.Entities.LCID lcid,
           com.microsoft.adcenter.api.customermanagement.Entities.PersonName name,
           java.lang.String password,
           java.lang.String secretAnswer,
           com.microsoft.adcenter.api.customermanagement.Entities.SecretQuestion secretQuestion,
           com.microsoft.adcenter.api.customermanagement.Entities.UserLifeCycleStatus userLifeCycleStatus,
           byte[] timeStamp,
           java.lang.String userName) {
           this.contactInfo = contactInfo;
           this.customerAppScope = customerAppScope;
           this.customerId = customerId;
           this.id = id;
           this.jobTitle = jobTitle;
           this.lastModifiedByUserId = lastModifiedByUserId;
           this.lastModifiedTime = lastModifiedTime;
           this.lcid = lcid;
           this.name = name;
           this.password = password;
           this.secretAnswer = secretAnswer;
           this.secretQuestion = secretQuestion;
           this.userLifeCycleStatus = userLifeCycleStatus;
           this.timeStamp = timeStamp;
           this.userName = userName;
    }


    /**
     * Gets the contactInfo value for this User.
     * 
     * @return contactInfo
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.ContactInfo getContactInfo() {
        return contactInfo;
    }


    /**
     * Sets the contactInfo value for this User.
     * 
     * @param contactInfo
     */
    public void setContactInfo(com.microsoft.adcenter.api.customermanagement.Entities.ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }


    /**
     * Gets the customerAppScope value for this User.
     * 
     * @return customerAppScope
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType getCustomerAppScope() {
        return customerAppScope;
    }


    /**
     * Sets the customerAppScope value for this User.
     * 
     * @param customerAppScope
     */
    public void setCustomerAppScope(com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType customerAppScope) {
        this.customerAppScope = customerAppScope;
    }


    /**
     * Gets the customerId value for this User.
     * 
     * @return customerId
     */
    public java.lang.Long getCustomerId() {
        return customerId;
    }


    /**
     * Sets the customerId value for this User.
     * 
     * @param customerId
     */
    public void setCustomerId(java.lang.Long customerId) {
        this.customerId = customerId;
    }


    /**
     * Gets the id value for this User.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this User.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the jobTitle value for this User.
     * 
     * @return jobTitle
     */
    public java.lang.String getJobTitle() {
        return jobTitle;
    }


    /**
     * Sets the jobTitle value for this User.
     * 
     * @param jobTitle
     */
    public void setJobTitle(java.lang.String jobTitle) {
        this.jobTitle = jobTitle;
    }


    /**
     * Gets the lastModifiedByUserId value for this User.
     * 
     * @return lastModifiedByUserId
     */
    public java.lang.Long getLastModifiedByUserId() {
        return lastModifiedByUserId;
    }


    /**
     * Sets the lastModifiedByUserId value for this User.
     * 
     * @param lastModifiedByUserId
     */
    public void setLastModifiedByUserId(java.lang.Long lastModifiedByUserId) {
        this.lastModifiedByUserId = lastModifiedByUserId;
    }


    /**
     * Gets the lastModifiedTime value for this User.
     * 
     * @return lastModifiedTime
     */
    public java.util.Calendar getLastModifiedTime() {
        return lastModifiedTime;
    }


    /**
     * Sets the lastModifiedTime value for this User.
     * 
     * @param lastModifiedTime
     */
    public void setLastModifiedTime(java.util.Calendar lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }


    /**
     * Gets the lcid value for this User.
     * 
     * @return lcid
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.LCID getLcid() {
        return lcid;
    }


    /**
     * Sets the lcid value for this User.
     * 
     * @param lcid
     */
    public void setLcid(com.microsoft.adcenter.api.customermanagement.Entities.LCID lcid) {
        this.lcid = lcid;
    }


    /**
     * Gets the name value for this User.
     * 
     * @return name
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.PersonName getName() {
        return name;
    }


    /**
     * Sets the name value for this User.
     * 
     * @param name
     */
    public void setName(com.microsoft.adcenter.api.customermanagement.Entities.PersonName name) {
        this.name = name;
    }


    /**
     * Gets the password value for this User.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this User.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the secretAnswer value for this User.
     * 
     * @return secretAnswer
     */
    public java.lang.String getSecretAnswer() {
        return secretAnswer;
    }


    /**
     * Sets the secretAnswer value for this User.
     * 
     * @param secretAnswer
     */
    public void setSecretAnswer(java.lang.String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }


    /**
     * Gets the secretQuestion value for this User.
     * 
     * @return secretQuestion
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.SecretQuestion getSecretQuestion() {
        return secretQuestion;
    }


    /**
     * Sets the secretQuestion value for this User.
     * 
     * @param secretQuestion
     */
    public void setSecretQuestion(com.microsoft.adcenter.api.customermanagement.Entities.SecretQuestion secretQuestion) {
        this.secretQuestion = secretQuestion;
    }


    /**
     * Gets the userLifeCycleStatus value for this User.
     * 
     * @return userLifeCycleStatus
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.UserLifeCycleStatus getUserLifeCycleStatus() {
        return userLifeCycleStatus;
    }


    /**
     * Sets the userLifeCycleStatus value for this User.
     * 
     * @param userLifeCycleStatus
     */
    public void setUserLifeCycleStatus(com.microsoft.adcenter.api.customermanagement.Entities.UserLifeCycleStatus userLifeCycleStatus) {
        this.userLifeCycleStatus = userLifeCycleStatus;
    }


    /**
     * Gets the timeStamp value for this User.
     * 
     * @return timeStamp
     */
    public byte[] getTimeStamp() {
        return timeStamp;
    }


    /**
     * Sets the timeStamp value for this User.
     * 
     * @param timeStamp
     */
    public void setTimeStamp(byte[] timeStamp) {
        this.timeStamp = timeStamp;
    }


    /**
     * Gets the userName value for this User.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this User.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof User)) return false;
        User other = (User) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contactInfo==null && other.getContactInfo()==null) || 
             (this.contactInfo!=null &&
              this.contactInfo.equals(other.getContactInfo()))) &&
            ((this.customerAppScope==null && other.getCustomerAppScope()==null) || 
             (this.customerAppScope!=null &&
              this.customerAppScope.equals(other.getCustomerAppScope()))) &&
            ((this.customerId==null && other.getCustomerId()==null) || 
             (this.customerId!=null &&
              this.customerId.equals(other.getCustomerId()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.jobTitle==null && other.getJobTitle()==null) || 
             (this.jobTitle!=null &&
              this.jobTitle.equals(other.getJobTitle()))) &&
            ((this.lastModifiedByUserId==null && other.getLastModifiedByUserId()==null) || 
             (this.lastModifiedByUserId!=null &&
              this.lastModifiedByUserId.equals(other.getLastModifiedByUserId()))) &&
            ((this.lastModifiedTime==null && other.getLastModifiedTime()==null) || 
             (this.lastModifiedTime!=null &&
              this.lastModifiedTime.equals(other.getLastModifiedTime()))) &&
            ((this.lcid==null && other.getLcid()==null) || 
             (this.lcid!=null &&
              this.lcid.equals(other.getLcid()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.secretAnswer==null && other.getSecretAnswer()==null) || 
             (this.secretAnswer!=null &&
              this.secretAnswer.equals(other.getSecretAnswer()))) &&
            ((this.secretQuestion==null && other.getSecretQuestion()==null) || 
             (this.secretQuestion!=null &&
              this.secretQuestion.equals(other.getSecretQuestion()))) &&
            ((this.userLifeCycleStatus==null && other.getUserLifeCycleStatus()==null) || 
             (this.userLifeCycleStatus!=null &&
              this.userLifeCycleStatus.equals(other.getUserLifeCycleStatus()))) &&
            ((this.timeStamp==null && other.getTimeStamp()==null) || 
             (this.timeStamp!=null &&
              java.util.Arrays.equals(this.timeStamp, other.getTimeStamp()))) &&
            ((this.userName==null && other.getUserName()==null) || 
             (this.userName!=null &&
              this.userName.equals(other.getUserName())));
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
        if (getContactInfo() != null) {
            _hashCode += getContactInfo().hashCode();
        }
        if (getCustomerAppScope() != null) {
            _hashCode += getCustomerAppScope().hashCode();
        }
        if (getCustomerId() != null) {
            _hashCode += getCustomerId().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getJobTitle() != null) {
            _hashCode += getJobTitle().hashCode();
        }
        if (getLastModifiedByUserId() != null) {
            _hashCode += getLastModifiedByUserId().hashCode();
        }
        if (getLastModifiedTime() != null) {
            _hashCode += getLastModifiedTime().hashCode();
        }
        if (getLcid() != null) {
            _hashCode += getLcid().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getSecretAnswer() != null) {
            _hashCode += getSecretAnswer().hashCode();
        }
        if (getSecretQuestion() != null) {
            _hashCode += getSecretQuestion().hashCode();
        }
        if (getUserLifeCycleStatus() != null) {
            _hashCode += getUserLifeCycleStatus().hashCode();
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
        if (getUserName() != null) {
            _hashCode += getUserName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(User.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "User"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contactInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ContactInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ContactInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerAppScope");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CustomerAppScope"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ApplicationType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "CustomerId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("jobTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "JobTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("lcid");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Lcid"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "LCID"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "PersonName"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secretAnswer");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "SecretAnswer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secretQuestion");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "SecretQuestion"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "SecretQuestion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userLifeCycleStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "UserLifeCycleStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "UserLifeCycleStatus"));
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
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "UserName"));
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
