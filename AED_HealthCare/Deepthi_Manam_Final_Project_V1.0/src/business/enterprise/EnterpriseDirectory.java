/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.enterprise.Enterprise.EnterpriseType;
import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;
    
    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }

    //add/ create the enterprise
    public Enterprise addEnterprise(String name, EnterpriseType type) {
        Enterprise enterprise = null;

        //based on the enterprise type, create the enterprise
        if (type.equals(EnterpriseType.Hospital)) {
            enterprise = new HospitalEnterprise(name);
            enterpriseList.add(enterprise);
        }else if (type.equals(EnterpriseType.DrugCompany)) {
            enterprise = new DrugCompanyEnterprise(name);
            enterpriseList.add(enterprise);
        } else if (type.equals(EnterpriseType.Pharmacy)) {
            enterprise = new PharmacyEnterprise(name);
            enterpriseList.add(enterprise);
        } 
        return enterprise;
    }    
}
