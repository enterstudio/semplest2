/**
 * GetNotificationsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.notifications;

public class GetNotificationsRequest  implements java.io.Serializable {
    private java.lang.String[] notificationTypes;

    private java.lang.Integer topN;

    public GetNotificationsRequest() {
    }

    public GetNotificationsRequest(
           java.lang.String[] notificationTypes,
           java.lang.Integer topN) {
           this.notificationTypes = notificationTypes;
           this.topN = topN;
    }


    /**
     * Gets the notificationTypes value for this GetNotificationsRequest.
     * 
     * @return notificationTypes
     */
    public java.lang.String[] getNotificationTypes() {
        return notificationTypes;
    }


    /**
     * Sets the notificationTypes value for this GetNotificationsRequest.
     * 
     * @param notificationTypes
     */
    public void setNotificationTypes(java.lang.String[] notificationTypes) {
        this.notificationTypes = notificationTypes;
    }


    /**
     * Gets the topN value for this GetNotificationsRequest.
     * 
     * @return topN
     */
    public java.lang.Integer getTopN() {
        return topN;
    }


    /**
     * Sets the topN value for this GetNotificationsRequest.
     * 
     * @param topN
     */
    public void setTopN(java.lang.Integer topN) {
        this.topN = topN;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetNotificationsRequest)) return false;
        GetNotificationsRequest other = (GetNotificationsRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.notificationTypes==null && other.getNotificationTypes()==null) || 
             (this.notificationTypes!=null &&
              java.util.Arrays.equals(this.notificationTypes, other.getNotificationTypes()))) &&
            ((this.topN==null && other.getTopN()==null) || 
             (this.topN!=null &&
              this.topN.equals(other.getTopN())));
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
        if (getNotificationTypes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNotificationTypes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNotificationTypes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTopN() != null) {
            _hashCode += getTopN().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetNotificationsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", ">GetNotificationsRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notificationTypes");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "NotificationTypes"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications/Entities", "NotificationType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("topN");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "TopN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
