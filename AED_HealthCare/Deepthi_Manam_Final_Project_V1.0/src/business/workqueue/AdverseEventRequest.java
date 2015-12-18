/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.drug.Drug;
import business.enterprise.DrugCompanyEnterprise;

/**
 *
 * @author Deepthi
 */
public class AdverseEventRequest extends WorkRequest{
    
    private DrugCompanyEnterprise drugCompanyEnterprise;
    private Drug drug;
    private String adverseEvent;
    private int adverseEventId;
    private String result;
   
    public DrugCompanyEnterprise getDrugCompanyEnterprise() {
        return drugCompanyEnterprise;
    }

    public void setDrugCompanyEnterprise(DrugCompanyEnterprise drugCompanyEnterprise) {
        this.drugCompanyEnterprise = drugCompanyEnterprise;
    }

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

    public void setAdverseEventId(int adverseEventId) {
        this.adverseEventId = adverseEventId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return String.valueOf(adverseEventId);
    }

   
    
}
