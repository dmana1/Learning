/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.patient.encounter;

import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class EncounterHistory {
    
     private ArrayList<Encounter> encounterList;
     
     public EncounterHistory(){
         encounterList = new ArrayList<Encounter>();
     }

    public ArrayList<Encounter> getEncounterList() {
        return encounterList;
    }

    public void setEncounterList(ArrayList<Encounter> encounterList) {
        this.encounterList = encounterList;
    }
    
    public Encounter addEncounter(){
        Encounter encounter = new Encounter();
        encounterList.add(encounter);
        return encounter;
    }
    
}
