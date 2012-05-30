/**
 * MetroAreaDemographicReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class MetroAreaDemographicReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected MetroAreaDemographicReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _AccountNumber = "AccountNumber";
    public static final java.lang.String _TimePeriod = "TimePeriod";
    public static final java.lang.String _LanguageAndRegion = "LanguageAndRegion";
    public static final java.lang.String _CampaignName = "CampaignName";
    public static final java.lang.String _AdGroupName = "AdGroupName";
    public static final java.lang.String _Country = "Country";
    public static final java.lang.String _State = "State";
    public static final java.lang.String _MetroArea = "MetroArea";
    public static final java.lang.String _CurrencyCode = "CurrencyCode";
    public static final java.lang.String _AdDistribution = "AdDistribution";
    public static final java.lang.String _Impressions = "Impressions";
    public static final java.lang.String _Clicks = "Clicks";
    public static final java.lang.String _Ctr = "Ctr";
    public static final java.lang.String _AverageCpc = "AverageCpc";
    public static final java.lang.String _Spend = "Spend";
    public static final java.lang.String _AveragePosition = "AveragePosition";
    public static final java.lang.String _AverageCpm = "AverageCpm";
    public static final java.lang.String _ProximityTargetLocation = "ProximityTargetLocation";
    public static final java.lang.String _Radius = "Radius";
    public static final java.lang.String _Language = "Language";
    public static final MetroAreaDemographicReportColumn AccountName = new MetroAreaDemographicReportColumn(_AccountName);
    public static final MetroAreaDemographicReportColumn AccountNumber = new MetroAreaDemographicReportColumn(_AccountNumber);
    public static final MetroAreaDemographicReportColumn TimePeriod = new MetroAreaDemographicReportColumn(_TimePeriod);
    public static final MetroAreaDemographicReportColumn LanguageAndRegion = new MetroAreaDemographicReportColumn(_LanguageAndRegion);
    public static final MetroAreaDemographicReportColumn CampaignName = new MetroAreaDemographicReportColumn(_CampaignName);
    public static final MetroAreaDemographicReportColumn AdGroupName = new MetroAreaDemographicReportColumn(_AdGroupName);
    public static final MetroAreaDemographicReportColumn Country = new MetroAreaDemographicReportColumn(_Country);
    public static final MetroAreaDemographicReportColumn State = new MetroAreaDemographicReportColumn(_State);
    public static final MetroAreaDemographicReportColumn MetroArea = new MetroAreaDemographicReportColumn(_MetroArea);
    public static final MetroAreaDemographicReportColumn CurrencyCode = new MetroAreaDemographicReportColumn(_CurrencyCode);
    public static final MetroAreaDemographicReportColumn AdDistribution = new MetroAreaDemographicReportColumn(_AdDistribution);
    public static final MetroAreaDemographicReportColumn Impressions = new MetroAreaDemographicReportColumn(_Impressions);
    public static final MetroAreaDemographicReportColumn Clicks = new MetroAreaDemographicReportColumn(_Clicks);
    public static final MetroAreaDemographicReportColumn Ctr = new MetroAreaDemographicReportColumn(_Ctr);
    public static final MetroAreaDemographicReportColumn AverageCpc = new MetroAreaDemographicReportColumn(_AverageCpc);
    public static final MetroAreaDemographicReportColumn Spend = new MetroAreaDemographicReportColumn(_Spend);
    public static final MetroAreaDemographicReportColumn AveragePosition = new MetroAreaDemographicReportColumn(_AveragePosition);
    public static final MetroAreaDemographicReportColumn AverageCpm = new MetroAreaDemographicReportColumn(_AverageCpm);
    public static final MetroAreaDemographicReportColumn ProximityTargetLocation = new MetroAreaDemographicReportColumn(_ProximityTargetLocation);
    public static final MetroAreaDemographicReportColumn Radius = new MetroAreaDemographicReportColumn(_Radius);
    public static final MetroAreaDemographicReportColumn Language = new MetroAreaDemographicReportColumn(_Language);
    public java.lang.String getValue() { return _value_;}
    public static MetroAreaDemographicReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        MetroAreaDemographicReportColumn enumeration = (MetroAreaDemographicReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static MetroAreaDemographicReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(MetroAreaDemographicReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MetroAreaDemographicReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
