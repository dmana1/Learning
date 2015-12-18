/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.patient;

import business.patient.adverseevents.AdverseEventHistory;
import business.patient.allergy.Allergy;
import business.patient.encounter.EncounterHistory;
import business.patient.labtest.LabTest;
import business.person.Person;
import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class Patient extends Person {

    private boolean detailsEnabled;
    private ArrayList<Allergy> allergyList;
    private EncounterHistory encounterHistory;
    private AdverseEventHistory adverseEventHistory;
    private ArrayList<LabTest> labTestList;

    public Patient() {
        allergyList = new ArrayList<Allergy>();
        encounterHistory = new EncounterHistory();
        adverseEventHistory = new AdverseEventHistory();
        labTestList = new ArrayList<LabTest>();

    }

    public ArrayList<Allergy> getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(ArrayList<Allergy> allergyList) {
        this.allergyList = allergyList;
    }

    public EncounterHistory getEncounterHistory() {
        return encounterHistory;
    }

    public void setEncounterRecord(EncounterHistory encounterRecord) {
        this.encounterHistory = encounterRecord;
    }

    public boolean isDetailsEnabled() {
        return detailsEnabled;
    }

    public void setDetailsEnabled(boolean detailsEnabled) {
        this.detailsEnabled = detailsEnabled;
    }

    public AdverseEventHistory getAdverseEventHistory() {
        return adverseEventHistory;
    }

    public void setAdverseEventHistory(AdverseEventHistory adverseEventHistory) {
        this.adverseEventHistory = adverseEventHistory;
    }

    public ArrayList<LabTest> getLabTestList() {
        return labTestList;
    }

    public void setLabTestList(ArrayList<LabTest> labTestList) {
        this.labTestList = labTestList;
    }

   

    @Override
    public String toString() {
        return String.valueOf(this.getId());
    }

}
