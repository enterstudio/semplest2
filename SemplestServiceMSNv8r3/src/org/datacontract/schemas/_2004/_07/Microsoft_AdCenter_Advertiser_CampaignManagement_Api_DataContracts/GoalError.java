/**
 * GoalError.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts;

public class GoalError  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.BatchError[] batchErrors;

    private java.lang.Integer index;

    private com.microsoft.adcenter.v8.BatchError[] stepErrors;

    public GoalError() {
    }

    public GoalError(
           com.microsoft.adcenter.v8.BatchError[] batchErrors,
           java.lang.Integer index,
           com.microsoft.adcenter.v8.BatchError[] stepErrors) {
           this.batchErrors = batchErrors;
           this.index = index;
           this.stepErrors = stepErrors;
    }


    /**
     * Gets the batchErrors value for this GoalError.
     * 
     * @return batchErrors
     */
    public com.microsoft.adcenter.v8.BatchError[] getBatchErrors() {
        return batchErrors;
    }


    /**
     * Sets the batchErrors value for this GoalError.
     * 
     * @param batchErrors
     */
    public void setBatchErrors(com.microsoft.adcenter.v8.BatchError[] batchErrors) {
        this.batchErrors = batchErrors;
    }


    /**
     * Gets the index value for this GoalError.
     * 
     * @return index
     */
    public java.lang.Integer getIndex() {
        return index;
    }


    /**
     * Sets the index value for this GoalError.
     * 
     * @param index
     */
    public void setIndex(java.lang.Integer index) {
        this.index = index;
    }


    /**
     * Gets the stepErrors value for this GoalError.
     * 
     * @return stepErrors
     */
    public com.microsoft.adcenter.v8.BatchError[] getStepErrors() {
        return stepErrors;
    }


    /**
     * Sets the stepErrors value for this GoalError.
     * 
     * @param stepErrors
     */
    public void setStepErrors(com.microsoft.adcenter.v8.BatchError[] stepErrors) {
        this.stepErrors = stepErrors;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GoalError)) return false;
        GoalError other = (GoalError) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.batchErrors==null && other.getBatchErrors()==null) || 
             (this.batchErrors!=null &&
              java.util.Arrays.equals(this.batchErrors, other.getBatchErrors()))) &&
            ((this.index==null && other.getIndex()==null) || 
             (this.index!=null &&
              this.index.equals(other.getIndex()))) &&
            ((this.stepErrors==null && other.getStepErrors()==null) || 
             (this.stepErrors!=null &&
              java.util.Arrays.equals(this.stepErrors, other.getStepErrors())));
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
        if (getBatchErrors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBatchErrors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBatchErrors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIndex() != null) {
            _hashCode += getIndex().hashCode();
        }
        if (getStepErrors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStepErrors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStepErrors(), i);
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
        new org.apache.axis.description.TypeDesc(GoalError.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "GoalError"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("batchErrors");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "BatchErrors"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BatchError"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BatchError"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("index");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Index"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stepErrors");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "StepErrors"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BatchError"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BatchError"));
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
