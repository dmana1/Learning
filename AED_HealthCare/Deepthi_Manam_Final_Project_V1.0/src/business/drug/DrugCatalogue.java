/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.drug;

import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class DrugCatalogue {
    
    private ArrayList<Drug> drugsList;
    
    public DrugCatalogue(){
        drugsList = new ArrayList<Drug>();
        
    }

    public ArrayList<Drug> getDrugsList() {
        return drugsList;
    }

    public void setDrugsList(ArrayList<Drug> drugsList) {
        this.drugsList = drugsList;
    }
    
    public Drug AddDrug(){
        Drug d = new Drug();
        drugsList.add(d);
        return d;
    }
    
    public void removeDrug(Drug drug){
        drugsList.remove(drug);
    }
    
    public Drug searchDrug(String drugName){
        for(Drug drug : drugsList){
            if(drugName.equalsIgnoreCase(drug.getDrugName())){
                return drug;
            }
        }
        return null;
    }
}
