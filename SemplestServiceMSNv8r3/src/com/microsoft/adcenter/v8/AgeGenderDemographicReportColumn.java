/**
 * AgeGenderDemographicReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class AgeGenderDemographicReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AgeGenderDemographicReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _AccountNumber = "AccountNumber";
    public static final java.lang.String _TimePeriod = "TimePeriod";
    public static final java.lang.String _LanguageAndRegion = "LanguageAndRegion";
    public static final java.lang.String _CampaignName = "CampaignName";
    public static final java.lang.String _AdGroupName = "AdGroupName";
    public static final java.lang.String _AdDistribution = "AdDistribution";
    public static final java.lang.String _AgeGroup = "AgeGroup";
    public static final java.lang.String _Gender = "Gender";
    public static final java.lang.String _EstimatedImpressionPercent = "EstimatedImpressionPercent";
    public static final java.lang.String _EstimatedClickPercent = "EstimatedClickPercent";
    public static final java.lang.String _EstimatedCtr = "EstimatedCtr";
    public static final java.lang.String _Language = "Language";
    public static final AgeGenderDemographicReportColumn AccountName = new AgeGenderDemographicReportColumn(_AccountName);
    public static final AgeGenderDemographicReportColumn AccountNumber = new AgeGenderDemographicReportColumn(_AccountNumber);
    public static final AgeGenderDemographicReportColumn TimePeriod = new AgeGenderDemographicReportColumn(_TimePeriod);
    public static final AgeGenderDemographicReportColumn LanguageAndRegion = new AgeGenderDemographicReportColumn(_LanguageAndRegion);
    public static final AgeGenderDemographicReportColumn CampaignName = new AgeGenderDemographicReportColumn(_CampaignName);
    public static final AgeGenderDemographicReportColumn AdGroupName = new AgeGenderDemographicReportColumn(_AdGroupName);
    public static final AgeGenderDemographicReportColumn AdDistribution = new AgeGenderDemographicReportColumn(_AdDistribution);
    public static final AgeGenderDemographicReportColumn AgeGroup = new AgeGenderDemographicReportColumn(_AgeGroup);
    public static final AgeGenderDemographicReportColumn Gender = new AgeGenderDemographicReportColumn(_Gender);
    public static final AgeGenderDemographicReportColumn EstimatedImpressionPercent = new AgeGenderDemographicReportColumn(_EstimatedImpressionPercent);
    public static final AgeGenderDemographicReportColumn EstimatedClickPercent = new AgeGenderDemographicReportColumn(_EstimatedClickPercent);
    public static final AgeGenderDemographicReportColumn EstimatedCtr = new AgeGenderDemographicReportColumn(_EstimatedCtr);
    public static final AgeGenderDemographicReportColumn Language = new AgeGenderDemographicReportColumn(_Language);
    public java.lang.String getValue() { return _value_;}
    public static AgeGenderDemographicReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        AgeGenderDemographicReportColumn enumeration = (AgeGenderDemographicReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static AgeGenderDemographicReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(AgeGenderDemographicReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeGenderDemographicReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
