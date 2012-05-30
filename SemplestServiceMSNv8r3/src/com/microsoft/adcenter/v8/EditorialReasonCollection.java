/**
 * EditorialReasonCollection.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class EditorialReasonCollection  implements java.io.Serializable {
    private java.lang.Long adOrKeywordId;

    private com.microsoft.adcenter.v8.EditorialReason[] reasons;

    public EditorialReasonCollection() {
    }

    public EditorialReasonCollection(
           java.lang.Long adOrKeywordId,
           com.microsoft.adcenter.v8.EditorialReason[] reasons) {
           this.adOrKeywordId = adOrKeywordId;
           this.reasons = reasons;
    }


    /**
     * Gets the adOrKeywordId value for this EditorialReasonCollection.
     * 
     * @return adOrKeywordId
     */
    public java.lang.Long getAdOrKeywordId() {
        return adOrKeywordId;
    }


    /**
     * Sets the adOrKeywordId value for this EditorialReasonCollection.
     * 
     * @param adOrKeywordId
     */
    public void setAdOrKeywordId(java.lang.Long adOrKeywordId) {
        this.adOrKeywordId = adOrKeywordId;
    }


    /**
     * Gets the reasons value for this EditorialReasonCollection.
     * 
     * @return reasons
     */
    public com.microsoft.adcenter.v8.EditorialReason[] getReasons() {
        return reasons;
    }


    /**
     * Sets the reasons value for this EditorialReasonCollection.
     * 
     * @param reasons
     */
    public void setReasons(com.microsoft.adcenter.v8.EditorialReason[] reasons) {
        this.reasons = reasons;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EditorialReasonCollection)) return false;
        EditorialReasonCollection other = (EditorialReasonCollection) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.adOrKeywordId==null && other.getAdOrKeywordId()==null) || 
             (this.adOrKeywordId!=null &&
              this.adOrKeywordId.equals(other.getAdOrKeywordId()))) &&
            ((this.reasons==null && other.getReasons()==null) || 
             (this.reasons!=null &&
              java.util.Arrays.equals(this.reasons, other.getReasons())));
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
        if (getAdOrKeywordId() != null) {
            _hashCode += getAdOrKeywordId().hashCode();
        }
        if (getReasons() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReasons());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReasons(), i);
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
        new org.apache.axis.description.TypeDesc(EditorialReasonCollection.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialReasonCollection"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adOrKeywordId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdOrKeywordId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reasons");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Reasons"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialReason"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialReason"));
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
