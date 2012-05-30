/**
 * SearchQueryReportAggregation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class SearchQueryReportAggregation implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected SearchQueryReportAggregation(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Summary = "Summary";
    public static final java.lang.String _Hourly = "Hourly";
    public static final java.lang.String _Daily = "Daily";
    public static final java.lang.String _Weekly = "Weekly";
    public static final java.lang.String _Monthly = "Monthly";
    public static final SearchQueryReportAggregation Summary = new SearchQueryReportAggregation(_Summary);
    public static final SearchQueryReportAggregation Hourly = new SearchQueryReportAggregation(_Hourly);
    public static final SearchQueryReportAggregation Daily = new SearchQueryReportAggregation(_Daily);
    public static final SearchQueryReportAggregation Weekly = new SearchQueryReportAggregation(_Weekly);
    public static final SearchQueryReportAggregation Monthly = new SearchQueryReportAggregation(_Monthly);
    public java.lang.String getValue() { return _value_;}
    public static SearchQueryReportAggregation fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        SearchQueryReportAggregation enumeration = (SearchQueryReportAggregation)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static SearchQueryReportAggregation fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(SearchQueryReportAggregation.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SearchQueryReportAggregation"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
