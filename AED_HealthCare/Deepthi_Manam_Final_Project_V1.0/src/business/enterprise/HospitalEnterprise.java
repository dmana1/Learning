/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.patient.Patient;
import business.patient.PatientDirectory;
import business.role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Deepthi
 */
public class HospitalEnterprise extends Enterprise {

    private PatientDirectory patientDirectory;
    private List<Patient> registeredPatients;

    public HospitalEnterprise(String name) {
        super(name, EnterpriseType.Hospital);
        patientDirectory = new PatientDirectory();
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
