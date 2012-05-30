/**
 * GetAccountsInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement;

public class GetAccountsInfoResponse  implements java.io.Serializable {
    private com.microsoft.adcenter.api.customermanagement.Entities.AccountInfo[] accountsInfo;

    public GetAccountsInfoResponse() {
    }

    public GetAccountsInfoResponse(
           com.microsoft.adcenter.api.customermanagement.Entities.AccountInfo[] accountsInfo) {
           this.accountsInfo = accountsInfo;
    }


    /**
     * Gets the accountsInfo value for this GetAccountsInfoResponse.
     * 
     * @return accountsInfo
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.AccountInfo[] getAccountsInfo() {
        return accountsInfo;
    }


    /**
     * Sets the accountsInfo value for this GetAccountsInfoResponse.
     * 
     * @param accountsInfo
     */
    public void setAccountsInfo(com.microsoft.adcenter.api.customermanagement.Entities.AccountInfo[] accountsInfo) {
        this.accountsInfo = accountsInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAccountsInfoResponse)) return false;
        GetAccountsInfoResponse other = (GetAccountsInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountsInfo==null && other.getAccountsInfo()==null) || 
             (this.accountsInfo!=null &&
              java.util.Arrays.equals(this.accountsInfo, other.getAccountsInfo())));
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
        if (getAccountsInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccountsInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccountsInfo(), i);
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
        new org.apache.axis.description.TypeDesc(GetAccountsInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetAccountsInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountsInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "AccountsInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "AccountInfo"));
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
