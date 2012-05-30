/**
 * Goal.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts;

public class Goal  implements java.io.Serializable {
    private java.lang.String[] costModel;

    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.DaysApplicableForConversion daysApplicableForConversion;

    private java.lang.Long id;

    private java.lang.String name;

    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.RevenueModel revenueModel;

    private org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.Step[] steps;

    private java.lang.Integer YEventId;

    public Goal() {
    }

    public Goal(
           java.lang.String[] costModel,
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.DaysApplicableForConversion daysApplicableForConversion,
           java.lang.Long id,
           java.lang.String name,
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.RevenueModel revenueModel,
           org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.Step[] steps,
           java.lang.Integer YEventId) {
           this.costModel = costModel;
           this.daysApplicableForConversion = daysApplicableForConversion;
           this.id = id;
           this.name = name;
           this.revenueModel = revenueModel;
           this.steps = steps;
           this.YEventId = YEventId;
    }


    /**
     * Gets the costModel value for this Goal.
     * 
     * @return costModel
     */
    public java.lang.String[] getCostModel() {
        return costModel;
    }


    /**
     * Sets the costModel value for this Goal.
     * 
     * @param costModel
     */
    public void setCostModel(java.lang.String[] costModel) {
        this.costModel = costModel;
    }


    /**
     * Gets the daysApplicableForConversion value for this Goal.
     * 
     * @return daysApplicableForConversion
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.DaysApplicableForConversion getDaysApplicableForConversion() {
        return daysApplicableForConversion;
    }


    /**
     * Sets the daysApplicableForConversion value for this Goal.
     * 
     * @param daysApplicableForConversion
     */
    public void setDaysApplicableForConversion(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.DaysApplicableForConversion daysApplicableForConversion) {
        this.daysApplicableForConversion = daysApplicableForConversion;
    }


    /**
     * Gets the id value for this Goal.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this Goal.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the name value for this Goal.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Goal.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the revenueModel value for this Goal.
     * 
     * @return revenueModel
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.RevenueModel getRevenueModel() {
        return revenueModel;
    }


    /**
     * Sets the revenueModel value for this Goal.
     * 
     * @param revenueModel
     */
    public void setRevenueModel(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.RevenueModel revenueModel) {
        this.revenueModel = revenueModel;
    }


    /**
     * Gets the steps value for this Goal.
     * 
     * @return steps
     */
    public org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.Step[] getSteps() {
        return steps;
    }


    /**
     * Sets the steps value for this Goal.
     * 
     * @param steps
     */
    public void setSteps(org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.Step[] steps) {
        this.steps = steps;
    }


    /**
     * Gets the YEventId value for this Goal.
     * 
     * @return YEventId
     */
    public java.lang.Integer getYEventId() {
        return YEventId;
    }


    /**
     * Sets the YEventId value for this Goal.
     * 
     * @param YEventId
     */
    public void setYEventId(java.lang.Integer YEventId) {
        this.YEventId = YEventId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Goal)) return false;
        Goal other = (Goal) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.costModel==null && other.getCostModel()==null) || 
             (this.costModel!=null &&
              java.util.Arrays.equals(this.costModel, other.getCostModel()))) &&
            ((this.daysApplicableForConversion==null && other.getDaysApplicableForConversion()==null) || 
             (this.daysApplicableForConversion!=null &&
              this.daysApplicableForConversion.equals(other.getDaysApplicableForConversion()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.revenueModel==null && other.getRevenueModel()==null) || 
             (this.revenueModel!=null &&
              this.revenueModel.equals(other.getRevenueModel()))) &&
            ((this.steps==null && other.getSteps()==null) || 
             (this.steps!=null &&
              java.util.Arrays.equals(this.steps, other.getSteps()))) &&
            ((this.YEventId==null && other.getYEventId()==null) || 
             (this.YEventId!=null &&
              this.YEventId.equals(other.getYEventId())));
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
        if (getCostModel() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCostModel());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCostModel(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDaysApplicableForConversion() != null) {
            _hashCode += getDaysApplicableForConversion().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getRevenueModel() != null) {
            _hashCode += getRevenueModel().hashCode();
        }
        if (getSteps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSteps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSteps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getYEventId() != null) {
            _hashCode += getYEventId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Goal.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Goal"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costModel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "CostModel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "CostModel"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("daysApplicableForConversion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "DaysApplicableForConversion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "DaysApplicableForConversion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revenueModel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "RevenueModel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "RevenueModel"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("steps");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Steps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Step"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Step"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("YEventId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "YEventId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
