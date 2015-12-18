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
public class RollbackWorkRequest extends WorkRequest {

    private int requestId;
    private Drug drug;
    private String senderEnterprise;

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public String getSenderEnterprise() {
        return senderEnterprise;
    }

    public void setSenderEnterprise(String senderEnterprise) {
        this.senderEnterprise = senderEnterprise;
    }

    @Override
    public String toString() {
        return  String.valueOf(requestId) ;
    }

}
