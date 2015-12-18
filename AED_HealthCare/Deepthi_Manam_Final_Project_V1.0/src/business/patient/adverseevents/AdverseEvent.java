/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.patient.adverseevents;

import business.drug.Drug;

/**
 *
 * @author Deepthi
 */
public class AdverseEvent {
    
    private Drug drug;
    private String adverseEvent;

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public String getAdverseEvent() {
        return adverseEvent;
    }

    public void setAdverseEvent(String adverseEvent) {
        this.adverseEvent = adverseEvent;
    }
    
    
    
}
