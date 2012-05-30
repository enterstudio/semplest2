/**
 * RichAdComponentPerformanceReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class RichAdComponentPerformanceReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected RichAdComponentPerformanceReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _AccountNumber = "AccountNumber";
    public static final java.lang.String _TimePeriod = "TimePeriod";
    public static final java.lang.String _AdId = "AdId";
    public static final java.lang.String _AdTitle = "AdTitle";
    public static final java.lang.String _CampaignName = "CampaignName";
    public static final java.lang.String _AdGroupName = "AdGroupName";
    public static final java.lang.String _AdGroupId = "AdGroupId";
    public static final java.lang.String _RichAdSubType = "RichAdSubType";
    public static final java.lang.String _ComponentType = "ComponentType";
    public static final java.lang.String _ComponentTitle = "ComponentTitle";
    public static final java.lang.String _ComponentDestinationURL = "ComponentDestinationURL";
    public static final java.lang.String _ComponentPosition = "ComponentPosition";
    public static final java.lang.String _ComponentClicks = "ComponentClicks";
    public static final java.lang.String _ComponentNonBillableClicks = "ComponentNonBillableClicks";
    public static final java.lang.String _ComponentTotalClicks = "ComponentTotalClicks";
    public static final java.lang.String _ComponentCTR = "ComponentCTR";
    public static final RichAdComponentPerformanceReportColumn AccountName = new RichAdComponentPerformanceReportColumn(_AccountName);
    public static final RichAdComponentPerformanceReportColumn AccountNumber = new RichAdComponentPerformanceReportColumn(_AccountNumber);
    public static final RichAdComponentPerformanceReportColumn TimePeriod = new RichAdComponentPerformanceReportColumn(_TimePeriod);
    public static final RichAdComponentPerformanceReportColumn AdId = new RichAdComponentPerformanceReportColumn(_AdId);
    public static final RichAdComponentPerformanceReportColumn AdTitle = new RichAdComponentPerformanceReportColumn(_AdTitle);
    public static final RichAdComponentPerformanceReportColumn CampaignName = new RichAdComponentPerformanceReportColumn(_CampaignName);
    public static final RichAdComponentPerformanceReportColumn AdGroupName = new RichAdComponentPerformanceReportColumn(_AdGroupName);
    public static final RichAdComponentPerformanceReportColumn AdGroupId = new RichAdComponentPerformanceReportColumn(_AdGroupId);
    public static final RichAdComponentPerformanceReportColumn RichAdSubType = new RichAdComponentPerformanceReportColumn(_RichAdSubType);
    public static final RichAdComponentPerformanceReportColumn ComponentType = new RichAdComponentPerformanceReportColumn(_ComponentType);
    public static final RichAdComponentPerformanceReportColumn ComponentTitle = new RichAdComponentPerformanceReportColumn(_ComponentTitle);
    public static final RichAdComponentPerformanceReportColumn ComponentDestinationURL = new RichAdComponentPerformanceReportColumn(_ComponentDestinationURL);
    public static final RichAdComponentPerformanceReportColumn ComponentPosition = new RichAdComponentPerformanceReportColumn(_ComponentPosition);
    public static final RichAdComponentPerformanceReportColumn ComponentClicks = new RichAdComponentPerformanceReportColumn(_ComponentClicks);
    public static final RichAdComponentPerformanceReportColumn ComponentNonBillableClicks = new RichAdComponentPerformanceReportColumn(_ComponentNonBillableClicks);
    public static final RichAdComponentPerformanceReportColumn ComponentTotalClicks = new RichAdComponentPerformanceReportColumn(_ComponentTotalClicks);
    public static final RichAdComponentPerformanceReportColumn ComponentCTR = new RichAdComponentPerformanceReportColumn(_ComponentCTR);
    public java.lang.String getValue() { return _value_;}
    public static RichAdComponentPerformanceReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        RichAdComponentPerformanceReportColumn enumeration = (RichAdComponentPerformanceReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static RichAdComponentPerformanceReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(RichAdComponentPerformanceReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RichAdComponentPerformanceReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
