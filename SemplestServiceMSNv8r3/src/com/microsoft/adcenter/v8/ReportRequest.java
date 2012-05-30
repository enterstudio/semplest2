/**
 * ReportRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class ReportRequest  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.ReportFormat format;

    private com.microsoft.adcenter.v8.ReportLanguage language;

    private java.lang.String reportName;

    private java.lang.Boolean returnOnlyCompleteData;

    public ReportRequest() {
    }

    public ReportRequest(
           com.microsoft.adcenter.v8.ReportFormat format,
           com.microsoft.adcenter.v8.ReportLanguage language,
           java.lang.String reportName,
           java.lang.Boolean returnOnlyCompleteData) {
           this.format = format;
           this.language = language;
           this.reportName = reportName;
           this.returnOnlyCompleteData = returnOnlyCompleteData;
    }


    /**
     * Gets the format value for this ReportRequest.
     * 
     * @return format
     */
    public com.microsoft.adcenter.v8.ReportFormat getFormat() {
        return format;
    }


    /**
     * Sets the format value for this ReportRequest.
     * 
     * @param format
     */
    public void setFormat(com.microsoft.adcenter.v8.ReportFormat format) {
        this.format = format;
    }


    /**
     * Gets the language value for this ReportRequest.
     * 
     * @return language
     */
    public com.microsoft.adcenter.v8.ReportLanguage getLanguage() {
        return language;
    }


    /**
     * Sets the language value for this ReportRequest.
     * 
     * @param language
     */
    public void setLanguage(com.microsoft.adcenter.v8.ReportLanguage language) {
        this.language = language;
    }


    /**
     * Gets the reportName value for this ReportRequest.
     * 
     * @return reportName
     */
    public java.lang.String getReportName() {
        return reportName;
    }


    /**
     * Sets the reportName value for this ReportRequest.
     * 
     * @param reportName
     */
    public void setReportName(java.lang.String reportName) {
        this.reportName = reportName;
    }


    /**
     * Gets the returnOnlyCompleteData value for this ReportRequest.
     * 
     * @return returnOnlyCompleteData
     */
    public java.lang.Boolean getReturnOnlyCompleteData() {
        return returnOnlyCompleteData;
    }


    /**
     * Sets the returnOnlyCompleteData value for this ReportRequest.
     * 
     * @param returnOnlyCompleteData
     */
    public void setReturnOnlyCompleteData(java.lang.Boolean returnOnlyCompleteData) {
        this.returnOnlyCompleteData = returnOnlyCompleteData;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReportRequest)) return false;
        ReportRequest other = (ReportRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.format==null && other.getFormat()==null) || 
             (this.format!=null &&
              this.format.equals(other.getFormat()))) &&
            ((this.language==null && other.getLanguage()==null) || 
             (this.language!=null &&
              this.language.equals(other.getLanguage()))) &&
            ((this.reportName==null && other.getReportName()==null) || 
             (this.reportName!=null &&
              this.reportName.equals(other.getReportName()))) &&
            ((this.returnOnlyCompleteData==null && other.getReturnOnlyCompleteData()==null) || 
             (this.returnOnlyCompleteData!=null &&
              this.returnOnlyCompleteData.equals(other.getReturnOnlyCompleteData())));
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
        if (getFormat() != null) {
            _hashCode += getFormat().hashCode();
        }
        if (getLanguage() != null) {
            _hashCode += getLanguage().hashCode();
        }
        if (getReportName() != null) {
            _hashCode += getReportName().hashCode();
        }
        if (getReturnOnlyCompleteData() != null) {
            _hashCode += getReturnOnlyCompleteData().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReportRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("format");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Format"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportFormat"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("language");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Language"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportLanguage"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reportName");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnOnlyCompleteData");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReturnOnlyCompleteData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
