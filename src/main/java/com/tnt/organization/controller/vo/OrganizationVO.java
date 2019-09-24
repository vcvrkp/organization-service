package com.tnt.organization.controller.vo;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.tnt.organization.domain.Department;

public class OrganizationVO {

    private Integer id;

    private Integer organizationTypeId;

    private Integer organizationISOCategoryId;

    private String name;

    private String cif;
    private String phone;
    private String street;
    private String number;
    private String locator;

    private String postalCode;

    private String city;
    private String state;
    private String country;
    private String fax;
    private String email;
    private String website;
    private String ftpsite;
    private String notes;

    private Integer ownerId;

    private Date insertDate;

    private Date updateDate;

    private String evaluationCriteria;

    private Set<Department> departments;

    private List<Project> projects;

    /**
     * @return the projects
     */
    public List<Project> getProjects() {
        return projects;
    }

    /**
     * @param projects the projects to set
     */
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the organizationTypeId
     */
    public Integer getOrganizationTypeId() {
        return organizationTypeId;
    }

    /**
     * @param organizationTypeId the organizationTypeId to set
     */
    public void setOrganizationTypeId(Integer organizationTypeId) {
        this.organizationTypeId = organizationTypeId;
    }

    /**
     * @return the organizationISOCategoryId
     */
    public Integer getOrganizationISOCategoryId() {
        return organizationISOCategoryId;
    }

    /**
     * @param organizationISOCategoryId the organizationISOCategoryId to set
     */
    public void setOrganizationISOCategoryId(Integer organizationISOCategoryId) {
        this.organizationISOCategoryId = organizationISOCategoryId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cif
     */
    public String getCif() {
        return cif;
    }

    /**
     * @param cif the cif to set
     */
    public void setCif(String cif) {
        this.cif = cif;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return the locator
     */
    public String getLocator() {
        return locator;
    }

    /**
     * @param locator the locator to set
     */
    public void setLocator(String locator) {
        this.locator = locator;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website the website to set
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return the ftpsite
     */
    public String getFtpsite() {
        return ftpsite;
    }

    /**
     * @param ftpsite the ftpsite to set
     */
    public void setFtpsite(String ftpsite) {
        this.ftpsite = ftpsite;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return the ownerId
     */
    public Integer getOwnerId() {
        return ownerId;
    }

    /**
     * @param ownerId the ownerId to set
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * @return the insertDate
     */
    public Date getInsertDate() {
        return insertDate;
    }

    /**
     * @param insertDate the insertDate to set
     */
    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    /**
     * @return the updateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate the updateDate to set
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return the evaluationCriteria
     */
    public String getEvaluationCriteria() {
        return evaluationCriteria;
    }

    /**
     * @param evaluationCriteria the evaluationCriteria to set
     */
    public void setEvaluationCriteria(String evaluationCriteria) {
        this.evaluationCriteria = evaluationCriteria;
    }

    /**
     * @return the departments
     */
    public Set<Department> getDepartments() {
        return departments;
    }

    /**
     * @param departments the departments to set
     */
    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

}
