/**
 * SetAnalyticsTypeRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class SetAnalyticsTypeRequest  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AccountAnalyticsType[] accountAnalyticsTypes;

    public SetAnalyticsTypeRequest() {
    }

    public SetAnalyticsTypeRequest(
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AccountAnalyticsType[] accountAnalyticsTypes) {
           this.accountAnalyticsTypes = accountAnalyticsTypes;
    }


    /**
     * Gets the accountAnalyticsTypes value for this SetAnalyticsTypeRequest.
     * 
     * @return accountAnalyticsTypes
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AccountAnalyticsType[] getAccountAnalyticsTypes() {
        return accountAnalyticsTypes;
    }


    /**
     * Sets the accountAnalyticsTypes value for this SetAnalyticsTypeRequest.
     * 
     * @param accountAnalyticsTypes
     */
    public void setAccountAnalyticsTypes(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AccountAnalyticsType[] accountAnalyticsTypes) {
        this.accountAnalyticsTypes = accountAnalyticsTypes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SetAnalyticsTypeRequest)) return false;
        SetAnalyticsTypeRequest other = (SetAnalyticsTypeRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountAnalyticsTypes==null && other.getAccountAnalyticsTypes()==null) || 
             (this.accountAnalyticsTypes!=null &&
              java.util.Arrays.equals(this.accountAnalyticsTypes, other.getAccountAnalyticsTypes())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAccountAnalyticsTypes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccountAnalyticsTypes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccountAnalyticsTypes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SetAnalyticsTypeRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetAnalyticsTypeRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountAnalyticsTypes");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountAnalyticsTypes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AccountAnalyticsType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AccountAnalyticsType"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
