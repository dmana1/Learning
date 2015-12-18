/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.role.DoctorRole;
import business.role.PatientManagerRole;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class PatientManagerOrganization  extends Organization  {
    public PatientManagerOrganization() {
        super(Organization.Type.PatientManagement.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new PatientManagerRole());
        return roles;
    }
    
}
