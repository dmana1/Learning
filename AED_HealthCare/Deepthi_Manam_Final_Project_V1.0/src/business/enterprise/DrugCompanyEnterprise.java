/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.drug.DrugCatalogue;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class DrugCompanyEnterprise extends Enterprise{

   private DrugCatalogue drugCatalogue;

    public DrugCompanyEnterprise(String name) {
        super(name,EnterpriseType.DrugCompany);
        drugCatalogue = new DrugCatalogue();
    }
    
    public DrugCatalogue getDrugCatalogue() {
        return drugCatalogue;
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
