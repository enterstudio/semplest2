/**
 * StandardBusinessIcon.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class StandardBusinessIcon implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected StandardBusinessIcon(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _MoviesOrVideo = "MoviesOrVideo";
    public static final java.lang.String _PubOrBarOrLiquor = "PubOrBarOrLiquor";
    public static final java.lang.String _Accommodations = "Accommodations";
    public static final java.lang.String _RestaurantOrDining = "RestaurantOrDining";
    public static final java.lang.String _CafeOrCoffeeShop = "CafeOrCoffeeShop";
    public static final java.lang.String _FlowersOrGarden = "FlowersOrGarden";
    public static final java.lang.String _CarDealerOrServiceOrRental = "CarDealerOrServiceOrRental";
    public static final java.lang.String _GroceryOrDepartmentStore = "GroceryOrDepartmentStore";
    public static final java.lang.String _ShoppingOrBoutique = "ShoppingOrBoutique";
    public static final java.lang.String _HousewaresOrRealEstateOrHomeRepair = "HousewaresOrRealEstateOrHomeRepair";
    public static final java.lang.String _PhonesOrServiceProvider = "PhonesOrServiceProvider";
    public static final java.lang.String _BankOrFinanceOrCurrencyExchange = "BankOrFinanceOrCurrencyExchange";
    public static final java.lang.String _BankOrFinanceOrCurrencyExchangeUK = "BankOrFinanceOrCurrencyExchangeUK";
    public static final java.lang.String _BankOrFinanceOrCurrencyExchangeEUR = "BankOrFinanceOrCurrencyExchangeEUR";
    public static final java.lang.String _HardwareOrRepair = "HardwareOrRepair";
    public static final java.lang.String _HairdresserOrBarberOrTailor = "HairdresserOrBarberOrTailor";
    public static final StandardBusinessIcon MoviesOrVideo = new StandardBusinessIcon(_MoviesOrVideo);
    public static final StandardBusinessIcon PubOrBarOrLiquor = new StandardBusinessIcon(_PubOrBarOrLiquor);
    public static final StandardBusinessIcon Accommodations = new StandardBusinessIcon(_Accommodations);
    public static final StandardBusinessIcon RestaurantOrDining = new StandardBusinessIcon(_RestaurantOrDining);
    public static final StandardBusinessIcon CafeOrCoffeeShop = new StandardBusinessIcon(_CafeOrCoffeeShop);
    public static final StandardBusinessIcon FlowersOrGarden = new StandardBusinessIcon(_FlowersOrGarden);
    public static final StandardBusinessIcon CarDealerOrServiceOrRental = new StandardBusinessIcon(_CarDealerOrServiceOrRental);
    public static final StandardBusinessIcon GroceryOrDepartmentStore = new StandardBusinessIcon(_GroceryOrDepartmentStore);
    public static final StandardBusinessIcon ShoppingOrBoutique = new StandardBusinessIcon(_ShoppingOrBoutique);
    public static final StandardBusinessIcon HousewaresOrRealEstateOrHomeRepair = new StandardBusinessIcon(_HousewaresOrRealEstateOrHomeRepair);
    public static final StandardBusinessIcon PhonesOrServiceProvider = new StandardBusinessIcon(_PhonesOrServiceProvider);
    public static final StandardBusinessIcon BankOrFinanceOrCurrencyExchange = new StandardBusinessIcon(_BankOrFinanceOrCurrencyExchange);
    public static final StandardBusinessIcon BankOrFinanceOrCurrencyExchangeUK = new StandardBusinessIcon(_BankOrFinanceOrCurrencyExchangeUK);
    public static final StandardBusinessIcon BankOrFinanceOrCurrencyExchangeEUR = new StandardBusinessIcon(_BankOrFinanceOrCurrencyExchangeEUR);
    public static final StandardBusinessIcon HardwareOrRepair = new StandardBusinessIcon(_HardwareOrRepair);
    public static final StandardBusinessIcon HairdresserOrBarberOrTailor = new StandardBusinessIcon(_HairdresserOrBarberOrTailor);
    public java.lang.String getValue() { return _value_;}
    public static StandardBusinessIcon fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        StandardBusinessIcon enumeration = (StandardBusinessIcon)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static StandardBusinessIcon fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(StandardBusinessIcon.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "StandardBusinessIcon"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
