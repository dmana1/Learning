/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.useraccount;

import business.person.Person;
import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class UserAccountDirectory {

    private ArrayList<UserAccount> userAccountList;
    
    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }
    
    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUserName().equalsIgnoreCase(username) && ua.getPassword().equalsIgnoreCase(password)) {
                return ua;
            }
        }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Person person, Role role) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(username);
        userAccount.setPassword(password);
        userAccount.setPerson(person);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
}
