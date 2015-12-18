/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.patient;

import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class PatientDirectory {
    
    private ArrayList<Patient> patientsList;
    
    public PatientDirectory(){
        patientsList = new ArrayList<Patient>();
    }

    public ArrayList<Patient> getPatientsList() {
        return patientsList;
    }
    
    public Patient AddPatient() {
        Patient patient = new Patient();
        patientsList.add(patient);
        return patient;
    }

    public void removePatient(Patient patient) {
        patientsList.remove(patient);
    }

    public Patient searchPatient(String ssn) {
        for (Patient p : patientsList) {
            if((p.getSsn()).equals(ssn)) {
                return p;
            }
        }
        return null;
    }
    
}
