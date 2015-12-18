/*
 * Person contains the general attributes of the person.
 */
package business.person;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author Deepthi
 */
public class Person {

    private int id;
    private String ssn;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private long phoneNumber;
    private String address;
    private String emailId;

    public Person() {
        id = new Random().nextInt(100);
        
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    

    @Override
    public String toString() {
        return String.valueOf(id);
    }

}
