/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.patient.Patient;
import business.patient.encounter.Medication;
import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class PrescriptionRequest extends WorkRequest{
    
    private Patient  patient;
    private ArrayList<Medication> medicinesList;
    private String senderHospital;
    private String senderHospitalAddress;
    private int requestId;
    
    public PrescriptionRequest(){
        medicinesList = new ArrayList<Medication>();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public ArrayList<Medication> getMedicinesList() {
        return medicinesList;
    }

    public void setMedicinesList(ArrayList<Medication> medicinesList) {
        this.medicinesList = medicinesList;
    }

    public String getSenderHospital() {
        return senderHospital;
    }

    public void setSenderHospital(String senderHospital) {
        this.senderHospital = senderHospital;
    }

    public String getSenderHospitalAddress() {
        return senderHospitalAddress;
    }

    public void setSenderHospitalAddress(String senderHospitalAddress) {
        this.senderHospitalAddress = senderHospitalAddress;
    }

    
    
    
    
    
    
}
