/**
 * DownloadEntityFilterNull.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class DownloadEntityFilterNull implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected DownloadEntityFilterNull(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _CampaignNegativeKeywords = "CampaignNegativeKeywords";
    public static final java.lang.String _CampaignNegativeSites = "CampaignNegativeSites";
    public static final java.lang.String _CampaignTargets = "CampaignTargets";
    public static final java.lang.String _AdGroupNegativeKeywords = "AdGroupNegativeKeywords";
    public static final java.lang.String _AdGroupNegativeSites = "AdGroupNegativeSites";
    public static final java.lang.String _AdGroupTargets = "AdGroupTargets";
    public static final DownloadEntityFilterNull CampaignNegativeKeywords = new DownloadEntityFilterNull(_CampaignNegativeKeywords);
    public static final DownloadEntityFilterNull CampaignNegativeSites = new DownloadEntityFilterNull(_CampaignNegativeSites);
    public static final DownloadEntityFilterNull CampaignTargets = new DownloadEntityFilterNull(_CampaignTargets);
    public static final DownloadEntityFilterNull AdGroupNegativeKeywords = new DownloadEntityFilterNull(_AdGroupNegativeKeywords);
    public static final DownloadEntityFilterNull AdGroupNegativeSites = new DownloadEntityFilterNull(_AdGroupNegativeSites);
    public static final DownloadEntityFilterNull AdGroupTargets = new DownloadEntityFilterNull(_AdGroupTargets);
    public java.lang.String getValue() { return _value_;}
    public static DownloadEntityFilterNull fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        DownloadEntityFilterNull enumeration = (DownloadEntityFilterNull)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static DownloadEntityFilterNull fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(DownloadEntityFilterNull.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DownloadEntityFilter>null"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
