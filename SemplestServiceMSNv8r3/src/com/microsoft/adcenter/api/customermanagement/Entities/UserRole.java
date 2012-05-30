/**
 * UserRole.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement.Entities;

public class UserRole implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected UserRole(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _AdvertiserCampaignManager = "AdvertiserCampaignManager";
    public static final java.lang.String _SuperAdmin = "SuperAdmin";
    public static final java.lang.String _ClientViewer = "ClientViewer";
    public static final java.lang.String _ClientManager = "ClientManager";
    public static final java.lang.String _PublisherAdmin = "PublisherAdmin";
    public static final java.lang.String _PublisherAccountManager = "PublisherAccountManager";
    public static final java.lang.String _PublisherReportUser = "PublisherReportUser";
    public static final java.lang.String _PublisherListManager = "PublisherListManager";
    public static final java.lang.String _PublisherAdViewer = "PublisherAdViewer";
    public static final java.lang.String _ClientAdmin = "ClientAdmin";
    public static final UserRole AdvertiserCampaignManager = new UserRole(_AdvertiserCampaignManager);
    public static final UserRole SuperAdmin = new UserRole(_SuperAdmin);
    public static final UserRole ClientViewer = new UserRole(_ClientViewer);
    public static final UserRole ClientManager = new UserRole(_ClientManager);
    public static final UserRole PublisherAdmin = new UserRole(_PublisherAdmin);
    public static final UserRole PublisherAccountManager = new UserRole(_PublisherAccountManager);
    public static final UserRole PublisherReportUser = new UserRole(_PublisherReportUser);
    public static final UserRole PublisherListManager = new UserRole(_PublisherListManager);
    public static final UserRole PublisherAdViewer = new UserRole(_PublisherAdViewer);
    public static final UserRole ClientAdmin = new UserRole(_ClientAdmin);
    public java.lang.String getValue() { return _value_;}
    public static UserRole fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        UserRole enumeration = (UserRole)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static UserRole fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(UserRole.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "UserRole"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
