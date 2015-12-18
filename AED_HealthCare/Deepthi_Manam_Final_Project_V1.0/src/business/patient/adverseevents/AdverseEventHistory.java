/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.patient.adverseevents;

import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class AdverseEventHistory {

    private ArrayList<AdverseEvent> adverseEventList;

    public AdverseEventHistory() {
        adverseEventList = new ArrayList<AdverseEvent>();
    }

    public ArrayList<AdverseEvent> getAdverseEventList() {
        return adverseEventList;
    }

    public AdverseEvent addAdverseEvent() {
        AdverseEvent ae = new AdverseEvent();
        adverseEventList.add(ae);
        return ae;
    }
}
