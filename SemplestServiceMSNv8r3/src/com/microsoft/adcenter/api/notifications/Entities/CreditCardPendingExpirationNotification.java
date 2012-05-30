/**
 * CreditCardPendingExpirationNotification.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.notifications.Entities;

public class CreditCardPendingExpirationNotification  extends com.microsoft.adcenter.api.notifications.Entities.AccountNotification  implements java.io.Serializable {
    private java.lang.String cardType;

    private java.lang.String lastFourDigits;

    private java.lang.String accountName;

    public CreditCardPendingExpirationNotification() {
    }

    public CreditCardPendingExpirationNotification(
           java.lang.Long notificationId,
           java.util.Calendar notificationDate,
           java.lang.String[] notificationType,
           java.lang.Long accountId,
           java.lang.String accountNumber,
           java.lang.String cardType,
           java.lang.String lastFourDigits,
           java.lang.String accountName) {
        super(
            notificationId,
            notificationDate,
            notificationType,
            accountId,
            accountNumber);
        this.cardType = cardType;
        this.lastFourDigits = lastFourDigits;
        this.accountName = accountName;
    }


    /**
     * Gets the cardType value for this CreditCardPendingExpirationNotification.
     * 
     * @return cardType
     */
    public java.lang.String getCardType() {
        return cardType;
    }


    /**
     * Sets the cardType value for this CreditCardPendingExpirationNotification.
     * 
     * @param cardType
     */
    public void setCardType(java.lang.String cardType) {
        this.cardType = cardType;
    }


    /**
     * Gets the lastFourDigits value for this CreditCardPendingExpirationNotification.
     * 
     * @return lastFourDigits
     */
    public java.lang.String getLastFourDigits() {
        return lastFourDigits;
    }


    /**
     * Sets the lastFourDigits value for this CreditCardPendingExpirationNotification.
     * 
     * @param lastFourDigits
     */
    public void setLastFourDigits(java.lang.String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }


    /**
     * Gets the accountName value for this CreditCardPendingExpirationNotification.
     * 
     * @return accountName
     */
    public java.lang.String getAccountName() {
        return accountName;
    }


    /**
     * Sets the accountName value for this CreditCardPendingExpirationNotification.
     * 
     * @param accountName
     */
    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreditCardPendingExpirationNotification)) return false;
        CreditCardPendingExpirationNotification other = (CreditCardPendingExpirationNotification) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cardType==null && other.getCardType()==null) || 
             (this.cardType!=null &&
              this.cardType.equals(other.getCardType()))) &&
            ((this.lastFourDigits==null && other.getLastFourDigits()==null) || 
             (this.lastFourDigits!=null &&
              this.lastFourDigits.equals(other.getLastFourDigits()))) &&
            ((this.accountName==null && other.getAccountName()==null) || 
             (this.accountName!=null &&
              this.accountName.equals(other.getAccountName())));
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
        if (getCardType() != null) {
            _hashCode += getCardType().hashCode();
        }
        if (getLastFourDigits() != null) {
            _hashCode += getLastFourDigits().hashCode();
        }
        if (getAccountName() != null) {
            _hashCode += getAccountName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreditCardPendingExpirationNotification.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "CreditCardPendingExpirationNotification"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "CardType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastFourDigits");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "LastFourDigits"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountName");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "AccountName"));
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
