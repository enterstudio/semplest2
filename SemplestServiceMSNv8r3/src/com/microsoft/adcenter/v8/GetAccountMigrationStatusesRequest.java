/**
 * GetAccountMigrationStatusesRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class GetAccountMigrationStatusesRequest  implements java.io.Serializable {
    private long[] accountIds;

    private java.lang.String migrationType;

    public GetAccountMigrationStatusesRequest() {
    }

    public GetAccountMigrationStatusesRequest(
           long[] accountIds,
           java.lang.String migrationType) {
           this.accountIds = accountIds;
           this.migrationType = migrationType;
    }


    /**
     * Gets the accountIds value for this GetAccountMigrationStatusesRequest.
     * 
     * @return accountIds
     */
    public long[] getAccountIds() {
        return accountIds;
    }


    /**
     * Sets the accountIds value for this GetAccountMigrationStatusesRequest.
     * 
     * @param accountIds
     */
    public void setAccountIds(long[] accountIds) {
        this.accountIds = accountIds;
    }


    /**
     * Gets the migrationType value for this GetAccountMigrationStatusesRequest.
     * 
     * @return migrationType
     */
    public java.lang.String getMigrationType() {
        return migrationType;
    }


    /**
     * Sets the migrationType value for this GetAccountMigrationStatusesRequest.
     * 
     * @param migrationType
     */
    public void setMigrationType(java.lang.String migrationType) {
        this.migrationType = migrationType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAccountMigrationStatusesRequest)) return false;
        GetAccountMigrationStatusesRequest other = (GetAccountMigrationStatusesRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountIds==null && other.getAccountIds()==null) || 
             (this.accountIds!=null &&
              java.util.Arrays.equals(this.accountIds, other.getAccountIds()))) &&
            ((this.migrationType==null && other.getMigrationType()==null) || 
             (this.migrationType!=null &&
              this.migrationType.equals(other.getMigrationType())));
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
        if (getAccountIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccountIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccountIds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMigrationType() != null) {
            _hashCode += getMigrationType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAccountMigrationStatusesRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAccountMigrationStatusesRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountIds");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("migrationType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MigrationType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
