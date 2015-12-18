/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.patient.encounter;

import java.util.Date;

/**
 *
 * @author Deepthi
 */
public class VitalSign {
    
    private int respiratoryRate;
    private int heartRate;
    private float systolicBloodPressure;
    private float weight;
    private Date createdOn;
    
    public VitalSign() {
        this.createdOn = new Date();
    }

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public float getSystolicBloodPressure() {
        return systolicBloodPressure;
    }

    public void setSystolicBloodPressure(float systolicBloodPressure) {
        this.systolicBloodPressure = systolicBloodPressure;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return createdOn.toString();
    }

    
    
    
}
