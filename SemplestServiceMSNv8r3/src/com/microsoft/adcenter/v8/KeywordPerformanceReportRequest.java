/**
 * KeywordPerformanceReportRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class KeywordPerformanceReportRequest  extends com.microsoft.adcenter.v8.ReportRequest  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.ReportAggregation aggregation;

    private com.microsoft.adcenter.v8.KeywordPerformanceReportColumn[] columns;

    private com.microsoft.adcenter.v8.KeywordPerformanceReportFilter filter;

    private com.microsoft.adcenter.v8.AccountThroughAdGroupReportScope scope;

    private com.microsoft.adcenter.v8.ReportTime time;

    public KeywordPerformanceReportRequest() {
    }

    public KeywordPerformanceReportRequest(
           com.microsoft.adcenter.v8.ReportFormat format,
           com.microsoft.adcenter.v8.ReportLanguage language,
           java.lang.String reportName,
           java.lang.Boolean returnOnlyCompleteData,
           com.microsoft.adcenter.v8.ReportAggregation aggregation,
           com.microsoft.adcenter.v8.KeywordPerformanceReportColumn[] columns,
           com.microsoft.adcenter.v8.KeywordPerformanceReportFilter filter,
           com.microsoft.adcenter.v8.AccountThroughAdGroupReportScope scope,
           com.microsoft.adcenter.v8.ReportTime time) {
        super(
            format,
            language,
            reportName,
            returnOnlyCompleteData);
        this.aggregation = aggregation;
        this.columns = columns;
        this.filter = filter;
        this.scope = scope;
        this.time = time;
    }


    /**
     * Gets the aggregation value for this KeywordPerformanceReportRequest.
     * 
     * @return aggregation
     */
    public com.microsoft.adcenter.v8.ReportAggregation getAggregation() {
        return aggregation;
    }


    /**
     * Sets the aggregation value for this KeywordPerformanceReportRequest.
     * 
     * @param aggregation
     */
    public void setAggregation(com.microsoft.adcenter.v8.ReportAggregation aggregation) {
        this.aggregation = aggregation;
    }


    /**
     * Gets the columns value for this KeywordPerformanceReportRequest.
     * 
     * @return columns
     */
    public com.microsoft.adcenter.v8.KeywordPerformanceReportColumn[] getColumns() {
        return columns;
    }


    /**
     * Sets the columns value for this KeywordPerformanceReportRequest.
     * 
     * @param columns
     */
    public void setColumns(com.microsoft.adcenter.v8.KeywordPerformanceReportColumn[] columns) {
        this.columns = columns;
    }


    /**
     * Gets the filter value for this KeywordPerformanceReportRequest.
     * 
     * @return filter
     */
    public com.microsoft.adcenter.v8.KeywordPerformanceReportFilter getFilter() {
        return filter;
    }


    /**
     * Sets the filter value for this KeywordPerformanceReportRequest.
     * 
     * @param filter
     */
    public void setFilter(com.microsoft.adcenter.v8.KeywordPerformanceReportFilter filter) {
        this.filter = filter;
    }


    /**
     * Gets the scope value for this KeywordPerformanceReportRequest.
     * 
     * @return scope
     */
    public com.microsoft.adcenter.v8.AccountThroughAdGroupReportScope getScope() {
        return scope;
    }


    /**
     * Sets the scope value for this KeywordPerformanceReportRequest.
     * 
     * @param scope
     */
    public void setScope(com.microsoft.adcenter.v8.AccountThroughAdGroupReportScope scope) {
        this.scope = scope;
    }


    /**
     * Gets the time value for this KeywordPerformanceReportRequest.
     * 
     * @return time
     */
    public com.microsoft.adcenter.v8.ReportTime getTime() {
        return time;
    }


    /**
     * Sets the time value for this KeywordPerformanceReportRequest.
     * 
     * @param time
     */
    public void setTime(com.microsoft.adcenter.v8.ReportTime time) {
        this.time = time;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof KeywordPerformanceReportRequest)) return false;
        KeywordPerformanceReportRequest other = (KeywordPerformanceReportRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.aggregation==null && other.getAggregation()==null) || 
             (this.aggregation!=null &&
              this.aggregation.equals(other.getAggregation()))) &&
            ((this.columns==null && other.getColumns()==null) || 
             (this.columns!=null &&
              java.util.Arrays.equals(this.columns, other.getColumns()))) &&
            ((this.filter==null && other.getFilter()==null) || 
             (this.filter!=null &&
              this.filter.equals(other.getFilter()))) &&
            ((this.scope==null && other.getScope()==null) || 
             (this.scope!=null &&
              this.scope.equals(other.getScope()))) &&
            ((this.time==null && other.getTime()==null) || 
             (this.time!=null &&
              this.time.equals(other.getTime())));
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
        if (getAggregation() != null) {
            _hashCode += getAggregation().hashCode();
        }
        if (getColumns() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getColumns());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getColumns(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFilter() != null) {
            _hashCode += getFilter().hashCode();
        }
        if (getScope() != null) {
            _hashCode += getScope().hashCode();
        }
        if (getTime() != null) {
            _hashCode += getTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(KeywordPerformanceReportRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordPerformanceReportRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aggregation");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Aggregation"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportAggregation"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("columns");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Columns"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordPerformanceReportColumn"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordPerformanceReportColumn"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filter");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Filter"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordPerformanceReportFilter"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scope");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Scope"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountThroughAdGroupReportScope"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("time");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Time"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportTime"));
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
