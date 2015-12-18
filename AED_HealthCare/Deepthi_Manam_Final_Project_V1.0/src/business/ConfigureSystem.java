/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.enterprise.Enterprise;
import business.enterprise.Enterprise.EnterpriseType;
import business.network.Network;
import business.organization.Organization;
import business.organization.Organization.Type;
import business.person.Person;
import business.role.AdminRole;
import business.role.DoctorRole;
import business.role.SystemAdminRole;
import business.useraccount.UserAccount;

/**
 *
 * @author Deepthi
 */
public class ConfigureSystem {
      public static HealthCareSystem configure(){
          
          HealthCareSystem system = HealthCareSystem.getInstance();
        
       //create a network
        Network network = system.addNetwork("MA");
        //Create enterprise in this network
//        Enterprise enterprise = network.getEnterpriseDir().addEnterprise("MAHospital", EnterpriseType.Hospital);
//        //Create an organization 
//        Organization organization = enterprise.getOrganizationDirectory().createOrganization(Type.DoctorOrganization);
//        //create the employee
        Person person = system.getPersonDirectory().addPerson();
        person.setFirstName("Deepthi");
        person.setLastName("Manam");
       
        person.setSsn("G2561252");
        
        //create useraccount for systemadmin
        UserAccount sysAdmin = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", person, new SystemAdminRole());
        
        //create enterprise admin
//        UserAccount enterpriseAdmin = enterprise.getUserAccountDirectory().createUserAccount("admin", "admin", person, new AdminRole());
//       
//        //create doctor user account
//        UserAccount doctor = organization.getUserAccountDirectory().createUserAccount("doc", "doc", person, new DoctorRole());
        return system;
          
      }
}
