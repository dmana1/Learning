package com.me.care.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.me.care.model.Vitalsign;

public class VitalsignDao extends DAO {

	public List<Vitalsign> selectVitalSignByMRN(Integer patientId) {

		try {
			// begin();
			Query query = getSession().createQuery(
					"from Vitalsign where patient.patientId = :patientId");
			query.setParameter("patientId", patientId);
			List<Vitalsign> vitalsignList = query.list();

			return vitalsignList;

		} catch (HibernateException e) {

			System.out.println(" EXCEPTION" + e.getMessage());
		}
		return null;
	}

	public void insertVitalsign(Vitalsign vitalsign) throws Exception {
		Transaction tx = null;
		try {
			Session session = getSession();
			tx = session.beginTransaction();
			session.save(vitalsign);
			tx.commit();
			session.close();
		} catch (HibernateException e) {

			throw new Exception("Could not get user " + e.getMessage());
		}

	}

}
