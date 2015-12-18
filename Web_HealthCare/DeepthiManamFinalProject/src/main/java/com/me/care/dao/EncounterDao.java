package com.me.care.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.me.care.model.Encounter;

public class EncounterDao extends DAO {

	public List<Encounter> selectEncounterByMRN(Integer patientId) {

		try {
			// begin();
			Query query = getSession().createQuery(
					"from Encounter  where patient.patientId = :patientId");
			query.setParameter("patientId", patientId);
			List<Encounter> encounterList = query.list();

			return encounterList;

		} catch (HibernateException e) {

			System.out.println(" EXCEPTION" + e.getMessage());
		}
		return null;
	}
	
	public void insertEncounter(Encounter encounter) throws Exception {
		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.save(encounter);
			tx.commit();
			session.close();
		} catch (HibernateException e) {

			throw new Exception("Could not insert encounter " + e.getMessage());
		}

	}

	

}
