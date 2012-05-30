/**
 * GoalResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts;

public class GoalResult  implements java.io.Serializable {
    private java.lang.Long goalId;

    private long[] stepIds;

    public GoalResult() {
    }

    public GoalResult(
           java.lang.Long goalId,
           long[] stepIds) {
           this.goalId = goalId;
           this.stepIds = stepIds;
    }


    /**
     * Gets the goalId value for this GoalResult.
     * 
     * @return goalId
     */
    public java.lang.Long getGoalId() {
        return goalId;
    }


    /**
     * Sets the goalId value for this GoalResult.
     * 
     * @param goalId
     */
    public void setGoalId(java.lang.Long goalId) {
        this.goalId = goalId;
    }


    /**
     * Gets the stepIds value for this GoalResult.
     * 
     * @return stepIds
     */
    public long[] getStepIds() {
        return stepIds;
    }


    /**
     * Sets the stepIds value for this GoalResult.
     * 
     * @param stepIds
     */
    public void setStepIds(long[] stepIds) {
        this.stepIds = stepIds;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GoalResult)) return false;
        GoalResult other = (GoalResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.goalId==null && other.getGoalId()==null) || 
             (this.goalId!=null &&
              this.goalId.equals(other.getGoalId()))) &&
            ((this.stepIds==null && other.getStepIds()==null) || 
             (this.stepIds!=null &&
              java.util.Arrays.equals(this.stepIds, other.getStepIds())));
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
        if (getGoalId() != null) {
            _hashCode += getGoalId().hashCode();
        }
        if (getStepIds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStepIds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStepIds(), i);
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
        new org.apache.axis.description.TypeDesc(GoalResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "GoalResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("goalId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "GoalId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stepIds");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "StepIds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long"));
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
