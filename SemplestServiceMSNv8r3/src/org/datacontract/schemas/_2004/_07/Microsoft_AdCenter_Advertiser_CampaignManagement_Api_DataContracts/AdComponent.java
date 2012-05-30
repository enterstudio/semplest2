/**
 * AdComponent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts;

public class AdComponent implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AdComponent(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Unknown = "Unknown";
    public static final java.lang.String _Keyword = "Keyword";
    public static final java.lang.String _KeywordParam1 = "KeywordParam1";
    public static final java.lang.String _KeywordParam2 = "KeywordParam2";
    public static final java.lang.String _KeywordParam3 = "KeywordParam3";
    public static final java.lang.String _AdTitleDescription = "AdTitleDescription";
    public static final java.lang.String _AdTitle = "AdTitle";
    public static final java.lang.String _AdDescription = "AdDescription";
    public static final java.lang.String _DisplayUrl = "DisplayUrl";
    public static final java.lang.String _DestinationUrl = "DestinationUrl";
    public static final java.lang.String _LandingUrl = "LandingUrl";
    public static final java.lang.String _SiteDomain = "SiteDomain";
    public static final java.lang.String _BusinessName = "BusinessName";
    public static final java.lang.String _PhoneNumber = "PhoneNumber";
    public static final java.lang.String _CashbackTextParam = "CashbackTextParam";
    public static final java.lang.String _AltText = "AltText";
    public static final java.lang.String _Audio = "Audio";
    public static final java.lang.String _Video = "Video";
    public static final java.lang.String _Flash = "Flash";
    public static final java.lang.String _CAsset = "CAsset";
    public static final java.lang.String _Image = "Image";
    public static final java.lang.String _Destination = "Destination";
    public static final java.lang.String _Asset = "Asset";
    public static final java.lang.String _Ad = "Ad";
    public static final java.lang.String _Order = "Order";
    public static final java.lang.String _BiddingKeyword = "BiddingKeyword";
    public static final java.lang.String _Association = "Association";
    public static final java.lang.String _Script = "Script";
    public static final AdComponent Unknown = new AdComponent(_Unknown);
    public static final AdComponent Keyword = new AdComponent(_Keyword);
    public static final AdComponent KeywordParam1 = new AdComponent(_KeywordParam1);
    public static final AdComponent KeywordParam2 = new AdComponent(_KeywordParam2);
    public static final AdComponent KeywordParam3 = new AdComponent(_KeywordParam3);
    public static final AdComponent AdTitleDescription = new AdComponent(_AdTitleDescription);
    public static final AdComponent AdTitle = new AdComponent(_AdTitle);
    public static final AdComponent AdDescription = new AdComponent(_AdDescription);
    public static final AdComponent DisplayUrl = new AdComponent(_DisplayUrl);
    public static final AdComponent DestinationUrl = new AdComponent(_DestinationUrl);
    public static final AdComponent LandingUrl = new AdComponent(_LandingUrl);
    public static final AdComponent SiteDomain = new AdComponent(_SiteDomain);
    public static final AdComponent BusinessName = new AdComponent(_BusinessName);
    public static final AdComponent PhoneNumber = new AdComponent(_PhoneNumber);
    public static final AdComponent CashbackTextParam = new AdComponent(_CashbackTextParam);
    public static final AdComponent AltText = new AdComponent(_AltText);
    public static final AdComponent Audio = new AdComponent(_Audio);
    public static final AdComponent Video = new AdComponent(_Video);
    public static final AdComponent Flash = new AdComponent(_Flash);
    public static final AdComponent CAsset = new AdComponent(_CAsset);
    public static final AdComponent Image = new AdComponent(_Image);
    public static final AdComponent Destination = new AdComponent(_Destination);
    public static final AdComponent Asset = new AdComponent(_Asset);
    public static final AdComponent Ad = new AdComponent(_Ad);
    public static final AdComponent Order = new AdComponent(_Order);
    public static final AdComponent BiddingKeyword = new AdComponent(_BiddingKeyword);
    public static final AdComponent Association = new AdComponent(_Association);
    public static final AdComponent Script = new AdComponent(_Script);
    public java.lang.String getValue() { return _value_;}
    public static AdComponent fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        AdComponent enumeration = (AdComponent)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static AdComponent fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(AdComponent.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AdComponent"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
