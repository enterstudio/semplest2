/**
 * Campaign.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class Campaign  implements java.io.Serializable {
    private com.microsoft.adcenter.v8.BudgetLimitType budgetType;

    private java.lang.Boolean conversionTrackingEnabled;

    private java.lang.Double dailyBudget;

    private java.lang.Boolean daylightSaving;

    private java.lang.String description;

    private java.lang.Long id;

    private java.lang.Double monthlyBudget;

    private java.lang.String name;

    private com.microsoft.adcenter.v8.CampaignStatus status;

    private java.lang.String timeZone;

    public Campaign() {
    }

    public Campaign(
           com.microsoft.adcenter.v8.BudgetLimitType budgetType,
           java.lang.Boolean conversionTrackingEnabled,
           java.lang.Double dailyBudget,
           java.lang.Boolean daylightSaving,
           java.lang.String description,
           java.lang.Long id,
           java.lang.Double monthlyBudget,
           java.lang.String name,
           com.microsoft.adcenter.v8.CampaignStatus status,
           java.lang.String timeZone) {
           this.budgetType = budgetType;
           this.conversionTrackingEnabled = conversionTrackingEnabled;
           this.dailyBudget = dailyBudget;
           this.daylightSaving = daylightSaving;
           this.description = description;
           this.id = id;
           this.monthlyBudget = monthlyBudget;
           this.name = name;
           this.status = status;
           this.timeZone = timeZone;
    }


    /**
     * Gets the budgetType value for this Campaign.
     * 
     * @return budgetType
     */
    public com.microsoft.adcenter.v8.BudgetLimitType getBudgetType() {
        return budgetType;
    }


    /**
     * Sets the budgetType value for this Campaign.
     * 
     * @param budgetType
     */
    public void setBudgetType(com.microsoft.adcenter.v8.BudgetLimitType budgetType) {
        this.budgetType = budgetType;
    }


    /**
     * Gets the conversionTrackingEnabled value for this Campaign.
     * 
     * @return conversionTrackingEnabled
     */
    public java.lang.Boolean getConversionTrackingEnabled() {
        return conversionTrackingEnabled;
    }


    /**
     * Sets the conversionTrackingEnabled value for this Campaign.
     * 
     * @param conversionTrackingEnabled
     */
    public void setConversionTrackingEnabled(java.lang.Boolean conversionTrackingEnabled) {
        this.conversionTrackingEnabled = conversionTrackingEnabled;
    }


    /**
     * Gets the dailyBudget value for this Campaign.
     * 
     * @return dailyBudget
     */
    public java.lang.Double getDailyBudget() {
        return dailyBudget;
    }


    /**
     * Sets the dailyBudget value for this Campaign.
     * 
     * @param dailyBudget
     */
    public void setDailyBudget(java.lang.Double dailyBudget) {
        this.dailyBudget = dailyBudget;
    }


    /**
     * Gets the daylightSaving value for this Campaign.
     * 
     * @return daylightSaving
     */
    public java.lang.Boolean getDaylightSaving() {
        return daylightSaving;
    }


    /**
     * Sets the daylightSaving value for this Campaign.
     * 
     * @param daylightSaving
     */
    public void setDaylightSaving(java.lang.Boolean daylightSaving) {
        this.daylightSaving = daylightSaving;
    }


    /**
     * Gets the description value for this Campaign.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Campaign.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the id value for this Campaign.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this Campaign.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the monthlyBudget value for this Campaign.
     * 
     * @return monthlyBudget
     */
    public java.lang.Double getMonthlyBudget() {
        return monthlyBudget;
    }


    /**
     * Sets the monthlyBudget value for this Campaign.
     * 
     * @param monthlyBudget
     */
    public void setMonthlyBudget(java.lang.Double monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }


    /**
     * Gets the name value for this Campaign.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Campaign.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the status value for this Campaign.
     * 
     * @return status
     */
    public com.microsoft.adcenter.v8.CampaignStatus getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Campaign.
     * 
     * @param status
     */
    public void setStatus(com.microsoft.adcenter.v8.CampaignStatus status) {
        this.status = status;
    }


    /**
     * Gets the timeZone value for this Campaign.
     * 
     * @return timeZone
     */
    public java.lang.String getTimeZone() {
        return timeZone;
    }


    /**
     * Sets the timeZone value for this Campaign.
     * 
     * @param timeZone
     */
    public void setTimeZone(java.lang.String timeZone) {
        this.timeZone = timeZone;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Campaign)) return false;
        Campaign other = (Campaign) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.budgetType==null && other.getBudgetType()==null) || 
             (this.budgetType!=null &&
              this.budgetType.equals(other.getBudgetType()))) &&
            ((this.conversionTrackingEnabled==null && other.getConversionTrackingEnabled()==null) || 
             (this.conversionTrackingEnabled!=null &&
              this.conversionTrackingEnabled.equals(other.getConversionTrackingEnabled()))) &&
            ((this.dailyBudget==null && other.getDailyBudget()==null) || 
             (this.dailyBudget!=null &&
              this.dailyBudget.equals(other.getDailyBudget()))) &&
            ((this.daylightSaving==null && other.getDaylightSaving()==null) || 
             (this.daylightSaving!=null &&
              this.daylightSaving.equals(other.getDaylightSaving()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.monthlyBudget==null && other.getMonthlyBudget()==null) || 
             (this.monthlyBudget!=null &&
              this.monthlyBudget.equals(other.getMonthlyBudget()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.timeZone==null && other.getTimeZone()==null) || 
             (this.timeZone!=null &&
              this.timeZone.equals(other.getTimeZone())));
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
        if (getBudgetType() != null) {
            _hashCode += getBudgetType().hashCode();
        }
        if (getConversionTrackingEnabled() != null) {
            _hashCode += getConversionTrackingEnabled().hashCode();
        }
        if (getDailyBudget() != null) {
            _hashCode += getDailyBudget().hashCode();
        }
        if (getDaylightSaving() != null) {
            _hashCode += getDaylightSaving().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getMonthlyBudget() != null) {
            _hashCode += getMonthlyBudget().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getTimeZone() != null) {
            _hashCode += getTimeZone().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Campaign.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Campaign"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("budgetType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BudgetType"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BudgetLimitType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("conversionTrackingEnabled");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ConversionTrackingEnabled"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dailyBudget");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DailyBudget"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("daylightSaving");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DaylightSaving"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monthlyBudget");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MonthlyBudget"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignStatus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeZone");
        elemField.setXmlName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TimeZone"));
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
