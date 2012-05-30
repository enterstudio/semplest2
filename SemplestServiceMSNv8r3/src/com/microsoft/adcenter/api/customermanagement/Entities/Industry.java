/**
 * Industry.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Entities;

public class Industry implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Industry(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _NA = "NA";
    public static final java.lang.String _AgencySalesHouse = "AgencySalesHouse";
    public static final java.lang.String _Automotive = "Automotive";
    public static final java.lang.String _ConsumerPackagedGoods = "ConsumerPackagedGoods";
    public static final java.lang.String _Education = "Education";
    public static final java.lang.String _Entertainment = "Entertainment";
    public static final java.lang.String _FinancialServices = "FinancialServices";
    public static final java.lang.String _FoodServices = "FoodServices";
    public static final java.lang.String _Gaming = "Gaming";
    public static final java.lang.String _GovernmentNonprofitPolitical = "GovernmentNonprofitPolitical";
    public static final java.lang.String _Healthcare = "Healthcare";
    public static final java.lang.String _Internal = "Internal";
    public static final java.lang.String _PublishingAndWebMedia = "PublishingAndWebMedia";
    public static final java.lang.String _RealEstate = "RealEstate";
    public static final java.lang.String _Retail = "Retail";
    public static final java.lang.String _Services = "Services";
    public static final java.lang.String _Technology = "Technology";
    public static final java.lang.String _Telecommunications = "Telecommunications";
    public static final java.lang.String _TravelHospitality = "TravelHospitality";
    public static final java.lang.String _Other = "Other";
    public static final java.lang.String _Pharmaceuticals = "Pharmaceuticals";
    public static final Industry NA = new Industry(_NA);
    public static final Industry AgencySalesHouse = new Industry(_AgencySalesHouse);
    public static final Industry Automotive = new Industry(_Automotive);
    public static final Industry ConsumerPackagedGoods = new Industry(_ConsumerPackagedGoods);
    public static final Industry Education = new Industry(_Education);
    public static final Industry Entertainment = new Industry(_Entertainment);
    public static final Industry FinancialServices = new Industry(_FinancialServices);
    public static final Industry FoodServices = new Industry(_FoodServices);
    public static final Industry Gaming = new Industry(_Gaming);
    public static final Industry GovernmentNonprofitPolitical = new Industry(_GovernmentNonprofitPolitical);
    public static final Industry Healthcare = new Industry(_Healthcare);
    public static final Industry Internal = new Industry(_Internal);
    public static final Industry PublishingAndWebMedia = new Industry(_PublishingAndWebMedia);
    public static final Industry RealEstate = new Industry(_RealEstate);
    public static final Industry Retail = new Industry(_Retail);
    public static final Industry Services = new Industry(_Services);
    public static final Industry Technology = new Industry(_Technology);
    public static final Industry Telecommunications = new Industry(_Telecommunications);
    public static final Industry TravelHospitality = new Industry(_TravelHospitality);
    public static final Industry Other = new Industry(_Other);
    public static final Industry Pharmaceuticals = new Industry(_Pharmaceuticals);
    public java.lang.String getValue() { return _value_;}
    public static Industry fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        Industry enumeration = (Industry)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Industry fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(Industry.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Industry"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
