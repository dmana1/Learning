/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.patient.Patient;
import business.patient.adverseevents.AdverseEvent;
import business.patient.allergy.Allergy;
import business.patient.encounter.Encounter;
import business.patient.labtest.LabTest;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Deepthi
 */
public class EmergencyRequest extends WorkRequest {
    
    private String firstName;
    private String lastName;
    private String ssn;
    private Date dob;
    private String uniqueCode;
    private File image;
    private String hospitalName;
    private ArrayList<Encounter> encounterList;
    private ArrayList<Allergy> allergyList;
    private ArrayList<AdverseEvent> adverseList;
    private ArrayList<LabTest> labTestList;
    private Patient patientOfHospital;
    
    
    public EmergencyRequest(){
        encounterList = new ArrayList<Encounter>();
        allergyList = new ArrayList<Allergy>();
        adverseList = new ArrayList<AdverseEvent>();
        labTestList = new ArrayList<LabTest>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public ArrayList<Encounter> getEncounterList() {
        return encounterList;
    }

    public void setEncounterList(ArrayList<Encounter> encounterList) {
        this.encounterList = encounterList;
    }

    public ArrayList<Allergy> getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(ArrayList<Allergy> allergyList) {
        this.allergyList = allergyList;
    }

    public ArrayList<AdverseEvent> getAdverseList() {
        return adverseList;
    }

    public void setAdverseList(ArrayList<AdverseEvent> adverseList) {
        this.adverseList = adverseList;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Patient getPatientOfHospital() {
        return patientOfHospital;
    }

    public void setPatientOfHospital(Patient patientOfHospital) {
        this.patientOfHospital = patientOfHospital;
    }

    public ArrayList<LabTest> getLabTestList() {
        return labTestList;
    }

    public void setLabTestList(ArrayList<LabTest> labTestList) {
        this.labTestList = labTestList;
    }
    
    
}
