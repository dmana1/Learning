/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.info.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Deepthi
 */
public class Posting implements Serializable{

    private String documentName;
    private int frequency;
    private int invertedFrequency;
    private ArrayList<Integer> positionOfTerm;
    private Date creationTime;
    private double sizeOfDocument;

    public Posting() {
        positionOfTerm = new ArrayList<Integer>();
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getInvertedFrequency() {
        return invertedFrequency;
    }

    public void setInvertedFrequency(int invertedFrequency) {
        this.invertedFrequency = invertedFrequency;
    }

    public ArrayList<Integer> getPositionOfTerm() {
        return positionOfTerm;
    }

    public void setPositionOfTerm(ArrayList<Integer> positionOfTerm) {
        this.positionOfTerm = positionOfTerm;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public double getSizeOfDocument() {
        return sizeOfDocument;
    }

    public void setSizeOfDocument(double sizeOfDocument) {
        this.sizeOfDocument = sizeOfDocument;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Posting posting = (Posting) object;
            if (this.documentName.equals(posting.getDocumentName())) {
                result = true;
            }
        }
        return result;

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + this.documentName.hashCode();
        return hash;

    }

    public String toString() {
        return this.documentName; //To change body of generated methods, choose Tools | Templates.
    }

   

}
