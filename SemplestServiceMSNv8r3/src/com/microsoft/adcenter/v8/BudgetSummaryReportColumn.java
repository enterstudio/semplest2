/**
 * BudgetSummaryReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class BudgetSummaryReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected BudgetSummaryReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _AccountNumber = "AccountNumber";
    public static final java.lang.String _CampaignName = "CampaignName";
    public static final java.lang.String _Date = "Date";
    public static final java.lang.String _CurrencyCode = "CurrencyCode";
    public static final java.lang.String _MonthlyBudget = "MonthlyBudget";
    public static final java.lang.String _DailySpend = "DailySpend";
    public static final java.lang.String _MonthToDateSpend = "MonthToDateSpend";
    public static final BudgetSummaryReportColumn AccountName = new BudgetSummaryReportColumn(_AccountName);
    public static final BudgetSummaryReportColumn AccountNumber = new BudgetSummaryReportColumn(_AccountNumber);
    public static final BudgetSummaryReportColumn CampaignName = new BudgetSummaryReportColumn(_CampaignName);
    public static final BudgetSummaryReportColumn Date = new BudgetSummaryReportColumn(_Date);
    public static final BudgetSummaryReportColumn CurrencyCode = new BudgetSummaryReportColumn(_CurrencyCode);
    public static final BudgetSummaryReportColumn MonthlyBudget = new BudgetSummaryReportColumn(_MonthlyBudget);
    public static final BudgetSummaryReportColumn DailySpend = new BudgetSummaryReportColumn(_DailySpend);
    public static final BudgetSummaryReportColumn MonthToDateSpend = new BudgetSummaryReportColumn(_MonthToDateSpend);
    public java.lang.String getValue() { return _value_;}
    public static BudgetSummaryReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        BudgetSummaryReportColumn enumeration = (BudgetSummaryReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static BudgetSummaryReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(BudgetSummaryReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BudgetSummaryReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
