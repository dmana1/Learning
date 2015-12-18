/*
 * Organization is like a department{Exampple: HRDepartment in an Organization}
 */
package business.organization;

import business.person.PersonDirectory;
import business.role.Role;
import business.useraccount.UserAccount;
import business.useraccount.UserAccountDirectory;
import business.workqueue.WorkQueue;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Deepthi
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private PersonDirectory personDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private Type type;

    public enum Type {

        //patient manager belongs to PatientManagement 
        LabOrganization("Lab Organization"), DoctorOrganization("Doctor Organization"),
        PatientManagement("Patient Management"), InventoryManagement("Inventory Management"),
        DrugManagement("Drug Management");
        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        personDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = new Random().nextInt(100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    //Abstract method for the roles supported by the department 
    public abstract ArrayList<Role> getSupportedRole();

    //authenticate the user in that department
    public UserAccount authenticateUser(String username, String password) {
        return this.userAccountDirectory.authenticateUser(username, password);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

}
