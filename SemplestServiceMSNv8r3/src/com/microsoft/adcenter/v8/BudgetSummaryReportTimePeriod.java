/**
 * BudgetSummaryReportTimePeriod.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class BudgetSummaryReportTimePeriod implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected BudgetSummaryReportTimePeriod(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Today = "Today";
    public static final java.lang.String _Yesterday = "Yesterday";
    public static final java.lang.String _LastSevenDays = "LastSevenDays";
    public static final java.lang.String _ThisMonth = "ThisMonth";
    public static final java.lang.String _LastMonth = "LastMonth";
    public static final BudgetSummaryReportTimePeriod Today = new BudgetSummaryReportTimePeriod(_Today);
    public static final BudgetSummaryReportTimePeriod Yesterday = new BudgetSummaryReportTimePeriod(_Yesterday);
    public static final BudgetSummaryReportTimePeriod LastSevenDays = new BudgetSummaryReportTimePeriod(_LastSevenDays);
    public static final BudgetSummaryReportTimePeriod ThisMonth = new BudgetSummaryReportTimePeriod(_ThisMonth);
    public static final BudgetSummaryReportTimePeriod LastMonth = new BudgetSummaryReportTimePeriod(_LastMonth);
    public java.lang.String getValue() { return _value_;}
    public static BudgetSummaryReportTimePeriod fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        BudgetSummaryReportTimePeriod enumeration = (BudgetSummaryReportTimePeriod)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static BudgetSummaryReportTimePeriod fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BudgetSummaryReportTimePeriod.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BudgetSummaryReportTimePeriod"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
