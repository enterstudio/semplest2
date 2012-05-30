/**
 * InsertionOrder.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Entities;

public class InsertionOrder  implements java.io.Serializable {
    private java.lang.Long accountId;

    private java.lang.Double balanceAmount;

    private java.lang.String bookingCountryCode;

    private java.lang.String comment;

    private java.util.Calendar endDate;

    private java.lang.Long insertionOrderId;

    private java.lang.Long lastModifiedByUserId;

    private java.util.Calendar lastModifiedTime;

    private java.lang.Double notificationThreshold;

    private java.lang.Long referenceId;

    private java.lang.Double spendCapAmount;

    private java.util.Calendar startDate;

    public InsertionOrder() {
    }

    public InsertionOrder(
           java.lang.Long accountId,
           java.lang.Double balanceAmount,
           java.lang.String bookingCountryCode,
           java.lang.String comment,
           java.util.Calendar endDate,
           java.lang.Long insertionOrderId,
           java.lang.Long lastModifiedByUserId,
           java.util.Calendar lastModifiedTime,
           java.lang.Double notificationThreshold,
           java.lang.Long referenceId,
           java.lang.Double spendCapAmount,
           java.util.Calendar startDate) {
           this.accountId = accountId;
           this.balanceAmount = balanceAmount;
           this.bookingCountryCode = bookingCountryCode;
           this.comment = comment;
           this.endDate = endDate;
           this.insertionOrderId = insertionOrderId;
           this.lastModifiedByUserId = lastModifiedByUserId;
           this.lastModifiedTime = lastModifiedTime;
           this.notificationThreshold = notificationThreshold;
           this.referenceId = referenceId;
           this.spendCapAmount = spendCapAmount;
           this.startDate = startDate;
    }


    /**
     * Gets the accountId value for this InsertionOrder.
     * 
     * @return accountId
     */
    public java.lang.Long getAccountId() {
        return accountId;
    }


    /**
     * Sets the accountId value for this InsertionOrder.
     * 
     * @param accountId
     */
    public void setAccountId(java.lang.Long accountId) {
        this.accountId = accountId;
    }


    /**
     * Gets the balanceAmount value for this InsertionOrder.
     * 
     * @return balanceAmount
     */
    public java.lang.Double getBalanceAmount() {
        return balanceAmount;
    }


    /**
     * Sets the balanceAmount value for this InsertionOrder.
     * 
     * @param balanceAmount
     */
    public void setBalanceAmount(java.lang.Double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }


    /**
     * Gets the bookingCountryCode value for this InsertionOrder.
     * 
     * @return bookingCountryCode
     */
    public java.lang.String getBookingCountryCode() {
        return bookingCountryCode;
    }


    /**
     * Sets the bookingCountryCode value for this InsertionOrder.
     * 
     * @param bookingCountryCode
     */
    public void setBookingCountryCode(java.lang.String bookingCountryCode) {
        this.bookingCountryCode = bookingCountryCode;
    }


    /**
     * Gets the comment value for this InsertionOrder.
     * 
     * @return comment
     */
    public java.lang.String getComment() {
        return comment;
    }


    /**
     * Sets the comment value for this InsertionOrder.
     * 
     * @param comment
     */
    public void setComment(java.lang.String comment) {
        this.comment = comment;
    }


    /**
     * Gets the endDate value for this InsertionOrder.
     * 
     * @return endDate
     */
    public java.util.Calendar getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this InsertionOrder.
     * 
     * @param endDate
     */
    public void setEndDate(java.util.Calendar endDate) {
        this.endDate = endDate;
    }


    /**
     * Gets the insertionOrderId value for this InsertionOrder.
     * 
     * @return insertionOrderId
     */
    public java.lang.Long getInsertionOrderId() {
        return insertionOrderId;
    }


    /**
     * Sets the insertionOrderId value for this InsertionOrder.
     * 
     * @param insertionOrderId
     */
    public void setInsertionOrderId(java.lang.Long insertionOrderId) {
        this.insertionOrderId = insertionOrderId;
    }


    /**
     * Gets the lastModifiedByUserId value for this InsertionOrder.
     * 
     * @return lastModifiedByUserId
     */
    public java.lang.Long getLastModifiedByUserId() {
        return lastModifiedByUserId;
    }


    /**
     * Sets the lastModifiedByUserId value for this InsertionOrder.
     * 
     * @param lastModifiedByUserId
     */
    public void setLastModifiedByUserId(java.lang.Long lastModifiedByUserId) {
        this.lastModifiedByUserId = lastModifiedByUserId;
    }


    /**
     * Gets the lastModifiedTime value for this InsertionOrder.
     * 
     * @return lastModifiedTime
     */
    public java.util.Calendar getLastModifiedTime() {
        return lastModifiedTime;
    }


    /**
     * Sets the lastModifiedTime value for this InsertionOrder.
     * 
     * @param lastModifiedTime
     */
    public void setLastModifiedTime(java.util.Calendar lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }


    /**
     * Gets the notificationThreshold value for this InsertionOrder.
     * 
     * @return notificationThreshold
     */
    public java.lang.Double getNotificationThreshold() {
        return notificationThreshold;
    }


    /**
     * Sets the notificationThreshold value for this InsertionOrder.
     * 
     * @param notificationThreshold
     */
    public void setNotificationThreshold(java.lang.Double notificationThreshold) {
        this.notificationThreshold = notificationThreshold;
    }


    /**
     * Gets the referenceId value for this InsertionOrder.
     * 
     * @return referenceId
     */
    public java.lang.Long getReferenceId() {
        return referenceId;
    }


    /**
     * Sets the referenceId value for this InsertionOrder.
     * 
     * @param referenceId
     */
    public void setReferenceId(java.lang.Long referenceId) {
        this.referenceId = referenceId;
    }


    /**
     * Gets the spendCapAmount value for this InsertionOrder.
     * 
     * @return spendCapAmount
     */
    public java.lang.Double getSpendCapAmount() {
        return spendCapAmount;
    }


    /**
     * Sets the spendCapAmount value for this InsertionOrder.
     * 
     * @param spendCapAmount
     */
    public void setSpendCapAmount(java.lang.Double spendCapAmount) {
        this.spendCapAmount = spendCapAmount;
    }


    /**
     * Gets the startDate value for this InsertionOrder.
     * 
     * @return startDate
     */
    public java.util.Calendar getStartDate() {
        return startDate;
    }


    /**
     * Sets the startDate value for this InsertionOrder.
     * 
     * @param startDate
     */
    public void setStartDate(java.util.Calendar startDate) {
        this.startDate = startDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InsertionOrder)) return false;
        InsertionOrder other = (InsertionOrder) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountId==null && other.getAccountId()==null) || 
             (this.accountId!=null &&
              this.accountId.equals(other.getAccountId()))) &&
            ((this.balanceAmount==null && other.getBalanceAmount()==null) || 
             (this.balanceAmount!=null &&
              this.balanceAmount.equals(other.getBalanceAmount()))) &&
            ((this.bookingCountryCode==null && other.getBookingCountryCode()==null) || 
             (this.bookingCountryCode!=null &&
              this.bookingCountryCode.equals(other.getBookingCountryCode()))) &&
            ((this.comment==null && other.getComment()==null) || 
             (this.comment!=null &&
              this.comment.equals(other.getComment()))) &&
            ((this.endDate==null && other.getEndDate()==null) || 
             (this.endDate!=null &&
              this.endDate.equals(other.getEndDate()))) &&
            ((this.insertionOrderId==null && other.getInsertionOrderId()==null) || 
             (this.insertionOrderId!=null &&
              this.insertionOrderId.equals(other.getInsertionOrderId()))) &&
            ((this.lastModifiedByUserId==null && other.getLastModifiedByUserId()==null) || 
             (this.lastModifiedByUserId!=null &&
              this.lastModifiedByUserId.equals(other.getLastModifiedByUserId()))) &&
            ((this.lastModifiedTime==null && other.getLastModifiedTime()==null) || 
             (this.lastModifiedTime!=null &&
              this.lastModifiedTime.equals(other.getLastModifiedTime()))) &&
            ((this.notificationThreshold==null && other.getNotificationThreshold()==null) || 
             (this.notificationThreshold!=null &&
              this.notificationThreshold.equals(other.getNotificationThreshold()))) &&
            ((this.referenceId==null && other.getReferenceId()==null) || 
             (this.referenceId!=null &&
              this.referenceId.equals(other.getReferenceId()))) &&
            ((this.spendCapAmount==null && other.getSpendCapAmount()==null) || 
             (this.spendCapAmount!=null &&
              this.spendCapAmount.equals(other.getSpendCapAmount()))) &&
            ((this.startDate==null && other.getStartDate()==null) || 
             (this.startDate!=null &&
              this.startDate.equals(other.getStartDate())));
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
        if (getAccountId() != null) {
            _hashCode += getAccountId().hashCode();
        }
        if (getBalanceAmount() != null) {
            _hashCode += getBalanceAmount().hashCode();
        }
        if (getBookingCountryCode() != null) {
            _hashCode += getBookingCountryCode().hashCode();
        }
        if (getComment() != null) {
            _hashCode += getComment().hashCode();
        }
        if (getEndDate() != null) {
            _hashCode += getEndDate().hashCode();
        }
        if (getInsertionOrderId() != null) {
            _hashCode += getInsertionOrderId().hashCode();
        }
        if (getLastModifiedByUserId() != null) {
            _hashCode += getLastModifiedByUserId().hashCode();
        }
        if (getLastModifiedTime() != null) {
            _hashCode += getLastModifiedTime().hashCode();
        }
        if (getNotificationThreshold() != null) {
            _hashCode += getNotificationThreshold().hashCode();
        }
        if (getReferenceId() != null) {
            _hashCode += getReferenceId().hashCode();
        }
        if (getSpendCapAmount() != null) {
            _hashCode += getSpendCapAmount().hashCode();
        }
        if (getStartDate() != null) {
            _hashCode += getStartDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InsertionOrder.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "InsertionOrder"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("balanceAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "BalanceAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bookingCountryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "BookingCountryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comment");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Comment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "EndDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insertionOrderId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "InsertionOrderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("notificationThreshold");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "NotificationThreshold"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenceId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ReferenceId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("spendCapAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "SpendCapAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "StartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
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
