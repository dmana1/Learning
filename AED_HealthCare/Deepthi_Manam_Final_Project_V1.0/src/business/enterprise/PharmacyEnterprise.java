/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.inventory.Inventory;
import business.role.Role;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Deepthi
 */
public class PharmacyEnterprise extends Enterprise {
    
    private Inventory inventory;
    

    public PharmacyEnterprise(String name) {
        super(name,EnterpriseType.Pharmacy);
       inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
    
}
