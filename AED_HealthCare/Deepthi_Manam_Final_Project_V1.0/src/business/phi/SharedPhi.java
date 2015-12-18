/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.phi;

import business.patient.allergy.AllergyHistory;

/**
 *
 * @author Deepthi
 */
public class SharedPhi {
    
    private AllergyHistory allergyHistory;
    private SharedEncounterHistory sharedEncounterHistory;
    
    public SharedPhi(){
        allergyHistory = new AllergyHistory();
        sharedEncounterHistory = new SharedEncounterHistory();
    }

    public AllergyHistory getAllergyHistory() {
        return allergyHistory;
    }

    public void setAllergyHistory(AllergyHistory allergyHistory) {
        this.allergyHistory = allergyHistory;
    }

    public SharedEncounterHistory getSharedEncounterHistory() {
        return sharedEncounterHistory;
    }

    public void setSharedEncounterHistory(SharedEncounterHistory sharedEncounterHistory) {
        this.sharedEncounterHistory = sharedEncounterHistory;
    }
    
    
    
}
