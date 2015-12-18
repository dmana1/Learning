/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.patient.encounter;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Deepthi
 */
public class Encounter {

    private Date encounterDate;
    private String symptoms;
    private String hospitalName;
    private String hospitalLocation;
    private String doctorName;
    private VitalSign vitalSign;
    private ArrayList<Medication> medicationList;
    private String advice;
    private String diagonizedDisease;

    public Encounter() {
        encounterDate = new Date();
        medicationList = new ArrayList<Medication>();
        vitalSign = new VitalSign();
    }

    public Date getEncounterDate() {
        return encounterDate;
    }

    public void setEncounterDate(Date encounterDate) {
        this.encounterDate = encounterDate;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public VitalSign getVitalSign() {
        return vitalSign;
    }

    public void setVitalSign(VitalSign vitalSign) {
        this.vitalSign = vitalSign;
    }

    public ArrayList<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(ArrayList<Medication> medicationList) {
        this.medicationList = medicationList;
    }

    public String getAdvice() {
        return advice;
    }

    public String getDiagonizedDisease() {
        return diagonizedDisease;
    }

    public void setDiagonizedDisease(String diagonizedDisease) {
        this.diagonizedDisease = diagonizedDisease;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getHospitalLocation() {
        return hospitalLocation;
    }

    public void setHospitalLocation(String hospitalLocation) {
        this.hospitalLocation = hospitalLocation;
    }

    @Override
    public String toString() {
        return encounterDate.toString();
    }

}
