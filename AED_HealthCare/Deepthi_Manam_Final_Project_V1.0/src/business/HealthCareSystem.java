/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.enterprise.DrugCompanyEnterprise;
import business.enterprise.Enterprise;
import business.enterprise.HospitalEnterprise;
import business.enterprise.PharmacyEnterprise;
import business.network.Network;
import business.organization.Organization;
import business.patient.experience.PatientExperience;
import business.role.Role;
import business.role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class HealthCareSystem extends Organization {

    private static HealthCareSystem system;
    private ArrayList<Network> networkList;
    private ArrayList<PatientExperience> patientExperienceList;
    private String news = "";
   
    

    public HealthCareSystem() {
        super(null);
        networkList = new ArrayList<Network>();
        patientExperienceList = new ArrayList<PatientExperience>();
    }

    public static HealthCareSystem getInstance() {
        if (system == null) {
            system = new HealthCareSystem();
        }
        return system;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public static HealthCareSystem getSystem() {
        return system;
    }

    public static void setSystem(HealthCareSystem system) {
        HealthCareSystem.system = system;
    }

    public ArrayList<PatientExperience> getPatientExperienceList() {
        return patientExperienceList;
    }

    public void setPatientExperienceList(ArrayList<PatientExperience> patientExperienceList) {
        this.patientExperienceList = patientExperienceList;
    }

    public static int getWorkRequestId() {
        return workRequestId;
    }

    public static void setWorkRequestId(int workRequestId) {
        HealthCareSystem.workRequestId = workRequestId;
    }

    public static int getAppointmentId() {
        return appointmentId;
    }

    public static void setAppointmentId(int appointmentId) {
        HealthCareSystem.appointmentId = appointmentId;
    }

    public static String getUniqueCode() {
        return uniqueCode;
    }

    public static void setUniqueCode(String uniqueCode) {
        HealthCareSystem.uniqueCode = uniqueCode;
    }

   
    public static String uniqueCode;
    public static int workRequestId;
    public static int appointmentId;

    @Override
    public ArrayList<Role> getSupportedRole() {
        SystemAdminRole role = new SystemAdminRole();
        ArrayList<Role> roleList = new ArrayList<Role>();
        roleList.add(role);
        return roleList;
    }

    //add a network
    public Network addNetwork(String name) {
        Network network = new Network();
        network.setName(name);
        networkList.add(network);
        return network;
    }

    //list of all DrugCompanyEnterprise 

    public ArrayList<DrugCompanyEnterprise> getAllDrugCompanyEnterprisesInNetwork() {
        ArrayList<DrugCompanyEnterprise> drugCompaniesList = new ArrayList<DrugCompanyEnterprise>();
        for (Network network : networkList) {
            for (Enterprise enterprise : network.getEnterpriseDir().getEnterpriseList()) {
                if (enterprise instanceof DrugCompanyEnterprise) {
                    DrugCompanyEnterprise drugCmpny = (DrugCompanyEnterprise) enterprise;
                    drugCompaniesList.add(drugCmpny);

                }
            }
        }
        return drugCompaniesList;
    }

    //list of all pharmacies 

    public ArrayList<PharmacyEnterprise> getAllPharmacies() {
        ArrayList<PharmacyEnterprise> pharmaciesList = new ArrayList<PharmacyEnterprise>();
        for (Network network : networkList) {
            for (Enterprise enterprise : network.getEnterpriseDir().getEnterpriseList()) {
                if (enterprise instanceof PharmacyEnterprise) {
                    PharmacyEnterprise pharmacy = (PharmacyEnterprise) enterprise;
                    pharmaciesList.add(pharmacy);

                }
            }
        }
        return pharmaciesList;
    }

    //list of all hospitals 
    public ArrayList<HospitalEnterprise> getAllHospitals() {
        ArrayList<HospitalEnterprise> hospitalList = new ArrayList<HospitalEnterprise>();
        for (Network network : networkList) {

            for (Enterprise enterprise : network.getEnterpriseDir().getEnterpriseList()) {
                if (enterprise instanceof HospitalEnterprise) {
                    HospitalEnterprise hospital = (HospitalEnterprise) enterprise;
                    hospitalList.add(hospital);

                }
            }
        }
        return hospitalList;
    }

}
