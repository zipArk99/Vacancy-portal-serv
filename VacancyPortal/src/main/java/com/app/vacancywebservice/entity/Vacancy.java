/**
 * Vacancy.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4.1-SNAPSHOT Nov 07, 2023 (07:57:58 UTC) WSDL2Java emitter.
 */

package com.app.vacancywebservice.entity;

public class Vacancy  implements java.io.Serializable {
    private java.util.Calendar createdAt;

    private java.util.Calendar updatedAt;

    private java.lang.String vacancyExperience;

    private int vacancyId;

    private int vacancyNumberOfOpening;

    private int vacancySalary;

    private java.lang.String vacancyTitle;

    public Vacancy() {
    }

    public Vacancy(
           java.util.Calendar createdAt,
           java.util.Calendar updatedAt,
           java.lang.String vacancyExperience,
           int vacancyId,
           int vacancyNumberOfOpening,
           int vacancySalary,
           java.lang.String vacancyTitle) {
           this.createdAt = createdAt;
           this.updatedAt = updatedAt;
           this.vacancyExperience = vacancyExperience;
           this.vacancyId = vacancyId;
           this.vacancyNumberOfOpening = vacancyNumberOfOpening;
           this.vacancySalary = vacancySalary;
           this.vacancyTitle = vacancyTitle;
    }


    /**
     * Gets the createdAt value for this Vacancy.
     * 
     * @return createdAt
     */
    public java.util.Calendar getCreatedAt() {
        return createdAt;
    }


    /**
     * Sets the createdAt value for this Vacancy.
     * 
     * @param createdAt
     */
    public void setCreatedAt(java.util.Calendar createdAt) {
        this.createdAt = createdAt;
    }


    /**
     * Gets the updatedAt value for this Vacancy.
     * 
     * @return updatedAt
     */
    public java.util.Calendar getUpdatedAt() {
        return updatedAt;
    }


    /**
     * Sets the updatedAt value for this Vacancy.
     * 
     * @param updatedAt
     */
    public void setUpdatedAt(java.util.Calendar updatedAt) {
        this.updatedAt = updatedAt;
    }


    /**
     * Gets the vacancyExperience value for this Vacancy.
     * 
     * @return vacancyExperience
     */
    public java.lang.String getVacancyExperience() {
        return vacancyExperience;
    }


    /**
     * Sets the vacancyExperience value for this Vacancy.
     * 
     * @param vacancyExperience
     */
    public void setVacancyExperience(java.lang.String vacancyExperience) {
        this.vacancyExperience = vacancyExperience;
    }


    /**
     * Gets the vacancyId value for this Vacancy.
     * 
     * @return vacancyId
     */
    public int getVacancyId() {
        return vacancyId;
    }


    /**
     * Sets the vacancyId value for this Vacancy.
     * 
     * @param vacancyId
     */
    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
    }


    /**
     * Gets the vacancyNumberOfOpening value for this Vacancy.
     * 
     * @return vacancyNumberOfOpening
     */
    public int getVacancyNumberOfOpening() {
        return vacancyNumberOfOpening;
    }


    /**
     * Sets the vacancyNumberOfOpening value for this Vacancy.
     * 
     * @param vacancyNumberOfOpening
     */
    public void setVacancyNumberOfOpening(int vacancyNumberOfOpening) {
        this.vacancyNumberOfOpening = vacancyNumberOfOpening;
    }


    /**
     * Gets the vacancySalary value for this Vacancy.
     * 
     * @return vacancySalary
     */
    public int getVacancySalary() {
        return vacancySalary;
    }


    /**
     * Sets the vacancySalary value for this Vacancy.
     * 
     * @param vacancySalary
     */
    public void setVacancySalary(int vacancySalary) {
        this.vacancySalary = vacancySalary;
    }


    /**
     * Gets the vacancyTitle value for this Vacancy.
     * 
     * @return vacancyTitle
     */
    public java.lang.String getVacancyTitle() {
        return vacancyTitle;
    }


    /**
     * Sets the vacancyTitle value for this Vacancy.
     * 
     * @param vacancyTitle
     */
    public void setVacancyTitle(java.lang.String vacancyTitle) {
        this.vacancyTitle = vacancyTitle;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Vacancy)) return false;
        Vacancy other = (Vacancy) obj;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.createdAt==null && other.getCreatedAt()==null) || 
             (this.createdAt!=null &&
              this.createdAt.equals(other.getCreatedAt()))) &&
            ((this.updatedAt==null && other.getUpdatedAt()==null) || 
             (this.updatedAt!=null &&
              this.updatedAt.equals(other.getUpdatedAt()))) &&
            ((this.vacancyExperience==null && other.getVacancyExperience()==null) || 
             (this.vacancyExperience!=null &&
              this.vacancyExperience.equals(other.getVacancyExperience()))) &&
            this.vacancyId == other.getVacancyId() &&
            this.vacancyNumberOfOpening == other.getVacancyNumberOfOpening() &&
            this.vacancySalary == other.getVacancySalary() &&
            ((this.vacancyTitle==null && other.getVacancyTitle()==null) || 
             (this.vacancyTitle!=null &&
              this.vacancyTitle.equals(other.getVacancyTitle())));
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
        if (getCreatedAt() != null) {
            _hashCode += getCreatedAt().hashCode();
        }
        if (getUpdatedAt() != null) {
            _hashCode += getUpdatedAt().hashCode();
        }
        if (getVacancyExperience() != null) {
            _hashCode += getVacancyExperience().hashCode();
        }
        _hashCode += getVacancyId();
        _hashCode += getVacancyNumberOfOpening();
        _hashCode += getVacancySalary();
        if (getVacancyTitle() != null) {
            _hashCode += getVacancyTitle().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Vacancy.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://entity.vacancywebservice.app.com", "Vacancy"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createdAt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entity.vacancywebservice.app.com", "createdAt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("updatedAt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entity.vacancywebservice.app.com", "updatedAt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vacancyExperience");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entity.vacancywebservice.app.com", "vacancyExperience"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vacancyId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entity.vacancywebservice.app.com", "vacancyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vacancyNumberOfOpening");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entity.vacancywebservice.app.com", "vacancyNumberOfOpening"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vacancySalary");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entity.vacancywebservice.app.com", "vacancySalary"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vacancyTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://entity.vacancywebservice.app.com", "vacancyTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
