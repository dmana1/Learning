package com.me.care.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.me.care.model.Patient;
import com.me.care.model.User;

public class PatientDao extends DAO {

	
	public void insertPatient(Patient  patient) throws Exception {
		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.save(patient);
			tx.commit();
			session.close();
		} catch (HibernateException e) {

			throw new Exception("Could not insert patient " + e.getMessage());
		}

	}
	
	
	public List<Patient> selectPatientByPrimaryDoctor(int primaryDoctorId) {

		try {
			// begin();
			Query query = getSession().createQuery(
					"from Patient where primaryDoctorId = :primaryDoctorId ");
			query.setParameter("primaryDoctorId", primaryDoctorId);
			List<Patient> patientList = query.list();

			return patientList;

		} catch (HibernateException e) {

			System.out.println(" EXCEPTION" + e.getMessage());
		}
		return null;
	}
	
	
	public Patient selectPatientById(Integer patientId)
			throws Exception {
		try {
			// begin();
			Query query = getSession()
					.createQuery(
							"from Patient where patientId = :patientId ");
			query.setParameter("patientId", patientId);
			Patient patient = (Patient) query.uniqueResult();
			// commit();
			return patient;
		} catch (HibernateException e) {
			// rollback();
			return null;

		}
	}
	
	public Patient selectPatientBySSN(String ssn)
			throws Exception {
		try {
			// begin();
			Query query = getSession()
					.createQuery(
							"from Patient where ssn = :ssn ");
			query.setParameter("ssn", ssn);
			Patient patient = (Patient) query.uniqueResult();
			// commit();
			return patient;
		} catch (HibernateException e) {
			// rollback();
			return null;

		}
	}
	
	
	public List<Patient> selectUserByMany(String firstName, String lastName,
			 String ssn, String phoneNumber) throws Exception {
		try {

			Session session = getSession();
			Criteria crit = session.createCriteria(Patient.class);
			if (!firstName.isEmpty())
				crit.add(Restrictions.eq("firstName", firstName));
			if (!lastName.isEmpty())
				crit.add(Restrictions.eq("lastName", lastName));
			if (!ssn.isEmpty())
				crit.add(Restrictions.eq("ssn", ssn));
			if (!phoneNumber.isEmpty())
				crit.add(Restrictions.eq("phoneNumber", phoneNumber));
			
			List results = crit.list();

			return results;
		} catch (HibernateException e) {

			throw new Exception("Could not get patient " + e.getMessage());
		}

	}


	

}
