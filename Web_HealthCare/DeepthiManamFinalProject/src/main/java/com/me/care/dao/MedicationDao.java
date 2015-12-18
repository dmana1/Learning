package com.me.care.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.me.care.model.Medication;
import com.me.care.model.Vitalsign;

public class MedicationDao extends DAO {

	public List<Medication> selectMedicationByMRN(Integer patientId) {

		try {
			// begin();
			Query query = getSession().createQuery(
					"from Medication where patient.patientId = :patientId");
			query.setParameter("patientId", patientId);
			List<Medication> medicationList = query.list();

			return medicationList;

		} catch (HibernateException e) {

			System.out.println(" EXCEPTION" + e.getMessage());
		}
		return null;
	}
	
	public List<Medication> selectMedicationByWorkRequestId(Integer requestId) {

		try {
			// begin();
			Query query = getSession().createQuery(
					"from Medication where requestId = :requestId");
			query.setParameter("requestId", requestId);
			List<Medication> medicationList = query.list();

			return medicationList;

		} catch (HibernateException e) {

			System.out.println(" EXCEPTION" + e.getMessage());
		}
		return null;
	}

	public void insertMedication(Medication medication) throws Exception {
		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.save(medication);
			tx.commit();
			session.close();
		} catch (HibernateException e) {

			throw new Exception( e.getMessage());
		}

	}
	
	
	

}
