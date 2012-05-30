/**
 * IncrementalBidPercentage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class IncrementalBidPercentage implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected IncrementalBidPercentage(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _ZeroPercent = "ZeroPercent";
    public static final java.lang.String _TenPercent = "TenPercent";
    public static final java.lang.String _TwentyPercent = "TwentyPercent";
    public static final java.lang.String _ThirtyPercent = "ThirtyPercent";
    public static final java.lang.String _FortyPercent = "FortyPercent";
    public static final java.lang.String _FiftyPercent = "FiftyPercent";
    public static final java.lang.String _SixtyPercent = "SixtyPercent";
    public static final java.lang.String _SeventyPercent = "SeventyPercent";
    public static final java.lang.String _EightyPercent = "EightyPercent";
    public static final java.lang.String _NinetyPercent = "NinetyPercent";
    public static final java.lang.String _OneHundredPercent = "OneHundredPercent";
    public static final java.lang.String _NegativeTenPercent = "NegativeTenPercent";
    public static final java.lang.String _NegativeTwentyPercent = "NegativeTwentyPercent";
    public static final java.lang.String _NegativeThirtyPercent = "NegativeThirtyPercent";
    public static final java.lang.String _NegativeFortyPercent = "NegativeFortyPercent";
    public static final java.lang.String _NegativeFiftyPercent = "NegativeFiftyPercent";
    public static final java.lang.String _NegativeSixtyPercent = "NegativeSixtyPercent";
    public static final java.lang.String _NegativeSeventyPercent = "NegativeSeventyPercent";
    public static final java.lang.String _NegativeEightyPercent = "NegativeEightyPercent";
    public static final java.lang.String _NegativeNinetyPercent = "NegativeNinetyPercent";
    public static final java.lang.String _NegativeOneHundredPercent = "NegativeOneHundredPercent";
    public static final IncrementalBidPercentage ZeroPercent = new IncrementalBidPercentage(_ZeroPercent);
    public static final IncrementalBidPercentage TenPercent = new IncrementalBidPercentage(_TenPercent);
    public static final IncrementalBidPercentage TwentyPercent = new IncrementalBidPercentage(_TwentyPercent);
    public static final IncrementalBidPercentage ThirtyPercent = new IncrementalBidPercentage(_ThirtyPercent);
    public static final IncrementalBidPercentage FortyPercent = new IncrementalBidPercentage(_FortyPercent);
    public static final IncrementalBidPercentage FiftyPercent = new IncrementalBidPercentage(_FiftyPercent);
    public static final IncrementalBidPercentage SixtyPercent = new IncrementalBidPercentage(_SixtyPercent);
    public static final IncrementalBidPercentage SeventyPercent = new IncrementalBidPercentage(_SeventyPercent);
    public static final IncrementalBidPercentage EightyPercent = new IncrementalBidPercentage(_EightyPercent);
    public static final IncrementalBidPercentage NinetyPercent = new IncrementalBidPercentage(_NinetyPercent);
    public static final IncrementalBidPercentage OneHundredPercent = new IncrementalBidPercentage(_OneHundredPercent);
    public static final IncrementalBidPercentage NegativeTenPercent = new IncrementalBidPercentage(_NegativeTenPercent);
    public static final IncrementalBidPercentage NegativeTwentyPercent = new IncrementalBidPercentage(_NegativeTwentyPercent);
    public static final IncrementalBidPercentage NegativeThirtyPercent = new IncrementalBidPercentage(_NegativeThirtyPercent);
    public static final IncrementalBidPercentage NegativeFortyPercent = new IncrementalBidPercentage(_NegativeFortyPercent);
    public static final IncrementalBidPercentage NegativeFiftyPercent = new IncrementalBidPercentage(_NegativeFiftyPercent);
    public static final IncrementalBidPercentage NegativeSixtyPercent = new IncrementalBidPercentage(_NegativeSixtyPercent);
    public static final IncrementalBidPercentage NegativeSeventyPercent = new IncrementalBidPercentage(_NegativeSeventyPercent);
    public static final IncrementalBidPercentage NegativeEightyPercent = new IncrementalBidPercentage(_NegativeEightyPercent);
    public static final IncrementalBidPercentage NegativeNinetyPercent = new IncrementalBidPercentage(_NegativeNinetyPercent);
    public static final IncrementalBidPercentage NegativeOneHundredPercent = new IncrementalBidPercentage(_NegativeOneHundredPercent);
    public java.lang.String getValue() { return _value_;}
    public static IncrementalBidPercentage fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        IncrementalBidPercentage enumeration = (IncrementalBidPercentage)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static IncrementalBidPercentage fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(IncrementalBidPercentage.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "IncrementalBidPercentage"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
