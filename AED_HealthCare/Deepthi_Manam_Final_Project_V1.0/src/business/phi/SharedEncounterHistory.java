/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.phi;

import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class SharedEncounterHistory {
    
    private ArrayList<SharedEncounter> sharedEncounterList;
    
    public SharedEncounterHistory(){
        sharedEncounterList = new ArrayList<SharedEncounter>();
    }

    public ArrayList<SharedEncounter> getSharedEncounterList() {
        return sharedEncounterList;
    }
    
    public SharedEncounter addSharedEncounter(){
        SharedEncounter se = new SharedEncounter();
        sharedEncounterList.add(se);
        return se;
    }
    
    
    
}
