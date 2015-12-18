/*
 * Drug Mangement is a department in DrugCompany Enterprise.
 */
package business.organization;

import business.drug.DrugCatalogue;
import business.role.DrugManufacturerRole;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class DrugManagement extends Organization {

    public DrugManagement() {
        super(Organization.Type.DrugManagement.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new DrugManufacturerRole());
        return roles;
    }

}
