/**
 * PollGenerateReportResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class PollGenerateReportResponse  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.ReportRequestStatus reportRequestStatus;

    public PollGenerateReportResponse() {
    }

    public PollGenerateReportResponse(
           com.microsoft.adcenter.v8.ReportRequestStatus reportRequestStatus) {
           this.reportRequestStatus = reportRequestStatus;
    }


    /**
     * Gets the reportRequestStatus value for this PollGenerateReportResponse.
     * 
     * @return reportRequestStatus
     */
    public com.microsoft.adcenter.v8.ReportRequestStatus getReportRequestStatus() {
        return reportRequestStatus;
    }


    /**
     * Sets the reportRequestStatus value for this PollGenerateReportResponse.
     * 
     * @param reportRequestStatus
     */
    public void setReportRequestStatus(com.microsoft.adcenter.v8.ReportRequestStatus reportRequestStatus) {
        this.reportRequestStatus = reportRequestStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PollGenerateReportResponse)) return false;
        PollGenerateReportResponse other = (PollGenerateReportResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.reportRequestStatus==null && other.getReportRequestStatus()==null) || 
             (this.reportRequestStatus!=null &&
              this.reportRequestStatus.equals(other.getReportRequestStatus())));
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
        if (getReportRequestStatus() != null) {
            _hashCode += getReportRequestStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PollGenerateReportResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PollGenerateReportResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportRequestStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportRequestStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportRequestStatus"));
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
