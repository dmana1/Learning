/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.person;

import java.util.ArrayList;

/**
 *
 * @author Deepthi
 */
public class PersonDirectory {

    private ArrayList<Person> personsList;

    public PersonDirectory() {
        personsList = new ArrayList<Person>();
    }

    public ArrayList<Person> getPersonsList() {
        return personsList;
    }

    public void setPersonsList(ArrayList<Person> personsList) {
        this.personsList = personsList;
    }

    public Person addPerson() {
        Person p = new Person();
        personsList.add(p);
        return p;
    }

    public void removePerson(Person person) {
        personsList.remove(person);
    }

    public Person searchPerson(String ssn) {
        for (Person p : personsList) {
            if (ssn.equalsIgnoreCase(p.getSsn())) {
                return p;
            }
        }
        return null;
    }
    
     public Person searchByFirstAndLastName(String firstName, String lastName) {
        for (Person p : personsList) {
            if (firstName.equalsIgnoreCase(p.getFirstName()) && lastName.equalsIgnoreCase(lastName)) {
                return p;
            }
        }
        return null;
    }
}
