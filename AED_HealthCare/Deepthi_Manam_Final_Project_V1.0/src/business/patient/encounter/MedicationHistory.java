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
public class MedicationHistory {

    private ArrayList<Medication> medicationList;

    public MedicationHistory() {
        medicationList = new ArrayList<Medication>();
    }

    public ArrayList<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(ArrayList<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    public Medication addMedication() {
        Medication medication = new Medication();
        medicationList.add(medication);
        return medication;
    }

    public void removeMedication(Medication medication) {
        medicationList.remove(medication);
    }

}
