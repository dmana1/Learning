/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.phi;

import business.patient.encounter.MedicationHistory;
import business.patient.encounter.VitalSign;
import java.util.Date;

/**
 *
 * @author Deepthi
 */
public class SharedEncounter {

    private Date encounterDate;
    private String problem;
    private String hospitalName;
    private VitalSign vitalSign;
    private MedicationHistory medicationHistory;
    private String diagonizedDisease;

    public SharedEncounter() {
        vitalSign = new VitalSign();
        medicationHistory = new MedicationHistory();

    }

    public Date getEncounterDate() {
        return encounterDate;
    }

    public void setEncounterDate(Date encounterDate) {
        this.encounterDate = encounterDate;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public VitalSign getVitalSign() {
        return vitalSign;
    }

    public void setVitalSign(VitalSign vitalSign) {
        this.vitalSign = vitalSign;
    }

    public MedicationHistory getMedicationHistory() {
        return medicationHistory;
    }

    public void setMedicationHistory(MedicationHistory medicationHistory) {
        this.medicationHistory = medicationHistory;
    }

    public String getDiagonizedDisease() {
        return diagonizedDisease;
    }

    public void setDiagonizedDisease(String diagonizedDisease) {
        this.diagonizedDisease = diagonizedDisease;
    }

}
