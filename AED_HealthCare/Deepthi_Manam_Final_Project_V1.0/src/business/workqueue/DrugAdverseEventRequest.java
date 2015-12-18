/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.drug.Drug;

/**
 *
 * @author Deepthi
 */
public class DrugAdverseEventRequest extends WorkRequest {
    
    private Drug drug;
    private String adverseEvent;
    private int requestId;
    private String senderHospital;

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

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getSenderHospital() {
        return senderHospital;
    }

    public void setSenderHospital(String senderHospital) {
        this.senderHospital = senderHospital;
    }

  

    @Override
    public String toString() {
        return String.valueOf(requestId);
    }
    
    
    
    
}
