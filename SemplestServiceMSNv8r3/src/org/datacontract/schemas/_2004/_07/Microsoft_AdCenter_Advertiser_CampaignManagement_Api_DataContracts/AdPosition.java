/**
 * AdPosition.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts;

public class AdPosition implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected AdPosition(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _All = "All";
    public static final java.lang.String _MainLine1 = "MainLine1";
    public static final java.lang.String _MainLine2 = "MainLine2";
    public static final java.lang.String _MainLine3 = "MainLine3";
    public static final java.lang.String _MainLine4 = "MainLine4";
    public static final java.lang.String _SideBar1 = "SideBar1";
    public static final java.lang.String _SideBar2 = "SideBar2";
    public static final java.lang.String _SideBar3 = "SideBar3";
    public static final java.lang.String _SideBar4 = "SideBar4";
    public static final java.lang.String _SideBar5 = "SideBar5";
    public static final java.lang.String _SideBar6 = "SideBar6";
    public static final java.lang.String _SideBar7 = "SideBar7";
    public static final java.lang.String _SideBar8 = "SideBar8";
    public static final java.lang.String _SideBar9 = "SideBar9";
    public static final java.lang.String _SideBar10 = "SideBar10";
    public static final java.lang.String _Aggregate = "Aggregate";
    public static final AdPosition All = new AdPosition(_All);
    public static final AdPosition MainLine1 = new AdPosition(_MainLine1);
    public static final AdPosition MainLine2 = new AdPosition(_MainLine2);
    public static final AdPosition MainLine3 = new AdPosition(_MainLine3);
    public static final AdPosition MainLine4 = new AdPosition(_MainLine4);
    public static final AdPosition SideBar1 = new AdPosition(_SideBar1);
    public static final AdPosition SideBar2 = new AdPosition(_SideBar2);
    public static final AdPosition SideBar3 = new AdPosition(_SideBar3);
    public static final AdPosition SideBar4 = new AdPosition(_SideBar4);
    public static final AdPosition SideBar5 = new AdPosition(_SideBar5);
    public static final AdPosition SideBar6 = new AdPosition(_SideBar6);
    public static final AdPosition SideBar7 = new AdPosition(_SideBar7);
    public static final AdPosition SideBar8 = new AdPosition(_SideBar8);
    public static final AdPosition SideBar9 = new AdPosition(_SideBar9);
    public static final AdPosition SideBar10 = new AdPosition(_SideBar10);
    public static final AdPosition Aggregate = new AdPosition(_Aggregate);
    public java.lang.String getValue() { return _value_;}
    public static AdPosition fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        AdPosition enumeration = (AdPosition)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static AdPosition fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(AdPosition.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AdPosition"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
