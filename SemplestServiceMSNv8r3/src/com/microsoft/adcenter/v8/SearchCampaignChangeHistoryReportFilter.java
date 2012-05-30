/**
 * SearchCampaignChangeHistoryReportFilter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class SearchCampaignChangeHistoryReportFilter  implements java.io.Serializable {
    private java.lang.String[] howChanged;

    private java.lang.String[] itemChanged;

    public SearchCampaignChangeHistoryReportFilter() {
    }

    public SearchCampaignChangeHistoryReportFilter(
           java.lang.String[] howChanged,
           java.lang.String[] itemChanged) {
           this.howChanged = howChanged;
           this.itemChanged = itemChanged;
    }


    /**
     * Gets the howChanged value for this SearchCampaignChangeHistoryReportFilter.
     * 
     * @return howChanged
     */
    public java.lang.String[] getHowChanged() {
        return howChanged;
    }


    /**
     * Sets the howChanged value for this SearchCampaignChangeHistoryReportFilter.
     * 
     * @param howChanged
     */
    public void setHowChanged(java.lang.String[] howChanged) {
        this.howChanged = howChanged;
    }


    /**
     * Gets the itemChanged value for this SearchCampaignChangeHistoryReportFilter.
     * 
     * @return itemChanged
     */
    public java.lang.String[] getItemChanged() {
        return itemChanged;
    }


    /**
     * Sets the itemChanged value for this SearchCampaignChangeHistoryReportFilter.
     * 
     * @param itemChanged
     */
    public void setItemChanged(java.lang.String[] itemChanged) {
        this.itemChanged = itemChanged;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchCampaignChangeHistoryReportFilter)) return false;
        SearchCampaignChangeHistoryReportFilter other = (SearchCampaignChangeHistoryReportFilter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.howChanged==null && other.getHowChanged()==null) || 
             (this.howChanged!=null &&
              java.util.Arrays.equals(this.howChanged, other.getHowChanged()))) &&
            ((this.itemChanged==null && other.getItemChanged()==null) || 
             (this.itemChanged!=null &&
              java.util.Arrays.equals(this.itemChanged, other.getItemChanged())));
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
        if (getHowChanged() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHowChanged());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHowChanged(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getItemChanged() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItemChanged());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItemChanged(), i);
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
        new org.apache.axis.description.TypeDesc(SearchCampaignChangeHistoryReportFilter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SearchCampaignChangeHistoryReportFilter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("howChanged");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HowChanged"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ChangeTypeReportFilter"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itemChanged");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ItemChanged"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ChangeEntityReportFilter"));
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
