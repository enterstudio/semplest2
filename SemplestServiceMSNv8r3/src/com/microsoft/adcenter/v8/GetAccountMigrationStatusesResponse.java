/**
 * GetAccountMigrationStatusesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GetAccountMigrationStatusesResponse  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.AccountMigrationStatusesInfo[] migrationStatuses;

    public GetAccountMigrationStatusesResponse() {
    }

    public GetAccountMigrationStatusesResponse(
           com.microsoft.adcenter.v8.AccountMigrationStatusesInfo[] migrationStatuses) {
           this.migrationStatuses = migrationStatuses;
    }


    /**
     * Gets the migrationStatuses value for this GetAccountMigrationStatusesResponse.
     * 
     * @return migrationStatuses
     */
    public com.microsoft.adcenter.v8.AccountMigrationStatusesInfo[] getMigrationStatuses() {
        return migrationStatuses;
    }


    /**
     * Sets the migrationStatuses value for this GetAccountMigrationStatusesResponse.
     * 
     * @param migrationStatuses
     */
    public void setMigrationStatuses(com.microsoft.adcenter.v8.AccountMigrationStatusesInfo[] migrationStatuses) {
        this.migrationStatuses = migrationStatuses;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAccountMigrationStatusesResponse)) return false;
        GetAccountMigrationStatusesResponse other = (GetAccountMigrationStatusesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.migrationStatuses==null && other.getMigrationStatuses()==null) || 
             (this.migrationStatuses!=null &&
              java.util.Arrays.equals(this.migrationStatuses, other.getMigrationStatuses())));
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
        if (getMigrationStatuses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMigrationStatuses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMigrationStatuses(), i);
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
        new org.apache.axis.description.TypeDesc(GetAccountMigrationStatusesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAccountMigrationStatusesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("migrationStatuses");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MigrationStatuses"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountMigrationStatusesInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountMigrationStatusesInfo"));
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
