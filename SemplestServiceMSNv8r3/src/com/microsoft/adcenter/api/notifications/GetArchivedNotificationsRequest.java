/**
 * GetArchivedNotificationsRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.notifications;

public class GetArchivedNotificationsRequest  implements java.io.Serializable {
    private java.lang.String[] notificationTypes;

    private java.lang.Integer topN;

    private java.util.Calendar startDate;

    private java.util.Calendar endDate;

    public GetArchivedNotificationsRequest() {
    }

    public GetArchivedNotificationsRequest(
           java.lang.String[] notificationTypes,
           java.lang.Integer topN,
           java.util.Calendar startDate,
           java.util.Calendar endDate) {
           this.notificationTypes = notificationTypes;
           this.topN = topN;
           this.startDate = startDate;
           this.endDate = endDate;
    }


    /**
     * Gets the notificationTypes value for this GetArchivedNotificationsRequest.
     * 
     * @return notificationTypes
     */
    public java.lang.String[] getNotificationTypes() {
        return notificationTypes;
    }


    /**
     * Sets the notificationTypes value for this GetArchivedNotificationsRequest.
     * 
     * @param notificationTypes
     */
    public void setNotificationTypes(java.lang.String[] notificationTypes) {
        this.notificationTypes = notificationTypes;
    }


    /**
     * Gets the topN value for this GetArchivedNotificationsRequest.
     * 
     * @return topN
     */
    public java.lang.Integer getTopN() {
        return topN;
    }


    /**
     * Sets the topN value for this GetArchivedNotificationsRequest.
     * 
     * @param topN
     */
    public void setTopN(java.lang.Integer topN) {
        this.topN = topN;
    }


    /**
     * Gets the startDate value for this GetArchivedNotificationsRequest.
     * 
     * @return startDate
     */
    public java.util.Calendar getStartDate() {
        return startDate;
    }


    /**
     * Sets the startDate value for this GetArchivedNotificationsRequest.
     * 
     * @param startDate
     */
    public void setStartDate(java.util.Calendar startDate) {
        this.startDate = startDate;
    }


    /**
     * Gets the endDate value for this GetArchivedNotificationsRequest.
     * 
     * @return endDate
     */
    public java.util.Calendar getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this GetArchivedNotificationsRequest.
     * 
     * @param endDate
     */
    public void setEndDate(java.util.Calendar endDate) {
        this.endDate = endDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetArchivedNotificationsRequest)) return false;
        GetArchivedNotificationsRequest other = (GetArchivedNotificationsRequest) obj;
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
              this.topN.equals(other.getTopN()))) &&
            ((this.startDate==null && other.getStartDate()==null) || 
             (this.startDate!=null &&
              this.startDate.equals(other.getStartDate()))) &&
            ((this.endDate==null && other.getEndDate()==null) || 
             (this.endDate!=null &&
              this.endDate.equals(other.getEndDate())));
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
        if (getStartDate() != null) {
            _hashCode += getStartDate().hashCode();
        }
        if (getEndDate() != null) {
            _hashCode += getEndDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetArchivedNotificationsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", ">GetArchivedNotificationsRequest"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "StartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/notifications", "EndDate"));
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
