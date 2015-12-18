/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.role.DoctorRole;
import business.role.DrugManufacturerRole;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class DoctorOrganization extends Organization {
    public DoctorOrganization() {
        super(Organization.Type.DoctorOrganization.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new DoctorRole());
        return roles;
    }
    
}
