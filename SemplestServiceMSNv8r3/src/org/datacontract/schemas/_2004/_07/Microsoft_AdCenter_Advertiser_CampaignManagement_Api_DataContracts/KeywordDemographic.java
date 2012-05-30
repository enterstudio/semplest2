/**
 * KeywordDemographic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts;

public class KeywordDemographic  implements java.io.Serializable {
    private java.lang.Double age18_24;

    private java.lang.Double age25_34;

    private java.lang.Double age35_49;

    private java.lang.Double age50_64;

    private java.lang.Double age65Plus;

    private java.lang.Double ageUnknown;

    private java.lang.Double female;

    private java.lang.Double male;

    private java.lang.Double genderUnknown;

    public KeywordDemographic() {
    }

    public KeywordDemographic(
           java.lang.Double age18_24,
           java.lang.Double age25_34,
           java.lang.Double age35_49,
           java.lang.Double age50_64,
           java.lang.Double age65Plus,
           java.lang.Double ageUnknown,
           java.lang.Double female,
           java.lang.Double male,
           java.lang.Double genderUnknown) {
           this.age18_24 = age18_24;
           this.age25_34 = age25_34;
           this.age35_49 = age35_49;
           this.age50_64 = age50_64;
           this.age65Plus = age65Plus;
           this.ageUnknown = ageUnknown;
           this.female = female;
           this.male = male;
           this.genderUnknown = genderUnknown;
    }


    /**
     * Gets the age18_24 value for this KeywordDemographic.
     * 
     * @return age18_24
     */
    public java.lang.Double getAge18_24() {
        return age18_24;
    }


    /**
     * Sets the age18_24 value for this KeywordDemographic.
     * 
     * @param age18_24
     */
    public void setAge18_24(java.lang.Double age18_24) {
        this.age18_24 = age18_24;
    }


    /**
     * Gets the age25_34 value for this KeywordDemographic.
     * 
     * @return age25_34
     */
    public java.lang.Double getAge25_34() {
        return age25_34;
    }


    /**
     * Sets the age25_34 value for this KeywordDemographic.
     * 
     * @param age25_34
     */
    public void setAge25_34(java.lang.Double age25_34) {
        this.age25_34 = age25_34;
    }


    /**
     * Gets the age35_49 value for this KeywordDemographic.
     * 
     * @return age35_49
     */
    public java.lang.Double getAge35_49() {
        return age35_49;
    }


    /**
     * Sets the age35_49 value for this KeywordDemographic.
     * 
     * @param age35_49
     */
    public void setAge35_49(java.lang.Double age35_49) {
        this.age35_49 = age35_49;
    }


    /**
     * Gets the age50_64 value for this KeywordDemographic.
     * 
     * @return age50_64
     */
    public java.lang.Double getAge50_64() {
        return age50_64;
    }


    /**
     * Sets the age50_64 value for this KeywordDemographic.
     * 
     * @param age50_64
     */
    public void setAge50_64(java.lang.Double age50_64) {
        this.age50_64 = age50_64;
    }


    /**
     * Gets the age65Plus value for this KeywordDemographic.
     * 
     * @return age65Plus
     */
    public java.lang.Double getAge65Plus() {
        return age65Plus;
    }


    /**
     * Sets the age65Plus value for this KeywordDemographic.
     * 
     * @param age65Plus
     */
    public void setAge65Plus(java.lang.Double age65Plus) {
        this.age65Plus = age65Plus;
    }


    /**
     * Gets the ageUnknown value for this KeywordDemographic.
     * 
     * @return ageUnknown
     */
    public java.lang.Double getAgeUnknown() {
        return ageUnknown;
    }


    /**
     * Sets the ageUnknown value for this KeywordDemographic.
     * 
     * @param ageUnknown
     */
    public void setAgeUnknown(java.lang.Double ageUnknown) {
        this.ageUnknown = ageUnknown;
    }


    /**
     * Gets the female value for this KeywordDemographic.
     * 
     * @return female
     */
    public java.lang.Double getFemale() {
        return female;
    }


    /**
     * Sets the female value for this KeywordDemographic.
     * 
     * @param female
     */
    public void setFemale(java.lang.Double female) {
        this.female = female;
    }


    /**
     * Gets the male value for this KeywordDemographic.
     * 
     * @return male
     */
    public java.lang.Double getMale() {
        return male;
    }


    /**
     * Sets the male value for this KeywordDemographic.
     * 
     * @param male
     */
    public void setMale(java.lang.Double male) {
        this.male = male;
    }


    /**
     * Gets the genderUnknown value for this KeywordDemographic.
     * 
     * @return genderUnknown
     */
    public java.lang.Double getGenderUnknown() {
        return genderUnknown;
    }


    /**
     * Sets the genderUnknown value for this KeywordDemographic.
     * 
     * @param genderUnknown
     */
    public void setGenderUnknown(java.lang.Double genderUnknown) {
        this.genderUnknown = genderUnknown;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof KeywordDemographic)) return false;
        KeywordDemographic other = (KeywordDemographic) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.age18_24==null && other.getAge18_24()==null) || 
             (this.age18_24!=null &&
              this.age18_24.equals(other.getAge18_24()))) &&
            ((this.age25_34==null && other.getAge25_34()==null) || 
             (this.age25_34!=null &&
              this.age25_34.equals(other.getAge25_34()))) &&
            ((this.age35_49==null && other.getAge35_49()==null) || 
             (this.age35_49!=null &&
              this.age35_49.equals(other.getAge35_49()))) &&
            ((this.age50_64==null && other.getAge50_64()==null) || 
             (this.age50_64!=null &&
              this.age50_64.equals(other.getAge50_64()))) &&
            ((this.age65Plus==null && other.getAge65Plus()==null) || 
             (this.age65Plus!=null &&
              this.age65Plus.equals(other.getAge65Plus()))) &&
            ((this.ageUnknown==null && other.getAgeUnknown()==null) || 
             (this.ageUnknown!=null &&
              this.ageUnknown.equals(other.getAgeUnknown()))) &&
            ((this.female==null && other.getFemale()==null) || 
             (this.female!=null &&
              this.female.equals(other.getFemale()))) &&
            ((this.male==null && other.getMale()==null) || 
             (this.male!=null &&
              this.male.equals(other.getMale()))) &&
            ((this.genderUnknown==null && other.getGenderUnknown()==null) || 
             (this.genderUnknown!=null &&
              this.genderUnknown.equals(other.getGenderUnknown())));
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
        if (getAge18_24() != null) {
            _hashCode += getAge18_24().hashCode();
        }
        if (getAge25_34() != null) {
            _hashCode += getAge25_34().hashCode();
        }
        if (getAge35_49() != null) {
            _hashCode += getAge35_49().hashCode();
        }
        if (getAge50_64() != null) {
            _hashCode += getAge50_64().hashCode();
        }
        if (getAge65Plus() != null) {
            _hashCode += getAge65Plus().hashCode();
        }
        if (getAgeUnknown() != null) {
            _hashCode += getAgeUnknown().hashCode();
        }
        if (getFemale() != null) {
            _hashCode += getFemale().hashCode();
        }
        if (getMale() != null) {
            _hashCode += getMale().hashCode();
        }
        if (getGenderUnknown() != null) {
            _hashCode += getGenderUnknown().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(KeywordDemographic.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordDemographic"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("age18_24");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Age18_24"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("age25_34");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Age25_34"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("age35_49");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Age35_49"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("age50_64");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Age50_64"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("age65Plus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Age65Plus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ageUnknown");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AgeUnknown"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("female");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Female"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("male");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Male"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("genderUnknown");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "GenderUnknown"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
