/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.role.LabAssitantRole;
import business.role.PharmacistRole;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class LabOrganization extends Organization{
      public LabOrganization() {
        super(Organization.Type.LabOrganization.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
         ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new LabAssitantRole());
        return roles;
    }
}
