/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.HealthCareSystem;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.useraccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Deepthi
 */
public abstract class Role {

    public enum RoleType {

        SystemAdmin("SystemAdmin"),
        Admin("Admin"),
        Doctor("Doctor"),
        Nurse("Nurse"),
        Staff("Staff"),
        Patient("Patient"),
        Pharmacist("Pharmacist"),
        DrugManufacturer("DrugManufacturer"),
        FDAManager("FDAManager");

        private String value;

        private RoleType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }

    }

    public abstract JPanel createWorkArea(JPanel userProcessContainer, HealthCareSystem system, Enterprise enterprise, Organization organization, UserAccount account);

    @Override
    public String toString() {
        return this.getClass().getName();
    }

}
