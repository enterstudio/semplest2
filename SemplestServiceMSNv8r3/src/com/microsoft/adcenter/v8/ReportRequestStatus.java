/**
 * ReportRequestStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class ReportRequestStatus  implements java.io.Serializable {
    private java.lang.String reportDownloadUrl;

    private com.microsoft.adcenter.v8.ReportRequestStatusType status;

    public ReportRequestStatus() {
    }

    public ReportRequestStatus(
           java.lang.String reportDownloadUrl,
           com.microsoft.adcenter.v8.ReportRequestStatusType status) {
           this.reportDownloadUrl = reportDownloadUrl;
           this.status = status;
    }


    /**
     * Gets the reportDownloadUrl value for this ReportRequestStatus.
     * 
     * @return reportDownloadUrl
     */
    public java.lang.String getReportDownloadUrl() {
        return reportDownloadUrl;
    }


    /**
     * Sets the reportDownloadUrl value for this ReportRequestStatus.
     * 
     * @param reportDownloadUrl
     */
    public void setReportDownloadUrl(java.lang.String reportDownloadUrl) {
        this.reportDownloadUrl = reportDownloadUrl;
    }


    /**
     * Gets the status value for this ReportRequestStatus.
     * 
     * @return status
     */
    public com.microsoft.adcenter.v8.ReportRequestStatusType getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ReportRequestStatus.
     * 
     * @param status
     */
    public void setStatus(com.microsoft.adcenter.v8.ReportRequestStatusType status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReportRequestStatus)) return false;
        ReportRequestStatus other = (ReportRequestStatus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.reportDownloadUrl==null && other.getReportDownloadUrl()==null) || 
             (this.reportDownloadUrl!=null &&
              this.reportDownloadUrl.equals(other.getReportDownloadUrl()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus())));
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
        if (getReportDownloadUrl() != null) {
            _hashCode += getReportDownloadUrl().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReportRequestStatus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportRequestStatus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportDownloadUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportDownloadUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportRequestStatusType"));
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
