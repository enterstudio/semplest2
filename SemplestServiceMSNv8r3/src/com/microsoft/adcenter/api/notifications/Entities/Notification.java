/**
 * Notification.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.notifications.Entities;

public class Notification  implements java.io.Serializable {
    private java.lang.Long notificationId;

    private java.util.Calendar notificationDate;

    private java.lang.String[] notificationType;

    public Notification() {
    }

    public Notification(
           java.lang.Long notificationId,
           java.util.Calendar notificationDate,
           java.lang.String[] notificationType) {
           this.notificationId = notificationId;
           this.notificationDate = notificationDate;
           this.notificationType = notificationType;
    }


    /**
     * Gets the notificationId value for this Notification.
     * 
     * @return notificationId
     */
    public java.lang.Long getNotificationId() {
        return notificationId;
    }


    /**
     * Sets the notificationId value for this Notification.
     * 
     * @param notificationId
     */
    public void setNotificationId(java.lang.Long notificationId) {
        this.notificationId = notificationId;
    }


    /**
     * Gets the notificationDate value for this Notification.
     * 
     * @return notificationDate
     */
    public java.util.Calendar getNotificationDate() {
        return notificationDate;
    }


    /**
     * Sets the notificationDate value for this Notification.
     * 
     * @param notificationDate
     */
    public void setNotificationDate(java.util.Calendar notificationDate) {
        this.notificationDate = notificationDate;
    }


    /**
     * Gets the notificationType value for this Notification.
     * 
     * @return notificationType
     */
    public java.lang.String[] getNotificationType() {
        return notificationType;
    }


    /**
     * Sets the notificationType value for this Notification.
     * 
     * @param notificationType
     */
    public void setNotificationType(java.lang.String[] notificationType) {
        this.notificationType = notificationType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Notification)) return false;
        Notification other = (Notification) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.notificationId==null && other.getNotificationId()==null) || 
             (this.notificationId!=null &&
              this.notificationId.equals(other.getNotificationId()))) &&
            ((this.notificationDate==null && other.getNotificationDate()==null) || 
             (this.notificationDate!=null &&
              this.notificationDate.equals(other.getNotificationDate()))) &&
            ((this.notificationType==null && other.getNotificationType()==null) || 
             (this.notificationType!=null &&
              java.util.Arrays.equals(this.notificationType, other.getNotificationType())));
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
        if (getNotificationId() != null) {
            _hashCode += getNotificationId().hashCode();
        }
        if (getNotificationDate() != null) {
            _hashCode += getNotificationDate().hashCode();
        }
        if (getNotificationType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNotificationType());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNotificationType(), i);
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
        new org.apache.axis.description.TypeDesc(Notification.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "Notification"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notificationId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "NotificationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notificationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "NotificationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notificationType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "NotificationType"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "NotificationType"));
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
