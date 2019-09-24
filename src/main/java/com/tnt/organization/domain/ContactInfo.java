package com.tnt.organization.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contactinfo")
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // INT(11) NOT NULL AUTO_INCREMENT,
    
    @Column(name = "contactid")
    private Integer contactId; // INT(11) NOT NULL,
    
    @Column(name = "positionid")
    private Integer positionId;// INT(11) NOT NULL,
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentid", referencedColumnName = "id")
    private Department department; // INT(10) UNSIGNED NOT NULL,
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizationid", referencedColumnName = "id")
    private Organization organization; // INT(11) NOT NULL,

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
     * @return the contactId
     */
    public Integer getContactId() {
        return contactId;
    }

    /**
     * @param contactId the contactId to set
     */
    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    /**
     * @return the positionId
     */
    public Integer getPositionId() {
        return positionId;
    }

    /**
     * @param positionId the positionId to set
     */
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    /**
     * @return the department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * @return the organization
     */
    public Organization getOrganization() {
        return organization;
    }

    /**
     * @param organization the organization to set
     */
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    
}
