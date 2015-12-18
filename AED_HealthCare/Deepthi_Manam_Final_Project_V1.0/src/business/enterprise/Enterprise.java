/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.organization.Organization;
import business.organization.OrganizationDirectory;

/**
 *
 * @author Deepthi
 */
public abstract class Enterprise extends Organization {
    
    
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    
    
    private String location;
    private long contactNumber;
    private String contactEmail;

    public Enterprise(String name, EnterpriseType type) {
        super(name);
        this.organizationDirectory = new OrganizationDirectory();
        this.enterpriseType = type;
    }

    public enum EnterpriseType {

        Hospital("Hospital"),
        Pharmacy("Pharmacy"),
        DrugCompany("DrugCompany");

        private EnterpriseType(String value) {
            this.value = value;
        }
        private String value;

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }

    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

  
    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    
    

}
