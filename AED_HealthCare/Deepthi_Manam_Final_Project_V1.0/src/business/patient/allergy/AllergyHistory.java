/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.patient.allergy;

import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class AllergyHistory {

    private ArrayList<Allergy> allergyList;

    public AllergyHistory() {
        allergyList = new ArrayList<Allergy>();
    }

    public ArrayList<Allergy> getAllergyList() {
        return allergyList;
    }

    public Allergy addAllergy() {
        Allergy allergy = new Allergy();
        allergyList.add(allergy);
        return allergy;
    }

}
