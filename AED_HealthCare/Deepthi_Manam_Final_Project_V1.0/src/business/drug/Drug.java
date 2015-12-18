/*
 * Drug is product manufactured by Drug companies and which are approved by FDA
 */
package business.drug;

import business.enterprise.Enterprise;
import business.patient.adverseevents.AdverseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Deepthi
 */
public class Drug {

    private String drugName;
    private String drugModelNo;
    private String ingredients;
    private Date expiryDate;
    private String treatmentArea;
    private String warnings;
    private String usageDirections;
    private Enterprise drugCompany;
    private ArrayList<String> adverseEffectsList;
    private boolean isRemApproved;

    private int availability = 100;

    public Drug() {
        //  manufacturedDate = new Date();
        drugModelNo = "DG" + new Random().nextInt(200);;
        adverseEffectsList = new ArrayList<String>();
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Enterprise getDrugCompany() {
        return drugCompany;
    }

    public void setDrugCompany(Enterprise drugCompany) {
        this.drugCompany = drugCompany;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isIsRemApproved() {
        return isRemApproved;
    }

    public void setIsRemApproved(boolean isRemApproved) {
        this.isRemApproved = isRemApproved;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getTreatmentArea() {
        return treatmentArea;
    }

    public void setTreatmentArea(String treatmentArea) {
        this.treatmentArea = treatmentArea;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public String getUsageDirections() {
        return usageDirections;
    }

    public void setUsageDirections(String usageDirections) {
        this.usageDirections = usageDirections;
    }

    public String getDrugModelNo() {
        return drugModelNo;
    }

    public void setDrugModelNo(String drugModelNo) {
        this.drugModelNo = drugModelNo;
    }

    public ArrayList<String> getAdverseEffectsList() {
        return adverseEffectsList;
    }

    public void setAdverseEffectsList(ArrayList<String> adverseEffectsList) {
        this.adverseEffectsList = adverseEffectsList;
    }

   

    @Override
    public String toString() {
        return drugName;
    }

}
