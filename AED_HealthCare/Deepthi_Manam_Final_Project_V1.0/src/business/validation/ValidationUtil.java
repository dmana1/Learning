/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Deepthi
 */
public class ValidationUtil {

    public static boolean isValidPhoneNumber(String phoneNumberString) {
        boolean isValid = true;
        long phoneNumber = 0;
        try {
            phoneNumber = Long.parseLong(phoneNumberString);
        } catch (NumberFormatException e) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidEmailId(String emailId) {
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        boolean isValid = emailId.matches(EMAIL_REGEX);

        return isValid;

    }

    public static boolean isValidDate(String dateOfBirthString) {

        boolean isValid = true;
        if (!(dateOfBirthString.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"))) {
            return false;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date dateOfBirth = null;
        try {
            dateOfBirth = dateFormat.parse(dateOfBirthString);
        } catch (ParseException e) {
            isValid = false;
        }
        return isValid;
    }

    public static Date parseDate(String dateOfBirthString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date dateOfBirth = null;
        try {
            dateOfBirth = dateFormat.parse(dateOfBirthString);
        } catch (ParseException e) {

        }
        return dateOfBirth;
    }

    public static long parsePhoneNumber(String phoneNumberString) {
        long phoneNumber = 0;
        try {
            phoneNumber = Long.parseLong(phoneNumberString);
        } catch (NumberFormatException e) {
        }
        return phoneNumber;
    }

    //Used in View
    public static String formatDate(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String dateString = df.format(date);
        return dateString;
    }
    public static String formatDateTime(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String dateString = df.format(date);
        return dateString;
    }
    
    public static String generateUniqueCode(String firstName, String lastName, String ssn, Date dob){
        String uniqueCode;
        //format and get the mm dd yyyy of the patient
        String dobString = ValidationUtil.formatDate(dob);
        String[] dobArray = dobString.split("/");
        uniqueCode = firstName + lastName + ssn + dobArray[0] + dobArray[1] + dobArray[2];
        return uniqueCode;
    }
    
    public static String generateUniqueCode1(String firstName, String lastName, String ssn, String dobString){
        String uniqueCode;
        //format and get the mm dd yyyy of the patient
        
        String[] dobArray = dobString.split("/");
        uniqueCode = firstName + lastName + ssn + dobArray[0] + dobArray[1] + dobArray[2];
        return uniqueCode;
    }
    
    public static boolean isValidSSN(String ssn){
         String regex =   "\\d{4}";
         return ssn.matches(regex);
    }
    public static boolean isCompleteSSN(String ssn){
         String regex =   "\\d{9}";
         return ssn.matches(regex);
    }
    
    public static void main(String args[]) {
        boolean isValid = isValidDate("11/11/1987");

        System.out.println(isValid);
        System.out.println(String.valueOf(parseDate("11/11/1987")));
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(df.format(parseDate("11/11/1987")));
        
        System.out.print("formatDateTime" + formatDateTime(new Date()));
    }
}
