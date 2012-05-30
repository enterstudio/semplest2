/**
 * SecretQuestion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Entities;

public class SecretQuestion implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected SecretQuestion(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _None = "None";
    public static final java.lang.String _FavoritePetsName = "FavoritePetsName";
    public static final java.lang.String _FavoriteMovie = "FavoriteMovie";
    public static final java.lang.String _Anniversary = "Anniversary";
    public static final java.lang.String _FatherMiddleName = "FatherMiddleName";
    public static final java.lang.String _SpouseMiddleName = "SpouseMiddleName";
    public static final java.lang.String _FirstChildMiddleName = "FirstChildMiddleName";
    public static final java.lang.String _HighSchoolName = "HighSchoolName";
    public static final java.lang.String _FavoriteTeacherName = "FavoriteTeacherName";
    public static final java.lang.String _FavoriteSportsTeam = "FavoriteSportsTeam";
    public static final SecretQuestion None = new SecretQuestion(_None);
    public static final SecretQuestion FavoritePetsName = new SecretQuestion(_FavoritePetsName);
    public static final SecretQuestion FavoriteMovie = new SecretQuestion(_FavoriteMovie);
    public static final SecretQuestion Anniversary = new SecretQuestion(_Anniversary);
    public static final SecretQuestion FatherMiddleName = new SecretQuestion(_FatherMiddleName);
    public static final SecretQuestion SpouseMiddleName = new SecretQuestion(_SpouseMiddleName);
    public static final SecretQuestion FirstChildMiddleName = new SecretQuestion(_FirstChildMiddleName);
    public static final SecretQuestion HighSchoolName = new SecretQuestion(_HighSchoolName);
    public static final SecretQuestion FavoriteTeacherName = new SecretQuestion(_FavoriteTeacherName);
    public static final SecretQuestion FavoriteSportsTeam = new SecretQuestion(_FavoriteSportsTeam);
    public java.lang.String getValue() { return _value_;}
    public static SecretQuestion fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        SecretQuestion enumeration = (SecretQuestion)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static SecretQuestion fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(SecretQuestion.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "SecretQuestion"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
