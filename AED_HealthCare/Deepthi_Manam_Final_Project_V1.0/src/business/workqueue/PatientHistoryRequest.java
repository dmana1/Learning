/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.patient.adverseevents.AdverseEvent;
import business.patient.allergy.Allergy;
import business.patient.encounter.EncounterHistory;
import business.patient.labtest.LabTest;
import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class PatientHistoryRequest extends WorkRequest{
    private int requestNo;
    private String patientUniqueCode;
    private String patientFoundResult;
    private EncounterHistory encounterHistory;
    private ArrayList<Allergy> allergyList;
    private ArrayList<AdverseEvent> adverseList;
    private ArrayList<LabTest> labTestList;
    private String senderEnterprise;
    private String sentToHospital;
    
  
    
    public PatientHistoryRequest(){
        encounterHistory = new EncounterHistory();
        allergyList = new ArrayList<Allergy>();
        adverseList = new ArrayList<AdverseEvent>();
        labTestList = new ArrayList<LabTest>();
    }

    public String getPatientUniqueCode() {
        return patientUniqueCode;
    }

    public void setPatientUniqueCode(String patientUniqueCode) {
        this.patientUniqueCode = patientUniqueCode;
    }

    public int getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(int requestNo) {
        this.requestNo = requestNo;
    }

    public String getPatientFoundResult() {
        return patientFoundResult;
    }

    public void setPatientFoundResult(String patientFoundResult) {
        this.patientFoundResult = patientFoundResult;
    }

    public EncounterHistory getEncounterHistory() {
        return encounterHistory;
    }

    public void setEncounterHistory(EncounterHistory encounterHistory) {
        this.encounterHistory = encounterHistory;
    }

    public String getSenderEnterprise() {
        return senderEnterprise;
    }

    public void setSenderEnterprise(String senderEnterprise) {
        this.senderEnterprise = senderEnterprise;
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

    public ArrayList<LabTest> getLabTestList() {
        return labTestList;
    }

    public void setLabTestList(ArrayList<LabTest> labTestList) {
        this.labTestList = labTestList;
    }

    public String getSentToHospital() {
        return sentToHospital;
    }

    public void setSentToHospital(String sentToHospital) {
        this.sentToHospital = sentToHospital;
    }


    
    
}
