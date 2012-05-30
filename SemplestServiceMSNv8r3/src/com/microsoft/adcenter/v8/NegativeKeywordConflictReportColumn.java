/**
 * NegativeKeywordConflictReportColumn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class NegativeKeywordConflictReportColumn implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected NegativeKeywordConflictReportColumn(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AccountName = "AccountName";
    public static final java.lang.String _AccountNumber = "AccountNumber";
    public static final java.lang.String _AccountId = "AccountId";
    public static final java.lang.String _CampaignName = "CampaignName";
    public static final java.lang.String _CampaignId = "CampaignId";
    public static final java.lang.String _AdGroupName = "AdGroupName";
    public static final java.lang.String _AdGroupId = "AdGroupId";
    public static final java.lang.String _Keyword = "Keyword";
    public static final java.lang.String _KeywordId = "KeywordId";
    public static final java.lang.String _NegativeKeyword = "NegativeKeyword";
    public static final java.lang.String _ConflictLevel = "ConflictLevel";
    public static final NegativeKeywordConflictReportColumn AccountName = new NegativeKeywordConflictReportColumn(_AccountName);
    public static final NegativeKeywordConflictReportColumn AccountNumber = new NegativeKeywordConflictReportColumn(_AccountNumber);
    public static final NegativeKeywordConflictReportColumn AccountId = new NegativeKeywordConflictReportColumn(_AccountId);
    public static final NegativeKeywordConflictReportColumn CampaignName = new NegativeKeywordConflictReportColumn(_CampaignName);
    public static final NegativeKeywordConflictReportColumn CampaignId = new NegativeKeywordConflictReportColumn(_CampaignId);
    public static final NegativeKeywordConflictReportColumn AdGroupName = new NegativeKeywordConflictReportColumn(_AdGroupName);
    public static final NegativeKeywordConflictReportColumn AdGroupId = new NegativeKeywordConflictReportColumn(_AdGroupId);
    public static final NegativeKeywordConflictReportColumn Keyword = new NegativeKeywordConflictReportColumn(_Keyword);
    public static final NegativeKeywordConflictReportColumn KeywordId = new NegativeKeywordConflictReportColumn(_KeywordId);
    public static final NegativeKeywordConflictReportColumn NegativeKeyword = new NegativeKeywordConflictReportColumn(_NegativeKeyword);
    public static final NegativeKeywordConflictReportColumn ConflictLevel = new NegativeKeywordConflictReportColumn(_ConflictLevel);
    public java.lang.String getValue() { return _value_;}
    public static NegativeKeywordConflictReportColumn fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        NegativeKeywordConflictReportColumn enumeration = (NegativeKeywordConflictReportColumn)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static NegativeKeywordConflictReportColumn fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(NegativeKeywordConflictReportColumn.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "NegativeKeywordConflictReportColumn"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
