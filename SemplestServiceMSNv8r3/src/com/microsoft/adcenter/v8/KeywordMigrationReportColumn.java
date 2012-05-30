/**
 * KeywordMigrationReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class KeywordMigrationReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected KeywordMigrationReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _AccountId = "AccountId";
    public static final java.lang.String _CampaignName = "CampaignName";
    public static final java.lang.String _CampaignId = "CampaignId";
    public static final java.lang.String _AdGroupName = "AdGroupName";
    public static final java.lang.String _AdGroupId = "AdGroupId";
    public static final java.lang.String _Keyword = "Keyword";
    public static final java.lang.String _KeywordId = "KeywordId";
    public static final java.lang.String _PreviousKeywordId = "PreviousKeywordId";
    public static final java.lang.String _BidMatchType = "BidMatchType";
    public static final KeywordMigrationReportColumn AccountName = new KeywordMigrationReportColumn(_AccountName);
    public static final KeywordMigrationReportColumn AccountId = new KeywordMigrationReportColumn(_AccountId);
    public static final KeywordMigrationReportColumn CampaignName = new KeywordMigrationReportColumn(_CampaignName);
    public static final KeywordMigrationReportColumn CampaignId = new KeywordMigrationReportColumn(_CampaignId);
    public static final KeywordMigrationReportColumn AdGroupName = new KeywordMigrationReportColumn(_AdGroupName);
    public static final KeywordMigrationReportColumn AdGroupId = new KeywordMigrationReportColumn(_AdGroupId);
    public static final KeywordMigrationReportColumn Keyword = new KeywordMigrationReportColumn(_Keyword);
    public static final KeywordMigrationReportColumn KeywordId = new KeywordMigrationReportColumn(_KeywordId);
    public static final KeywordMigrationReportColumn PreviousKeywordId = new KeywordMigrationReportColumn(_PreviousKeywordId);
    public static final KeywordMigrationReportColumn BidMatchType = new KeywordMigrationReportColumn(_BidMatchType);
    public java.lang.String getValue() { return _value_;}
    public static KeywordMigrationReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        KeywordMigrationReportColumn enumeration = (KeywordMigrationReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static KeywordMigrationReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(KeywordMigrationReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordMigrationReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
