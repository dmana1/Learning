/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<Organization>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }

    public Organization createOrganization(Type type) {
        Organization organization = null;
        if (type.getValue().equals(Type.DoctorOrganization.getValue())) {
            organization = new DoctorOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.LabOrganization.getValue())) {
            organization = new LabOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.DrugManagement.getValue())) {
            organization = new DrugManagement();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.PatientManagement.getValue())) {
            organization = new PatientManagerOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.InventoryManagement.getValue())) {
            organization = new InventoryManagement();
            organizationList.add(organization);
        }
        return organization;
    }

}
