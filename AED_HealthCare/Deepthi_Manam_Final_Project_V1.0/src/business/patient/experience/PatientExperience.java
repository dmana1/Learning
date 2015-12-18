/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.patient.experience;

import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class PatientExperience {
    private ArrayList<Experience> experienceList;
    private String patientName;
    private String patientUniqueCode;

    public PatientExperience() {
        experienceList = new ArrayList<Experience>();
    }

    public ArrayList<Experience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(ArrayList<Experience> experienceList) {
        this.experienceList = experienceList;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientUniqueCode() {
        return patientUniqueCode;
    }

    public void setPatientUniqueCode(String patientUniqueCode) {
        this.patientUniqueCode = patientUniqueCode;
    }
    
    
}
