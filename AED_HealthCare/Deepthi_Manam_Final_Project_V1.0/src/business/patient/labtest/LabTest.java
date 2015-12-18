/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.patient.labtest;

import java.util.Date;

/**
 *
 * @author Deepthi
 */
public class LabTest {
    
    private int wbc;
    private int rbc;
    private  int lDL;
    private int hDL;
    private Date date;
    
    public LabTest(){
        date = new Date();
    }

    public int getWbc() {
        return wbc;
    }

    public void setWbc(int wbc) {
        this.wbc = wbc;
    }

    public int getRbc() {
        return rbc;
    }

    public void setRbc(int rbc) {
        this.rbc = rbc;
    }

    public int getlDL() {
        return lDL;
    }

    public void setlDL(int lDL) {
        this.lDL = lDL;
    }

    public int gethDL() {
        return hDL;
    }

    public void sethDL(int hDL) {
        this.hDL = hDL;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
