/**
 * SearchQueryPerformanceReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class SearchQueryPerformanceReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected SearchQueryPerformanceReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _AccountNumber = "AccountNumber";
    public static final java.lang.String _AccountId = "AccountId";
    public static final java.lang.String _TimePeriod = "TimePeriod";
    public static final java.lang.String _CampaignName = "CampaignName";
    public static final java.lang.String _CampaignId = "CampaignId";
    public static final java.lang.String _AdGroupName = "AdGroupName";
    public static final java.lang.String _AdGroupId = "AdGroupId";
    public static final java.lang.String _AdId = "AdId";
    public static final java.lang.String _AdType = "AdType";
    public static final java.lang.String _DestinationUrl = "DestinationUrl";
    public static final java.lang.String _MatchType = "MatchType";
    public static final java.lang.String _LanguageAndRegion = "LanguageAndRegion";
    public static final java.lang.String _CampaignStatus = "CampaignStatus";
    public static final java.lang.String _AdStatus = "AdStatus";
    public static final java.lang.String _Impressions = "Impressions";
    public static final java.lang.String _Clicks = "Clicks";
    public static final java.lang.String _Ctr = "Ctr";
    public static final java.lang.String _AverageCpc = "AverageCpc";
    public static final java.lang.String _Spend = "Spend";
    public static final java.lang.String _AveragePosition = "AveragePosition";
    public static final java.lang.String _SearchQuery = "SearchQuery";
    public static final java.lang.String _Keyword = "Keyword";
    public static final java.lang.String _Conversions = "Conversions";
    public static final java.lang.String _ConversionRate = "ConversionRate";
    public static final java.lang.String _CostPerConversion = "CostPerConversion";
    public static final java.lang.String _Language = "Language";
    public static final java.lang.String _KeywordId = "KeywordId";
    public static final SearchQueryPerformanceReportColumn AccountName = new SearchQueryPerformanceReportColumn(_AccountName);
    public static final SearchQueryPerformanceReportColumn AccountNumber = new SearchQueryPerformanceReportColumn(_AccountNumber);
    public static final SearchQueryPerformanceReportColumn AccountId = new SearchQueryPerformanceReportColumn(_AccountId);
    public static final SearchQueryPerformanceReportColumn TimePeriod = new SearchQueryPerformanceReportColumn(_TimePeriod);
    public static final SearchQueryPerformanceReportColumn CampaignName = new SearchQueryPerformanceReportColumn(_CampaignName);
    public static final SearchQueryPerformanceReportColumn CampaignId = new SearchQueryPerformanceReportColumn(_CampaignId);
    public static final SearchQueryPerformanceReportColumn AdGroupName = new SearchQueryPerformanceReportColumn(_AdGroupName);
    public static final SearchQueryPerformanceReportColumn AdGroupId = new SearchQueryPerformanceReportColumn(_AdGroupId);
    public static final SearchQueryPerformanceReportColumn AdId = new SearchQueryPerformanceReportColumn(_AdId);
    public static final SearchQueryPerformanceReportColumn AdType = new SearchQueryPerformanceReportColumn(_AdType);
    public static final SearchQueryPerformanceReportColumn DestinationUrl = new SearchQueryPerformanceReportColumn(_DestinationUrl);
    public static final SearchQueryPerformanceReportColumn MatchType = new SearchQueryPerformanceReportColumn(_MatchType);
    public static final SearchQueryPerformanceReportColumn LanguageAndRegion = new SearchQueryPerformanceReportColumn(_LanguageAndRegion);
    public static final SearchQueryPerformanceReportColumn CampaignStatus = new SearchQueryPerformanceReportColumn(_CampaignStatus);
    public static final SearchQueryPerformanceReportColumn AdStatus = new SearchQueryPerformanceReportColumn(_AdStatus);
    public static final SearchQueryPerformanceReportColumn Impressions = new SearchQueryPerformanceReportColumn(_Impressions);
    public static final SearchQueryPerformanceReportColumn Clicks = new SearchQueryPerformanceReportColumn(_Clicks);
    public static final SearchQueryPerformanceReportColumn Ctr = new SearchQueryPerformanceReportColumn(_Ctr);
    public static final SearchQueryPerformanceReportColumn AverageCpc = new SearchQueryPerformanceReportColumn(_AverageCpc);
    public static final SearchQueryPerformanceReportColumn Spend = new SearchQueryPerformanceReportColumn(_Spend);
    public static final SearchQueryPerformanceReportColumn AveragePosition = new SearchQueryPerformanceReportColumn(_AveragePosition);
    public static final SearchQueryPerformanceReportColumn SearchQuery = new SearchQueryPerformanceReportColumn(_SearchQuery);
    public static final SearchQueryPerformanceReportColumn Keyword = new SearchQueryPerformanceReportColumn(_Keyword);
    public static final SearchQueryPerformanceReportColumn Conversions = new SearchQueryPerformanceReportColumn(_Conversions);
    public static final SearchQueryPerformanceReportColumn ConversionRate = new SearchQueryPerformanceReportColumn(_ConversionRate);
    public static final SearchQueryPerformanceReportColumn CostPerConversion = new SearchQueryPerformanceReportColumn(_CostPerConversion);
    public static final SearchQueryPerformanceReportColumn Language = new SearchQueryPerformanceReportColumn(_Language);
    public static final SearchQueryPerformanceReportColumn KeywordId = new SearchQueryPerformanceReportColumn(_KeywordId);
    public java.lang.String getValue() { return _value_;}
    public static SearchQueryPerformanceReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        SearchQueryPerformanceReportColumn enumeration = (SearchQueryPerformanceReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static SearchQueryPerformanceReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(SearchQueryPerformanceReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SearchQueryPerformanceReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
