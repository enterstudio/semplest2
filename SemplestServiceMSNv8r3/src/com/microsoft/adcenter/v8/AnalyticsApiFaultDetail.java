/**
 * AnalyticsApiFaultDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class AnalyticsApiFaultDetail  extends com.microsoft.adapi.ApplicationFault  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.GoalError[] goalErrors;

    private com.microsoft.adcenter.v8.OperationError[] operationErrors;

    public AnalyticsApiFaultDetail() {
    }

    public AnalyticsApiFaultDetail(
           java.lang.String trackingId,
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.GoalError[] goalErrors,
           com.microsoft.adcenter.v8.OperationError[] operationErrors) {
        super(
            trackingId);
        this.goalErrors = goalErrors;
        this.operationErrors = operationErrors;
    }


    /**
     * Gets the goalErrors value for this AnalyticsApiFaultDetail.
     * 
     * @return goalErrors
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.GoalError[] getGoalErrors() {
        return goalErrors;
    }


    /**
     * Sets the goalErrors value for this AnalyticsApiFaultDetail.
     * 
     * @param goalErrors
     */
    public void setGoalErrors(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.GoalError[] goalErrors) {
        this.goalErrors = goalErrors;
    }


    /**
     * Gets the operationErrors value for this AnalyticsApiFaultDetail.
     * 
     * @return operationErrors
     */
    public com.microsoft.adcenter.v8.OperationError[] getOperationErrors() {
        return operationErrors;
    }


    /**
     * Sets the operationErrors value for this AnalyticsApiFaultDetail.
     * 
     * @param operationErrors
     */
    public void setOperationErrors(com.microsoft.adcenter.v8.OperationError[] operationErrors) {
        this.operationErrors = operationErrors;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AnalyticsApiFaultDetail)) return false;
        AnalyticsApiFaultDetail other = (AnalyticsApiFaultDetail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.goalErrors==null && other.getGoalErrors()==null) || 
             (this.goalErrors!=null &&
              java.util.Arrays.equals(this.goalErrors, other.getGoalErrors()))) &&
            ((this.operationErrors==null && other.getOperationErrors()==null) || 
             (this.operationErrors!=null &&
              java.util.Arrays.equals(this.operationErrors, other.getOperationErrors())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getGoalErrors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGoalErrors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGoalErrors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOperationErrors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOperationErrors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOperationErrors(), i);
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
        new org.apache.axis.description.TypeDesc(AnalyticsApiFaultDetail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AnalyticsApiFaultDetail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("goalErrors");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GoalErrors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "GoalError"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "GoalError"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operationErrors");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "OperationErrors"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "OperationError"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "OperationError"));
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


    /**
     * Writes the exception data to the faultDetails
     */
    public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, this);
    }
}
