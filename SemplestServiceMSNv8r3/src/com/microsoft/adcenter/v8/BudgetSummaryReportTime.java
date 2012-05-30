/**
 * BudgetSummaryReportTime.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class BudgetSummaryReportTime  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.Date customDateRangeEnd;

    private com.microsoft.adcenter.v8.Date customDateRangeStart;

    private com.microsoft.adcenter.v8.BudgetSummaryReportTimePeriod predefinedTime;

    public BudgetSummaryReportTime() {
    }

    public BudgetSummaryReportTime(
           com.microsoft.adcenter.v8.Date customDateRangeEnd,
           com.microsoft.adcenter.v8.Date customDateRangeStart,
           com.microsoft.adcenter.v8.BudgetSummaryReportTimePeriod predefinedTime) {
           this.customDateRangeEnd = customDateRangeEnd;
           this.customDateRangeStart = customDateRangeStart;
           this.predefinedTime = predefinedTime;
    }


    /**
     * Gets the customDateRangeEnd value for this BudgetSummaryReportTime.
     * 
     * @return customDateRangeEnd
     */
    public com.microsoft.adcenter.v8.Date getCustomDateRangeEnd() {
        return customDateRangeEnd;
    }


    /**
     * Sets the customDateRangeEnd value for this BudgetSummaryReportTime.
     * 
     * @param customDateRangeEnd
     */
    public void setCustomDateRangeEnd(com.microsoft.adcenter.v8.Date customDateRangeEnd) {
        this.customDateRangeEnd = customDateRangeEnd;
    }


    /**
     * Gets the customDateRangeStart value for this BudgetSummaryReportTime.
     * 
     * @return customDateRangeStart
     */
    public com.microsoft.adcenter.v8.Date getCustomDateRangeStart() {
        return customDateRangeStart;
    }


    /**
     * Sets the customDateRangeStart value for this BudgetSummaryReportTime.
     * 
     * @param customDateRangeStart
     */
    public void setCustomDateRangeStart(com.microsoft.adcenter.v8.Date customDateRangeStart) {
        this.customDateRangeStart = customDateRangeStart;
    }


    /**
     * Gets the predefinedTime value for this BudgetSummaryReportTime.
     * 
     * @return predefinedTime
     */
    public com.microsoft.adcenter.v8.BudgetSummaryReportTimePeriod getPredefinedTime() {
        return predefinedTime;
    }


    /**
     * Sets the predefinedTime value for this BudgetSummaryReportTime.
     * 
     * @param predefinedTime
     */
    public void setPredefinedTime(com.microsoft.adcenter.v8.BudgetSummaryReportTimePeriod predefinedTime) {
        this.predefinedTime = predefinedTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BudgetSummaryReportTime)) return false;
        BudgetSummaryReportTime other = (BudgetSummaryReportTime) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customDateRangeEnd==null && other.getCustomDateRangeEnd()==null) || 
             (this.customDateRangeEnd!=null &&
              this.customDateRangeEnd.equals(other.getCustomDateRangeEnd()))) &&
            ((this.customDateRangeStart==null && other.getCustomDateRangeStart()==null) || 
             (this.customDateRangeStart!=null &&
              this.customDateRangeStart.equals(other.getCustomDateRangeStart()))) &&
            ((this.predefinedTime==null && other.getPredefinedTime()==null) || 
             (this.predefinedTime!=null &&
              this.predefinedTime.equals(other.getPredefinedTime())));
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
        if (getCustomDateRangeEnd() != null) {
            _hashCode += getCustomDateRangeEnd().hashCode();
        }
        if (getCustomDateRangeStart() != null) {
            _hashCode += getCustomDateRangeStart().hashCode();
        }
        if (getPredefinedTime() != null) {
            _hashCode += getPredefinedTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BudgetSummaryReportTime.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BudgetSummaryReportTime"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customDateRangeEnd");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CustomDateRangeEnd"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customDateRangeStart");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CustomDateRangeStart"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("predefinedTime");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PredefinedTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BudgetSummaryReportTimePeriod"));
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
