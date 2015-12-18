/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.network;

import business.enterprise.DrugCompanyEnterprise;
import business.enterprise.Enterprise;
import business.enterprise.EnterpriseDirectory;
import business.enterprise.PharmacyEnterprise;
import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class Network {
    private String name;
    private EnterpriseDirectory enterpriseDir;
    private ArrayList<Network> subNetworkList;
    
    public Network(){
        enterpriseDir = new EnterpriseDirectory();
        subNetworkList = new ArrayList<Network>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseDir() {
        return enterpriseDir;
    }

    public void setEnterpriseDir(EnterpriseDirectory enterpriseDir) {
        this.enterpriseDir = enterpriseDir;
    }

    public ArrayList<Network> getSubNetworkList() {
        return subNetworkList;
    }

    public void setSubNetworkList(ArrayList<Network> subNetworkList) {
        this.subNetworkList = subNetworkList;
    }
    
    //list of pharmacies in that state
    public ArrayList<PharmacyEnterprise> getAllPharmaciesInNetwork() {
        ArrayList<PharmacyEnterprise> pharmaciesList = new ArrayList<PharmacyEnterprise>();

        for (Enterprise enterprise : enterpriseDir.getEnterpriseList()) {
            if (enterprise instanceof PharmacyEnterprise) {
                PharmacyEnterprise pharmacy = (PharmacyEnterprise) enterprise;
                pharmaciesList.add(pharmacy);

            }
        }

        return pharmaciesList;
    }
    @Override
    public String toString() {
        return  name;
    }
    
    
}
