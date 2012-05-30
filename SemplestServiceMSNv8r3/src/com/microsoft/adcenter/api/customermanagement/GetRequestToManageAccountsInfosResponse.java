/**
 * GetRequestToManageAccountsInfosResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customermanagement;

public class GetRequestToManageAccountsInfosResponse  implements java.io.Serializable {
    private com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestInfo[] manageAccountsRequestInfos;

    public GetRequestToManageAccountsInfosResponse() {
    }

    public GetRequestToManageAccountsInfosResponse(
           com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestInfo[] manageAccountsRequestInfos) {
           this.manageAccountsRequestInfos = manageAccountsRequestInfos;
    }


    /**
     * Gets the manageAccountsRequestInfos value for this GetRequestToManageAccountsInfosResponse.
     * 
     * @return manageAccountsRequestInfos
     */
    public com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestInfo[] getManageAccountsRequestInfos() {
        return manageAccountsRequestInfos;
    }


    /**
     * Sets the manageAccountsRequestInfos value for this GetRequestToManageAccountsInfosResponse.
     * 
     * @param manageAccountsRequestInfos
     */
    public void setManageAccountsRequestInfos(com.microsoft.adcenter.api.customermanagement.Entities.ManageAccountsRequestInfo[] manageAccountsRequestInfos) {
        this.manageAccountsRequestInfos = manageAccountsRequestInfos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetRequestToManageAccountsInfosResponse)) return false;
        GetRequestToManageAccountsInfosResponse other = (GetRequestToManageAccountsInfosResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.manageAccountsRequestInfos==null && other.getManageAccountsRequestInfos()==null) || 
             (this.manageAccountsRequestInfos!=null &&
              java.util.Arrays.equals(this.manageAccountsRequestInfos, other.getManageAccountsRequestInfos())));
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
        if (getManageAccountsRequestInfos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getManageAccountsRequestInfos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getManageAccountsRequestInfos(), i);
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
        new org.apache.axis.description.TypeDesc(GetRequestToManageAccountsInfosResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", ">GetRequestToManageAccountsInfosResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("manageAccountsRequestInfos");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement", "ManageAccountsRequestInfos"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ManageAccountsRequestInfo"));
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
