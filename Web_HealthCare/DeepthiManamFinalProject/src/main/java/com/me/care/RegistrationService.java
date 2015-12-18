package com.me.care;

import java.security.Security;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.me.care.dao.PatientDao;
import com.me.care.dao.UserDao;
import com.me.care.exception.InvalidRegistrationException;
import com.me.care.mail.Email;
import com.me.care.model.Patient;
import com.me.care.model.Registration;
import com.me.care.model.Role;
import com.me.care.model.User;


public class RegistrationService {
	private static final Logger logger = LoggerFactory
			.getLogger(RegistrationService.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private PatientDao patientDao;

	public RegistrationService(UserDao userDao, PatientDao patientDao) {
		this.userDao = userDao;
		this.patientDao = patientDao;
	}

	public String register(Registration registration)
			throws InvalidRegistrationException {
		
		String mrnString = registration.getMrn();
		String userName = registration.getUserName();
		String password = registration.getPassword();
		
		//do validation of userName and password
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{4,10}$");
	    Matcher matcher1 = pattern.matcher(userName);
	    Matcher matcher2 = pattern.matcher(password);

	    if(!matcher1.matches()) {
	    	throw new InvalidRegistrationException();
	    }
	    if(!matcher2.matches()) {
	    	throw new InvalidRegistrationException();
	    }
	    
	    
		
		

		Patient patient = null;
		User user = null;

		try {

			patient = patientDao.selectPatientById(Integer.parseInt(mrnString));

			user = userDao.queryUserByUserName(userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new InvalidRegistrationException();
		}
		
		

		if (patient != null && user == null) {
			return "validPatient";
		}  else {
			throw new InvalidRegistrationException();
		}
		

	}
	
	public String createPatient(Registration registration)
			throws InvalidRegistrationException{
				
		 String userName = registration.getUserName();
		 String password = registration.getPassword();
		 String userIdString = registration.getMrn();
		 
		 Integer  userId = Integer.parseInt(userIdString);
		 
		 Role role = new Role();
		 role.setRoleId(5);
		 
		 User user = new User();
		 user.setUserName(userName);
		 user.setPassword(password);
		 user.setRole(role);
		 user.setUserId(userId);
		 
		 try {
			userDao.insertUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Patient patient = null;
		try {
			patient = patientDao.selectPatientById(userId);
			String mailTo = patient.getEmailId();
			String subject="HealthCare Registration";
			String message="Successfully registered to HealthCare.";
		    Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

            new Email().sendSSLMessage(mailTo, subject, message, mailTo);
			
		}  catch (javax.mail.MessagingException ex) {
	    	  System.out.println(ex.getMessage());
	    }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return "success";
			
		}

}
