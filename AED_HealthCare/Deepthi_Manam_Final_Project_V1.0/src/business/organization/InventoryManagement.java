/*
 * Inventory Management is 
 */
package business.organization;

import business.role.DrugManufacturerRole;
import business.role.PharmacistRole;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class InventoryManagement extends Organization{

    public InventoryManagement() {
       super(Organization.Type.InventoryManagement.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
         ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new PharmacistRole());
        return roles;
    }
    
}
