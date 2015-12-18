/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.patient.encounter;

import business.drug.Drug;

/**
 *
 * @author Deepthi
 */
public class Medication {
    
    private Drug drug;
    private int dosage;

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

   
    
      @Override
    public String toString() {
        return getDrug().getDrugName();
    }
}
