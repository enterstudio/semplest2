/**
 * ManageAccountsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Entities;

public class ManageAccountsRequest  implements java.io.Serializable {
    private java.lang.String[] advertiserAccountNumbers;

    private java.lang.String agencyCustomerNumber;

    private com.microsoft.adcenter.api.customermanagement.Entities.Date effectiveDate;

    private java.lang.Long id;

    private java.lang.Long lastModifiedByUserId;

    private java.util.Calendar lastModifiedDateTime;

    private java.lang.String notes;

    private java.lang.Long paymentMethodId;

    private java.util.Calendar requestDate;

    private java.lang.String requesterContactEmail;

    private java.lang.String requesterContactName;

    private java.lang.String requesterContactPhoneNumber;

    private java.lang.String requesterCustomerNumber;

    private com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestStatus requestStatus;

    private java.lang.String[] requestStatusDetails;

    private com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestType requestType;

    private byte[] timeStamp;

    public ManageAccountsRequest() {
    }

    public ManageAccountsRequest(
           java.lang.String[] advertiserAccountNumbers,
           java.lang.String agencyCustomerNumber,
           com.microsoft.adcenter.api.customermanagement.Entities.Date effectiveDate,
           java.lang.Long id,
           java.lang.Long lastModifiedByUserId,
           java.util.Calendar lastModifiedDateTime,
           java.lang.String notes,
           java.lang.Long paymentMethodId,
           java.util.Calendar requestDate,
           java.lang.String requesterContactEmail,
           java.lang.String requesterContactName,
           java.lang.String requesterContactPhoneNumber,
           java.lang.String requesterCustomerNumber,
           com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestStatus requestStatus,
           java.lang.String[] requestStatusDetails,
           com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestType requestType,
           byte[] timeStamp) {
           this.advertiserAccountNumbers = advertiserAccountNumbers;
           this.agencyCustomerNumber = agencyCustomerNumber;
           this.effectiveDate = effectiveDate;
           this.id = id;
           this.lastModifiedByUserId = lastModifiedByUserId;
           this.lastModifiedDateTime = lastModifiedDateTime;
           this.notes = notes;
           this.paymentMethodId = paymentMethodId;
           this.requestDate = requestDate;
           this.requesterContactEmail = requesterContactEmail;
           this.requesterContactName = requesterContactName;
           this.requesterContactPhoneNumber = requesterContactPhoneNumber;
           this.requesterCustomerNumber = requesterCustomerNumber;
           this.requestStatus = requestStatus;
           this.requestStatusDetails = requestStatusDetails;
           this.requestType = requestType;
           this.timeStamp = timeStamp;
    }


    /**
     * Gets the advertiserAccountNumbers value for this ManageAccountsRequest.
     * 
     * @return advertiserAccountNumbers
     */
    public java.lang.String[] getAdvertiserAccountNumbers() {
        return advertiserAccountNumbers;
    }


    /**
     * Sets the advertiserAccountNumbers value for this ManageAccountsRequest.
     * 
     * @param advertiserAccountNumbers
     */
    public void setAdvertiserAccountNumbers(java.lang.String[] advertiserAccountNumbers) {
        this.advertiserAccountNumbers = advertiserAccountNumbers;
    }


    /**
     * Gets the agencyCustomerNumber value for this ManageAccountsRequest.
     * 
     * @return agencyCustomerNumber
     */
    public java.lang.String getAgencyCustomerNumber() {
        return agencyCustomerNumber;
    }


    /**
     * Sets the agencyCustomerNumber value for this ManageAccountsRequest.
     * 
     * @param agencyCustomerNumber
     */
    public void setAgencyCustomerNumber(java.lang.String agencyCustomerNumber) {
        this.agencyCustomerNumber = agencyCustomerNumber;
    }


    /**
     * Gets the effectiveDate value for this ManageAccountsRequest.
     * 
     * @return effectiveDate
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.Date getEffectiveDate() {
        return effectiveDate;
    }


    /**
     * Sets the effectiveDate value for this ManageAccountsRequest.
     * 
     * @param effectiveDate
     */
    public void setEffectiveDate(com.microsoft.adcenter.api.customermanagement.Entities.Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    /**
     * Gets the id value for this ManageAccountsRequest.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this ManageAccountsRequest.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the lastModifiedByUserId value for this ManageAccountsRequest.
     * 
     * @return lastModifiedByUserId
     */
    public java.lang.Long getLastModifiedByUserId() {
        return lastModifiedByUserId;
    }


    /**
     * Sets the lastModifiedByUserId value for this ManageAccountsRequest.
     * 
     * @param lastModifiedByUserId
     */
    public void setLastModifiedByUserId(java.lang.Long lastModifiedByUserId) {
        this.lastModifiedByUserId = lastModifiedByUserId;
    }


    /**
     * Gets the lastModifiedDateTime value for this ManageAccountsRequest.
     * 
     * @return lastModifiedDateTime
     */
    public java.util.Calendar getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }


    /**
     * Sets the lastModifiedDateTime value for this ManageAccountsRequest.
     * 
     * @param lastModifiedDateTime
     */
    public void setLastModifiedDateTime(java.util.Calendar lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }


    /**
     * Gets the notes value for this ManageAccountsRequest.
     * 
     * @return notes
     */
    public java.lang.String getNotes() {
        return notes;
    }


    /**
     * Sets the notes value for this ManageAccountsRequest.
     * 
     * @param notes
     */
    public void setNotes(java.lang.String notes) {
        this.notes = notes;
    }


    /**
     * Gets the paymentMethodId value for this ManageAccountsRequest.
     * 
     * @return paymentMethodId
     */
    public java.lang.Long getPaymentMethodId() {
        return paymentMethodId;
    }


    /**
     * Sets the paymentMethodId value for this ManageAccountsRequest.
     * 
     * @param paymentMethodId
     */
    public void setPaymentMethodId(java.lang.Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }


    /**
     * Gets the requestDate value for this ManageAccountsRequest.
     * 
     * @return requestDate
     */
    public java.util.Calendar getRequestDate() {
        return requestDate;
    }


    /**
     * Sets the requestDate value for this ManageAccountsRequest.
     * 
     * @param requestDate
     */
    public void setRequestDate(java.util.Calendar requestDate) {
        this.requestDate = requestDate;
    }


    /**
     * Gets the requesterContactEmail value for this ManageAccountsRequest.
     * 
     * @return requesterContactEmail
     */
    public java.lang.String getRequesterContactEmail() {
        return requesterContactEmail;
    }


    /**
     * Sets the requesterContactEmail value for this ManageAccountsRequest.
     * 
     * @param requesterContactEmail
     */
    public void setRequesterContactEmail(java.lang.String requesterContactEmail) {
        this.requesterContactEmail = requesterContactEmail;
    }


    /**
     * Gets the requesterContactName value for this ManageAccountsRequest.
     * 
     * @return requesterContactName
     */
    public java.lang.String getRequesterContactName() {
        return requesterContactName;
    }


    /**
     * Sets the requesterContactName value for this ManageAccountsRequest.
     * 
     * @param requesterContactName
     */
    public void setRequesterContactName(java.lang.String requesterContactName) {
        this.requesterContactName = requesterContactName;
    }


    /**
     * Gets the requesterContactPhoneNumber value for this ManageAccountsRequest.
     * 
     * @return requesterContactPhoneNumber
     */
    public java.lang.String getRequesterContactPhoneNumber() {
        return requesterContactPhoneNumber;
    }


    /**
     * Sets the requesterContactPhoneNumber value for this ManageAccountsRequest.
     * 
     * @param requesterContactPhoneNumber
     */
    public void setRequesterContactPhoneNumber(java.lang.String requesterContactPhoneNumber) {
        this.requesterContactPhoneNumber = requesterContactPhoneNumber;
    }


    /**
     * Gets the requesterCustomerNumber value for this ManageAccountsRequest.
     * 
     * @return requesterCustomerNumber
     */
    public java.lang.String getRequesterCustomerNumber() {
        return requesterCustomerNumber;
    }


    /**
     * Sets the requesterCustomerNumber value for this ManageAccountsRequest.
     * 
     * @param requesterCustomerNumber
     */
    public void setRequesterCustomerNumber(java.lang.String requesterCustomerNumber) {
        this.requesterCustomerNumber = requesterCustomerNumber;
    }


    /**
     * Gets the requestStatus value for this ManageAccountsRequest.
     * 
     * @return requestStatus
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestStatus getRequestStatus() {
        return requestStatus;
    }


    /**
     * Sets the requestStatus value for this ManageAccountsRequest.
     * 
     * @param requestStatus
     */
    public void setRequestStatus(com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }


    /**
     * Gets the requestStatusDetails value for this ManageAccountsRequest.
     * 
     * @return requestStatusDetails
     */
    public java.lang.String[] getRequestStatusDetails() {
        return requestStatusDetails;
    }


    /**
     * Sets the requestStatusDetails value for this ManageAccountsRequest.
     * 
     * @param requestStatusDetails
     */
    public void setRequestStatusDetails(java.lang.String[] requestStatusDetails) {
        this.requestStatusDetails = requestStatusDetails;
    }


    /**
     * Gets the requestType value for this ManageAccountsRequest.
     * 
     * @return requestType
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestType getRequestType() {
        return requestType;
    }


    /**
     * Sets the requestType value for this ManageAccountsRequest.
     * 
     * @param requestType
     */
    public void setRequestType(com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestType requestType) {
        this.requestType = requestType;
    }


    /**
     * Gets the timeStamp value for this ManageAccountsRequest.
     * 
     * @return timeStamp
     */
    public byte[] getTimeStamp() {
        return timeStamp;
    }


    /**
     * Sets the timeStamp value for this ManageAccountsRequest.
     * 
     * @param timeStamp
     */
    public void setTimeStamp(byte[] timeStamp) {
        this.timeStamp = timeStamp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ManageAccountsRequest)) return false;
        ManageAccountsRequest other = (ManageAccountsRequest) obj;
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
            ((this.effectiveDate==null && other.getEffectiveDate()==null) || 
             (this.effectiveDate!=null &&
              this.effectiveDate.equals(other.getEffectiveDate()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.lastModifiedByUserId==null && other.getLastModifiedByUserId()==null) || 
             (this.lastModifiedByUserId!=null &&
              this.lastModifiedByUserId.equals(other.getLastModifiedByUserId()))) &&
            ((this.lastModifiedDateTime==null && other.getLastModifiedDateTime()==null) || 
             (this.lastModifiedDateTime!=null &&
              this.lastModifiedDateTime.equals(other.getLastModifiedDateTime()))) &&
            ((this.notes==null && other.getNotes()==null) || 
             (this.notes!=null &&
              this.notes.equals(other.getNotes()))) &&
            ((this.paymentMethodId==null && other.getPaymentMethodId()==null) || 
             (this.paymentMethodId!=null &&
              this.paymentMethodId.equals(other.getPaymentMethodId()))) &&
            ((this.requestDate==null && other.getRequestDate()==null) || 
             (this.requestDate!=null &&
              this.requestDate.equals(other.getRequestDate()))) &&
            ((this.requesterContactEmail==null && other.getRequesterContactEmail()==null) || 
             (this.requesterContactEmail!=null &&
              this.requesterContactEmail.equals(other.getRequesterContactEmail()))) &&
            ((this.requesterContactName==null && other.getRequesterContactName()==null) || 
             (this.requesterContactName!=null &&
              this.requesterContactName.equals(other.getRequesterContactName()))) &&
            ((this.requesterContactPhoneNumber==null && other.getRequesterContactPhoneNumber()==null) || 
             (this.requesterContactPhoneNumber!=null &&
              this.requesterContactPhoneNumber.equals(other.getRequesterContactPhoneNumber()))) &&
            ((this.requesterCustomerNumber==null && other.getRequesterCustomerNumber()==null) || 
             (this.requesterCustomerNumber!=null &&
              this.requesterCustomerNumber.equals(other.getRequesterCustomerNumber()))) &&
            ((this.requestStatus==null && other.getRequestStatus()==null) || 
             (this.requestStatus!=null &&
              this.requestStatus.equals(other.getRequestStatus()))) &&
            ((this.requestStatusDetails==null && other.getRequestStatusDetails()==null) || 
             (this.requestStatusDetails!=null &&
              java.util.Arrays.equals(this.requestStatusDetails, other.getRequestStatusDetails()))) &&
            ((this.requestType==null && other.getRequestType()==null) || 
             (this.requestType!=null &&
              this.requestType.equals(other.getRequestType()))) &&
            ((this.timeStamp==null && other.getTimeStamp()==null) || 
             (this.timeStamp!=null &&
              java.util.Arrays.equals(this.timeStamp, other.getTimeStamp())));
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
        if (getEffectiveDate() != null) {
            _hashCode += getEffectiveDate().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getLastModifiedByUserId() != null) {
            _hashCode += getLastModifiedByUserId().hashCode();
        }
        if (getLastModifiedDateTime() != null) {
            _hashCode += getLastModifiedDateTime().hashCode();
        }
        if (getNotes() != null) {
            _hashCode += getNotes().hashCode();
        }
        if (getPaymentMethodId() != null) {
            _hashCode += getPaymentMethodId().hashCode();
        }
        if (getRequestDate() != null) {
            _hashCode += getRequestDate().hashCode();
        }
        if (getRequesterContactEmail() != null) {
            _hashCode += getRequesterContactEmail().hashCode();
        }
        if (getRequesterContactName() != null) {
            _hashCode += getRequesterContactName().hashCode();
        }
        if (getRequesterContactPhoneNumber() != null) {
            _hashCode += getRequesterContactPhoneNumber().hashCode();
        }
        if (getRequesterCustomerNumber() != null) {
            _hashCode += getRequesterCustomerNumber().hashCode();
        }
        if (getRequestStatus() != null) {
            _hashCode += getRequestStatus().hashCode();
        }
        if (getRequestStatusDetails() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRequestStatusDetails());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRequestStatusDetails(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRequestType() != null) {
            _hashCode += getRequestType().hashCode();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ManageAccountsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequest"));
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
        elemField.setFieldName("lastModifiedByUserId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "LastModifiedByUserId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastModifiedDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "LastModifiedDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notes");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Notes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentMethodId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "PaymentMethodId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("requesterContactEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "RequesterContactEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requesterContactName");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "RequesterContactName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requesterContactPhoneNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "RequesterContactPhoneNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requesterCustomerNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "RequesterCustomerNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "RequestStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestStatusDetails");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "RequestStatusDetails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "RequestType"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestType"));
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
